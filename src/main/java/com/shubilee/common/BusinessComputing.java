/**
 * Yamibuy 核心计算类
 * ============================================================================
 * * 版权所有 Yamibuy，并保留所有权利。
 * 网站地址: http://www.yamibuy.com；
 * ----------------------------------------------------------------------------
 * $Author: james $
 * $Id: DbHelper.java 2015-04-29 
*/
package com.shubilee.common;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shubilee.bean.ComputerGoodResult;
import com.shubilee.bean.ComputerResult;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityGift;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.BonusVendor;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.Shipping;
import com.shubilee.entity.TaxLookup;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.Vendors;








public class BusinessComputing {
	
	
	/*
	 计算折扣总金额
	 @param bonusType		
	 @param lstCart
	 @return Map<String,Object>	 
	*/
	public static ComputerResult  countPromoPriceV1(BonusType bonusType,List<Cart> lstCartIn,List<Vendors> lstVendor) throws Exception{
		ComputerResult result = new ComputerResult();
		List<ComputerGoodResult> lstComputerGoodResult  = new ArrayList<ComputerGoodResult>();
		ComputerGoodResult computerGoodResult = new ComputerGoodResult();
		//对传入的购物车信息进行处理，去除未参加活动的第三方商品
		List<Cart> lstCart = new ArrayList<Cart>();
		for(Cart cart:lstCartIn){
			if(cart.getVendor_id().intValue()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
				lstCart.add(cart);
			}else{
				if(null!=lstVendor){
				for(Vendors vendors:lstVendor){
					if(null!= vendors.getVendorId()){
					 if(cart.getVendor_id().intValue() == vendors.getVendorId().intValue()){
						lstCart.add(cart);
					 }
					}
					}
				}	
			}
		}
		BigDecimal promoPrice = new BigDecimal(0.00);
        if(null!=bonusType){
		
		BigDecimal subtotal = accountOrder(lstCart);
		List<BonusLookup> lstBonusLookup = bonusType.getLstBonusLookup();
		//是否可以使用折扣码标识
		Boolean valid = true;
		//最小订单额度，必须大于该额度才能使用订单
		if(bonusType.getMinGoodsAmount().compareTo(new BigDecimal(0.00))>0&&
				subtotal.compareTo(bonusType.getMinGoodsAmount())>=0 ||	bonusType.getMinGoodsAmount().compareTo(new BigDecimal(0.00))==0){
			
			
				//1为按时间
				if(bonusType.getType().equals("1")){
					if(DateUtil.getNowLong()<bonusType.getUseStartDate()||DateUtil.getNowLong()>bonusType.getUseEndDate()){
						valid = false;
					}
				}
				//3为按次数
				if(bonusType.getType().equals("3")){
					if(Integer.parseInt(bonusType.getUserBonus().getBonusCount())<1||DateUtil.getNowLong()<bonusType.getUseStartDate()||DateUtil.getNowLong()>bonusType.getUseEndDate()){
						valid = false;
					}
				}
				
				if(valid){
					//总价折扣
					if(bonusType.getScope()==1){
						//百分比折扣
						if(bonusType.getIsPercentOff()==1){
							//折扣金额=总价*（1-百分比/10)
							promoPrice = subtotal.multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))));
							for(Cart cartTemp:lstCart){
								computerGoodResult = new ComputerGoodResult();
								computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
								computerGoodResult.setGoods_id(cartTemp.getGoods_id());
								lstComputerGoodResult.add(computerGoodResult);
							}
						}
						//满就减折扣
						if(bonusType.getIsOffOnAmount()==1){
							BigDecimal bonus = new BigDecimal(0.00);
							//必须大于折扣最低额度
							if(subtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
								//大于折扣减免金额
								if(subtotal.compareTo(bonusType.getReduceAmount())>0){
									bonus = bonusType.getReduceAmount();
									promoPrice = bonus;
								}
								//小于折扣减免金额
								else{
									bonus = subtotal;
									promoPrice = bonus;
								}
							}
							//满就减，按折扣金额计算折扣百分比
							BigDecimal rate = new BigDecimal(1.00);
							if(promoPrice.compareTo(new BigDecimal(0.00))>0&&subtotal.compareTo(new BigDecimal(0.00))>0){
								rate = new BigDecimal(1.00).subtract(promoPrice.divide(subtotal,3));
							}
							
							for(Cart cartTemp:lstCart){
								computerGoodResult = new ComputerGoodResult();
								computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
								computerGoodResult.setGoods_id(cartTemp.getGoods_id());
								lstComputerGoodResult.add(computerGoodResult);
							}
						}
					}
					//单品折扣
					
					if(bonusType.getScope()==2){
						//计算参加活动的商品的合计金额，为满就减方式折扣准备
						BigDecimal goodsSubtotal =  new BigDecimal(0.00);
						for(Cart cartTemp:lstCart){
							for(BonusLookup bonusLookupTemp:lstBonusLookup){
								if(cartTemp.getGoods_id().intValue()==bonusLookupTemp.getGoodsId().intValue()){
									BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
									goodsSubtotal = goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
									}
							}
						}
						//参加活动商品ID串，逗号分隔
						String bounsGoodsIds = "";
						for(BonusLookup bonusLookupTemp:lstBonusLookup){
							bounsGoodsIds = bounsGoodsIds+","+bonusLookupTemp.getGoodsId().toString();
						}
						bounsGoodsIds = bounsGoodsIds.substring(1, bounsGoodsIds.length());
						
						
						for(Cart cartTemp:lstCart){
							BigDecimal bonus = new BigDecimal(0.00);
								if(belong_to_bonus_good(cartTemp.getGoods_id(),bounsGoodsIds)){
									//百分比折扣
									if(bonusType.getIsPercentOff()==1){
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
										//折扣金额=总价*（1-百分比/10)
										BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
										bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
										promoPrice = promoPrice.add(bonus);
									}
									//满就减折扣
									if(bonusType.getIsOffOnAmount()==1){
										//满就减，按折扣金额计算折扣百分比
										BigDecimal rate = new BigDecimal(1.00);
										//达到最低额度才享受减免
										if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
											if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
												bonus = bonusType.getReduceAmount();
												promoPrice = bonus;
												if(promoPrice.compareTo(new BigDecimal(0.00))>0&&subtotal.compareTo(new BigDecimal(0.00))>0){
													rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
												}
											}
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
											
										}
										else{
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
									}
								}
								else{
									computerGoodResult = new ComputerGoodResult();
									computerGoodResult.setDeal_price(cartTemp.getGoods_price());
									computerGoodResult.setGoods_id(cartTemp.getGoods_id());
									lstComputerGoodResult.add(computerGoodResult);
								}
							
							
						}
					}
					//类折扣
					if(bonusType.getScope()==3){
						BigDecimal goodsSubtotal = new BigDecimal(0.00);
					for(Cart cartTemp:lstCart){
							for(BonusLookup bonusLookupTemp:lstBonusLookup){
								//判断购物车商品是否属于折扣分类
								if(belong_to_cat(cartTemp.getSubTree(),bonusLookupTemp.getCatId())){
									//满就减折扣
									if(bonusType.getIsOffOnAmount()==1){
										BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
										goodsSubtotal =  goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
								}
							}
						}	
					}
					
					//参加活动分类ID串，逗号分隔
					String bounsCatIds = "";
					for(BonusLookup bonusLookupTemp:lstBonusLookup){
						bounsCatIds = bounsCatIds+","+bonusLookupTemp.getCatId().toString();
					}
					bounsCatIds = bounsCatIds.substring(1, bounsCatIds.length());
					
					
					for(Cart cartTemp:lstCart){
						BigDecimal bonus = new BigDecimal(0.00);
						
							//判断购物车商品是否属于折扣分类
							if(belong_to_cat(cartTemp.getSubTree(),bounsCatIds)){
								//百分比折扣
								if(bonusType.getIsPercentOff()==1){
									//折扣金额=总价*（1-百分比/10)
									BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
									bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
									promoPrice = promoPrice.add(bonus);
									computerGoodResult = new ComputerGoodResult();
									computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
									computerGoodResult.setGoods_id(cartTemp.getGoods_id());
									lstComputerGoodResult.add(computerGoodResult);
								}
								//满就减折扣
								if(bonusType.getIsOffOnAmount()==1){
									//满就减，按折扣金额计算折扣百分比
									BigDecimal rate = new BigDecimal(1.00);
									//达到最低额度才享受减免
									if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
										if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
											bonus = bonusType.getReduceAmount();
											promoPrice = bonus;
											if(promoPrice.compareTo(new BigDecimal(0.00))>0&&subtotal.compareTo(new BigDecimal(0.00))>0){
												rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
											}
										}
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
									else{
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
								}
							}
							else{
								computerGoodResult = new ComputerGoodResult();
								computerGoodResult.setDeal_price(cartTemp.getGoods_price());
								computerGoodResult.setGoods_id(cartTemp.getGoods_id());
								lstComputerGoodResult.add(computerGoodResult);
							}
						
						
					}
					
					}
					
					//品牌折扣
					if(bonusType.getScope()==4){
						
						BigDecimal goodsSubtotal = new BigDecimal(0.00);
						
						for(Cart cartTemp:lstCart){
							for(BonusLookup bonusLookupTemp:lstBonusLookup){
								//判断购物车商品是否属于折扣分类
								if(cartTemp.getBrand_id().intValue()==bonusLookupTemp.getBrandId().intValue()){
								
									//满就减折扣
									if(bonusType.getIsOffOnAmount()==1){
										BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
										goodsSubtotal =  goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
									
									}
								}
							
							}

						}
						//参加活动分类ID串，逗号分隔
						String bounsBrandIds = "";
						for(BonusLookup bonusLookupTemp:lstBonusLookup){
							bounsBrandIds = bounsBrandIds+","+bonusLookupTemp.getBrandId().toString();
						}
						bounsBrandIds = bounsBrandIds.substring(1, bounsBrandIds.length());
						
						
						
						for(Cart cartTemp:lstCart){
							BigDecimal bonus = new BigDecimal(0.00);
								//判断购物车商品是否属于折扣分类
								if(belong_to_brand(cartTemp.getBrand_id(),bounsBrandIds)){
									//百分比折扣
									if(bonusType.getIsPercentOff()==1){
										//折扣金额=总价*（1-百分比/10)
										BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
										bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
										promoPrice = promoPrice.add(bonus);
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
									//满就减折扣
									if(bonusType.getIsOffOnAmount()==1){
										//满就减，按折扣金额计算折扣百分比
										BigDecimal rate = new BigDecimal(1.00);
										//达到最低额度才享受减免
										if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
											if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
												bonus = bonusType.getReduceAmount();
												promoPrice = bonus;
												if(promoPrice.compareTo(new BigDecimal(0.00))>0&&goodsSubtotal.compareTo(new BigDecimal(0.00))>0){
													rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
												}
											}
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
										else{
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
									}
								}
								else{
									computerGoodResult = new ComputerGoodResult();
									computerGoodResult.setDeal_price(cartTemp.getGoods_price());
									computerGoodResult.setGoods_id(cartTemp.getGoods_id());
									lstComputerGoodResult.add(computerGoodResult);
								}
							
						}
					}
				}
				 else{
			        	for(Cart cartTemp:lstCart){
			        		computerGoodResult = new ComputerGoodResult();
							computerGoodResult.setDeal_price(cartTemp.getGoods_price());
							computerGoodResult.setGoods_id(cartTemp.getGoods_id());
							lstComputerGoodResult.add(computerGoodResult);
			        	}
			        }
		}
        }
        else{
        	for(Cart cartTemp:lstCart){
        		computerGoodResult = new ComputerGoodResult();
				computerGoodResult.setDeal_price(cartTemp.getGoods_price());
				computerGoodResult.setGoods_id(cartTemp.getGoods_id());
				lstComputerGoodResult.add(computerGoodResult);
        	}
        }
		result.setComputerPrice(promoPrice);
		result.setComputerGoodResult(lstComputerGoodResult);
		return result;
		
	}
	/*
	 计算折扣总金额(无法计算满就减)
	 @param bonusType		
	 @param lstCart
	 @return Map<String,Object>	 
	*/
	public static ComputerResult  countPromoPriceByVendorV1(BonusType bonusType,List<Cart> lstCartIn,Vendors vendor) throws Exception{
		ComputerResult result = new ComputerResult();
		List<ComputerGoodResult> lstComputerGoodResult  = new ArrayList<ComputerGoodResult>();
		ComputerGoodResult computerGoodResult = new ComputerGoodResult();
		//对传入的购物车信息进行处理，去除未参加活动的第三方商品
		List<Cart> lstCartSubtotal = new ArrayList<Cart>();
		List<Cart> lstCartVendorSubtotal = new ArrayList<Cart>();
		//转化参加活动的第三方集合，便于后续计算
		Map<String,Object> mapBonusVendors = new HashMap<String,Object>();
		for(BonusVendor bonusVendor:bonusType.getLstBonusVendor()){
			if(null!=bonusVendor.getVendorId()){
				mapBonusVendors.put(bonusVendor.getVendorId().toString(), bonusVendor);
			}
		}
		//统计购物车中参加活动的第三方商品集合、参加活动的所有商品计划
		for(Cart cart:lstCartIn){
			if(cart.getVendor_id().intValue()==vendor.getVendorId().intValue()){
				lstCartVendorSubtotal.add(cart);
			}
			if(mapBonusVendors.containsKey(cart.getVendor_id().toString())||cart.getVendor_id().toString().equals(YamiConstant.VENDOR_ID_YAMIBUY)){
				lstCartSubtotal.add(cart);
			}
		}
		
		
		
		
		BigDecimal promoPrice = new BigDecimal(0.00);
       if(null!=bonusType){
		//总单商品合计金额
		BigDecimal subtotal = accountOrder(lstCartSubtotal);
		//第三方商品合计金额
		BigDecimal vendorsubtotal = accountOrder(lstCartVendorSubtotal);
		List<BonusLookup> lstBonusLookup = bonusType.getLstBonusLookup();
		//是否可以使用折扣码标识
		Boolean valid = true;
		//最小订单额度，必须大于该额度才能使用订单
		//最小订单额度，必须大于该额度才能使用订单
		if(bonusType.getMinGoodsAmount().compareTo(new BigDecimal(0.00))>0
				&&subtotal.compareTo(bonusType.getMinGoodsAmount())>=0 
				||bonusType.getMinGoodsAmount().compareTo(new BigDecimal(0.00))==0){
				//1为按时间
				if(bonusType.getType().equals("1")){
					if(DateUtil.getNowLong()<bonusType.getUseStartDate()||DateUtil.getNowLong()>bonusType.getUseEndDate()){
						valid = false;
					}
				}
				//3为按次数
				if(bonusType.getType().equals("3")){
					if(Integer.parseInt(bonusType.getUserBonus().getBonusCount())<1||DateUtil.getNowLong()<bonusType.getUseStartDate()||DateUtil.getNowLong()>bonusType.getUseEndDate()){
						valid = false;
					}
				}
				//当前供货商是否参加活动
				if(!vendor.getVendorId().toString().equals(YamiConstant.VENDOR_ID_YAMIBUY)){
					if(!mapBonusVendors.containsKey(vendor.getVendorId().toString())){
						valid = false;
					}
					
				}
				if(valid){
							//总价折扣
							if(bonusType.getScope()==1){
								//百分比折扣
								if(bonusType.getIsPercentOff()==1){
									//折扣金额=总价*（1-百分比/10)
									promoPrice = vendorsubtotal.multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))));
									for(Cart cartTemp:lstCartVendorSubtotal){
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
								}
								//满就减折扣
								if(bonusType.getIsOffOnAmount()==1){
									BigDecimal bonus = new BigDecimal(0.00);
									//必须大于折扣最低额度
									if(subtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
										//大于折扣减免金额
										if(subtotal.compareTo(bonusType.getReduceAmount())>0){
											bonus = bonusType.getReduceAmount();
											promoPrice = bonus;
										}
										//小于折扣减免金额
										else{
											bonus = subtotal;
											promoPrice = bonus;
										}
									}
									//满就减，按折扣金额计算折扣百分比
									BigDecimal rate = new BigDecimal(1.00);
									if(promoPrice.compareTo(new BigDecimal(0.00))>0&&subtotal.compareTo(new BigDecimal(0.00))>0){
										rate = new BigDecimal(1.00).subtract(promoPrice.divide(subtotal,3));
									}
									
									for(Cart cartTemp:lstCartVendorSubtotal){
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
								}
							}
							//单品折扣
							
							if(bonusType.getScope()==2){
								//计算参加活动的商品的合计金额，为满就减方式折扣准备
								BigDecimal goodsSubtotal =  new BigDecimal(0.00);
								for(Cart cartTemp:lstCartVendorSubtotal){
									for(BonusLookup bonusLookupTemp:lstBonusLookup){
										if(cartTemp.getGoods_id().intValue()==bonusLookupTemp.getGoodsId().intValue()){
											BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
											goodsSubtotal = goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
											}
									}
								}
								//参加活动商品ID串，逗号分隔
								String bounsGoodsIds = "";
								for(BonusLookup bonusLookupTemp:lstBonusLookup){
									bounsGoodsIds = bounsGoodsIds+","+bonusLookupTemp.getGoodsId().toString();
								}
								bounsGoodsIds = bounsGoodsIds.substring(1, bounsGoodsIds.length());
								
								
								for(Cart cartTemp:lstCartVendorSubtotal){
									BigDecimal bonus = new BigDecimal(0.00);
										if(belong_to_bonus_good(cartTemp.getGoods_id(),bounsGoodsIds)){
											//百分比折扣
											if(bonusType.getIsPercentOff()==1){
												computerGoodResult = new ComputerGoodResult();
												computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
												computerGoodResult.setGoods_id(cartTemp.getGoods_id());
												lstComputerGoodResult.add(computerGoodResult);
												//折扣金额=总价*（1-百分比/10)
												BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
												bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
												promoPrice = promoPrice.add(bonus);
											}
											//满就减折扣
											if(bonusType.getIsOffOnAmount()==1){
												//满就减，按折扣金额计算折扣百分比
												BigDecimal rate = new BigDecimal(1.00);
												//达到最低额度才享受减免
												if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
													if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
														bonus = bonusType.getReduceAmount();
														promoPrice = bonus;
														if(promoPrice.compareTo(new BigDecimal(0.00))>0&&subtotal.compareTo(new BigDecimal(0.00))>0){
															rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
														}
													}
													computerGoodResult = new ComputerGoodResult();
													computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
													computerGoodResult.setGoods_id(cartTemp.getGoods_id());
													lstComputerGoodResult.add(computerGoodResult);
													
												}
												else{
													computerGoodResult = new ComputerGoodResult();
													computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
													computerGoodResult.setGoods_id(cartTemp.getGoods_id());
													lstComputerGoodResult.add(computerGoodResult);
												}
											}
										}
										else{
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price());
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
									
									
								}
							}
							//类折扣
							if(bonusType.getScope()==3){
								BigDecimal goodsSubtotal = new BigDecimal(0.00);
							for(Cart cartTemp:lstCartVendorSubtotal){
									for(BonusLookup bonusLookupTemp:lstBonusLookup){
										//判断购物车商品是否属于折扣分类
										if(belong_to_cat(cartTemp.getSubTree(),bonusLookupTemp.getCatId())){
											//满就减折扣
											if(bonusType.getIsOffOnAmount()==1){
												BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
												goodsSubtotal =  goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
										}
									}
								}	
							}
							
							//参加活动分类ID串，逗号分隔
							String bounsCatIds = "";
							for(BonusLookup bonusLookupTemp:lstBonusLookup){
								bounsCatIds = bounsCatIds+","+bonusLookupTemp.getCatId().toString();
							}
							bounsCatIds = bounsCatIds.substring(1, bounsCatIds.length());
							
							
							for(Cart cartTemp:lstCartVendorSubtotal){
								BigDecimal bonus = new BigDecimal(0.00);
								
									//判断购物车商品是否属于折扣分类
									if(belong_to_cat(cartTemp.getSubTree(),bounsCatIds)){
										//百分比折扣
										if(bonusType.getIsPercentOff()==1){
											//折扣金额=总价*（1-百分比/10)
											BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
											bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
											promoPrice = promoPrice.add(bonus);
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
										//满就减折扣
										if(bonusType.getIsOffOnAmount()==1){
											//满就减，按折扣金额计算折扣百分比
											BigDecimal rate = new BigDecimal(1.00);
											//达到最低额度才享受减免
											if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
												if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
													bonus = bonusType.getReduceAmount();
													promoPrice = bonus;
													if(promoPrice.compareTo(new BigDecimal(0.00))>0&&subtotal.compareTo(new BigDecimal(0.00))>0){
														rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
													}
												}
												computerGoodResult = new ComputerGoodResult();
												computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
												computerGoodResult.setGoods_id(cartTemp.getGoods_id());
												lstComputerGoodResult.add(computerGoodResult);
											}
											else{
												computerGoodResult = new ComputerGoodResult();
												computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
												computerGoodResult.setGoods_id(cartTemp.getGoods_id());
												lstComputerGoodResult.add(computerGoodResult);
											}
										}
									}
									else{
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price());
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
								
								
							}
							
							}
							
							//品牌折扣
							if(bonusType.getScope()==4){
								
								BigDecimal goodsSubtotal = new BigDecimal(0.00);
								
								for(Cart cartTemp:lstCartVendorSubtotal){
									for(BonusLookup bonusLookupTemp:lstBonusLookup){
										//判断购物车商品是否属于折扣分类
										if(cartTemp.getBrand_id().intValue()==bonusLookupTemp.getBrandId().intValue()){
										
											//满就减折扣
											if(bonusType.getIsOffOnAmount()==1){
												BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
												goodsSubtotal =  goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
											
											}
										}
									
									}

								}
								//参加活动分类ID串，逗号分隔
								String bounsBrandIds = "";
								for(BonusLookup bonusLookupTemp:lstBonusLookup){
									bounsBrandIds = bounsBrandIds+","+bonusLookupTemp.getBrandId().toString();
								}
								bounsBrandIds = bounsBrandIds.substring(1, bounsBrandIds.length());
								
								
								
								for(Cart cartTemp:lstCartVendorSubtotal){
									BigDecimal bonus = new BigDecimal(0.00);
										//判断购物车商品是否属于折扣分类
										if(belong_to_brand(cartTemp.getBrand_id(),bounsBrandIds)){
											//百分比折扣
											if(bonusType.getIsPercentOff()==1){
												//折扣金额=总价*（1-百分比/10)
												BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
												bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
												promoPrice = promoPrice.add(bonus);
												computerGoodResult = new ComputerGoodResult();
												computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
												computerGoodResult.setGoods_id(cartTemp.getGoods_id());
												lstComputerGoodResult.add(computerGoodResult);
											}
											//满就减折扣
											if(bonusType.getIsOffOnAmount()==1){
												//满就减，按折扣金额计算折扣百分比
												BigDecimal rate = new BigDecimal(1.00);
												//达到最低额度才享受减免
												if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
													if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
														bonus = bonusType.getReduceAmount();
														promoPrice = bonus;
														if(promoPrice.compareTo(new BigDecimal(0.00))>0&&goodsSubtotal.compareTo(new BigDecimal(0.00))>0){
															rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
														}
													}
													computerGoodResult = new ComputerGoodResult();
													computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
													computerGoodResult.setGoods_id(cartTemp.getGoods_id());
													lstComputerGoodResult.add(computerGoodResult);
												}
												else{
													computerGoodResult = new ComputerGoodResult();
													computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
													computerGoodResult.setGoods_id(cartTemp.getGoods_id());
													lstComputerGoodResult.add(computerGoodResult);
												}
											}
										}
										else{
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price());
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
									
								}
							}
						}
				else{
			       	for(Cart cartTemp:lstCartVendorSubtotal){
			       		computerGoodResult = new ComputerGoodResult();
							computerGoodResult.setDeal_price(cartTemp.getGoods_price());
							computerGoodResult.setGoods_id(cartTemp.getGoods_id());
							lstComputerGoodResult.add(computerGoodResult);
			       	}
			       }
				}
		       }
		       else{
		       	for(Cart cartTemp:lstCartVendorSubtotal){
		       		computerGoodResult = new ComputerGoodResult();
						computerGoodResult.setDeal_price(cartTemp.getGoods_price());
						computerGoodResult.setGoods_id(cartTemp.getGoods_id());
						lstComputerGoodResult.add(computerGoodResult);
		       	}
		       }
		result.setComputerPrice(promoPrice);
		result.setComputerGoodResult(lstComputerGoodResult);
		return result;
		
	}
	/*
	 计算折扣总金额V2支持第三方参加活动
	 @param bonusType		
	 @param lstCart 全部商品
	 @param lstVendor  第三方集合
	 @return Map<String,Object>	 
	*/
	public static ComputerResult  countPromoPrice(BonusType bonusType,List<Cart> lstCartIn,List<Vendors> lstVendor) throws Exception{
		ComputerResult result = new ComputerResult();
		ComputerResult vendorComputerResult= new ComputerResult();
		
		if(null==bonusType||null==lstVendor||lstVendor.size()==0){
			List<ComputerGoodResult> lstComputerGoodResult = new ArrayList<ComputerGoodResult>();
			for(Cart cart:lstCartIn){
				ComputerGoodResult computerGoodResult = new ComputerGoodResult();
				computerGoodResult.setGoods_id(cart.getGoods_id());
				computerGoodResult.setDeal_price(cart.getGoods_price());
				lstComputerGoodResult.add(computerGoodResult);
			}
			result.setComputerGoodResult(lstComputerGoodResult);
			result.setComputerPrice(new BigDecimal(0.0));	
		}
		else{
			for(Vendors vendors:lstVendor){
				vendorComputerResult = countPromoPriceByVendor(bonusType,lstCartIn,vendors);
				if(null==result.getComputerPrice()){
					result.setComputerPrice(new BigDecimal(0.0));
					result.setComputerPrice(result.getComputerPrice().add(vendorComputerResult.getComputerPrice()));
				}else{
					result.setComputerPrice(result.getComputerPrice().add(vendorComputerResult.getComputerPrice()));
				}
				List<ComputerGoodResult> lstComputerGoodResult = result.getComputerGoodResult();
				for(ComputerGoodResult computerGoodResult:vendorComputerResult.getComputerGoodResult()){
					if(null==lstComputerGoodResult){
						lstComputerGoodResult = new ArrayList<ComputerGoodResult>();
						lstComputerGoodResult.add(computerGoodResult);
					}
					else{
						lstComputerGoodResult.add(computerGoodResult);
					}
				}
				result.setComputerGoodResult(lstComputerGoodResult);	
			}
		}
		return result;
		
	}
	/*
	 计算指定第三方折扣总金额
	 @param bonusType		
	 @param lstCart  全部商品
	 @param vendor  指定计算的第三方
	 @return Map<String,Object>	 
	*/
	public static ComputerResult  countPromoPriceByVendor(BonusType bonusType,List<Cart> lstCartIn,Vendors vendor) throws Exception{
		ComputerResult result = new ComputerResult();
		List<ComputerGoodResult> lstComputerGoodResult  = new ArrayList<ComputerGoodResult>();
		ComputerGoodResult computerGoodResult = new ComputerGoodResult();
		//对传入的购物车信息进行处理，去除未参加活动的第三方商品
		List<Cart> lstCartSubtotal = new ArrayList<Cart>();
		List<Cart> lstCartVendorSubtotal = new ArrayList<Cart>();
		//转化参加活动的第三方集合，便于后续计算
		Map<String,Object> mapBonusVendors = new HashMap<String,Object>();
		
		//统计购物车中参加活动的第三方商品集合、参加活动的所有商品计划
		for(Cart cart:lstCartIn){
			if(cart.getVendor_id().intValue()==vendor.getVendorId().intValue()){
				lstCartVendorSubtotal.add(cart);
			}
		}
		BigDecimal promoPrice = new BigDecimal(0.00);
       if(null!=bonusType){
    	for(BonusVendor bonusVendor:bonusType.getLstBonusVendor()){
   			if(null!=bonusVendor.getVendorId()){
   				mapBonusVendors.put(bonusVendor.getVendorId().toString(), bonusVendor);
   			}
   		}  
		//第三方参加活动商品合计金额
		BigDecimal vendorsubtotal = accountOrderByVendor(bonusType,lstCartIn,vendor);
		List<BonusLookup> lstBonusLookup = bonusType.getLstBonusLookup();
		//是否可以使用折扣码标识
		Boolean valid = true;
		//最小订单额度，必须大于该额度才能使用订单
		if(bonusType.getMinGoodsAmount().compareTo(new BigDecimal(0.00))>0
				&&vendorsubtotal.compareTo(bonusType.getMinGoodsAmount())>=0 
				||bonusType.getMinGoodsAmount().compareTo(new BigDecimal(0.00))==0){
				//1为按时间
				if(bonusType.getType().equals("1")){
					if(DateUtil.getNowLong()<bonusType.getUseStartDate()||DateUtil.getNowLong()>bonusType.getUseEndDate()){
						valid = false;
					}
				}
				//3为按次数
				if(bonusType.getType().equals("3")){
					if(Integer.parseInt(bonusType.getUserBonus().getBonusCount())<1||DateUtil.getNowLong()<bonusType.getUseStartDate()||DateUtil.getNowLong()>bonusType.getUseEndDate()){
						valid = false;
					}
				}
				//当前供货商是否参加活动
				if(!mapBonusVendors.containsKey(vendor.getVendorId().toString())){
					valid = false;
				}
				if(valid){
							//总价折扣
							if(bonusType.getScope()==1){
								//百分比折扣
								if(bonusType.getIsPercentOff()==1){
									//折扣金额=总价*（1-百分比/10)
									promoPrice = vendorsubtotal.multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))));
									for(Cart cartTemp:lstCartVendorSubtotal){
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
								}
								//满就减折扣
								if(bonusType.getIsOffOnAmount()==1){
									BigDecimal bonus = new BigDecimal(0.00);
									//必须大于折扣最低额度
									if(vendorsubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
										//大于折扣减免金额
										if(vendorsubtotal.compareTo(bonusType.getReduceAmount())>0){
											bonus = bonusType.getReduceAmount();
											promoPrice = bonus;
										}
										//小于折扣减免金额
										else{
											bonus = vendorsubtotal;
											promoPrice = bonus;
										}
									}
									//满就减，按折扣金额计算折扣百分比
									BigDecimal rate = new BigDecimal(1.00);
									if(promoPrice.compareTo(new BigDecimal(0.00))>0&&vendorsubtotal.compareTo(new BigDecimal(0.00))>0){
										rate = new BigDecimal(1.00).subtract(promoPrice.divide(vendorsubtotal,3));
									}
									
									for(Cart cartTemp:lstCartVendorSubtotal){
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
								}
							}
							//单品折扣
							
							if(bonusType.getScope()==2){
								//计算参加活动的商品的合计金额，为满就减方式折扣准备
								BigDecimal goodsSubtotal =  new BigDecimal(0.00);
								for(Cart cartTemp:lstCartVendorSubtotal){
									for(BonusLookup bonusLookupTemp:lstBonusLookup){
										if(cartTemp.getGoods_id().intValue()==bonusLookupTemp.getGoodsId().intValue()){
											BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
											goodsSubtotal = goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
											}
									}
								}
								//参加活动商品ID串，逗号分隔
								String bounsGoodsIds = "";
								for(BonusLookup bonusLookupTemp:lstBonusLookup){
									bounsGoodsIds = bounsGoodsIds+","+bonusLookupTemp.getGoodsId().toString();
								}
								bounsGoodsIds = bounsGoodsIds.substring(1, bounsGoodsIds.length());
								
								
								for(Cart cartTemp:lstCartVendorSubtotal){
									BigDecimal bonus = new BigDecimal(0.00);
										if(belong_to_bonus_good(cartTemp.getGoods_id(),bounsGoodsIds)){
											//百分比折扣
											if(bonusType.getIsPercentOff()==1){
												computerGoodResult = new ComputerGoodResult();
												computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
												computerGoodResult.setGoods_id(cartTemp.getGoods_id());
												lstComputerGoodResult.add(computerGoodResult);
												//折扣金额=总价*（1-百分比/10)
												BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
												bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
												promoPrice = promoPrice.add(bonus);
											}
											//满就减折扣
											if(bonusType.getIsOffOnAmount()==1){
												//满就减，按折扣金额计算折扣百分比
												BigDecimal rate = new BigDecimal(1.00);
												//达到最低额度才享受减免
												if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
													if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
														bonus = bonusType.getReduceAmount();
														promoPrice = bonus;
														if(promoPrice.compareTo(new BigDecimal(0.00))>0&&vendorsubtotal.compareTo(new BigDecimal(0.00))>0){
															rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
														}
													}
													computerGoodResult = new ComputerGoodResult();
													computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
													computerGoodResult.setGoods_id(cartTemp.getGoods_id());
													lstComputerGoodResult.add(computerGoodResult);
													
												}
												else{
													computerGoodResult = new ComputerGoodResult();
													computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
													computerGoodResult.setGoods_id(cartTemp.getGoods_id());
													lstComputerGoodResult.add(computerGoodResult);
												}
											}
										}
										else{
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price());
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
									
									
								}
							}
							//类折扣
							if(bonusType.getScope()==3){
								BigDecimal goodsSubtotal = new BigDecimal(0.00);
							for(Cart cartTemp:lstCartVendorSubtotal){
									for(BonusLookup bonusLookupTemp:lstBonusLookup){
										//判断购物车商品是否属于折扣分类
										if(belong_to_cat(cartTemp.getSubTree(),bonusLookupTemp.getCatId())){
											//满就减折扣
											if(bonusType.getIsOffOnAmount()==1){
												BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
												goodsSubtotal =  goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
										}
									}
								}	
							}
							
							//参加活动分类ID串，逗号分隔
							String bounsCatIds = "";
							for(BonusLookup bonusLookupTemp:lstBonusLookup){
								bounsCatIds = bounsCatIds+","+bonusLookupTemp.getCatId().toString();
							}
							bounsCatIds = bounsCatIds.substring(1, bounsCatIds.length());
							
							
							for(Cart cartTemp:lstCartVendorSubtotal){
								BigDecimal bonus = new BigDecimal(0.00);
								
									//判断购物车商品是否属于折扣分类
									if(belong_to_cat(cartTemp.getSubTree(),bounsCatIds)){
										//百分比折扣
										if(bonusType.getIsPercentOff()==1){
											//折扣金额=总价*（1-百分比/10)
											BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
											bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
											promoPrice = promoPrice.add(bonus);
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
										//满就减折扣
										if(bonusType.getIsOffOnAmount()==1){
											//满就减，按折扣金额计算折扣百分比
											BigDecimal rate = new BigDecimal(1.00);
											//达到最低额度才享受减免
											if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
												if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
													bonus = bonusType.getReduceAmount();
													promoPrice = bonus;
													if(promoPrice.compareTo(new BigDecimal(0.00))>0&&vendorsubtotal.compareTo(new BigDecimal(0.00))>0){
														rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
													}
												}
												computerGoodResult = new ComputerGoodResult();
												computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
												computerGoodResult.setGoods_id(cartTemp.getGoods_id());
												lstComputerGoodResult.add(computerGoodResult);
											}
											else{
												computerGoodResult = new ComputerGoodResult();
												computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
												computerGoodResult.setGoods_id(cartTemp.getGoods_id());
												lstComputerGoodResult.add(computerGoodResult);
											}
										}
									}
									else{
										computerGoodResult = new ComputerGoodResult();
										computerGoodResult.setDeal_price(cartTemp.getGoods_price());
										computerGoodResult.setGoods_id(cartTemp.getGoods_id());
										lstComputerGoodResult.add(computerGoodResult);
									}
								
								
							}
							
							}
							
							//品牌折扣
							if(bonusType.getScope()==4){
								
								BigDecimal goodsSubtotal = new BigDecimal(0.00);
								
								for(Cart cartTemp:lstCartVendorSubtotal){
									for(BonusLookup bonusLookupTemp:lstBonusLookup){
										//判断购物车商品是否属于折扣分类
										if(cartTemp.getBrand_id().intValue()==bonusLookupTemp.getBrandId().intValue()){
										
											//满就减折扣
											if(bonusType.getIsOffOnAmount()==1){
												BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
												goodsSubtotal =  goodsSubtotal.add(goodsNum.multiply(cartTemp.getGoods_price()));
											
											}
										}
									
									}

								}
								//参加活动分类ID串，逗号分隔
								String bounsBrandIds = "";
								for(BonusLookup bonusLookupTemp:lstBonusLookup){
									bounsBrandIds = bounsBrandIds+","+bonusLookupTemp.getBrandId().toString();
								}
								bounsBrandIds = bounsBrandIds.substring(1, bounsBrandIds.length());
								
								
								
								for(Cart cartTemp:lstCartVendorSubtotal){
									BigDecimal bonus = new BigDecimal(0.00);
										//判断购物车商品是否属于折扣分类
										if(belong_to_brand(cartTemp.getBrand_id(),bounsBrandIds)){
											//百分比折扣
											if(bonusType.getIsPercentOff()==1){
												//折扣金额=总价*（1-百分比/10)
												BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
												bonus =  goodsNum.multiply(cartTemp.getGoods_price().multiply(new BigDecimal(1.00).subtract(bonusType.getTypeMoney().divide(new BigDecimal(10.0))))).setScale(2,BigDecimal.ROUND_HALF_UP);
												promoPrice = promoPrice.add(bonus);
												computerGoodResult = new ComputerGoodResult();
												computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(bonusType.getTypeMoney().divide(new BigDecimal(10.0))).setScale(2,BigDecimal.ROUND_HALF_UP));
												computerGoodResult.setGoods_id(cartTemp.getGoods_id());
												lstComputerGoodResult.add(computerGoodResult);
											}
											//满就减折扣
											if(bonusType.getIsOffOnAmount()==1){
												//满就减，按折扣金额计算折扣百分比
												BigDecimal rate = new BigDecimal(1.00);
												//达到最低额度才享受减免
												if(goodsSubtotal.compareTo(bonusType.getMinGoodsAmount())>=0){
													if(goodsSubtotal.compareTo(bonusType.getReduceAmount())>0){
														bonus = bonusType.getReduceAmount();
														promoPrice = bonus;
														if(promoPrice.compareTo(new BigDecimal(0.00))>0&&goodsSubtotal.compareTo(new BigDecimal(0.00))>0){
															rate = new BigDecimal(1.00).subtract(promoPrice.divide(goodsSubtotal,3));
														}
													}
													computerGoodResult = new ComputerGoodResult();
													computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
													computerGoodResult.setGoods_id(cartTemp.getGoods_id());
													lstComputerGoodResult.add(computerGoodResult);
												}
												else{
													computerGoodResult = new ComputerGoodResult();
													computerGoodResult.setDeal_price(cartTemp.getGoods_price().multiply(rate).setScale(2,BigDecimal.ROUND_HALF_UP));
													computerGoodResult.setGoods_id(cartTemp.getGoods_id());
													lstComputerGoodResult.add(computerGoodResult);
												}
											}
										}
										else{
											computerGoodResult = new ComputerGoodResult();
											computerGoodResult.setDeal_price(cartTemp.getGoods_price());
											computerGoodResult.setGoods_id(cartTemp.getGoods_id());
											lstComputerGoodResult.add(computerGoodResult);
										}
									
								}
							}
						}
				else{
			       	for(Cart cartTemp:lstCartVendorSubtotal){
			       		computerGoodResult = new ComputerGoodResult();
							computerGoodResult.setDeal_price(cartTemp.getGoods_price());
							computerGoodResult.setGoods_id(cartTemp.getGoods_id());
							lstComputerGoodResult.add(computerGoodResult);
			       	}
			       }
				}
		       }
		       else{
		       	for(Cart cartTemp:lstCartVendorSubtotal){
		       		computerGoodResult = new ComputerGoodResult();
						computerGoodResult.setDeal_price(cartTemp.getGoods_price());
						computerGoodResult.setGoods_id(cartTemp.getGoods_id());
						lstComputerGoodResult.add(computerGoodResult);
		       	}
		       }
		result.setComputerPrice(promoPrice);
		result.setComputerGoodResult(lstComputerGoodResult);
		return result;
		
	}

	/*
	 计算购物车商品金额合计
	 @param List<Cart>		
	 
	 @return BigDecimal	 
	*/
	public static BigDecimal  accountOrder(List<Cart> lstCart){
		BigDecimal result = new BigDecimal(0.00);
		for(Cart cart :lstCart){
			if(cart.getIs_gift()==0){
				BigDecimal goodsNum = new BigDecimal(new BigInteger(cart.getGoods_number().toString()));
				BigDecimal subtotal = cart.getGoods_price().multiply(goodsNum);
				result =result.add(subtotal);
			}
		}
		return result;
	}
	/*
	 计算指定供货商的购物车商品金额合计
	 @param List<Cart>		
	 
	 @return BigDecimal	 
	*/
	public static BigDecimal  accountOrderByVendorId(List<Cart> lstCart,int vendor_id){
		BigDecimal result = new BigDecimal(0.00);
		for(Cart cart :lstCart){
			if(cart.getIs_gift()==0&&cart.getVendor_id()==vendor_id){
				BigDecimal goodsNum = new BigDecimal(new BigInteger(cart.getGoods_number().toString()));
				BigDecimal subtotal = cart.getGoods_price().multiply(goodsNum);
				result =result.add(subtotal);
			}
		}
		return result;
	}
	/*
	 计算指定供货商参加活动的商品金额合计
	 @param List<Cart>		
	 
	 @return BigDecimal	 
	*/
	public static BigDecimal  accountOrderByVendor(BonusType bonusType,List<Cart> lstCart,Vendors vendors){
		BigDecimal result = new BigDecimal(0.00);
		List<BonusLookup> lstBonusLookup = bonusType.getLstBonusLookup();
		for(Cart cart:lstCart){
			BigDecimal goodsNum = new BigDecimal(new BigInteger(cart.getGoods_number().toString()));
			if(cart.getVendor_id().intValue()==vendors.getVendorId().intValue()){
				
				//全场折扣
				if(bonusType.getScope()==1){
						result = result.add(cart.getGoods_price().multiply(goodsNum));
				}
				//单品折扣
				else if(bonusType.getScope()==2){
					for(BonusLookup bonusLookup:lstBonusLookup){
						if(cart.getGoods_id().intValue()==bonusLookup.getGoodsId().intValue()){
								result = result.add(cart.getGoods_price().multiply(goodsNum));
						}
					}
				}
				//分类折扣
				else if(bonusType.getScope()==3){
					for(BonusLookup bonusLookup:lstBonusLookup){
						if(belong_to_cat(cart.getSubTree(),bonusLookup.getCatId())){
								result = result.add(cart.getGoods_price().multiply(goodsNum));
						}
					}
				}
				//品牌折扣
				else if(bonusType.getScope()==4){
					for(BonusLookup bonusLookup:lstBonusLookup){
						if(cart.getBrand_id().intValue()==bonusLookup.getBrandId()){
								result = result.add(cart.getGoods_price().multiply(goodsNum));
						}
					}
				}
				
				
			}
		}
		return result;
	}
	/*
	 判断购物车商品是否属于指定分类
	 @param subTree		指定商品的归属分类树
	 @param cat_id	         分类ID
	 
	 @return Boolean	 
	*/
	public static Boolean belong_to_cat(String subTree,int cat_id){
		Boolean result = false;
		String[] cat_id_Array = subTree.split(",");
		   for(int i=0;i<cat_id_Array.length;i++){
			   if(cat_id_Array[i].equals(String.valueOf(cat_id))){
				   result= true;   
			   }
		   }

		return result;
		
	}
	/*
	 判断购物车商品是否属于指定分类
	 @param subTree		指定商品的归属分类树
	 @param cat_id	         分类ID
	 
	 @return Boolean	 
	*/
	public static Boolean belong_to_cat(String subTree,String cat_ids){
		Boolean result = false;
		String[] cat_id_Array = subTree.split(",");
		String[] bouns_cat_id_Array = cat_ids.split(",");
		   for(int i=0;i<cat_id_Array.length;i++){
			   for(int j=0;j<bouns_cat_id_Array.length;j++){
				   if(cat_id_Array[i].equals(String.valueOf(bouns_cat_id_Array[j]))){
					   result= true;   
				   }
			   }
		   }

		return result;
		
	}
	/*
	 判断购物车商品是否属于指定分类
	 @param subTree		指定商品的归属分类树
	 @param cat_id	         分类ID
	 
	 @return Boolean	 
	*/
	public static Boolean belong_to_brand(int brand_id,String brand_ids){
		Boolean result = false;
		String[] bouns_brand_id_Array = brand_ids.split(",");
			   for(int i=0;i<bouns_brand_id_Array.length;i++){
				   if(bouns_brand_id_Array[i].equals(String.valueOf(brand_id))){
					   result= true;   
				   }
			   }

		return result;
		
	}
	
	/*
	 判断购物车商品是否属于指定分类
	 @param subTree		指定商品的归属分类树
	 @param cat_id	         分类ID
	 
	 @return Boolean	 
	*/
	public static Boolean belong_to_bonus_good(int goods_id,String goods_ids){
		Boolean result = false;
		String[] bouns_goods_id_Array = goods_ids.split(",");
			   for(int i=0;i<bouns_goods_id_Array.length;i++){
				   if(bouns_goods_id_Array[i].equals(String.valueOf(goods_id))){
					   result= true;   
				   }
			   }

		return result;
		
	}
	/*
	判断商品是否减免运费
	 @param token		
	 @return List<Shipping> 
	*/
	public static Boolean  getVendorShipping(BigDecimal vendorSubtotal,Map<Integer,Shipping> mapShippingTemp,int shipping_id){
		Boolean result = false;
		Shipping shipping = mapShippingTemp.get(shipping_id);
		if(vendorSubtotal.compareTo(shipping.getFreeShippingAmount())>=0&&shipping.getFreeShippingAmount().compareTo(new BigDecimal(0.00))>0){
			result = true;
		}
		
		if(shipping.getShippingFee().compareTo(new BigDecimal(0.00))==0){
			result = true;
		}
		return result;
	}
	/*
	 计算商品税额
	 @param token		
	 @param lstCart
	 @return BigDecimal 
	*/
	public static ComputerResult  countTax(int uid,List<Cart> lstCart,UserAddress address,TaxLookup taxLookup,List<ComputerGoodResult>  lstComputerGoodResultIn){
		ComputerResult result = new ComputerResult();
		BigDecimal tax = new BigDecimal(0.00);
		List<ComputerGoodResult> lstComputerGoodResult  = new ArrayList<ComputerGoodResult>();
		ComputerGoodResult computerGoodResult = new ComputerGoodResult();
		BigDecimal rateTemp = new BigDecimal(0.075);
		BigDecimal taxTemp = new BigDecimal(0.0);
		BigDecimal deal_price = new BigDecimal(0.0);
		Map<Integer,ComputerGoodResult> mapComputerGoodResultIn = new HashMap<Integer,ComputerGoodResult>();
		if(null!=lstComputerGoodResultIn){
			for(ComputerGoodResult computerGoodResultTemp:lstComputerGoodResultIn){
				mapComputerGoodResultIn.put(computerGoodResultTemp.getGoods_id(), computerGoodResultTemp);
			}
		}
		
		if(null!=address){
			//
			if(null!=taxLookup){
				rateTemp = new BigDecimal(taxLookup.getTax()).multiply(new BigDecimal(0.01));
			}else{
				if(address.getProvince().equals("California")){
					rateTemp = new BigDecimal(YamiConstant.CA_TAX_RENT).multiply(new BigDecimal(0.01));	
				}else{
					rateTemp = new BigDecimal(0.0);
				}
			}
			for(Cart cartTemp:lstCart){	
				 computerGoodResult = new ComputerGoodResult();
				BigDecimal goodsNum = new BigDecimal(new BigInteger(cartTemp.getGoods_number().toString()));
				if(!belong_to_cat(cartTemp.getSubTree(),1)){
					if(!mapComputerGoodResultIn.containsKey(cartTemp.getGoods_id())){
						taxTemp = cartTemp.getGoods_price().multiply(goodsNum).multiply(rateTemp);
						deal_price = cartTemp.getGoods_price();
					}else{
						taxTemp = mapComputerGoodResultIn.get(cartTemp.getGoods_id()).getDeal_price().multiply(goodsNum).multiply(rateTemp);
						deal_price = mapComputerGoodResultIn.get(cartTemp.getGoods_id()).getDeal_price();
					}
				}else{
					if(!mapComputerGoodResultIn.containsKey(cartTemp.getGoods_id())){
						deal_price = cartTemp.getGoods_price();
					}else{
						deal_price = mapComputerGoodResultIn.get(cartTemp.getGoods_id()).getDeal_price();
					}
					taxTemp = new BigDecimal(0.0);	
				}
				computerGoodResult.setTax(taxTemp.setScale(2,BigDecimal.ROUND_HALF_UP));
				computerGoodResult.setDeal_price(deal_price);
				computerGoodResult.setGoods_id(cartTemp.getGoods_id());
				lstComputerGoodResult.add(computerGoodResult);
				tax = tax.add(taxTemp.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
		}
		result.setComputerPrice(tax);
		result.setComputerGoodResult(lstComputerGoodResult);
		return result;
	}
	
	/*
	 验证折扣码
	 @param bonusType		
	 @param lstCart
	 @return Map<String,Object>	 
	*/
	public static Boolean  checkPromoCode(BonusType bonusType) throws Exception{
		Boolean result = true;
		if(null==bonusType){
			result = false;
		}else{
			//1为按时间
			if(bonusType.getType().equals("1")){
				if(DateUtil.getNowLong()>bonusType.getUseStartDate()&&DateUtil.getNowLong()<bonusType.getUseEndDate()){
					result = true;
				}
			}
			//3为按次数
			if(bonusType.getType().equals("3")){
				if(Integer.parseInt(bonusType.getUserBonus().getBonusCount())<1||DateUtil.getNowLong()<bonusType.getUseStartDate()||DateUtil.getNowLong()>bonusType.getUseEndDate()){
					result = false;
				}
			}
		}
		
		
		return result;
	}
	
	/*
	 构造以第三方供货商分类的购物车数据结构
	 @param bonusType		
	 @param lstCart
	 @return Map<String,Object>	 
	*/
	public static Map<String,List<Cart>> formateCartInfo(List<Cart> lstCart){
		Map<String,List<Cart>> result = new HashMap<String,List<Cart>>();
		List<Cart> lstCartTemp;
		for(Cart cart:lstCart){
			lstCartTemp = new ArrayList<Cart>();
			if(result.containsKey(cart.getVendor_id().toString())){
				lstCartTemp = result.get(cart.getVendor_id().toString());
				lstCartTemp.add(cart);
				result.put(cart.getVendor_id().toString(), lstCartTemp);
			}else{
				lstCartTemp.add(cart);
				result.put(cart.getVendor_id().toString(), lstCartTemp);
			}
		}
		return result;
	}
	
	 /*
	   对计算后的礼品列表，做出相应数据库操作，并返回完整购物车信息
	  @param List<Activity> 礼品列表
	  @param List<Cart> 购物车
	  @return List<Map<String,Object>> 可以获得的赠品信息
	 */
	  public static List<Map<String,Object>> calculate_giftsV2(List<Activity>  lstActivity,List<Cart> listCart) {
		  int round = 0;
		  List<ActivityGift> lstActivityGift = new ArrayList<ActivityGift>();
		  List<Map<String,Object>> lstMapTemp = new ArrayList<Map<String,Object>>();
		  Map<String,Object> mapTemp;
		  for(Activity activity:lstActivity){
			  //可获得赠品次数
			  int activity_gift = qualify_activity_orderV2(listCart,activity);
			  //可选择礼品
			  if(activity.getGift_mode()>0){
				  for(round=1;round<=activity_gift;round++){
					  if(activity_gift>=1){
						  lstActivityGift= activity.getLstActivityGift();
					    for(ActivityGift activityGift:lstActivityGift){
					    	mapTemp = new HashMap<String,Object>();
					    	mapTemp.put("activityGift", activityGift);
					    	mapTemp.put("overlap_num", String.valueOf(activity_gift));
					    	mapTemp.put("gift_number",String.valueOf(activityGift.getGoodsNumber()*activity_gift));
					    	lstMapTemp.add(mapTemp);
					    }
					  } 
				  }
				  round++;
			  }
			  //不可选择礼品
			  else{
				  if(activity_gift>=1){
					  lstActivityGift= activity.getLstActivityGift();
					  for(ActivityGift activityGift:lstActivityGift){
					    	mapTemp = new HashMap<String,Object>();
					    	mapTemp.put("activityGift", activityGift);
					    	mapTemp.put("overlap_num", String.valueOf(activity_gift));
					    	mapTemp.put("gift_number",String.valueOf(activityGift.getGoodsNumber()*activity_gift));
					    	lstMapTemp.add(mapTemp);
					    }
			  } 	  
		  } 
		  }
		  return lstMapTemp;
	  }
	  
	  /* 检查可获得礼品次数
		 * @param activity 活动信息 
		 * @param lstCart 购物车信息
		 * @return int
		 */
		public static int qualify_activity_orderV2(List<Cart> lstCart, Activity activity){
			int result = 0;
			int tempNumber = 0;
			BigDecimal tempPrice = new BigDecimal(0);
			switch(activity.getAct_type()){
			//全场
			case 0:
				//按个数
				if(activity.getCal_type()==1){
					 for(int i=0;i<lstCart.size();i++){
					     if(lstCart.get(i).getIs_gift()==0){
					    	 tempNumber+=lstCart.get(i).getGoods_number();
					     }
					 }
					 result = gift_overlapV2(tempNumber,activity.getNum(),activity.getOverlap());
				}
				//按金额
				else{
					for(int i=0;i<lstCart.size();i++){
						BigDecimal goodsNum = new BigDecimal(new BigInteger(lstCart.get(i).getGoods_number().toString()));
						tempPrice = tempPrice.add(lstCart.get(i).getGoods_price().multiply(goodsNum));
					}
					result = gift_overlapV2(tempPrice,activity.getLine(),activity.getOverlap());
				}
				
			break;
			//分类:该出逻辑判断需再检查	   
			case 1:
				for(int i=0;i<lstCart.size();i++){
					for(int j=0;j<activity.getLstActivityLookup().size();j++){
						//判断当前购物车商品不是赠品并且属于活动赠品范围
						if(lstCart.get(i).getIs_gift()==0 && BusinessComputing.belong_to_cat(lstCart.get(i).getSubTree(),activity.getLstActivityLookup().get(j).getCat_id())){
							tempNumber+=lstCart.get(i).getGoods_number();
							BigDecimal goodsNum = new BigDecimal(new BigInteger(lstCart.get(i).getGoods_number().toString()));
							tempPrice = tempPrice.add(lstCart.get(i).getGoods_price().multiply(goodsNum));
							}
						}
					}
				//按个数
				if(activity.getCal_type()==1){
					result = gift_overlapV2(tempNumber,activity.getNum(),activity.getOverlap());
				}
				//按金额
				else{
					result = gift_overlapV2(tempPrice,activity.getLine(),activity.getOverlap());
				}
			break;
			//品牌：该出逻辑判断需再检查		   
			case 2:
				for(int i=0;i<lstCart.size();i++){
					for(int j=0;j<activity.getLstActivityLookup().size();j++){
						//判断当前购物车商品不是赠品并且属于活动赠品范围
						if(lstCart.get(i).getIs_gift()==0 && lstCart.get(i).getBrand_id().intValue()==activity.getLstActivityLookup().get(j).getBrand_id().intValue()){
							tempNumber+=lstCart.get(i).getGoods_number();
							BigDecimal goodsNum = new BigDecimal(new BigInteger(lstCart.get(i).getGoods_number().toString()));
							tempPrice = tempPrice.add(lstCart.get(i).getGoods_price().multiply(goodsNum));
							}
						}
					}
				//按个数
				if(activity.getCal_type()==1){
					result = gift_overlapV2(tempNumber,activity.getNum(),activity.getOverlap());
				}
				//按金额
				else{
					result = gift_overlapV2(tempPrice,activity.getLine(),activity.getOverlap());
				}
			break;
			//单品	：该出逻辑判断需再检查		   
			case 3:
				
				for(int i=0;i<lstCart.size();i++){
					for(int j=0;j<activity.getLstActivityLookup().size();j++){
						//判断当前购物车商品不是赠品并且属于活动赠品范围
						if(lstCart.get(i).getIs_gift()==0 && lstCart.get(i).getGoods_id().intValue()==activity.getLstActivityLookup().get(j).getGoods_id().intValue()){
							tempNumber+=lstCart.get(i).getGoods_number();
							BigDecimal goodsNum = new BigDecimal(new BigInteger(lstCart.get(i).getGoods_number().toString()));
							tempPrice = tempPrice.add(lstCart.get(i).getGoods_price().multiply(goodsNum));
							}
						}
					}
				//按个数
				if(activity.getCal_type()==1){
					result = gift_overlapV2(tempNumber,activity.getNum(),activity.getOverlap());
				}
				//按金额
				else{
					result = gift_overlapV2(tempPrice,activity.getLine(),activity.getOverlap());
				}
			break;
				   
			default:
			break; 
			}
			return result;
		}
		/*
		 计算礼品叠加后的数量
		 @param goodsNum		物品数值
		 @param actNum			活动最低要求
		 @param overlap	                   是否叠加
		 
		 @return count	返回可获得赠品数量 
		*/
		public static int gift_overlapV2(int goodsNum,int actNum,int overlap){
			int result = 0;
			//可叠加
			if(overlap==1){
				if(goodsNum>=actNum){
					result = goodsNum/actNum;
				}else{
					result = 0;
				}
			}
			//不叠加
			else{
				if(goodsNum>=actNum){
					result = 1;
				}else{
					result = 0;
				}
			}
			return result;
		}
		/*
		 计算礼品叠加后的数量
		 @param goodsCount		物品金额
		 @param actNum			活动最低要求
		 @param overlap	                   是否叠加
		 
		 @return count	返回可获得赠品数量 
		*/
		public static int gift_overlapV2(BigDecimal goodsCount,BigDecimal actLine,int overlap){
			int result = 0;
			//可叠加
			if(overlap==1){
				if(goodsCount.compareTo(actLine)==1||goodsCount.compareTo(actLine)==0){
					result =     Integer.parseInt(goodsCount.divide(actLine,0,BigDecimal.ROUND_HALF_DOWN).toString());
				}else{
					result = 0;
				}
			}
			//不叠加
			else{
				if(goodsCount.compareTo(actLine)==1||goodsCount.compareTo(actLine)==0){
					result = 1;
				}else{
					result = 0;
				}
			}
			return result;
		}
		
		
		
}
