package com.plocc.framework.exception;

public enum ExceptionEnumImpl implements ExceptionEnum{
	DATA_COLLECTION_EXCEPTION("S0001","行为收集系统记录异常！"),
	SEND_SMS_EXCEPTION("S0002","短信发送异常！"),
	SEND_EMAIL_EXCEPTION("S0003","邮件发送异常！"),
	USER_REGISTER_EXCEPTION("Y0001","用户注册失败！"),
	NO_THIS_ITEM("0000","没有此商品"),
	NO_THIS_USER("0001","没有此用户"),
	DB_CANOT_CONNECT("1000","数据库无法连接"),
	INSUFFICIENT_BALANCE("0002","余额不足"),
	PASSWORD_NOT_CORRECT("0003","密码不正确"),
	NO_THIS_FILE("S0004","获取图片信息异常");
	// 构造枚举值
	private ExceptionEnumImpl(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String toString() { // 覆盖了父类Enum的toString()
		return super.toString() + "(" + code + "," + message + ")";
	}
	
	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
