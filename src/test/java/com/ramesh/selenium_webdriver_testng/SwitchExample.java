package com.ramesh.selenium_webdriver_testng;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SwitchExample {
	
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
	
	public void switchToAlertFrame(){
		driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.cssSelector("button")).click();
		swicthToAlertWindow();
	}
	
	public void swicthToAlertWindow(){
		//get the alert text
		String alertText = driver.switchTo().alert().getText();
		System.out.println("Alert Text = " +alertText);
		
		//Show the error
//		driver.findElement(By.cssSelector("button")).click();
		
		//Accept
//		driver.switchTo().alert().accept();
		
		//Dismiss
//		driver.switchTo().alert().dismiss();
	}
	
	public void switchToNewWindow(){
		driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		System.out.println("Window handles output (Before)- " +driver.getWindowHandles());
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.cssSelector("button")).click();
//		System.out.println("Window handle output - " +driver.getWindowHandle());		
		System.out.println("Window handles output (After)- " +driver.getWindowHandles());
		
		
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
//
		driver.switchTo().window(tabs.get(0));
//		driver.close();
//		
//		driver.switchTo().window(tabs.get(0));
//		
//		driver.quit();

	}
	
	public static void main(String[] args){
		SwitchExample driver = new SwitchExample();
		driver.openBrowser("chrome", "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
//		driver.switchToAlertFrame();
		driver.switchToNewWindow();
//		driver.closeBrowser();
		
	}


}
