package mainRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import TestCasesV1.testcaseSSettingModule;
import TestCasesV1.testcaseSelectClinic;
import Testbase.Testbase;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class blog extends Testbase{

	;



	@Test
	public static void signup() throws InterruptedException  {

		WebDriverWait wait = new WebDriverWait(driver, 10);



;


		ExtentTest test = extent.createTest("Class test1", "Testbase test");


		testcaseSelectClinic.Login();
		testcaseSelectClinic.Clinic();

		test.log(Status.INFO, "After login and selecting clinc and doctor");
		String a = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='form_category']"))).getText();
		System.out.println(a);
		logger.info("category");

		//driver.quit();
		//test.pass("driver close");

		test.info("Sucessful implemented report");
		extent.flush();


	}
	



}
