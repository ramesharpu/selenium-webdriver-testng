package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;


public class TestNGEnableFalse {
	
	public WebDriver driver;
  
  @Test (priority=0,  alwaysRun=true, enabled=false)
  public void test1() {
	  System.out.println("from test1  priority 0");
  }
  
  @Test (dependsOnMethods = {"test1"})
  public void test2() {
	  System.out.println("from test2  priority 1");
  }
  
  @Test (priority=2)
  public void test3() {
	  System.out.println("from test3  priority 2");
  }
  
  @Test (priority=3)
  public void test4() {
	  System.out.println("from test4  priority 3");
  }
  
  @Test (priority=4)
  public void test5() {
	  System.out.println("from test5  priority 4");
  }
  
//  @Test (priority=2)
  @Test
  public void test6() {
	  System.out.println("from test6  priority 2");
  }
  
  @Test (priority=-1)
  public void test7() {
	  System.out.println("from test7  priority -1");
  }
  
 /* @BeforeSuite
  public void beforeMethod() {
	  openBrowser("chrome", "http://demosite.center/wordpress/wp-login.php");
  }

  @AfterSuite
  public void afterMethod() {
	  closeBrowser();
  }*/
  
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
