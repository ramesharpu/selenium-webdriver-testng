package com.ramesh.selenium_webdriver_testng;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class PageLoadTimoutExample {
	
	static WebDriver bDriver;
	
	
	public void openBrowser(String browserType, String url){
		
		String currentDir = System.getProperty("user.dir");
		
		if (browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", currentDir+"\\drivers\\geckodriver.exe");
			bDriver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", currentDir+"\\drivers\\chromedriver.exe");
			bDriver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", currentDir+"\\drivers\\IEDriverserver.exe");
			bDriver = new InternetExplorerDriver();
		}
		else if (browserType.equalsIgnoreCase("htmlunitdriver")){
			bDriver = new HtmlUnitDriver();
		}
		
	
		if(url.isEmpty()){
			url = "about:blank";
		}
		
		bDriver.manage().window().maximize();
		bDriver.get(url);
		bDriver.navigate().to("http://www.github.com");
//		bDriver.manage().timeouts().pageLoadTimeout(1, TimeUnit.NANOSECONDS);
		bDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	public void closeBrowser(){
		if (bDriver != null){
			bDriver.close();
			bDriver.quit();
		}
	}
	
		
	public static void main(String[] args) {
		PageLoadTimoutExample driver = new PageLoadTimoutExample();
		driver.openBrowser("chrome", "https://www.google.com");
		//driver.closeBrowser();
		
	}


}
