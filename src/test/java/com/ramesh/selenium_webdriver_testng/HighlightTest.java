package com.ramesh.selenium_webdriver_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HighlightTest {

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

	public static void highlight(WebElement element) throws InterruptedException{
		//Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor)bDriver;
		js.executeScript("arguments[0].style.border='10px groove red'", element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].style.border=''", element);
	}
	private void locatorTest() throws InterruptedException {
		WebElement highlightElementOnScreen;

		//highlighting email id element
		highlightElementOnScreen = bDriver.findElement(By.id("email"));
		highlight(highlightElementOnScreen);

		//Entering the value
		bDriver.findElement(By.id("email")).sendKeys("test");

		//highlighting password element
		highlightElementOnScreen = bDriver.findElement(By.name("pass"));
		highlight(highlightElementOnScreen);

		//Entering the value
		bDriver.findElement(By.name("pass")).sendKeys("test");
	}

	public static void main(String[] args) throws InterruptedException {
		HighlightTest driver = new HighlightTest();
		driver.openBrowser("chrome", "https://www.facebook.com");
		driver.locatorTest();
	}
}
