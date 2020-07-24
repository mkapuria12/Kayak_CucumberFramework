package com.kayak.qa.testRunner;
import java.io.File;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		format={"pretty","json:path/to/json_repot.json"},
		features="Features",
		glue= {"com.kayak.qa.test"}, 
		monochrome=true
		)
public class TestRunner {
	@AfterClass
    public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		/*Reporter.setSystemInfo("User Name", "AJ");
		Reporter.setSystemInfo("Application Name", "Test App ");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");  */ }
}
//com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:
//com.cucumber.listener.ExtentCucumberFormatter