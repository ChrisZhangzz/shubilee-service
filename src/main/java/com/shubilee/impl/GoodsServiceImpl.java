package com.shubilee.impl;

import java.math.BigDecimal;
import java.util.List;










































import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.YamiConstant;
import com.shubilee.dao.BrandDao;
import com.shubilee.dao.CategoryDao;
import com.shubilee.dao.GoodsAggregateDao;
import com.shubilee.dao.GoodsDao;
import com.shubilee.dao.GoodsHotDao;
import com.shubilee.dao.KeywordsDao;
import com.shubilee.dao.SearchBarDao;
import com.shubilee.entity.Brand;
import com.shubilee.entity.BrandAttr;
import com.shubilee.entity.BrandHot;
import com.shubilee.entity.BrandName;
import com.shubilee.entity.CategoryForShow;
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
import com.shubilee.entity.Message;
import com.shubilee.entity.MessageComment;
import com.shubilee.entity.MessageImage;
import com.shubilee.entity.MessagePost;
import com.shubilee.entity.SearchBar;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.entity.YmZipcode;
import com.shubilee.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private KeywordsDao keywordsDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private GoodsHotDao goodsHotDao;
	@Autowired
	private GoodsAggregateDao goodsAggregateDao;
	@Autowired
	private SearchBarDao searchBarDao;	
	    public Goods selectByPrimaryKey(int gid){
	    	Goods goods = goodsDao.selectByPrimaryKey(gid);
	    	return goods;
	    };
 
	    public List<Goods> selectGoods(int start,int leng){
	    	List<Goods> lstGoods = goodsDao.selectGoods(start, leng);
	    	return lstGoods;
	    };
	    
	    public List<CategoryForShow> selectShowCategory() {
			List<CategoryForShow> ShowCategory = categoryDao.selectShowCategory();
			return ShowCategory;
		}

		public List<GoodsOfCatItems> selectCatItems(int cat_id, int sort_by, int sort_order, int is_promote, int index, int[] brand_id,int ITEMS_PER_PAGE) {
			return goodsDao.selectCatItems(cat_id, sort_by,sort_order,is_promote,index,ITEMS_PER_PAGE, brand_id);
		}

		public BrandName selectNameByBrandId(int brandId) {
			return brandDao.selectNameByBrandId(brandId);
		}

		public int selectCatItemsCount(int cat_id,int sort_by, int sort_order, int is_promote, int index, int[] brand_id, int ITEMS_PER_PAGE) {
			return goodsDao.selectCatItemsCount(cat_id, sort_by,sort_order,is_promote,index,ITEMS_PER_PAGE, brand_id);
		}
		
		public List<BrandName> selectCatBrands(int cat_id) {
		    
			return brandDao.selectCatBrands(cat_id);
		}
		public int updateGoodsNum(int goods_num,int goods_id){
			return goodsDao.updateGoodsNum(goods_num, goods_id);
		}
		public int updateLimitedNum(int goods_num,int goods_id){
			return goodsDao.updateLimitedNum(goods_num, goods_id);
		}
		public List<GoodsGallery> selectThumbByGid(int gid, int display_number) {
			return goodsDao.selectThumbByGid(gid,display_number);
		}

		public List<Goods> selectGoodsForNew(int start, int leng) {
			List<Goods> lstGoods = goodsDao.selectGoodsForNew(start, leng);
	    	return lstGoods;
		}
		public int selectGoodsForNewCount(){
			return goodsDao.selectGoodsForNewCount();
		}
		public List<Goods> selectGoodsForNewByCatid(int cat_id, int start, int leng) {
			List<Goods> lstGoods = goodsDao.selectGoodsForNewByCatid(cat_id,start, leng);
	    	return lstGoods;
		}
		public List<GoodsFlash> selectGoodsOfFlash(Integer start,Integer length){
			return goodsDao.selectGoodsOfFlash(start, length);
		}
		public int selectGoodsOfFlashCount(){
			return goodsDao.selectGoodsOfFlashCount();
		}
		public GoodsFlash selectGoodsOfFlashInIndex(){
			return goodsDao.selectGoodsOfFlashInIndex();
		}
		public List<Keywords> selectKeywords(Integer cat_id,Integer priority,Integer count){
			return keywordsDao.selectKeywords(cat_id, priority, count);
		}
		public List<CategoryForShow> selectShowCategory4Index(){
			return categoryDao.selectShowCategory4Index();
		}
		public List<CategoryForShow> selectShowCategory4Channel3(){
			return categoryDao.selectShowCategory4Channel3();
		}
		public List<CategoryForShow> selectShowCategory4Channel5(){
			return categoryDao.selectShowCategory4Channel5();
		}
		public List<CategoryForShow> selectShowCategory4Channel2(){
			return categoryDao.selectShowCategory4Channel2();
		}
		public List<CategoryForShow> selectShowCategory4Channel4(){
			return categoryDao.selectShowCategory4Channel4();
		}
		 public List<Goods> selectCatNewGoods(Integer cat_id,Integer start,Integer length){
			 return goodsDao.selectCatNewGoods(cat_id,start,length);
		 }
		 public List<GoodsComment> selectGoodsComment(Integer goods_id,Integer start,Integer length){
			 return goodsDao.selectGoodsComment(goods_id, start, length);
		 }
		 public int selectGoodsCommentCount(Integer goods_id){
			 return goodsDao.selectGoodsCommentCount(goods_id);
		 }
		 public String selectGoodsCommentRate(Integer goods_id){
			 return goodsDao.selectGoodsCommentRate(goods_id);
		 }

		 public List<Goods> selectGoodsWeekly(Long nowDate,Integer start,Integer length){
			 return goodsDao.selectGoodsWeekly(nowDate, start, length);
		 }
		 public int selectGoodsWeeklyCount(Long nowDate){
			 return goodsDao.selectGoodsWeeklyCount(nowDate); 
		 }
		 public List<Goods> selectGoodsPromote(Long nowDate,Integer start,Integer length){
			 return goodsDao.selectGoodsPromote(nowDate, start, length);
		 }
		 public int selectGoodsPromoteCount(Long nowDate){
			 return goodsDao.selectGoodsPromoteCount(nowDate); 
		 }

		public int selectFavoriteByUidandGid(int uid, int gid) {
			 return goodsDao.selectFavoriteByUidandGid(uid,gid);
		}
		
		 public List<GoodsDisplayApp> selectGoodsEdit(Integer page,Integer section,Integer cat_id,Integer type,Integer start,Integer leng){
			 return goodsDao.selectGoodsEdit(page, section,cat_id,type,start, leng);
		 }
		 public int selectGoodsEditCount(Integer page,Integer scope,Integer cat_id,Integer type){
			 return goodsDao.selectGoodsEditCount(page,scope,cat_id,type); 
		 }
		 public List<Goods> selectPersonalizedGoods(int gid,Integer start,Integer length){
			 return goodsDao.selectPersonalizedGoods(gid, start, length);
		 }
		 public int selectPersonalizedGoodsCount(int gid){
			 return goodsDao.selectPersonalizedGoodsCount(gid);
			 
		 }
		 public List<GoodsDisplayDkp> selectGoodsDkpEdit(Integer page,Integer section,Integer cat_id,Integer type,Integer start,Integer leng){
			 return goodsDao.selectGoodsDkpEdit(page, section, cat_id, type, start, leng);
		 }
		 public int selectGoodsDkpEditCount(Integer page,Integer section,Integer cat_id,Integer type){
			 return goodsDao.selectGoodsDkpEditCount(page, section, cat_id, type);
		 }
		 public List<GoodsHot> selectGoodsHot(int page){
			 return goodsHotDao.selectGoodsHot(page);
		 }
		 public int insertMessage(Message message){
			 return goodsDao.insertMessage(message);
		 }
		 public int insertMessagePost(MessagePost messagePost){
			 return goodsDao.insertMessagePost(messagePost);
		 }
		 public int insertMessageComment(MessageComment messageComment){
			 return goodsDao.insertMessageComment(messageComment);
		 }
		 public int insertMessageImage(MessageImage messageImage){
			 return goodsDao.insertMessageImage(messageImage);
		 }
		 public int updateMessageImage(Integer iid,Integer pid){
			 return goodsDao.updateMessageImage(iid, pid);
		 }
		 public List<BrandHot> selectBrandHot(Integer page,Integer start,Integer leng){
			 return goodsDao.selectBrandHot(page, start, leng);
		 }
		 public List<Goods> selectBrandItems(int brand_id, Integer sort_by, Integer sort_order, Integer start,Integer length){
			 return goodsDao.selectBrandItems(brand_id, sort_by, sort_order, start, length);
		 }
		 public int selectBrandItemsCount(int brand_id){
			 return goodsDao.selectBrandItemsCount(brand_id);
		 }
		 public Brand selectBrandInfo(int brandId){
			 return brandDao.selectBrandInfo(brandId);
		 }
		 public List<Brand> selectBrands(Integer cat_id,String index){
			 return brandDao.selectBrands(cat_id, index);
		 }
		 public String selectCatInfoByGid(int goods_id){
			 return categoryDao.selectCatInfoByGid(goods_id);
		 }
		public CategoryForShow selectCategoryInfo(int cat_id){
			 return categoryDao.selectCategoryInfo(cat_id);
		}
		public List<Goods> selectEventItems(String[]  goods_ids){
			 return goodsDao.selectEventItems(goods_ids);
		}
		public SearchBar selectSearchBar(){
			return searchBarDao.selectSearchBar();
		}
		public List<SearchBar> selectAllSearchBar(){
			return searchBarDao.selectAllSearchBar();
		}
		 public BrandAttr selectBrandAttrByBrandId(int brandId){
			 return brandDao.selectBrandAttrByBrandId(brandId);
		 }
		 public List<GoodsAggregate> selectGoodsForAggregate(Integer ag_id){
			 return goodsAggregateDao.selectGoodsForAggregate(ag_id);
		 }
		 public YmZipcode selectYmZipcodeByZip(int zip){
			return goodsDao.selectYmZipcodeByZip(zip); 
		 }
		 public List<YmZipcode> selectYmZipcode(){
			 return goodsDao.selectYmZipcode();
		 }
		 
		 public List<Goods> selectGoodsPromoteV2(Integer cat_id,Integer sort_by,Integer sort_order,Long nowDate,Integer start,Integer length){
			 return goodsDao.selectGoodsPromoteV2(cat_id, sort_by,sort_order, nowDate, start, length);
		 }
		 public int selectGoodsPromoteCountV2(Integer cat_id,Long nowDate){
			 return goodsDao.selectGoodsPromoteCountV2(cat_id, nowDate);
			 }
		 public List<ShopDistrictZipcode> selectGoodsZipcodeLimit(int goodsId){
			 return goodsDao.selectGoodsZipcodeLimit(goodsId);
		 }
		 public List<ShopDistrictZipcode> selectVendorZipcodeLimitByGoodsId(int goodsId){
			 return goodsDao.selectVendorZipcodeLimitByGoodsId(goodsId); 
		 }
		 }

