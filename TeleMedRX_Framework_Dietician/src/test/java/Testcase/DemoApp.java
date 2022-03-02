package Testcase;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SelectAnyClinicLocation;
import TestCasesV1.rCreatedrandomPatientAppointment;
import TestCasesV1.testcaseSelectClinic;
import Testbase.Testbase;

public class DemoApp extends Testbase {
	@Test
	public static void Add() {

		try {
			String again = "Y";
			Boolean repeat = true;
			while(repeat) {

			WebDriverWait wait = new WebDriverWait(driver, 10);

			testcaseSelectClinic.Login();
			testcaseSelectClinic.Clinic();
			rCreatedrandomPatientAppointment.appointment();	
			rCreatedrandomPatientAppointment.CreateAappointment();
			
		
		
			String a = driver.findElement(By.xpath("//select[@id='form_category']")).getText();
			System.out.println(a);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]"))).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Sign Out!')]")).click();
			Thread.sleep(3000);
			Scanner sCANNER = new Scanner(System.in);
			String userinput = sCANNER.next();
			
			if(again.equals(userinput)) {
				System.out.println("Repeating Again");
				repeat = true;
			}
			else {
				System.out.println("Lol");
			}

			}
			System.out.println("Closing ther Driver");
			driver.quit();
			
			
		} catch (Exception e) {

		}

	}
}
