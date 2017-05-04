package testcases;

import org.testng.annotations.Test;

import locaters.POD;
import utilities.CommonFunctions;
import utilities.Staticvariables;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class Negitive_testing_Assignment  extends Staticvariables{
	CommonFunctions cfn=new CommonFunctions();
	
  @Test
  public void f() throws IOException, Exception {
	  // to get data from property file
	  ProjectDir=System.getProperty("user.dir");
	  String path=ProjectDir+"\\TestData\\input.properties";
		System.out.println("project location is"+ProjectDir);
	  FileInputStream fi=new FileInputStream(path);
	  Properties prop=new Properties();
	  prop.load(fi);
	  cfn.Launch_ChromeBrowser();
	  String baseURL=" http://www.pod.co.uk/user/register";
	  cfn.LaunchURL(baseURL);
	  Thread.sleep(2000);
	  cfn.EnterTextByXPATH(POD.XP_EMAIL, prop.getProperty("POD_Email"));
	  cfn.EnterTextByXPATH(POD.XP_FIRSTNAME, prop.getProperty("POD_First_Name"));
	  cfn.EnterTextByXPATH(POD.XP_SURNAME, prop.getProperty("POD_Surname"));
	  cfn.EnterTextByXPATH(POD.XP_PASSWORD, prop.getProperty("POD_Pass"));
	  cfn.EnterTextByXPATH(POD.XP_CONFIRMPASSWORD, prop.getProperty("POD_Conpass"));
	  cfn.ClickByXPATH(POD.XP_CONTINUE);
	  String str=driver.findElement(By.xpath(POD.XP_EMAIL_ERRORMSG)).getText();
	  String str1=driver.findElement(By.xpath(POD.XP_FIRSTNAME_ERRORMSG)).getText();
	  String str2=driver.findElement(By.xpath(POD.XP_SURNAME_ERRORMSG)).getText();
	  String str3=driver.findElement(By.xpath(POD.XP_PASSWORD_ERRORMSG)).getText();
	  String str4=driver.findElement(By.xpath(POD.XP_CONFIRMPASSWORD_ERRORMSG)).getText();
	  String str5=driver.findElement(By.xpath(POD.XP_TERMS_CON_ERRORMSG)).getText();
	  cfn.takeScreenshot("POD_Error");
	  System.out.println("error message of email is  "+str);
	  System.out.println("error message of firstname is  "+str1);
	  System.out.println("error message of surname is  "+str2);
	  System.out.println("error message of password is  "+str3);
	  System.out.println("error message of confirm password is  "+str4);
	  System.out.println("error message of terms&con  is  "+str5);
	  // clear data and getting proper data into edit boxes
	  driver.findElement(By.xpath(POD.XP_EMAIL)).clear();
	  driver.findElement(By.xpath(POD.XP_FIRSTNAME)).clear();
	  driver.findElement(By.xpath(POD.XP_SURNAME)).clear();
	  driver.findElement(By.xpath(POD.XP_PASSWORD)).clear();
	  driver.findElement(By.xpath(POD.XP_CONFIRMPASSWORD)).clear();
	  cfn.EnterTextByXPATH(POD.XP_EMAIL, prop.getProperty("POD_email"));
	  cfn.EnterTextByXPATH(POD.XP_FIRSTNAME, prop.getProperty("POD_fname"));
	  cfn.EnterTextByXPATH(POD.XP_SURNAME, prop.getProperty("POD_sname"));
	  cfn.EnterTextByXPATH(POD.XP_PASSWORD, prop.getProperty("POD_password"));
	  cfn.EnterTextByXPATH(POD.XP_CONFIRMPASSWORD, prop.getProperty("POD_cpass"));
	  
  }
  @AfterTest
  public void afterTest()
  {
	  //driver.quit();
  }

}
