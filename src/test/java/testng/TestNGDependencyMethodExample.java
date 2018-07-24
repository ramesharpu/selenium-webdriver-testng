package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;


public class TestNGDependencyMethodExample {

	public WebDriver driver;

	@Test (dependsOnMethods = {"test4"})
	public void test1() {
		System.out.println("from test1 of group - tier-1");
	}

	@Test (dependsOnMethods = {"test3"})
	public void test2() {
		System.out.println("from test2 of group - tier-2");
	}

	@Test (dependsOnMethods = {"test4"})
	public void test3() {
		System.out.println("from test3 of group - tier-1");
	}

	@Test
	public void test4() {
		assertEquals(true, false);
		System.out.println("from test4 of group - tier-2");
	}

	@Test
	public void test5() {
		System.out.println("from test5");
	}

	@BeforeSuite
	public void beforeMethod() {
		openBrowser("chrome", "http://demosite.center/wordpress/wp-login.php");
	}

	@AfterSuite
	public void afterMethod() {
		closeBrowser();
	}

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

}
