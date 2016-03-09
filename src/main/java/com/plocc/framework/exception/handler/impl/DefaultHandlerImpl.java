/**
 * 
 */
package com.plocc.framework.exception.handler.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.plocc.framework.exception.handler.ParamsKey;
import com.plocc.support.utility.ExceptionConstants;

/**
 * 默认异常处理handler,处理runtime Exception
 * 
 * @author John
 *
 */
public final class DefaultHandlerImpl extends AbstractHandlerImpl {
	
	private static final String DEFAULT_ERROR_CODE = "D0001";
	
	private static final String DEFAULT_MOBILE_ERROR_CODE = "1";
	
	private static final String DEFAULT_ERROR_MESSAGE = "抱歉！系统繁忙，请稍后重试。";
	
	
	@Override
	public ModelAndView doHandler(HttpServletRequest request,
			HttpServletResponse response, ModelAndView modelAndView,
			Map<String, Object> params) {
		if (StringUtils.isEmpty(request
				.getHeader(ExceptionConstants.JSON_HEADER_NAME))
				&& StringUtils.isEmpty(request
						.getHeader(ExceptionConstants.REQUEST_HEADER_NAME))
				&& StringUtils.isEmpty(request.getParameter(ExceptionConstants.JSONP_PARAM_NAME))) {
			modelAndView.setViewName((String) params.get(ParamsKey.ERROR_PAGE));
			modelAndView.addObject(ERROR_CODE_KEY, DEFAULT_ERROR_CODE);
			modelAndView.addObject(ERROR_MESSAGE_KEY, DEFAULT_ERROR_MESSAGE);
			modelAndView.addObject(ParamsKey.HOME_PAGE,
					params.get(ParamsKey.HOME_PAGE));
		} else if (!StringUtils.isEmpty(request
				.getHeader(ExceptionConstants.REQUEST_HEADER_NAME))
				&& request.getHeader(ExceptionConstants.REQUEST_HEADER_NAME)
						.equalsIgnoreCase(ExceptionConstants.APP_REQUEST)) {
			View view = this.getJsonView(DEFAULT_MOBILE_ERROR_CODE,
					DEFAULT_ERROR_MESSAGE);
			modelAndView.setView(view);
		} else {
			View view = this.getJsonView(DEFAULT_ERROR_CODE,
					DEFAULT_ERROR_MESSAGE);
			modelAndView.setView(view);
		}
		modelAndView = doNextHandler(request, response, modelAndView, params);
		return modelAndView;
	}
	

}
