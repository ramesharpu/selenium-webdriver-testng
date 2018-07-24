package com.ramesh.selenium_webdriver_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverExample {
	
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
	}
	
	public void closeBrowser(){
		if (driver != null){
			driver.close();
			driver.quit();
		}
	}
	
	public void hoverActionDemo(){

		WebElement element = driver.findElement(By.linkText("For Home"));
		element.click();
		driver.findElement(By.linkText("Best-Selling Deals")).click();
//		new Actions(driver).moveToElement(driver.findElement(By.linkText("For Home"))).moveToElement(driver.findElement(By.linkText("Best-Selling Deals"))).click().build().perform();		
	}
	
	public static void main(String[] args) {
		HoverExample driver = new HoverExample();
		driver.openBrowser("chrome", "https://www.dell.com");
		driver.hoverActionDemo();
		//driver.closeBrowser();
		
	}


}
