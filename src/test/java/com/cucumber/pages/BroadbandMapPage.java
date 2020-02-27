package com.cucumber.pages;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.util.ConfigUtil;

public class BroadbandMapPage extends BasePage {

	@FindBy(id="wivolo-search-input")
	WebElement address_field;
	
	@FindBy(id="location-details")
	WebElement service_list;
	
	ConfigUtil config_util = new ConfigUtil();
	String config_file = "src/main/resources/config.properties";
    
   
    public void searchService(String address){
		
    	System.out.println("testing: " + address_field);
    	this.setInputs(address_field, address);
    }
    
    public WebElement getServiceList(){
    	
    	return service_list;
    }

}