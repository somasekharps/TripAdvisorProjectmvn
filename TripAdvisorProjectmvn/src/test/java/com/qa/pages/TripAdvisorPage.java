package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAdvisorPage 
{
	WebDriver driver;
	   
    @FindBy(xpath="/html/body/div[2]/div/form/input[1]")
    WebElement textbox;
    public WebElement gettextbox()
    {
    	return textbox;
    }
    @FindBy(className="_3qLQ-U8m")  
    WebElement search;
    public WebElement getsearch()
    {
    	return search;
    }
    @FindBy(xpath="//*[@id=\"lithium-root\"]/main/div[1]/div[2]/div/div/div[2]/a")
    WebElement hoidayhomes;
    
    public WebElement gethoidayhomes()
    {
    	return hoidayhomes;
    }
    
    @FindBy(xpath="//*[@id=\"lithium-root\"]/main/div[1]/div[2]/div/div/div[1]/a")
    WebElement hotels;
    
    public WebElement gethotels()
    {
    	return hotels;
    }
    
    @FindBy(xpath="//*[@id=\"component_2\"]/div/div[2]/div/div/div/div[1]/div/div/div[2]")
     WebElement Checkin;
    
    public WebElement getCheckin()
    {
    	return Checkin;
    }
    
    @FindBy(xpath="//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div[2]/div[3]/div[3]/div[2]")
    WebElement CheckinDate;
   
    public WebElement getCheckinDate()
    {
   	 return CheckinDate;
    }
    @FindBy(xpath="//*[@id=\"component_2\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]")
    WebElement Checkout;
  
    public WebElement getCheckout()
    {
  	return Checkout;
    }
    @FindBy(xpath="//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div[4]/div[3]")
    WebElement CheckoutDate;
 
    public WebElement getCheckoutDate()
    {
 	return CheckoutDate;
    }
    @FindAll(@FindBy(className="_2K0y-IXo"))
    List<WebElement> SearchHomes;

    public List<WebElement> getSearchHomes()
    {
	return SearchHomes;
    }
    
    
    @FindAll(@FindBy(className="_33TIi_t4"))
    List<WebElement> price;

    public List<WebElement> getprice()
    {
	return price;
    }
    
    public TripAdvisorPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
}

