/**
 * 
 */
package com.plocc.framework.exception.handler.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.plocc.framework.exception.handler.ErrorMessage;
import com.plocc.framework.exception.handler.Handler;

/**
 * 抽象类
 * 
 * @author John
 *
 */
public abstract class AbstractHandlerImpl implements Handler {
	
	protected static final String ERROR_CODE_KEY = "code";
	
	protected static final String ERROR_MESSAGE_KEY = "msg";

	private Handler nextHandler;
	
	private ErrorMessage errorMessage;
	
	protected String getMessage(String code){
		return errorMessage.getMessage(code);
	}
	
	/**
	 * 获取JSON VIEW
	 * 
	 * @param code
	 * @param message
	 * @return
	 */
	protected View getJsonView(String code, String message){
		MappingJacksonJsonView  view = new MappingJacksonJsonView();
		Map<String, String> map = new HashMap<String,String>();
		map.put(ERROR_CODE_KEY, code);
		map.put(ERROR_MESSAGE_KEY, message);
		view.setAttributesMap(map);
		return view;
	}
	
	/**
	 * 如果下一个异常处理handler存在 ，执行doHandler
	 * 
	 * @param request
	 * @param response
	 * @param modelAndView
	 * @param params
	 * @return
	 */
	protected ModelAndView doNextHandler(HttpServletRequest request,
			HttpServletResponse response, ModelAndView modelAndView,
			Map<String, Object> params){
		if (nextHandler != null) {
			return nextHandler.doHandler(request, response, modelAndView,
					params);
		}
		return modelAndView;
	}

	/**
	 * @param nextHandler the nextHandler to set
	 */
	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}	

}
