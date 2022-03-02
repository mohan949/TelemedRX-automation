/**
 * 
 */
package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.Testbase;

/**
 * @author mohan
 * This code is to select the clinic randomly
 *
 */
public class SelectAnyClinicLocation extends Testbase {

	@Test
	public static void selectclinic() throws InterruptedException, IOException {
		Thread.sleep(1000);
		

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement ClinicDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("select")));
			Select drpClinic = new Select(ClinicDropDown);
			
			
			List<WebElement> c = drpClinic.getAllSelectedOptions();
				
			int totalClinic = c.size();
			System.out.println("Number of  clinic Present are : "+totalClinic);
			
			for(WebElement d:c) {
				
				String p = d.getText();
				System.out.println("new"+p);
				
			}
			
			if(driver.findElements(By.xpath("//div[contains(text(),'Confirm Clinic Location:')]")).size() > 0) {
				
				drpClinic.selectByIndex(1);
			    
			    
			} else 
			{
			    System.out.println("Default Clinic Selected");
			}
			
		 	
		 	
		 	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	
	}

	
	
}
