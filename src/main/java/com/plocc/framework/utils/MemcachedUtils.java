/**
 * 宝龙电商
 * org.powerlong.sso.common.utility
 * MemcachedUtils.java
 *
 * 2013-5-13-下午02:13:33
 *  2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.utils;

import com.plocc.support.utility.WebUtility;
import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Map;

/**
 * MemcachedUtils
 * <p/>
 * Kira Sun 2013-5-13-下午02:13:33
 * 
 * @version 1.0.0
 */
public class MemcachedUtils {

	/**
	 * 冲突键
	 */
	public static final String MUTEX_KEY_PREFIX = "MUTEX_";

	/**
	 * 冲突延时 1秒
	 */
	public static final int MUTEX_EXP = 1;

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MemcachedUtils.class);
	/**
	 * Memcached Client
	 */
	private MemcachedClient memcachedClient;

	private int expireTime=7200;

	private String domain;

	/**
	 * cacheObject(緩存對象) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param key
	 * @param value
	 * @param exp
	 *            void
	 * @throws
	 * @since 1.0.0
	 */
	public void cacheObject(String key, Object value, int exp) {
		try {
			memcachedClient.set(key, exp, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("Cache Object: [" + key + "]");
	}

	/**
	 * 
	 * sessionPut(session插入) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param jsessionId
	 *            Cookie中key为ploccSessionId的值
	 * @param key
	 *            插入关键字
	 * @param value
	 *            插入值 void
	 * @exception
	 * @since 1.0.0
	 */
	public void sessionPut(String jsessionId, String key, Object value) {
		HashSet<String> set = this.loadObject(jsessionId);
		if (set == null) {
			set = new HashSet<String>();
		}
		set.add(key);
		try {
			this.cacheObject(jsessionId, set, expireTime == 0 ? 60 * 30: expireTime);
			this.cacheObject(jsessionId + "_" + key, value,expireTime == 0 ? 60 * 30 : expireTime);
		} catch (Exception e) {
            logger.debug("Cache Object: [" + jsessionId + "]cas存储失败");
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * sessionPut(session插入) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param request
	 *            当前request对象
	 * @param key
	 *            插入关键字
	 * @param value
	 *            插入值 void
	 * @exception
	 * @since 1.0.0
	 */
	public void sessionPut(HttpServletRequest request, String key, Object value) {
		Map cookie = WebUtility.getCookies(request);
		String jsessionId = (String) cookie.get("ploccSessionId");
		this.sessionPut(jsessionId, key, value);
	}

	/**
	 * 
	 * sessionGet(session获取) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param <T>
	 * @param jsessionId
	 *            Cookie中key为ploccSessionId的值
	 * @param key
	 *            关键值
	 * @return T
	 * @exception
	 * @since 1.0.0
	 */
	public <T> T sessionGet(String jsessionId, String key) {
		try {
			memcachedClient.touch(jsessionId + "_" + key,
					expireTime == 0 ? 60 * 30 : expireTime);
			return (T) this.loadObject(jsessionId + "_" + key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("Cache Object: [" + key + "]");
		return null;
	}

	/**
	 * 
	 * sessionGet(session获取) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param <T>
	 * @param request
	 *            当前request对象
	 * @param key
	 *            关键值
	 * @return T
	 * @exception
	 * @since 1.0.0
	 */
	public <T> T sessionGet(HttpServletRequest request, String key) {
		Map cookie = WebUtility.getCookies(request);
		String jsessionId = (String) cookie.get("ploccSessionId");
		return (T) this.sessionGet(jsessionId, key);
	}

	/**
	 * 
	 * flushBatch(批量刷新时间) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param jsessionId
	 *            void
	 * @exception
	 * @since 1.0.0
	 */
	public void flushBatch(String jsessionId) {
		HashSet<String> set = this.loadObject(jsessionId);
		try {
			memcachedClient.getAndTouch(jsessionId, expireTime == 0 ? 60 * 30 : expireTime);
			if (set != null) {
				for (String key : set) {
					memcachedClient.getAndTouch(jsessionId + "_" + key,
							expireTime == 0 ? 60 * 30 : expireTime);
				}
			}
			logger.debug("touch Object: [" + jsessionId + "]");
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("touch Object: [" + jsessionId + "] failed");
		}
	}
	
	public void sessionFlush(HttpServletRequest request, String key) {
		Map cookie = WebUtility.getCookies(request);
		String jsessionId = (String) cookie.get("ploccSessionId");
		this.sessionFlush(jsessionId, key);
	}
	
	public void sessionFlush(String jsessionId, String key) {
		try {
			flushObject(jsessionId + "_" + key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("Flush Object: [" + jsessionId + "_" + key + "]");
	}

	/**
	 * flushObject(清理对象) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param key
	 *            void
	 * @throws
	 * @since 1.0.0
	 */
	public void flushObject(String key) {
		try {
			memcachedClient.deleteWithNoReply(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("Flush Object: [" + key + "]");
	}

	/**
	 * isMutex(冲突判定) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param key
	 * @return boolean
	 * @throws
	 * @since 1.0.0
	 */
	public boolean isMutex(String key) {
		return isMutex(key, MUTEX_EXP);
	}

	/**
	 * isMutex(冲突判定) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param key
	 * @param exp
	 * @return boolean
	 * @throws
	 * @since 1.0.0
	 */
	public boolean isMutex(String key, int exp) {
		boolean status = true;
		try {
			if (memcachedClient.add(MUTEX_KEY_PREFIX + key, exp, "true")) {
				status = false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return status;
	}

	/**
	 * loadObject(加载对象) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param <T>
	 * @param key
	 * @return T
	 * @throws
	 * @since 1.0.0
	 */
	public <T> T loadObject(String key) {
		T object = null;
		try {
			object = memcachedClient.<T> get(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("Load Object: [" + key + "]");
		return object;
	}
    /**
     * loadObjectByKey(加载对象key+obj.toString()) (这里描述这个方法适用条件 – 可选)
     *
     * @param <T>
     * @param key
     * @return T
     * @throws
     * @since 1.0.0
     */
    public <T> T loadObjectByKey(String key,Object obj) {
        T object = null;
        try {
            object = memcachedClient.<T> get(key + obj.toString());
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        logger.debug("Load Object: [" + key + obj.toString() + "]");
        return object;
    }

	/**
	 * ******************** getter&&setter *************************
	 */
	public MemcachedClient getMemcachedClient() {
		return memcachedClient;
	}

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
