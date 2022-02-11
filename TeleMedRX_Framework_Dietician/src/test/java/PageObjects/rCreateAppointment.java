/**
 * 
 */
package PageObjects;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Testbase.Testbase;

/**
 * @author mohan
 *create a appointment for randomly created patent
 *make sure the patinet exist or create it.
 */
public class rCreateAppointment extends Testbase {
	
	
	public static void raddAppointment() throws InterruptedException {
		
		
		SoftAssert softassert;


		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]"))).click();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"))).click();
		Thread.sleep(1000);


		//vRandromFirstName = randomStringForm();
		//String Fname1 = Fname();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("SearchPatientOpd"))))
		.sendKeys(vRandromFirstName);



		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("pname")))).click();

		//*************************** select slots***************************************//


		driver.findElement(By.xpath(prop.getProperty("realslots"))).click();

		driver.findElement(By.xpath(prop.getProperty("create_Appointment"))).click();



//		Thread.sleep(500);


		String toastactual = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(prop.getProperty("aptaddToast")))).getText();
		System.out.println("Testcase has been:- " +toastactual);
		String toastexpected = "Appointment is created successfully";
		softassert = new SoftAssert();

		AssertJUnit.assertEquals(toastactual, toastexpected);
		softassert.assertAll();

		
		//driver.quit();
		
	}
	

}
