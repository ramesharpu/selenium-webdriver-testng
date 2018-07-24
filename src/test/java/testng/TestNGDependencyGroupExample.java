package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;


public class TestNGDependencyGroupExample {
	
	public WebDriver driver;
  
  @Test (dependsOnGroups = { "tier-1" })
  public void test1() {
	  System.out.println("from test1 of group - tier-1");
  }
  
  @Test (dependsOnGroups = { "tier-2" })
  public void test2() {
	  System.out.println("from test2 of group - tier-2");
  }
  
  @Test (groups = { "tier-1" })
  public void test3() {
	  System.out.println("from test3 of group - tier-1");
  }
  
  @Test (groups = { "tier-2" })
  public void test4() {
	  System.out.println("from test4 of group - tier-2");
  }
  
  @Test (groups = { "tier-1" })
  public void test5() {
	  System.out.println("from test5 of group - tier-1");
  }
  
  @Test (groups = { "tier-2" })
  public void test6() {
	  System.out.println("from test6 of group - tier-2");
  }
  
  @Test (groups = { "tier-3" })
  public void test7() {
	  System.out.println("from test7 of group - tier-3");
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /*@BeforeSuite
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
	}*/

}
