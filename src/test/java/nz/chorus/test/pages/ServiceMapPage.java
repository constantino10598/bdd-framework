package nz.chorus.test.pages;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import nz.chorus.test.util.ConfigUtil;

public class ServiceMapPage extends BasePage {

	@FindBy(id="wivolo-search-input")
	WebElement search_field;
	
	@FindBy(id="ui-id-1")
	WebElement address_list;
	
	@FindBy(id="location-details-now")
	WebElement service_list;
	
	ConfigUtil config_util = new ConfigUtil();
	String config_file = "src/main/resources/config.properties";
    
   
    public void searchService(String address){
		
    	this.setInputs(search_field, address);
    }
    
    public WebElement getServiceList(){
    	
    	return service_list;
    }
    
    public WebElement getAddressList(){
    	
    	return address_list;
    }

}