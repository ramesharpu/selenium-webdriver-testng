package com.ramesh.selenium_webdriver_testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliExample {

	static WebDriver driver;
	String currentDir = System.getProperty("user.dir");

	public void openBrowser(String browserType, String url){

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

	public void test() throws FindFailed{
		//String imageDir = currentDir + "\\images";
		String imageDir = "C:\\Users\\Ramesh\\Desktop\\images";
		Screen screen = new Screen();
		Pattern facebook = new Pattern(imageDir+"\\facebook.JPG");
		Pattern username = new Pattern(imageDir+"\\un.JPG");
		Pattern password = new Pattern(imageDir+"\\pass.JPG");
		Pattern login = new Pattern(imageDir+"\\login.JPG");

		screen.wait(facebook, 2);
		screen.click(facebook);
		screen.type(username, "adminasdf");
		screen.type(password, "admin");
		screen.click(login);
	}

	public static void main(String[] args) throws FindFailed {
		SikuliExample driver = new SikuliExample();
		driver.openBrowser("chrome", "http://www.facebook.com");
		driver.test();
//		driver.closeBrowser();

	}


}
