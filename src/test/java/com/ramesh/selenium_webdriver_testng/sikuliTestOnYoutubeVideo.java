package com.ramesh.selenium_webdriver_testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class sikuliTestOnYoutubeVideo {

	static WebDriver bDriver;
	String currentDir = System.getProperty("user.dir");

	public void openBrowser(String browserType, String url){

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

	public void test() throws FindFailed{
		//String imageDir = currentDir + "\\images";
		String imageDir = "C:\\Users\\Ramesh\\Desktop\\images\\";
		Screen screen = new Screen();
		screen.type(Key.PAGE_DOWN);
		Pattern videoLink = new Pattern(imageDir+"playButton.JPG");
		
		screen.wait(videoLink, 2);
		screen.click(videoLink);
	}

	public static void main(String[] args) throws FindFailed {
		sikuliTestOnYoutubeVideo driver = new sikuliTestOnYoutubeVideo();
		driver.openBrowser("chrome", "https://www.educare.co.uk/news-and-blogs");
		driver.test();
//		driver.closeBrowser();

	}


}
