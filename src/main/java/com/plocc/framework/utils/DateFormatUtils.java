/**
 * 宝龙电商
 * org.powerlong.framework.utils
 * DateFormatUtils.java
 *
 * 2013-6-27-下午04:27:02
 *  2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.utils;

import com.plocc.framework.exception.BaseRuntimeException;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * DateFormatUtils
 *
 * @version 1.0.0
 * @see Kira Sun
 *      2013-6-27-下午04:27:02
 */
public class DateFormatUtils extends
        org.apache.commons.lang3.time.DateFormatUtils {
    public static final FastDateFormat PLOCC_US_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd' 'HH:mm:ss");
    public static final FastDateFormat PLOCC_CN_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy年MM月dd日' 'HH:mm:ss");

    /**
     * 日期到 字符转换
     *
     * @param format
     * @param date
     * @return
     */
    public static String format(SimpleDateFormat format, Date date) {
        try {
            return format.format(date);
        } catch (Exception ex) {
            throw new BaseRuntimeException("日期到字符的转换错误:" + format + ":" + date);
        }
    }

    public static String format(String format, Date date) {
        if (null != date) {
            return format(new SimpleDateFormat(format), date);
        }
        return null;
    }


}
