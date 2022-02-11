package testCasesV2;

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
		//rCreatedrandomPatientAppointment.appointment();	
		//	rCreatedrandomPatientAppointment.CreateAappointment();

	}
	
	
	@Test(priority = 0)
	public void TLMDRx_027() throws InterruptedException {
		
		
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
			driver.quit();
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
}
