package com.cucumber.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

public class ConfigUtil {
	
	final Logger LOGGER = Logger.getLogger(ConfigUtil.class);
	
	public String getConfigPropertyValues(String propertyName) {
		
    	String result = "";
    	String prop_file = "config.properties";
    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	Properties props = new Properties();
    	InputStream resourceStream = loader.getResourceAsStream(prop_file);
    	try {
			props.load(resourceStream);
			result = props.getProperty(propertyName);
		} catch (IOException e) {
			LOGGER.error(e);
		}
    	
		return result;
    }
	
	public String getConfigPropValue(String prop_file, String propertyName) throws ConfigurationException {
		
    	PropertiesConfiguration config = new PropertiesConfiguration(prop_file);
        String value = config.getString(propertyName);    	
        return value;
    }

}
