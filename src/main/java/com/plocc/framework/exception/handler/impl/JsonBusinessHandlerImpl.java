/**
 * 
 */
package com.plocc.framework.exception.handler.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

//import com.plocc.framework.exception.JsonBusinessException;
import com.plocc.framework.exception.handler.ParamsKey;

/**
 * AJAX业务异常处理handler
 * 
 * @author John
 *
 */
@Deprecated
public class JsonBusinessHandlerImpl extends AbstractHandlerImpl {

	@Override
	public ModelAndView doHandler(HttpServletRequest request,
			HttpServletResponse response, ModelAndView modelAndView,
			Map<String, Object> params) {
		//JsonBusinessException ex = (JsonBusinessException) params
		//		.get(ParamsKey.EXCEPTION);
		//View view = this.getJsonView(ex.getExceptionCode(), getMessage(ex.getExceptionCode()));
		//modelAndView.setView(view);
		modelAndView = doNextHandler(request, response, modelAndView, params);
		return modelAndView;
	}

}
