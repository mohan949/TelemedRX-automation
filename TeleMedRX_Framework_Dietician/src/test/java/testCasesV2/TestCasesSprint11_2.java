/**
 * 
 */
package testCasesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Testbase.Testbase;

/**
 * @author mohan.prasad
 *
 */
public class TestCasesSprint11_2 extends Testbase {
	SoftAssert softassert;

	@Test(priority = 1)
	public void TLMDRx_059() throws Exception {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
		
	
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

			
			//driver.switchTo().window(tabs.get(1)); 
			driver.navigate().to("http://devportal.telemedrx.in/");
			String URL = driver.getCurrentUrl();
			System.out.println("Url Launched is for  11_2 :"+URL);

			//verify color of a web element -----> google colorpicker
			WebElement t = driver.findElement(By.xpath("//body/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/span[2]"));
			String s = t.getCssValue("background-color");
			
			
		//	String s = t.getCssValue("color");
			
			String c = Color.fromString(s).asHex();
			System.out.println("Color is :" + s);
			System.out.println("Hex code for color:" + c);
			String expectedButtonColor = "#154fac";
			String actualButtonColor = c;
			Assert.assertEquals(actualButtonColor, expectedButtonColor);

			
			String registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//body/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/span[2]")))).getText();
			System.out.println(registerButton);
			String resgiEXp = "";
			softassert = new SoftAssert();		

			//if(registerButton==resgiEXp)
			if(registerButton.equalsIgnoreCase(resgiEXp))
			{
				System.out.println("pass"); 

			}
			else 
			{
				System.out.println("Testcase  register has been fail ") ;


				System.out.println("Screenshot is captured");
				getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
						+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

			}

			softassert = new SoftAssert();
			softassert.assertEquals(registerButton, resgiEXp);
			softassert.assertAll();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	
	
	@Test(priority = 2)
	public void TLMDRx_060() {
		
		try {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[contains(text(),'Register for free')]")))).click();
		
	
		
		Boolean label3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'CONTINUE')]"))).isDisplayed();
		System.out.println("Register label is :"+label3);
		
		Boolean label = driver.findElement(By.xpath("//label[contains(text(),'Register')]")).isDisplayed();
		System.out.println("Register label is :"+label);
		
		Boolean label2 = driver.findElement(By.xpath("//input[@id='mobile_no']")).isDisplayed();
		System.out.println("Register label is :"+label2);
		
		TestCasesSprint11.clickforgetback();


		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 


	}

	
	@Test(priority = 3)
	public void TLMDRx_067() {
		
		try {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement t =	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//header/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[6]/a[1]"))));
		t.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Register')]"))).click();
		Boolean label3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'CONTINUE')]"))).isDisplayed();
		System.out.println("Register label is :"+label3);
		
		Boolean label = driver.findElement(By.xpath("//label[contains(text(),'Register')]")).isDisplayed();
		System.out.println("Register label is :"+label);
		
		Boolean label2 = driver.findElement(By.xpath("//input[@id='mobile_no']")).isDisplayed();
		System.out.println("Register label is :"+label2);
		

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 


	}
	
	@Test(priority = 4)
	public void TLMDRx_069() {
		SoftAssert softassert;
		try {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement t =	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[@id='mobile_no']"))));
		t.click();
		t.sendKeys("9000000000000");
		driver.findElement(By.xpath("//div[contains(text(),'CONTINUE')]")).click();
		
		
		String TestExistActual = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Contact number must be 10 digit')]"))).getText();
		
		
		
		System.out.println("Asserted :-" +TestExistActual );
		String TestExistexp = "Contact number must be 10 digit";

		softassert = new SoftAssert();		

		if (TestExistActual.equalsIgnoreCase(TestExistexp)) {
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
		softassert.assertEquals(TestExistActual, TestExistexp);
		softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority = 4)

	public void TLMDRx_071() {
		
		Boolean f = driver.findElement(By.xpath("//span[@id='prepend_mobile']")).isDisplayed();
		System.out.println("+91 is Displayed"+f);
		
		
	}
	
	@Test(priority = 5)
	public void TLMDRx_070() {
		SoftAssert softassert;
		try {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement t =	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[@id='mobile_no']"))));
		t.click();
		t.clear();
		String M = "000"+randomPhoneNumberGenerator();
		t.sendKeys(M);

		driver.findElement(By.xpath("//div[contains(text(),'CONTINUE')]")).click();
		
		
		String TestExistActual23 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'NEXT')]"))).getText();
		
		System.out.println(TestExistActual23);
		
		System.out.println("Asserted :-" +TestExistActual23 );
		String TestExistexp23 = "NEX";

		softassert = new SoftAssert();		

		if (TestExistActual23.equalsIgnoreCase(TestExistexp23)) {
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
		softassert.assertEquals(TestExistActual23, TestExistexp23);
		softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
