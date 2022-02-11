package Testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testbase.Testbase;

public class DemoApp extends Testbase {

	public void Add() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("OPD")))).click();
			WebElement textDemo = driver.findElement(By.xpath("//span[contains(text(),'03:00 PM')]"));

			if (textDemo.isDisplayed()) {
				System.out.println("Element found using text");
			}

			else {

				System.out.println("Element not found");
				driver.quit();
			}

			System.out.println("Check ....");

		} catch (Exception e) {

		}

	}
}
