/**
 * 宝龙电商
 * com.plocc.framework.security
 * AuthRole.java
 *
 * 2013-8-29-上午10:03
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.security;

import java.io.Serializable;

/**
 * AuthRole
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-8-29-上午10:03
 * @email zhanggj-hws@powerlong.com
 * @description 职责描述
 */
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 2903748234792879l;

    // 系统编号
    private String systemId;
    // 空间ID
    private String spaceId;
    // 角色CODE
    private String roleCode;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
