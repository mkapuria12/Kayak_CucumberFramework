package com.kayak.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kayak.qa.utilities.TestBase;

public class FlightSearchPage extends TestBase{
	
	public FlightSearchPage(){
		PageFactory.initElements(driver, this);
		
	}
	
//	public String validateHomePageTitle(){
//		return driver.getTitle();
//	}
	
	@FindBy(xpath="(//a[contains(text(),'Flights')])[1]")
	WebElement FlightButton;
	public void kayakflight()
	{
		bUti.waitForPageElementToVisible(FlightButton);
		FlightButton.click();
	}
	
	@FindBy(xpath="//h2[contains(text(),'Search hundreds of flights at once.')]")
	WebElement validateFlightpage;
	public String flightPage()
	{
		bUti.waitForPageElementToVisible(validateFlightpage);
		String flightText=validateFlightpage.getText();
		return flightText;
	}
	
	//cancel default origin
	@FindBy(xpath="(//button[@class='Button-No-Standard-Style js-remove-selection _iae _h-Y'])[1]")
	WebElement fromOriginCancelDefault;
	public void cancelDefault()
	{
		bUti.waitForPageElementToVisible(fromOriginCancelDefault);
		fromOriginCancelDefault.click();	
	}
		
	//pass origin value
	@FindBy(xpath="(//input[contains(@id,'-origin-airport')])[1]")
	WebElement fromOrigin;
	public void originFlight(String oCity)
	{
		bUti.waitForPageElementToVisible(fromOrigin);
		fromOrigin.sendKeys(oCity);
	}
	
	//select origin from the option
	@FindBy(xpath="(//ul[@class='flight-smarty'])[1]")
	WebElement selectOrigin;
	public void originOption()
	{
		bUti.waitForPageElementToVisible(selectOrigin);
	}
	
	//click on destination 
	@FindBy(xpath="(//div[contains(@id,'-destination-airport-display')])[1]")
	WebElement toDestinationClick;
	public void destination()
	{
		bUti.waitForPageElementToVisible(toDestinationClick);
		toDestinationClick.click();	
	}
	
	//pass destination value
	@FindBy(xpath="(//input[contains(@id,'-destination-airport')])[1]")
	WebElement toDestination;
	public void destinationFlight(String dCity)
	{
		bUti.waitForPageElementToVisible(toDestination);
		toDestination.sendKeys(dCity);
	}
	
	//select destination from the option
	@FindBy(xpath="(//ul[@class='flight-smarty'])[2]")
	WebElement selectDestination;
	public void destinationOption()
	{
		bUti.waitForPageElementToVisible(selectDestination);	
	}
	
	//click on from date
	@FindBy(xpath="(//div[@class='_iaf _iEU _iam _iai']//parent::div[contains(@id,'-dateRangeInput-display-start')])[1]")
	WebElement fromDateCLick;
	public void fromDate()
	{
		bUti.waitForPageElementToVisible(fromDateCLick);
		fromDateCLick.click();	
	}
	
	//select from date
	@FindBy(xpath="(//div[@class='_j2U _icW _icg _iq6 _ix7 _iaB _jyS _iXu _j16 _jPW _j19' and contains(text(),'31')])[1]")
	WebElement fromDateSelect;
	public void selectDateFrom()
	{
		bUti.waitForPageElementToVisible(fromDateSelect);
		fromDateSelect.click();	
	}
	
	//select To date
	@FindBy(xpath="(//div[@class='_j2U _icW _icg _iq6 _ix7 _iaB _jyS _iXu _j16 _jPW _j19' and contains(text(),'15')])[3]")
	WebElement ToDateSelectSelect;
	public void selectDateTo()
	{
		bUti.waitForPageElementToVisible(ToDateSelectSelect);
		ToDateSelectSelect.click();	
	}
	
	//search button
	@FindBy(xpath="//span[contains(@class,'v-c-p centre')]//span[contains(@class,'icon')]//*[local-name()='svg']")
	WebElement searchButton;
	public void search()
	{
		bUti.waitForPageElementToVisible(searchButton);
		searchButton.click();	
	}
	
	@FindBy(xpath="(//div[@class='js-selection-text-container _iac _iad _ia1 _iaa _iab _iaB _h-8 _ii0 _kaN'])[1]")
	WebElement fOrigin;
	public String flightOriginCity()
	{
		String foriginText=fOrigin.getText();
		return foriginText;
	}
	
	@FindBy(xpath="(//div[@class='js-selection-text-container _iac _iad _ia1 _iaa _iab _iaB _h-8 _ii0 _kaN'])[2]")
	WebElement fDestination;
	public String flightDestinationCity()
	{
		String fDestinationText=fDestination.getText();
		return fDestinationText;
	}
}
