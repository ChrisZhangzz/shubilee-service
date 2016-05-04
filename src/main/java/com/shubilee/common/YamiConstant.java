package com.shubilee.common;

import java.math.BigDecimal;

public interface YamiConstant {
	//The times of encode md5
	final static int ENCTIMES = 2;
	
	/*---------------ErrorCode Area------------------*/
	//Token expired.
	final static String ERRORCODE_ER1001 = "ER1001";
	//Token service failed.
	final static String ERRORCODE_ER1002 = "ER1002";
	//Invalid token.
	final static String ERRORCODE_ER1003 = "ER1003";
	//Need login
	final static String ERRORCODE_ER1004 = "ER1004";
	//Database error occurred.
	final static String ERRORCODE_ER1005 = "ER1005";
	//An exception occurred.
	final static String ERRORCODE_ER1006 = "ER1006";
	
	/*---------------Cart Service ErrorCode Area------------------*/
	//商品已经下架
	final static String ERRORCODE_ER1101 = "ER1101";
	//够买的数量已经超过限购数量
	final static String ERRORCODE_ER1102 = "ER1102";
	//库存不足
	final static String ERRORCODE_ER1103 = "ER1103";
	//购物车数据更新失败
	final static String ERRORCODE_ER1104 = "ER1104";

	//折扣码验证失败
	final static String ERRORCODE_ER1105 = "ER1105";
	//邮寄地址
	final static String ERRORCODE_ER1106 = "ER1106";
	//支付方式
	final static String ERRORCODE_ER1107 = "ER1107";
	//邮寄方式
	final static String ERRORCODE_ER1108 = "ER1108";
	//账单地址
	final static String ERRORCODE_ER1109 = "ER1109";
	//阿拉斯加或夏威夷请重新选择邮寄方式
	final static String ERRORCODE_ER1110= "ER1110";
	//finishOrder加密验证
	final static String ERRORCODE_ER1114 = "ER1114";
	//第三方供货商不支持配送阿拉斯加或夏威夷
	final static String ERRORCODE_ER1111= "ER1111";
	//库存不足
	final static String ERRORCODE_ER1112 = "ER1112";
	//finishOrder加密验证
	final static String ERRORCODE_ER1113 = "ER1113";
	//添加购物车赠品错误提示
	final static String ERRORCODE_ER1115 = "ER1115";
	//添加购物车赠品错误提示
	final static String ERRORCODE_ER1116 = "ER1116";
	/*---------------Cart Service ErrorCode Area------------------*/
	/*---------------Order Service ErrorCode Area------------------*/
	//订单金额变化
	final static String ERRORCODE_ER1201 = "ER1201";
	//订单商品由于库存、销售、删除等提交时错误
	final static String ERRORCODE_ER1202 = "ER1202";
	//提交订单是购物车商品为空
	final static String ERRORCODE_ER1203 = "ER1203";
	/*---------------Order Service ErrorCode Area------------------*/
	
	
	//Invalid user and password.
	final static String ERRORCODE_ER1301 = "ER1301";
	
	//user email already exist.
    final static String ERRORCODE_ER1302 = "ER1302";
	
	//user name already exist.
    final static String ERRORCODE_ER1303 = "ER1303";
	//The last request is processing, please wait for respond.
    final static String ERRORCODE_ER1304 = "ER1304";
	//Invalid request. Please request again.
    final static String ERRORCODE_ER1305 = "ER1305";
	//Request expired. Please request again.
    final static String ERRORCODE_ER1306 = "ER1306";
	//User email does not exist.
    final static String ERRORCODE_ER1307 = "ER1307";
	
	//Cannot process profile. A error has occurred.
	final static String ERRORCODE_ER1311 = "ER1311";
	//Cannot process profile. Profile does not exist.
	final static String ERRORCODE_ER1312 = "ER1312";
	//Error validating card/account number checksum.
	final static String ERRORCODE_ER1313 = "ER1313";
	//The address does not exist.
	final static String ERRORCODE_ER1321 = "ER1321";
	//The billing address does not exist.
	final static String ERRORCODE_ER1322 = "ER1322";
	//Cannot process payment. A error has occurred.
	final static String ERRORCODE_ER1331 = "ER1331";
	//Cannot process payment. Amounts are not equal.
	final static String ERRORCODE_ER1332 = "ER1332";
	//Declined.
	final static String ERRORCODE_ER1333 = "ER1333";
	
	//Declined.
	final static String ERRORCODE_ER1334 = "ER1334";
	
	
	/*--------------Payment Service ErrorCode Area----------------*/
	//Cannot get configuration file of PayPal. A error has occurred.
	final static String ERRORCODE_ER1401 = "ER1401";
	//Cannot process service of PayPal. A error has occurred.
	final static String ERRORCODE_ER1402 = "ER1402";
	//The transaction didn't complete successfully.
	final static String ERRORCODE_ER1403 = "ER1403";
	//A successful transaction has already been completed for this token.
	final static String ERRORCODE_ER1404 = "ER1404";
	//Please login to your PayPal
	final static String ERRORCODE_ER1405 = "ER1405";
	//The transaction didn't complete successfully. Please contact customer service.
	final static String ERRORCODE_ER1406 = "ER1406";
	
	/*------------UPS and USPS Service ErrorCode Area------------*/
	//Cannot process service of UPS. A error has occurred.
	final static String ERRORCODE_ER1451 = "ER1451";
	//No tracking information available
	final static String ERRORCODE_ER1452 = "ER1452";
	//Invalid tracking number
	final static String ERRORCODE_ER1453 = "ER1453";
	//Cannot process service of USPS. A error has occurred.
	final static String ERRORCODE_ER1461 = "ER1461";
	//The Postal Service could not locate the tracking information for your request.
	final static String ERRORCODE_ER1462 = "ER1462";
	final static String ERRORCODE_ER1463 = "ER1463";
	final static String ERRORCODE_ER1464 = "ER1464";
	final static String ERRORCODE_ER1465 = "ER1465";
	final static String ERRORCODE_ER1466 = "ER1466";
	final static String ERRORCODE_ER1467 = "ER1467";
	final static String ERRORCODE_ER1468 = "ER1468";
	final static String ERRORCODE_ER1469 = "ER1469";
	
	/*--------------Goods Service ErrorCode Area----------------*/
	final static String ERRORCODE_ER1501 = "ER1501";
	final static String ERRORCODE_ER1502 = "ER1502";
	/*--------------Goods Service ErrorCode Area----------------*/
	
	
	/*--------------各校验返回码----------------*/
	//登陆页面邮箱校验判断有唯一[ @ ] 跟随唯一[ . ]
	final static String ERRORCODE_ER1601 = "ER1601";
	//登陆页面密码至少6位
	final static String ERRORCODE_ER1602 = "ER1602";
	//注册页面邮箱校验判断有唯一[ @ ] 跟随唯一[ . ]
	final static String ERRORCODE_ER1603 = "ER1603";
	//注册页面密码至少6位
	final static String ERRORCODE_ER1604 = "ER1604";
	//注册页面邀请码输入错误
	final static String ERRORCODE_ER1642 = "ER1642";
	//注册页面密码至少6位
	final static String ERRORCODE_ER1605 = "ER1605";
	//注册页面密码至少6位
	final static String ERRORCODE_ER1606 = "ER1606";	
	//注册页面密码至少6位
	final static String ERRORCODE_ER1607 = "ER1607";	
	//注册页面密码至少6位
	final static String ERRORCODE_ER1608 = "ER1608";
	//注册页面密码至少6位
	final static String ERRORCODE_ER1609 = "ER1609";
	//注册页面密码至少6位
	final static String ERRORCODE_ER1610 = "ER1610";
	//注册页面密码至少6位
	final static String ERRORCODE_ER1611 = "ER1611";
	//注册页面密码至少6位
	final static String ERRORCODE_ER1612 = "ER1612";
	//注册页面密码至少6位
	final static String ERRORCODE_ER1613 = "ER1613";
	//column name can not input Chinese
	final static String ERRORCODE_ER1614 = "ER1614";
	//column address can not input Chinese
	final static String ERRORCODE_ER1615 = "ER1615";
	//We don't support this type of card yet
	final static String ERRORCODE_ER1616 = "ER1616";
	
	final static String ERRORCODE_ER1627 = "ER1627";

	final static String ERRORCODE_ER1626 = "ER1626";

	final static String ERRORCODE_ER1628 = "ER1628";

	final static String ERRORCODE_ER1629 = "ER1629";

	final static String ERRORCODE_ER1620 = "ER1620";

	final static String ERRORCODE_ER1621 = "ER1621";

	final static String ERRORCODE_ER1622 = "ER1622";

	final static String ERRORCODE_ER1624 = "ER1624";

	final static String ERRORCODE_ER1625 = "ER1625";	
	
	final static String ERRORCODE_ER1630 = "ER1630";
	final static String ERRORCODE_ER1631 = "ER1631";
	final static String ERRORCODE_ER1632 = "ER1632";
	final static String ERRORCODE_ER1633 = "ER1633";
	final static String ERRORCODE_ER1634 = "ER1634";
	final static String ERRORCODE_ER1635 = "ER1635";
	
	final static String ERRORCODE_ER1636 = "ER1636";
	final static String ERRORCODE_ER1637 = "ER1637";
	final static String ERRORCODE_ER1638 = "ER1638";
	final static String ERRORCODE_ER1639 = "ER1639";
	final static String ERRORCODE_ER1640 = "ER1640";
	final static String ERRORCODE_ER1641 = "ER1641";
	final static String ERRORCODE_ER1643 = "ER1643";
	/*---------------Common Area------------------*/
	/*---------------goods Param check------------------*/
	final static String ERRORCODE_ER1701 = "ER1701";
	final static String ERRORCODE_ER1702 = "ER1702";
	/*---------------goods Param check------------------*/
	/*---------------lottery check------------------*/
	final static String ERRORCODE_ER1801 = "ER1801";
	final static String ERRORCODE_ER1802 = "ER1802";
	final static String ERRORCODE_ER1803 = "ER1803";
	/*---------------lottery check------------------*/
	
	
	
	
	
	
	//is login
	final static Integer IS_LOGIN = 1;
	//is not login
	final static Integer IS_NOT_LOGIN = 0;
	//is primary
	final static Integer RECORD_IS_PRIMARY = 1;
	//is not primary
	final static Integer RECORD_IS_NOT_PRIMARY = 0;
	//success status 
	final static Integer STATUS_OK = 1;
	//failure status 
	final static Integer STATUS_NG = 0;
	//no record
	final static Integer NO_RECORD = 0;
	//space 
	final static String STRING_SPACE = " ";
	//empty 
	final static String STRING_EMPTY = "";
	//integer 
	final static int INT_ZERO = 0;
	//no decimal point
	final static String FMT_NO_DECIMAL_POINT = "#";
	//two decimal point
	final static String FMT_TWO_DECIMAL_POINT = "#.00";
	//zip code pattern
	final static String ZIP_CODE_PATTERN = "^[0-9]{5}$";
	//error level warning
	final static String ERROR_LVL_WARNING = "warning";
	//error level error
	final static String ERROR_LVL_ERROR = "error";
	
	
	/*---------------UserService Area------------------*/
	//Country
	final static String COUNTRY_UNITEDSTATES = "United States";
	//random salt range 
	final static Integer RANDOM_SALT_RANGE = 9999;
	//is primary
	final static Integer IS_PRIMARY = 1;
	//is not primary
	final static Integer IS_NOT_PRIMARY = 0;
	
	//pay id
    final static int CREDIT_CARD = 4;
	
	//添加购物车赠品错误提示
	final static int GIFT_CAT_ID = 97;
	

	/*---------------Orbital Ups Web Service Area------------------*/


	/*---------------Orbital Usps Web Service Area------------------*/
	final static String USPS_ERRMSG_NEEDMOREINFO = "The address you entered was found but more information is needed";
	final static String USPS_ERRMSG_NOTFOUND = "Unfortunately, this address wasn't found. Please double-check it and try again.";
	
	/*---------------Payment Service Area------------------*/

	
	/*---------------Orbital Gateway Web Service Area------------------*/
	//Card Type
	final static String OGWS_CARD_TYPE_MSTE = "MASTERCARD";
	final static String OGWS_CARD_TYPE_VISA = "VISA";
	final static String OGWS_CARD_TYPE_AMEX = "AMEX";
	final static String OGWS_CARD_TYPE_DINE = "DINERS CLUB";
	final static String OGWS_CARD_TYPE_DISC = "DISCOVER";
	final static String OGWS_CARD_TYPE_JCB  = "JCB";
	final static String OGWS_CARD_TYPE_UNKN = "UNKNOWN";
	final static String OGWS_CARD_ERROR_839 = "839";
	final static String OGWS_CARD_ERROR_841 = "841";
	
	/*---------------PayPal Web Service Area------------------*/

	final static String CUSTOMER_SERVICE_EMAIL = "customerservice@yamibuy.com";
	final static String OTHER_CC_EMAIL = "little@little.lv";
	final static String IMAGE_URL = "http://cdn.yamibuy.com/";
	final static String IMAGE_DESC = "images/cn/index/no_detail.png";
	final static String IMAGE_EDESC = "images/en/index/no_detail_en.png";

	
	
	final static String BRAND_LOGO_URL = "http://cdn.yamibuy.com/data/brandlogo/";
	final static String AVATAR_URL = "http://cdn.yamibuy.com/";
	final static String NODE_HEAD_ENGLISH = "head";
	final static String NODE_HEAD_CHINESE = "头";
	final static int HAS_STOCK_YES = 1;
	final static int HAS_STOCK_NO = 0;


	
	final static String VENDOR_ID_YAMIBUY = "0";
	
	final static int SHIPPING_ID_GESOO = 15;
	
    final static int ITEMS_PER_PAGE_MOBILE = 20;
    final static int ITEMS_PER_PAGE_LABTOP = 48;
    final static int ITEMS_PER_PAGE_PROMOTEITEMS = 50;
    final static int ITEMS_PER_PAGE_MOBILE_DISCOVERY = 50;
    final static int ITEMS_PER_PAGE_LABTOP_DISCOVERY = 50;

	final static String REGEX_SOAPUI = "(.*)apache(.*)java(.*)";
	final static String REGEX_IPHONE = "(.*)iPhone(.*)";
	final static String REGEX_ANDROID = "(.*)android(.*)";
	final static String REGEX_FIREFOX = "(.*)firefox(.*)";
	final static String REGEX_CHROME = "(.*)chrome(.*)";
	final static String REGEX_IE = "(.*)windows(.*)";
	final static String REGEX_IPAD = "(.*)ipad(.*)";
	final static String REGEX_MAC = "(.*)intel(.*)";
	
	final static String REGEX_DESC_URL="<img(.*)src=\"(.*)\\.(jpg|png|mpeg|bmp|jpeg|tiff|gif)\"";
	
	

	final static int PAYPAL_PROFILE_ID = 0;

	final static int DISPLAY_NUMBER = 5;
	
	final static String ADD_INTERGRAL_FOR_REGISTER = "50.00";
	
	final static String CURRENCY = "$";
	
	//首页显示各分类关键字数量
	final static int INDEX_KEYWORDS_DISPLAY_NUMBER = 4;
	//pc首页显示各分类关键字数量
	final static int DKP_INDEX_KEYWORDS_DISPLAY_NUMBER = 6;
	//pc美妆馆显示各分类关键字数量
	final static int DKP_CHANNEL_PAGE_3_KEYWORDS_DISPLAY_NUMBER = 8;
	//pc美食馆显示各分类关键字数量
	final static int DKP_CHANNEL_PAGE_2_KEYWORDS_DISPLAY_NUMBER = 7;
	//首页显示各分类关键字权重级别
	final static int INDEX_KEYWORDS_DISPLAY_PRIORITY = 0;
	//首页显示各分类商品数量
	final static int INDEX_CAT_DISPLAY_GOODS_LENGTH = 6;
	
	//首页显示各分类商品起始
	final static int INDEX_CAT_DISPLAY_GOODS_START = 0;
	
	//APP首页显示主题推荐信息起始
	final static int INDEX_THEME_START =0;
	//APP首页显示主题推荐信息数量
	final static int INDEX_THEME_LENGTH =5;
	
	//APP首页显示折扣商品数量
	final static int INDEX_PROMOTE_DISPLAY_GOODS_LENGTH =8;
	
	//APP首页显示折扣商品起始
	final static int INDEX_PROMOTE_DISPLAY_GOODS_START = 0;
	
	//PC首页显示各分类商品数量
	final static int DKP_INDEX_CAT_DISPLAY_GOODS_LENGTH = 6;
	
	//PC首页显示各分类商品起始
	final static int DKP_INDEX_CAT_DISPLAY_GOODS_START = 0;
	
	
	//PC美妆页显示各分类商品数量
	final static int DKP_CHANNEL_PAGE_3_CAT_DISPLAY_GOODS_LENGTH = 8;
	
	//PC美妆页显示各分类商品起始
	final static int DKP_CHANNEL_PAGE_3_CAT_DISPLAY_GOODS_START = 0;
	
	//PC美食页显示各分类商品数量
	final static int DKP_CHANNEL_PAGE_2_CAT_DISPLAY_GOODS_LENGTH = 6;
	
	//PC美食页显示各分类商品起始
	final static int DKP_CHANNEL_PAGE_2_CAT_DISPLAY_GOODS_START = 0;
	
	//PC养生页显示各分类商品数量
	final static int DKP_CHANNEL_PAGE_4_CAT_DISPLAY_GOODS_LENGTH = 8;
	
	//PC养生页显示各分类商品起始
	final static int DKP_CHANNEL_PAGE_4_CAT_DISPLAY_GOODS_START = 0;
	//PC生活页显示各分类商品数量
	final static int DKP_CHANNEL_PAGE_5_CAT_DISPLAY_GOODS_LENGTH = 10;
	
	//PC生活页显示各分类商品起始
	final static int DKP_CHANNEL_PAGE_5_CAT_DISPLAY_GOODS_START = 0;
	//首页显示新商品数量
	final static int INDEX_DISPLAY_NEWGOODS_START = 0;
	//首页显示新商品起始
	final static int INDEX_DISPLAY_NEWGOODS_LENGTH = 6;
	//PC首页显示新商品起始
	final static int DKP_INDEX_DISPLAY_NEWGOODS_START = 0;
	//PC首页显示新商品数量
	final static int DKP_INDEX_DISPLAY_NEWGOODS_LENGTH = 8;
	
	//PC美妆馆页显示热销品牌起始
	final static int DKP_CHANNEL_PAGE_3_DISPLAY_BRANDHOT_START = 0;
	//PC美妆馆页显示热销品牌数量
	final static int DKP_CHANNEL_PAGE_3_DISPLAY_BRANDHOT_LENGTH = 20;
	//PC美食馆页显示热销品牌起始
	final static int DKP_CHANNEL_PAGE_2_DISPLAY_BRANDHOT_START = 0;
	//PC美食馆页显示热销品牌数量
	final static int DKP_CHANNEL_PAGE_2_DISPLAY_BRANDHOT_LENGTH = 20;
	//PC生活馆页显示热销品牌起始
	final static int DKP_CHANNEL_PAGE_5_DISPLAY_BRANDHOT_START = 0;
	//PC生活馆页显示热销品牌数量
	final static int DKP_CHANNEL_PAGE_5_DISPLAY_BRANDHOT_LENGTH = 20;
	
	//评论栏默认用户图片
	final static String DEFULT_IMAGE_GOODS_COMMENT_USER = "http://cdn.yamibuy.com/themes/default/images/user_snapshot_default.png";
	
	//首页显示对应PAGE
	final static int INDEX_PAGE = 1;
	//发现页显示对应PAGE
	final static int DISCOVER_PAGE = 9;
	//美食馆频道页显示对应PAGE
	final static int CHANNEL_PAGE_2 = 2;
	//美妆馆频道页显示对应PAGE
	final static int CHANNEL_PAGE_3 = 3;
	//养生馆频道页显示对应PAGE
	final static int CHANNEL_PAGE_4 = 4;
	//生活馆频道页显示对应PAGE
	final static int CHANNEL_PAGE_5 = 5;
	//首页显示滚动图片对应section
	final static int INDEX_SLIDES_IMAGE_SECTION = 1;
	//首页显示新品对应section
	final static int INDEX_NEW_ITEM_SECTION = 6;
	//首页显示分类新品对应section
	final static int INDEX_CAT_NEW_ITEM_SECTION = 7;
	//首页显示主题推荐信息对应section
	final static int INDEX_THEME_SECTION = 8;
	//DKP美妆馆页显示分类新品对应section
	final static int CHANNEL_PAGE_3_CAT_NEW_ITEM_SECTION = 7;
	//DKP美食馆页显示分类新品对应section
	final static int CHANNEL_PAGE_2_CAT_NEW_ITEM_SECTION = 7;
	//DKP养生馆页显示分类新品对应section
	final static int CHANNEL_PAGE_4_CAT_NEW_ITEM_SECTION = 7;
	//DKP美食馆页显示新品尝鲜对应section
	final static int CHANNEL_PAGE_2_NEW_ITEM_SECTION = 2;
	//DKP生活馆页显示分类新品对应section
	final static int CHANNEL_PAGE_5_CAT_NEW_ITEM_SECTION = 7;
	//发现页显示文字对应section
	final static int DISCOVER_KEY_SECTION = 1;
	//发现页显示图片对应section
	final static int DISCOVER_IMAGE_SECTION = 2;
	
	//频道页区域1对应section
	final static int CHANNEL_AREA1_SECTION = 2;
	//频道页区域2对应section
	final static int CHANNEL_AREA2_SECTION = 3;
	
	//display表数据类型 1：商品
	final static int DISPLAY_DATA_TYPE_1 = 1;
	//display表数据类型 2：品牌
	final static int DISPLAY_DATA_TYPE_2 = 2;
	//display表数据类型 3：分类
	final static int DISPLAY_DATA_TYPE_3 = 3;
	//display表数据类型 4：搜索
	final static int DISPLAY_DATA_TYPE_4 = 4;
	//display表数据类型 0:首页滚动图片
	final static int DISPLAY_DATA_TYPE_0 = 0;
	//顶级分类ID：休闲零食
	final static int TOP_CAT_ID_1 = 1;
	//顶级分类ID：休闲零食
	final static int TOP_CAT_ID_2 = 2;
	//顶级分类ID：营养保健
	final static int TOP_CAT_ID_3 = 7;
	//顶级分类ID：日用百货 厨房电器
	final static int TOP_CAT_ID_4 = 10;
	
	//匿名用户值
	final static String NO_LOGIN_USER_NAME = "匿名用户";
		
	//积分历史中，类型 0：购买获得积分
	final static int POINTS_TYPE_NO_0 = 0;
	//积分历史中，类型 0：购买获得积分
	final static String POINTS_TYPE_DESC_0 = "购买获得积分";
	//积分历史中，类型 0：购买获得积分
	final static String POINTS_TYPE_EDESC_0 = "Points Received";
	//积分历史中，类型 1：使用积分
	final static int POINTS_TYPE_NO_1 = 1;
	//积分历史中，类型 1：使用积分
	final static String POINTS_TYPE_DESC_1 = "使用积分";
	//积分历史中，类型 1：使用积分
	final static String POINTS_TYPE_EDESC_1 = "Points Used";
	//积分历史中，类型 2：注册
	final static int POINTS_TYPE_NO_2 = 2;
	//积分历史中，类型  2：注册
	final static String POINTS_TYPE_DESC_2 = "注册";
	//积分历史中，类型  2：注册
	final static String POINTS_TYPE_EDESC_2 = "Points from Registration";
	//积分历史中，类型 3：推荐
	final static int POINTS_TYPE_NO_3 = 3;
	//积分历史中，类型3：推荐
	final static String POINTS_TYPE_DESC_3 = "推荐";
	//积分历史中，类型3：推荐
	final static String POINTS_TYPE_EDESC_3 = "Points from Referral";
	//积分历史中，类型 4：系统奖励
	final static int POINTS_TYPE_NO_4 = 4;
	//积分历史中，类型 4：系统奖励
	final static String POINTS_TYPE_DESC_4 = "系统奖励";
	//积分历史中，类型4：系统奖励
	final static String POINTS_TYPE_EDESC_4 = "Bonus Points";
	//积分历史中，类型 5：退货
	final static int POINTS_TYPE_NO_5 = 5;
	//积分历史中，类型5：退货
	final static String POINTS_TYPE_DESC_5 = "退货";
	//积分历史中，类型 5：退货
	final static String POINTS_TYPE_EDESC_5 = "Return";
	//积分历史中，类型 6：其他
	final static int POINTS_TYPE_NO_6 = 6;
	//积分历史中，类型  6：其他
	final static String POINTS_TYPE_DESC_6 = "其他";
	//积分历史中，类型  6：其他
	final static String POINTS_TYPE_EDESC_6 = "Others";
	//字典表中不存在的加州地址税率
	final static double CA_TAX_RENT = 7.5;
	
	//阿拉斯加对应名称
	final static String PROVINCE_ALASKA = "Alaska";
	//夏威夷对应名称
	final static String PROVINCE_HAWAII = "Hawaii";
	//阿拉斯加夏威夷对应邮寄方式ID
	final static int SHIPPING_ID_ALASKAHAWAII = 3;
	
	//阿拉斯加夏威夷对应邮寄方式ID
	final static String KEY_FINISHORDER_CHECK = "secret";
	

	//REDIS key value of getExpressCheckout
	final static String KEY_EXPRESSCHECKOUT_REDIS = "expressCheckout";
	
	final static int IS_NOT_ON_SALE = 0;

	final static int IS_ON_SALE = 1;
	
	
	//1 公告 2主题 3达人评测 4 米粉评论 5活动 6新品
	final static int DISCOVERY_MSG_TYPE_1 = 1;
	final static int DISCOVERY_MSG_TYPE_2 = 2;
	final static int DISCOVERY_MSG_TYPE_3 = 3;
	final static int DISCOVERY_MSG_TYPE_4 = 4;
	final static int DISCOVERY_MSG_TYPE_5 = 5;
	final static int DISCOVERY_MSG_TYPE_6 = 6;
	//4 搜索 2 品牌 3分类 1单品
	final static int DISCOVERY_TYPE_1 = 1;
	final static int DISCOVERY_TYPE_2 = 2;
	final static int DISCOVERY_TYPE_3 = 3;
	final static int DISCOVERY_TYPE_4 = 4;
	final static int DISCOVERY_TYPE_5 = 5;
	//被邀请人注册送积分值
	final static String INVITE_REGISTER_POINTS = "300";
}
