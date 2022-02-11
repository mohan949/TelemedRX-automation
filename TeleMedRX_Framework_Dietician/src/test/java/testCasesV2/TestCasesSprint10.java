package testCasesV2;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import PageObjects.LoginPage;
import PageObjects.SelectAnyClinicLocation;
import PageObjects.rCreateAppointment;
import PageObjects.rCreateRandomPatient;
import TestCasesV1.rCreatedUpdatePatient;
import TestCasesV1.rCreatedrandomPatientAppointment;
import TestCasesV1.testcaseSCalendarModule;
import Testbase.Testbase;
import Testcase.EndtoEndFullRegressionPack;

@SuppressWarnings("unused")
public class TestCasesSprint10 extends Testbase{

	@Test(priority = -1)
	public void TLMDRx_016() throws InterruptedException {
		
		
		try {
			LoginPage.Doctorloginform();

		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	


	@Test(priority = 0)
	public void TLMDRx_001() throws Throwable {

		//SelectAnyClinicLocation.selectclinic();
		//rCreatedrandomPatientAppointment.appointment();	
		//LoginPage jjj = new LoginPage();
		//jjj.Doctorloginform();

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10); boolean
		 * clinicSelectConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//div[contains(text(),'Confirm Clinic Location:')]\r\n" +
		 * ""))).isDisplayed(); if (clinicSelectConfirm==true) {
		 * Assert.assertTrue(true); System.out.println("TestCase_Pass"); } else {
		 * 
		 * captureScreen(driver,"SelectAnyClinicLocation");
		 * 
		 * Assert.assertTrue(false);
		 * 
		 * }
		 */
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//isDisplayed() method returns boolean value either True or False
		Boolean Display = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Confirm Clinic Location:')]"))).isDisplayed();
		//To print the value
		System.out.println("Element displayed is :"+Display);


		SelectAnyClinicLocation.selectclinic();
		driver.navigate().refresh();

	}
	@Test(priority = 1 )
	public void TLMDRx_002() throws Exception {


		WebDriverWait wait = new WebDriverWait(driver, 10);

		//	Boolean Display = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Appointments - "))).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[contains(text(),'TIME')]"))).getText();
		String Display1 = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/h4[1]")).getText();
		System.out.println("Current Date :"+Display1);
		Boolean Display = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/h4[1]"))).isDisplayed();
		//To print the value
		System.out.println("Element displayed is :"+Display);

	}

	@Test(priority = 2)
	public void TLMDRx_003() throws Exception {

		EndtoEndFullRegressionPack.Verify_AllLeftNavigationMenuBarListArePresent();

	}
	
	@Test(priority = 3)
	public void TLMDRx_004() throws Exception {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_ColumnsNameInAppointmentPage();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
	}
	
	@Test(priority = 4)
	public void TLMDRx_006() {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_AddPatientPopupIsDisplayedAfterClickingAddPatientButton();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	
	
	@Test(priority = 5)
	public void TLMDRx_007() throws InterruptedException {
		
		
		try {
			rCreateRandomPatient rrr = new rCreateRandomPatient();
			rrr.CreateIt();
		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	
	
	
	@Test(priority = 6)
	public void TLMDRx_009() throws InterruptedException {
		
		
		try {
			rCreatedrandomPatientAppointment.CreateAappointment();

		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	
	@Test(priority = 7)
	public void TLMDRx_010() throws InterruptedException {
		
		
		try {
			rCreatedUpdatePatient.patientForUpdateTestcase();			

		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	
	
	

	@Test(priority = 8)
	public void TLMDRx_011() throws InterruptedException {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_StaffLabelIsDisplay();

		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	
	

	@Test(priority = 9)
	public void TLMDRx_012() throws InterruptedException {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_AddStaffButtonIsDisplay(); 

		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	
	
	/*
	 * @Test(priority = 9) public void TLMDRx_015() throws InterruptedException {
	 * 
	 * 
	 * try { EndtoEndFullRegressionPack.Verify_RegistrationStatusButton();
	 * driver.quit(); } catch (Exception e) {
	 * 
	 * 
	 * System.out.println(e.getMessage()); System.out.println(e.getCause());
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
	
	
	

	@Test(priority = 11)
	public void TLMDRx_017() throws InterruptedException {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_Calendar_Lable_Is_Displayed();

		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	
	
	
	@Test(priority = 10)
	public void TLMDRx_018() throws InterruptedException {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_GoogleSyncButtonDisplayedInCalendarPage();

		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	
	
	@Test(priority = 12)
	public void TLMDRx_020() throws InterruptedException {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_AllViewsInCalendarPage();

		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();

		}
		
		
	}
	@Test(priority = 13)
	public void TLMDRx_023() throws InterruptedException {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_WeekViewOnCalendar();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
	
	}
	
	

	@Test(priority = 14)
	public void TLMDRx_024() throws InterruptedException {
		
		
		try {
			EndtoEndFullRegressionPack.Verify_DayViewOnCalendar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
	
	}	
	

	
}