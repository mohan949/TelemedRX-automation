/**
 * 
 */
package TestCasesV1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import PageObjects.LoginPage;
import PageObjects.SelectAnyClinicLocation;
import Testbase.Testbase;

/**
 * @author mohan
 *
 */
public class testcaseSCalendarModule extends Testbase {

	SoftAssert softassert;

	@Test(priority = 0)
	public void patientForCalendarTestcase() throws InterruptedException, IOException {
		LoginPage.Doctorloginform();
		SelectAnyClinicLocation.selectclinic();
		rCreatedrandomPatientAppointment.appointment();	
		rCreatedrandomPatientAppointment.CreateAappointment();
	}


	@Test(priority = 1)
	public static void calendarCheckCreatedAppointment() throws Exception {
		SoftAssert softassert;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("calendarbutton")))).click();
		//driver.navigate().refresh();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'week')]"))).click();
		try {
			
		//	String calendarTestExistActual = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(vRandromFirstName+" automated"))).getText();
		//driver.findElement(By.id("someID).getText().contains("textToSearch");

			
			String calendarTestExistActual = vRandromFirstName+" automated";
			
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(vRandromFirstName+" automated"))).getText().contains(calendarTestExistActual);
			
			System.out.println("test calendar has been :-" +calendarTestExistActual );
			String calendarTestExistexp = vRandromFirstName+" automated";
			//String calendarTestExistexp = "failed";

			softassert = new SoftAssert();		

			if (calendarTestExistActual.equalsIgnoreCase(calendarTestExistexp)) {
				String name = "Pass";
				System.out.println("Testcase has been:- " + name);

			}
			else {
				String name = "Fail";
				System.out.println("Testcase has been :- " + name);
				System.out.println("Screenshot is captured");





				System.out.println("Screenshot is captured");
				getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
						+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");





			}

			softassert = new SoftAssert();
			softassert.assertEquals(calendarTestExistActual, calendarTestExistexp);
			softassert.assertAll();


		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}




	}
	
	@Test(priority = 2)
	public static void calendarSlotsClick() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(vRandromFirstName+" automated"))).click();

		String details = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/h6[1]"))).getText();
		System.out.println("This are the appointment details :"+details);
	}

	
	
	@Test(priority = 2)
	public static void calendarSlotsClickExtra() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		Boolean Display = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Start Consultation')]"))).isDisplayed();
		//To print the value
		System.out.println("Element displayed is :"+Display);


		
		String name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/h6[1]"))).getText();
		System.out.println("Name :"+name);
		String Time = driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/h6[1]")).getText();
		System.out.println("Time :"+Time	);

		String Duration = driver.findElement(By.xpath("		//body/div[4]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/span[1]\r\n"
				+ "")).getText();
		System.out.println("Duration :"+Duration);
		
		String AppType = driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/span[1]")).getText();
		System.out.println("Appointment Type :"+AppType	);

	
	}
	@Test(priority = 3)
	public static void upateCalendarAppt() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/i[1]")).click();
		
		Boolean Clinic = driver.findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")).isSelected();
		System.out.println("Element selected is :"+Clinic);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/div[2]/input[1]"))).click();
		
		WebElement updateApptDetails = driver.findElement(By.xpath("//button[contains(text(),'Update Appointment Details')]"));
		//updateApptDetails.getText();
		updateApptDetails.click();
		//System.out.println(+updateApptDetails);
		String upt = updateApptDetails.getText();
		System.out.println(upt);
		
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/a[1]/span[1]"
		 * ))) .click(); Thread.sleep(3000); driver.quit();
		 */
		
		
		
	}
	@Test(priority = 4)
	public static void calenarStartConsultation() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'week')]"))).click();
	
		//wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(vRandromFirstName+" automated"))).click();

		WebElement calsatr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("startconsultButton"))));
		Boolean calSta =	calsatr.isEnabled();
		System.out.println("Button is Enabled :"+calSta);
		String calsatrString = calsatr.getText();
		System.out.println(calsatrString);
		
		calsatr.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Finish & Next Patie"))).click();
		Thread.sleep(2000);
		
	}

}
