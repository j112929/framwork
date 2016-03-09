/**
 * 宝龙电商
 * com.plocc.framework.utils
 * MemcachLock.java
 * 
 * 2014-3-2-上午11:37:57
 *  2014宝龙公司-版权所有
 * 
 */
package com.plocc.framework.utils;

import com.plocc.support.utility.ActionContext;


/**
 * MemcachLock
 * @see memcach锁处理工具类
 * zhuhuan
 * 2014-3-2-上午11:37:57
 * @version 1.0.0
 */
public class MemcachLock {
	
	private static MemcachedUtils memcachedUtils;
	private static String keyPrefix = "memcache_lock_service_key_";
	/**
	 * 已锁状态
	 */
	public static final String LOCK_STATUS = "1";
	/**
	 * 未锁状态
	 */
	public static final String UN_LOCK_STATUS = "0";
	
	public static String getkey(String name){
		return keyPrefix + name;
	}
	
	//开始加锁
	public static boolean begin(String name,int maxBlockTime){
		memcachedUtils = ActionContext.getApplicationContext().getBean(MemcachedUtils.class);
		String mKey = getkey(name);
		String lockStatus = memcachedUtils.loadObject(mKey);
		if(StringUtils.isEmpty(lockStatus)){
			memcachedUtils.cacheObject(mKey, LOCK_STATUS, maxBlockTime);
			return true;
		}else{
			return false;
		}
		
	}
	
	//释放锁
	public static void release(String name){
		memcachedUtils = ActionContext.getApplicationContext().getBean(MemcachedUtils.class);
		String mKey = getkey(name);
		memcachedUtils.flushObject(mKey);
	}
}
