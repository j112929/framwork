/**
 * 
 */
package com.plocc.framework.utils;

import java.io.File;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Log日志工具类
 * 
 * @author John
 * 
 */
public final class LoggerUtils {

	/**
	 * 获取指定路径的ERROR级别的LOGGER
	 * 
	 * @param path
	 * @param clazz
	 * @return
	 */
	public static Logger getErrorLogger(String path, Class<?> clazz) {
		// 生成新的Logger
		// 如果已經有了一個Logger實例返回現有的
		Logger logger = Logger.getLogger(clazz);
		// 清空Appender。
		logger.removeAllAppenders();
		// 設定Logger級別。
		logger.setLevel(Level.ERROR);
		//繼承root輸出。
		logger.setAdditivity(true);
		// 生成新的Appender
		DailyRollingFileAppender appender = new DailyRollingFileAppender();
		appender.setDatePattern("'.'yyyy-MM-dd'.log'");
		PatternLayout layout = new PatternLayout();
		// log的输出形式
		String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss,SSS} [%t:%p] %c - %m%n";
		layout.setConversionPattern(conversionPattern);
		appender.setLayout(layout);
		// log输出路径
		appender.setFile(path + "/exception_handler_log.log");
		// log的文字码
		appender.setEncoding("UTF-8");
		// true:在已存在log文件后面追加 false:新log覆盖以前的log
		appender.setAppend(true);
		// 适用当前配置
		appender.activateOptions();
		// 将新的Appender加到Logger中
		logger.addAppender(appender);
		return logger;
	}

}
