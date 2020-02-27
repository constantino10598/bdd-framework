package nz.chorus.test.services;

import org.apache.log4j.Logger;

import nz.chorus.test.util.ConfigUtil;

/**
 * Placeholder for non web test services
 * @author ericson.d.ruiz
 *
 */
public class TestService {
	
	String serviceName = null;
	private static final Logger LOGGER = Logger.getLogger(TestService.class);
	
	//TODO: Future services for non web test cases
	public void startService(String service) {
		this.serviceName = service;
		LOGGER.info("Configured test service");	
	}	
}
