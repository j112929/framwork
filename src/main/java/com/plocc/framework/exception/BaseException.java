/**
 * 宝龙电商
 * org.powerlong.framework.exception
 * BaseException.java
 * 
 * 2013-6-27-下午02:01:53
 *  2013宝龙公司-版权所有
 * 
 */
package com.plocc.framework.exception;

/**
 * BaseException
 * 
 * @see Kira Sun 2013-6-27-下午02:01:53
 * @version 1.0.0
 */
public class BaseException extends Exception {
	private static final long serialVersionUID = 1L;
	protected String exceptionCode;
	protected String message;

	public BaseException() {
		super();
	}

	public BaseException(String code) {
		super();
		if (code != null) {
			this.exceptionCode = code;
		}
	}
	
	public BaseException(ExceptionEnum exceptionEnum) {
		super();
		if (exceptionEnum!= null) {
			this.exceptionCode = exceptionEnum.getCode();
			this.message = exceptionEnum.getMessage();
		}
	}
	
	public BaseException(String code,String message) {
		super();
		if (code != null) {
			this.exceptionCode = code;
		}
		if (message != null) {
			this.message = message;
		}
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
