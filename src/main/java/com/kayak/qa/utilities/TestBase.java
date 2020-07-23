package com.kayak.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners(com.kayak.qa.listner.TestListener.class)
public class TestBase {
	
	public static WebDriver driver=null;
	public static BrowserUtilities bUti=new BrowserUtilities();
	public static CommonUtilities  cUti=new CommonUtilities();
	
	public static String takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver; //Screenshot setup is done
		File Source = ts.getScreenshotAs(OutputType.FILE);//Taken the screenshot and saving it to source
		String sPathOfDestinationImage = System.getProperty("user.dir")+"/Screenshots/"+ 
				new SimpleDateFormat("'Image_'YYYYMMddHHmm'.png'").format(new Date());
		File dest = new File(sPathOfDestinationImage);
		FileUtils.copyFile(Source, dest);
		return sPathOfDestinationImage;
	}
}
