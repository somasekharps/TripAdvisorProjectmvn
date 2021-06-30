package com.qa.utility;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	ExtentHtmlReporter htmlReporter;
	  ExtentReports xReports;
	  ExtentTest xTest;
	  
	  
	public void onStart(ITestContext testContext) {
		
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String RepName= "Test-execution-report" + timeStamp + ".html";
		
		String dest =System.getProperty("user.dir")+"/Reports/"+RepName;
	
		htmlReporter =new ExtentHtmlReporter(dest);
		htmlReporter.config().setDocumentTitle("Automation Testing");
		htmlReporter.config().setReportName("Funtional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

		
		xReports=new ExtentReports();
		xReports.attachReporter(htmlReporter);
		xReports.setSystemInfo("host", "localhost");
		xReports.setSystemInfo("Tester name", "Eshwar");
		xReports.setSystemInfo("OS", "MAc");
	  }

	  
	  public void onFinish(ITestContext testContext) {
		  xReports.flush();
		  
	  }

	  public void onTestSuccess(ITestResult tr) {
		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		xTest.log(Status.PASS, "Test is passed");
		String Path = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
        File file =new File(Path);
        if(file.exists()) {
        	try {
				xTest.pass("Screenshot for passed test is" +xTest.addScreenCaptureFromPath(Path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	  }

	  
	  public void onTestFailure(ITestResult tr) {
			xTest = xReports.createTest(tr.getName());
			xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
			xTest.log(Status.FAIL, "Test is Failed");
			xTest.log(Status.FAIL, tr.getThrowable());
			String Path = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
        File file =new File(Path);
        if(file.exists()) {
        	try {
				xTest.fail("Screenshot for failed test is" +xTest.addScreenCaptureFromPath(Path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	  }

	  
	  public void onTestSkipped(ITestResult tr) {
			xTest = xReports.createTest(tr.getName());
			xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
			xTest.log(Status.SKIP, "Test is Skipped");
			xTest.log(Status.SKIP, tr.getThrowable());

	  }

	  

	  
}