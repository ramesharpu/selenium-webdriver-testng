package testng;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class ScreenshotOnMethodCompletion {
	public static WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
	String currentDir = System.getProperty("user.dir");
	System.out.println(currentDir);
	System.setProperty("wedriver.firefox.driver", currentDir+"\\drivers\\firefoxdriver.exe");
	driver = new FirefoxDriver();
	}
	
	@Test
	public void method1() {
		assertTrue(true);
	}
	
	@Test
	public void method2() {
		driver.get("http://www.amazon.com");
		assertTrue(false);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("Test method : "+ result.getName()+" - "+result.getStatus());
		System.out.println(result);
		if(result.getStatus()==ITestResult.FAILURE){
			File errorFile = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(errorFile, new File("C:\\Users\\Ramesh\\Desktop\\errorFileScreenShot.png"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
