package com.ramesh.selenium_webdriver_testng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AutoITExample {

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

	public void autoItExample() throws InterruptedException{
		driver.findElement(By.xpath("html/body/header/section/section[1]/figure")).click();
		try {
			Runtime.getRuntime().exec("F:\\Edureka\\Feb 19th to Mar 9th\\Autoit-Sikuli\\Autoit\\tinyImageUpload.exe");
			Thread.sleep(5000);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static void main(String[] args) throws InterruptedException {
		AutoITExample driver = new AutoITExample();
		driver.openBrowser("chrome", "https://tinypng.com/");
		driver.autoItExample();
		//driver.closeBrowser();

	}


}
