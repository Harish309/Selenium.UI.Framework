package com.crm.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.BaseClass.TestBase;
import com.crm.qa.Constants.Constants;
import com.crm.qa.Utilities.TestUtility;
import com.crm.qa.Utilities.Xls_Reader;

import jdk.internal.org.jline.utils.Log;

public class LoginPage extends TestBase
{
	Xls_Reader xls = new Xls_Reader(Constants.TEST_DATA_SHEET_PATH);

	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@class='btn btn-small' and @type='submit']") 
	WebElement loginButton;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpButton;

	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}

	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}

	public HomePage login(String Username, String Password)
	{
		username.sendKeys(Username);
		password.sendKeys(Password);
		Log.info(Username);
		Log.info(password);

		TestUtility.clickOnJS(driver, loginButton, 30);

		return new HomePage();
	}

	public HomePage loginExcelData()
	{
		username.sendKeys(xls.getCellData("creds", 0, 2));
		password.sendKeys(xls.getCellData("creds", 1, 2));
		Log.info(xls.getCellData("creds", 0, 2));
		Log.info(xls.getCellData("creds", 1, 2));
		TestUtility.clickOnJS(driver, loginButton, 30);

		return new HomePage();
	}
}

