/**
 * 宝龙电商
 * com.plocc.auth.common.aop
 * SpringAspectInterceptor.java
 *
 * 2013-7-13-下午6:04
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.spring;

import com.plocc.framework.security.Authorization;
import com.plocc.framework.utils.StringUtils;
import com.plocc.support.utility.ActionContext;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/**
 * SpringAspectInterceptor
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-7-13-下午6:04
 * @email zhanggj-hws@powerlong.com
 * @description Spring 统一处理 创建时间，创建人，更新时间，更新人
 */
@Aspect
public class SpringAspectInterceptor {

    // 创建人
    private static String[] creatorUserProperty = new String[]{"creater", "creatorId", "createdBy"};
    private static String[] creatorUserNameProperty = new String[]{"creatorUsername","creatorName"};

    // 创建时间
    private static String[] creatorDateProperty = new String[]{"createDate", "createdDate"};

    // 更新人
    private static String[] updaterUserProperty = new String[]{"updater", "updaterId", "updatedBy"};
    private static String[] updaterUserNameProperty = new String[]{"updaterUsername","updatedName"};

    // 更新时间
    private static String[] updaterDateProperty = new String[]{"updateDate", "updatedDate"};

    @Around("execution(* com.plocc..*.dao.impl.*.insert*(..)) && target(tar) && args(entity)")
    public Object aroundInsert(ProceedingJoinPoint point, Object tar, Object entity) throws Throwable {
        Authorization authorization = ActionContext.getAuthorization();
        Date now = new Date();
        // 创建人
        for (String property : creatorUserProperty) {
            if (null != authorization && null != PropertyUtils.getPropertyDescriptor(entity, property)) {
                String value = (String) PropertyUtils.getProperty(entity, property);
                if (StringUtils.isBlank(value)) {
                    BeanUtils.setProperty(entity, property, authorization.getId());
                }
            }
        }
        for (String property : creatorUserNameProperty) {
            if (null != authorization && null != PropertyUtils.getPropertyDescriptor(entity, property)) {
                String value = (String) PropertyUtils.getProperty(entity, property);
                if (StringUtils.isBlank(value)) {
                    BeanUtils.setProperty(entity, property, authorization.getUsername());
                }
            }
        }
        // 创建时间
        for (String property : creatorDateProperty) {
            if (null != PropertyUtils.getPropertyDescriptor(entity, property)) {
                String value = (String) PropertyUtils.getProperty(entity, property);
                if (null == value) {
                    BeanUtils.setProperty(entity, property, now);
                }
            }
        }
        return point.proceed();
    }

    @Around("execution(* com.plocc..*.dao.impl.*.update*(..)) && target(tar) && args(entity)")
    public Object aroundUpdate(ProceedingJoinPoint point, Object tar, Object entity) throws Throwable {
        Authorization authorization = ActionContext.getAuthorization();
        Date now = new Date();
        // 更新人
        for (String property : updaterUserProperty) {
            if (null != authorization && null != PropertyUtils.getPropertyDescriptor(entity, property)) {
                BeanUtils.setProperty(entity, property, authorization.getId());
            }
        }
        for (String property : updaterUserNameProperty) {
            if (null != authorization && null != PropertyUtils.getPropertyDescriptor(entity, property)) {
                BeanUtils.setProperty(entity, property, authorization.getUsername());
            }
        }

        // 更新时间
        for (String property : updaterDateProperty) {
            if (null != PropertyUtils.getPropertyDescriptor(entity, property)) {
                BeanUtils.setProperty(entity, property, now);
            }
        }
        return point.proceed();
    }
}
