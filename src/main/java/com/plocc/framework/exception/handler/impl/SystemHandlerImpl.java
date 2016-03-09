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

import com.plocc.framework.exception.SystemException;
import com.plocc.framework.exception.handler.ParamsKey;
import com.plocc.support.utility.ExceptionConstants;

/**
 * 系统异常处理handler
 * 
 * @author John
 *
 */
public class SystemHandlerImpl extends AbstractHandlerImpl {

	@Override
	public ModelAndView doHandler(HttpServletRequest request,
			HttpServletResponse response, ModelAndView modelAndView,
			Map<String, Object> params) {
		SystemException ex = (SystemException) params.get(ParamsKey.EXCEPTION);
		if (StringUtils.isEmpty(request
				.getHeader(ExceptionConstants.JSON_HEADER_NAME))
				&& StringUtils.isEmpty(request
						.getHeader(ExceptionConstants.REQUEST_HEADER_NAME))
				&& StringUtils.isEmpty(request
						.getParameter(ExceptionConstants.JSONP_PARAM_NAME))) {
			modelAndView.setViewName((String) params.get(ParamsKey.ERROR_PAGE));
			modelAndView.addObject(ERROR_CODE_KEY, ex.getExceptionCode());
			modelAndView.addObject(ERROR_MESSAGE_KEY,
					getMessage(ex.getExceptionCode()));
			modelAndView.addObject(ParamsKey.HOME_PAGE,
					params.get(ParamsKey.HOME_PAGE));
		} else if (!StringUtils.isEmpty(request
				.getHeader(ExceptionConstants.REQUEST_HEADER_NAME))
				&& request.getHeader(ExceptionConstants.REQUEST_HEADER_NAME)
						.equalsIgnoreCase(ExceptionConstants.APP_REQUEST)) {
			String code = ex.getExceptionCode().replaceAll("[A-Za-z]", "");
			code = Integer.valueOf(code).toString();
			View view = this.getJsonView(code,
					getMessage(ex.getExceptionCode()));
			modelAndView.setView(view);
		} else {
			View view = this.getJsonView(ex.getExceptionCode(),
					getMessage(ex.getExceptionCode()));
			modelAndView.setView(view);
		}
		modelAndView = doNextHandler(request, response, modelAndView, params);
		return modelAndView;
	}

}
