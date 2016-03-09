/**
 * 宝龙电商
 * com.plocc.sso.client.interceptor
 * LoginInterceptor.java
 *
 * 2013-7-22-上午11:20
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginInterceptor
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-7-22-上午11:20
 * @email zhanggj-hws@powerlong.com
 * @description 登录监听器
 */
public interface LoginListener {
    /**
     * 登录成功后执行的方法
     *
     * @param authorization
     */
    void success(Authorization authorization, HttpServletRequest request, HttpServletResponse response);

    /**
     * 退出登录后执行的方法
     *
     * @param authorization
     */
    void logout(Authorization authorization);
}
