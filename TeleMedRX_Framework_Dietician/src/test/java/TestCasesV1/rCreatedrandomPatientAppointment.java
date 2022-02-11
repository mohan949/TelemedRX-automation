package TestCasesV1;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.rCreateAppointment;
import PageObjects.rCreateRandomPatient;
import Testcase.EndtoEndFullRegressionPack;

public class rCreatedrandomPatientAppointment {


	@Test(priority = 3)

	public static void appointment()  {
		try {


			rCreateRandomPatient rrr = new rCreateRandomPatient();
			rrr.CreateIt();

			//rCreateAppointment.CreateIt();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();			}



	}


	@Test(priority = 4)
	public static void CreateAappointment() {

		try {


			rCreateAppointment creatapp = new 	rCreateAppointment();
			creatapp.raddAppointment();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());	
			e.printStackTrace();
		}

	}




	/*
	 * @Test(priority = 5) public void verify() {
	 * 
	 * 
	 * try {
	 * 
	 * EndtoEndFullRegressionPack.Verify_AllLeftNavigationMenuBarListArePresent();
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage());
	 * System.out.println(e.getCause()); e.printStackTrace(); }
	 * 
	 * }
	 */

}


