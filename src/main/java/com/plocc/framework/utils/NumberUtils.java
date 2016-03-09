/**
 * 宝龙电商
 * org.powerlong.framework.utils
 * NumberUtils.java
 * 
 * 2013-6-27-下午04:29:11
 *  2013宝龙公司-版权所有
 * 
 */
package com.plocc.framework.utils;

import java.math.BigDecimal;

/**
 * NumberUtils
 * @see
 * Kira Sun
 * 2013-6-27-下午04:29:11
 * @version 1.0.0
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {
	public static String moneyFormat(String str) {
		return new BigDecimal(str).stripTrailingZeros().toPlainString();
	}
}
