/**
 * 宝龙电商
 * com.plocc.framework.validation
 * UserEntity.java
 *
 * 2013-10-28-上午10:36
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.validation;

import com.plocc.support.utility.Enterprise;
import com.plocc.support.utility.Validation;
import org.apache.commons.lang.StringUtils;

/**
 * UserEntity
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-10-28-上午10:36
 * @email zhanggj-hws@powerlong.com
 * @description 职责描述
 */
public class UserEntity extends Validation.Entity {
    private String username;
    private String password;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enterprise validation() {
        Enterprise errors = super.validation();


        if (isNeedValidField("username")) {
            if (StringUtils.isBlank(getUsername())) {
                errors.set("username", "用户名不能为空！");
            }
        }
        if (isNeedValidField("password")) {
            if (StringUtils.isBlank(getPassword())) {
                errors.set("password", "密码不能为空！");
            }
        }
        if (isNeedValidField("age")) {
            if (null == age || age.compareTo(1) == -1) {
                errors.set("age", "年龄不能为空！");
            }
        }
        return errors;
    }

    public static void main(String[] args) {

    }
}

