package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import locaters.MyObjects;
import utilities.CommonFunctions;
import utilities.Staticvariables;

public class FB_Login extends Staticvariables {
	@Test
	public void f() throws IOException, InterruptedException {

		CommonFunctions cfn = new CommonFunctions();

		// get the data from property file
		ProjectDir = System.getProperty("user.dir");
		System.out.println("ProjectDir:  " + ProjectDir);
		String path = ProjectDir + "\\TestData\\input.properties";
		FileInputStream fi = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fi);
		cfn.Launch_ChromeBrowser();
		
		cfn.GetAndOpenBrowserFromXML("firefox");
		// enter url
		String baseURL = prop.getProperty("url");
		cfn.LaunchURL(baseURL);
		cfn.takeScreenshot("fblaunch");
		cfn.EnterTextByID(MyObjects.ID_EMAIL, prop.getProperty("Email"));
		cfn.takeScreenshot("fbemail");
		cfn.EnterTextByID(MyObjects.ID_PASSWORD, prop.getProperty("Password"));
		cfn.ClickByXPATH(MyObjects.XP_LOGIN);
		cfn.takeScreenshot("fb_lafterclick");
		
		WebElement ele = driver.findElement(By.id(MyObjects.ID_EMAIL));
		ele.clear();
		ele.sendKeys("Sdgsdg");

		
	}
}
