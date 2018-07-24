package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;


public class TestNGSuiteExample {
	
	public WebDriver driver;
  
	

  @Test (threadPoolSize = 3, invocationCount = 2,  timeOut = 10000)
  public void trueTest() {
	  System.out.println("trueTestOutput");
	  assertTrue(true);
  }
  
  @Test
  public void falseTest() {
	  System.out.println("falseTestOutput");
	  assertFalse(true);
  }
  
}
