package com.qa.testscript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.TripAdvisorPage;

public class TestBase {
	WebDriver driver;
	TripAdvisorPage trip;
	@Parameters({"Browser","url"})
	@BeforeClass
    public void setUp(String Browser, String url)
	{
	
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Somu Sekhar Reddy\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
	}
	else if(Browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\Somu Sekhar Reddy\\Desktop\\edgedriver_win64\\msedgedriver.exe");
		driver= new EdgeDriver();
		
	}
	driver.manage().window().maximize();
	driver.get(url);

	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreenShot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File Source=screenshot.getScreenshotAs(OutputType.FILE);
		String Dest=System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		FileUtils.copyFile(Source,new File(Dest));
	}
}

