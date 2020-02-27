package nz.chorus.test.services;

import org.apache.log4j.Logger;

import nz.chorus.test.util.ConfigUtil;

public class TestService {
	
	String serviceName = null;
	private static final Logger LOGGER = Logger.getLogger(TestService.class);
	
	public void startService(String service) {
		this.serviceName = service;
		LOGGER.info("Configured test service");	
	}	
}
