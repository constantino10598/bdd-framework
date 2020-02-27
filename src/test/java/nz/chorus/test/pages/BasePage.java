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

public class BasePage {

	WebDriver driver;

	public void open() {

		ConfigUtil config_util = new ConfigUtil();
		File driver_path = new File(config_util.getConfigPropertyValues("chrome.driver.path"));
		System.setProperty("webdriver.chrome.driver", driver_path.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {

		return this.driver;
	}

	public void navigate(String url) {
		
		driver.get(url);
	}

	public void setInputs(WebElement field, String text) {
		
		field.clear();
		field.sendKeys(text);
	}
	
	public void setInputById(String id, String text) {

		WebElement input = driver.findElement(By.id(id));
		input.clear();
		input.sendKeys(text);
	}
	
	public boolean isFieldDisplayed(WebElement webElement) {

		return webElement.isDisplayed();
	}

	public boolean isFieldDisplayed(String id) {

		try {
			WebElement element = driver.findElement(By.id(id));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isTextDisplayed(String text) {

		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText.contains(text);
	}

	public boolean isExactTextDisplayed(String text) {

		String bodyText = driver.findElement(By.tagName("body")).getText();
		String pattern = "\\b" + text + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(bodyText);
		return m.find();
	}

	public void clickElementByName(String name) {

		driver.findElement(By.name(name)).click();
	}

	public void highlightElements(String text) {

		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]"));
		for (WebElement item : elements) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.background='yellow'", item);
		}
	}

	public void highlightExactText(String text) {

		List<WebElement> elements = driver.findElements(By.xpath("//*[text()='" + text + "']"));
		for (WebElement item : elements) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.background='yellow'", item);
		}
	}

	public void highlightText(String text) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var body = document.getElementsByTagName('body');"
				+ "document.body.innerHTML = document.body.innerHTML.replace(arguments[0], '<span style=background-color:yellow; >"
				+ text + "</span>');", text);
	}

	public void highlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border: 5px solid red !important; display: block');",
				element);
	}

	public void takeScreenshot(Scenario scenario, String alt_id) {

		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	}

	public void close() {

		driver.quit();
	}
}