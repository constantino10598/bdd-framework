package nz.chorus.test.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.junit.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nz.chorus.test.pages.BasePage;
import nz.chorus.test.pages.ServiceMapPage;
import nz.chorus.test.util.ConfigUtil;

public class BasePageSD  {
	
	static Scenario scenario;
	static BasePage page = new BasePage();
	ConfigUtil config_util = new ConfigUtil();
	String base_url = config_util.getConfigPropertyValues("base.url"); 
	String testcase_id;
	
	private static final Logger LOGGER = Logger.getLogger(BasePageSD.class);
	
    @Before
    public void setup(Scenario scenario) throws ConfigurationException{
    	
    	BasePageSD.scenario = scenario;    
    	testcase_id = this.getTestCaseId(scenario);
    }
    
    public static Scenario getScenario(){
    	
    	return scenario;
    }
    
    public static BasePage getPage(){
		
    	return page;
    }
    
    @Given("the user opens the \"([^\"]*)\" page$")
    public void openHomePage(String url) throws Exception {
    	
    	if ("home" == url) {
    		page = new ServiceMapPage();
    		page.open();
    		page.navigate(base_url);
    	}else {
    		page = new ServiceMapPage();
    		page.open();
    		page.navigate(base_url + url);
    	}
    }
    
    @Then("verify the text \"([^\"]*)\" is displayed in page$")
    public void verifytextDisplayed(String text) throws InterruptedException {
        
    	Assert.assertTrue(page.isTextDisplayed(text)); 
    	page.highlightElements(text);
    }
    
    @Then("take screenshot of the page")
    public void takePageScreenShot() throws InterruptedException{
    	
    	TimeUnit.SECONDS.sleep(2);
    	page.takeScreenshot(scenario, testcase_id);
    } 
    
    @After
    public void close_browser(){
    	
    	if(scenario.isFailed()){
    		page.takeScreenshot(scenario, testcase_id);
    	}
    	
    	try {
	    	page.close();
    	} catch (Exception e) {
			LOGGER.error("ERROR: " + e.getMessage());
		} 
    }
    
 private String getTestCaseId(Scenario scenario) {
        
        String testCaseId = scenario.getName().split(":")[0];
        return testCaseId;
    }
}