package mainRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class blog {
	
	@Test
	public void signup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\I2E_Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// launchwebsite
		driver.navigate().to("http://devportal.telemedrx.in/app/");

		// window size
		driver.manage().window().maximize();

		/*
		 * // click signup
		 * driver.findElement(By.xpath("//body/div[2]/div[1]/a[2]")).click();
		 * 
		 * // username
		 * //driver.findElement(By.xpath("//input[@id='user_username']")).sendKeys(
		 * "Mohan");
		 * 
		 * // password
		 * //driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(
		 * "Mohan123@");
		 * 
		 * // email
		 * //driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(
		 * "Mohan123@gmail.com");
		 * 
		 * // click sign up
		 * driver.findElement(By.className("btn btn-success btn-lg active")).click();
		 */
		
		driver.quit();

	}
	
	

}
