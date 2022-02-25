/**
 * 
 */
package TestCasesV1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.rCreateRandomPatient;
import Testbase.Testbase;
import Testcase.EndtoEndFullRegressionPack;

/**
 * @author mohan
 *
 */
public class testcaseSSettingModule extends Testbase{


	@Test(priority = 2)
	public void patientForCalendarTestcase() {
		
	
		
		testcaseSelectClinic.Login();
		testcaseSelectClinic.Clinic();
		
		
	}
	
	public static void testcaseSettings_ALLButtonsAreWorking() {
		
		
		
	}
	
	
	
	

	@Test(priority = 3)

	public static  void testcasequotes() throws Exception {

		SoftAssert softassert;



		//select settings
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("settingsButton")))).click();



		



		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Quotes Settings"))).click();

		driver.navigate().refresh();


		WebElement footernote =	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save')]")));
		footernote.click();


		try {



			String footact =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(prop.getProperty("footerSaveToast")))).getText();
			System.out.println("test setting has been :-" +footact );
			String footexp = "Quotes updated successfully";
			softassert = new SoftAssert();		

			if (footact.equalsIgnoreCase(footexp)) {
				String name = "Pass";
				System.out.println("Testcase has been:- " + name);

			}
			else {
				String name = "Fail";
				System.out.println("Testcase has been :- " + name);
				System.out.println("Screenshot is captured");





				captureScreen(driver,"settings");





			}

			softassert = new SoftAssert();
			AssertJUnit.assertEquals(footact, footexp);
			softassert.assertAll();


		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}





		Thread.sleep(3000);

		driver.quit();
	}


}
