package assignment;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class GetAllLinksExample {

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

	public void getAllLinks(){
		List<WebElement> links = driver.findElements(By.xpath("//table[@class='uiGrid _51mz navigationGrid']/tbody/tr/td"));
		List<String> li = new ArrayList<>();

		for(WebElement x : links){
			System.out.println(x.getText());
			li.add(x.getText());			
		}

		for(String generatedLink : li){

			if(generatedLink.equals("Settings") || generatedLink.equals("Activity log")){
				System.out.println("Not clicking on - "+generatedLink);
			}
			else{
				System.out.println("Clicking on the link - "+generatedLink);
				if(!generatedLink.equals("Settings") || !generatedLink.equals("Activity Log"))
					driver.findElement(By.linkText(generatedLink)).click();

				if(driver.getWindowHandles().size() > 1){
					ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					driver.close();
					driver.switchTo().window(tabs.get(0));
				}
				else{
					driver.navigate().back();
				}
			}
		}
	}

	public static void main(String[] args) {
		GetAllLinksExample driver = new GetAllLinksExample();
		driver.openBrowser("chrome", "https://www.facebook.com");
		driver.getAllLinks();
		driver.closeBrowser();

	}


}
