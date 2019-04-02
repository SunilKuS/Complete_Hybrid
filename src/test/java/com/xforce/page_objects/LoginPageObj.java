package com.xforce.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObj {
	WebDriver rdriver;
	public LoginPageObj(WebDriver driver) {
		rdriver=driver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(name="uid")
	WebElement txtLogUname1;
	@FindBy(name="password")
	WebElement txtLogPwd1;
	@FindBy(name="btnLogin")
	WebElement btnLog1;
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement btnReset;
	
	public void txtValueUname(String uname) {
		txtLogUname1.sendKeys(uname);
	}
	public void txtValuePwd(String pwd) {
		txtLogPwd1.sendKeys(pwd);
	}
	public void btnLogClick() {
		btnLog1.click();
	}
	public void btnResetClick() {
		btnReset.click();
	}
	

	public String txtUnameGetText() {
		return txtLogUname1.getAttribute("value");
	}
	public String txtPwdGetText() {
		return txtLogPwd1.getAttribute("value");
	}

}
