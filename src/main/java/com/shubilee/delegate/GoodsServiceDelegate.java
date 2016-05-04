package com.shubilee.delegate;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shubilee.common.BrandNameSort;
import com.shubilee.common.CategoryTreeNode;
import com.shubilee.common.DateUtil;
import com.shubilee.common.DistrictCheck;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.RedisKeyConstant;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.Brand;
import com.shubilee.entity.BrandAttr;
import com.shubilee.entity.BrandHot;
import com.shubilee.entity.BrandName;
import com.shubilee.entity.CategoryForShow;
import com.shubilee.entity.DiscoveryInfo;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsAggregate;
import com.shubilee.entity.GoodsComment;
import com.shubilee.entity.GoodsDisplayApp;
import com.shubilee.entity.GoodsDisplayDkp;
import com.shubilee.entity.GoodsFlash;
import com.shubilee.entity.GoodsGallery;
import com.shubilee.entity.GoodsHot;
import com.shubilee.entity.GoodsOfCatItems;
import com.shubilee.entity.Keywords;
import com.shubilee.entity.Message4Discovery;
import com.shubilee.entity.SearchBar;
import com.shubilee.entity.Shipping;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.entity.Token;
import com.shubilee.entity.User;
import com.shubilee.entity.Vendors;
import com.shubilee.entity.YmZipcode;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.redis.entity.OrderGenerateRedis;
import com.shubilee.redis.entity.YmZipcodeRedis;
import com.shubilee.service.CollectGoodsService;
import com.shubilee.service.DiscoveryInfoService;
import com.shubilee.service.DiscoveryRedisService;
import com.shubilee.service.GoodsRedisService;
import com.shubilee.service.GoodsService;
import com.shubilee.service.ShippingService;
import com.shubilee.service.UserService;

@Service
public class GoodsServiceDelegate {
	@Autowired 
	private RedisTemplate<String,String> redisTemplate;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsRedisService goodsRedisService;
	@Autowired
	private DiscoveryInfoService discoveryInfoService;
	@Autowired
	private DiscoveryRedisService discoveryRedisService;
	@Autowired
	private ShippingService shippingService;
	@Autowired
	private UserService userService;	
	@Autowired
	private CollectGoodsService collectGoodsService;
	@Autowired
	private TransactionDelegate transactionDelegate;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String,Object> selectGoodsByid(String token, int gid) throws Exception{
		Map<String,Object>  result = new HashMap<String, Object>();
		//从编辑表取得数据
		//result.put("token", token);
		Goods goodsTemp = goodsService.selectByPrimaryKey(gid);
		if(null==goodsTemp||goodsTemp.getIsDelete()){
			throw new YamiException(YamiConstant.ERRORCODE_ER1101,ErrorCodeEnum.ER1101.getMsg());
		}
		BrandName BrandNameTemp = goodsService.selectNameByBrandId(Integer.parseInt(goodsTemp.getBrandId().toString()));
		List<GoodsGallery> goodsGallery = goodsService.selectThumbByGid(gid,YamiConstant.DISPLAY_NUMBER);
        //initial node 
		Map detail = new HashMap();
		Map basic = new HashMap();
		Map info = new HashMap();
		Map limit = new HashMap();
		Map weight = new HashMap();
		Map brand = new HashMap();
		
		//creat brand leaf
		if(null!=BrandNameTemp){
		brand.put("brand_id", BrandNameTemp.getBrand_id());
		brand.put("brand_name", BrandNameTemp.getBrand_name());
		brand.put("brand_ename", BrandNameTemp.getBrand_ename());
		detail.put("Brand", brand);
		}
		//creat weight leaf
		weight.put("goods_weight",goodsTemp.getGoodsWeight());
		weight.put("unit",goodsTemp.getWeightUnit());
		detail.put("Weight", weight);
		
		//creat limit leaf
		limit.put("limit_num",goodsTemp.getLimitedNumber());
		
		if(goodsTemp.getIsLimited()==true)
		{
			limit.put("is_limited",1);
		}
		else
		{
			limit.put("is_limited",0);
		}
		limit.put("limit_qty",goodsTemp.getLimitedQuantity());
		detail.put("Limit", limit);
			
		//detail.put("Limit", limit);
		detail.put("is_favorite", 0);
		//get value of is_favorite from database
		Gson gson = new Gson();
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		if(tokenIn.getIsLogin()==1)
		{
			int is_favorite=0;
			int uid = Integer.valueOf(tokenIn.getData()).intValue();
			try{
				is_favorite=goodsService.selectFavoriteByUidandGid(uid,gid);
			   }catch (Exception e)
			 	{
				   is_favorite=0;
			 	}
			if(is_favorite>0)
			{
				detail.put("is_favorite", 1);
			}
		}
		//creat detail leaf
		detail.put("desc",YamiConstant.IMAGE_URL+YamiConstant.IMAGE_DESC);
		detail.put("edesc",YamiConstant.IMAGE_URL+YamiConstant.IMAGE_EDESC);
		
		if(null!=goodsTemp.getGoodsDesc()){
		detail.put("goodsDesc",goodsTemp.getGoodsDesc().replaceAll("src=\"/images", "src=\""+YamiConstant.IMAGE_URL+"images").replaceAll("http://www.yamibuy.com/", YamiConstant.IMAGE_URL));
		}else{
			detail.put("goodsDesc","");	
		}
		if(null!=goodsTemp.getGoodsEdesc()){
		detail.put("goodsEdesc",goodsTemp.getGoodsEdesc().replaceAll("src=\"/images", "src=\""+YamiConstant.IMAGE_URL+"images").replaceAll("http://www.yamibuy.com/", YamiConstant.IMAGE_URL));
		}else{
			detail.put("goodsEdesc","");	
		}
		Pattern p=Pattern.compile(YamiConstant.REGEX_DESC_URL, Pattern.CASE_INSENSITIVE);
		Matcher m=p.matcher(goodsTemp.getGoodsDesc());
		if(m.find())
		{
			String outString="";
			String temp=m.group();
			temp = temp.substring(temp.indexOf("src"), temp.length());
			int find=0;
			for(int i=0;i<temp.length();i++)
			{
				if(String.valueOf(temp.charAt(i)).equals("\"") && find==0)
				{
					find=1;
					
					if(String.valueOf(temp.charAt(i+1)).equals("h"))
					{
						for(int j=i+24;j<temp.length();j++)
						{
							if(!String.valueOf(temp.charAt(j)).equals("\"")&& find==1)
							{
								outString+= temp.charAt(j);
							}else
							{
								find=2;
							}	
						}		
					}else{
						
						for(int j=i+2;j<temp.length();j++)
						{
							if(!String.valueOf(temp.charAt(j)).equals("\"")&& find==1)
							{
								outString+= temp.charAt(j);
							}else
							{
								find=2;
							}	
						}		
						
					}
	
				}
			}
		    
			detail.put("desc",java.net.URLDecoder.decode(YamiConstant.IMAGE_URL+outString, "UTF-8"));
			detail.put("edesc",java.net.URLDecoder.decode(YamiConstant.IMAGE_URL+outString, "UTF-8"));
		}	
		BrandAttr brandAttr = goodsService.selectBrandAttrByBrandId(BrandNameTemp.getBrand_id());
		if(null!=brandAttr){
		detail.put("origin",brandAttr.getAttrValue());
		detail.put("eorigin",brandAttr.getAttrEvalue());
		}else{
			detail.put("origin","");
			detail.put("eorigin","");	
		}
		//check points value -1:has price. others:no price
		if(goodsTemp.getGiveIntegral() == -1)
		{   
			//check if promote
			if(goodsTemp.getIsPromote() == true)
			{
				 detail.put("points",goodsTemp.getPromotePrice());
			}else{
					detail.put("points",goodsTemp.getShopPrice());
				}
		}else{
				detail.put("points",goodsTemp.getGiveIntegral());
			}
		//check if has stocks
		if(goodsTemp.getGoodsNumber()>0)
		{
			detail.put("in_stock",YamiConstant.HAS_STOCK_YES);	
			detail.put("is_oos",YamiConstant.HAS_STOCK_NO);	
		}else{
				detail.put("in_stock",YamiConstant.HAS_STOCK_NO);
				detail.put("is_oos",YamiConstant.HAS_STOCK_YES);	
			}
		if(goodsTemp.getIsOnSale()||!goodsTemp.getIsDelete())
		{
			 detail.put("is_on_sale",YamiConstant.IS_ON_SALE);	
		}else{
			     detail.put("is_on_sale",YamiConstant.IS_NOT_ON_SALE);		
			 }
		
		//creat basic's leaf
		basic.put("name",goodsTemp.getGoodsName());
		basic.put("ename",goodsTemp.getGoodsEname());
		//获取商品对应分类树
		basic.put("is_gift",goodsTemp.getCatId().intValue()==YamiConstant.GIFT_CAT_ID?1:0);
		basic.put("is_promote", StringUtil.checkPrice(goodsTemp)?1:0);
		basic.put("is_district", goodsTemp.getIsDistrict().intValue());
		basic.put("promote_price",StringUtil.formatPrice(goodsTemp.getPromotePrice()));
		basic.put("shop_price",StringUtil.formatPrice(goodsTemp.getShopPrice()));
		basic.put("currency",YamiConstant.CURRENCY);
		
		//search good_gallery
		//
		
		if(null!=goodsGallery&&goodsGallery.size()>0){
			String image[]= new String[goodsGallery.size()];
			if(goodsGallery.size() < 1)
			{
				image= new String[1];
			}
			int i=0;	
			for(i=0;i<goodsGallery.size();i++)
			{
				if(goodsGallery.get(i)!=null)
				{
					image[i]=YamiConstant.IMAGE_URL+goodsGallery.get(i).getImgUrl();	
				}
			}
			image[0]=YamiConstant.IMAGE_URL+goodsTemp.getOriginalImg();
			basic.put("images", image);
		}
		else{
			String image[]= new String[1];
			image[0]=YamiConstant.IMAGE_URL+goodsTemp.getGoodsImg();
			basic.put("images", image);
		}
		basic.put("goods_thumb", YamiConstant.IMAGE_URL+goodsTemp.getGoodsThumb());
		basic.put("goods_img", YamiConstant.IMAGE_URL+goodsTemp.getGoodsImg());
		//creat info's leaf
		info.put("Basic", basic);
	
		Vendors vendors=  userService.getVendorsByVendorId(goodsTemp.getVendorId());
		
		
		Map<String,Object>  vendor = new HashMap<String, Object>();
		vendor.put("vendor_id", vendors.getVendorId());
		vendor.put("vendor_name", vendors.getVendorName());
		vendor.put("vendor_ename", vendors.getVendorEname());
		vendor.put("quality", vendors.getQuality());
		vendor.put("quality_en", vendors.getQualityEn());
		vendor.put("points", vendors.getPoints());
		vendor.put("points_en", vendors.getPointsEn());
		vendor.put("return_policy", vendors.getReturnPolicy());
		vendor.put("return_policy_en", vendors.getReturnPolicyEn());
		vendor.put("delivery", vendors.getDelivery());
		vendor.put("delivery_en", vendors.getDeliveryEn());
		
		Map<String,Object> mapShipping = new HashMap<String,Object>();
		List<Map<String,Object>> lstShipping = new ArrayList<Map<String,Object>>();
		List<Shipping> lstShippingTemp = shippingService.selectShippingListByVendorId(goodsTemp.getVendorId());
			for(Shipping shipping:lstShippingTemp){
					mapShipping = new HashMap<String,Object>();
					mapShipping.put("shipping_id", shipping.getShippingId());
					mapShipping.put("shipping_name", shipping.getShippingName());
					mapShipping.put("shipping_fee", StringUtil.formatPrice(shipping.getShippingFee()));
					mapShipping.put("shipping_desc", shipping.getShippingDesc());
					mapShipping.put("free_shipping", shipping.getFreeShippingAmount());
					mapShipping.put("is_primary", shipping.getIsPrimary());
					lstShipping.add(mapShipping);
			}
			vendor.put("shipping",lstShipping);
		info.put("vendor", vendor);
		info.put("gid",goodsTemp.getGoodsId());
		info.put("Detail", detail);
		
		String catSub = goodsService.selectCatInfoByGid(goodsTemp.getGoodsId());
		String[] catIds = catSub.split(",");
		Map<String,Object>  category = new HashMap<String, Object>();
		List<Map<String,Object>> lstCategory = new ArrayList<Map<String,Object>>();
		for(int cstlev =0;cstlev<catIds.length;cstlev++){
			CategoryForShow categoryForShow = goodsService.selectCategoryInfo(Integer.parseInt(catIds[cstlev]));
			 category = new HashMap<String, Object>();
			 category.put("cat_id", categoryForShow.getCat_id());
			 category.put("cat_name", categoryForShow.getCat_name());
			 category.put("cat_ename", categoryForShow.getCat_ename());
			 category.put("parent_id", categoryForShow.getParent_id());
				 lstCategory.add(category); 
		}
		info.put("Category", lstCategory);
		result.put("Info", info);
		return result;
	}
	public Map<String, Object> selectNewItems(String token,int source,int channel,
			int start, int length) {
		// TODO Auto-generated method stub
		Map<String,Object>  result = new HashMap<String, Object>();
		List<Object>  items = new ArrayList<Object>();
		int count = 0;
		result.put("token", token);
		//按商品添加时间排序，获得新品列表
		if(source==1)
		{
			List<Goods> goodsTemp = goodsService.selectGoodsForNew(start, length);	
			count = goodsService.selectGoodsForNewCount();	
			for(Goods goods:goodsTemp)
			{
				Map<String,Object>  item = new HashMap<String, Object>();
				item.put("gid", goods.getGoodsId());
				Map<String,Object>  basic = new HashMap<String, Object>();
				basic.put("name",goods.getGoodsName());
				basic.put("ename",goods.getGoodsEname());
				basic.put("is_promote",goods.getIsPromote()?1:0);
				basic.put("shop_price",StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("promote_price",StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("currency",YamiConstant.CURRENCY);
				basic.put("image",YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				basic.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
				basic.put("image_big",YamiConstant.IMAGE_URL+goods.getGoodsImg());
				item.put("basic", basic);
				items.add(item);
			}
			result.put("items", items);
			result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		}
		
		//按goods_display_app设置，获得新品列表
		else if(source==2){
			List<GoodsDisplayApp> lstGoodsDisplayApp = goodsService.selectGoodsEdit(channel, YamiConstant.INDEX_NEW_ITEM_SECTION,null,YamiConstant.DISPLAY_DATA_TYPE_1,start, length);	
			count = goodsService.selectGoodsEditCount(channel, YamiConstant.INDEX_NEW_ITEM_SECTION,null,YamiConstant.DISPLAY_DATA_TYPE_1);	
			for(GoodsDisplayApp goods:lstGoodsDisplayApp)
			{
				Map<String,Object>  item = new HashMap<String, Object>();
				item.put("gid", goods.getId());
				Map<String,Object>  basic = new HashMap<String, Object>();
				basic.put("name",goods.getGoodsName());
				basic.put("ename",goods.getGoodsEname());
			 	basic.put("is_promote",goods.getIsPromote()?1:0);
				basic.put("shop_price",StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("promote_price",StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("currency",YamiConstant.CURRENCY);
				basic.put("image",goods.getIsImage()==1?YamiConstant.IMAGE_URL+goods.getImage():YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				basic.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
				item.put("basic", basic);
				items.add(item);
			}
			result.put("items", items);
			result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
			
		}
		//按goods_display_dkp设置，获得新品列表
		else if(source==3){
			List<GoodsDisplayDkp> lstGoodsDisplayDkp = goodsService.selectGoodsDkpEdit(channel, YamiConstant.INDEX_NEW_ITEM_SECTION,null,YamiConstant.DISPLAY_DATA_TYPE_1,start, length);	
			count = goodsService.selectGoodsDkpEditCount(channel, YamiConstant.INDEX_NEW_ITEM_SECTION,null,YamiConstant.DISPLAY_DATA_TYPE_1);	
			for(GoodsDisplayDkp goods:lstGoodsDisplayDkp)
			{
				Map<String,Object>  item = new HashMap<String, Object>();
				item.put("gid", goods.getId());
				Map<String,Object>  basic = new HashMap<String, Object>();
				basic.put("name",goods.getGoodsName());
				basic.put("ename",goods.getGoodsEname());
			 	basic.put("is_promote",goods.getIsPromote()?1:0);
				basic.put("shop_price",StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("promote_price",StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("currency",YamiConstant.CURRENCY);
				basic.put("image",goods.getIsImage()==1?YamiConstant.IMAGE_URL+goods.getImage():YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				basic.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
				item.put("basic", basic);
				items.add(item);
			}
			result.put("items", items);
			result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
			
		}
		return result;
	}
	
	public Map<String, Object> selectCatNewItems(String token, int channel,int cat_id, int start, int length) {
		// TODO Auto-generated method stub
				Map<String,Object>  result = new HashMap<String, Object>();
				List<Object>  lstResult = new ArrayList<Object>();
				
				List<GoodsDisplayApp> lstGoodsDisplayApp = new ArrayList<GoodsDisplayApp>();
				int count = 0;
				//首页分类下新品数据构成
				if(channel==YamiConstant.INDEX_PAGE){
					lstGoodsDisplayApp = goodsService.selectGoodsEdit(channel, YamiConstant.INDEX_CAT_NEW_ITEM_SECTION,cat_id,YamiConstant.DISPLAY_DATA_TYPE_1,start, length);
					count = goodsService.selectGoodsEditCount(channel, YamiConstant.INDEX_CAT_NEW_ITEM_SECTION,cat_id,YamiConstant.DISPLAY_DATA_TYPE_1);
					for(GoodsDisplayApp goods:lstGoodsDisplayApp)
					{
						if(goods.getSection()==7){
						Map<String,Object>  Item = new HashMap<String, Object>();
						Item.put("type", YamiConstant.DISPLAY_DATA_TYPE_1);
						Item.put("value", goods.getId());
						Map<String,Object>  Basic = new HashMap<String, Object>();
						Basic.put("name",goods.getGoodsName());
						Basic.put("ename",goods.getGoodsEname());
						Basic.put("is_promote",goods.getIsPromote());
						Basic.put("shop_price",StringUtil.formatPrice(goods.getShopPrice()));
						Basic.put("currency",YamiConstant.CURRENCY);
						Basic.put("image",goods.getIsImage()==1?YamiConstant.IMAGE_URL+goods.getImage():YamiConstant.IMAGE_URL+goods.getGoodsThumb());
						Item.put("Basic", Basic);
						lstResult.add(Item);
						}
					}
					
				}
				//发现页分类下新品数据构成
				else if(channel==YamiConstant.DISCOVER_PAGE){
					lstGoodsDisplayApp = goodsService.selectGoodsEdit(channel, null,cat_id,null,start, length);
					count = goodsService.selectGoodsEditCount(channel, null,cat_id,null);
					for(GoodsDisplayApp goods:lstGoodsDisplayApp)
					{
						Map<String,Object>  Item = new HashMap<String, Object>();
						Item.put("type", goods.getType());
						
						if(goods.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
							Item.put("value", goods.getId());
							Map<String,Object>  Basic = new HashMap<String, Object>();
							Basic.put("name",goods.getGoodsName());
							Basic.put("ename",goods.getGoodsEname());
							Basic.put("is_promote",goods.getIsPromote());
							Basic.put("shop_price",StringUtil.formatPrice(goods.getShopPrice()));
							Basic.put("currency",YamiConstant.CURRENCY);
							Basic.put("image",goods.getIsImage()==1?YamiConstant.IMAGE_URL+goods.getImage():YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							Item.put("Basic", Basic);
						}
						else if(goods.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
							Item.put("value", goods.getId());
							Map<String,Object>  brand = new HashMap<String, Object>();
							brand.put("name",goods.getBrandName());
							brand.put("ename",goods.getBrandEname());
							Item.put("brand", brand);
						}
						else if(goods.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
							Item.put("value", goods.getId());
							Map<String,Object>  cat = new HashMap<String, Object>();
							cat.put("name",goods.getCatName());
							cat.put("ename",goods.getCatEname());
							Item.put("cat", cat);
						}
						else if(goods.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
							Item.put("value", goods.getSearch());
							Map<String,Object>  search = new HashMap<String, Object>();
							search.put("name",goods.getSearch());
							search.put("ename",goods.getEsearch());
							Item.put("search", search);
						}
						lstResult.add(Item);
					}
				}

				result.put("token", token);
				result.put("cat_id", cat_id);
				result.put("results", lstResult);
				result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
				return result;
	}
	
	/*
	获取频道页信息（读）（缓）
	@param String token 
	@return Map<String,Object> 信息列表
	*/	
	public  Map<String,Object> getChannelInfo(String token,int channel){
		Map<String,Object> result = new HashMap<String,Object>();
		List<Object>  lstResult = new ArrayList<Object>();
		List<Object>  lstSection = new ArrayList<Object>();
		Map<String,Object> mapSection = new HashMap<String,Object>();
		List<GoodsDisplayApp> lstGoodsDisplayApp = goodsService.selectGoodsEdit(channel, null,null,null,null, null);

			for(GoodsDisplayApp goods:lstGoodsDisplayApp)
			{
				Map<String,Object>  Item = new HashMap<String, Object>();
				Item.put("type", goods.getType());
				Item.put("section", goods.getSection());
				Item.put("cat_id", goods.getCatId());
				Item.put("image", goods.getIsImage()==1?YamiConstant.IMAGE_URL+goods.getImage():YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				Item.put("eimage",goods.getIsImage()==1?YamiConstant.IMAGE_URL+goods.getEimage():YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				
				
				if(goods.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
					Item.put("value", goods.getId());
					Map<String,Object>  Basic = new HashMap<String, Object>();
					Basic.put("name",goods.getGoodsName());
					Basic.put("ename",goods.getGoodsEname());
					Basic.put("promote_price",StringUtil.formatPrice(goods.getPromotePrice()));
					Basic.put("is_promote",goods.getIsPromote());
					Basic.put("shop_price",StringUtil.formatPrice(goods.getShopPrice()));
					Basic.put("currency",YamiConstant.CURRENCY);
					Item.put("Basic", Basic);
				}
				else if(goods.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
					Item.put("value", goods.getId());
					Map<String,Object>  brand = new HashMap<String, Object>();
					brand.put("name",goods.getBrandName());
					brand.put("ename",goods.getBrandEname());
					Item.put("brand", brand);
				}
				else if(goods.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
					Item.put("value", goods.getId());
					Map<String,Object>  cat = new HashMap<String, Object>();
					cat.put("name",goods.getCatName());
					cat.put("ename",goods.getCatEname());
					Item.put("cat", cat);
				}
				else if(goods.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
					Item.put("value", goods.getSearch());
					Map<String,Object>  search = new HashMap<String, Object>();
					search.put("name",goods.getSearch());
					search.put("ename",goods.getEsearch());
					Item.put("search", search);
				}
				
				if(null!=mapSection.get("section"+String.valueOf(goods.getSection()))){
					lstSection = (ArrayList<Object>)mapSection.get("section"+String.valueOf(goods.getSection()));
					lstSection.add(Item);
					mapSection.put("section"+String.valueOf(goods.getSection()), lstSection);
					
				}else{
					lstSection = new ArrayList<Object>();
					lstSection.add(Item);
					mapSection.put("section"+String.valueOf(goods.getSection()), lstSection);
				}
			}
	
	//result.put("token", token);
	result.put("channel", mapSection);
	return result;
		
	}
	

	
	public Map<String,Object> selectShowCategory(String token) {
		//创建hashmap
		Map<String,Object>  result = new HashMap<String, Object>();
		//result.put("token", token);
		//创建树头.
		CategoryTreeNode categoryTreeNode = new CategoryTreeNode();
		categoryTreeNode.setParent_id(0);
		categoryTreeNode.setCat_id(0);
		categoryTreeNode.setCat_ename(YamiConstant.NODE_HEAD_ENGLISH);
		categoryTreeNode.setCat_name(YamiConstant.NODE_HEAD_CHINESE);
		categoryTreeNode.children = new LinkedList<CategoryTreeNode>();
		List<CategoryForShow> tempList = goodsService.selectShowCategory();
		//察看是否有list
		if(tempList != null)
		{
			if(tempList.size()>0)
			{
				//遍历一次树头
				for(int j=0;j<tempList.size();j++)
				{
					//是否是树头的叶子节点
					if(tempList.get(j).getParent_id() == 0)
					{ 
						//temp赋值
						//check is_show
						if(tempList.get(j).getIs_show() == 1)
						{
							CategoryTreeNode temp = new CategoryTreeNode();
							temp.setCat_id(tempList.get(j).getCat_id());
							temp.setParent_id(tempList.get(j).getParent_id());
							temp.setCat_name(tempList.get(j).getCat_name());
							temp.setCat_ename(tempList.get(j).getCat_ename());
							if(tempList.get(j).getIcon() != null)
							{
								if(!tempList.get(j).getIcon().equals(""))
								{
									temp.setIcon(YamiConstant.IMAGE_URL+tempList.get(j).getIcon());	
								}
								else{
										temp.setIcon("");	
									}
							}
							//添加temp
							categoryTreeNode.children.add(temp);
						}
					}
				}
			}
		
			//获取children，线性代数,递归
			if(categoryTreeNode.children != null)
			{
				if(categoryTreeNode.children.size() != 0)
				{
					//递归查询子层.
					NewtonDownhillRecursionCheck(categoryTreeNode.children,tempList);
				}
			}
		}
		//qu wuyong de zhi good_id
		
		result.put("category", categoryTreeNode.children);
		return result;
	}
    	
	private void NewtonDownhillRecursionCheck(List<CategoryTreeNode> categoryTreeNode, List<CategoryForShow> tempList)
	{	
		//遍历线性代数.
		for(int i=0;i<categoryTreeNode.size();i++)
		{
			categoryTreeNode.get(i).children=new LinkedList<CategoryTreeNode>();
			//队列遍历
			for(int j=0;j<tempList.size();j++)
			{
				//牛顿下山法.循环便利数组,察看是否属于相同父节点.
				if(tempList.get(j).getParent_id() == categoryTreeNode.get(i).getCat_id())
				{
					//temp赋值
					//check is_show
					if(tempList.get(j).getIs_show() == 1)
					{
						CategoryTreeNode temp = new CategoryTreeNode();
						temp.setCat_id(tempList.get(j).getCat_id());
						temp.setParent_id(tempList.get(j).getParent_id());
						temp.setCat_name(tempList.get(j).getCat_name());
						temp.setCat_ename(tempList.get(j).getCat_ename());
						if(tempList.get(j).getIcon() != null)
						{
							if(!tempList.get(j).getIcon().equals(""))
							{
								temp.setIcon(YamiConstant.IMAGE_URL+tempList.get(j).getIcon());	
							}else{
								temp.setIcon("");	
							}
						}
						
						//牛顿下山法递减序列.减少2/3运算量.删除已经遍历过的list
						tempList.remove(tempList.get(j--));

						//添加符合匹配的list.
						categoryTreeNode.get(i).children.add(temp);
					}
				}
			}
			//QA检查是否创建节点.
			if(categoryTreeNode.get(i).children != null)
			{
				//QA检查是否有子节点
				if(categoryTreeNode.get(i).children.size() != 0)
				{
					//递归查询子层.
					NewtonDownhillRecursionCheck(categoryTreeNode.get(i).children,tempList);
				}
			}
		}
		//遍历
	}

	public Map<String, Object> selectCatItems(String token, Integer cat_id, Integer sort_by, Integer sort_order, Integer is_promote, Integer page, String brand_id, String agent) 
	{
		Map<String,Object>  result = new HashMap<String, Object>();
		result.put("token", token);
		//求总行数
		
		//默认为手机配置
		int index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
		int ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE;

		if(agent==null||agent.trim().equals(YamiConstant.STRING_EMPTY)){
			agent = "android";
		}
		//System.out.println(agent.toString());
		//识别调试器,完成调试器配置
		Pattern pattern = Pattern.compile(YamiConstant.REGEX_SOAPUI, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(agent);
        if (matcher.find()) 
        {
        	//System.out.println("find soapUI ");
    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
    		ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE;
        }
	    //识别苹果手机
        pattern = Pattern.compile(YamiConstant.REGEX_IPHONE, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(agent);
        if (matcher.find()) 
        {
        	//System.out.println("find iphone ");
    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_MOBILE;
        }
        //识别三星系列智能设备.
        pattern = Pattern.compile(YamiConstant.REGEX_ANDROID, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(agent);
        if (matcher.find()) 
        {
        	//System.out.println("find android ");
    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_MOBILE;
        }
        //识别火狐浏览器
        pattern = Pattern.compile(YamiConstant.REGEX_FIREFOX, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(agent);
        if (matcher.find()) 
        {
        	//System.out.println("find firefox ");
    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
        }
		//识别windows平台浏览器
        pattern = Pattern.compile(YamiConstant.REGEX_IE, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(agent);
        if (matcher.find()) 
        {
        	//System.out.println("find ie ");
    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
        }
        //识别chrome浏览器
        pattern = Pattern.compile(YamiConstant.REGEX_CHROME, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(agent);
        if (matcher.find()) 
        {
        	//System.out.println("find chrome ");
    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
        }
        //识别ipad平台.
        pattern = Pattern.compile(YamiConstant.REGEX_IPAD, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(agent);
        if (matcher.find()) 
        {
        	//System.out.println("find ipad ");
    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
        }
        //识别mac平台.
        pattern = Pattern.compile(YamiConstant.REGEX_MAC, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(agent);
        if (matcher.find()) 
        {
        	//System.out.println("find imac ");
    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
        }
        //执行
        //字符串提取算法
        int[] brand_id_int = new int[0];
        if(brand_id!=null)
        {
        	brand_id_int = new int[brand_id.split(",").length];
            //System.out.println("1:"+brand_id.split(",").length);
        	//判断1个值域
        	if(brand_id.split(",").length==1)
        	{
        		for(int i=0;i<brand_id.split(",").length;i++)
                {
        			//创造temp数组并且提取.
                	String str2="";
                	if(brand_id.split(",")[i] != null && !"".equals(brand_id.split(",")[i]))
                    {
                    	for(int j=0;j<brand_id.split(",")[i].length();j++)
                    	{
                    		//取0~9数字
                    		if(brand_id.split(",")[i].charAt(j)>=48 && brand_id.split(",")[i].charAt(j)<=57)
                    		{
                    			str2+=brand_id.split(",")[i].charAt(j);
                    		}
                    	}
                    }
                	//值域判断为空
                	if(str2.equals(""))
                	{
                		 brand_id_int = new int[0];;	
                	}
                	else
                	{
                		brand_id_int[i]=Integer.parseInt(str2); 
                	}
                }		
        	}else{
        		    //确定为多个值域.
        			for(int i=0;i<brand_id.split(",").length;i++)
        			{
        				String str2="";
        				if(brand_id.split(",")[i] != null && !"".equals(brand_id.split(",")[i]))
        				{
        					for(int j=0;j<brand_id.split(",")[i].length();j++)
        					{
        						//取0~9数字
        						if(brand_id.split(",")[i].charAt(j)>=48 && brand_id.split(",")[i].charAt(j)<=57)
        						{
        							str2+=brand_id.split(",")[i].charAt(j);
        						}
        					}
        				}
        				brand_id_int[i]=Integer.parseInt(str2); 
        			}
        	     }	
        }  
        //去掉负数
        if(index<0)
        {
        	index=0;
        }
        //求图片地址和是否售空.
        List<GoodsOfCatItems> goodsOfCatItems= goodsService.selectCatItems(cat_id, sort_by, sort_order, is_promote, index, brand_id_int, ITEMS_PER_PAGE);
        //或取选择搜索总行数
        int goodsOfCatItemsCount= goodsService.selectCatItemsCount(cat_id, sort_by, sort_order, is_promote, index, brand_id_int, ITEMS_PER_PAGE);
        
        
        ArrayList<Object>  CatItems  = new ArrayList<>();        
        for(int i=0;i<goodsOfCatItems.size();i++)
        {
        	  Map<String,Object> catItemsTemp  = new HashMap<String, Object>();
        	  catItemsTemp.put("goods_id",goodsOfCatItems.get(i).getGoods_id());
        	  catItemsTemp.put("goods_name",goodsOfCatItems.get(i).getGoods_name());
        	  catItemsTemp.put("goods_ename",goodsOfCatItems.get(i).getGoods_ename());
        	  catItemsTemp.put("shop_price",StringUtil.formatPrice(goodsOfCatItems.get(i).getShop_price()));
        	  catItemsTemp.put("is_promote",goodsOfCatItems.get(i).getIs_promote());
        	  catItemsTemp.put("promote_price",StringUtil.formatPrice(goodsOfCatItems.get(i).getPromote_price()));
        	  //大于0没有售完,小于0售完.
        	  if(goodsOfCatItems.get(i).getGoods_number()>0)
        	  {
        		  catItemsTemp.put("is_oos",0);
        	  }else{
        		  		catItemsTemp.put("is_oos",1);
        	  	   }
        	  catItemsTemp.put("image",YamiConstant.IMAGE_URL+goodsOfCatItems.get(i).getGoodsImg());
        	  catItemsTemp.put("goods_thumb",YamiConstant.IMAGE_URL+goodsOfCatItems.get(i).getGoods_thumb());
        	  catItemsTemp.put("goods_img",YamiConstant.IMAGE_URL+goodsOfCatItems.get(i).getGoodsImg());
        	  catItemsTemp.put("original_img",YamiConstant.IMAGE_URL+goodsOfCatItems.get(i).getOriginalImg());
        	  CatItems.add(catItemsTemp);  
        }
       
		result.put("items",CatItems);	
		
		result.put("page",page);
		//page_count
		//获取数据库总行数数
		//总行数除以每页行数==页数  共页面,则显示page(1~x)之间
		result.put("page_count",new Double(Math.ceil(new Double(goodsOfCatItemsCount)/new Double(ITEMS_PER_PAGE))).intValue());
		
	    return result;
	}

	public Map<String, Object> selectCatBrands(String token, int cat_id) 
	{
		Map<String,Object>  result = new HashMap<String, Object>();
		List<BrandName> brandName = null;
		
	    brandName=goodsService.selectCatBrands(cat_id);

		char temp = 0;
		Map<String, List<Object>> map_number = new LinkedHashMap<String, List<Object>>();
		
		List<Object>  list_number = new ArrayList<Object>();
		List<Object>  list_a = new ArrayList<Object>();
		List<Object>  list_b = new ArrayList<Object>();
		List<Object>  list_c = new ArrayList<Object>();
		List<Object>  list_d = new ArrayList<Object>();
		List<Object>  list_e = new ArrayList<Object>();
		List<Object>  list_f = new ArrayList<Object>();
		List<Object>  list_g = new ArrayList<Object>();
		List<Object>  list_h = new ArrayList<Object>();
		List<Object>  list_i = new ArrayList<Object>();
		List<Object>  list_j = new ArrayList<Object>();
		List<Object>  list_k = new ArrayList<Object>();
		List<Object>  list_l = new ArrayList<Object>();
		List<Object>  list_m = new ArrayList<Object>();
		List<Object>  list_n = new ArrayList<Object>();
		List<Object>  list_o = new ArrayList<Object>();
		List<Object>  list_p = new ArrayList<Object>();
		List<Object>  list_q = new ArrayList<Object>();
		List<Object>  list_r = new ArrayList<Object>();
		List<Object>  list_s = new ArrayList<Object>();
		List<Object>  list_t = new ArrayList<Object>();
		List<Object>  list_u = new ArrayList<Object>();
		List<Object>  list_v = new ArrayList<Object>();
		List<Object>  list_w = new ArrayList<Object>();
		List<Object>  list_x = new ArrayList<Object>();
		List<Object>  list_y = new ArrayList<Object>();
		List<Object>  list_z = new ArrayList<Object>();
		
		//
		//System.out.println(brandName.size());
		for(int i=0;i<brandName.size();i++)
		{
			if(brandName.get(i).getAlphabetic_index()!=null)
			{
				if(!brandName.get(i).getAlphabetic_index().equals(""))
				{	
					temp=brandName.get(i).getAlphabetic_index().charAt(0);
				}
			}
	    	//0~9 use # simbol
		//	System.out.println(temp);
			if(temp>=48 && temp<=57)//check 0~9 ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_number.add(brandNameSort);
			}
			if(temp==65 || temp==97)//check a ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_a.add(brandNameSort);
			}
			if(temp==66 || temp==98)//check b ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_b.add(brandNameSort);
			}
			if(temp==67 || temp==99)//check c ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_c.add(brandNameSort);
			}
			if(temp==68 || temp==100)//check d ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_d.add(brandNameSort);
			}
			if(temp==69 || temp==101)//check e ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_e.add(brandNameSort);
			}
			if(temp==70 || temp==102)//check f ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_f.add(brandNameSort);
			}
			if(temp==71 || temp==103)//check g ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_g.add(brandNameSort);
			}
			if(temp==72 || temp==104)//check h ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_h.add(brandNameSort);
			}
			if(temp==73 || temp==105)//check i ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_i.add(brandNameSort);
			}
			if(temp==74 || temp==106)//check j ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_j.add(brandNameSort);
			}
			if(temp==75 || temp==107)//check k ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_k.add(brandNameSort);
			}
			if(temp==76 || temp==108)//check l ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_l.add(brandNameSort);
			}
			if(temp==77 || temp==109)//check m ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_m.add(brandNameSort);
			}
			if(temp==78 || temp==110)//check n ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_n.add(brandNameSort);
			}
			if(temp==79 || temp==111)//check o ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_o.add(brandNameSort);
			}
			if(temp==80 || temp==112)//check p ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_p.add(brandNameSort);
			}
			if(temp==81 || temp==113)//check q ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_q.add(brandNameSort);
			}
			if(temp==82 || temp==114)//check r ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_r.add(brandNameSort);
			}
			if(temp==83 || temp==115)//check s ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_s.add(brandNameSort);
			}
			if(temp==84 || temp==116)//check t ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_t.add(brandNameSort);
			}
			if(temp==85 || temp==117)//check u ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_u.add(brandNameSort);
			}
			if(temp==86 || temp==118)//check v ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_v.add(brandNameSort);
			}
			if(temp==87 || temp==119)//check w ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_w.add(brandNameSort);
			}
			if(temp==88 || temp==120)//check x ascii
			{ 
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_x.add(brandNameSort);
			}
			if(temp==89 || temp==121)//check y ascii
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_y.add(brandNameSort);
			}
			if(temp==90 || temp==122)//check z ascii 
			{
				BrandNameSort brandNameSort= new BrandNameSort();
				brandNameSort.setBrand_id(brandName.get(i).getBrand_id());
				brandNameSort.setBrand_name(brandName.get(i).getBrand_name());
				brandNameSort.setBrand_ename(brandName.get(i).getBrand_ename());
				list_z.add(brandNameSort);
			}
			
		}
		if(list_number.size()>0)
		{
			map_number.put("#", list_number);	
		}
		if(list_a.size()>0)
		{
			map_number.put("A", list_a);
		}
		if(list_b.size()>0)
		{
			map_number.put("B", list_b);
		}
		if(list_c.size()>0)
		{
			map_number.put("C", list_c);
		}
		if(list_d.size()>0)
		{
			map_number.put("D", list_d);
		}
		if(list_e.size()>0)
		{
			map_number.put("E", list_e);
		}
		if(list_f.size()>0)
		{
			map_number.put("F", list_f);
		}
		if(list_g.size()>0)
		{
			map_number.put("G", list_g);
		}
		if(list_h.size()>0)
		{
			map_number.put("H", list_h);
		}
		if(list_i.size()>0)
		{
			map_number.put("I", list_i);
		}
		if(list_j.size()>0)
		{
			map_number.put("J", list_j);
		}
		if(list_k.size()>0)
		{
			map_number.put("K", list_k);
		}
		if(list_l.size()>0)
		{
			map_number.put("L", list_l);
		}
		if(list_m.size()>0)
		{
			map_number.put("M", list_m);
		}
		if(list_n.size()>0)
		{
			map_number.put("N", list_n);
		}
		if(list_o.size()>0)
		{
			map_number.put("O", list_o);
		}
		if(list_p.size()>0)
		{
			map_number.put("P", list_p);
		}
		if(list_q.size()>0)
		{
			map_number.put("Q", list_q);
		}
		if(list_r.size()>0)
		{
			map_number.put("R", list_r);
		}
		if(list_s.size()>0)
		{
			map_number.put("S", list_s);
		}
		if(list_t.size()>0)
		{
			map_number.put("T", list_t);
		}
		if(list_u.size()>0)
		{
			map_number.put("U", list_u);
		}
		if(list_v.size()>0)
		{
			map_number.put("V", list_v);
		}
		if(list_w.size()>0)
		{
			map_number.put("W", list_w);
		}
		if(list_x.size()>0)
		{
			map_number.put("X", list_x);
		}
		if(list_y.size()>0)
		{
			map_number.put("Y", list_y);
		}
		if(list_z.size()>0)
		{
			map_number.put("Z", list_z);
		}
		
		result.put("Brands", map_number);
		result.put("token", token);
		return result;
	}

	/*
	  获取闪购商品数据（当 start = 0 length = 1时， 服务从数据库中提取标记为首页展示的商品。）
	@param Integer start
	@param Integer length
	@return Map<String,Object> 商品信息
	*/
	public Map<String,Object> getFlashItems(String token,Integer start,Integer length){
		Map<String,Object> result = new HashMap<String,Object>();
		List<Object> items = new ArrayList<Object>();
		Map<String,Object> item = new HashMap<String,Object>();
		Map<String,Object> basic = new HashMap<String,Object>();
		List<GoodsFlash> lstGoodsFlash = goodsService.selectGoodsOfFlash(start, length);
		int count = goodsService.selectGoodsOfFlashCount();
		for(GoodsFlash goodsFlash:lstGoodsFlash){
			basic = new HashMap<String,Object>();
			basic.put("name", goodsFlash.getGoodsName());
			basic.put("ename", goodsFlash.getGoodsEname());
			basic.put("desc", goodsFlash.getGoodsDesc());
			basic.put("edesc", goodsFlash.getGoodsEdesc());
			basic.put("is_promote", goodsFlash.getIsPromote());
			basic.put("promote_price", StringUtil.formatPrice(goodsFlash.getPromotePrice()));
			basic.put("shop_price", StringUtil.formatPrice(goodsFlash.getShopPrice()));
			basic.put("currency", "$");
			basic.put("image", YamiConstant.IMAGE_URL+goodsFlash.getGoodsThumb());
			item = new HashMap<String,Object>();
			item.put("gid", goodsFlash.getGoodsId());
			item.put("basic", basic);
			item.put("expiry", goodsFlash.getPromoteCountdown());
			items.add(item);	
		}
		result.put("items", items);
		result.put("token", token);
		result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		return result;
	}
	/*
	 获取分类关键字
	@param Integer cat_id   分类ID。
	@param Integer priority  权重级别。p_natural + p_manual 大于该值的记录将被返回。默认为0。
	@param Integer count   返回个数。默认为全部符合记录。
	@return Map<String,Object> 关键字信息
	*/	
	public  Map<String,Object> getCatKeywords(String token,Integer cat_id,Integer priority,Integer count){
		 Map<String,Object> result   = new HashMap<String,Object>();
		 List<Object> keywords = new ArrayList<Object>();
		 Map<String,Object> keyword   = new HashMap<String,Object>();
		 List<Keywords> lstKeywords = goodsService.selectKeywords(cat_id, priority, count);
		 for(Keywords keywordTemp:lstKeywords){
			 keyword   = new HashMap<String,Object>();
			 keyword.put("key_id", keywordTemp.getKeyId());
			 keyword.put("key_name", keywordTemp.getKeyName());
			 keyword.put("key_ename", keywordTemp.getKeyEname());
			 keywords.add(keyword);
		 }
		 result.put("token", token);
		 result.put("cat_id", cat_id);
		 result.put("keywords", keywords); 
		return result;
	}

	/*
	 获取首页信息
	@param String token 
	@return Map<String,Object> 首页信息
	*/	
	public  Map<String,Object> getIndexInfo(String token)throws Exception{
		Map<String,Object> result   = new HashMap<String,Object>();
		Map<String,Object> home   = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		//获取滚动图片信息
		List<GoodsDisplayApp> imageOfIndex = goodsService.selectGoodsEdit(YamiConstant.INDEX_PAGE, YamiConstant.INDEX_SLIDES_IMAGE_SECTION,null,null,YamiConstant.INDEX_CAT_DISPLAY_GOODS_START, YamiConstant.INDEX_CAT_DISPLAY_GOODS_LENGTH);
		Map<String,Object> image = new HashMap<String,Object>();
		List<Object> lstImage = new ArrayList<Object>();
		for(GoodsDisplayApp goodsDisplayApp:imageOfIndex){
			image = new HashMap<String,Object>();
			image.put("type", goodsDisplayApp.getType());
			
			if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
				image.put("value", goodsDisplayApp.getId());
				basic   = new HashMap<String,Object>();
				basic.put("name", goodsDisplayApp.getGoodsName());
				basic.put("ename", goodsDisplayApp.getGoodsEname());
				basic.put("is_promote", goodsDisplayApp.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goodsDisplayApp.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goodsDisplayApp.getShopPrice()));
				basic.put("currency", "$");
//				basic.put("image", YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
				image.put("basic", basic);
				image.put("image",  goodsDisplayApp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayApp.getImage():YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
				image.put("eimage",  goodsDisplayApp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayApp.getImage():YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
			}else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
				image.put("value", goodsDisplayApp.getId());
				Map<String,Object>  brand = new HashMap<String, Object>();
				brand.put("name",goodsDisplayApp.getBrandName());
				brand.put("ename",goodsDisplayApp.getBrandEname());
				image.put("brand", brand);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
			}
			else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
				image.put("value", goodsDisplayApp.getId());
				Map<String,Object>  cat = new HashMap<String, Object>();
				cat.put("name",goodsDisplayApp.getCatName());
				cat.put("ename",goodsDisplayApp.getCatEname());
				image.put("cat", cat);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
			}

			else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
				image.put("value", goodsDisplayApp.getSearch());
				image.put("evalue", goodsDisplayApp.getEsearch());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
			}
			else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_0){
				image.put("url",   goodsDisplayApp.getUrl());
				image.put("title",  goodsDisplayApp.getTitle());
				image.put("etitle",  goodsDisplayApp.getEtitle());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
			}
			lstImage.add(image);
		}
		home.put("slides", lstImage);
		
		
		//获取闪购信息
		GoodsFlash goodsFlash = goodsService.selectGoodsOfFlashInIndex();
		Map<String,Object> flashItem = new HashMap<String,Object>();
		flashItem.put("gid", goodsFlash.getGoodsId());
		basic   = new HashMap<String,Object>();
		basic.put("name", goodsFlash.getGoodsName());
		basic.put("ename", goodsFlash.getGoodsEname());
		basic.put("desc", goodsFlash.getGoodsDesc());
		basic.put("edesc", goodsFlash.getGoodsEdesc());
		basic.put("is_promote", goodsFlash.getIsPromote()?1:0);
		basic.put("promote_price", StringUtil.formatPrice(goodsFlash.getPromotePrice()));
		basic.put("shop_price", StringUtil.formatPrice(goodsFlash.getShopPrice()));
		basic.put("currency", "$");
		basic.put("image", YamiConstant.IMAGE_URL+goodsFlash.getGoodsImg());
		basic.put("goods_thumb", YamiConstant.IMAGE_URL+goodsFlash.getGoodsThumb());
		basic.put("goods_img", YamiConstant.IMAGE_URL+goodsFlash.getGoodsImg());
		basic.put("original_img", YamiConstant.IMAGE_URL+goodsFlash.getOriginalImg());
		flashItem.put("basic", basic);
		flashItem.put("expiry", goodsFlash.getPromoteCountdown());
		home.put("flashItem", flashItem);
		//获取新品信息
		Map<String, Object> mapNewGoods = selectNewItems(token, 2,YamiConstant.INDEX_PAGE,YamiConstant.INDEX_DISPLAY_NEWGOODS_START, YamiConstant.INDEX_DISPLAY_NEWGOODS_LENGTH);
		home.put("newItems", mapNewGoods.get("items"));
		//获取首页分类下信息
		//获取首页需显示的顶级分类
		 List<CategoryForShow> lstCat = goodsService.selectShowCategory4Index();
		 List<Object> lstcatInfo = new ArrayList<Object>();
		 Map<String,Object> catInfo = new HashMap<String,Object> ();
		 for(CategoryForShow categoryForShow:lstCat){
			 catInfo = new HashMap<String,Object> ();
			 catInfo.put("cat_id", categoryForShow.getCat_id());
			 //获取分类关键字信息
			 List<Keywords> lstKeywords = goodsService.selectKeywords(categoryForShow.getCat_id(), YamiConstant.INDEX_KEYWORDS_DISPLAY_PRIORITY, YamiConstant.INDEX_KEYWORDS_DISPLAY_NUMBER);
			 List<Object> keywords = new ArrayList<Object>();
			 Map<String,Object> keyword = new HashMap<String,Object> ();
			 for(Keywords keywordTemp:lstKeywords){
				 keyword = new HashMap<String,Object> ();
				 keyword   = new HashMap<String,Object>();
				 keyword.put("key_id", keywordTemp.getKeyId());
				 keyword.put("key_name", keywordTemp.getKeyName());
				 keyword.put("key_ename", keywordTemp.getKeyEname());
				 keywords.add(keyword);
		     } 
			 catInfo.put("keywords", keywords);
			//获取分类新商品信息
			 List<GoodsDisplayApp> lstGoodsDisplayApp = goodsService.selectGoodsEdit(YamiConstant.INDEX_PAGE,YamiConstant.INDEX_CAT_NEW_ITEM_SECTION,categoryForShow.getCat_id(),YamiConstant.DISPLAY_DATA_TYPE_1,YamiConstant.INDEX_CAT_DISPLAY_GOODS_START, YamiConstant.INDEX_CAT_DISPLAY_GOODS_LENGTH);
			 Map<String,Object> item = new HashMap<String,Object>();
			 List<Object> items = new ArrayList<Object>();
			 for(GoodsDisplayApp goods:lstGoodsDisplayApp){
				 if(goods.getSection()==7){
				    basic = new HashMap<String,Object>();
					basic.put("name", goods.getGoodsName());
					basic.put("ename", goods.getGoodsEname());
					basic.put("is_promote", goods.getIsPromote()?1:0);
					basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
					basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
					basic.put("currency", "$");
					basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
					basic.put("goods_thumb", YamiConstant.IMAGE_URL+goodsFlash.getGoodsThumb());
					basic.put("goods_img", YamiConstant.IMAGE_URL+goodsFlash.getGoodsImg());
					basic.put("original_img", YamiConstant.IMAGE_URL+goodsFlash.getOriginalImg());
					item = new HashMap<String,Object>();
					item.put("gid", goods.getId());
					item.put("basic", basic);
					items.add(item);	
				 }
			 }
			 catInfo.put("catNewItems", items);
			 lstcatInfo.add(catInfo);
		 }
		home.put("catInfo", lstcatInfo);
		//获取折扣商品信息只获取8条
		List<Goods> lstGoods = goodsService.selectGoodsPromote(DateUtil.getNowLong(), YamiConstant.INDEX_PROMOTE_DISPLAY_GOODS_START, YamiConstant.INDEX_PROMOTE_DISPLAY_GOODS_LENGTH);
		List<Object> lstPromoteItem = new ArrayList<Object>();
		Map<String,Object> promoteItem = new HashMap<String,Object>();
		 for(Goods goods:lstGoods){
			    basic = new HashMap<String,Object>();
				basic.put("name", goods.getGoodsName());
				basic.put("ename", goods.getGoodsEname());
				basic.put("is_promote", goods.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("currency", "$");
				basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("goods_thumb", YamiConstant.IMAGE_URL+goodsFlash.getGoodsThumb());
				basic.put("goods_img", YamiConstant.IMAGE_URL+goodsFlash.getGoodsImg());
				basic.put("original_img", YamiConstant.IMAGE_URL+goodsFlash.getOriginalImg());
				promoteItem = new HashMap<String,Object>();
				promoteItem.put("gid", goods.getGoodsId());
				promoteItem.put("basic", basic);
				lstPromoteItem.add(promoteItem);	 
		 }
		 home.put("promoteItems", lstPromoteItem);

		 
		//获取主题图片信息
			List<GoodsDisplayApp> imageOfTheme = goodsService.selectGoodsEdit(YamiConstant.INDEX_PAGE, YamiConstant.INDEX_THEME_SECTION,null,null,YamiConstant.INDEX_THEME_START, YamiConstant.INDEX_THEME_LENGTH);
			Map<String,Object> theme = new HashMap<String,Object>();
			List<Object> lstTheme = new ArrayList<Object>();
			for(GoodsDisplayApp goodsDisplayApp:imageOfTheme){
				theme = new HashMap<String,Object>();
				theme.put("type", goodsDisplayApp.getType());
				
				if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
					theme.put("value", goodsDisplayApp.getId());
					basic   = new HashMap<String,Object>();
					basic.put("name", goodsDisplayApp.getGoodsName());
					basic.put("ename", goodsDisplayApp.getGoodsEname());
					basic.put("is_promote", goodsDisplayApp.getIsPromote()?1:0);
					basic.put("promote_price", StringUtil.formatPrice(goodsDisplayApp.getPromotePrice()));
					basic.put("shop_price", StringUtil.formatPrice(goodsDisplayApp.getShopPrice()));
					basic.put("currency", "$");
//					basic.put("image", YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
					theme.put("basic", basic);
					theme.put("image",  goodsDisplayApp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayApp.getImage():YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
					theme.put("eimage",  goodsDisplayApp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayApp.getImage():YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
				}else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
					theme.put("value", goodsDisplayApp.getId());
					Map<String,Object>  brand = new HashMap<String, Object>();
					brand.put("name",goodsDisplayApp.getBrandName());
					brand.put("ename",goodsDisplayApp.getBrandEname());
					theme.put("brand", brand);
					theme.put("image",  YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
					theme.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
				}
				else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
					theme.put("value", goodsDisplayApp.getId());
					Map<String,Object>  cat = new HashMap<String, Object>();
					cat.put("name",goodsDisplayApp.getCatName());
					cat.put("ename",goodsDisplayApp.getCatEname());
					theme.put("cat", cat);
					theme.put("image",  YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
					theme.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
				}

				else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
					theme.put("value", goodsDisplayApp.getSearch());
					theme.put("evalue", goodsDisplayApp.getEsearch());
					theme.put("image",  YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
					theme.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
				}
				else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_0){
					theme.put("url",   goodsDisplayApp.getUrl());
					theme.put("title",  goodsDisplayApp.getTitle());
					theme.put("etitle",  goodsDisplayApp.getEtitle());
					theme.put("image",  YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
					theme.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
				}
				lstTheme.add(theme);
			}
			home.put("themes", lstTheme);
		 
		 
		 
		 
		 
		 
		//result.put("token", token);
		result.put("home", home);
		return result;
	}
	
	/*
	 获取首页信息(DKP)
	@param String token 
	@return Map<String,Object> 首页信息
	*/	
	public  Map<String,Object> getIndexInfoDkp(String token){
		Map<String,Object> result   = new HashMap<String,Object>();
		Map<String,Object> home   = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		//获取滚动图片信息
		List<GoodsDisplayDkp> imageOfIndex = goodsService.selectGoodsDkpEdit(YamiConstant.INDEX_PAGE, YamiConstant.INDEX_SLIDES_IMAGE_SECTION,null,null,null, null);
		Map<String,Object> image = new HashMap<String,Object>();
		List<Object> lstImage = new ArrayList<Object>();
		for(GoodsDisplayDkp goodsDisplayDkp:imageOfIndex){
			image = new HashMap<String,Object>();
			image.put("type", goodsDisplayDkp.getType());
			
			if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
				image.put("value", goodsDisplayDkp.getId());
				basic   = new HashMap<String,Object>();
				basic.put("name", goodsDisplayDkp.getGoodsName());
				basic.put("ename", goodsDisplayDkp.getGoodsEname());
				basic.put("is_promote", goodsDisplayDkp.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goodsDisplayDkp.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goodsDisplayDkp.getShopPrice()));
				basic.put("currency", "$");
				image.put("basic", basic);
				image.put("image",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
				image.put("eimage",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
			}else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  brand = new HashMap<String, Object>();
				brand.put("name",goodsDisplayDkp.getBrandName());
				brand.put("ename",goodsDisplayDkp.getBrandEname());
				image.put("brand", brand);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  cat = new HashMap<String, Object>();
				cat.put("name",goodsDisplayDkp.getCatName());
				cat.put("ename",goodsDisplayDkp.getCatEname());
				image.put("cat", cat);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}

			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
				image.put("value", goodsDisplayDkp.getSearch());
				image.put("evalue", goodsDisplayDkp.getEsearch());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_0){
				image.put("url",   goodsDisplayDkp.getUrl());
				image.put("title",  goodsDisplayDkp.getTitle());
				image.put("etitle",  goodsDisplayDkp.getEtitle());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			lstImage.add(image);
		}
		home.put("slides", lstImage);
		
		
		//获取闪购信息
		GoodsFlash goodsFlash = goodsService.selectGoodsOfFlashInIndex();
		Map<String,Object> flashItem = new HashMap<String,Object>();
		flashItem.put("gid", goodsFlash.getGoodsId());
		basic   = new HashMap<String,Object>();
		basic.put("name", goodsFlash.getGoodsName());
		basic.put("ename", goodsFlash.getGoodsEname());
		basic.put("desc", goodsFlash.getGoodsDesc());
		basic.put("edesc", goodsFlash.getGoodsEdesc());
		basic.put("is_promote", goodsFlash.getIsPromote()?1:0);
		basic.put("promote_price", StringUtil.formatPrice(goodsFlash.getPromotePrice()));
		basic.put("shop_price", StringUtil.formatPrice(goodsFlash.getShopPrice()));
		basic.put("limitedQuantity", goodsFlash.getLimitedQuantity());
		basic.put("currency", "$");
		basic.put("image", YamiConstant.IMAGE_URL+goodsFlash.getGoodsThumb());
		flashItem.put("basic", basic);
		flashItem.put("expiry", goodsFlash.getPromoteCountdown());
		home.put("flashItem", flashItem);
		//获取新品信息
		Map<String, Object> mapNewGoods = selectNewItems(token, 3,YamiConstant.INDEX_PAGE,YamiConstant.DKP_INDEX_DISPLAY_NEWGOODS_START, YamiConstant.DKP_INDEX_DISPLAY_NEWGOODS_LENGTH);
		home.put("newItems", mapNewGoods.get("items"));
		//获得热销商品
		Map<String, Object> mapHotItems  = selectHotItems(token,YamiConstant.INDEX_PAGE);
		home.put("hotItems", mapHotItems.get("items"));
		
		
		//获取首页分类下信息
		//获取首页需显示的顶级分类
		 List<CategoryForShow> lstCat = goodsService.selectShowCategory4Index();
		 List<Object> lstcatInfo = new ArrayList<Object>();
		 Map<String,Object> catInfo = new HashMap<String,Object> ();
		 for(CategoryForShow categoryForShow:lstCat){
			 catInfo = new HashMap<String,Object> ();
			 catInfo.put("cat_id", categoryForShow.getCat_id());
			 //获取分类关键字信息
			 List<Keywords> lstKeywords = goodsService.selectKeywords(categoryForShow.getCat_id(), YamiConstant.INDEX_KEYWORDS_DISPLAY_PRIORITY, YamiConstant.DKP_INDEX_KEYWORDS_DISPLAY_NUMBER);
			 List<Object> keywords = new ArrayList<Object>();
			 Map<String,Object> keyword = new HashMap<String,Object> ();
			 for(Keywords keywordTemp:lstKeywords){
				 keyword = new HashMap<String,Object> ();
				 keyword   = new HashMap<String,Object>();
				 keyword.put("key_id", keywordTemp.getKeyId());
				 keyword.put("key_name", keywordTemp.getKeyName());
				 keyword.put("key_ename", keywordTemp.getKeyEname());
				 keywords.add(keyword);
		     } 
			 catInfo.put("keywords", keywords);
			//获取分类新商品信息
			 List<GoodsDisplayDkp> lstGoodsDisplayApp = goodsService.selectGoodsDkpEdit(YamiConstant.INDEX_PAGE,YamiConstant.INDEX_CAT_NEW_ITEM_SECTION,categoryForShow.getCat_id(),YamiConstant.DISPLAY_DATA_TYPE_1,YamiConstant.DKP_INDEX_CAT_DISPLAY_GOODS_START, YamiConstant.DKP_INDEX_CAT_DISPLAY_GOODS_LENGTH);
			 Map<String,Object> item = new HashMap<String,Object>();
			 List<Object> items = new ArrayList<Object>();
			 for(GoodsDisplayDkp goods:lstGoodsDisplayApp){
				 if(goods.getSection()==YamiConstant.INDEX_CAT_NEW_ITEM_SECTION){
				    basic = new HashMap<String,Object>();
					basic.put("name", goods.getGoodsName());
					basic.put("ename", goods.getGoodsEname());
					basic.put("is_promote", goods.getIsPromote()?1:0);
					basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
					basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
					basic.put("currency", "$");
					basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
					item = new HashMap<String,Object>();
					item.put("gid", goods.getId());
					item.put("basic", basic);
					items.add(item);	
				 }
			 }
			 catInfo.put("catNewItems", items);
			 lstcatInfo.add(catInfo);
		 }
		home.put("catInfo", lstcatInfo);
		//result.put("token", token);
		result.put("home", home);
		return result;
	}
	/*
	 获取美妆馆信息(DKP)
	@param String token 
	@return Map<String,Object> 美妆馆信息(DKP)
	*/	
	public  Map<String,Object> getChannelBeautyInfoDkp(String token){
		Map<String,Object> result   = new HashMap<String,Object>();
		Map<String,Object> home   = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		//获取滚动图片信息
		List<GoodsDisplayDkp> imageOfIndex = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_3, YamiConstant.INDEX_SLIDES_IMAGE_SECTION,null,null,null, null);
		Map<String,Object> image = new HashMap<String,Object>();
		List<Object> lstImage = new ArrayList<Object>();
		for(GoodsDisplayDkp goodsDisplayDkp:imageOfIndex){
			image = new HashMap<String,Object>();
			image.put("type", goodsDisplayDkp.getType());
			
			if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
				image.put("value", goodsDisplayDkp.getId());
				basic   = new HashMap<String,Object>();
				basic.put("name", goodsDisplayDkp.getGoodsName());
				basic.put("ename", goodsDisplayDkp.getGoodsEname());
				basic.put("is_promote", goodsDisplayDkp.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goodsDisplayDkp.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goodsDisplayDkp.getShopPrice()));
				basic.put("currency", "$");
				image.put("basic", basic);
				image.put("image",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
				image.put("eimage",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
			}else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  brand = new HashMap<String, Object>();
				brand.put("name",goodsDisplayDkp.getBrandName());
				brand.put("ename",goodsDisplayDkp.getBrandEname());
				image.put("brand", brand);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  cat = new HashMap<String, Object>();
				cat.put("name",goodsDisplayDkp.getCatName());
				cat.put("ename",goodsDisplayDkp.getCatEname());
				image.put("cat", cat);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}

			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
				image.put("value", goodsDisplayDkp.getSearch());
				image.put("evalue", goodsDisplayDkp.getEsearch());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_0){
				image.put("url",   goodsDisplayDkp.getUrl());
				image.put("title",  goodsDisplayDkp.getTitle());
				image.put("etitle",  goodsDisplayDkp.getEtitle());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			lstImage.add(image);
		}
		home.put("slides", lstImage);
		
		//获取热销品牌信息
		List<BrandHot> lstBrandHot = goodsService.selectBrandHot(YamiConstant.CHANNEL_PAGE_3, null,null);
		List<Object> lstBrandHots = new ArrayList<Object>();
		Map<String,Object> mapBrandHot = new HashMap<String,Object>();
		for(BrandHot brandHot:lstBrandHot){
			mapBrandHot = new HashMap<String,Object>();
			mapBrandHot.put("brand_id", brandHot.getBrandId());
			mapBrandHot.put("name", brandHot.getBrandName());
			mapBrandHot.put("ename", brandHot.getBrandEname());
			mapBrandHot.put("logo",  YamiConstant.BRAND_LOGO_URL+brandHot.getBrandLogo());
			lstBrandHots.add(mapBrandHot);
		}
		home.put("hotBrands", lstBrandHots);		

		//获得热销商品
		Map<String, Object> mapHotItems  = selectHotItems(token,YamiConstant.CHANNEL_PAGE_3);
		home.put("hotItems", mapHotItems.get("items"));
		
		
		//获取各分类下信息
		//获取首页需显示的顶级分类
		 List<CategoryForShow> lstCat = goodsService.selectShowCategory4Channel3();
		 List<Object> lstcatInfo = new ArrayList<Object>();
		 Map<String,Object> catInfo = new HashMap<String,Object> ();
		 for(CategoryForShow categoryForShow:lstCat){
			 catInfo = new HashMap<String,Object> ();
			 catInfo.put("cat_id", categoryForShow.getCat_id());
			 //获取分类关键字信息
			 List<Keywords> lstKeywords = goodsService.selectKeywords(categoryForShow.getCat_id(), YamiConstant.INDEX_KEYWORDS_DISPLAY_PRIORITY, YamiConstant.DKP_CHANNEL_PAGE_3_KEYWORDS_DISPLAY_NUMBER);
			 List<Object> keywords = new ArrayList<Object>();
			 Map<String,Object> keyword = new HashMap<String,Object> ();
			 for(Keywords keywordTemp:lstKeywords){
				 keyword = new HashMap<String,Object> ();
				 keyword   = new HashMap<String,Object>();
				 keyword.put("key_id", keywordTemp.getKeyId());
				 keyword.put("key_name", keywordTemp.getKeyName());
				 keyword.put("key_ename", keywordTemp.getKeyEname());
				 keywords.add(keyword);
		     } 
			 catInfo.put("keywords", keywords);
			//获取分类新商品信息
			 List<GoodsDisplayDkp> lstGoodsDisplayApp = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_3,YamiConstant.CHANNEL_PAGE_3_CAT_NEW_ITEM_SECTION,categoryForShow.getCat_id(),YamiConstant.DISPLAY_DATA_TYPE_1,YamiConstant.DKP_CHANNEL_PAGE_3_CAT_DISPLAY_GOODS_START, YamiConstant.DKP_CHANNEL_PAGE_3_CAT_DISPLAY_GOODS_LENGTH);
			 Map<String,Object> item = new HashMap<String,Object>();
			 List<Object> items = new ArrayList<Object>();
			 for(GoodsDisplayDkp goods:lstGoodsDisplayApp){
				 if(goods.getSection()==YamiConstant.CHANNEL_PAGE_3_CAT_NEW_ITEM_SECTION){
				    basic = new HashMap<String,Object>();
					basic.put("name", goods.getGoodsName());
					basic.put("ename", goods.getGoodsEname());
					basic.put("is_promote", goods.getIsPromote()?1:0);
					basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
					basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
					basic.put("currency", "$");
					basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
					item = new HashMap<String,Object>();
					item.put("gid", goods.getId());
					item.put("basic", basic);
					items.add(item);	
				 }
			 }
			 catInfo.put("catNewItems", items);
			 lstcatInfo.add(catInfo);
		 }
		home.put("catInfo", lstcatInfo);
		//result.put("token", token);
		result.put("home", home);
		return result;
	}
	/*
	 获取生活馆信息(DKP)
	@param String token 
	@return Map<String,Object> 生活馆信息(DKP)
	*/	
	public  Map<String,Object> getChannelElectronicsInfoDkp(String token){
		Map<String,Object> result   = new HashMap<String,Object>();
		Map<String,Object> home   = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		//获取滚动图片信息
		List<GoodsDisplayDkp> imageOfIndex = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_5, YamiConstant.INDEX_SLIDES_IMAGE_SECTION,null,null,null, null);
		Map<String,Object> image = new HashMap<String,Object>();
		List<Object> lstImage = new ArrayList<Object>();
		for(GoodsDisplayDkp goodsDisplayDkp:imageOfIndex){
			image = new HashMap<String,Object>();
			image.put("type", goodsDisplayDkp.getType());
			
			if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
				image.put("value", goodsDisplayDkp.getId());
				basic   = new HashMap<String,Object>();
				basic.put("name", goodsDisplayDkp.getGoodsName());
				basic.put("ename", goodsDisplayDkp.getGoodsEname());
				basic.put("is_promote", goodsDisplayDkp.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goodsDisplayDkp.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goodsDisplayDkp.getShopPrice()));
				basic.put("currency", "$");
				image.put("basic", basic);
				image.put("image",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
				image.put("eimage",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
			}else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  brand = new HashMap<String, Object>();
				brand.put("name",goodsDisplayDkp.getBrandName());
				brand.put("ename",goodsDisplayDkp.getBrandEname());
				image.put("brand", brand);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  cat = new HashMap<String, Object>();
				cat.put("name",goodsDisplayDkp.getCatName());
				cat.put("ename",goodsDisplayDkp.getCatEname());
				image.put("cat", cat);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}

			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
				image.put("value", goodsDisplayDkp.getSearch());
				image.put("evalue", goodsDisplayDkp.getEsearch());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_0){
				image.put("url",   goodsDisplayDkp.getUrl());
				image.put("title",  goodsDisplayDkp.getTitle());
				image.put("etitle",  goodsDisplayDkp.getEtitle());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			lstImage.add(image);
		}
		home.put("slides", lstImage);
		
		

		//获得热销商品
		Map<String, Object> mapHotItems  = selectHotItems(token,YamiConstant.CHANNEL_PAGE_5);
		home.put("hotItems", mapHotItems.get("items"));
		
		
		//获取各分类下信息
		//获取首页需显示的顶级分类
		 List<CategoryForShow> lstCat = goodsService.selectShowCategory4Channel5();
		 List<Object> lstcatInfo = new ArrayList<Object>();
		 Map<String,Object> catInfo = new HashMap<String,Object> ();
		 for(CategoryForShow categoryForShow:lstCat){
			 catInfo = new HashMap<String,Object> ();
			 catInfo.put("cat_id", categoryForShow.getCat_id());
//			 //获取分类关键字信息
//			 List<Keywords> lstKeywords = goodsService.selectKeywords(categoryForShow.getCat_id(), YamiConstant.INDEX_KEYWORDS_DISPLAY_PRIORITY, YamiConstant.DKP_CHANNEL_PAGE_3_KEYWORDS_DISPLAY_NUMBER);
//			 List<Object> keywords = new ArrayList<Object>();
//			 Map<String,Object> keyword = new HashMap<String,Object> ();
//			 for(Keywords keywordTemp:lstKeywords){
//				 keyword = new HashMap<String,Object> ();
//				 keyword   = new HashMap<String,Object>();
//				 keyword.put("key_id", keywordTemp.getKeyId());
//				 keyword.put("key_name", keywordTemp.getKeyName());
//				 keyword.put("key_ename", keywordTemp.getKeyEname());
//				 keywords.add(keyword);
//		     } 
//			 catInfo.put("keywords", keywords);
			//获取分类新商品信息
			 List<GoodsDisplayDkp> lstGoodsDisplayApp = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_5,YamiConstant.CHANNEL_PAGE_5_CAT_NEW_ITEM_SECTION,categoryForShow.getCat_id(),YamiConstant.DISPLAY_DATA_TYPE_1,YamiConstant.DKP_CHANNEL_PAGE_5_CAT_DISPLAY_GOODS_START, YamiConstant.DKP_CHANNEL_PAGE_5_CAT_DISPLAY_GOODS_LENGTH);
			 Map<String,Object> item = new HashMap<String,Object>();
			 List<Object> items = new ArrayList<Object>();
			 for(GoodsDisplayDkp goods:lstGoodsDisplayApp){
				 if(goods.getSection()==YamiConstant.CHANNEL_PAGE_5_CAT_NEW_ITEM_SECTION){
				    basic = new HashMap<String,Object>();
					basic.put("name", goods.getGoodsName());
					basic.put("ename", goods.getGoodsEname());
					basic.put("is_promote", goods.getIsPromote()?1:0);
					basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
					basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
					basic.put("currency", "$");
					basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
					item = new HashMap<String,Object>();
					item.put("gid", goods.getId());
					item.put("basic", basic);
					items.add(item);	
				 }
			 }
			 catInfo.put("catNewItems", items);
			 lstcatInfo.add(catInfo);
		 }
		home.put("catInfo", lstcatInfo);
		//result.put("token", token);
		result.put("home", home);
		return result;
	}
	/*
	 获取美食馆信息(DKP)
	@param String token 
	@return Map<String,Object> 美食馆信息(DKP)
	*/	
	public  Map<String,Object> getChannelSnackInfoDkp(String token){
		Map<String,Object> result   = new HashMap<String,Object>();
		Map<String,Object> home   = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		//获取滚动图片信息
		List<GoodsDisplayDkp> imageOfIndex = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_2, YamiConstant.INDEX_SLIDES_IMAGE_SECTION,null,null,null, null);
		Map<String,Object> image = new HashMap<String,Object>();
		List<Object> lstImage = new ArrayList<Object>();
		for(GoodsDisplayDkp goodsDisplayDkp:imageOfIndex){
			image = new HashMap<String,Object>();
			image.put("type", goodsDisplayDkp.getType());
			
			if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
				image.put("value", goodsDisplayDkp.getId());
				basic   = new HashMap<String,Object>();
				basic.put("name", goodsDisplayDkp.getGoodsName());
				basic.put("ename", goodsDisplayDkp.getGoodsEname());
				basic.put("is_promote", goodsDisplayDkp.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goodsDisplayDkp.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goodsDisplayDkp.getShopPrice()));
				basic.put("currency", "$");
				image.put("basic", basic);
				image.put("image",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
				image.put("eimage",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
			}else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  brand = new HashMap<String, Object>();
				brand.put("name",goodsDisplayDkp.getBrandName());
				brand.put("ename",goodsDisplayDkp.getBrandEname());
				image.put("brand", brand);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  cat = new HashMap<String, Object>();
				cat.put("name",goodsDisplayDkp.getCatName());
				cat.put("ename",goodsDisplayDkp.getCatEname());
				image.put("cat", cat);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}

			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
				image.put("value", goodsDisplayDkp.getSearch());
				image.put("evalue", goodsDisplayDkp.getEsearch());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_0){
				image.put("url",   goodsDisplayDkp.getUrl());
				image.put("title",  goodsDisplayDkp.getTitle());
				image.put("etitle",  goodsDisplayDkp.getEtitle());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			lstImage.add(image);
		}
		home.put("slides", lstImage);
		//获取新品尝鲜
		List<GoodsDisplayDkp> lstNewItems = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_2, YamiConstant.CHANNEL_PAGE_2_NEW_ITEM_SECTION,null,null,null, null);
		Map<String,Object> newItem = new HashMap<String,Object>();
		 List<Object> newItems = new ArrayList<Object>();
		 for(GoodsDisplayDkp goods:lstNewItems){
			 if(goods.getSection()==YamiConstant.CHANNEL_PAGE_2_NEW_ITEM_SECTION){
			    basic = new HashMap<String,Object>();
				basic.put("name", goods.getGoodsName());
				basic.put("ename", goods.getGoodsEname());
				basic.put("is_promote", goods.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("currency", "$");
				basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				newItem = new HashMap<String,Object>();
				newItem.put("gid", goods.getId());
				newItem.put("basic", basic);
				newItems.add(newItem);	
			 }
		 }
		 home.put("newItems", newItems);	
		
		
		

		//获得热销商品
		Map<String, Object> mapHotItems  = selectHotItems(token,YamiConstant.CHANNEL_PAGE_2);
		home.put("hotItems", mapHotItems.get("items"));
		
		
		//获取各分类下信息
		//获取首页需显示的顶级分类
		 List<CategoryForShow> lstCat = goodsService.selectShowCategory4Channel2();
		 List<Object> lstcatInfo = new ArrayList<Object>();
		 Map<String,Object> catInfo = new HashMap<String,Object> ();
		 for(CategoryForShow categoryForShow:lstCat){
			 catInfo = new HashMap<String,Object> ();
			 catInfo.put("cat_id", categoryForShow.getCat_id());
			 //获取分类关键字信息
			 List<Keywords> lstKeywords = goodsService.selectKeywords(categoryForShow.getCat_id(), YamiConstant.INDEX_KEYWORDS_DISPLAY_PRIORITY, YamiConstant.DKP_CHANNEL_PAGE_2_KEYWORDS_DISPLAY_NUMBER);
			 List<Object> keywords = new ArrayList<Object>();
			 Map<String,Object> keyword = new HashMap<String,Object> ();
			 for(Keywords keywordTemp:lstKeywords){
				 keyword = new HashMap<String,Object> ();
				 keyword   = new HashMap<String,Object>();
				 keyword.put("key_id", keywordTemp.getKeyId());
				 keyword.put("key_name", keywordTemp.getKeyName());
				 keyword.put("key_ename", keywordTemp.getKeyEname());
				 keywords.add(keyword);
		     } 
			 catInfo.put("keywords", keywords);
			//获取分类新商品信息
			 List<GoodsDisplayDkp> lstGoodsDisplayApp = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_2,YamiConstant.CHANNEL_PAGE_2_CAT_NEW_ITEM_SECTION,categoryForShow.getCat_id(),YamiConstant.DISPLAY_DATA_TYPE_1,YamiConstant.DKP_CHANNEL_PAGE_2_CAT_DISPLAY_GOODS_START, YamiConstant.DKP_CHANNEL_PAGE_2_CAT_DISPLAY_GOODS_LENGTH);
			 Map<String,Object> item = new HashMap<String,Object>();
			 List<Object> items = new ArrayList<Object>();
			 for(GoodsDisplayDkp goods:lstGoodsDisplayApp){
				 if(goods.getSection()==YamiConstant.CHANNEL_PAGE_2_CAT_NEW_ITEM_SECTION){
				    basic = new HashMap<String,Object>();
					basic.put("name", goods.getGoodsName());
					basic.put("ename", goods.getGoodsEname());
					basic.put("is_promote", goods.getIsPromote()?1:0);
					basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
					basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
					basic.put("currency", "$");
					basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
					item = new HashMap<String,Object>();
					item.put("gid", goods.getId());
					item.put("basic", basic);
					items.add(item);	
				 }
			 }
			 catInfo.put("catNewItems", items);
			 lstcatInfo.add(catInfo);
		 }
		home.put("catInfo", lstcatInfo);
		//result.put("token", token);
		result.put("home", home);
		return result;
	}
	/*
	 获取养生馆信息(DKP)
	@param String token 
	@return Map<String,Object> 养生馆信息(DKP)
	*/	
	public  Map<String,Object> getChannelHealthInfoDkp(String token){
		Map<String,Object> result   = new HashMap<String,Object>();
		Map<String,Object> home   = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		//获取滚动图片信息
		List<GoodsDisplayDkp> imageOfIndex = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_4, YamiConstant.INDEX_SLIDES_IMAGE_SECTION,null,null,null, null);
		Map<String,Object> image = new HashMap<String,Object>();
		List<Object> lstImage = new ArrayList<Object>();
		for(GoodsDisplayDkp goodsDisplayDkp:imageOfIndex){
			image = new HashMap<String,Object>();
			image.put("type", goodsDisplayDkp.getType());
			
			if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
				image.put("value", goodsDisplayDkp.getId());
				basic   = new HashMap<String,Object>();
				basic.put("name", goodsDisplayDkp.getGoodsName());
				basic.put("ename", goodsDisplayDkp.getGoodsEname());
				basic.put("is_promote", goodsDisplayDkp.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goodsDisplayDkp.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goodsDisplayDkp.getShopPrice()));
				basic.put("currency", "$");
				image.put("basic", basic);
				image.put("image",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
				image.put("eimage",  goodsDisplayDkp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage():YamiConstant.IMAGE_URL+goodsDisplayDkp.getGoodsThumb());
			}else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  brand = new HashMap<String, Object>();
				brand.put("name",goodsDisplayDkp.getBrandName());
				brand.put("ename",goodsDisplayDkp.getBrandEname());
				image.put("brand", brand);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
				image.put("value", goodsDisplayDkp.getId());
				Map<String,Object>  cat = new HashMap<String, Object>();
				cat.put("name",goodsDisplayDkp.getCatName());
				cat.put("ename",goodsDisplayDkp.getCatEname());
				image.put("cat", cat);
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}

			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
				image.put("value", goodsDisplayDkp.getSearch());
				image.put("evalue", goodsDisplayDkp.getEsearch());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			else if(goodsDisplayDkp.getType()==YamiConstant.DISPLAY_DATA_TYPE_0){
				image.put("url",   goodsDisplayDkp.getUrl());
				image.put("title",  goodsDisplayDkp.getTitle());
				image.put("etitle",  goodsDisplayDkp.getEtitle());
				image.put("image",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+goodsDisplayDkp.getEimage());
			}
			lstImage.add(image);
		}
		home.put("slides", lstImage);
	
	

		//获得热销商品
		Map<String, Object> mapHotItems  = selectHotItems(token,YamiConstant.CHANNEL_PAGE_4);
		home.put("hotItems", mapHotItems.get("items"));
		
		
		//获取各分类下信息
		//获取首页需显示的顶级分类
		 List<CategoryForShow> lstCat = goodsService.selectShowCategory4Channel4();
		 List<Object> lstcatInfo = new ArrayList<Object>();
		 Map<String,Object> catInfo = new HashMap<String,Object> ();
		 for(CategoryForShow categoryForShow:lstCat){
			 catInfo = new HashMap<String,Object> ();
			 catInfo.put("cat_id", categoryForShow.getCat_id());

			//获取分类新商品信息
			 List<GoodsDisplayDkp> lstGoodsDisplayApp = goodsService.selectGoodsDkpEdit(YamiConstant.CHANNEL_PAGE_4,YamiConstant.CHANNEL_PAGE_4_CAT_NEW_ITEM_SECTION,categoryForShow.getCat_id(),YamiConstant.DISPLAY_DATA_TYPE_1,YamiConstant.DKP_CHANNEL_PAGE_4_CAT_DISPLAY_GOODS_START, YamiConstant.DKP_CHANNEL_PAGE_4_CAT_DISPLAY_GOODS_LENGTH);
			 Map<String,Object> item = new HashMap<String,Object>();
			 List<Object> items = new ArrayList<Object>();
			 for(GoodsDisplayDkp goods:lstGoodsDisplayApp){
				 if(goods.getSection()==YamiConstant.CHANNEL_PAGE_4_CAT_NEW_ITEM_SECTION){
				    basic = new HashMap<String,Object>();
					basic.put("name", goods.getGoodsName());
					basic.put("ename", goods.getGoodsEname());
					basic.put("is_promote", goods.getIsPromote()?1:0);
					basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
					basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
					basic.put("currency", "$");
					basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
					item = new HashMap<String,Object>();
					item.put("gid", goods.getId());
					item.put("basic", basic);
					items.add(item);	
				 }
			 }
			 catInfo.put("catNewItems", items);
			 lstcatInfo.add(catInfo);
		 }
		home.put("catInfo", lstcatInfo);
		//result.put("token", token);
		result.put("home", home);
		return result;
	}
	/*
	 获取商品评论信息
	@param String token 
	@param int gid 
	@param int start 默认为0。当为0时服务会回复总评分数和评论数。
	@param int length 取回多少条评论。默认为1。
	@return Map<String,Object> 评论信息
	*/	
	public  Map<String,Object> getItemComments(String token,int gid,int start,int length){
		Map<String,Object> result = new HashMap<String,Object>();
		List<Object> lstComments = new ArrayList<Object>();
		Map<String,Object> comment = new HashMap<String,Object>();
		List<GoodsComment> lstComment = goodsService.selectGoodsComment(gid, start, length);
		for(GoodsComment goodsComment:lstComment){
			comment = new HashMap<String,Object>();
			if(null!=goodsComment.getAvatar()){
				comment.put("avatar", YamiConstant.IMAGE_URL+goodsComment.getAvatar());
			}else{
				comment.put("avatar", YamiConstant.DEFULT_IMAGE_GOODS_COMMENT_USER);
			}
			comment.put("username",goodsComment.getUsername());
			comment.put("rate",goodsComment.getRate());
			comment.put("date",DateUtil.formateUTC(goodsComment.getDate()));
			comment.put("message",goodsComment.getMessage());
			lstComments.add(comment);
		}
		
			int count = goodsService.selectGoodsCommentCount(gid);
			BigDecimal rateTemp = new BigDecimal(goodsService.selectGoodsCommentRate(gid));
			BigDecimal rate = new BigDecimal(0.0);
			
			if(rateTemp.compareTo( new BigDecimal(0.0))>0){
			rate = rateTemp.divide(new BigDecimal(count),1,BigDecimal.ROUND_HALF_UP);
			}
			result.put("rate", rate);
			result.put("count", count);
		
		result.put("token", token);
		result.put("comments", lstComments);
		result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		
		
		
		
		return result;
	}
	
	
	/*
	 获取用户收藏夹列表，帮助用户删除下架和删除的商品。
	@param String token 
	@param int start 默认为0
	@param int length 默认为1。
	@return Map<String,Object> 收藏夹商品信息
	*/	
	public  Map<String,Object> getUserFavorites(String token,int start,int length){
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		Map<String,Object> result = new HashMap<String,Object>();
		List<Object> lstItem = new ArrayList<Object>();
		Map<String,Object> item = new HashMap<String,Object>();
		List<Goods>  lstGoods = collectGoodsService.selectGoodsByUid(Integer.parseInt(tokenIn.getData()), start, length);
		for(Goods goods:lstGoods){
			item = new HashMap<String,Object>();
			item.put("goods_id", goods.getGoodsId());
			item.put("goods_name", goods.getGoodsName());
			item.put("goods_ename", goods.getGoodsEname());
			item.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
			item.put("is_promote", goods.getIsPromote()?1:0);
			item.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
			if(goods.getGoodsNumber()>0){
				item.put("is_oos",0);
			}else{
				item.put("is_oos",1);
			}
			item.put("image", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
			lstItem.add(item);
		}
		int count = collectGoodsService.selectGoodsCountByUid(Integer.parseInt(tokenIn.getData()));
		result.put("token", token);
		result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		result.put("items", lstItem);
		List<Goods>  lstGoodNotSale = collectGoodsService.selectGoodsOfNotSaleByUid(Integer.parseInt(tokenIn.getData()));
		List<Integer> lstGoodsId = new ArrayList<Integer>();
		for(Goods goods:lstGoodNotSale){
			lstGoodsId.add(goods.getGoodsId());
		}
		transactionDelegate.transactionRemoveFromFavorites(Integer.parseInt(tokenIn.getData()), lstGoodsId);
		
		return result;
	}
	
	
	/*
	 获取本周特价商品列表（读）
	@param String token 
	@param int start 默认为0
	@param int length 默认为1。
	@return Map<String,Object> 本周特价商品列表
	*/	
	public  Map<String,Object> getWeekItems(String token,int start,int length)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		List<Object> lstItem = new ArrayList<Object>();
		Map<String,Object> item = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		List<Goods> lstGoods = goodsService.selectGoodsWeekly(DateUtil.getNowLong(), start, length);
		int count = goodsService.selectGoodsWeeklyCount(DateUtil.getNowLong());
		
		 for(Goods goods:lstGoods){
			    basic = new HashMap<String,Object>();
				basic.put("name", goods.getGoodsName());
				basic.put("ename", goods.getGoodsEname());
				basic.put("is_promote", goods.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("currency", "$");
				basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				item = new HashMap<String,Object>();
				item.put("gid", goods.getGoodsId());
				item.put("basic", basic);
				lstItem.add(item);	 
		 }
		 result.put("token", token);
		 result.put("items", lstItem);
		 result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		return result;
	}
	/*
	获取折扣商品列表（读）
	@param String token 
	@param int start 默认为0
	@param int length 默认为1。
	@return Map<String,Object> 折扣商品列表
	*/	
	public  Map<String,Object> getPromoteItems(String token,int start,int length)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		List<Object> lstItem = new ArrayList<Object>();
		Map<String,Object> item = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		List<Goods> lstGoods = goodsService.selectGoodsPromote(DateUtil.getNowLong(), start, length);
		int count = goodsService.selectGoodsPromoteCount(DateUtil.getNowLong());

		 for(Goods goods:lstGoods){
			    basic = new HashMap<String,Object>();
				basic.put("name", goods.getGoodsName());
				basic.put("ename", goods.getGoodsEname());
				basic.put("is_promote", goods.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("currency", "$");
				basic.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
				basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				basic.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
				item = new HashMap<String,Object>();
				item.put("gid", goods.getGoodsId());
				item.put("basic", basic);
				lstItem.add(item);	 
		 }
		 result.put("token", token);
		 result.put("items", lstItem);
		 result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		return result;
	}
	
	/*
	获取折扣商品列表 V2.0（读）
	@param String token 
	@param int start 默认为0
	@param int length 默认为1。
	@return Map<String,Object> 折扣商品列表
	*/	
	public  Map<String,Object> getPromoteItemsV2(String token,Integer cat_id,Integer sort_by,Integer sort_order,int start,int length)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		List<Object> lstItem = new ArrayList<Object>();
		Map<String,Object> item = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		List<Goods> lstGoods = goodsService.selectGoodsPromoteV2(cat_id,sort_by,sort_order,DateUtil.getNowLong(), start, length);
		int count = goodsService.selectGoodsPromoteCountV2(cat_id,DateUtil.getNowLong());

		 for(Goods goods:lstGoods){
			    basic = new HashMap<String,Object>();
				basic.put("name", goods.getGoodsName());
				basic.put("ename", goods.getGoodsEname());
				basic.put("is_promote", goods.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("currency", "$");
				basic.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
				basic.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				basic.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
				item = new HashMap<String,Object>();
				item.put("gid", goods.getGoodsId());
				item.put("basic", basic);
				lstItem.add(item);	 
		 }
		 result.put("token", token);
		 result.put("items", lstItem);
		 result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		return result;
	}
	
	/*
	获取发现页信息（读）
	@param String token 
	@return Map<String,Object> 信息列表
	*/	
	public  Map<String,Object> getExploreInfo(String token){
		Map<String,Object> result = new HashMap<String,Object>();
		 List<Object> lstExplore = new ArrayList<Object>();
		Map<String,Object> explore = new HashMap<String,Object>();
		 List<GoodsDisplayApp> lstGoodsDisplayApp = goodsService.selectGoodsEdit(YamiConstant.DISCOVER_PAGE, null,null,null,null, null);
		 List<Object> lstKey = new ArrayList<Object>();
		 Map<String,Object> mapKey = new HashMap<String,Object>();
		 Map<String,Object> key = new HashMap<String,Object>();
		 List<Object> lstImage = new ArrayList<Object>();
		 Map<String,Object> mapImage = new HashMap<String,Object>();
		 Map<String,Object> image = new HashMap<String,Object>();
		 Map<String,Object> basic = new HashMap<String,Object>();
		 Map<String,Object> brand = new HashMap<String,Object>();
		 Map<String,Object> cat = new HashMap<String,Object>();
		for(GoodsDisplayApp goodsDisplayApp:lstGoodsDisplayApp){
			key = new HashMap<String,Object>();
			if(goodsDisplayApp.getSection()==YamiConstant.DISCOVER_KEY_SECTION){
				key.put("type", goodsDisplayApp.getType());
				if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
					key.put("value", goodsDisplayApp.getId());
					key.put("name", goodsDisplayApp.getGoodsName());
					key.put("ename", goodsDisplayApp.getGoodsEname());
				}else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
					key.put("value", goodsDisplayApp.getId());
					key.put("name", goodsDisplayApp.getBrandName());
					key.put("ename", goodsDisplayApp.getBrandEname());
				}else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
					key.put("value", goodsDisplayApp.getId());
					key.put("name", goodsDisplayApp.getCatName());
					key.put("ename", goodsDisplayApp.getCatEname());
				}else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
					key.put("value", goodsDisplayApp.getSearch());
					key.put("evalue", goodsDisplayApp.getEsearch());
				}
				if(mapKey.containsKey(goodsDisplayApp.getCatId().toString())){
					lstKey = (List<Object>)mapKey.get(goodsDisplayApp.getCatId().toString());
					lstKey.add(key);
					mapKey.put(goodsDisplayApp.getCatId().toString(), lstKey);
				}else{
					lstKey = new ArrayList<Object>();
					lstKey.add(key);
					mapKey.put(goodsDisplayApp.getCatId().toString(), lstKey);
				}
			}
			
			image = new HashMap<String,Object>();
			if(goodsDisplayApp.getSection()==YamiConstant.DISCOVER_IMAGE_SECTION){
				image.put("type", goodsDisplayApp.getType());
				if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
					image.put("value", goodsDisplayApp.getId());
					basic = new HashMap<String,Object>();
					basic.put("name", goodsDisplayApp.getGoodsName());
					basic.put("ename", goodsDisplayApp.getGoodsEname());
					basic.put("is_promote", goodsDisplayApp.getIsPromote()?1:0);
					basic.put("promote_price", StringUtil.formatPrice(goodsDisplayApp.getPromotePrice()));
					basic.put("shop_price", StringUtil.formatPrice(goodsDisplayApp.getShopPrice()));
					basic.put("currency", "$");
//					basic.put("image", YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
					image.put("basic", basic);
					image.put("image", goodsDisplayApp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayApp.getImage():YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
					image.put("eimage", goodsDisplayApp.getIsImage()==1?YamiConstant.IMAGE_URL+goodsDisplayApp.getImage():YamiConstant.IMAGE_URL+goodsDisplayApp.getGoodsThumb());
				}else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
					image.put("value", goodsDisplayApp.getId());
					brand = new HashMap<String,Object>();
					brand.put("name", goodsDisplayApp.getBrandName());
					brand.put("ename", goodsDisplayApp.getBrandEname());
					image.put("brand", brand);
					image.put("image", YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
					image.put("eimage", YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
				}else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
					image.put("value", goodsDisplayApp.getId());
					cat = new HashMap<String,Object>();
					cat.put("name", goodsDisplayApp.getCatName());
					cat.put("ename", goodsDisplayApp.getCatEname());
					image.put("cat", cat);
					image.put("image", YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
					image.put("eimage", YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
				}else if(goodsDisplayApp.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
					image.put("value", goodsDisplayApp.getSearch());
					image.put("evalue", goodsDisplayApp.getEsearch());
					image.put("image", YamiConstant.IMAGE_URL+goodsDisplayApp.getImage());
					image.put("eimage", YamiConstant.IMAGE_URL+goodsDisplayApp.getEimage());
				}	
				
				if(mapImage.containsKey(goodsDisplayApp.getCatId().toString())){
					lstImage = (List<Object>)mapImage.get(goodsDisplayApp.getCatId().toString());
					lstImage.add(image);
					mapImage.put(goodsDisplayApp.getCatId().toString(), lstImage);
				}else{
					lstImage = new ArrayList<Object>();
					lstImage.add(image);
					mapImage.put(goodsDisplayApp.getCatId().toString(), lstImage);
				}	
			}
			
		}
		
		
			explore = new HashMap<String,Object>();
			explore.put("cat_id", YamiConstant.TOP_CAT_ID_1);
			explore.put("key", mapKey.get(String.valueOf(YamiConstant.TOP_CAT_ID_1)));
			explore.put("image", mapImage.get(String.valueOf(YamiConstant.TOP_CAT_ID_1)));
			lstExplore.add(explore);
			explore = new HashMap<String,Object>();
			explore.put("cat_id", YamiConstant.TOP_CAT_ID_2);
			explore.put("key", mapKey.get(String.valueOf(YamiConstant.TOP_CAT_ID_2)));
			explore.put("image", mapImage.get(String.valueOf(YamiConstant.TOP_CAT_ID_2)));
			lstExplore.add(explore);
			explore = new HashMap<String,Object>();
			explore.put("cat_id", YamiConstant.TOP_CAT_ID_3);
			explore.put("key", mapKey.get(String.valueOf(YamiConstant.TOP_CAT_ID_3)));
			explore.put("image", mapImage.get(String.valueOf(YamiConstant.TOP_CAT_ID_3)));
			lstExplore.add(explore);
			explore = new HashMap<String,Object>();
			explore.put("cat_id", YamiConstant.TOP_CAT_ID_4);
			explore.put("key", mapKey.get(String.valueOf(YamiConstant.TOP_CAT_ID_4)));
			explore.put("image", mapImage.get(String.valueOf(YamiConstant.TOP_CAT_ID_4)));
			lstExplore.add(explore);
			
			
		//result.put("token", token);
		result.put("explore", lstExplore);
		return result;
	}
	
	/*
	推荐服务（读）
	@param String token 
	@return Map<String,Object> 信息列表
	*/	
	public Map<String, Object> getPersonalizedItems(String token,Integer gid,
			int start, int length) {
		Map<String, Object> result = new HashMap<String,Object>();
		List<Object>  items = new ArrayList<Object>();
		List<Goods> goodsTemp = new ArrayList<Goods>();
		int count = 0;
		if(null==gid){
				goodsTemp = goodsService.selectGoodsForNew(start, length);	
				count = goodsService.selectGoodsForNewCount();	
				for(Goods goods:goodsTemp)
				{
					Map<String,Object>  item = new HashMap<String, Object>();
					item.put("gid", goods.getGoodsId());
					Map<String,Object>  basic = new HashMap<String, Object>();
					basic.put("name",goods.getGoodsName());
					basic.put("ename",goods.getGoodsEname());
					basic.put("is_promote",goods.getIsPromote()?1:0);
					basic.put("shop_price",StringUtil.formatPrice(goods.getShopPrice()));
					basic.put("promote_price",StringUtil.formatPrice(goods.getPromotePrice()));
					basic.put("currency",YamiConstant.CURRENCY);
					basic.put("image",YamiConstant.IMAGE_URL+goods.getGoodsImg());
					basic.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
					basic.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
					basic.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
					item.put("basic", basic);
					items.add(item);
				}
		}else{
		
			goodsTemp = goodsService.selectPersonalizedGoods(gid, start, length);
			count = goodsService.selectPersonalizedGoodsCount(gid);	
			for(Goods goods:goodsTemp)
			{
				Map<String,Object>  item = new HashMap<String, Object>();
				item.put("gid", goods.getGoodsId());
				Map<String,Object>  basic = new HashMap<String, Object>();
				basic.put("name",goods.getGoodsName());
				basic.put("ename",goods.getGoodsEname());
				basic.put("is_promote",goods.getIsPromote()?1:0);
				basic.put("shop_price",StringUtil.formatPrice(goods.getShopPrice()));
				basic.put("promote_price",StringUtil.formatPrice(goods.getPromotePrice()));
				basic.put("currency",YamiConstant.CURRENCY);
				basic.put("image",YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
				basic.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				basic.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
				item.put("basic", basic);
				items.add(item);
			}
			
			
			
			
		}
		

		result.put("items", items);
		result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		result.put("token", token);
		return result;
		
	}
	
	/*
	浏览过的商品列表（读）
	@param String token 
	@param String gids
	@return Map<String,Object> 信息列表
	*/	
	public Map<String,Object> selectViewedItems(String token, String gids) throws IOException
	{
		Map<String,Object>  result = new HashMap<String, Object>();
		List<Object>  items = new ArrayList<Object>();
		
		result.put("token", token);
		
		String[] gidTemp = gids.split(",");
		
		int[] gid = new int[gidTemp.length];
		Goods goodsTemp[] = new Goods[gid.length];
		
		for(int x=0; x<gid.length; x++)
		{
			gid[x]=Integer.parseInt(gidTemp[x]);
			goodsTemp[x] = goodsService.selectByPrimaryKey(gid[x]);
		}
		
		
		
		for(int y=0; y<gid.length; y++)
		{			
			if(null==goodsTemp[y]||!goodsTemp[y].getIsOnSale()||goodsTemp[y].getIsDelete())
			{
				continue;
			}
			Map<String,Object>  item = new HashMap<String, Object>();
			item.put("gid", gid[y]);
			Map<String,Object>  basic = new HashMap<String, Object>();;		
			
			basic.put("name",goodsTemp[y].getGoodsName());
			basic.put("ename",goodsTemp[y].getGoodsEname());
			basic.put("is_promote",goodsTemp[y].getIsPromote()?1:0);
			basic.put("is_oos",goodsTemp[y].getGoodsNumber().intValue()>0?0:1);
			basic.put("promote_price",StringUtil.formatPrice(goodsTemp[y].getPromotePrice()));
			basic.put("shop_price",StringUtil.formatPrice(goodsTemp[y].getShopPrice()));
			basic.put("currency",YamiConstant.CURRENCY);
			basic.put("image",YamiConstant.IMAGE_URL+goodsTemp[y].getGoodsImg());
			item.put("basic", basic);
			items.add(item);
		}

		result.put("items", items);

		return result;
	}	
	
	/*
	获取热销商品列表（读）（缓）
	@param String token 
	@param int channel
	@return Map<String,Object> 信息列表
	*/	
	public Map<String,Object> selectHotItems(String token, int channel){
		Map<String,Object>  result = new HashMap<String, Object>();
		List<GoodsHot> lstGoodsHot = goodsService.selectGoodsHot(channel);
		List<Map<String,Object>> lstItems = new ArrayList<Map<String,Object>>();
		Map<String,Object> mapItem = new HashMap<String,Object>();
		Map<String,Object> mapBasic = new HashMap<String,Object>();
		for(GoodsHot goodsHot:lstGoodsHot){
			mapBasic = new HashMap<String,Object>();
			mapBasic.put("name", goodsHot.getGoodsName());
			mapBasic.put("ename", goodsHot.getGoodsEname());
			mapBasic.put("is_promote", goodsHot.getIsPromote()?1:0);
			mapBasic.put("promote_price", StringUtil.formatPrice(goodsHot.getPromotePrice()));
			mapBasic.put("shop_price", StringUtil.formatPrice(goodsHot.getShopPrice()));
			mapBasic.put("currency", "$");
			mapBasic.put("image",YamiConstant.IMAGE_URL+goodsHot.getGoodsImg());
			mapItem = new HashMap<String,Object>();
			mapItem.put("gid", goodsHot.getGoodsId());
			mapItem.put("Basic", mapBasic);
			lstItems.add(mapItem);
		}
		
		result.put("token", token);
		result.put("items", lstItems);
		return result;
	}	
	
	/*
	按品牌获取商品列表（读）
	@param String token 
	@return Map<String,Object> 信息列表
	*/	
	public Map<String, Object> selectBrandItems(String token, int brand_id, Integer sort_by, Integer sort_order, Integer page,String agent){
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
		Map<String, Object> result = new HashMap<String, Object>();
		List<Goods> lstGoodsBrand = goodsService.selectBrandItems(brand_id, sort_by, sort_order, pageSet.get("start"), pageSet.get("length"));
		int count = goodsService.selectBrandItemsCount(brand_id);
		List<Map<String,Object>> lstItems = new ArrayList<Map<String,Object>>();
		Map<String, Object> item = new HashMap<String, Object>();
		for(Goods goods:lstGoodsBrand){
			item = new HashMap<String, Object>();
			item.put("goods_id", goods.getGoodsId());
			item.put("goods_name", goods.getGoodsName());
			item.put("goods_ename", goods.getGoodsEname());
			item.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
			item.put("is_promote", goods.getIsPromote()?1:0);
			item.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
			item.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
			item.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
			item.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
			item.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
			item.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
			
			lstItems.add(item);
		}
		result.put("items", lstItems);
		result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(pageSet.get("length")))).intValue());
		result.put("page", page);
		result.put("token", token);
		

		return result;
	}
	
	/*
	按品牌获取商品列表（读）
	@param String token 
	@return Map<String,Object> 信息列表
	*/	
	public Map<String, Object> selectBrandInfo(String token, int brand_id){
		Map<String, Object> result = new HashMap<String, Object>();
		Brand brandInfo = goodsService.selectBrandInfo(brand_id);
		if(null==brandInfo){
			throw new YamiException(YamiConstant.ERRORCODE_ER1502,ErrorCodeEnum.ER1502.getMsg());			
		}
		Map<String, Object> brand = new HashMap<String, Object>();
		brand.put("bid", brandInfo.getBrandId());
		brand.put("name", brandInfo.getBrandName());
		brand.put("ename", brandInfo.getBrandEname());
		brand.put("logo", YamiConstant.BRAND_LOGO_URL+brandInfo.getBrandLogo());
		brand.put("index", brandInfo.getAlphabeticIndex());
		brand.put("attrId", brandInfo.getAttrId());
		brand.put("attrValue", brandInfo.getAttrValue());
		brand.put("attrEvalue", brandInfo.getAttrEvalue());
		result.put("brand", brand);
		result.put("token", token);
		return result;
	}
	
	/*
	品牌索引页信息列表（读）
	@param String token 
	@return Map<String,Object> 信息列表
	*/	
	public Map<String, Object> selectBrandIndex(String token, Integer cat_id,String index){
		Map<String, Object> result = new HashMap<String, Object>();
		if(null!=index){
			if("#".equals(index)){
				index = "OTHER";
			}
		}
		List<Brand> lstBrand = goodsService.selectBrands(cat_id, index);
		List<Object> lstResult = new ArrayList<Object>();
		Map<String,Object> mapIndex = new HashMap<String,Object>();
		Map<String,Object> mapBrands = new HashMap<String,Object>();
		Map<String,Object> mapBrand = new HashMap<String,Object>();
		String indexKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(Brand brand:lstBrand){
			mapBrand = new HashMap<String,Object>();
			mapBrand.put("brand_id", brand.getBrandId());
			mapBrand.put("brand_name", brand.getBrandName());
			mapBrand.put("brand_ename", brand.getBrandEname());
			mapBrand.put("index", brand.getAlphabeticIndex());
			mapBrand.put("cat_id", brand.getBrandCat());
			if(null!=brand.getAlphabeticIndex()&&!"".equals(brand.getAlphabeticIndex())){
				if(indexKey.contains(brand.getAlphabeticIndex())){
					if(mapIndex.containsKey(brand.getAlphabeticIndex())){
						mapBrands = (Map<String,Object>)mapIndex.get(brand.getAlphabeticIndex());
						mapBrands.put(brand.getBrandId().toString(), mapBrand);
						mapIndex.put(brand.getAlphabeticIndex(), mapBrands);
					}else{
						mapBrands = new HashMap<String,Object>();
						mapBrands.put(brand.getBrandId().toString(), mapBrand);
						mapIndex.put(brand.getAlphabeticIndex(), mapBrands);
					}
				}else{
					if(mapIndex.containsKey("#")){
						mapBrands = (Map<String,Object>)mapIndex.get("#");
						mapBrands.put(brand.getBrandId().toString(), mapBrand);
						mapIndex.put("#", mapBrands);
					}else{
						mapBrands = new HashMap<String,Object>();
						mapBrands.put(brand.getBrandId().toString(), mapBrand);
						mapIndex.put("#", mapBrands);
					}
				}
			}else{
				if(mapIndex.containsKey("#")){
					mapBrands = (Map<String,Object>)mapIndex.get("#");
					mapBrands.put(brand.getBrandId().toString(), mapBrand);
					mapIndex.put("#", mapBrands);
				}else{
					mapBrands = new HashMap<String,Object>();
					mapBrands.put(brand.getBrandId().toString(), mapBrand);
					mapIndex.put("#", mapBrands);
				}
			}
		}
		if(mapIndex.containsKey("A")){
			lstResult.add(mapIndex.get("A"));
		}
		if(mapIndex.containsKey("B")){
			lstResult.add(mapIndex.get("B"));
		}
		if(mapIndex.containsKey("C")){
			lstResult.add(mapIndex.get("C"));
		}
		if(mapIndex.containsKey("D")){
			lstResult.add(mapIndex.get("D"));
		}
		if(mapIndex.containsKey("E")){
			lstResult.add(mapIndex.get("E"));
		}
		if(mapIndex.containsKey("F")){
			lstResult.add(mapIndex.get("F"));
		}
		if(mapIndex.containsKey("G")){
			lstResult.add(mapIndex.get("G"));
		}
		if(mapIndex.containsKey("H")){
			lstResult.add(mapIndex.get("H"));
		}
		if(mapIndex.containsKey("I")){
			lstResult.add(mapIndex.get("I"));
		}
		if(mapIndex.containsKey("J")){
			lstResult.add(mapIndex.get("J"));
		}
		if(mapIndex.containsKey("K")){
			lstResult.add(mapIndex.get("K"));
		}
		if(mapIndex.containsKey("L")){
			lstResult.add(mapIndex.get("L"));
		}
		if(mapIndex.containsKey("M")){
			lstResult.add(mapIndex.get("M"));
		}
		if(mapIndex.containsKey("N")){
			lstResult.add(mapIndex.get("N"));
		}
		if(mapIndex.containsKey("O")){
			lstResult.add(mapIndex.get("O"));
		}
		if(mapIndex.containsKey("P")){
			lstResult.add(mapIndex.get("P"));
		}
		if(mapIndex.containsKey("Q")){
			lstResult.add(mapIndex.get("Q"));
		}
		if(mapIndex.containsKey("R")){
			lstResult.add(mapIndex.get("R"));
		}
		if(mapIndex.containsKey("S")){
			lstResult.add(mapIndex.get("S"));
		}
		if(mapIndex.containsKey("T")){
			lstResult.add(mapIndex.get("T"));
		}
		if(mapIndex.containsKey("U")){
			lstResult.add(mapIndex.get("U"));
		}
		if(mapIndex.containsKey("V")){
			lstResult.add(mapIndex.get("V"));
		}
		if(mapIndex.containsKey("W")){
			lstResult.add(mapIndex.get("W"));
		}
		if(mapIndex.containsKey("X")){
			lstResult.add(mapIndex.get("X"));
		}
		if(mapIndex.containsKey("Y")){
			lstResult.add(mapIndex.get("Y"));
		}
		if(mapIndex.containsKey("Z")){
			lstResult.add(mapIndex.get("Z"));
		}
		if(mapIndex.containsKey("#")){
			lstResult.add(mapIndex.get("#"));
		}
		result.put("brands", lstResult);
		result.put("token", token);
		return result;
	}
	
	
	/*
	 获取促销活动商品信息
	@param String token 
	@return Map<String,Object> 
	*/	
	public  Map<String,Object> getEventItems(String token,String goods_ids){
		
		Map<String,Object> result = new HashMap<String,Object>();
		List<Goods> lstGoods = goodsService.selectEventItems(goods_ids.split(","));
		List<Map<String,Object>> lstItems = new ArrayList<Map<String,Object>>();
		Map<String, Object> item = new HashMap<String, Object>();
		for(Goods goods:lstGoods){
			item = new HashMap<String, Object>();
			item.put("goods_id", goods.getGoodsId());
			item.put("goods_name", goods.getGoodsName());
			item.put("goods_ename", goods.getGoodsEname());
			item.put("shop_price", goods.getShopPrice());
			item.put("is_promote", goods.getIsPromote()?1:0);
			item.put("promote_price", goods.getPromotePrice());
			item.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
			item.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
			lstItems.add(item);
		}
		result.put("items", lstItems);
		
		result.put("token", token);
		
		return result;
		
	}
	/*
	 获取搜索栏广告信息
	@param String token 
	@return Map<String,Object> 
	*/	
	public  List<SearchBar> getAllSearchBar(){
		List<SearchBar> lstSearchBar  = goodsService.selectAllSearchBar();
		return lstSearchBar;
		
	}
	/*
	为商品信息补充分享链接数据
	@param String token 
	@return Map<String,Object> 
	*/	
	public  Map<String,Object> addShareUrlToItemsInfo(String token,Integer gid,Map<String,Object> itemInfo)throws Exception{
		

		itemInfo.put("shareUrl", StringUtil.makeShareUrl(token, gid));
		//itemInfo.put("shareUrl", "");

		
		return itemInfo;
		
	}
	
	
	
	/*
	 获取聚合页面商品信息
	@param String token 
	@return Map<String,Object> 
	*/	
	public  Map<String,Object> getAggregateItems(String token,Integer ag_id)throws Exception{
		
		Map<String,Object> result = new HashMap<String,Object>();
		List<GoodsAggregate> lstGoodsAggregate = goodsService.selectGoodsForAggregate(ag_id);
		List<Map<String,Object>> lstItems = new ArrayList<Map<String,Object>>();
		Map<String, Object> item = new HashMap<String, Object>();
		for(GoodsAggregate goodsAggregate:lstGoodsAggregate){
			if(null!=goodsAggregate.getGoods()){
				item = new HashMap<String, Object>();
				item.put("goods_id", goodsAggregate.getGoodsId());
				item.put("goods_name", goodsAggregate.getGoods().getGoodsName());
				item.put("goods_ename", goodsAggregate.getGoods().getGoodsEname());
				item.put("shop_price", StringUtil.formatPrice(goodsAggregate.getGoods().getShopPrice()));
				item.put("is_promote", StringUtil.checkPrice(goodsAggregate.getGoods())?1:0);
				item.put("promote_price", StringUtil.formatPrice(goodsAggregate.getGoods().getPromotePrice()));
				item.put("is_oos", goodsAggregate.getGoods().getGoodsNumber().intValue()>0?0:1);
				item.put("is_limited", goodsAggregate.getGoods().getIsLimited()?1:0);
				item.put("limited_number", goodsAggregate.getGoods().getLimitedNumber());
				item.put("limited_quantity", goodsAggregate.getGoods().getLimitedQuantity());
				
				item.put("image", YamiConstant.IMAGE_URL+goodsAggregate.getGoods().getGoodsImg());
				lstItems.add(item);
			}
		}
		result.put("items", lstItems);
		
		result.put("token", token);
		
		return result;
		
	}
	
	
	/*
	 获取聚合页面商品信息
	@param String token 
	@return Map<String,Object> 
	*/	
	public  Map<String,Object> checkRemindFlag(String token,int gid)throws Exception{
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		int countNum = userService.checkRemindFlag(uid, gid);
		if(countNum>0){
			User user = userService.selectUsersByID(uid);
			result.put("remindFlag", 1);
			result.put("email", user.getQuestion());
		}else{
			result.put("remindFlag", 0);
			result.put("email", "");
		}
		result.put("token", token);
		
		return result;
		
	}
	
	
	/*
	 验证指定商品对应的用户ZIP是否可以购买
	@param String token 
	@return Map<String,Object> 
	*/	
	public  Map<String,Object> checkZipcode(String token,int gid,String zip)throws Exception{ 
		Map<String,Object> result = new HashMap<String,Object>();
		boolean checkValue = false;
		//1、商品区域限购配置
		List<ShopDistrictZipcode> lstShopZipcodeLimit = this.getGoodsZipLimit(gid);
		//2、用户ZIP是否符合区域限购设定
		checkValue = DistrictCheck.goodsDistrictCheck(zip, lstShopZipcodeLimit);
		result.put("checkValue", checkValue?1:0);
		result.put("token", token);
		
		return result;
		
	}
	

	
	/*
	 获取发现消息信息
	@param String token 
	@param int currentIndex 当前数据位置
	@param int direction 0 显示历史消息 1显示新消息
	@return Map<String,Object> 
	*/	
	public  Map<String,Object> loadDiscoveryMessage(String token,int currentIndex,int direction,String agent)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Integer> pageSet = StringUtil.GetClientType4Discovery(currentIndex, agent);
		int starIndex = pageSet.get("start").intValue();
		int endIndex = starIndex + pageSet.get("length").intValue();
		
		
		List<DiscoveryInfo> lstDiscoveryInfo = new ArrayList<DiscoveryInfo>(); 
		List<DiscoveryInfo> lstDiscoveryInfoTemp = new ArrayList<DiscoveryInfo>(); 
		List<DiscoveryInfo> lstDiscoveryInfoOfTop = new ArrayList<DiscoveryInfo>(); 
		//获取置顶发现信息
		if(discoveryRedisService.checkAllTop()){
			lstDiscoveryInfoOfTop = discoveryRedisService.selectAllTop();
		}else{
			lstDiscoveryInfoOfTop = discoveryInfoService.selectDiscoveryInfosOfTop();
		}
		
		
		
		
		
		//是否存在更多历史数据  true存在 false不存在
		boolean hasMore = true;
		//1、显示最新发现数据
		if(direction==1){
			//1.1确定数据最新发现信息rec_id
			int maxRecIdDB = discoveryInfoService.selectMaxRecId();
			int maxRecIdRedis = 0;
			//1.2查看redis数据最新值
			if(discoveryRedisService.checkMaxRecId()){
				maxRecIdRedis = discoveryRedisService.selectMaxRecId();
			}else{
				//discoveryRedisService.insertMaxRecId(maxRecIdDB);
			}
			//1.3.1数据库最新值大于REDIS，取数据库信息，同时补充REDIS信息
			if(maxRecIdDB>maxRecIdRedis){
				//获取数据库发现数据最新值
				lstDiscoveryInfoTemp = discoveryInfoService.selectDiscoveryInfos(0, pageSet.get("length"));
				for(DiscoveryInfo discoveryInfo:lstDiscoveryInfoOfTop){
					lstDiscoveryInfo.add(discoveryInfo);
				}
				for(DiscoveryInfo discoveryInfo:lstDiscoveryInfoTemp){
					lstDiscoveryInfo.add(discoveryInfo);
				}
				
				
				
				//补充REDIS信息
				discoveryRedisService.insertMaxRecId(maxRecIdDB);
				for(DiscoveryInfo discoveryInfo:lstDiscoveryInfo){
					if(discoveryInfo.getIsTop().intValue()==0){
						discoveryRedisService.insert(discoveryInfo);
					}
					else{
						discoveryRedisService.insertTop(discoveryInfo);
					}
				}
				//检查是否还存在更久的历史信息
				if(maxRecIdDB<=pageSet.get("length")){
					hasMore = false;
				}
			}
			//1.3.2、取REDIS信息，进行处理
			else{
				//以信息的rec_id为索引，进行递减查询，需保证后台数据rec_id的连续性，当需要查询索引为负数，说明已经无更多历史数据，hasMore返回false
				for(int i=maxRecIdDB;i>maxRecIdDB - pageSet.get("length").intValue();i--){
					
					if(i<1){
						hasMore = false;
						break;
					}
					else{
						DiscoveryInfo discoveryInfo;
						if(discoveryRedisService.check(i)){
							discoveryInfo = discoveryRedisService.select(i);
						}else{
							discoveryInfo = discoveryInfoService.selectDiscoveryInfoByRecId(i);	
							if(null!=discoveryInfo){
								discoveryRedisService.insert(discoveryInfo);
							}else{
								
							}
						}
						lstDiscoveryInfo.add(discoveryInfo);
					}
				}
			}
		}
		//2、显示历史发现数据
		else{
			for(int i=currentIndex-1;i>currentIndex - pageSet.get("length").intValue();i--){
				
				if(i<1){
					hasMore = false;
					break;
				}
				else{
					DiscoveryInfo discoveryInfo;
					if(discoveryRedisService.check(i)){
						discoveryInfo = discoveryRedisService.select(i);
					}else{
						discoveryInfo = discoveryInfoService.selectDiscoveryInfoByRecId(i);	
						if(null!=discoveryInfo){
							discoveryRedisService.insert(discoveryInfo);
						}
					}
					lstDiscoveryInfo.add(discoveryInfo);
				}
			}
		}
		
		//3、整合返回结果
		result.put("token", token);
		result.put("hasMore", hasMore?1:0);
		result.put("message", formateDiscoveryInfo(lstDiscoveryInfo));
		
		return result;
		
	}
	
	
	/*
	 整合发现页返回信息
	@param String token 
	@param List<DiscoveryInfo> lstDiscoverInfo 查询结果数据
	@return Map<String,Object> 查询结果数据
	*/	
	private List<Map<String,Object>> formateDiscoveryInfo(List<DiscoveryInfo> lstDiscoverInfo)throws Exception{
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		Map<String,Object> mapDiscoveryInfo = new HashMap<String,Object>();
		Map<String,Object> mapDiscoveryDetail = new HashMap<String,Object>();
		List<Map<String,Object>> lstGoods = new ArrayList<Map<String,Object>>();
		Map<String,Object> mapGoods = new HashMap<String,Object>();
		
		for(DiscoveryInfo discoveryInfo:lstDiscoverInfo){
			mapDiscoveryInfo = new HashMap<String,Object>();
			mapDiscoveryInfo.put("rec_id", discoveryInfo.getRecId());
			mapDiscoveryInfo.put("is_top", discoveryInfo.getIsTop());
			mapDiscoveryInfo.put("msg_type", discoveryInfo.getMsgType());
			mapDiscoveryInfo.put("title", discoveryInfo.getTitle());
			mapDiscoveryInfo.put("etitle", discoveryInfo.getEtitle());
			mapDiscoveryInfo.put("image", YamiConstant.IMAGE_URL+discoveryInfo.getImage());
			mapDiscoveryInfo.put("eimage", YamiConstant.IMAGE_URL+discoveryInfo.getEimage());
			mapDiscoveryInfo.put("creat_time", discoveryInfo.getCreateTime());
			mapDiscoveryInfo.put("start_time", discoveryInfo.getStartTime());
			mapDiscoveryInfo.put("end_time", discoveryInfo.getEndTime());
			mapDiscoveryInfo.put("expire_time", discoveryInfo.getExpireTime());
			
			//1 公告
			if(discoveryInfo.getMsgType().intValue()==YamiConstant.DISCOVERY_MSG_TYPE_1){
			}
			// 2主题 
			else if(discoveryInfo.getMsgType().intValue()==YamiConstant.DISCOVERY_MSG_TYPE_2){
				//2.5指定活动
				if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_5){
					mapDiscoveryInfo.put("url", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryInfo.put("eurl", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
					}
					mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
				}
				
				//2.1 搜索
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_4){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}
				}
				//2.2品牌
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_2){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					Map<String,Object>  brand = new HashMap<String, Object>();
					brand.put("name",discoveryInfo.getDiscoveryDetail().getBrandName());
					brand.put("ename",discoveryInfo.getDiscoveryDetail().getBrandEname());
					
					mapDiscoveryDetail.put("brand", brand);
					
					
					
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}
				}
				//2.3分类
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_3){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					Map<String,Object>  cat = new HashMap<String, Object>();
					cat.put("name",discoveryInfo.getDiscoveryDetail().getCatName());
					cat.put("ename",discoveryInfo.getDiscoveryDetail().getCatEname());
					
					mapDiscoveryDetail.put("cat", cat);
					
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}	
				}
				//2.4单品
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_1){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					Map<String,Object>  topGoods = new HashMap<String, Object>();
					topGoods.put("name",discoveryInfo.getDiscoveryDetail().getGoodsName());
					topGoods.put("ename",discoveryInfo.getDiscoveryDetail().getGoodsEname());
					
					mapDiscoveryDetail.put("topItem", topGoods);
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}
					}
			}
			// 3达人评测 
			else if(discoveryInfo.getMsgType().intValue()==YamiConstant.DISCOVERY_MSG_TYPE_3){
				mapDiscoveryInfo.put("url", discoveryInfo.getDiscoveryDetail().getValue());
				mapDiscoveryInfo.put("eurl",discoveryInfo.getDiscoveryDetail().getEvalue());
				

				mapDiscoveryDetail = new HashMap<String,Object>();
				mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
				mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
				mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
				

				mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
			}
			// 4 米粉评论
			else if(discoveryInfo.getMsgType().intValue()==YamiConstant.DISCOVERY_MSG_TYPE_4){
				
				Message4Discovery message4Discovery = discoveryInfoService.selectMessage4Discovery(Integer.parseInt(discoveryInfo.getDiscoveryDetail().getValue()));
				
				mapDiscoveryDetail = new HashMap<String,Object>();
				mapDiscoveryDetail.put("goods_id", message4Discovery.getGoodsId());
				mapDiscoveryDetail.put("goods_name", message4Discovery.getGoodsName());
				mapDiscoveryDetail.put("goods_ename", message4Discovery.getGoodsEname());
				mapDiscoveryDetail.put("goods_img", YamiConstant.IMAGE_URL+message4Discovery.getGoodsImg());
				mapDiscoveryDetail.put("content", message4Discovery.getContent());
				mapDiscoveryDetail.put("rank", message4Discovery.getRank());
				mapDiscoveryInfo.put("detail", mapDiscoveryDetail);		
			}
			// 5活动 
			else if(discoveryInfo.getMsgType().intValue()==YamiConstant.DISCOVERY_MSG_TYPE_5){
				//2.5指定活动
				if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_5){
					mapDiscoveryInfo.put("url", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryInfo.put("eurl", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
					}
					mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
				}
				//2.1单品
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_4){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}
				}
				//2.2品牌
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_2){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					Map<String,Object>  brand = new HashMap<String, Object>();
					brand.put("name",discoveryInfo.getDiscoveryDetail().getBrandName());
					brand.put("ename",discoveryInfo.getDiscoveryDetail().getBrandEname());
					
					mapDiscoveryDetail.put("brand", brand);
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}

				}
				//2.3分类
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_3){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					Map<String,Object>  cat = new HashMap<String, Object>();
					cat.put("name",discoveryInfo.getDiscoveryDetail().getCatName());
					cat.put("ename",discoveryInfo.getDiscoveryDetail().getCatEname());
					
					mapDiscoveryDetail.put("cat", cat);
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}	

				}
				//2.4单品
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_1){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					Map<String,Object>  topGoods = new HashMap<String, Object>();
					topGoods.put("name",discoveryInfo.getDiscoveryDetail().getGoodsName());
					topGoods.put("ename",discoveryInfo.getDiscoveryDetail().getGoodsEname());
					
					mapDiscoveryDetail.put("topItem", topGoods);
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}
					}	
				
			
				
				
				
				
				
				
				
				
			}
			//  6新品
			else if(discoveryInfo.getMsgType().intValue()==YamiConstant.DISCOVERY_MSG_TYPE_6){
				//2.5指定活动
				if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_5){
					mapDiscoveryInfo.put("url", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryInfo.put("eurl", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
					}
					mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
				}
				//2.1 单品
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_4){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}
				}
				//2.2品牌
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_2){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					Map<String,Object>  brand = new HashMap<String, Object>();
					brand.put("name",discoveryInfo.getDiscoveryDetail().getBrandName());
					brand.put("ename",discoveryInfo.getDiscoveryDetail().getBrandEname());
					
					mapDiscoveryDetail.put("brand", brand);
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}

				}
				//2.3分类
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_3){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					Map<String,Object>  cat = new HashMap<String, Object>();
					cat.put("name",discoveryInfo.getDiscoveryDetail().getCatName());
					cat.put("ename",discoveryInfo.getDiscoveryDetail().getCatEname());
					
					mapDiscoveryDetail.put("cat", cat);
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}	

				}
				//2.4单品
				else if(discoveryInfo.getDiscoveryDetail().getType().intValue()==YamiConstant.DISCOVERY_TYPE_1){
					mapDiscoveryDetail = new HashMap<String,Object>();
					mapDiscoveryDetail.put("type", discoveryInfo.getDiscoveryDetail().getType());
					mapDiscoveryDetail.put("value", discoveryInfo.getDiscoveryDetail().getValue());
					mapDiscoveryDetail.put("evalue", discoveryInfo.getDiscoveryDetail().getEvalue());
					Map<String,Object>  topGoods = new HashMap<String, Object>();
					topGoods.put("name",discoveryInfo.getDiscoveryDetail().getGoodsName());
					topGoods.put("ename",discoveryInfo.getDiscoveryDetail().getGoodsEname());
					
					mapDiscoveryDetail.put("topItem", topGoods);
					if(null!=discoveryInfo.getDiscoveryDetail().getLstGoods()&&discoveryInfo.getDiscoveryDetail().getLstGoods().size()>0){
						lstGoods = new ArrayList<Map<String,Object>>();
						for(Goods goods:discoveryInfo.getDiscoveryDetail().getLstGoods()){
							 mapGoods = new HashMap<String,Object>();
							 mapGoods.put("goods_id", goods.getGoodsId());
							 mapGoods.put("goods_name", goods.getGoodsName());
							 mapGoods.put("goods_ename", goods.getGoodsEname());
							 mapGoods.put("shop_price", StringUtil.formatPrice(goods.getShopPrice()));
							 mapGoods.put("is_promote", goods.getIsPromote()?1:0);
							 mapGoods.put("promote_price", StringUtil.formatPrice(goods.getPromotePrice()));
							 mapGoods.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
							 mapGoods.put("goods_thumb", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
							 mapGoods.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
							 mapGoods.put("original_img", YamiConstant.IMAGE_URL+goods.getOriginalImg());
							 lstGoods.add(mapGoods);
						}
						mapDiscoveryDetail.put("items", lstGoods);
						mapDiscoveryInfo.put("detail", mapDiscoveryDetail);	
					}
					}	
				
			}

			
			
			
			
			
			
			result.add(mapDiscoveryInfo);	
		}
		
		
		return result;
		
	}
	
	/*
	 获取区域限购商品对应的区域限购设置信息
	@param String token 
	@return Map<String,Object> 
	*/	
	public  List<ShopDistrictZipcode> getGoodsZipLimit(int gid){ 
		List<ShopDistrictZipcode> result = new ArrayList<ShopDistrictZipcode>();
		Goods goods = goodsService.selectByPrimaryKey(gid);

		if(goodsRedisService.checkShopZipcode(goods.getZipcodeLimitId())){
			result = goodsRedisService.selectShopZipcode(goods.getZipcodeLimitId());
		}
		else{
			//1、商品区域限购配置
			result = goodsService.selectGoodsZipcodeLimit(gid);
			//2、商品无区域限购配置，查询商品对应供货商的区域限购配置
			if(null==result||result.size()==0){
				result = goodsService.selectVendorZipcodeLimitByGoodsId(gid);
			}
			for(ShopDistrictZipcode shopZipcodeLimit:result){
				goodsRedisService.insertShopZipcode(shopZipcodeLimit);
			}
			
		}
		return result;
		
	}
	
}
