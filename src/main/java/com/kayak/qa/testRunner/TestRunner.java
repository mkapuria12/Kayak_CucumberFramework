package com.kayak.qa.testRunner;


import org.junit.runner.RunWith;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import cucumber.api.testng.CucumberFeatureWrapper;
//import cucumber.api.testng.PickleEventWrapper;  
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		format={"pretty","json:path/to/json_repot.json"},
		features="Features",
		glue= {"com.kayak.qa.test"}, 
		monochrome=true)
public class TestRunner {
//	private TestNGCucumberRunner testNGCucumberRunner;  
//
//	  @BeforeClass(alwaysRun = true)  
//	    public void setUpClass() throws Exception {  
//	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
//	  }  
//
//	    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
//	    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {  
//	        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());  
//	  }  
//
//	    @DataProvider  
//	  public Object[][] scenarios() {  
//	        return (testNGCucumberRunner.provideScenarios();  
//	  }  
//
//	    @AfterClass(alwaysRun = true)  
//	    public void tearDownClass() throws Exception {  
//	        testNGCucumberRunner.finish();  
//	  }  
}
