package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import locaters.MyObjects;

public class CommonFunctions extends Staticvariables {

	public CommonFunctions()// constructor
	{
		ProjectDir = System.getProperty("user.dir");// C:\Users\likhitha555\Desktop\Selenium\Workspace\Maven_Project

		File f = new File(ProjectDir + "\\Screenshots");
		boolean a = false;
		if (!f.exists()) {
			a = f.mkdir();
		}
		if (a) {
			System.out.println("Screenshots folder successfully created...");
		} else {
			System.out.println("Screenshots folder already existed ...");
		}

		ScreenshotsPath = ProjectDir + "\\Screenshots\\";

	}

	/************** Launch Chrome URL ***************/
	public void Launch_ChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\likhitha555\\Desktop\\Selenium\\Workspace\\Library\\chromedriver.exe ");
		driver = new ChromeDriver();
	}

	/****************** Launch URL ***********************/
	public void LaunchURL(String baseURL) {
		driver.get(baseURL);
		// window maximizer
		driver.manage().window().maximize();
	}

	/********** Editbox **************/
	public void EnterTextByID(String locater, String inputdata) {
		driver.findElement(By.id(locater)).sendKeys(inputdata);
	}

	public void EnterTextByXPATH(String locater, String inputdata) {
		driver.findElement(By.xpath(locater)).sendKeys(inputdata);
	}

	public void EnterTextByNAME(String locater, String inputdata) {
		driver.findElement(By.name(locater)).sendKeys(inputdata);
	}

	/************ Click Event ****************/
	public void ClickByID(String locater) {
		driver.findElement(By.id(locater)).click();

	}

	public void ClickByXPATH(String locater) {
		driver.findElement(By.xpath(locater)).click();
	}

	public void ClickByNAME(String locater) {
		driver.findElement(By.name(locater)).click();
	}

	public void ClickByCss(String elementlocator) {
		driver.findElement(By.cssSelector(elementlocator)).click();
	}

	public void ClickByLinkText(String elementlocator) {
		driver.findElement(By.linkText(elementlocator)).click();
	}

	public void ClickByPartialLinkText(String elementlocator) {
		// driver.findElement(By.partialLinkText(elementlocator)).click();
		WebElement element = driver.findElement(By.partialLinkText(elementlocator));
		element.click();
	}

	public void ClickUsingJavaScript(WebElement webelement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", webelement);
	}

	/************
	 * Screenshot
	 * 
	 * @throws IOException
	 ***********************************/
	public void takeScreenshot(String name) throws IOException {
		/*
		 * Date d = new Date(); System.out.println(d); DateFormat df = new
		 * SimpleDateFormat("YYYY_MM_DD_HH_mm_ss"); String time = df.format(d);
		 */

		File text = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(text, new File(ScreenshotsPath + name + ".png"));

	}

	/***********************
	 * Assertion
	 * 
	 * @throws Exception
	 ***************/
	public void assertEquals(String ActualMessage, String Expectedmessage) throws Exception {
		Thread.sleep(3000);
		Assert.assertEquals(ActualMessage, Expectedmessage);

	}

	// Clear the Editbox Text
	public void ClearTextByName(String elementlocator) {
		driver.findElement(By.name(elementlocator)).clear();
	}

	public void ClearTextByID(String elementlocator) {
		driver.findElement(By.id(elementlocator)).clear();
	}

	public void ClearTextByXpath(String elementlocator) {
		driver.findElement(By.xpath(elementlocator)).clear();
	}

	/************** Return Web Element *********/
	public WebElement GetWebElementByID(String elementlocator) {
		WebElement element = driver.findElement(By.id(elementlocator));
		return element;
	}

	public WebElement GetWebElementName(String elementlocator) {
		WebElement element = driver.findElement(By.name(elementlocator));
		return element;
	}

	public WebElement GetWebElementXpath(String elementlocator) {
		WebElement element = driver.findElement(By.xpath(elementlocator));
		return element;
	}

	public WebElement GetWebElementCss(String elementlocator) {
		WebElement element = driver.findElement(By.cssSelector(elementlocator));
		return element;
	}

	public WebElement GetWebElementLinkText(String elementlocator) {
		WebElement element = driver.findElement(By.linkText(elementlocator));
		return element;
	}

	public WebElement GetWebElementPartialLinkText(String elementlocator) {
		WebElement element = driver.findElement(By.partialLinkText(elementlocator));
		return element;
	}

	public int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			// throw new IllegalArgumentException("max must be greater than
			// min");
			return min;
		}
		Random r = new Random();
		return (r.nextInt((max - min) + 1) + min);
	}

	/******************* Launch Browser *******************/
	public void GetAndOpenBrowserFromXML(String browser) throws IOException, InterruptedException {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", ProjectDir + "/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				// System.setProperty("webdriver.chrome.driver",
				// FileOrDriverPathOf("ChromeDriverpath"));
				System.setProperty("webdriver.chrome.driver", ProjectDir + "\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", ProjectDir + "\\Drivers\\IEDriverServer.exe");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver(capabilities);
			} else if (browser.equalsIgnoreCase("Safari")) {
				driver = new SafariDriver();
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	/******* Get current time and Date *******/
	public String TimeStampasSrting() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	/*************
	 * ScreenshotOnPassFail
	 * 
	 * @throws IOException
	 ********************/
	public void ScreenshotOnPassFail(ITestResult testresult) throws IOException {
		ClassName = testresult.getTestClass().getName().trim();
		MethodName = testresult.getName().trim();

		// Fail_classname_Methodname_timestamp.png

		if (testresult.getStatus() != ITestResult.FAILURE)// Pass
		{
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(ScreenshotsPath + "Pass_" + ClassName + "_" + MethodName + "_" + TimeStampasSrting() + ".png"));
		}
		if (testresult.getStatus() == ITestResult.FAILURE)// Fail
		{
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(ScreenshotsPath + "Fail_" + ClassName + "_" + MethodName + "_" + TimeStampasSrting() + ".png"));
		}

	}

	/*********************** TestData path ****************/
	// C:\Users\likhitha555\Desktop\Selenium\Workspace\Maven_Project\TestData\input.properties

	public String TestdataPath(String testdatafilename) {
		String TestdataPath = ProjectDir + "\\TestData\\" + testdatafilename;
		return TestdataPath;
	}

	
	
	
	
	
}