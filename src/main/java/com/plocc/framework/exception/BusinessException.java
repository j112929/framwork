/**
 * 宝龙电商
 * org.powerlong.framework.exception
 * BusinessException.java
 * 
 * 2013-6-27-下午02:08:05
 *  2013宝龙公司-版权所有
 * 
 */
package com.plocc.framework.exception;

public class BusinessException extends BaseException {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 7311875829572909766L;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String code) {
		super();
		if (code != null) {
			super.exceptionCode = code;
		}
	}
	
	public BusinessException(ExceptionEnum exceptionEnum) {
		super();
		if (exceptionEnum!= null) {
			super.exceptionCode = exceptionEnum.getCode();
			super.message = exceptionEnum.getMessage();
		}
	}
	
}
