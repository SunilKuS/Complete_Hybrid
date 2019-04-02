package com.xforce.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithDrawPageObj {
	WebDriver rdriver;
	public WithDrawPageObj(WebDriver driver) {
		rdriver=driver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//a[contains(text(),'Withdrawal')]")
	WebElement lnkWithDraw;
	@FindBy(xpath="//input[@name='accountno']")
	WebElement txtAcNo;
	@FindBy(xpath="//input[@name='ammount']")
	WebElement txtAmt;
	@FindBy(xpath="//input[@name='desc']")
	WebElement txtDesc;
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnSubmit;
	
	public void clickWithdrawLink() {
		lnkWithDraw.click();
	}
	public void enterAccNo(String acNo) {
		txtAcNo.sendKeys(acNo);
	}
	public void enterAmount(String amt) {
		txtAmt.sendKeys(amt);
	}
	public void enterDesc(String desc) {
		txtDesc.sendKeys(desc);
	}
	public void withdrawSubmit() {
		btnSubmit.click();
	}
	

	
}
