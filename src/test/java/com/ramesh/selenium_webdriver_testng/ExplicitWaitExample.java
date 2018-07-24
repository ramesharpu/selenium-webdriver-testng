package com.ramesh.selenium_webdriver_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWaitExample {
	
	static WebDriver driver;
	
	
	public void openBrowser(String browserType, String url){
		
		String currentDir = System.getProperty("user.dir");
		
		if (browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", currentDir+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", currentDir+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", currentDir+"\\drivers\\IEDriverserver.exe");
			driver = new InternetExplorerDriver();
		}
		else if (browserType.equalsIgnoreCase("htmlunitdriver")){
			driver = new HtmlUnitDriver();
		}
		
	
		if(url.isEmpty()){
			url = "about:blank";
		}	
		
		driver.manage().window().maximize();
		driver.get(url);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
//		WebElement element = wait.until(ExpectedConditions.
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("u_0_u")));
//		WebElement element = driver.findElement(By.id("u_0_3"));
		element.click();

	}
	
	public void closeBrowser(){
		if (driver != null){
			driver.close();
			driver.quit();
		}
	}
	

	public static void main(String[] args) {
		ExplicitWaitExample driver = new ExplicitWaitExample();
		driver.openBrowser("chrome", "http://www.facebook.com");
		//driver.closeBrowser();
		
	}


}
