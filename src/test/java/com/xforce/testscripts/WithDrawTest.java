package com.xforce.testscripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xforce.common.ApplnStarts;
import com.xforce.common.Reuse;
import com.xforce.page_objects.LoginPageObj;
import com.xforce.page_objects.WithDrawPageObj;
import com.xforce.utilities.ExcelUtils;


public class WithDrawTest extends ApplnStarts {
	String withData[][];
@Test(dataProvider="withdrawAc")	
public void withDrawEleTest(String ac,String am,String de) throws IOException {
	Reuse.login();
	WithDrawPageObj withPage=new WithDrawPageObj(driver);
	withPage.clickWithdrawLink();
	withPage.enterAccNo(ac);
	withPage.enterAmount(am);
	withPage.enterDesc(de);
	withPage.withdrawSubmit();
	driver.switchTo().alert().accept();
	Reuse.logout();
}
@DataProvider(name="withdrawAc")
public String[][] dataForWithdrawTest() throws Exception {
	ExcelUtils utils=new ExcelUtils();
	withData=utils.readExcelData("withdraw");//sheet name
	return withData;
}
}
