/**
 * 宝龙电商
 * org.powerlong.sso.common.utility
 * WebUtility.java
 *
 * 2013-7-2-上午11:00
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.utility;

import com.plocc.framework.exception.BaseRuntimeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/**
 * WebUtility
 *
 * @author Zhanggj
 * @version 1.0.0
 * @email zhanggj-hws@powerlong.com
 * @date 2013-7-2-上午11:02
 * @description 数据格式化 对象，例如 日期 转换, 简单类型转换,换算
 */


public class DateUtility {
    public static final SimpleDateFormat FORMAT_SIMPLE = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat FORMAT_SIMPLE_CN = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat FORMAT_FULL = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static final SimpleDateFormat FORMAT_FULL_CN = new SimpleDateFormat("yyyy年MM月dd hh小时mm分钟ss秒");
    public static final SimpleDateFormat FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat FORMAT_HH_MM_SS = new SimpleDateFormat("hh:mm:ss");

    public static String getGMTString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        dateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return FORMAT_FULL.format(date);
    }

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
            throw new BaseRuntimeException("日期到字符的转换错误:" + format + ":" + date, ex.getMessage());
        }
    }

    public static String format(String format, Date date) {
        return format(new SimpleDateFormat(format), date);
    }

    public static Date add(Date date, int field, int value) {
        Calendar calendar = Calendar.getInstance();
        if (null != date) {
            calendar.setTime(date);
        }
        calendar.add(field, value);
        return calendar.getTime();
    }

    public static Date add(int field, int value) {
        return add(null, field, value);
    }

    public static Date set(Date date, int field, int value) {

        Calendar calendar = Calendar.getInstance();
        if (null != date) {
            calendar.setTime(date);
        }
        calendar.set(field, value);
        return date;
    }

    public static Date set(int field, int value) {
        return add(null, field, value);
    }

    /**
     * 字符到日期转换
     *
     * @param format
     * @param date
     * @return
     */
    public static Date parse(SimpleDateFormat format, String date) {
        try {
            return format.parse(date);
        } catch (Exception ex) {
            throw new BaseRuntimeException("字符到日期的转换错误:" + format + ":" + date, ex.getMessage());
        }
    }

    public static Date parse(String format, String date) {
        return parse(new SimpleDateFormat(format), date);
    }

    public static Date clearTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        return calendar.getTime();
    }


    public static Date parse(String date) {
        if (Validation.dateRegexSimple.matcher(date).find()) {
            if (date.contains("年")) {
                return parse(FORMAT_SIMPLE_CN, date);
            } else {
                return parse(FORMAT_SIMPLE, date);
            }
        } else {
            if (date.contains("年")) {
                return parse(FORMAT_FULL_CN, date);
            } else {
                return parse(FORMAT_FULL, date);
            }
        }
    }

    /**
     * 强制将String类型转换为Long类型;
     *
     * @param size
     * @return
     */
    public static Long getByteSize(String size) {
        String nuit = size.substring(size.length() - 1, size.length()).toUpperCase();
        if (nuit.equalsIgnoreCase("K")) {
            String num = size.substring(0, size.length() - 1);
            return Long.parseLong(num) * 1024;
        } else if (nuit.equalsIgnoreCase("M")) {
            String num = size.substring(0, size.length() - 1);
            return Long.parseLong(num) * 1024 * 1024;
        } else {
            return Long.parseLong(size);
        }
    }

    /**
     * 强制将String类型转换为Long类型;
     *
     * @param size
     * @return
     */
    public static String getByteCNM(Long size) {
        if (size == 0 || size < 1024) {
            return "1K";
        } else if (size / (1024) < 1024) {
            return (size / 1024) + "K";
        } else if (size / (1024 * 1024) < 1024) {
            return (size / (1024 * 1024)) + "M";
        } else {
            return (size / (1024 * 1024 * 1024)) + "G";
        }
    }


    /**
     * 在当天的日期上加或减Number天后的 的日期
     *
     * @param dayNumber
     * @return
     */
    public static Date getDay(Integer dayNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dayNumber);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }


    /**
     * @param date
     * @return
     */
    public static String getTimeDifference(String date) {
        try {
            return getTimeDifference(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date));
        } catch (ParseException ex) {
            ex.printStackTrace();
            return "日期错误";
        }
    }

    public static String getTimeDifference(Date date) {
        long timer = new Date().getTime() - date.getTime();
        if ((timer / 365 / 24 / 60 / 60 / 1000) > 0) {
            return (timer / 365 / 24 / 60 / 60 / 1000) + "年";
        } else if ((timer / 30 / 24 / 60 / 60 / 1000) > 0) {
            return (timer / 30 / 24 / 60 / 60 / 1000) + "个月";
        } else if ((timer / 24 / 60 / 60 / 1000) == 1) {
            return "昨天";
        } else if ((timer / 24 / 60 / 60 / 1000) == 2) {
            return "前天";
        } else if ((timer / 24 / 60 / 60 / 1000) > 2) {
            return (timer / 24 / 60 / 60 / 1000) + "天";
        } else if ((timer / 60 / 60 / 1000) > 0) {
            return (timer / 60 / 60 / 1000) + "小时";
        } else if ((timer / 60 / 1000) > 0) {
            return (timer / 60 / 1000) + "分钟";
        } else {
            return "1分钟";
        }
    }

    public static void main(String[] args) {
        Date t1 = DateUtility.parse("1987-04-22");
        Date t2 = DateUtility.parse(DateUtility.format(DateUtility.FORMAT_SIMPLE, new Date()));
        System.out.println(t1.getTime() > t2.getTime());

        System.out.println(DateUtility.clearTime(new Date()));
    }
}
