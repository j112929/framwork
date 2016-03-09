/**
 * 宝龙电商
 * com.plocc.framework.test
 * JUnitAdapter.java
 *
 * 2013-9-23-上午10:07
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.plocc.support.utility.Configuration;

/**
 * JUnitAdapter
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-9-23-上午10:07
 * @email zhanggj-hws@powerlong.com
 * @description 职责描述
 */
public class TestHessianAdapter {
    private static final HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();

    public <T> T getRemoteInterface(String module, String beanName) {
        try {
            return (T) hessianProxyFactory.create(Configuration.getProperty(module+".hessian.serviceUrl") + beanName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
