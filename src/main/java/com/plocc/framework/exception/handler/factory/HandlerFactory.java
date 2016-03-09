/**
 * 
 */
package com.plocc.framework.exception.handler.factory;

import java.util.Map;

import com.plocc.framework.exception.handler.Handler;


/**
 * 异常处理工厂类
 * 
 * @author John
 *
 */
public final class HandlerFactory {

	/**
	 * handler map
	 */
	private Map<Class<?>, Handler> handlerMap;
	
	/**
	 * 默认handler
	 */
	private Handler defaultHandler;

	/**
	 * 获取对应handler
	 * 
	 * @param clazz
	 * @return
	 */
	public Handler getHandler(Class<?> clazz){
		Handler handler = handlerMap.get(clazz);
		if(handler == null){
			handler =  defaultHandler;
		}
		return handler;
	}

	/**
	 * @param handlerMap the handlerMap to set
	 */
	public void setHandlerMap(Map<Class<?>, Handler> handlerMap) {
		this.handlerMap = handlerMap;
	}

	/**
	 * @param defaultHandler the defaultHandler to set
	 */
	public void setDefaultHandler(Handler defaultHandler) {
		this.defaultHandler = defaultHandler;
	}
	
	

}
