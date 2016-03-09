/**
 * 宝龙电商
 * org.powerlong.sso.common.utility
 * WebUtility.java
 *
 * 2013-7-2-上午11:00
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.utility;

import com.plocc.framework.utils.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;

/**
 * WebUtility
 *
 * @author Zhanggj
 * @version 1.0.0
 * @email zhanggj-hws@powerlong.com
 * @date 2013-7-2-上午11:02
 * @description Web层辅助工具类
 */
public class WebUtility {

    private static String fileServerURL = Configuration.getProperties("/filestore.properties").getProperty("accessUrl");
    private static Logger logger = Logger.getLogger(WebUtility.class);

    /**
     * 返回不带HTTP://的服务器全路径
     *
     * @param 文件存储路径
     * @return 返回file.property中的accessUrl
     */
    public static String getFileServerURL(String... prefix) {
        return fileServerURL + (null != prefix && prefix.length != 0 ? prefix[0] : "");
    }

    /**
     * 返回带HTTP://的服务器全路径
     *
     * @param 文件存储路径
     * @return 返回file.property中的accessUrl
     */
    public static String getFullFileServerURL(String... prefix) {
        return "http://" +
                fileServerURL +
                (null != prefix && prefix.length != 0 ? prefix[0] : "");
    }

    public static void setFileServerURL(String fileServerURL) {
        WebUtility.fileServerURL = fileServerURL;
    }

    /**
     * 获取浏览器IP地址
     *
     * @param request
     *
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 获取Cookie 信息
     *
     * @param
     * @return
     */
    public static Map getCookies(HttpServletRequest request) {
        Map values = new HashMap();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                try {
                    values.put(cookie.getName(), java.net.URLDecoder.decode(cookie.getValue(), "UTF-8"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return values;
    }

    /**
     * 设置Cookie 信息
     *
     * @param
     * @return
     */
    public static void setCookies(HttpServletResponse response, Map<String, Object> input) {
        if (response != null) {
            for (String key : input.keySet()) {
                if (!key.equalsIgnoreCase("timeout") && !key.equalsIgnoreCase("domain")) {
                    try {
                        String value = input.get(key).toString();
                        String timeout = null == input.get("timeout") ? "0" : input.get("timeout").toString();
                        String domain = null == input.get("domain") ? "" : input.get("domain").toString();
                        value = URLEncoder.encode(StringUtils.isBlank(value) ? "" : value, "utf-8");
                        Cookie cookie = new Cookie(key, value);
                        if (StringUtils.isNotBlank(timeout)) {
                            cookie.setMaxAge(Integer.valueOf(timeout));
                        }
                        if (StringUtils.isNotBlank(domain)) {
                            cookie.setDomain(domain);
                        }
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    } catch (Exception ex) {
                        logger.error("写入Cookie异常,key=" + key + ",完整参数:" + input, ex);
                    }
                }
            }
        }
    }

    /**
     * 获取当前 服务器 SERVER URL
     *
     * @param request
     * @return
     */
    public static String getLocalhostURL(HttpServletRequest request) {
        StringBuffer url = new StringBuffer(request.getScheme());
        url.append("://").append(request.getServerName());
        if (request.getServerPort() != 80) {
            url.append(":").append(request.getServerPort());
        }
        return url.toString();
    }

    /**
     * 生成 请求 SSO  请求地址
     *
     * @param request
     * @param serverURL
     * @return
     */
    public static String generatorRequestSsoURL(HttpServletRequest request, String serverURL) throws Exception {
        // 生成 Callback 地址
        StringBuffer redirectURL = request.getRequestURL();
        String queryString = request.getQueryString();
        if (StringUtils.isNotBlank(request.getQueryString())) {
            queryString = queryString.replaceAll("&?cas_logout=[^=&]+", "");
            if (queryString.startsWith("&")) {
                queryString = queryString.substring(1, queryString.length());
            }
            if (StringUtils.isNotBlank(queryString)) {
                redirectURL.append("?").append(queryString);
            }
        }
        // 生成 SSO 服务器 地址
        StringBuffer fullServerURL = new StringBuffer();
        fullServerURL.append(serverURL);
        fullServerURL.append("?");
        fullServerURL.append(Constants.CAS_REDIRECT_URL_KEY);
        fullServerURL.append("=");
        fullServerURL.append(URLEncoder.encode(redirectURL.toString(), "UTF-8"));
        return fullServerURL.toString();
    }

    /**
     * 封装 转换Request 为 Enterprise DATA
     *
     * @return
     */
    public static Enterprise getInput() {
        HttpServletRequest request = ActionContext.getRequest();
        return getInput(request);
    }

    public static Enterprise getInput(HttpServletRequest request) {
        if (null != request.getAttribute("input") && request.getAttribute("input") instanceof Enterprise) {
            return (Enterprise) request.getAttribute("input");
        }
        Enterprise entity = new Enterprise("REQUEST_DATA");
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements(); ) {
            String key = (String) e.nextElement();
            String[] values = request.getParameterValues(key);
            for (String value : values) {
                if (entity.containsKey(key) && !key.equalsIgnoreCase("id")) {
                    Object temp = entity.get(key);
                    if (temp instanceof List) {
                        ((List) temp).add(value);
                    } else {
                        List temps = new ArrayList();
                        temps.add(temp);
                        temps.add(value);
                        entity.put(key, temps);
                    }
                } else {
                    entity.put(key, value);
                }
            }
        }
        request.setAttribute("input", entity);
        return entity;
    }

    /**
     * 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param request
     * @return
     */
    public static String buildSign(Map request) {
        List<String> fields = new ArrayList<String>(request.keySet());
        Collections.sort(fields);
        StringBuffer fieldsString = new StringBuffer();
        for (int i = 0; i < fields.size(); i++) {
            // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            fieldsString.append(fields.get(i)).append("=").append(request.get(fields.get(i))).append("&");
        }
        return fieldsString.toString();
    }

    public static void main(String[] args) {

    }
}
