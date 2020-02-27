# BDD Test Framework

A sample BDD Test Framework using [Cucumber](https://cucumber.io/) for Java and [Selenium](https://selenium.dev/)
that includes sample feature specification for testing service availability.


## Requirements

[Apache Maven](https://maven.apache.org/download.cgi) is required to install dependencies and run scripts via `mvn`. Visit this [link](https://mkyong.com/maven/how-to-install-maven-in-windows/) on how to install Maven on Windows.

## Available Commands

| Command | Description |
|---------|-------------|
| `mvn install` | Install project dependencies |
| `mvn clean test` | Build project and run the automated tests |

## Writing Code

After cloning the repo, run `mvn install` from your project directory. Then, you can start the tests locally
by running `mvn clean test`. After starting the test with `mvn test`, you can edit any files in the `src` folder with your Eclipse or other editors.

## Project Structure

### Runner
This is the main Cucumber runner and contains most of the configurations for the tests like report config, screenshot and step (glue code) locations, and test coverage tags.

  ```
   retryCount = 3,
   detailedReport = true,
   detailedAggregatedReport = true,
   overviewReport = true,
   coverageReport = true,
   jsonUsageReport = "target/cucumber-usage.json",
   usageReport = true,
   excludeCoverageTags = {"@flaky"},
   includeCoverageTags = {"@passed"},
   outputFolder = "target",
   customTemplatesPath = "src/test/resources/templates",
	screenShotLocation = "./screenshots/cucumber/",
	sreenShotSize = "1000px",
	consolidatedReport = true,	
	consolidatedReportConfig = 	"src/test/resources/consolidated/consolidated_batch.json"
  ```

### Features
Cucumber feature files are test specification written in human readable language. But behind each step are Java glue codes that binds the test cases to the Java backend services that interacts with the system tested. Note that Cucumber Eclipse plugin must be installed before editing in Eclipse

  ```
	Scenario Outline: As an Internet user, I want to know which Chorus services are available to me. So that I can decide on the service I want to order.
    Given the user opens the "broadband-map" page
    When the user types his address "<address>"
    Then verify the address "<address>" displays in the list
  ```

### Steps
Steps are the glue codes that bind the steps in the Cucumber feature specification to the Java backend services. 

  ```
	@Then("verify the address \"([^\"]*)\" displays in the list$")
    public void verifyAddressList(String address) throws InterruptedException {
        
    	WebElement address_list = page.getAddressList();
    	TimeUnit.SECONDS.sleep(3);
    	address_list.click();
    }
  ```
### Pages
Web page models that contains the element, and methods to be used

### Util
Contains tools and common methods used by the framework

## Filtering Tests to Run
Some test cases can take hours to run depending on its volume. To filter one test to run, type:
  
  ```
	mvn test -Dcucumber.options="src/test[location of feature files]/[feature file name]:[line number]"  
  ```