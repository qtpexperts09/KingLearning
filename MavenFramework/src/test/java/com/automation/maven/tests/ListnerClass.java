package com.automation.maven.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

	public class ListnerClass implements ITestListener{
		/* This is TestNG listner class which will show logs for status and execution of each test case */

		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			Reporter.log("Failed Test with percentage of Sucess->"+ITestResult.SUCCESS_PERCENTAGE_FAILURE, true);
		}

		public void onStart(ITestContext arg0) {
	          Reporter.log("Start Of Execution(TEST)->"+arg0.getName(), true);
			  Reporter.log("********************************************",true);
	    }
	 
	    public void onTestStart(ITestResult arg0) {
	         Reporter.log("Test Started->"+arg0.getName(), true);
			 Reporter.log("********************************************",true);
	         //Reporter.log("Test started at time->"+arg0.getStartMillis(), true);
	     }
	 
	    public void onTestSuccess(ITestResult arg0) {
	    	 Reporter.log("Test Pass Name->"+arg0.getName(), true);
	    	 printTestResults(arg0);
	         Reporter.log("Priority of this method is->" + arg0.getMethod().getPriority(), true);
	         //Reporter.log("Test ended at time->"+arg0.getEndMillis(), true);
	     }
	 
	    public void onTestFailure(ITestResult arg0) {
	         Reporter.log("Test Failed Name->"+arg0.getName(), true);
	         printTestResults(arg0);
	         Reporter.log("Priority of this method is->" + arg0.getMethod().getPriority(), true);
	         //Reporter.log("Test ended at time->"+arg0.getEndMillis(), true);
	     }
	 
	    public void onTestSkipped(ITestResult arg0) {
	         Reporter.log("Test Skipped name->"+arg0.getName(), true);
	         printTestResults(arg0);
	         Reporter.log("Priority of this method is->" + arg0.getMethod().getPriority(), true);
	         //Reporter.log("Test ended at time->"+arg0.getEndMillis(), true);
	     }
	 
	    public void onFinish(ITestContext arg0) {
	     	Reporter.log("END Of Execution(TEST)->"+arg0.getName(), true);
	     }
	    
	    private void printTestResults(ITestResult result) {
	    	 
	    	Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
	 
			if (result.getParameters().length != 0) {
	 			String params = null;
	 			for (Object parameter : result.getParameters()) {
	 				params += parameter.toString() + ",";
	 			}
	 			Reporter.log("Test Method had the following parameters : " + params, true);
	 		}
	 		String status = null;
	 		switch (result.getStatus()) {
	 		case ITestResult.SUCCESS:
	 			status = "Pass";
	 			break;
	 		case ITestResult.FAILURE:
	 			status = "Failed";
	 			break;
	 		case ITestResult.SKIP:
	 			status = "Skipped";
	 		}
	 		Reporter.log("Test Status: " + status, true);
			Reporter.log("********************************************",true);
			Reporter.log("********************************************",true);
	 	}

	}


