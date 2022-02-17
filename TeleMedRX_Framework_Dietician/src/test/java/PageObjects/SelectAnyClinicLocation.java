/**
 * 
 */
package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
		// Select(driver.findElement(By.xpath("//select[@id='']")));
		// drpClinic.selectByVisibleText("Trivandrum-Health clinic");

		try {

			Select drpClinic = new Select(driver.findElement(By.tagName("select")));
		 	drpClinic.selectByIndex(1);
		 	//System.out.println(drpClinic.getOptions().size());
		 	
		 	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

		// Thread.sleep(1000);
		// driver.findElement(By.xpath("//span[contains(text(),'OPEN')]")).click();

		

	
		
		
		//driver.quit();
	}

	
	
}
