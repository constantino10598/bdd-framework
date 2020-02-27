package nz.chorus.test.steps;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.chorus.test.pages.BasePage;
import nz.chorus.test.pages.ServiceMapPage;
import nz.chorus.test.util.ConfigUtil;

/**
 * Broadband page step definitions
 * @author ericson.d.ruiz
 *
 */
public class ServiceMapPageSD  {
	
	Scenario scenario = BasePageSD.getScenario();
	ServiceMapPage page = (ServiceMapPage) BasePageSD.getPage();
	private static final Logger LOGGER = Logger.getLogger(ServiceMapPageSD.class);
	    
    @When("the user types his address \"([^\"]*)\"$")
    public void verifyAddress(String address) {
        
    	page.searchService(address);
    }
    
    @Then("verify the address \"([^\"]*)\" displays in the list$")
    public void verifyAddressList(String address) throws InterruptedException {
        
    	WebElement address_list = page.getAddressList();
    	TimeUnit.SECONDS.sleep(3);
    	address_list.click();
    }
    
    @Then("verify the list of services is displayed")
    public void verifyServices() throws InterruptedException {
        
    	WebElement service_list = page.getServiceList();
    	Assert.assertNotNull(service_list.getText()); 
    	page.highlightElement(service_list);
    }
    
    @Then("print the list of services available")
    public void printServices() {
    	
    	List<WebElement> products = page.getDriver().findElements(By.cssSelector("#location-details-now > ul"));
    	for (WebElement product: products) {
			scenario.write(product.getText());
		}
    	
    }
    
}