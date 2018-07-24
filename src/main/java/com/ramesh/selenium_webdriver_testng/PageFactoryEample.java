/*package selenium;

import org.testng.annotations.Test;

public class PageFactoryEample {
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(name = "login")
	public static WebElement usernameEditBox;
	
	    @FindBy(name = "pass")
	    public static WebElement passwordEditBox;
	
	    @FindBy(name = "btnlogin")
	    public static WebElement submitBtn;
	
	    @FindBy(xpath = "//span[text()=' Annn']")
	    public static WebElement verifyLogoinpage;
	    
	@Test   
	public HomePage login(String username1, String password1) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(usernameEditBox)).sendKeys(username1);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(passwordEditBox)).sendKeys(password1);
     	new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(submitBtn)).click();

        return new HomePage(driver);
}
*/