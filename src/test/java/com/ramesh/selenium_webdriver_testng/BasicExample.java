package com.ramesh.selenium_webdriver_testng;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BasicExample {

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

	public void testBrowser(){
		System.out.println("Current URL - " +driver.getCurrentUrl());
		System.out.println("Page Source - " +driver.getPageSource());
		System.out.println("Window Handle - " +driver.getWindowHandle());
		System.out.println("Title URL - " +driver.getTitle());
		System.out.println("Class - " +driver.getClass());
	}

	public void testBrowserNavigate(){
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	private void locatorTest() {
		//on facebook
		//id
		/*driver.findElement(By.id("email")).sendKeys("test123");*/

		//name
		/*driver.findElement(By.name("pass")).sendKeys("ramesh");*/

		//class name
		/*driver.findElement(By.className("inputtext")).sendKeys("ramesh");*/

		//tag name (Expect element not visible error in this)
		/*driver.findElement(By.tagName("input")).sendKeys("from tagname");*/

		//dropdown button
		/*Select day = new Select(driver.findElement(By.id("day")));
		day.selectByVisibleText("10");*/

		//radio button
		/*driver.findElement(By.id("u_0_9")).click();*/

		//tag name
		/*Select day1 = new Select(driver.findElement(By.tagName("select")));
		day1.selectByVisibleText("18");*/

		//css select
		/*driver.findElement(By.cssSelector("#email")).sendKeys("css selector");*/

		//link text
		/*driver.findElement(By.linkText("Forgotten account?")).click();*/

		//partial link text
		/*driver.findElement(By.partialLinkText("Forgotten")).click();*/
		/*driver.findElement(By.partialLinkText("account?")).click();*/
		/*driver.findElement(By.partialLinkText("ten a")).click();*/
		/*driver.findElement(By.partialLinkText("go")).click();*/
		/*driver.findElement(By.partialLinkText("?")).click();*/
		/*driver.findElement(By.partialLinkText("Forgotten account?")).click();*/



		//combination of two elements (parent & child)
		/*driver.findElement(new ByChained(By.id("login_form"), By.name("pass"))).sendKeys("ramesh");*/

		//xpath - email
		/*driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ramesh-xpath-data-testid");*/

		//xpath - contains ==> FB create an account button ==> By Text
		/*driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();*/
		/*driver.findElement(By.xpath("//button[contains(text(),'an')]")).click();*/
		/*driver.findElement(By.xpath("//button[contains(text(),'account')]")).click();*/

		//xpath - By Attribute
		/*driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test-from-xpath-attribute");*/

		//on FB == Forgotten account?
		/*driver.findElement(By.xpath("//a[contains(@href, 'recover/initiate?')]")).click();*/

		//xpath - starts with
		/*driver.findElement(By.xpath("//input[starts-with(@id, 'email')]")).sendKeys("xpath-starts with example");*/

		//xpath-following axes
		//input[@id='email']/following::*
		//input[@id='email']/following::tr
		//input[@id='email']/following::td/input[@id='pass']
		/*driver.findElement(By.xpath("//input[@id='email']/following::td/input[@id='pass']")).sendKeys("testpassword");*/

		//Following Sibling Axis
		//select[@id='month']/following-sibling::*
		//select[@id='month']/following-sibling::select
		//select[@id='month']/following-sibling::select[@id='year']


		//Preceding Sibling Axis
		//select[@id='year']/preceding-sibling::*
		//select[@id='year']/preceding-sibling::select
		//select[@id='year']/preceding-sibling::select[@id='day']


	}

	public void browserWindowSwtich(){
		// on https://www.edureka.co/
		driver.findElement(By.className("ga-linkedin")).click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(tabs.get(0));
		driver.close();

	}

	public void validationTest(){
		/*
		 * Execute this on https://www.facebook.com
		 * Validation List - 
		 * 1. Does Element Exists
		 * 2. Is Element editable
		 * 3. Radio button validation - Enabled/Selected
		 */
		driver.navigate().to("https://www.facebook.in");

		//get css value
		/*System.out.println(driver.findElement(By.className("loggedout_menubar_container")).getCssValue("color"));
				System.out.println(driver.findElement(By.id("u_0_11")).getCssValue("color"));*/

		//getting the text from hyperlink
		/*System.out.println(driver.findElement(By.id("u_0_11")).getText());*/


		//Element Exists
		try{
			WebElement radioButton = driver.findElement(By.id("u_0_6"));
			if (radioButton !=null)
				System.out.println("Radio button exists");
		}
		catch(Exception e){
			System.out.println("Element does not exist \n ");
			//			e.printStackTrace();
		}

		//Element Displayed
		WebElement radioButton = driver.findElement(By.id("u_0_6"));
		boolean exists = radioButton.isDisplayed();
		System.out.println("Radio button exists - "+exists);

		//Enabled
		boolean enabled = radioButton.isEnabled();
		System.out.println("Radio button enabled Before- "+enabled);


		//Selected
		//Before
		boolean selected = radioButton.isSelected();
		System.out.println("Radio button Selected (before clicking) - "+selected);
		//After
		radioButton.click();
		selected = radioButton.isSelected();
		System.out.println("Radio button Selected (after clicking) - "+selected);

		//Scroll Down
		//Executing on amazon.in		
		driver.navigate().to("https://www.amazon.in");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");

		//First name Text Box Value
		driver.navigate().to("https://www.facebook.com");
		WebElement firstName = driver.findElement(By.id("u_0_g"));
		String defaultValue = firstName.getAttribute("aria-label");
		System.out.println("Default Text Box value is - " +defaultValue);

		//text color
		String color = firstName.getCssValue("color");
		System.out.println("Text Box font color is - " + color);

	}

	public static void main(String[] args) {
		BasicExample driver = new BasicExample();
		//Allowed values for browser is chrome, ie, htmlunitdriver, firefox
		driver.openBrowser("chrome", "https://www.fb.com");
		//		driver.testBrowser();
		//		driver.testBrowserNavigate();
		//		driver.locatorTest();
		//		driver.browserWindowSwtich();
		//		driver.validationTest();
		//		driver.closeBrowser();

	}


}
