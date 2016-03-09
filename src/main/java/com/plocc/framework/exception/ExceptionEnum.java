package com.plocc.framework.exception;

/**
 * 异常枚举类接口
 * 
 * @author John
 *
 */
public interface ExceptionEnum {
	
	/**
	 * 获取异常代码
	 * 
	 * @return 异常代码
	 */
	public String getCode();
	
	/**
	 * 获取异常信息
	 * 
	 * @return 异常信息
	 */
	public String getMessage();

}
