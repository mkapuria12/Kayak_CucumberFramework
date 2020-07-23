package com.kayak.qa.test;

import static org.testng.Assert.assertEquals;

//import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.kayak.qa.pages.FlightSearchPage;
import com.kayak.qa.pages.SearchOptionPage;
import com.kayak.qa.utilities.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightSearchTest extends TestBase{
	
	public FlightSearchTest(){
		super();
	}
	public static Logger log = Logger.getLogger(FlightSearchTest.class.getName());
	FlightSearchPage fsp;
	SearchOptionPage sop;
	SoftAssert sa=new SoftAssert();
	String sheetName="Flight search";
	JavascriptExecutor js;
//	@DataProvider
//	public Object[][] getFlightTestData() throws Exception{
//		Object data[][] = cUti.readDataFromExcelSheet(sheetName);
//		return data;
//	}
	
//	@BeforeMethod
//	public void setUp() throws IOException{
//		 fsp=new FlightSearchPage();
//		 sop=new SearchOptionPage();
//	}
	
	@BeforeSuite
	@Given("^Launch the chrome browser$")
	public void launch_the_chrome_browser() throws Throwable {
		
		bUti.launchBrowser("ch");
		bUti.URL();
		//String title=driver.getTitle();
		//log.info(title);
	}
	
	@Test(priority=1)
	@When("^Click on flight button$")
	public void click_on_flight_button() throws Throwable {
		fsp=new FlightSearchPage();
		fsp.kayakflight();
	    log.info("Clicked on Flight button.");
	    String fText=fsp.flightPage();
	    log.info(fText);
	    assertEquals(fText, "Search hundreds of flights at once.");
	}

	@Test(priority=2)
	@Then("^Enter origin \"(.*)\", destination \"(.*)\", select from date, to date and click on search button$")
	public void enter_origin_destination_select_from_date_to_date_and_click_on_search_button(String oCity, String dCIty) throws Throwable {
		fsp.cancelDefault();
	    log.info("Cancelled default origin city.");
	    fsp.originFlight(oCity);
	    log.info("Origin city is entered.");
	    fsp.originOption();
	    List<WebElement> originList = driver.findElements(By.xpath("(//ul[@class='flight-smarty'])[1]"));
		log.info(originList.size());	
		for(int i=0;i<originList.size();i++)	{
			log.info(originList.get(i).getText());
				if(i==0)
				{
					originList.get(i).click();
				}
			}
		fsp.destination();
		log.info("Clicked on destination.");
		fsp.destinationFlight(dCIty);
		log.info("Destination city is entered.");
		fsp.destinationOption();
		List<WebElement> destinationList = driver.findElements(By.xpath("(//ul[@class='flight-smarty'])[2]"));
		log.info(destinationList.size());
		for(int i=0;i<destinationList.size();i++)
			{
			log.info(destinationList.get(i).getText());
				if(i==0)
				{
					destinationList.get(i).click();
				}
			}
		fsp.fromDate();
		log.info("Clicked on from date.");
		fsp.selectDateFrom();
		log.info("Selected from date.");
		fsp.selectDateTo();
		log.info("Selected to date.");
		fsp.search();
		log.info("Clicked on search button.");
	    log.info("Informations are entered successfully and navigated to search option page.");
//	    String currUrl=driver.getCurrentUrl();
//	    log.info("The URL of search option page:- "+currUrl);
//	    assertEquals(currUrl, "https://www.kayak.com/flights/SFO-LAS/2020-07-31/2020-08-25?sort=bestflight_a");
	}

	@Test(priority=4)
	@When("^Select one search option$")
	public void select_one_search_option() throws Throwable {
		sop=new SearchOptionPage();
		sop.popUp();
		log.info("Closed pop up.");
		 js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		sop.searchList();
	    log.info("Option is selected.");
	    js.executeScript("window.scrollBy(0,0)");
	}

	@Test(priority=3)
	@Then("^Verify and Validate origin and destination cities$")
	public void Verify_and_Validate_origin_and_destination_cities()
	{
		
		String fOrText=fsp.flightOriginCity();
	    log.info(fOrText);
		String oText=sop.validateOriginCity();
	    log.info(oText);
	    sa.assertEquals(fOrText, oText, "Origins are the same.");
	    
	    String fDeText=fsp.flightDestinationCity();
	    log.info(fDeText);
	    String dText=sop.validatedestinationCity();
	    log.info(dText);
	    sa.assertEquals(fDeText, dText, "Destinations are the same.");
	}
	
	@AfterSuite
	@Then("^Quit the browser$")
	public void quit_the_browser() throws Throwable {
	    bUti.quitBrowser();
	}



}
