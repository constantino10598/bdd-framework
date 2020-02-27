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

/**
 * Base web page step definitions
 * @author ericson.d.ruiz
 *
 */
public class BasePageSD  {
	
	static Scenario scenario;
	static BasePage page = new BasePage();
	ConfigUtil config_util = new ConfigUtil();
	String base_url = config_util.getConfigProperty("base.url"); 
	String testcase_id;
	
	private static final Logger LOGGER = Logger.getLogger(BasePageSD.class);
	
	/**
	 * Sets up the scenario before running
	 * @param scenario scenario object
	 * @throws ConfigurationException configuration exception
	 */
    @Before
    public void setup(Scenario scenario) throws ConfigurationException{
    	
    	BasePageSD.scenario = scenario;    
    	testcase_id = this.getTestCaseId(scenario);
    }
    
    /**
     * Retrieves the scenario
     * @return scenario object
     */
    public static Scenario getScenario(){
    	
    	return scenario;
    }
    
    /**
     * Retrieves the base page
     * @return page object
     */
    public static BasePage getPage(){
		
    	return page;
    }
    
    /**
     * Step for opening the base page
     * @param url URL address
     */
    @Given("the user opens the \"([^\"]*)\" page$")
    public void openHomePage(String url) {
    	
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
    
    /**
     * Step to verify if text is displayed
     * @param text text to search for
     * @throws InterruptedException
     */
    @Then("verify the text \"([^\"]*)\" is displayed in page$")
    public void verifytextDisplayed(String text) throws InterruptedException {
        
    	Assert.assertTrue(page.isTextDisplayed(text)); 
    	page.highlightElements(text);
    }
    
    /**
     * Step to take the screenshot of the page
     * @throws InterruptedException exception
     */
    @Then("take screenshot of the page")
    public void takePageScreenShot() throws InterruptedException{
    	
    	TimeUnit.SECONDS.sleep(2);
    	page.takeScreenshot(scenario, testcase_id);
    } 
    
    /**
     * Closes the browser after the scenario is finished
     */
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
    
    /**
     * Gets the test case ID
     * @param scenario scenario object
     * @return test case ID
     */
    private String getTestCaseId(Scenario scenario) {
        
        String testCaseId = scenario.getName().split(":")[0];
        return testCaseId;
    }
}