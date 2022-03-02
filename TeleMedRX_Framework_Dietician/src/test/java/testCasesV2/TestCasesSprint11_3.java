package testCasesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.LoginPage;
import PageObjects.SelectAnyClinicLocation;
import TestCasesV1.rCreatedrandomPatientAppointment;
import Testbase.Testbase;

public class TestCasesSprint11_3 extends Testbase{
	

	@Test(priority = 0)
	public static void test300() {

		try {
			SoftAssert softassert;

			LoginPage.Doctorloginform();
			SelectAnyClinicLocation.selectclinic();
			rCreatedrandomPatientAppointment.appointment();	

			driver.navigate().refresh();
			Thread.sleep(3000);

			WebDriverWait wait = new WebDriverWait(driver, 50);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Client")))).click();
			Thread.sleep(1000);
			WebElement drpSearch  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='searchBar']")));
			drpSearch.sendKeys(vRandromFirstName);
			
			Select drpsrc = new Select(driver.findElement(By.name("dialcode")));
			drpsrc.selectByValue("id");
  
			WebElement ab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'No data available for this search category')]")));
			
			Boolean drpA = ab.isDisplayed();
			if(drpA==true) {
				drpsrc.selectByValue("name");

			}
			else {
				System.out.println("Not able to find :"+drpSearch);
			}
			

			String actualText = vRandromFirstName+" automated";
			System.out.println("Actual text present is : "+actualText);
			String exptText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'automated')]"))).getText();
			 
			System.out.println("Expected text present is : "+exptText);
			
			softassert = new SoftAssert();		

			
			
			if (actualText.equalsIgnoreCase(exptText)) {
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
			softassert.assertEquals(actualText, exptText);
			softassert.assertAll();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();


		}
		

	}
	@Test(priority = 1)
	public static void test2000() {
		
		try {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		System.out.println(vRandromFirstName+" second one");	
		
		String l = vRandromFirstName.toLowerCase();
		String u = vRandromFirstName.toUpperCase();
		
		
		WebElement drpSearch  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='searchBar']")));
		drpSearch.clear();
		drpSearch.sendKeys(l);
		
		String actualText1 =   vRandromFirstName+" automated";
		String exptText1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'automated')]"))).getText();
		
		
		
		System.out.println(exptText1);
		if(actualText1.equalsIgnoreCase(exptText1)) {
			System.out.println("Hurray");
		
		}
		else {
			System.out.println("lol");
		}
	/*		
		WebElement ab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'No data available for this search category')]")));
		Boolean drpA = ab.isDisplayed();
		System.out.println("not able to find element by lowercase"+drpA);
*/
		
		drpSearch.clear();
		drpSearch.sendKeys(u);
		Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();


		}
		
	}
}
