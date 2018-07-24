package com.ramesh.selenium_webdriver_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class uploadExample {
	
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

	public void uploadTest(){
		bDriver.findElement(By.name("uploaded_file")).sendKeys("C:\\Users\\Ramesh\\Desktop\\Day5\\uploadDoc.txt");
		//bDriver.findElement(By.xpath("html/body/table/tbody/tr[4]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[1]/img")).click();
		
	}
	
	public static void main(String[] args) {
		uploadExample driver = new uploadExample();
		driver.openBrowser("chrome", "http://tinyupload.com/");
		driver.uploadTest();
		//driver.closeBrowser();
		
	}


}
