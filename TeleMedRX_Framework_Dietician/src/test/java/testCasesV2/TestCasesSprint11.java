/**
 * 
 */
package testCasesV2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Testbase.Testbase;

/**
 * @author mohan.prasad
 *
 */
public class TestCasesSprint11 extends Testbase {
	SoftAssert softassert;

	@Test(priority = 0)
	public static void launchIntroPage() {
		try {
			SoftAssert softassert;
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

			driver.navigate().to("http://devportal.telemedrx.in/");
			String URL = driver.getCurrentUrl();

			softassert = new SoftAssert();
			softassert.assertEquals(URL, "http://devportal.telemedrx.in/" );
			System.out.println("Url Launched is :"+URL);
			softassert.assertAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();


		}

	}


	@Test(priority = 1)	
	public static void TLMDRx_049() {

		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 30);

	WebElement t =	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//header/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[6]/a[1]"))));
		String s = t.getCssValue("background-color");
		String c = Color.fromString(s).asHex();
		System.out.println("Color is :" + s);
		System.out.println("Hex code for color:" + c);	
	
		t.click();
		
		
		Boolean username = driver.findElement(By.xpath(prop.getProperty("Username"))).isEnabled();
		System.out.println(username);
		Boolean password = driver.findElement(By.xpath(prop.getProperty("Password"))).isEnabled();
		System.out.println(password);
		Boolean Login = driver.findElement(By.xpath(prop.getProperty("Login_button"))).isEnabled();
		System.out.println(Login);
	}

	@Test(priority = 2)	

	public void TLMDRx_050() {
		WebElement forgetuser =	driver.findElement(By.xpath(prop.getProperty("Forgot_Username")));
		String forgetstring = forgetuser.getText();
		System.out.println(forgetstring);
		Boolean forgetBoolean = forgetuser.isDisplayed();
		System.out.println(forgetBoolean);


	}

	@Test(priority = 3)	

	public void TLMDRx_051() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			driver.findElement(By.xpath(prop.getProperty("Forgot_Username"))).click();

			String forgetlabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[contains(text(),'Forgot Username')]")))).getText();

			//String forgetlabel = driver.findElement(By.xpath("//label[contains(text(),'Forgot Username')]")).getText();
			String forgetlabelexp = "Forgot Username";
			softassert = new SoftAssert();		

			if (forgetlabel.equalsIgnoreCase(forgetlabelexp)) {
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
			softassert.assertEquals(forgetlabel, forgetlabelexp);
			softassert.assertAll();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}

	@Test(priority = 4)
	public void TLMDRx_052() {
		try {

			Boolean forgetMobile =	driver.findElement(By.xpath("//input[@id='mobile_no']")).isEnabled();
			System.out.println("Forget Username mobile is :"+forgetMobile);



			Boolean forgetcont =	driver.findElement(By.xpath("//div[contains(text(),'CONTINUE')]")).isEnabled();
			System.out.println("Forget Username continue button is :"+forgetcont);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}



	@Test(priority = 5)
	public static void clickforgetback() {
		try {
			driver.navigate().refresh();
			driver.navigate().back();
			driver.navigate().refresh();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6)	

	public void TLMDRx_053() {
		try {

			WebElement forgetpass =	driver.findElement(By.xpath(prop.getProperty("Forgot_Password")));
			String forgetstringP = forgetpass.getText();
			System.out.println(forgetstringP);
			Boolean forgetBooleanP = forgetpass.isDisplayed();
			System.out.println(forgetBooleanP);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}



	@Test(priority = 7)	

	public void TLMDRx_054() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			driver.findElement(By.xpath(prop.getProperty("Forgot_Password"))).click();

			String forgetPlabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[contains(text(),'Forgot Password')]")))).getText();

			String forgetPlabelexp = "Forgot Password";
			softassert = new SoftAssert();		

			if (forgetPlabel.equalsIgnoreCase(forgetPlabelexp)) {
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
			softassert.assertEquals(forgetPlabel, forgetPlabelexp);
			softassert.assertAll();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}



	@Test(priority = 8)
	public void TLMDRx_055() {
		try {

			Boolean forgetMobile =	driver.findElement(By.xpath("//input[@id='mobile_no']")).isEnabled();
			System.out.println("Forget Password mobile Number is :"+forgetMobile);



			Boolean forgetcont =	driver.findElement(By.xpath("//div[contains(text(),'CONTINUE')]")).isEnabled();
			System.out.println("Forget Password continue button is :"+forgetcont);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		clickforgetback();

	}


	@Test(priority = 8)
	public void TLMDRx_056() {
		try {

			Boolean LoginPrivacy =	driver.findElement(By.xpath("//div[contains(text(),'Privacy Policy')]")).isDisplayed();
			System.out.println("login Privacy Policy :"+LoginPrivacy);





		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}

	@Test(priority = 9)
	public void TLMDRx_057() throws InterruptedException {
		try {

			driver.findElement(By.xpath("//div[contains(text(),'Privacy Policy')]")).click();

			System.out.println(driver.getTitle());
			Set <String> beforePopup= driver.getWindowHandles();


			for(String i:beforePopup)
			{
				String t = driver.switchTo().window(i).getCurrentUrl();
				System.out.println(t);


				if(driver.getCurrentUrl()=="http://devportal.telemedrx.in/app/PrivacyPolicy");
				{
					System.out.println(driver.getCurrentUrl());
					System.out.println("Privacy tab is open sucessfully");
				}

			}


			//	driver.findElement(By.xpath("//p[contains(text(),'Privacy and Terms of Use')]")).sendKeys(Keys.CONTROL + "w");
			//	driver.navigate().back();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}
	
}


