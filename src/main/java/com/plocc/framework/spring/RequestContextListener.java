/**
 * 宝龙电商
 * com.plocc.framework.spring
 * RequestContextListener.java
 *
 * 2013-8-14-上午11:31
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.spring;

import com.plocc.support.web.context.PloccHttpServletRequest;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * RequestContextListener
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-8-14-上午11:31
 * @email zhanggj-hws@powerlong.com
 * @description 防止 XSS 攻击，转义 表单中 HTML 脚本
 */
public class RequestContextListener extends org.springframework.web.context.request.RequestContextListener {

    private static final String REQUEST_ATTRIBUTES_ATTRIBUTE = RequestContextListener.class.getName() + ".REQUEST_ATTRIBUTES";

    public void requestInitialized(ServletRequestEvent requestEvent) {
        if (!(requestEvent.getServletRequest() instanceof HttpServletRequest)) {
            throw new IllegalArgumentException(
                    "Request is not an HttpServletRequest: " + requestEvent.getServletRequest());
        }
        HttpServletRequest request = new PloccHttpServletRequest((HttpServletRequest) requestEvent.getServletRequest());
        ServletRequestAttributes attributes = new ServletRequestAttributes(request);
        request.setAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE, attributes);
        LocaleContextHolder.setLocale(request.getLocale());
        RequestContextHolder.setRequestAttributes(attributes);
    }

    public void requestDestroyed(ServletRequestEvent requestEvent) {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) requestEvent.getServletRequest().getAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE);
        ServletRequestAttributes threadAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (threadAttributes != null) {
            // We're assumably within the original request thread...
            if (attributes == null) {
                attributes = threadAttributes;
            }
            LocaleContextHolder.resetLocaleContext();
            RequestContextHolder.resetRequestAttributes();
        }
        if (attributes != null) {
            attributes.requestCompleted();
        }
    }
}
