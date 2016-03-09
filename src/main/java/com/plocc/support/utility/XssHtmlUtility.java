/**
 * 宝龙电商
 * com.plocc.support.utility
 * XssHtmlUtlity.java
 *
 * 2013-8-14-上午11:29
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.utility;

/**
 * XssHtmlUtlity
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-8-14-上午11:29
 * @email zhanggj-hws@powerlong.com
 * @description 防止 XSS 攻击，转义 表单中 HTML 脚本
 */
public class XssHtmlUtility {

    /**
     * 编码
     *
     * @param value
     * @return
     */
    public static String encode(String value) {
        if (null != value) {
            char content[] = new char[value.length()];
            value.getChars(0, value.length(), content, 0);
            StringBuilder result = new StringBuilder(content.length + 50);
            for (int i = 0; i < content.length; i++) {
                switch (content[i]) {
                    case '<':
                        result.append("&lt;");
                        break;
                    case '>':
                        result.append("&gt;");
                        break;
                    case '&':
                        result.append("&amp;");
                        break;
                    case '"':
                        result.append("&quot;");
                        break;
                    default:
                        result.append(content[i]);
                }
            }
            return result.toString();
        }
        return null;
    }

    /**
     * 解码
     *
     * @param value
     * @return
     */
    public static String decode(String value) {
        if (null != value) {
            return value.replace("&lt;", "<").replace("&gt;", ">").replace("&;", "&amp;").replace("&quot;", "\"").replace("&amp;", "&");
        }
        return value;
    }

    public static String filter(String value) {
        return encode(value);
    }
}
