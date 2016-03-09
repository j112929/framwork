/**
 * 宝龙电商
 * com.plocc.framework.session
 * SessionUtils.java
 * 
 * 2013-9-2-上午11:37:57
 *  2013宝龙公司-版权所有
 * 
 */
package com.plocc.framework.session;

import javax.servlet.http.HttpServletRequest;

import com.plocc.framework.utils.MemcachedUtils;

/**
 * SessionUtils
 * @see session处理工具类
 * Kira Sun
 * 2013-9-2-上午11:37:57
 * @version 1.0.0
 */
public class SessionUtils {
	
	private MemcachedUtils memcachedUtils;
	
	/**
	 * 
	 * get(从seession中获取对象)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param request 当前request对象 
	 * @param key
	 * @return 
	 *T
	 * @exception 
	 * @since  1.0.0
	 */
	public  <T> T get(HttpServletRequest request, String key){
		return (T)memcachedUtils.sessionGet(request, key);
	}
	
	/**
	 * 
	 * get(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param <T>
	 * @param jsessionId Cookie中key为ploccSessionId的值 
	 * @param key
	 * @return 
	 *T
	 * @exception 
	 * @since  1.0.0
	 */
	public  <T> T get(String jsessionId, String key){
		return (T)memcachedUtils.sessionGet(jsessionId, key);
	}
	
	/**
	 * 
	 * put(将简单对象放入session)
	 * (不能将List Map等复杂对象插入)
	 * @param request 当前对象
	 * @param key    插入关键字
	 * @param value  插入对象
	 * @return 
	 * @exception 
	 * @since  1.0.0
	 */
	public  void  put(HttpServletRequest request,String key, Object value){
		 memcachedUtils.sessionPut(request, key, value);
	}
	
	/**
	 * 
	 * put(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param jsessionId Cookie中key为ploccSessionId的值 
	 * @param key
	 * @param value 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public  void  put(String jsessionId,String key, Object value){
		memcachedUtils.sessionPut(jsessionId, key, value);
	}
	
	/**
	 * 
	 * remove(清理对象)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param jsessionId
	 * @param key 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public  void  remove(String jsessionId,String key){
		 memcachedUtils.sessionFlush(jsessionId, key);
	}
	
	/**
	 * 
	 * remove(清理对象)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param request
	 * @param key 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public  void  remove(HttpServletRequest request,String key){
		 memcachedUtils.sessionFlush(request, key);
	}
	

	public MemcachedUtils getMemcachedUtils() {
		return memcachedUtils;
	}

	public void setMemcachedUtils(MemcachedUtils memcachedUtils) {
		this.memcachedUtils = memcachedUtils;
	}
	
	
}
