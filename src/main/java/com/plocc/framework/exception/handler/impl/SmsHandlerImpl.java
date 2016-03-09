/**
 * 
 */
package com.plocc.framework.exception.handler.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author John
 *
 */
public class SmsHandlerImpl extends AbstractHandlerImpl {

	@Override
	public ModelAndView doHandler(HttpServletRequest request,
			HttpServletResponse response, ModelAndView modelAndView,
			Map<String, Object> params) {
		//TODO 待短信接口确认后实现
		modelAndView = doNextHandler(request, response, modelAndView, params);
		return modelAndView;
	}

}
