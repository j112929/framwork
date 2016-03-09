/**
 * 宝龙电商
 * com.plocc.support.web.context
 * PloccHttpServletRequest.java
 *
 * 2013-8-14-下午3:07
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.web.context;

import com.plocc.support.utility.XssHtmlUtility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * PloccHttpServletRequest
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-8-14-下午3:07
 * @email zhanggj-hws@powerlong.com
 * @description 职责描述
 */
public class PloccHttpServletRequest extends HttpServletRequestWrapper {
    public PloccHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public String getParameter(String name) {
        return XssHtmlUtility.encode(super.getParameter(name));
    }

    public String getOriginParameter(String name) {
        return super.getRequest().getParameter(name);
    }

    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (null != values) {
            for (int i = 0; i < values.length; i++) {
                values[i] = XssHtmlUtility.encode(values[i]);
            }
        }
        return values;
    }

    public String[] getOriginParameterValues(String name) {
        return super.getRequest().getParameterValues(name);
    }
}
