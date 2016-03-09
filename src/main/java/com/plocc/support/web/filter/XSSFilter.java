/**
 * 宝龙电商
 * com.plocc.framework.filter
 * XSSFilter.java
 *
 * 2013-8-14-上午9:50
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.web.filter;

import com.plocc.support.web.context.PloccHttpServletRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * XSSFilter
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-8-14-上午9:50
 * @email zhanggj-hws@powerlong.com
 * @description 防止 XSS 攻击，转义 表单中 HTML 脚本
 */
public class XSSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new PloccHttpServletRequest((HttpServletRequest) request), response);
    }

    public void destroy() {
    }
}
