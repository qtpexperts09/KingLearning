package com.automation.maven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonRegisterationPage {
	
	 WebDriver driver; 
	 By name =By.id("ap_customer_name");
	 By phone =By.id("ap_phone_number");
	 By continueButton =By.id("continue");
	 	 
	 //Constructor 
	 public AmazonRegisterationPage(WebDriver driver)
	    {
	 	  this.driver = driver;
	    }
	    
	 //Enter data in name field
	 public void enterDataInCustomerName(String cname)
	    {
	 	  driver.findElement(name).sendKeys(cname);
	    }
	 //Enter data in phone field
	 public void enterDataInMobileNum(String mob)
	    {
	 	  driver.findElement(phone).sendKeys(mob);
	    }

	 //Click on Register button
	 public void clickContinueButton()
	    {
	 	  driver.findElement(continueButton).click();
	    }
	 
	    public void registerUser(String name,String phone){
	     //Enter details in the registration form
	    	this.enterDataInCustomerName(name);
	    	this.enterDataInMobileNum(phone);
	    //click on register button
	        this.clickContinueButton();
	    }
	 
	}

