/**
 * 
 */
package com.plocc.framework.exception.handler.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.plocc.framework.exception.handler.ParamsKey;
import com.plocc.framework.utils.LoggerUtils;

/**
 * Log日志记录handler
 * 
 * @author John
 *
 */
public class LogHandlerImpl extends AbstractHandlerImpl {
	
	/**
	 * 日志陆金凤
	 */
	private static final String LOG_PATH = "/logs/exception_handler";
	
	/**
	 * log4j 日志对象
	 *
	 * @since 1.0.0
	 */
	private static final Logger LOG = LoggerUtils.getErrorLogger(LOG_PATH, LogHandlerImpl.class);

	@Override
	public ModelAndView doHandler(HttpServletRequest request,
			HttpServletResponse response, ModelAndView modelAndView,
			Map<String, Object> params) {
		//获取异常
		Exception ex = (Exception) params.get(ParamsKey.EXCEPTION);
		//记录LOG
		LOG.error("出现系统异常或未处理的异常, 需要维护人员处理！异常信息：" + ex.getLocalizedMessage(), ex);
		modelAndView = doNextHandler(request, response, modelAndView, params);
		return modelAndView;
	}

}
