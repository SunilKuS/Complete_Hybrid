package com.xforce.testscripts;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.xforce.common.ApplnStarts;
import com.xforce.common.Reuse;
import com.xforce.page_objects.LoginPageObj;

public class LoginTest extends ApplnStarts {
	
	@Test
	public void loginTestOp() throws IOException {
		LoginPageObj logPage=new LoginPageObj(driver);//dont put outside of a class
		logPage.txtValueUname(logUsName);
		logPage.txtValuePwd("logPasswd");
		logPage.btnLogClick();
		String text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		//String curl=driver.getCurrentUrl();
		if(text.equals("User or Password is not valid")) {
			
			Assert.assertTrue(true);
		}
		else {
			Reuse.screenShotsTaken(driver,"loginTestOp");
			System.out.println("false value");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void resetButtonTest() throws IOException {
	LoginPageObj lPage=new LoginPageObj(driver);
	lPage.txtValueUname("how are you");
	lPage.txtValuePwd("hello dude");
	lPage.btnResetClick();
	String ut=lPage.txtUnameGetText();
	String pt=lPage.txtPwdGetText();
	if(ut.equals("") && pt.equals("")) {
		Assert.assertTrue(true);
	}
	else {
		Reuse.screenShotsTaken(driver,"resetButtonTest");
		Assert.assertTrue(false);
	}
	}
	
	
	
	
	
	
	
	
	
	

}


