/**
 * 
 */
package mainRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import TestCasesV1.testcaseSelectClinic;
import testCasesV2.TestCasesSprint11;

/**
 * @author mohan
 *this is  test 
 */
public class MainRunner {
	static TestNG testng;
	public static void main(String[] args) {
		testng=new TestNG();
		String path = System.getProperty("user.dir")+"/testng.xml";
		List<String> xmlList = new ArrayList<String>();
		xmlList.add(path);
		
		
	
		
     		
		//testng.setTestSuites(xmlList);
		/*
		 * ablove code is for running whole testNG.xml file
		 */		
		
		testng.setTestClasses(new Class[] { TestCasesSprint11.class}); 
		
		
		testng.run();
	}
}
