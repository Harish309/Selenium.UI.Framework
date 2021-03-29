package com.crm.qa.Reports;

import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.BaseClass.TestBase;
import com.crm.qa.Utilities.TestUtility;

public class ExtentReportSetup extends TestBase
{	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReport;
	
	public static ExtentReports extentReportSetup()
	{
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/CRMExtentResults/CRMExtentReport" + TestUtility.getSystemDate() + ".html");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.setSystemInfo("HostName", "Harish Gajjela");
		sparkReport.setStartTime(Calendar.getInstance().getTime());
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("Test Automation Report");
		sparkReport.config().setDocumentTitle("Test Automation Report");
		sparkReport.config().setProtocol(Protocol.HTTPS);
		sparkReport.config().setEncoding("UTF-8");
		sparkReport.getDeviceContextInfo();
		return extent;
	}
	
	public static void extentInfo(String msg)
	{
		extentTest.log(Status.INFO, msg);
	}
	
}
