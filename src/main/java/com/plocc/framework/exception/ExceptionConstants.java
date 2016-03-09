/**
 * 宝龙电商
 * org.powerlong.framework.exception
 * ExceptionConstants.java
 * 
 * 2013-6-27-下午02:06:53
 *  2013宝龙公司-版权所有
 * 
 */
package com.plocc.framework.exception;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ExceptionConstants
 * 
 * @see Kira Sun 2013-6-27-下午02:06:53
 * @version 1.0.0
 */
public class ExceptionConstants {  
		  
	    public static final String Code_0000 = "0000";  
	    public static final String Msg_0000 = "输入参数不合法!";  
	  
	    public static final String Code_0100 = "0100";  
	    public static final String Msg_0100 = "";  
	  
	    public static final String Code_9999 = "9999";  
	    public static final String Msg_9999 = "其它错误!";  
	  
	    private static Map<String, String> returnCodeMap = new ConcurrentHashMap<String, String>();  
	  
	    public static Map<String, String> getReturnCodeMap() {  
	        if (returnCodeMap.isEmpty()) {  
	            returnCodeMap.put(Code_0000, Msg_0000);  
	            returnCodeMap.put(Code_0100, Msg_0100);  
	            returnCodeMap.put(Code_9999, Msg_9999);  
	        }  
	        return returnCodeMap;  
	    }  
}
