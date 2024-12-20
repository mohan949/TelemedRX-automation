package testCasesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SelectAnyClinicLocation;
import TestCasesV1.rCreatedrandomPatientAppointment;
import TestCasesV1.testcaseSCalendarModule;
import Testbase.Testbase;

public class TestCasesSprint10_2 extends Testbase {
	
	
	
	@Test(priority = -1)
	public static void intials() throws Exception {

			LoginPage.Doctorloginform();
			SelectAnyClinicLocation.selectclinic();
		

	}
	
	
	@Test(priority = 0)
	public static void TLMDRx_027() throws InterruptedException {
		
		
		try {
			rCreatedrandomPatientAppointment.appointment();	
			rCreatedrandomPatientAppointment.CreateAappointment();			
			testcaseSCalendarModule.calendarCheckCreatedAppointment();
			} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
	
	}

	
	
	@Test(priority = 1)
	public void TLMDRx_028() throws InterruptedException {
		
		
		try {
					
			testcaseSCalendarModule.calendarSlotsClick();

			} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
	
	}
	
	@Test(priority = 2)
	public void TLMDRx_029() throws InterruptedException {
		
		try {
					
			testcaseSCalendarModule.calendarSlotsClickExtra();

			} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
	}
	

	@Test(priority = 3)
	public void TLMDRx_030() throws InterruptedException {
		
		try {
					
			testcaseSCalendarModule.upateCalendarAppt();
			} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
	}
	
	
	
	public void TLMDRx_031() throws InterruptedException {
		
		try {
					
			testcaseSCalendarModule.calenarStartConsultation();

			} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
	}

	
	
	
	@Test(priority = 5)
	public void backtologinPage() {
		try {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]"))).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out!')]")).click();
		Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
	}
	
	
	

	
}
