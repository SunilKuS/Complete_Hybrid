package com.xforce.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Reuse extends ApplnStarts {
	public static void screenShotsTaken( WebDriver driver,String imgName) throws IOException {
		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuu");
		TakesScreenshot takeScreen=(TakesScreenshot) driver;
		File src=takeScreen.getScreenshotAs(OutputType.FILE);
		File dest=new File("H:\\SeleniumAutomation\\"
				+ "Complete_Hybrid_Framework_Guru\\Screenshots\\"+imgName+".png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screeenshot is taken!!!!");
		}
	public static void login() {
		driver.findElement(By.name("uid")).sendKeys(logUsName);
		driver.findElement(By.name("password")).sendKeys(logPasswd);
		driver.findElement(By.name("btnLogin")).click();
	}
	
	public static void logout() {
		driver.findElement(By.partialLinkText("Log out")).click();
	}
}
