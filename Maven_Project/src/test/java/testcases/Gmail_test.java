package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import locaters.MyObjects;
import utilities.CommonFunctions;

public class Gmail_test {
  @Test
  public void f() throws IOException, InterruptedException {
	  CommonFunctions cfn = new CommonFunctions();

		// get the data from property file
		String path = "C:\\Users\\likhitha555\\Desktop\\Selenium\\Workspace\\Maven_Project\\TestData\\input.properties";
		FileInputStream fi = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fi);
		cfn.Launch_ChromeBrowser();
		// enter url
		String baseURL = prop.getProperty("gmail_URL");
		cfn.LaunchURL(baseURL);
		Thread.sleep(5000);
		cfn.EnterTextByID(MyObjects.Gmail_Email, prop.getProperty("gmail_Email"));
		cfn.ClickByXPATH(MyObjects.Gmail_NEXT);
		
  }
}
