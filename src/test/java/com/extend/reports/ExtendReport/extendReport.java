package com.extend.reports.ExtendReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendReport {
	ExtentReports extend;
	
	@BeforeTest
	public void getExtendReport() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("My first extend Report");
		reporter.config().setReportName("My first report");
		
		extend=new ExtentReports();
		extend.attachReporter(reporter);
		extend.setSystemInfo("Tester", "Pooja");
		
	}
	
	@Test
	public void getData() {
		ExtentTest test=extend.createTest("getData");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "D://Interview//Selenum Drivers//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Results do not match");
		test.fail("Results do not match1");
		test.fail("Results do not match2");
		extend.flush();
		
	}

}
