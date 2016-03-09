/**
 * 
 */
package com.plocc.framework.exception.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理接口
 * 
 * @author John
 *
 */
public interface Handler {
	
	/**
	 * 异常处理方法
	 * 
	 * @param request
	 * @param response
	 * @param modelAndView 
	 * @param params 传递参数
	 * @return
	 */
	ModelAndView doHandler(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView, Map<String, Object> params);
	
	/**
	 * 设置{@link ErrorMessage}
	 * 
	 * @param errorMessage
	 */
	void setErrorMessage(ErrorMessage errorMessage);

}
