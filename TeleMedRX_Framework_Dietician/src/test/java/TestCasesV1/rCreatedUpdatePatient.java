/**
 * 
 */
package TestCasesV1;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.LoginPage;
import PageObjects.SelectAnyClinicLocation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testbase.Testbase;

/**
 * @author mohan
 *update a randomly created patient
 */
public class rCreatedUpdatePatient extends Testbase {


	@Test(priority = 0)
	public static void patientForUpdateTestcase() throws Exception {

			//LoginPage.Doctorloginform();
			//SelectAnyClinicLocation.selectclinic();
		rCreatedrandomPatientAppointment.appointment();	
		//	rCreatedrandomPatientAppointment.CreateAappointment();

		updatepatient();
	}
	public  static void updatepatient() throws Exception {
		SoftAssert softassert;

		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(prop.getProperty("css")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Client")))).click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='searchBar']")))
		.sendKeys(vRandromFirstName);
		//
		/*
		 * WebElement searchpatient = driver.findElement(
		 * By.xpath("//input[@id='searchBar']")); searchpatient.click();
		 * searchpatient.sendKeys(prop.getProperty(vRandromFirstName));
		 * searchpatient.sendKeys(prop.getProperty("lname"));
		 * searchpatient.sendKeys(Keys.ENTER);
		 */

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(prop.getProperty("editclient")))).click();
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/a[1]"))).click();

		// change mobile no

		WebElement update_mobilenumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("form_mobilenumber")));
		update_mobilenumber.clear();
		update_mobilenumber.sendKeys("7000000000");

		// state

		// driver.findElement(By.id("form_state"))

		//Select drpstate = new Select(driver.findElement(By.id("form_state")));
		//drpstate.selectByVisibleText("Maharashtra");

		//driver.findElement(By.id("form_city")).sendKeys("Mumbai");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("form_postalcode"))).sendKeys("50000");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("update")))).click();


		/*
		 * String toastactual =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(prop.
		  getProperty("Clienttoast")))).getText();
		 * System.out.println("Testcase has been:- " +toastactual); 
		 * String toastexpected= "Client details updated successfully";
		 * 
		 * AssertJUnit.assertEquals(toastactual, toastexpected);
		 */




		try {
			//String toastactual = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(prop.getProperty("Clienttoast")))).getText();
			String toastactual = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Client details updated successfully')]"))).getText();
			System.out.println("Testcase has been captured:- " +toastactual); 

			
			String toastexpected= "Client details updated successfully";			

			softassert = new SoftAssert();		

			if (toastactual.equalsIgnoreCase(toastexpected)) {
				String name = "Pass";
				System.out.println("Testcase has been:- " + name);

			}
			else {
				String name = "Fail";
				System.out.println("Testcase has been :- " + name);
				System.out.println("Screenshot is captured");
				System.out.println("Testcase has been:- " +toastactual); 


				System.out.println("Screenshot is captured");
				getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
						+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");


			//	captureScreen(driver,"settings");





			}

			softassert = new SoftAssert();
			//AssertJUnit.assertEquals(toastactual, toastexpected);
			softassert.assertEquals(toastactual,  toastexpected);

			softassert.assertAll();


		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

		//driver.quit();



	}

}
