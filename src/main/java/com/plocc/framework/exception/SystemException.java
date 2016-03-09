/**
 * 宝龙电商
 * org.powerlong.framework.exception
 * SystemException.java
 * 
 * 2013-6-27-下午02:08:05
 *  2013宝龙公司-版权所有
 * 
 */
package com.plocc.framework.exception;

/**
 * SystemException
 * @see
 * Kira Sun
 * 2013-6-27-下午02:08:05
 * @version 1.0.0
 */
public class SystemException extends BaseException {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = -1344852932375992652L;
	
	public SystemException() {
		super();
	}

	public SystemException(String code) {
		super();
		if (code != null) {
			super.exceptionCode = code;
		}
	}
	
	public SystemException(ExceptionEnum exceptionEnum) {
		super();
		if (exceptionEnum!= null) {
			super.exceptionCode = exceptionEnum.getCode();
			super.message = exceptionEnum.getMessage();
		}
	}

}
