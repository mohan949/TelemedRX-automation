package Testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Testbase.Testbase;

public class ContactUS extends Testbase {
	

	
	public void contactUS() {
	SoftAssert softassert;

	{
		// Step 1 run for loop for testdata sheet
		for (int i = 1; i <=1; i++) {
							
			// Step 2 Check if Execute column value is Y the only run rows data
			if (xlTD[i][1].equalsIgnoreCase("Y")) {
				vUsername = xlTD[i][2];
				vPassword = xlTD[i][3];
				try {
					driver.get(prop.getProperty("url"));
//					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//					driver.findElement(By.xpath(prop.getProperty("login_button1"))).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// Enter valid Username
					driver.findElement(By.xpath(prop.getProperty("Username"))).sendKeys(vUsername);
					// Enter valid Password
					driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(vPassword);
					// Click Submit button
					driver.findElement(By.xpath(prop.getProperty("Login_button"))).click();
					
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("ContactUs")))).click();
					System.out.println("Click Contact US ");
					Thread.sleep(10000);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Ok")))).click();
					Thread.sleep(10000);
					driver.findElement(By.xpath(prop.getProperty("lDropdown_arrow"))).click();
					System.out.println("Arrow Click");
					driver.findElement(By.xpath(prop.getProperty("Signout"))).click();
					// Assert.assertEquals(vActualDoctorName, vExcptedDoctorName);
					softassert = new SoftAssert();
//					softassert.assertEquals(vActualDoctorName, vExcptedDoctorName);
					// collect error details & destroy or release at last from memory
					softassert.assertAll();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}

			}
		}

	}
	
	}

