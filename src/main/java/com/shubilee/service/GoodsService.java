package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;



































import org.apache.ibatis.annotations.Param;

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

public interface GoodsService {
	 public Goods selectByPrimaryKey(int gid);
	 public List<Goods> selectGoods(int start,int leng);
	 public List<CategoryForShow> selectShowCategory();
	 public List<GoodsOfCatItems> selectCatItems(int cat_id, int sort_by, int sort_order, int is_promote, int index, int[] brand_id, int iTEMS_PER_PAGE);
	 public BrandName selectNameByBrandId(int brandId);
	 public List<BrandName> selectCatBrands(int cat_id);
	 public int selectCatItemsCount(int cat_id, int sort_by,int sort_order, int is_promote, int index, int[] brand_id_int, int iTEMS_PER_PAGE);
	 public int updateGoodsNum(int goods_num,int goods_id);
	 public int updateLimitedNum(int goods_num,int goods_id);
	 public List<GoodsGallery> selectThumbByGid(int gid,int display_number);
	 public List<Goods> selectGoodsForNew(int start, int length);
	 public int selectGoodsForNewCount();
	 public List<Goods> selectGoodsForNewByCatid(int cat_id, int start,int length);
	 public List<GoodsFlash> selectGoodsOfFlash(Integer start,Integer length);
	 public int selectGoodsOfFlashCount();
	 public GoodsFlash selectGoodsOfFlashInIndex();
	 public List<Keywords> selectKeywords(Integer cat_id,Integer priority,Integer count);
	 public List<CategoryForShow> selectShowCategory4Index();
	 public List<CategoryForShow> selectShowCategory4Channel3();
	 public List<CategoryForShow> selectShowCategory4Channel5();
	 public List<CategoryForShow> selectShowCategory4Channel2();
	 public List<CategoryForShow> selectShowCategory4Channel4();
	 public List<Goods> selectCatNewGoods(Integer cat_id,Integer start,Integer length);
	 public List<GoodsComment> selectGoodsComment(Integer goods_id,Integer start,Integer length);
	 public int selectGoodsCommentCount(Integer goods_id);
	 public String selectGoodsCommentRate(Integer goods_id);

	 public List<Goods> selectGoodsWeekly(Long nowDate,Integer start,Integer length);
	 public int selectGoodsWeeklyCount(Long nowDate);
	 public List<Goods> selectGoodsPromote(Long nowDate,Integer start,Integer length);
	 public int selectGoodsPromoteCount(Long nowDate);

	 public int selectFavoriteByUidandGid(int uid, int gid);
	 public List<GoodsDisplayApp> selectGoodsEdit(Integer page,Integer section,Integer cat_id,Integer type,Integer start,Integer leng);
	 public int selectGoodsEditCount(Integer page,Integer scope,Integer cat_id,Integer type);
	 public List<Goods> selectPersonalizedGoods(int gid,Integer start,Integer length);
	 public int selectPersonalizedGoodsCount(int gid);
	 public List<GoodsDisplayDkp> selectGoodsDkpEdit(Integer page,Integer section,Integer cat_id,Integer type,Integer start,Integer leng);
	 public int selectGoodsDkpEditCount(Integer page,Integer section,Integer cat_id,Integer type);
	 public List<GoodsHot> selectGoodsHot(int page);
	 public int insertMessage(Message message);
	 public int insertMessagePost(MessagePost messagePost);
	 public int insertMessageComment(MessageComment messageComment);
	 public int insertMessageImage(MessageImage messageImage);
	 public int updateMessageImage(Integer iid,Integer pid);
	 public List<BrandHot> selectBrandHot(Integer page,Integer start,Integer leng);
	 public List<Goods> selectBrandItems(int brand_id, Integer sort_by, Integer sort_order, Integer start,Integer length);
	 public int selectBrandItemsCount(int brand_id);
	 public Brand selectBrandInfo(int brandId);
	 public List<Brand> selectBrands(Integer cat_id,String index);
	 public String selectCatInfoByGid(int goods_id);
	 public CategoryForShow selectCategoryInfo(int cat_id);
	 public List<Goods> selectEventItems(String[]  goods_ids);
	 public SearchBar selectSearchBar();
	 public List<SearchBar> selectAllSearchBar();
	 public BrandAttr selectBrandAttrByBrandId(int brandId);
	 public List<GoodsAggregate> selectGoodsForAggregate(Integer ag_id);
	 public YmZipcode selectYmZipcodeByZip(int zip);
	 public List<YmZipcode> selectYmZipcode();
	 public List<Goods> selectGoodsPromoteV2(Integer cat_id,Integer sort_by,Integer sort_order,Long nowDate,Integer start,Integer length);
	 public int selectGoodsPromoteCountV2(Integer cat_id,Long nowDate);
	 public List<ShopDistrictZipcode> selectGoodsZipcodeLimit(int goodsId);
	 public List<ShopDistrictZipcode> selectVendorZipcodeLimitByGoodsId(int goodsId);
}
