/**
 * 宝龙电商
 * com.plocc.framework.collection
 * BehaviorRecordFilter.java
 *
 * 2013-11-15-下午3:58
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.collection;

import com.alibaba.fastjson.JSON;
import com.plocc.framework.utils.StringUtils;
import com.plocc.support.utility.Configuration;
import com.plocc.support.utility.ThreadPool;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * BehaviorRecordFilter
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-11-15-下午3:58
 * @email zhanggj-hws@powerlong.com
 * @description 收集 收集接口 信息 发送给 行为收集系统。
 */
public class MobileInterfaceRequestRecordFilter implements Filter {


    // 行为收集地址
    private final String serverURL = Configuration.getProperty("mobile.interface.request.record.url");


    public void init(FilterConfig filterConfig) throws ServletException {
        ThreadPool.executeTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("============");
            }
        });
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (StringUtils.isNotBlank(serverURL)) {
            ThreadPool.executeTask(new CollectTask((HttpServletRequest) request));
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    /**
     * 任务处理类
     */
    public class CollectTask implements Runnable {
        private Map params = new HashMap();

        public CollectTask(HttpServletRequest request) {
            params.put("param", request.getParameter("data"));
            params.put("tgc", request.getHeader("tgc"));
            params.put("mac", request.getHeader("mac"));
            params.put("version", request.getHeader("version"));
            params.put("url", request.getRequestURL());
            params.put("uid", request.getHeader("uid"));
            params.put("user-agent", request.getHeader("user-agent"));
        }

        public void run() {
            HttpClient httpClient = new HttpClient();
            PostMethod method = new PostMethod(serverURL);
            try {
                method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                NameValuePair[] param = {new NameValuePair("df", "json"), new NameValuePair("json", JSON.toJSONString(params))};
                method.setRequestBody(param);
                method.setRequestHeader("Connection", "close");
                httpClient.executeMethod(method);
                //System.out.println(method.getResponseBodyAsString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }finally {
                method.releaseConnection();
            }
        }
    }
}
