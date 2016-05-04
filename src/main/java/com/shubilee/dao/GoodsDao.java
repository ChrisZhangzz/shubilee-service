
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.BrandHot;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsComment;
import com.shubilee.entity.GoodsDisplayApp;
import com.shubilee.entity.GoodsDisplayDkp;
import com.shubilee.entity.GoodsFlash;
import com.shubilee.entity.GoodsGallery;
import com.shubilee.entity.GoodsOfCatItems;
import com.shubilee.entity.Message;
import com.shubilee.entity.MessageComment;
import com.shubilee.entity.MessageImage;
import com.shubilee.entity.MessagePost;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.entity.YmZipcode;

public interface GoodsDao {  
	
    public Goods selectByPrimaryKey(@Param("goods_id") int goodsId);
    public List<Goods> selectGoods(@Param("start") Integer start,@Param("leng") Integer leng);
	public List<GoodsOfCatItems> selectCatItems(@Param("cat_id") int cat_id, @Param("sort_by") int sort_by, @Param("sort_order") int sort_order,
			                                       @Param("is_promote") int is_promote, @Param("index")  int index,
			                                       @Param("items_Per_Page") int items_Per_Page, @Param("brand_id")  int[] brand_id);
	
	public int selectCatItemsCount(@Param("cat_id") int cat_id, @Param("sort_by") int sort_by, @Param("sort_order") int sort_order,
            									   @Param("is_promote") int is_promote, @Param("index")  int index,
            									   @Param("items_Per_Page") int items_Per_Page, @Param("brand_id")  int[] brand_id);
	public int updateGoodsNum(@Param("goods_num") int goods_num,@Param("goods_id") int goods_id);
	public int updateLimitedNum(@Param("goods_num") int goods_num,@Param("goods_id") int goods_id);
	public List<GoodsGallery> selectThumbByGid(@Param("gid") int gid, @Param("display_number") int display_number);
	public List<Goods> selectGoodsForNew(@Param("start") Integer start,@Param("leng") Integer leng);
	public int selectGoodsForNewCount();
	public List<GoodsDisplayApp> selectGoodsEdit(@Param("page") Integer page,@Param("section") Integer section,@Param("cat_id") Integer cat_id,@Param("type") Integer type,@Param("start") Integer start,@Param("leng") Integer leng);
	public int selectGoodsEditCount(@Param("page") Integer page,@Param("section") Integer section,@Param("cat_id") Integer cat_id,@Param("type") Integer type);
	public List<Goods> selectGoodsForNewByCatid(@Param("cat_id") Integer cat_id, @Param("start") Integer start, @Param("leng") Integer leng);
	public List<GoodsFlash> selectGoodsOfFlash(@Param("start") Integer start, @Param("length") Integer length);
	public int selectGoodsOfFlashCount();
	public GoodsFlash selectGoodsOfFlashInIndex();
	public List<Goods> selectCatNewGoods(@Param("cat_id") Integer cat_id,@Param("start") Integer start,@Param("length") Integer length);
	public List<GoodsComment> selectGoodsComment(@Param("goods_id") Integer goods_id,@Param("start") Integer start,@Param("length") Integer length);
	public int selectGoodsCommentCount(@Param("goods_id") Integer goods_id);
	public String selectGoodsCommentRate(@Param("goods_id") Integer goods_id);
	public List<Goods> selectGoodsWeekly(@Param("nowDate") Long nowDate,@Param("start") Integer start,@Param("length") Integer length);
	public int selectGoodsWeeklyCount(@Param("nowDate") Long nowDate);
	public List<Goods> selectGoodsPromote(@Param("nowDate") Long nowDate,@Param("start") Integer start,@Param("length") Integer length);
	public List<Goods> selectGoodsPromoteV2(@Param("cat_id") Integer cat_id,@Param("sort_by") Integer sort_by,@Param("sort_order") Integer sort_order,@Param("nowDate") Long nowDate,@Param("start") Integer start,@Param("length") Integer length);
	public int selectGoodsPromoteCount(@Param("nowDate") Long nowDate);
	public int selectGoodsPromoteCountV2(@Param("cat_id") Integer cat_id,@Param("nowDate") Long nowDate);
	public int selectFavoriteByUidandGid(@Param("uid") int uid, @Param("gid") int gid);
	public List<Goods> selectPersonalizedGoods(@Param("gid") int gid,@Param("start") Integer start,@Param("length") Integer length);
	public int selectPersonalizedGoodsCount(@Param("gid") int gid);
	public List<GoodsDisplayDkp> selectGoodsDkpEdit(@Param("page") Integer page,@Param("section") Integer section,@Param("cat_id") Integer cat_id,@Param("type") Integer type,@Param("start") Integer start,@Param("leng") Integer leng);
	public int selectGoodsDkpEditCount(@Param("page") Integer page,@Param("section") Integer section,@Param("cat_id") Integer cat_id,@Param("type") Integer type);
	public int insertMessage(Message message);
	public int insertMessagePost(MessagePost messagePost);
	public int insertMessageComment(MessageComment messageComment);
	public int insertMessageImage(MessageImage messageImage);
	public int updateMessageImage(@Param("iid") Integer iid,@Param("pid") Integer pid);
	public List<BrandHot> selectBrandHot(@Param("page") Integer page,@Param("start") Integer start,@Param("length") Integer leng);
	public List<Goods> selectBrandItems(@Param("brand_id") int brand_id, @Param("sort_by") Integer sort_by, @Param("sort_order") Integer sort_order,
			@Param("start") Integer start,@Param("length") Integer length);

	public int selectBrandItemsCount(@Param("brand_id") int brand_id);
	public List<Goods> selectEventItems(@Param("goods_ids") String[] goods_ids);
	public YmZipcode selectYmZipcodeByZip(@Param("zip") int zip);
	public List<YmZipcode> selectYmZipcode();
	public List<Goods> selectGoodsByGoodsIds(@Param("goods_ids") String[]  goods_ids);
	public List<ShopDistrictZipcode> selectGoodsZipcodeLimit(@Param("goods_id") int goodsId);
	public List<ShopDistrictZipcode> selectVendorZipcodeLimitByGoodsId(@Param("goods_id") int goodsId);
}
