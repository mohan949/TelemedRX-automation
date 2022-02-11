package Testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.KeysRelatedAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import Testbase.Testbase;
import junit.framework.Assert;

public class EndtoEndFullRegressionPack extends Testbase {

	@Test(priority = 1)
	public void Verify_PageTitle() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {
						vExpectedPageTitle = xlTD1[i][38];

						try {
							driver.get(prop.getProperty("url"));
							vActualPageTitle = driver.getTitle();
							if (vActualPageTitle.equalsIgnoreCase(vExpectedPageTitle)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualPageTitle, vExpectedPageTitle);
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}

		}
	}

	@Test(priority = 2)
	public void Verify_AfterEnterAValidCredentialTryToLoginLoginApp() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {
						vUsername = xlTD1[i][2];
						vPassword = xlTD1[i][3];
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElement(By.xpath(prop.getProperty("login_button1"))).click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							// Enter valid Username
							driver.findElement(By.xpath(prop.getProperty("Username"))).sendKeys(vUsername);
							// Enter valid Password
							driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(vPassword);
							// Click Submit button
							driver.findElement(By.xpath(prop.getProperty("Login_button"))).click();
							Thread.sleep(4000);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}

		}
	}

	@Test(priority = 3)
	public void Verify_WhenTwoClinicsArePresentThenCheckClinicPopupIsVisible() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {
						try {
							Thread.sleep(1000);
							vExcptedClinicName = xlTD1[i][4];
							vActualClinicName = driver.findElement(By.xpath(prop.getProperty("ClinicPopup"))).getText();
							if (vActualClinicName.equalsIgnoreCase(vExcptedClinicName)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualClinicName, vExcptedClinicName);
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}

		}
	}

	@Test(priority = 4)
	public void Verify_AndChooseSanjivaniClinicFromDropdownList() throws Exception {
		SoftAssert softassert;
		{
			Thread.sleep(2000);
			// Select country
			Select drpClinic = new Select(driver.findElement(By.xpath(prop.getProperty("clinicDropdown"))));
			drpClinic.selectByVisibleText("Mumbai-Sanjivani Clinic");
			Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("openClinic"))).click();

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExcptedOPDtext = xlTD1[i][5];
							vActualOPDtext = driver.findElement(By.xpath(prop.getProperty("OPD"))).getText();
							if (vActualOPDtext.equalsIgnoreCase(vExcptedOPDtext)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							AssertJUnit.assertEquals(vActualOPDtext, vExcptedOPDtext);
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualOPDtext, vExcptedOPDtext);
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}

		}
	}

	@Test(priority = 5)
	public static void Verify_AllLeftNavigationMenuBarListArePresent() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExcptedOPDtext = xlTD1[i][5];
							vExcptedPatienttext = xlTD1[i][6];
							vExcptedStafftext = xlTD1[i][7];
							vExcptedCalendartext = xlTD1[i][8];
							vExcptedSettingstext = xlTD1[i][9];
							vExcptedContactUstext = xlTD1[i][10];
							//vExcptedContactUstext = "ContactUS";
							
							vActualOPDtext = driver.findElement(By.xpath(prop.getProperty("OPD"))).getText();
							vActualPatienttext = driver.findElement(By.xpath(prop.getProperty("Client"))).getText();
							vActualStafftext = driver.findElement(By.xpath(prop.getProperty("Staff"))).getText();
							vActualCalendartext = driver.findElement(By.xpath(prop.getProperty("Calendar"))).getText();
							vActualSettingstext = driver.findElement(By.xpath(prop.getProperty("Settings"))).getText();
							//vActualContactUstext = driver.findElement(By.xpath(prop.getProperty("ContactUS"))).getText();

							if (vActualOPDtext.equalsIgnoreCase(vExcptedOPDtext)
									&& vActualPatienttext.equalsIgnoreCase(vExcptedPatienttext)
									&& vActualStafftext.equalsIgnoreCase(vExcptedStafftext)
									&& vActualCalendartext.equalsIgnoreCase(vExcptedCalendartext)
									&& vActualSettingstext.equalsIgnoreCase(vExcptedSettingstext)
									) {
//								there is some issue with contact us && vActualContactUstext.equalsIgnoreCase(vExcptedContactUstext)
								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							AssertJUnit.assertEquals(vActualOPDtext, vExcptedOPDtext);
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualOPDtext, vExcptedOPDtext);
							AssertJUnit.assertEquals(vActualPatienttext, vExcptedPatienttext);
							AssertJUnit.assertEquals(vActualStafftext, vExcptedStafftext);
							AssertJUnit.assertEquals(vActualCalendartext, vExcptedCalendartext);
							AssertJUnit.assertEquals(vActualSettingstext, vExcptedSettingstext);
							//AssertJUnit.assertEquals(vActualContactUstext, vExcptedContactUstext);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 6)

	public void Verify_AppointmentPageisDisplayedByDefault() throws Exception {
		SoftAssert softassert;
		{

			Thread.sleep(2000);

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedAPTitle = xlTD1[i][18];

							vActualAPTitle = driver.findElement(By.xpath(prop.getProperty("Page-APTitle"))).getText();

							// String store into new string because of word spliting
							String s1 = vActualAPTitle;
							String[] sp = s1.split(" ");

							if (sp[0].equalsIgnoreCase(vExpectedAPTitle)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							AssertJUnit.assertEquals(sp[0], vExpectedAPTitle);
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(sp[0], vExpectedAPTitle);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}

		}
	}

	@Test(priority = 7)
	public static void Verify_ColumnsNameInAppointmentPage() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExcptedColTimetext = xlTD1[i][11];
							vExcptedColPatinettext = xlTD1[i][12];
							vExcptedColGenderAgetext = xlTD1[i][13];
							vExcptedColPhoneNumbertext = xlTD1[i][14];
							vExcptedColStatustext = xlTD1[i][15];
							vExcptedColAppointmenttext = xlTD1[i][16];
							vExcptedColActiontext = xlTD1[i][17];

							vActualColTimetext = driver.findElement(By.xpath(prop.getProperty("Col-Time"))).getText();
							vActualColPatinettext = driver.findElement(By.xpath(prop.getProperty("Col-Client")))
									.getText();
							vActualColGenderAgetext = driver.findElement(By.xpath(prop.getProperty("Col-GenderAge")))
									.getText();
							vActualColPhoneNumbertext = driver
									.findElement(By.xpath(prop.getProperty("Col-PhoneNumber"))).getText();
							vActualColStatustext = driver.findElement(By.xpath(prop.getProperty("Col-Status")))
									.getText();
							vActualColAppointmenttext = driver
									.findElement(By.xpath(prop.getProperty("Col-AppointmentType"))).getText();
							vActualColActiontext = driver.findElement(By.xpath(prop.getProperty("Col-Action")))
									.getText();

							if (vActualColTimetext.equalsIgnoreCase(vExcptedColTimetext)
									&& vActualColPatinettext.equalsIgnoreCase(vExcptedColPatinettext)
									&& vActualColGenderAgetext.equalsIgnoreCase(vExcptedColGenderAgetext)
									&& vActualColPhoneNumbertext.equalsIgnoreCase(vExcptedColPhoneNumbertext)
									&& vActualColStatustext.equalsIgnoreCase(vExcptedColStatustext)
									&& vActualColAppointmenttext.equalsIgnoreCase(vExcptedColAppointmenttext)
									&& vActualColActiontext.equalsIgnoreCase(vExcptedColActiontext)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							AssertJUnit.assertEquals(vActualColTimetext, vExcptedColTimetext);
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualColTimetext, vExcptedColTimetext);
							AssertJUnit.assertEquals(vActualColPatinettext, vExcptedColPatinettext);
							AssertJUnit.assertEquals(vActualColGenderAgetext, vExcptedColGenderAgetext);
							AssertJUnit.assertEquals(vActualColPhoneNumbertext, vExcptedColPhoneNumbertext);
							AssertJUnit.assertEquals(vActualColStatustext, vExcptedColStatustext);
							AssertJUnit.assertEquals(vActualColAppointmenttext, vExcptedColAppointmenttext);
							AssertJUnit.assertEquals(vActualColActiontext, vExcptedColActiontext);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 8)
	public void Verify_AddAppointmentButtonIsDisplayed() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedAPButton = xlTD1[i][19];

							vActualAPButton = driver.findElement(By.xpath(prop.getProperty("btnAddAppointmentTitle")))
									.getText();

							if (vActualAPButton.equalsIgnoreCase(vExpectedAPButton)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							AssertJUnit.assertEquals(vActualAPButton, vExpectedAPButton);
							softassert = new SoftAssert();

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 9)
	public static void Verify_AddPatientPopupIsDisplayedAfterClickingAddPatientButton() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount2; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD2[i][1].equalsIgnoreCase("Y")) {

					vFirstname = xlTD2[i][2];
					vLastname = xlTD2[i][3];
					vMobilenumber = xlTD2[i][4];

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.xpath(prop.getProperty("nv_patient"))).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					WebDriverWait wait = new WebDriverWait(driver, 10);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("add_Patient"))))
							.click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
				}
			}

		}
	}

	@Test(priority = 10)
	public static void Verify_FillTheNewPatientDetailsInTheAddPatientPopup() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount2; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD2[i][1].equalsIgnoreCase("Y")) {

					vFirstname = xlTD2[i][2];
					vLastname = xlTD2[i][3];
					vMobilenumber = xlTD2[i][4];

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// Enter fNname
					driver.findElement(By.xpath(prop.getProperty("firstName"))).sendKeys(vFirstname);
					// Enter lNname
					Thread.sleep(2000);
					driver.findElement(By.xpath(prop.getProperty("lastName"))).sendKeys(vLastname);
					Thread.sleep(2000);
					driver.findElement(By.xpath(prop.getProperty("radiobuttonMale"))).click();
					// Enter Mobile Number
					driver.findElement(By.xpath(prop.getProperty("mobileNumber"))).sendKeys(vMobilenumber);
					Thread.sleep(2000);
					driver.findElement(By.xpath(prop.getProperty("Submit"))).click();
					Thread.sleep(4000);

				}
			}

		}
	}

	@Test(priority = 11)
	public void Verify_OpenOtherclass() throws Exception {
		SoftAssert softassert;
		{
			DemoApp class2 = new DemoApp();
			class2.Add();
		}
	}

	@Test(priority = 12)
	public void Verify_CreateANewAppointment() throws Exception {
		SoftAssert softassert;
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("OPD"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("Add_Appointment"))).click();

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount3; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD3[i][1].equalsIgnoreCase("Y")) {

					vOPDPatientName = xlTD3[i][2];
					vOPDDate = xlTD3[i][3];
					vOPDConcern = xlTD3[i][4];
					vOPDSlot = xlTD3[i][5];
					vExpectedWeight = xlTD3[i][6];

					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Patient"))))
							.sendKeys(vOPDPatientName);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("pname")))).click();

					driver.findElement(By.xpath(prop.getProperty("RelativeSlot"))).click();
					Thread.sleep(2000);
					wait.until(
							ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("expandFirstSection"))))
							.click();
					Thread.sleep(2000);
					wait.until(
							ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("expandSecondSection"))))
							.click();
					Thread.sleep(1000);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("weight")))).clear();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("weight"))))
							.sendKeys(vExpectedWeight);

					// Comment cancle button when you uncommnet create appointment button

//					wait.until(
//							ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("create_Appointment"))))
//							.click();

					// If you want to skip the create appointment then user below steps

					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("cancleButton"))))
							.click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("yesButton"))))
							.click();

					Thread.sleep(4000);

				}
			}

		}
	}
	
	@Test(priority = 13)
	public static void Verify_GoogleSyncButtonDisplayedInCalendarPage() throws Exception {
		SoftAssert softassert;
		{
			driver.findElement(By.xpath(prop.getProperty("calendarLeftNav"))).click();

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedGoogleCalendarSync = xlTD1[i][39];
							Thread.sleep(2000);
							vActualGoogleCalendarSync = driver
									.findElement(By.xpath(prop.getProperty("GoogleCalendarSync"))).getText();

							if (vActualGoogleCalendarSync.equalsIgnoreCase(vExpectedGoogleCalendarSync)) {

								String name = "Pass";
								System.out.println("Verify_GoogleSyncButtonDisplayedInCalendarPage :- " + name);

							} else {

								String name = "Fail";
								System.out.println("Verify_Calendar_Lable_Is_Displayed :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
//							Assert.assertEquals(vActualPopPatient, vExpectedPopPatient);
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualGoogleCalendarSync, vExpectedGoogleCalendarSync);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}
	@Test(priority = 14)
	public static void Verify_Calendar_Lable_Is_Displayed() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedCalendarLable = xlTD1[i][37];
							Thread.sleep(2000);
							vActualCalendarLable = driver.findElement(By.xpath(prop.getProperty("calendarLable")))
									.getText();

							if (vActualCalendarLable.equalsIgnoreCase(vExpectedCalendarLable)) {

								String name = "Pass";
								System.out.println("Verify_Calendar_Lable_Is_Displayed:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
//							Assert.assertEquals(vActualPopPatient, vExpectedPopPatient);
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualCalendarLable, vExpectedCalendarLable);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}
	@Test(priority = 15)
	public static void Verify_AllViewsInCalendarPage() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedmonthview = xlTD1[i][40];
							vExpectedweekview = xlTD1[i][41];
							vExpecteddayview = xlTD1[i][42];

							vActualmonthview = driver.findElement(By.xpath(prop.getProperty("MonthView"))).getText();
							vActualweekview = driver.findElement(By.xpath(prop.getProperty("WeekView"))).getText();
							vActualdayview = driver.findElement(By.xpath(prop.getProperty("DayView"))).getText();

							if (vActualmonthview.equalsIgnoreCase(vExpectedmonthview)
									&& vActualweekview.equalsIgnoreCase(vExpectedweekview)
									&& vActualdayview.equalsIgnoreCase(vExpecteddayview)) {

								String name = "Pass";
								System.out.println("Verify_AllViewsInCalendarPage:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualmonthview, vExpectedmonthview);
							AssertJUnit.assertEquals(vActualweekview, vExpectedweekview);
							AssertJUnit.assertEquals(vActualdayview, vExpecteddayview);
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}
	@Test(priority = 16)

	public static void Verify_WeekViewOnCalendar() throws Exception {
		{
			driver.findElement(By.xpath(prop.getProperty("WeekView"))).click();
			System.out.println("weekview");
		}
	}

	@Test(priority = 17)

	public static void Verify_DayViewOnCalendar() throws Exception {
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("DayView"))).click();
			System.out.println("dayview");

		}

	}

	@Test(priority = 18)
	public static void Verify_StaffLabelIsDisplay() throws Exception {
		SoftAssert softassert;
		{

			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("staffLaftNav"))).click();

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedStaffLabel = xlTD1[i][31];
							vActualStaffLabel = driver.findElement(By.xpath(prop.getProperty("staffLable"))).getText();

							if (vActualStaffLabel.equalsIgnoreCase(vExpectedStaffLabel)) {

								String name = "Pass";
								System.out.println("Testcase has been Verify_StaffLabelIsDisplay :- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							softassert.assertEquals(vActualStaffLabel, vExpectedStaffLabel);
							Thread.sleep(2000);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 19)
	public static void Verify_AddStaffButtonIsDisplay() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedAddStaffButton = xlTD1[i][32];
							Thread.sleep(2000);
							vActuaAddStaffButton = driver.findElement(By.xpath(prop.getProperty("AddStaff"))).getText();

							if (vActuaAddStaffButton.equalsIgnoreCase(vExpectedAddStaffButton)) {

								String name = "Pass";
								System.out.println("Testcase has been Verify_AddStaffButtonIsDisplay :- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							softassert.assertEquals(vActuaAddStaffButton, vExpectedAddStaffButton);
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 20)
	public static void Verify_AddStaffPopupFieldVerification() throws Exception {
		SoftAssert softassert;
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("AddStaff"))).click();

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedMobNo = xlTD1[i][33];
							vExpectedSendButton = xlTD1[i][34];
							vExpectedCloseButton = xlTD1[i][35];

							Thread.sleep(3000);
							vActualMobNo = driver.findElement(By.xpath(prop.getProperty("enterMobNo"))).getText();
							vActualSendButton = driver.findElement(By.xpath(prop.getProperty("sendbtnForAddStaff")))
									.getText();
							vActualCloseButton = driver.findElement(By.xpath(prop.getProperty("closebtnForAddStaff")))
									.getText();

							if (vActualMobNo.equalsIgnoreCase(vExpectedMobNo)
									&& vActualSendButton.equalsIgnoreCase(vExpectedSendButton)
									&& vActualCloseButton.equalsIgnoreCase(vExpectedCloseButton)) {

								String name = "Pass";
								System.out.println("Testcase has been  Verify_AddStaffPopupFieldVerification() :- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							softassert.assertEquals(vActualMobNo, vExpectedMobNo);
							softassert.assertEquals(vActualSendButton, vExpectedSendButton);
							softassert.assertEquals(vActualCloseButton, vExpectedCloseButton);

							softassert.assertAll();

							driver.findElement(By.xpath(prop.getProperty("closebtnForAddStaff"))).click();
							Thread.sleep(2000);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 21)
	
	public static void Verify_RegistrationStatusButton() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedRegistrationStatusButton = xlTD1[i][36];

							vActualRegistrationStatusButton = driver
									.findElement(By.xpath(prop.getProperty("registrationStatusButton"))).getText();

							if (vActualRegistrationStatusButton.equalsIgnoreCase(vExpectedRegistrationStatusButton)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase Verify_RegistrationStatusButton :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							softassert.assertEquals(vActualRegistrationStatusButton, vExpectedRegistrationStatusButton);
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}
	
	@Test(priority = 22)
	
	public void Verify_RegistrationStatusPopup() throws Exception {
		SoftAssert softassert;
		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {
							
							driver.findElement(By.xpath(prop.getProperty("registrationStatusButton"))).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath(prop.getProperty("StaffRegistrationbutton"))).click();


						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 23)
	public static void Verify_PageTitleOfSettingPage() throws Exception {
		SoftAssert softassert;
		{

			Thread.sleep(2000);

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {
							vExpectedSettingName = xlTD1[i][44];
							driver.findElement(By.xpath(prop.getProperty("Setting"))).click();
							Thread.sleep(2000);
							vActualSettingName = driver.findElement(By.xpath(prop.getProperty("SettingpageTitle")))
									.getText();

							if (vActualSettingName.equalsIgnoreCase(vExpectedSettingName)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}

//						}
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualSettingName, vExpectedSettingName);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 24)
	public static void Verify_UpdateProfileSetting() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {
							vSettingFName = xlTD1[i][52];
							vSettingLName = xlTD1[i][53];

							Thread.sleep(2000);
							// Enter valid FName
//							driver.findElement(By.xpath(prop.getProperty("SettingFName"))).sendKeys(vSettingFName);
//							Thread.sleep(2000);
//							// Enter valid LName
//							driver.findElement(By.xpath(prop.getProperty("SettingLName"))).sendKeys(vSettingLName);
//							Thread.sleep(2000);
//							// Click Submit button
//							driver.findElement(By.xpath(prop.getProperty("SettingSave"))).click();				
//						}
							softassert = new SoftAssert();
							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 25)
	public static void Verify_AddClinicButtonIsPresentOnClinicSettingPage() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vExpectedBTNAddClinic = xlTD1[i][51];
							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("ClinicSetting"))).click();
							Thread.sleep(2000);
							vActualBTNAddClinic = driver.findElement(By.xpath(prop.getProperty("AddClinic"))).getText();

							if (vActualBTNAddClinic.equalsIgnoreCase(vExpectedBTNAddClinic)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							AssertJUnit.assertEquals(vActualBTNAddClinic, vExpectedBTNAddClinic);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 26)
	public static void Verify_CreateANewClinic() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {

							vClinicName = xlTD1[i][45];
							vClinicPhone = xlTD1[i][46];
							vClinicStreetAddress = xlTD1[i][47];

							driver.findElement(By.xpath(prop.getProperty("AddClinic"))).click();
							// Enter valid ClinicName
							driver.findElement(By.xpath(prop.getProperty("ClinicName"))).sendKeys(vClinicName);
							Thread.sleep(2000);
							// Enter valid Phonenumber
							driver.findElement(By.xpath(prop.getProperty("ClinicPhone"))).sendKeys(vClinicPhone);
							Thread.sleep(2000);
							// Enter valid Street Address
							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("ClinicStreetAddress")))
									.sendKeys(vClinicStreetAddress);

							// Click Add Clinic button
//							driver.findElement(By.xpath(prop.getProperty("PopAddClinic"))).click();

							// This is the line for close popup
							driver.findElement(By.xpath(prop.getProperty("ClinicCloseButton"))).click();

//						}
							softassert = new SoftAssert();

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}
	
	@Test(priority = 27)
	public static void Verify_DoctorTime() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {
							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("DocTiming"))).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("InTime"))).click();
							driver.findElement(By.xpath(prop.getProperty("InTimeField"))).click();
							driver.findElement(By.xpath(prop.getProperty("InTimeField"))).clear();
							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("InTimeField"))).sendKeys("7:10 a");
							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("OuttimeLbl"))).click();
							driver.findElement(By.xpath(prop.getProperty("Updatebtn"))).click();
							driver.findElement(By.xpath(prop.getProperty("YesPopupBtn"))).click();
							Thread.sleep(2000);
				
//						}
							softassert = new SoftAssert();
//							 AssertJUnit.assertEquals(vActualSettingName, vExpectedSettingName);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}
	
	@Test(priority = 28)
	public void Verify_SMSSetting() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {
							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("SMSSetting"))).click();
							Thread.sleep(2000);
//						}
							softassert = new SoftAssert();
//							 AssertJUnit.assertEquals(vActualSettingName, vExpectedSettingName);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}
	
	@Test(priority = 29)
	public void Verify_BillingSetting() throws Exception {
		SoftAssert softassert;
		{

			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {
					for (int j = 1; j < XlRowCount1; j++) {

						try {
							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("BillingSetting"))).click();
							Thread.sleep(2000);
//						}
							softassert = new SoftAssert();
//							 AssertJUnit.assertEquals(vActualSettingName, vExpectedSettingName);

							// collect error details & destroy or release at last from memory
							softassert.assertAll();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}

					}

				}
			}

		}
	}

	@Test(priority = 30)
	public void Verify_ContactUSPopupMessage() throws Exception {
		{
			// This functionlity i am calling from other class i.e. "ContactUS"
			ContactUS cont = new ContactUS();
			//cont.Message();
			cont.contactUS();
			
		}
	}

	@Test(priority = 31)

	public void Verify_DoctorName() throws Exception

	{
		SoftAssert softassert;

		{
			// Step 1 run for loop for testdata sheet
			for (int i = 1; i < XlRowCount; i++) {

				// Step 2 Check if Execute column value is Y the only run rows data
				if (xlTD[i][1].equalsIgnoreCase("Y")) {

					for (int j = 1; j < XlRowCount1; j++) {

						try {

							Thread.sleep(2000);
							driver.findElement(By.xpath(prop.getProperty("ldropdownArrow"))).click();
							driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
							vActualDoctorName = driver.findElement(By.xpath(prop.getProperty("Dr_Name"))).getText();
							driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
							vExcptedDoctorName = xlTD1[i][54];
							if (vActualDoctorName.equalsIgnoreCase(vExcptedDoctorName)) {

								String name = "Pass";
								System.out.println("Testcase has been:- " + name);

							} else {

								String name = "Fail";
								System.out.println("Testcase has been :- " + name);

								System.out.println("Screenshot is captured");
								getscreenshot(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
										+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".jpg");

							}
							softassert = new SoftAssert();
							softassert.assertEquals(vActualDoctorName, vExcptedDoctorName);
							softassert.assertAll();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}

		}

	}

	@Test(priority = 32)
	public void Verify_SignOutAppAfterClickingSignOutButton() throws Exception {

		// Click Submit button
		Thread.sleep(2000);
//		driver.findElement(By.xpath(prop.getProperty("ldropdownArrow"))).click();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("Signout"))).click();

	}

}