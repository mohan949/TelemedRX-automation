/**
 * 
 */
package PageObjects;

import org.testng.AssertJUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import Testbase.Testbase;

/**
 * @author mohan
 * a appointment is randomly created
 *with random first name of 8 alphabet
 */
public class rCreateRandomPatient extends Testbase {
	
	
	public  void CreateIt()  throws InterruptedException {
		
		

		driver.navigate().refresh();
		SoftAssert softassert;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/a[1]/span[1]")))
		.click();
		Thread.sleep(500);


		WebElement addpatient = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")));
		addpatient.click();

		Select title = new Select(driver.findElement(By.id("form_title")));
		title.selectByVisibleText("Mrs.");

		// patient names
			//vRandromFirstName = randomStringForm();
		//driver.findElement(By.id("form_firstname")).sendKeys(vRandromFirstName);
		
	//	 String Fname1 = Fname23();

		//driver.findElement(By.id("form_firstname")).sendKeys("Thisistest");
		
		
		
		vRandromFirstName = randomStringForm();
		driver.findElement(By.id("form_firstname")).sendKeys(vRandromFirstName);
		driver.findElement(By.id("form_middlename")).sendKeys(prop.getProperty("mname"));
		driver.findElement(By.id("form_lastname")).sendKeys(prop.getProperty("lname"));

		

		// gender
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();

		WebElement phoneno = driver.findElement(By.id("form_mobilenumber"));
		phoneno.sendKeys("9000000000");



		String Femail  = randomStringForm()+"@gmail.com";
		driver.findElement(By.id("form_email")).sendKeys(Femail);
		System.out.println("Entered new Unique Email : "+Femail);
		
		/**
		 * Incase randomgenreate fail use below to enter 
		 * https://www.youtube.com/watch?v=M4Ye3SKT46g&list=PLihSAgc3VAcO1Le200aM6a4-h8n9s5jY2&index=2
		 * 
		 * timestamp :- 3.40
		 */



		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();


		Thread.sleep(200);
		
		String toastactual = driver.findElement(By.cssSelector(prop.getProperty("Clienttoast"))).getText();
		System.out.println("Testcase has been:- " +toastactual);
		String toastexpected = "Client added successfully";
		softassert = new SoftAssert();

		AssertJUnit.assertEquals(toastactual, toastexpected);
		softassert.assertAll();

	
		Thread.sleep(1000);
		
		driver.navigate().refresh();




	
		
	}
	
	

	

}
