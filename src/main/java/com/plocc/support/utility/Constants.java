/**
 * 宝龙电商
 * com.plocc.auth.common.utility
 * Constants.java
 *
 * 2013-7-18-下午7:50
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.utility;

/**
 * Constants
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-7-18-下午7:50
 * @email zhanggj-hws@powerlong.com
 * @description 常量类
 */
public class Constants {

    // SESSION 中存放 用户信息的 KEY
    public final static String CAS_AUTHENTICATION_KEY = "cas_authentication_key";
    // 重定向
    public final static String CAS_REDIRECT_URL_KEY = "redirect";

    /**
     * Web层
     */
    /*================== COOKIE ticket redirectURL =================================================================*/
    // 票据
    public final static String CAS_TICKET_KEY = "ticket";
    // 退出请求
    public final static String CAS_LOGOUT_KEY = "cas_logout";
    /**
     * 搜索引擎默认查询条数
     */
    public final static int SEARCH_PAGE_SIZE = 20;
    /**
     * 搜索引擎关键字默认查询条数
     */
    public final static int SEARCH_KEY_PAGE_SIZE = 10;


    /**
     * 是否
     */
    /*================== COOKIE ticket redirectURL =================================================================*/
    public final static int DEL_STAT_ON = 1;
    public final static int DEL_STAT_OFF = 0;

}
