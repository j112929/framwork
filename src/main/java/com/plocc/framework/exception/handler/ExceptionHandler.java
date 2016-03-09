/**
 * 
 */
package com.plocc.framework.exception.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.plocc.framework.exception.handler.factory.HandlerFactory;

/**
 * 异常处理入口
 * 
 * @author John
 *
 */
public class ExceptionHandler implements HandlerExceptionResolver {
	
	/**
	 * 是否发送邮件
	 */
	private Boolean isSendEmail;
	
	
	/**
	 * 是否发送短信
	 */
	private Boolean isSendSms;
	
	/**
	 * email地址
	 */
	private String email;
	
	/**
	 * 电话号码
	 */
	private String phoneNum;
	
	/**
	 * 异常页面
	 */
	private String errorPage;
	
	
	/**
	 * 系统首页
	 */
	private String homePage;
	
	private HandlerFactory handlerFactory;
	
	private ErrorMessage errorMessage;

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		Handler exceptionHandler = getHandlerFactory().getHandler(ex.getClass());
		exceptionHandler.setErrorMessage(errorMessage);
		Map<String, Object> params = buildParams(ex);
		modelAndView = exceptionHandler.doHandler(request, response, modelAndView, params);
		return modelAndView;
	}

	/**
	 * 传递参数构成
	 * 
	 * @param ex
	 * @return
	 */
	private Map<String, Object> buildParams(Exception ex) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ParamsKey.EMAIL_ADDRESS, getEmail());
		params.put(ParamsKey.ERROR_PAGE, getErrorPage());
		params.put(ParamsKey.EXCEPTION, ex);
		params.put(ParamsKey.HOME_PAGE, getHomePage());
		params.put(ParamsKey.IS_SEND_EMAIL, getIsSendEmail());
		params.put(ParamsKey.IS_SEND_SMS, getIsSendSms());
		params.put(ParamsKey.PHONE_NUMBER, getPhoneNum());
		return params;
	}

	/**
	 * @return the isSendEmail
	 */
	public Boolean getIsSendEmail() {
		if(isSendEmail == null){
			return false;
		}
		return isSendEmail;
	}

	/**
	 * @param isSendEmail the isSendEmail to set
	 */
	public void setIsSendEmail(Boolean isSendEmail) {
		this.isSendEmail = isSendEmail;
	}

	/**
	 * @return the isSendSms
	 */
	public Boolean getIsSendSms() {
		if(isSendSms == null){
			return false;
		}
		return isSendSms;
	}

	/**
	 * @param isSendSms the isSendSms to set
	 */
	public void setIsSendSms(Boolean isSendSms) {
		this.isSendSms = isSendSms;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return the errorPage
	 */
	public String getErrorPage() {
		return errorPage;
	}

	/**
	 * @param errorPage the errorPage to set
	 */
	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

	/**
	 * @return the homePage
	 */
	public String getHomePage() {
		return homePage;
	}

	/**
	 * @param homePage the homePage to set
	 */
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	/**
	 * @return the handlerFactory
	 */
	public HandlerFactory getHandlerFactory() {
		return handlerFactory;
	}

	/**
	 * @param handlerFactory the handlerFactory to set
	 */
	public void setHandlerFactory(HandlerFactory handlerFactory) {
		this.handlerFactory = handlerFactory;
	}

	/**
	 * @return the errorMessage
	 */
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
