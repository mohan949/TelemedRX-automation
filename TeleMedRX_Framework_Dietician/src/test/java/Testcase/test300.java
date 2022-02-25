package  Testcase;

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

import TestCasesV1.testcaseSelectClinic;
import Testbase.Testbase;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class test300 extends Testbase  {



		@Test
		public void signup() throws InterruptedException  {

			WebDriverWait wait = new WebDriverWait(driver, 10);


		        




			testcaseSelectClinic.Login();
			testcaseSelectClinic.Clinic();


			String a = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='form_category']"))).getText();
			System.out.println(a);
			logger.info("category");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]"))).click();
			logger.info("right side button");

			driver.findElement(By.xpath("//a[contains(text(),'Sign Out!')]")).click();
			Thread.sleep(3000);

			driver.quit();



		}

	//}

}
