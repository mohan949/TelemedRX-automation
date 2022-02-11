/**
 * 
 */
package TestCasesV1;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SelectAnyClinicLocation;
import Testbase.Testbase;

/**
 * @author mohan
 *
 */
public class testcaseSelectClinic extends Testbase {


	@Test(priority = 0)

	public static void Login() {


		try {


			//LoginPage rCreatedPateintCalendarCheck = new LoginPage();

			//rCreatedPateintCalendarCheck.Doctorloginform();

			LoginPage.Doctorloginform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}

	}
	
	
	
	@Test(priority = 1)

	public static void Clinic() {
		
		
		try {


			SelectAnyClinicLocation.selectclinic();
			} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());			
			e.printStackTrace();
		}
			
		
	}
	
}



