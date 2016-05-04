package com.shubilee.common;

public enum ErrorCodeEnum {
	ER1001("Token expired.","Token过期"),
	ER1002("Token service failed.","Token服务返回错误"),
	ER1003("Invalid token.","错误的Token"),
	ER1004("Need login","需要登录"),
	ER1005("Database error occurred.","数据库错误"),	
	ER1006("An exception occurred.","系统异常发生"),
	


	/*--------------User Service ErrorCode Area-------------------*/
	ER1301("Invalid user and password.","用户名密码不匹配"),
	ER1302("User email already exist.","邮箱已经用过"),
	ER1303("User name already exist.","用户名已存在"),
	ER1304("The last request is processing, please wait for respond.","上次请求正在处理，请稍后再试"),
	ER1305("Invalid request. Please request again.","请求错误，请重新找回密码"),
	ER1306("Request expired. Please request again.","请求过期，请重新找回密码"),
	ER1307("User email does not exist.","邮箱不存在"),
	ER1311("Failed to handle payment method.","修改支付方式失败"),
	ER1312("Payment method does not exist. Please add a payment method.","该支付方式不存在，请重新添加支付方式"),
	ER1313("Error validating card/account number.","银行卡号验证错误，请检查"),
	ER1321("The address does not exist.","该地址不存在"),
	ER1322("The billing address does not exist.","没有绑定账单地址"),
	ER1331("Cannot process payment. A error has occurred.","支付失败，有异常发生"),
	ER1332("Cannot process payment. Amounts are not equal.","支付失败，金额不一致"),
	ER1333("Declined.","支付失败"),
	ER1334("Invalid integral data.","积分数据读取错误"),
	/*--------------Payment Service ErrorCode Area----------------*/
	ER1401("Cannot get configuration file of PayPal. Please re-login PayPal.","不能设定PayPal，请重新登录PayPal"),
	ER1402("Cannot process service of PayPal. Please re-login PayPal.","PayPal服务错误，请重新登录PayPal"),
	ER1403("The transaction didn't complete successfully.Please re-login PayPal.","付款失败，请重新登录PayPal"),	
	ER1404("A successful transaction has already been completed for this token. Please contact customer service.","这个订单已经提交过了，请联系客服"),
	ER1405("No valid PayPal information found. Please login to your PayPal","未找到PayPal用户信息，请重新登录PayPal"),
	ER1406("The transaction didn't complete successfully. Please contact customer service.","付款异常，请联系客服"),		
	/*---------------UPS and USPS Service ErrorCode Area------------------*/
	ER1451("Cannot process service of UPS. A error has occurred.","UPS服务错误，有异常发生"),
	ER1452("No tracking information available.","地址追踪信息不可用"),
	ER1453("Invalid tracking number","订单追踪号码不存在或无效"),
	ER1461("Cannot process service of USPS. A error has occurred.","USPS服务错误，有异常发生"),
	ER1462("The Postal Service could not locate the tracking information for your request. Please verify your tracking number and try again later.","不能定位地址信息，请检查tracking number再试一次"),
	
	ER1463("Several addresses matched the information you provided. Perhaps you didn't enter a street number or the building has multiple units.","找到多个地址，可能没有输入街道地址或该地址存在多个unit"),
	ER1464("The address you entered was found but more information is needed (such as an apartment, suite, or box number) to match to a specific address.","可能需要更多的信息（门牌号，信箱号等）来定位正确地址"),
	ER1465("The address you provided is not recognized by the US Postal Service as an address. Mail sent to this address may be returned.","您输入的地址在usps地址库不存在，发到该地址的包裹可能被退回"),
	ER1466("Unfortunately, this address wasn't found. Please double-check it and try again.","很抱歉您输入的地址未找到，请检查下输入的地址信息"),
	ER1467("Invalid City. Please double-check it and try again.","城市名不可用，请检查下输入的地址信息"),
	ER1468("Invalid Zip Code. Please double-check it and try again.","邮编不可用，请检查下输入的地址信息"),	
	ER1469("Invalid City and Zip Code combination. Please double-check it and try again.","城市名和邮编不匹配，请检查下输入的地址信息"),

	/*---------------Cart Service ErrorCode Area------------------*/
	//商品已经下架
	ER1101("The item is no longer for sale","商品已经下架"),
	//够买的数量已经超过限购数量
	ER1102("Exceed the amount allowed per order","够买的数量已经超过限购数量"),
	//库存不足暂停销售
	ER1103("out of stock","库存不足"),
	//购物车更新失败
	ER1104("Fail to update the cart","购物车更新失败"),
	//使用折扣码失败
	ER1105("Fail to apply promo code","您输入的折扣码不存在或已失效，请重新输入"),
	//收货地址为空
	ER1106("Please enter shipping address","您尚未填写收货地址"),
	//支付方式为空
	ER1107("Please enter payment method","请选择支付方式"),
	//配货方式为空
	ER1108("Please choose delivery option","请选择配货方式"),
	//账单地址方式为空
	ER1109("Please enter billing address for payment option","所选支付方式未绑定账单地址"),
	//账单地址方式为空
	ER1110("Please choose USPS-Alaska/Hawaii as the delivery option","阿拉斯加或夏威夷请重新选择邮寄方式"),
	//账单地址方式为空
	ER1114("Please don't choose USPS-Alaska/Hawaii as the delivery option","不能选择阿拉斯加或夏威夷的邮寄方式"),
	//账单地址方式为空
	ER1111("Marketplace items cannot be delivered to Alaska/Hawaii","第三方供货商不支持配送阿拉斯加或夏威夷"),
	//库存不足暂停销售
	ER1112("Sold out","您的购买数量已经超过限购数量"),
	//finishOrder加密验证
	ER1113("error request","错误请求"),
	//finishOrder加密验证
	ER1115("gift could not join cart","无法添加赠品到购物车"),
	//使用折扣码失败
	ER1116("Fail to apply promo code","商品金额未达到折扣码使用标准，或折扣金额为0，折扣码使用失败"),
	//区域限购商品
	ER1117("Regional restriction items","区域限购商品"),
	/*---------------Cart Service ErrorCode Area------------------*/
	
	/*---------------Order Service ErrorCode Area------------------*/
	//订单金额变化
	ER1201("amount change","订单金额变化"),
	//订单金额变化
	ER1202("items change，please check cart","订单商品变化，请检查并刷新购物车"),
	//订单金额变化
	ER1203("cart is empty,pleae choose items","订单商品由于库存不足，已自动删除，购物车无商品信息，请选择商品"),
	/*---------------Order Service ErrorCode Area------------------*/
	
	/*---------------Goods Service ErrorCode Area------------------*/
	ER1501("Sorry, the cat_id is not exist or equal to zero",""),
	ER1502("No item belong to this brand temporally","该品牌暂时没有商品"),

	
	/*---------------Goods Service ErrorCode Area------------------*/
	ER1601("Incorrect user name","用户名错误"),
	
	ER1602("Incorrect password","密码错误"),
	
	ER1603("Invalid user name format","用户名格式错误"),
	
	ER1604("Invalid password, must be at least 6 characters","密码错误,必须大于6位"),
	
	ER1605("Please enter your cell phone number","请您填写手机号"),
	
	ER1606("Invalid last name","姓氏错误,请填写正确"),
	ER1626("Shipping Address:Invalid last name","收货地址:姓氏错误,请填写正确"),
	
	ER1607("Invalid first name","名字错误,请填写正确"),
	ER1627("Shipping Address:Invalid first name","收货地址:名字错误,请填写正确"),
	
	ER1608("Invalid address 1","地址错误,请填写地址 1"),
	ER1628("Shipping Address:Invalid address 1","收货地址:地址错误,请填写地址 1"),
	
	ER1609("Invalid city","请正确填写城市"),
	ER1629("Shipping Address:Invalid city","收货地址:请正确填写城市"),
	ER1610("Invalid zip code","邮编错误,请正确填写"),
	ER1620("Shipping Address:Invalid zip code","收货地址:邮编错误,请正确填写"),
	ER1611("Invalid phone number","请正确填写电话"),
	ER1621("Shipping Address:Invalid phone number","收货地址:请正确填写电话"),
	ER1612("Invalid email address","电子邮件格式错误,请正确填写"),
	ER1622("Shipping Address:Invalid email address","收货地址:电子邮件格式错误,请正确填写"),
	ER1613("Invalid card number","银行卡号错误,请正确填写"),
	
	ER1614("Please use English alphabet for names","姓名栏不能输入中文"),
	ER1624("Shipping Address:Please use English alphabet for names","收货地址:姓名栏不能输入中文"),
	ER1615("Please use English alphabet for addresses","地址栏不能输入中文"),
	ER1625("Shipping Address:Please use English alphabet for addresses","收货地址:地址栏不能输入中文"),
	ER1616("We don't support this type of card yet","此类银行卡暂时不支持,请重新填写"),
	
	
	
	ER1630("Shipping Address:Please use English alphabet for names","收货地址:姓名栏不能输入中文"),
	ER1631("Shipping Address:Please use English alphabet for address1","收货地址:地址1栏不能输入中文"),
	ER1632("Shipping Address:Please use English alphabet for address2","收货地址:地址2栏不能输入中文"),
	ER1633("Shipping Address:Please use English alphabet for country","收货地址:国家栏不能输入中文"),
	ER1634("Shipping Address:Please use English alphabet for province","收货地址:州 不能输入中文"),
	ER1635("Shipping Address:Please use English alphabet for city","收货地址:城市不能输入中文"),
	
	
	ER1636("billing Address:Please use English alphabet for names","账单地址:姓名栏不能输入中文"),
	ER1637("billing Address:Please use English alphabet for address1","账单地址:地址1栏不能输入中文"),
	ER1638("billing Address:Please use English alphabet for address2","账单地址:地址2栏不能输入中文"),
	ER1639("billing Address:Please use English alphabet for country","账单地址:国家栏不能输入中文"),
	ER1640("billing Address:Please use English alphabet for province","账单地址:州 不能输入中文"),
	ER1641("billing Address:Please use English alphabet for city","账单地址:城市不能输入中文"),
	ER1642("Invalid  Invitation code ","邀请码错误，请重新输入"),
	ER1643("shipping method is wrong","配送方式错误，请重新选择"),
	/*------------------------Good database ------------------------------*/
	
	/*------------------------goods Param check ------------------------------*/
	ER1701("goods id errror","请输入正确的商品编码"),
	ER1702("cat_id error","请输入正确的分类编码"),
	/*------------------------goods Param check ------------------------------*/
	
	/*------------------------lottery check ------------------------------*/
	ER1801("Prizes have ran out. Come back earlier tomorrow!","今日奖池积分已经不足，明日请尽早!!"),
	ER1802("You have used all your chances. Come back tomorrow!","您今天的机会用光啦，明天继续吧"),
	ER1803("No raffle today.","今日无抽奖活动，请关注官方信息");
	/*------------------------lottery check ------------------------------*/
	
	
	
	
	
	
	
	

	private String emsg;
	private String cmsg;

	private ErrorCodeEnum(String emsg,String cmsg) {
		this.emsg = emsg;
		this.cmsg = cmsg;
	}
	
	public String[] getMsg() {
		String msg[] = new String[2];
		msg[0] = emsg;
		msg[1] = cmsg;
		return msg;
	}
	
	public String getCMsg() {
		return cmsg;
	}
	
	public String getEMsg() {
		return emsg;
	}
	
}
