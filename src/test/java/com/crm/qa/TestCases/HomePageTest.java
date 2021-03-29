package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.BaseClass.TestBase;
import com.crm.qa.Constants.Constants;
import com.crm.qa.Pages.ContactsPage;
import com.crm.qa.Pages.DealsPage;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Reports.ExtentReportSetup;
import com.crm.qa.Utilities.TestUtility;
import com.crm.qa.Utilities.Xls_Reader;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;

	public HomePageTest()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		Log.info("Application Launched Successfully");
		testUtil = new TestUtility();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		//homePage = loginPage.login(property.getProperty("Username"),property.getProperty("Password"));
		homePage = loginPage.loginExcelData();
	}

	@Test(priority=0, enabled=true)
	public void VerifyHomePageTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, Constants.HOME_PAGE_TITLE, "Home Page Title is not Matched");
		ExtentReportSetup.extentInfo("Home Page Title Verified");
		Log.info("Home Page Title Verified");

		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyCorrectUserName());
		ExtentReportSetup.extentInfo("UserName Verified");
		Log.info("UserName Verified");

		contactsPage = homePage.clickOnContactsLink();
		ExtentReportSetup.extentInfo("Switched into Frame and Clicked on Contacts Link");
		Log.info("Switched into Frame and Clicked on Contacts Link");

		dealsPage = homePage.clickOnDealsLink();
		ExtentReportSetup.extentInfo("Clicked on Deals Link");
		Log.info("Switched into Frame and Clicked on Deals Link");
	}
}
