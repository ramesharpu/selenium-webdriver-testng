package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample2 {

	static RemoteWebDriver driver;
	public static void test() throws InterruptedException{
		driver.findElement(By.id("email")).sendKeys("ramesh");
		driver.findElement(By.id("pass")).sendKeys("password");
		System.out.println("Done");
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		new DesiredCapabilities();
		DesiredCapabilities cap = DesiredCapabilities.firefox();
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("http://www.facebook.com");
		test();
//		driver.close();
//		driver.quit();

	}


}
