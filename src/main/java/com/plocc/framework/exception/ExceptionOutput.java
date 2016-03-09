/**
 * 宝龙电商
 * org.powerlong.framework.exception
 * ExceptionOutput.java
 * 
 * 2013-6-27-下午02:05:25
 *  2013宝龙公司-版权所有
 * 
 */
package com.plocc.framework.exception;

/**
 * ExceptionOutput
 * 
 * @see Kira Sun 2013-6-27-下午02:05:25
 * @version 1.0.0
 */
public class ExceptionOutput {
	private String exceptionCode;
	private String execptionMessage;

	public ExceptionOutput(String exceptionCode) {
		this.exceptionCode = exceptionCode;
		this.execptionMessage = ExceptionConstants.getReturnCodeMap().get(
				this.exceptionCode);
	}

	// 封装返回结果，比如封闭成XML等，返回给调用处，这里打印输出一下。
	public void toXML() {
		System.out.println("Exception:" + this.execptionMessage);
	}
}
