/**
 * 
 */
package com.plocc.framework.exception.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import com.plocc.framework.utils.LoggerUtils;

/**
 * ErrorMessage 简单实现，通过配置文件获取友好异常信息
 * 
 * @author John
 *
 */
public class SimpleErrorMessage implements ErrorMessage {

	/**
	 * 日志陆金凤
	 */
	private static final String LOG_PATH = "/logs/exception_handler";
	
	/**
	 * log4j 日志对象
	 *
	 * @since 1.0.0
	 */
	private static final Logger LOG = LoggerUtils.getErrorLogger(LOG_PATH, SimpleErrorMessage.class);
	
	private static final String DEFAULT_MESSAGE = "抱歉！系统繁忙，请稍后重试。";
	
	private Resource[] locations;
	
	/**
	 *  友好异常信息properties
	 */
	private Properties properties;
	
	public String getMessage(String key) {
		try {
			loadProperties();
		} catch (IOException e) {
			LOG.error(e);
			return DEFAULT_MESSAGE;
		}
		try {
			String message = properties.getProperty(key);
			if(!StringUtils.isEmpty(message)){
				return message;
			}
		} catch (Exception ex) {
			LOG.error(ex);
			
		}	
		return DEFAULT_MESSAGE;
	}
	
	protected void loadProperties() throws IOException {
		if(properties != null){
			return;
		}
		properties = new Properties();
		PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
		if (this.locations != null) {
			for (Resource location : this.locations) {
				InputStream is = null;
				try {
					is = location.getInputStream();

					propertiesPersister.load(properties, new InputStreamReader(is, "UTF-8"));

				}
				catch (IOException ex) {
					LOG.error("异常处理配置文件读取异常", ex);
					throw ex;
				}
				finally {
					if (is != null) {
						is.close();
					}
				}
			}
		}
	}

	/**
	 * @return the locations
	 */
	public Resource[] getLocations() {
		return locations;
	}

	/**
	 * @param locations the locations to set
	 */
	public void setLocations(Resource[] locations) {
		this.locations = locations;
	}

}
