package testcases;

import org.testng.annotations.Test;

import locaters.POD;
import utilities.CommonFunctions;
import utilities.Staticvariables;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class TestCaseTemplate extends Staticvariables {

	CommonFunctions cfn = new CommonFunctions();

	@BeforeClass
  @Parameters("browser")//browser will come from xml
  public void beforeClass(@Optional("chrome") String browser) throws IOException, InterruptedException {
	  
	  TestdataPath = cfn.TestdataPath("input.properties");//to get the data from property file, given path info
	  cfn.GetAndOpenBrowserFromXML(browser);
	  
  }

	@AfterClass//finally this annotation will run
	public void afterClass() {
		driver.quit();
	}

	@AfterMethod//Each and every @Test annotation after this(AfterMethod annotation) will run
	public void afterMethod(ITestResult testresult) throws InterruptedException, IOException {
		cfn.ScreenshotOnPassFail(testresult);
		Thread.sleep(1000);
		
	}
	
	@Test
	public void Testcase1() throws IOException, InterruptedException {
		
		File file = new File(TestdataPath);
		FileInputStream fi = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fi);
			
		cfn.LaunchURL(prop.getProperty("PODurl"));
		Thread.sleep(5000);
		cfn.ClickByXPATH(POD.XP_CONTINUE);
		
		
	}
	
}
