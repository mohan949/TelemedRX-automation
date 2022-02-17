package mainRunner;

import org.testng.TestNG;

import testCasesV2.TestCasesSprint11;
import testCasesV2.TestCasesSprint11_2;

public class RunnerTwo {
	
	
	
	static TestNG testNg;
	
	public static void main(String[] args) {
		
	
	//ExtentReportListener ent= new ExtentReportListener();

	testNg=new TestNG();

	//testNg.setTestClasses(new Class[]{C:\Users\mohan\eclipse-workspace\TeleMedRX_Framework_Dietician\src\test\java\TestCasesV1\blog.class});
	testNg.setTestClasses(new Class[] { TestCasesSprint11.class}); 

	//testNg.addListener(ent);

	testNg.run();

	}

}
