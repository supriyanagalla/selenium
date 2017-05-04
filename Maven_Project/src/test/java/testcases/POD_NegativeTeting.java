package testcases;

import org.testng.annotations.Test;

import locaters.POD;

import utilities.CommonFunctions;
import utilities.Staticvariables;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class POD_NegativeTeting extends Staticvariables {
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void f() throws Exception {

		ProjectDir = System.getProperty("user.dir");
		System.out.println("ProjectDir:  " + ProjectDir);
		String path = ProjectDir + "\\TestData\\input.properties";
		FileInputStream fi = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fi);
		
		cfn.Launch_ChromeBrowser();
		// enter url
//		String baseURL = prop.getProperty("PODurl");
		String baseURL = "http://www.pod.co.uk/user/register";
//		cfn.wait(3000);
		cfn.LaunchURL(baseURL);
		

		// validate / assertion whether error message is displaing or not if we
		// missed email input

		cfn.ClickByXPATH(POD.XP_CONTINUE);
		Thread.sleep(5000);
		String abc = driver.findElement(By.xpath(POD.XP_EMAIL_ERRORMSG)).getText();
		String abc1 = abc.trim();
		
		String xyz = "Required input";
		
		cfn.assertEquals(abc1, xyz);

		System.out.println("email Assertion done");
		//validating surname
		String str = driver.findElement(By.xpath(POD.XP_FIRSTNAME_ERRORMSG)).getText();
		String str1 = str.trim();
		
		String xyz1 = "Required input";
		
		cfn.assertEquals(str1, xyz1);
		System.out.println("First name Assertion done");
		//validating surname
		String strsur = driver.findElement(By.xpath(POD.XP_SURNAME_ERRORMSG)).getText();
		String str2 = strsur.trim();
		
		String xyz2 = "Required input";
		
		cfn.assertEquals(str2, xyz2);
		System.out.println("surname  Assertion done");
		
		//validating password
		String strpass = driver.findElement(By.xpath(POD.XP_PASSWORD_ERRORMSG)).getText();
		String str3 = strpass.trim();
		
		String xyz3 = "Required input";
		
		cfn.assertEquals(str3, xyz3);
		System.out.println("password  Assertion done");
		// validating confirm password
		String strcpass = driver.findElement(By.xpath(POD.XP_CONFIRMPASSWORD_ERRORMSG)).getText();
		String str4 = strcpass.trim();
		
		String xyz4 = "Required input";
		
		cfn.assertEquals(str4, xyz4);
		System.out.println("confirm password  Assertion done");
		//validating terms and condition
		
		String strterm = driver.findElement(By.xpath(POD.XP_TERMS_CON_ERRORMSG)).getText();
		String str5 = strterm.trim();
		
		String xyz5 = "Please accept terms";
		
		cfn.assertEquals(str5, xyz5);
		System.out.println("terms and condition Assertion done");

	}


}
