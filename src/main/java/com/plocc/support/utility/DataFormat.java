/**
 * 宝龙电商
 * com.plocc.support.utility
 * DataFormat.java
 *
 * 2013-7-31-下午2:28
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.utility;

import java.math.BigDecimal;

/**
 * DataFormat
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-7-31-下午2:28
 * @email zhanggj-hws@powerlong.com
 * @description 职责描述
 */
public class DataFormat {
    public BigDecimal toBigDecimal(Object value) {
        if (value == null) {
            return new BigDecimal(0.0D);
        } else if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        } else {
            try {
                return new BigDecimal(value.toString());
            } catch (Exception ex) {
                return BigDecimal.ZERO;
            }
        }
    }
}
