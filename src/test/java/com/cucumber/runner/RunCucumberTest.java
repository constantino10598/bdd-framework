package com.cucumber.runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;
import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
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
		consolidatedReportConfig = "src/test/resources/consolidated/consolidated_batch.json"
)
@CucumberOptions(
		plugin = {"html:target/cucumber-html-report",
		          "json:target/cucumber.json", 
		          "pretty:target/cucumber-pretty.txt",
		          "usage:target/cucumber-usage.json", 
		          "junit:target/cucumber-results.xml" },
        features = "src/test/java/com/cucumber/features/service_check.feature",
        glue = "com.cucumber.steps"
)
public class RunCucumberTest extends ExtendedTestNGRunner {
	
		
}