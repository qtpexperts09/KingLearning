package com.automation.maven.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.maven.pages.AmazonHomePage;
import com.automation.maven.pages.AmazonRegisterationPage;
import com.automation.maven.resources.ReadDataProperty;
import com.automation.maven.resources.TestBaseSetUpClass;

@Listeners(ListnerClass.class)
public class DemoTest extends TestBaseSetUpClass{

		/*
		 * This is the demo test class for executing Test cases
		 * use testNG annotations for executing test cases in a specific order
		 */
		WebDriver driver;
		ReadDataProperty propertyDataObj = new ReadDataProperty();
		AmazonHomePage objHomePage;
	    AmazonRegisterationPage objRegisterPage;
	    
		
		@BeforeMethod
		public void setUp() throws IOException, InterruptedException{
			/* This is set up method which will execute before every test method
			*  Enters the data from property file
			*/
			Properties allObjects = propertyDataObj.getObjectRepository();
			String b = allObjects.getProperty("browser");  //chrome
			driver = getBrowser(b);
			driver.get(allObjects.getProperty("URL"));	
		}
		
		 @AfterMethod
		 public void TearDown(ITestResult testResult) throws IOException {
			/* This is teardown method which will execute after every test method.
			   Screenshots will be taken whenever test will fail
			*/
			 takeScreenShotOnFailure(testResult);
			 closeDriver();
		    }
		
		@Test(priority=1, enabled=true)
		public void test1() throws IOException, InterruptedException{
			
			 /* This is the test case for viewing test case library for specific logged in user
			 *  Steps:
			 *      1. 
			 *      2.
			 *      3.
			 *      4.
			 */
			
			//call Login(username,password) method here
			Properties allObjects = propertyDataObj.getObjectRepository();
			
		 	//Create Home Page and Register Page object
		    objHomePage = new AmazonHomePage(driver);
		    objRegisterPage = new AmazonRegisterationPage(driver);
		    
		   //MouseOver on Your Orders and click on start here link
		    objHomePage.mouseHoverOnYourOrders();
		    objHomePage.clickStarttHereLink();
		 
		    //Enter register details and click register button
		    objRegisterPage.registerUser(allObjects.getProperty("name"),allObjects.getProperty("phone"));
		   
		    System.out.println("Customer name wrong test case1 passed!!!!!");
			
		}
		
		@Test(priority=2, enabled=true)
		public void test2() throws IOException, InterruptedException{
			
			 /* This is the test case for viewing test case library for specific logged in user
			 *  Steps:
			 *      1. 
			 *      2.
			 *      3.
			 *      4.
			 */
			//call Login() method here
			//call Login(username,password) method here
			Properties allObjects = propertyDataObj.getObjectRepository();		
			
		 	//Create Home Page and Register Page object
		    objHomePage = new AmazonHomePage(driver);
		    objRegisterPage = new AmazonRegisterationPage(driver);
		    
		    //click on register link to goto registration page
		    objHomePage.mouseHoverOnYourOrders();
		    //objHomePage.clickStarttHereLink();
		 
		  //Enter register details and click register button
		    objRegisterPage.registerUser(allObjects.getProperty("fnameWrong"),allObjects.getProperty("phone"));
		    
		    System.out.println("Email id wrong test case1 passed!!!!!");
			
		}

}
