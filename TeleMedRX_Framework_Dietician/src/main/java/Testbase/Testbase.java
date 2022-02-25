package Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.Table.Cell;

public class Testbase {
	public static WebDriver driver;
	public static File file;
	public static FileInputStream fs, FS1;
	public static Properties prop;
	public static String xlPath, xlPatientpath,xlOPDpath, xlloginPath;
	public static String xlTD[][];// 2 D Arrays
	public static String xlTD1[][];// 2 D Arrays
	public static String xlTD2[][];// 2 D Arrays
	public static String xlTD3[][];
	public static String vUsername, vPassword, vFirstname, vLastname,vMobilenumber,vOPDPatientName,
	vOPDDate,vOPDConcern,vOPDSlot, vExcptedDoctorName, vExcptedSearchtext, vActualDoctorName,vExcptedClinicName, 
	vActualClinicName,vExcptedOPDtext, vActualOPDtext,vExcptedPatienttext, vExcptedStafftext, vExcptedCalendartext, 
	vExcptedSettingstext,vExcptedContactUstext, vActualPatienttext, vActualStafftext, vActualCalendartext, 
	vActualSettingstext,vActualContactUstext,vExcptedColTimetext,vExcptedColPatinettext,vExcptedColGenderAgetext ,vExcptedColPhoneNumbertext
	,vExcptedColStatustext, vExcptedColAppointmenttext,vExcptedColActiontext,vActualColTimetext,vActualColPatinettext,vActualColGenderAgetext ,vActualColPhoneNumbertext
	,vActualColStatustext, vActualColAppointmenttext,vActualColActiontext, vExpectedAPTitle,vActualAPTitle,vExpectedAPButton,vActualAPButton,
	vExpectedCreateAnAppointmentTitle,vActualCreateAnAppointmentTitle,
	vExpectedPopPatient,vExpectedPopDoctor,vExpectedPopClinicFacilityAddress,vExpectedPopAppointmentType,vExpectedDate, vExpectedAppointmentslot,vExpectedPopStatus,
	vExpectedPopPatientConcerns, vExpectedPopBtnCancel,vExpectedPopBtnCreateAppointment,
	vActualPopPatient,vActualPopDoctor,vActualPopClinicFacilityAddress,vActualPopAppointmentType,vActualDate, vActualAppointmentslot,vActualPopStatus,
	vActualPopPatientConcerns, vActualPopBtnCancel,vActualPopBtnCreateAppointment,
	vExpectedStaffLabel,vActualStaffLabel,vExpectedAddStaffButton,vActuaAddStaffButton,
	vExpectedMobNo,vExpectedSendButton,vExpectedCloseButton,vActualMobNo,vActualSendButton,vActualCloseButton,vExpectedRegistrationStatusButton,vActualRegistrationStatusButton,
	vExpectedCalendarLable,vActualCalendarLable,vExpectedPageTitle,vActualPageTitle,vExpectedGoogleCalendarSync,vActualGoogleCalendarSync,
	vExpectedmonthview,vExpectedweekview,vExpecteddayview,vActualmonthview,vActualweekview,vActualdayview,
	vExpectedCurrentMonth,vActualCurrentMonth,vExpectedWeight,vActualTodaysDate,
	vExpectedSettingName,vActualSettingName,vClinicName,vClinicPhone,vClinicStreetAddress,
	vHrs,vMin,vType, vActualBTNAddClinic,vExpectedBTNAddClinic,
	vSettingFName,vSettingLName;
	
	
	public static String vRandromFirstName;
	public static Logger logger;
	
	public static  ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	//public static ExtentTest logger;
	


	public static String fName, lName, mobNo;
	public static int XlRowCount,XlRowCount1,XlRowCount2,XlRowCount3, XLReportCount, xRows, xCols;
	public static String arraycount;

	@BeforeTest 
	public void initial() throws Exception {
		// Step 1
		file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Config.properties");
		fs = new FileInputStream(file);
		prop = new Properties();
		prop.load(fs);
		
		xlPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testsuite\\Test_suite.xls";
		xlTD = readXL(xlPath, "Testcase");		
		XlRowCount = xlTD.length;
//		System.out.println("Total  rows in Test sheet are --->" + XlRowCount);
		
		
		xlloginPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testsuite\\Test_suite.xls";
		xlTD1 = readXL(xlloginPath, "Login");		
		XlRowCount2 = xlTD1.length;
//		System.out.println("Total  rows in Test sheet are --->" + XlRowCount2);
		
		
		xlPatientpath = System.getProperty("user.dir") + "\\src\\test\\resources\\testsuite\\Test_suite.xls";
		xlTD2 = readXL(xlPatientpath, "Patient");		
		XlRowCount1 = xlTD2.length;
//		System.out.println("Total  rows in Test sheet are --->" + XlRowCount1);
		
		
		xlOPDpath = System.getProperty("user.dir") + "\\src\\test\\resources\\testsuite\\Test_suite.xls";
		xlTD3 = readXL(xlOPDpath, "OPD");		
		XlRowCount3 = xlTD3.length;
//		System.out.println("Total  rows in Test sheet are --->" + XlRowCount3);
		
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\I2E_Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		logger = Logger.getLogger("Log_test_extend_report_Mohan");
		PropertyConfigurator.configure("Log4j.properties");
		
		

		htmlReporter = new ExtentHtmlReporter("extent_report"+ GetCurrentTimeStamp().replace(":", "_").replace(".", "_")+".html");


		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		
	}
	
	// Below 2 methods are used for taking screenshot
	public static void getscreenshot(String path) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		FileUtils.copyFile(scrFile, new File(path));
	}
	public static String GetCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
	
	
	
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/test/resources/screenshots\r\n"
				+ "" + GetCurrentTimeStamp().replace(":", "_").replace(".", "_")+ tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	// Teach Java to R/W from MS Excel
	// Method to read XL
	public String[][] readXL(String fPath, String fSheet) throws Exception {
		// Inputs : XL Path and XL Sheet name
		// Output : cellValue

		String[][] xData;
		// Step 1 create Constructor of FIle Class to store xls file path
		File myxl = new File(fPath);
		// Step 2 create constructor of FileInputStream instruct read data from
		// xls
		FileInputStream myStream = new FileInputStream(myxl);
		// Step 3 create constructor of HSSFworkbook
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);
		// Step 4 get sheet name in run time
		HSSFSheet mySheet = myWB.getSheet(fSheet);
		xRows = mySheet.getLastRowNum() + 1;
		xCols = mySheet.getRow(0).getLastCellNum();
//		System.out.println("Total Rows in Excel are " + xRows);
//		System.out.println("Total Cols in Excel are " + xCols);
		xData = new String[xRows][xCols];
		for (int i = 0; i < xRows; i++) {// outer for loop for Rows
			HSSFRow row = mySheet.getRow(i);
			for (int j = 0; j < xCols; j++) {// inner loop for Columns
				HSSFCell cell = row.getCell(j);
				String value = "-";
				if (cell != null) {
					value = cellToString(cell);
				}
				xData[i][j] = value;
//				System.out.print(value);
//				System.out.print("----");
			}
			System.out.println("");
		}
		myxl = null; // Memory gets released
		myWB.close(); //Close workbook
		return xData;
		}

	public static String cellToString(HSSFCell cell) {
		// This function will convert an object of type excel cell to a string
		// value
		int type = cell.getCellType();
		Object result;
		switch (type) {
		case HSSFCell.CELL_TYPE_NUMERIC: // 0
			//Chnage for Number 
			result = (long)cell.getNumericCellValue();
//			Chnage for timeslot 
//			result = cell.getDateCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING: // 1
			result = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_FORMULA: // 2
			throw new RuntimeException("We can't evaluate formulas in Java");
		case HSSFCell.CELL_TYPE_BLANK: // 3
			result = "%";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN: // 4
			result = cell.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_ERROR: // 5
			throw new RuntimeException("This cell has an error");
		default:
			throw new RuntimeException("We don't support this cell type: " + type);
		}
		return result.toString();
		
	}
	
	
	//Write Excel Method
	public void writeExl(String staus, int rowID) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testcase\\data.xls");
		FileInputStream fs = new FileInputStream(file);
		HSSFWorkbook xsf = new HSSFWorkbook(fs);
		// Step 4 get sheet name in run time
		HSSFSheet mySheet = xsf.getSheetAt(0);
		mySheet.getRow(rowID).getCell(6).setCellValue(staus);
		FileInputStream fos= new FileInputStream(file);	
		xsf.write(file);
		xsf.close();
		
	}
	

	

	public  String randomStringForm() {

		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);

	}



	public String randomNumberGeneratorCl() {

		String generatednumber = RandomStringUtils.randomNumeric(2);
		return (generatednumber);


	
	}
	
	public String randomPhoneNumberGenerator() {

		String generatednumber = RandomStringUtils.randomNumeric(7);
		return (generatednumber);


	
	}
	

}
