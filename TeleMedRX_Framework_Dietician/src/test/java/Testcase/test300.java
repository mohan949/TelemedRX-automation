package Testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SelectAnyClinicLocation;
import TestCasesV1.rCreatedrandomPatientAppointment;
import Testbase.Testbase;

public class test300 extends Testbase{




	@Test(priority = 0)
	public void TLMDRx_001() throws Throwable {

		//SelectAnyClinicLocation.selectclinic();
		//rCreatedrandomPatientAppointment.appointment();	
		//LoginPage jjj = new LoginPage();
		//jjj.Doctorloginform();
		LoginPage.Doctorloginform();

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10); boolean
		 * clinicSelectConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//div[contains(text(),'Confirm Clinic Location:')]\r\n" +
		 * ""))).isDisplayed(); if (clinicSelectConfirm==true) {
		 * Assert.assertTrue(true); System.out.println("TestCase_Pass"); } else {
		 * 
		 * captureScreen(driver,"SelectAnyClinicLocation");
		 * 
		 * Assert.assertTrue(false);
		 * 
		 * }
		 */
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//isDisplayed() method returns boolean value either True or False
		Boolean Display = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Confirm Clinic Location:')]"))).isDisplayed();
		//To print the value
		System.out.println("Element displayed is :"+Display);


		SelectAnyClinicLocation.selectclinic();
		driver.navigate().refresh();

	}
	@Test(priority = 1 )
	public void TLMDRx_002() throws Exception {


		WebDriverWait wait = new WebDriverWait(driver, 10);

		//	Boolean Display = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Appointments - "))).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[contains(text(),'TIME')]"))).getText();
		String Display1 = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/h4[1]")).getText();
		System.out.println("Current Date :"+Display1);
		Boolean Display = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/h4[1]"))).isDisplayed();
		//To print the value
		System.out.println("Element displayed is :"+Display);

	}

	@Test(priority = 2)
	public void TLMDRx_003() throws Exception {

		EndtoEndFullRegressionPack.Verify_AllLeftNavigationMenuBarListArePresent();
		driver.quit();

	}
}
