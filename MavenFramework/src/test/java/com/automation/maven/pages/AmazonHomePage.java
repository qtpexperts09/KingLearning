package com.automation.maven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonHomePage {
	
	//driver instance or declaration
	//Locators
	//constructor
	//functions or actions on the objects
	//other function
	
	 WebDriver driver; 
	 
	 //Locators
	 By youOrders = By.xpath(".//*[@id='nav-link-yourAccount']/span[2]");
	 By startHere = By.linkText("Start here.");  // id of register link on home page
	 
	 //Constructor 
	 public AmazonHomePage(WebDriver driver)
	    {
	 	  this.driver = driver;
	    }
	 
	 //Click on login button
	 public void mouseHoverOnYourOrders() throws InterruptedException
	    {
		
			WebElement ele1 = driver.findElement(youOrders);
					
			Actions action = new Actions(driver);
			action.moveToElement(ele1).perform();
			Thread.sleep(2000);
	    }
	    
	 //Click on login button
	 public void clickStarttHereLink() throws InterruptedException
	    {
	 	  driver.findElement(startHere).click();
	 	 Thread.sleep(2000);
	    }
	}