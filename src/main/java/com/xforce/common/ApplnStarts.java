package com.xforce.common;

import java.io.File;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.xforce.utilities.ConfigUtils;
//import com.xforce.utilities.ConfigUtils;

public abstract class ApplnStarts {
	public  static WebDriver driver;
	//ConfigUtils conf=new ConfigUtils();
	public static ConfigUtils conf=new ConfigUtils();		
	public static String browserUrl=conf.applnUrl();
	public static String chromePath=conf.applnChromPath();
	public static String iePath=conf.applnIePath();
	public static String logUsName=conf.applnUserName();
	public static String logPasswd=conf.applnUserPwd();
	
	
	@Parameters("browser")
	@BeforeMethod
	public void browserInt(String browName) {
		if(browName.contains("chrome")) {
		System.setProperty("webdriver.chrome.driver",chromePath);
		driver=new ChromeDriver();
		}
		else if(browName.contains("ie")) {
			System.setProperty("webdriver.chrome.driver",iePath);
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("browser name not specified");
		}	
		
		driver.manage().window().maximize();
		driver.get(browserUrl);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
