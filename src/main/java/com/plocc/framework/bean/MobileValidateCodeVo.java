/**
 * 宝龙广场
 * com.plocc.user.mobile.vo
 * MobileValidateCodeVo.java
 * 
 * 2013-9-9-下午3:21:03
 *  2013宝龙公司-版权所有
 * 
 */
package com.plocc.framework.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * MobileValidateCodeVo
 * 
 * 朱欢
 * zhuh
 * 2013-9-9-下午3:21:03
 * 
 * @version 1.0.0
 * 
 */
public class MobileValidateCodeVo  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mobile;
	private String code;
	private Date sendTime;
	
	/**
	 * mobile
	 *
	 * @return  the mobile
	 * @zhuh   1.0.0
	 */
	
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * code
	 *
	 * @return  the code
	 * @zhuh   1.0.0
	 */
	
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * sendTime
	 *
	 * @return  the sendTime
	 * @zhuh   1.0.0
	 */
	
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
}
