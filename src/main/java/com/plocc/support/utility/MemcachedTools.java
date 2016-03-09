package com.plocc.support.utility;

import com.plocc.framework.utils.MemcachedUtils;

/**
 * Created by Administrator on 14-8-16.
 */
public class MemcachedTools {
    public static MemcachedUtils getMemcachedUtils() {

        return ActionContext.getApplicationContext().getBean(MemcachedUtils.class);
    }
}
