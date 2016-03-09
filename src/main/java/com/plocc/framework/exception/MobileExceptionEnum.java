package com.plocc.framework.exception;

public enum MobileExceptionEnum implements ExceptionEnum{
	PARAMETER_EXCEPTION("-1","输入参数不合法！"),
	PROCESSING_EXCEPTION("1","操作异常！");
	
	// 构造枚举值
	private MobileExceptionEnum(String code, String message) {
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
