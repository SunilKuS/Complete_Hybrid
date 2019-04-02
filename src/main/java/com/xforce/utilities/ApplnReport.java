package com.xforce.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ApplnReport extends TestListenerAdapter{
	public ExtentHtmlReporter htmlRepo;
	public ExtentReports extent;
	public ExtentTest logger;
	
public void onStart(ITestContext testContext) {
	htmlRepo=new ExtentHtmlReporter("H:\\SeleniumAutomation\\Complete_Hybrid_Framework_Guru\\Reports\\finalReport.html");
	extent=new ExtentReports();
	extent.attachReporter(htmlRepo);	
}
public void onTestSuccess(ITestResult it) {
	logger=extent.createTest(it.getName());
	logger.log(Status.PASS,"Test is passed");
}
public void onTestFailure(ITestResult it) {
	logger=extent.createTest(it.getName());
	logger.log(Status.FAIL,"Test case failed");
	System.out.println(it.getName());
	String screenPath="H:\\SeleniumAutomation\\Complete_Hybrid_Framework_Guru\\Screenshots\\"+it.getName()+".png";
	try {
		logger.addScreenCaptureFromPath(screenPath);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
public void onTestSkipped(ITestResult it) {
	logger=extent.createTest(it.getName());
	logger.log(Status.PASS,"Test is skipped");
}
public void onFinish(ITestContext testContext) {
	extent.flush();
}
}
