/**
 * 
 */
package com.plocc.framework.exception.handler;

/**
 * 异常信息描述接口
 * 
 * @author John
 *
 */
public interface ErrorMessage {
	
	/**
	 * 通过异常代码获取友好异常提示信息
	 * 
	 * @param key 友好异常信息key
	 * @return 友好异常信息
	 */
	String getMessage(String key);

}
