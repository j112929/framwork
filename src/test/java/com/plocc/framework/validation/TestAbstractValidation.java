/**
 * 宝龙电商
 * com.plocc.framework.validation
 * TestAbstractValidation.java
 *
 * 2013-10-28-上午10:36
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.validation;

import com.plocc.support.utility.Enterprise;

/**
 * TestAbstractValidation
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-10-28-上午10:36
 * @email zhanggj-hws@powerlong.com
 * @description 职责描述
 */
public class TestAbstractValidation {

    public static void main(String[] args) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("");
        userEntity.setPassword("");
        userEntity.setAge(0);

        userEntity.addIgnoreValidFields("age");
        userEntity.addValidFields("password");
        // 执行验证
        Enterprise errors = userEntity.validation();
        // 是否存在错误
        if (errors.isEmpty()) {
            System.out.println("OK");
        } else {
            System.out.println("发生异常:" + errors);
        }


    }
}
