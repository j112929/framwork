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
public class EmailHandlerImpl extends AbstractHandlerImpl {

	@Override
	public ModelAndView doHandler(HttpServletRequest request,
			HttpServletResponse response, ModelAndView modelAndView,
			Map<String, Object> params) {
		//TODO 待邮件接口确认后实现
		modelAndView = doNextHandler(request, response, modelAndView, params);
		return modelAndView;
	}

}
