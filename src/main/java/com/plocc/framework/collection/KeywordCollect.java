package com.plocc.framework.collection;

import com.alibaba.fastjson.JSON;
import com.plocc.framework.security.Authorization;
import com.plocc.support.utility.Configuration;
import com.plocc.support.utility.ThreadPool;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-3-10.
 */
public class KeywordCollect {
    // 行为收集地址
    private static final String serverURL = Configuration.getProperty("keyword.interface.request.record.url");

    /**
     * 关键字 行为收集
     *
     * @param request
     * @param authorization
     * @param clientType    设备类型(web,mobile)
     * @param mall          所属 mall
     * @param channel       频道(item,shop,groupon)
     * @param keyword       关键字
     * @param category      分了
     * @param brand         商品品牌
     * @param floor         店铺楼层
     */
    public static void collect(HttpServletRequest request, Authorization authorization, String clientType, String channel, String keyword, String mall, String category, String brand, String floor) {
        ThreadPool.executeTask(new CollectTask(request, authorization, clientType, channel, keyword, mall, category, brand, floor));
    }

    /**
     * 任务处理类
     */
    public static class CollectTask implements Runnable {
        private Map params = new HashMap();

        public CollectTask(HttpServletRequest request, Authorization authorization, String clientType, String channel, String keyword, String mall, String category, String brand, String floor) {
            params.put("mall", mall);
            params.put("client-type", clientType);
            params.put("channel", channel);
            params.put("keyword", keyword);
            params.put("category", category);
            params.put("brand", brand);
            params.put("floor", floor);
            params.put("url", request.getRequestURL());
            params.put("user-agent", request.getHeader("user-agent"));
            if (null != authorization) {
                params.put("username", authorization.getUsername());
                params.put("uid", authorization.getId());
            } else {
                params.put("uid", request.getHeader("uid"));
            }
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }finally {
                method.releaseConnection();
            }
        }
    }
}
