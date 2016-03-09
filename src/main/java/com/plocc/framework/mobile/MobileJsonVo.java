package com.plocc.framework.mobile;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * 
 * MobileJsonVo
 * 返回APP端 数据保存实体对象
 * 
 * 2013-8-16-下午03:02:50
 * 
 * 刘博宇 1.0.0
 * 
 */
public class MobileJsonVo implements Serializable {
	private static final Logger LOG = Logger .getLogger(MobileJsonVo.class);
	/**
	 * 处理结果
	 * 0 成功，1...n 错误
	 * @since 1.0.0
	 */
	private int code;
	
	/**
	 * 反馈消息
	 * @since 1.0.0
	 */
	private String msg;
	
	/**
	 * 回复标识
	 * @since 1.0.0
	 */
	private String type;
	
	/**
	 * 返回给手机端的数据，将需要转化成json对象的数据对象存入
	 * @since 1.0.0
	 */
	private Object data;
	
	private static final long serialVersionUID = 1L;

	public int getCode() {
		return code;
	}

	public void setCode(String code) {
		try {
			this.code = Integer.parseInt(code);
		} catch (Exception e) {
			LOG.error("code转换异常", e);
			this.code = -1;
		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
