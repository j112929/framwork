/**
 * 宝龙电商
 * com.plocc.support.utility
 * SafeHtmlUtility.java
 *
 * 2013-7-2-上午11:00
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.utility;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.springframework.util.Assert;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * SafeHtmlUtility
 *
 * @author Zhanggj
 * @version 1.0.0
 * @email zhanggj-hws@powerlong.com
 * @date 2013-7-2-上午11:02
 * @description 富文本内容 过滤
 * 原理：将客户端提交文本 强制转换为 HTML 使用 HtmlCleaner，它的容错能力很好。
 * 然后利用 Xpath表达式 过滤掉不需要的节点，并且删除 所有节点的 事件。
 */
public class SafeHtmlUtility {

    private static HtmlCleaner cleaner = new HtmlCleaner();
    private static CleanerProperties props = cleaner.getProperties();

    static {
        props.setRecognizeUnicodeChars(true);
        props.setUseEmptyElementTags(true);
        props.setAdvancedXmlEscape(true);
        props.setTranslateSpecialEntities(true);
        props.setOmitComments(true);
        props.setBooleanAttributeValues("empty");
        props.setAllowMultiWordAttributes(true);
    }

    /**
     * 过滤函数
     *
     * @param content
     * @return
     */
    public static String filter(String content) {

        Assert.isTrue(null != content, "内容不能为空!");

        // 将 输入参数转换为 HTML 文档
        TagNode tagNode = cleaner.clean(content);
        StringWriter result = new StringWriter();
        try {
            // 循环删除 Script 或  Link 节点
            for (Object element : tagNode.evaluateXPath("//script")) {
                TagNode parentElement = ((TagNode) element).getParent();
                parentElement.removeChild(element);
            }
            for (Object element : tagNode.evaluateXPath("//link")) {
                TagNode parentElement = ((TagNode) element).getParent();
                parentElement.removeChild(element);
            }
            // 删除所有 元素的事件
            for (Object element : tagNode.evaluateXPath("//*")) {
                TagNode _element = ((TagNode) element);
                List<String> delAttributesKeys = new ArrayList<String>();
                Map<String, String> attributes = _element.getAttributes();
                for (String key : attributes.keySet()) {
                    if (key.startsWith("on")) {
                        delAttributesKeys.add(key);
                    }
                }
                for (String key : delAttributesKeys) {
                    _element.removeAttribute(key);
                }
            }
            // 去除 HTML 头尾
            Object[] tagNodes = tagNode.evaluateXPath("body");
            PrettyHtmlSerializer serializer = new PrettyHtmlSerializer(props);
            serializer.write((TagNode) tagNodes[0], result, "GB2312");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String _result = result.toString();
        // 去除 头尾的 <body></body>
        return _result.substring(47, _result.length() - 8);
    }

    // 测试
    public static void main(String[] args) throws Exception {
        StringBuffer htmlBuffer = new StringBuffer();
        htmlBuffer.append("<div onClick='asdf'>1<link href='asdf'/>asdfasdf");
        htmlBuffer.append("<div/>asdfasdf").append("<script>alert($);</script><link href='asdf'/>");
        htmlBuffer.append("<script>asdf</sc%ript>");
        htmlBuffer.append("<scrip>asdf</script>");
        htmlBuffer.append("<div/>asdf");
        htmlBuffer.append("<dasdfasdfiv/>asdf");
        htmlBuffer.append("<p>===============<p>");
        htmlBuffer.append("</p>===============</p>");
        htmlBuffer.append("<p>===============</p>");
        htmlBuffer.append("</div><div>222</div>");
        System.out.println(SafeHtmlUtility.filter(htmlBuffer.toString()));
    }
}
