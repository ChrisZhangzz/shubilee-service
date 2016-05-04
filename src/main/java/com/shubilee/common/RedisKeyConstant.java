package com.shubilee.common;



public interface RedisKeyConstant {


	//cart
	final static String REDIS_KEY_CART_INFO = "cart_info:"; 
	//orderGenerate
	final static String REDIS_KEY_ORDER_GENERATE_INFO = "orderGenerate_info:"; 
	//lottery
	final static String REDIS_KEY_LOTTERY_SET_INFO = "lottery_set"; 
	//lottery_config
	final static String REDIS_KEY_LOTTERY_CONFIG_INFO = "lottery_config:"; 
	//lottery_config
	final static String REDIS_KEY_LOTTERY_USER_HISTORY_INFO = "lottery_user_log:"; 
	//cart
	final static String REDIS_KEY_YM_ZIPCODE_INFO = "ym_zipcode";
	
	//cart
	final static String REDIS_KEY_SHOP_ZIPCODE_INFO = "shop_zipcode_limit:";
	
	//cart
	final static String REDIS_KEY_SHIPPING_ZIPCODE_INFO = "shipping_zipcode_limit:";
	
	//discovery
	final static String REDIS_KEY_DISCOVERY_INFO = "discovery_info"; 
	//discovery
	final static String REDIS_KEY_DISCOVERY_INFO_TOP = "discovery_info_top"; 
	//discovery
	final static String REDIS_KEY_DISCOVERY_MAX_REC_ID = "discovery_max_rec_id"; 
}
