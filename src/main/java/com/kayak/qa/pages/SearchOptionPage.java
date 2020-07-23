package com.kayak.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kayak.qa.utilities.TestBase;

public class SearchOptionPage extends TestBase {
	
	public SearchOptionPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	//close pop up
		@FindBy(xpath="//button[contains(@id,'-covid-loading-dialog-close')]")
		WebElement closePopup;
		public void popUp()
		{
			bUti.waitForPageElementToVisible(closePopup);
			closePopup.click();	
		}
		
	@FindBy(xpath="(//div[contains(@id,'-info-leg-0-select-leg-checkbox-icon')])[1]")
	WebElement selectOption;
	public void searchList()
	{
		bUti.waitForPageElementToVisible(selectOption);
		selectOption.click();
		
	}
	
	@FindBy(xpath="(//div[@class='js-selection-display _id7 _ii0 _iir _iQe _kaM _ic2 _ic3'])[1]")
	WebElement originText;
	public String validateOriginCity()
	{
		String oCityText=originText.getText();
		return oCityText;
	}
	
	@FindBy(xpath="(//div[@class='js-selection-display _id7 _ii0 _iir _iQe _kaM _ic2 _ic3'])[2]")
	WebElement destinationText;
	public String validatedestinationCity()
	{
		String dCityText=destinationText.getText();
		return dCityText;
	}
}
