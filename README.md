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
		screenShotSize = "1000px",
		consolidatedReport = true,	
		consolidatedReportConfig = 	"src/test/resources/consolidated/consolidated_batch.json"
  ```

### Features
Cucumber feature files are test specification written in human readable language. But behind each step are Java glue codes that binds the test cases to the Java backend services that interacts with the system tested

### Features
Steps are the glue codes that bind the steps in the Cucumber feature specification to the Java backend services. Note that Cucumber Eclipse plugin must be installed before editing in Eclipse

### Pages
Web page models that contains the element, and methods to be used

### Util
Contains tools and common methods used by the framework

## Filtering Tests to Run
After you run the `npm run build` command, your code will be built into a single bundle located at 
`dist/bundle.min.js` along with any other assets you project depended. 

If you put the contents of the `dist` folder in a publicly-accessible location (say something like `http://mycoolserver.com`), 
you should be able to open `http://mycoolserver.com/index.html` and play your game.
