package nz.chorus.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

/**
 * Configuration and other common utilities
 * @author ericson.d.ruiz
 *
 */
public class ConfigUtil {
	
	final Logger LOGGER = Logger.getLogger(ConfigUtil.class);
	
	/**
	 * Gets the value from the property file
	 * @param propertyName property name
	 * @return property value
	 */
	public String getConfigProperty(String propertyName) {
		
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

}
