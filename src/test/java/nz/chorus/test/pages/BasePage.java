package nz.chorus.test.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Splitter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import cucumber.api.Scenario;
import nz.chorus.test.util.ConfigUtil;

/**
 * Base web page model
 * @author ericson.d.ruiz
 *
 */
public class BasePage {

	WebDriver driver;

	/**
	 * Opens the internet browser from the driver
	 */
	public void open() {

		ConfigUtil config_util = new ConfigUtil();
		File driver_path = new File(config_util.getConfigProperty("chrome.driver.path"));
		System.setProperty("webdriver.chrome.driver", driver_path.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Retrieves the web driver
	 * @return web driver object
	 */
	public WebDriver getDriver() {

		return this.driver;
	}

	/**
	 * Browses and navigates webpage 
	 * @param url URL address of the webpage
	 */
	public void navigate(String url) {
		
		driver.get(url);
	}

	/**
	 * Sets the value for a certain field
	 * @param field input field name
	 * @param text input field value
	 */
	public void setInputs(WebElement field, String text) {
		
		field.clear();
		field.sendKeys(text);
	}
	
	/**
	 * Sets the value thru its element ID
	 * @param id element id
	 * @param text input value
	 */
	public void setInputById(String id, String text) {

		WebElement input = driver.findElement(By.id(id));
		input.clear();
		input.sendKeys(text);
	}
	
	/**
	 * Verifies if a certain text is displayed on page
	 * @param text value to search
	 * @return true if the text was found
	 */
	public boolean isTextDisplayed(String text) {

		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText.contains(text);
	}
	
	/**
	 * Clicks a certain element thru its name
	 * @param name element's name
	 */
	public void clickElementByName(String name) {

		driver.findElement(By.name(name)).click();
	}

	/**
	 * Highlights the elements if it exists in the page
	 * @param text text to search for
	 */
	public void highlightElements(String text) {

		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]"));
		for (WebElement item : elements) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.background='yellow'", item);
		}
	}

	/**
	 * Highlights the exact text in the page
	 * @param text exact text to search for
	 */
	public void highlightExactText(String text) {

		List<WebElement> elements = driver.findElements(By.xpath("//*[text()='" + text + "']"));
		for (WebElement item : elements) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.background='yellow'", item);
		}
	}

	/**
	 * Highlights the element's border if found
	 * @param element element's name
	 */
	public void highlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border: 5px solid red !important; display: block');",
				element);
	}

	/**
	 * Captures the screenshot of the page
	 * @param scenario scenario ID
	 * @param alt_id test case ID
	 */
	public void takeScreenshot(Scenario scenario, String alt_id) {

		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	}

	/**
	 * Closes the browser
	 */
	public void close() {

		driver.quit();
	}
}