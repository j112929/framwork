package com.plocc.framework.utils;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.errors.EncodingException;

/**
 * EsApiUtils
 * 
 * liuboyu
 * liuboyu
 * 2013-11-7-上午10:35:35
 * 
 * @version 1.0.0
 *
 */
public class EsApiUtils {
	
	/**
	 * encodeForCSS
	 * @param str
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	*/
	public static String encodeForCSS(String str) {
		return ESAPI.encoder().encodeForCSS(str);
	}
	
	/**
	 * encodeForHTML
	 * @param str
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	*/
	public static String encodeForHTML(String str) {
		return ESAPI.encoder().encodeForHTML(str);
	}
	
	/**
	 * encodeForHTMLAttribute
	 * @param str
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	*/
	public static String encodeForHTMLAttribute(String str) {
		return ESAPI.encoder().encodeForHTMLAttribute(str);
	}
	
	/**
	 * encodeForJavaScript
	 * @param str
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	*/
	public static String encodeForJavaScript(String str) {
		return ESAPI.encoder().encodeForJavaScript(str);
	}
	
	/**
	 * encodeForSQL
	 * @param codec
	 * @param str
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	*/
	public static String encodeForSQL(Codec codec,String str) {
		return ESAPI.encoder().encodeForSQL(codec,str);
	}
	
	/**
	 * encodeForURL
	 * @param str
	 * @return
	 * @throws EncodingException 
	 *String
	 * @exception 
	 * @since  1.0.0
	*/
	public static String encodeForURL(String str) throws EncodingException {
		return ESAPI.encoder().encodeForURL(str);
	}
	
	/**
	 * encodeForXML
	 * @param str
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	*/
	public static String encodeForXML(String str) {
		return ESAPI.encoder().encodeForXML(str);
	}
	
	
}
