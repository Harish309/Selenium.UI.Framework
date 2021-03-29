package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.BaseClass.TestBase;
import com.crm.qa.Constants.Constants;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Reports.ExtentReportSetup;

public class LoginPageTest extends TestBase  
{	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		Log.info("Application Launched Successfully");
		loginPage = new LoginPage();
	}
	
	@Test(priority=1, enabled=true)
	public void VerifyloginTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Page Title is not Matched");
		ExtentReportSetup.extentInfo("Login Page Title Verified");
		Log.info("Login Page Title Verified");
		
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		ExtentReportSetup.extentInfo("CRM Logo Verified");
		Log.info("CRM Logo Verified");
		
		//homePage = loginPage.login(property.getProperty("Username"),property.getProperty("Password"));
		homePage = loginPage.loginExcelData();
		ExtentReportSetup.extentInfo("Successfully Logged into CRM Application");
		Log.info("Successfully Logged into CRM Application");
	}
}
