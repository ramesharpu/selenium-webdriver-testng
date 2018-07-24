package testng;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestNGMultibrowserExample {
	
	public WebDriver driver;
 
  @Test
  public void test1() {
	  System.out.println("from test1");
  }
  
  @BeforeClass
  @Parameters("browser")
  public void beforeMethod(String browser) {
	  System.out.println("browser = "+browser);
	  openBrowser(browser, "http://demosite.center/wordpress/wp-login.php");
  }

  @AfterClass
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
			//driver.close();
			driver.quit();
		}
	}

}
