package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import locaters.MyObjects;
import utilities.CommonFunctions;
import utilities.Staticvariables;

public class Sample extends Staticvariables {
  @Test
  public void f() throws IOException {
	  
	  CommonFunctions cfn = new CommonFunctions();

		/*// get the data from property file
		ProjectDir = System.getProperty("user.dir");
		System.out.println("ProjectDir:  " + ProjectDir);
		String path = ProjectDir + "\\TestData\\input.properties";
		FileInputStream fi = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fi);
		cfn.Launch_ChromeBrowser();
		// enter url
		String baseURL = prop.getProperty("url");
		cfn.LaunchURL(baseURL);
		
		WebElement fb_Email = driver.findElement(By.id(MyObjects.ID_EMAIL));
		fb_Email.clear();
		fb_Email.sendKeys("SDgsdgs");
		*/
		System.out.println("test");
		System.out.println(cfn.getRandomNumberInRange(2, 8));
		
		
  }
}
