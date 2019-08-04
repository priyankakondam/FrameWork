package actilogintest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.FileLib;
import pom.ActiLoginPage;

public class ActiLoginTest extends BaseTest{

	FileLib fLib;
	
	@Test(enabled=false)
	public void LoginToActiTIMEWithValidData() throws Throwable
	{
		fLib=new FileLib();
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle,fLib.getCellData("InvalidData", 1, 3));
		Reporter.log("I am test Msg",true);
	}
	
	@Test(enabled=true)
	public void LoginToActiTIMEWithInvalidData() throws Throwable
	{
		fLib=new FileLib();
		ActiLoginPage alp=new ActiLoginPage(driver);
		
		int rowCount = fLib.getRowCount("InvalidData");
		
		for(int i=1;i<=rowCount;i++)
		{
		String username = fLib.getCellData("InvalidData", i, 0);
		String password = fLib.getCellData("InvalidData", i, 1);
		Thread.sleep(3000);
		alp.setUsername(username);
		Thread.sleep(3000);
		alp.setPassword(password);
		Thread.sleep(3000);
		alp.clickLoginBtn();
		Thread.sleep(6000);
		String loginPageTitle = driver.getTitle();
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(loginPageTitle, fLib.getCellData("InvalidData", 1, 2));
		sa.assertAll();
		}
	}
	
}









