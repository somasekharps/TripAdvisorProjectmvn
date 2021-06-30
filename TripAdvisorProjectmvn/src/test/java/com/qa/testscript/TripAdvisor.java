package com.qa.testscript;


import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.TripAdvisorPage;
import com.qa.utility.ExcelUtility;

public class TripAdvisor extends TestBase
{
	@Test(dataProvider="getData")
	 public void serachTrip(String places) throws InterruptedException, IOException
	   {
		TripAdvisorPage trip=new TripAdvisorPage(driver);
		 Thread.sleep(6000);
	   	 trip.gethoidayhomes().click();
		 Thread.sleep(6000);
		 trip.gettextbox().sendKeys(places);
		 Thread.sleep(6000);
		 trip.gettextbox().sendKeys(Keys.ENTER);
		 Thread.sleep(6000);
		 trip.getCheckin().click();
		 trip.getCheckinDate().click();
		 trip.getCheckout().click();
		 trip.getCheckoutDate().click();
		 List<WebElement> searchhome=trip.getSearchHomes();
		int size=searchhome.size();
		 for(int i=0;i<searchhome.size();i++)
		 {
			 Reporter.log(searchhome.get(i).getText(),true);
		 }
		 if(size>0)
		 {
			 captureScreenShot(driver,"serachTrip");
			 Reporter.log("the iteam is searched",true);
			 Assert.assertTrue(true);
         }
		 else
		 {
			 
			  Reporter.log("the iteam is not searched",false);
		 }
		 Thread.sleep(6000);
		
		 driver.navigate().back();
		 }
	
	 @DataProvider
	    public Object[][] getData() throws IOException
	    {
	    	String xFile="C:\\Users\\Somu Sekhar Reddy\\eclipse-workspace\\TripAdvisorProject\\src\\test\\java\\com\\qa\\InpuData\\TripInputData.xlsx";
	    	String xSheet="Sheet2";
	    	int rowCount=ExcelUtility.getRowCount(xFile,xSheet);
	    	int cellCount=ExcelUtility.getCellCount(xFile,xSheet,rowCount);
	    	Object[][] data=new Object[rowCount][cellCount];
	    	
	    	for(int i=1;i<=rowCount;i++)
	    	{
	    		for(int j=0;j<cellCount;j++)
	    		{
	    			data[i-1][j]=ExcelUtility.getCellData(xFile,xSheet,i,j);
	    		}
	    	}
			return data;
 
	    }
}
