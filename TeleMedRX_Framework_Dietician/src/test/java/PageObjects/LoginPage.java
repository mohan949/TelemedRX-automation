package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Testbase.Testbase;

public class LoginPage extends Testbase {
	
	
	
	public static void Doctorloginform() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);


		driver.get("http://devportal.telemedrx.in/app/");
		
		
		// window size
		//driver.manage().window().maximize();
		//login
		//username
		//wait.until(ExpectedConditions.elementToBeClickable(By.(prop.getProperty("Username")))).sendKeys(prop.getProperty("DoctorUsername"));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Username")))).sendKeys(prop.getProperty("DoctorUsernameP"));
		//password
		driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("DoctorPasswordP"));
		//Login click
		
		driver.findElement(By.xpath("//div[contains(text(),'LOGIN')]")).click(); 
		
		System.out.println("login Sucessful");
		//WebDriverWait wait = new WebDriverWait(driver, 10);

		/*
		 * boolean clinicSelectConfirm =
		 * driver.getPageSource().contains("Confirm Clinic Location:");
		 * 
		 * if (clinicSelectConfirm==true) { Assert.assertTrue(true);
		 * System.out.println("LoginSucessful!"); } else {
		 * 
		 * captureScreen(driver,"Doctorloginform");
		 * 
		 * Assert.assertTrue(false);
		 * 
		 * 
		 * }
		 */
		
		
	}

}
