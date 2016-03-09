package com.plocc.support.enums;


/**
 * 
 * MobileParamsEnum
 * 手机接口类中传入传出参数常量
 * 朱欢
 * zhuh
 * 2013-8-15-下午1:44:35
 * 
 * @version 1.0.0
 *  
 */
public enum MobileParamsEnum {
	SEARCH_ITEM_TYPE("item","查询商品"),
	SEARCH_SHOP_TYPE("shop","查询商铺"),
	SEARCH_KEYWORD_TYPE("keyword","查询关键字"),
	SEARCH_GROUPON_TYPE("groupon","查询团购"),
	
	CURRENT_PAGE("page","当前页"),
	SORT_FIELD("sort_field","排序项"),
	SORT_TYPE("sort_type","排序类型"),
	ID("id","主键编号"),
	NAME("name","名称"),
	MALL_ID("mall","所在mall"),
	SHOP_ID("shop_id","商品编号"),
	USER_ID("user_id","用户编号"),
	NAV_ID("navId","导航栏编号"),
	EMAIL("email","用户邮箱"),
	MOBILE("mobile","用户手机号码"),
	CODE("code","验证码,短信验证码"),
	PASSWORD("pwd","用户密码"),
	TGC("TGC","用户凭证"),
	CATEGORY_ID("category_id","类目编号"),
	CLASSIFICATION_ID("classification_id","商品类目编号"),
	FLOOR("floor","楼层"),
	MODIFY_USER_NICKNAME("newNickname","新的昵称"),
	MODIFY_USER_EMAIL("newEmail","新的邮箱"),
	MODIFY_USER_MOBILE("newMobile","新的手机"),
	
	RETURN_CODE("code","返回码"),
	RETURN_CODE_SUCCESS("0","成功"),
	RETURN_MSG("msg","返回信息"),
	RETURN_TYPE("type","返回方法标识"),
	RETURN_DATA("data","返回数据"),
	RETURN_PAGE("page","当前页"),
	RETURN_COUNT("count","记录总数"),
	RETURN_DATA_VERSION("version","接口数据版本号"),
	RETURN_PAGE_SIZE("pageSize","返回分页参数，每页行数"),
	RETURN_NAVIGATION_LIST("navigationList","接口数据版本号"),
	RETURN_SHOP_LIST("shopList","商铺列表"),
	RETURN_KEYWORD_LIST("keyList","关键字列表"),
	RETURN_SHOP("shop","商铺信息"),
	RETURN_ITEM_LIST("itemList","商品列表"),
	RETURN_ITEM("item","商品信息"),
	RETURN_ACTIVITY_LIST("activityList","活动列表"),
	RETURN_ACTIVITY("activity","活动信息"),
	RETURN_ADDRESS_LIST("addressList","收货地址列表"),
	RETURN_COMMUNITY_LIST("communityList","配送地址列表"),
	RETURN_ADDRESS("address","收货地址信息"),
	
	
	FAVOUR_LIST("favourList","收藏编号集合"),
	FAVOUR_ID("favourID","收藏编号"),
	ITEM_LIST("itemList","商品集合"),
	ITEM_ID("id","商品ID"),
	ITEM_TYPE("type","商品类别"),
	PAGE("page","当前所在页"),
	COUPON_TYPE("type","团购类型"),
	MALL("mall","mallId"),
	ORDER_ID("orderId","订单id"),
	GROUPON_ID("grouponId","团购id"),
	KEY_WORD("keyword","搜索关键字"),
	FAVOUR_ITEM_ID("itemId","需要收藏的商品ID"),
	ITEM_PER_PAGE("itemPerPage","每页显示条数"),
	BUY_NUM("buyNum","购买数量"),
	ADDRESSID("addressId","收货地址id"),
	LOGISTICSID("logisticsId","物流id"),
	PAYID("payId","支付方式"),
	RECEIVETIME("receiveTime","收货时间"),
	PRICE("price","总价格"),
	FREIGHT("freight","运费"),
	PLCASHCOUPONID("plCashCouponId","宝龙抵用券"),
	CASHCOUPONID("cashCouponId","店铺抵用券"),
	MESSAGE("message","店铺留言"),
	PLPRICE("plPrice","宝龙价格"),
	ITEMBARGAINLIST("itemBargainList","商品优惠"),
	OPERATE("operate","订单操作码"),
	ITEM_NAME("itemName","商品名称"),
	FROM_TYPE("fromType","0：从购物车添加；1：直接从商品添加"),
	SHOP_NAME("shopName","店铺名称"),
	FAVOUR_SHOP_ID("shopId","店铺ID"),
	SENDER_ID("senderId","发送人ID")
	;
	
	
	
	public String key;
	public String value;
	
	private MobileParamsEnum(String key,String value) {
		this.key = key;
		this.value = value;
	}
}
