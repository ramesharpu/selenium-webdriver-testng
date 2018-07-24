package com.ramesh.selenium_webdriver_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class keyboardAndMouseExample {
	
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
	}
	
	public void closeBrowser(){
		if (bDriver != null){
			bDriver.close();
			bDriver.quit();
		}
	}
	
	public void keyboardAndMouseInteraction(){
		WebElement elem = bDriver.findElement(By.id("login_field"));
		Actions loginAction = new Actions(bDriver);
		Action performLogin = loginAction.moveToElement(elem).click().sendKeys("asdf").sendKeys(Keys.TAB)
				.sendKeys("asdfsdaf").sendKeys(Keys.TAB)
				.sendKeys(Keys.ENTER).build();
		performLogin.perform();
		
	}
	
	public static void main(String[] args) {
		keyboardAndMouseExample driver = new keyboardAndMouseExample();
		driver.openBrowser("chrome", "https://github.com/login");
		driver.keyboardAndMouseInteraction();
		//driver.closeBrowser();
		
	}


}
