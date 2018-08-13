package com.automation.maven.resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class TestBaseSetUpClass {

	/*
	 * This is the Test Base Setup class for opening Browser of the given choice
	 * and closing browser using testNG annotations
	 * This will login to Saint application every-time a new test will execute
	 * Function for taking screenshot is also present in this class when the test fails.
	 */
    private static WebDriver driver;

    ReadDataProperty propertyDataObj = new ReadDataProperty();

    public static WebDriver getBrowser(String browserType)
    {
	 /*@param: WebDriver driver
	  *@return: This is returning driver
	  */
        if(driver == null || driver.toString().startsWith("ChromeDriver") || driver.toString().startsWith("FirefoxDriver"))

        {
            if(browserType.equals("firefox"))
            {
                System.setProperty("webdriver.gecko.driver","src//test//java//geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().deleteAllCookies();
                System.out.println(driver);
                driver.manage().window().maximize();
            }
            else if(browserType.equals("chrome"))
            {
            	ChromeOptions options = new ChromeOptions();
                options.addArguments("chrome.switches","--disable-extensions");
                System.setProperty("webdriver.chrome.driver","src//test//java//chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                System.out.println(driver);
            }
        }
        return driver;
    }

    public static void closeDriver()
    {
        /*@method: This is closing driver*/
        driver.close();
    }

    public static void logIn(String email,String password) 
    {
		/*@param: email and password for login into application
		 *@method: Sign in to application
		 */
      
    	//here you have to write the code for LOGIN TO SHUTTERFLY/Facebook
    }

    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException
    {
        /*This function will take the screenshot and save the image at the given location*/

        final String DATE_FORMAT_NOW = "dd-MM-yyyy_HH-mm-ss";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        if (testResult.getStatus() == ITestResult.FAILURE)
        {
            String fileName = "testScreenShot"+sdf.format(cal.getTime())+ ".jpg";
            Reporter.log(fileName);
            Reporter.log("Status for failure is: = " , testResult.getStatus());
            try {

	    		/*ClassLoader loader = Thread.currentThread().getContextClassLoader();
	            InputStream resourceStream = loader.getResourceAsStream("src/main/screenshots/iLabsQA/SaintAutomationProject/"+fileName);*/
            	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //press print screen button of keyboard
    			Files.copy(srcFile, new File("src//test//java//com//automation//maven//screenshots//"+fileName)); //save the file

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


