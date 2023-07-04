package com.dev.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/OrderProduct.feature", // content root
        glue = "com/dev/cucumber/stepdefinitions", //source root
        dryRun = false, // without executing checks if SLEEP for single method
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"} // 1st format of report, 2nd name of report, 3rd failedTest

)

public class Runner {


}
