package com.cucumber.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.cucumber.pages.BasePage;
import com.cucumber.pages.BroadbandMapPage;
import com.cucumber.util.ConfigUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BroadbandMapPageSteps  {
	
	static Scenario scenario;
	BroadbandMapPage page = new BroadbandMapPage();
	private static final Logger LOGGER = Logger.getLogger(BroadbandMapPageSteps.class);
	    
    public BasePage getPage(){
		
    	return page;
    }
    
    @Then("the user types his address \"([^\"]*)\"$")
    public void verifyAddress(String address) {
        
    	page.searchService(address);
    }
    
    @Then("verify the list of service is displayed")
    public void verifyServices(String text) {
        
    	WebElement service_list = page.getServiceList();
    	Assert.assertNotNull(service_list); 
    	page.highlightElement(service_list);
    }
    
    @Then("print the list of service available")
    public void printServices() {
    	
    	WebElement service_list = page.getServiceList();
    	scenario.write(service_list.toString());
    }
    
}