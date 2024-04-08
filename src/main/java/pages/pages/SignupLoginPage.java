package pages.pages;
 
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AutomatedActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SignupLoginPage extends Base {
    protected WebDriver webDriver;
    private final Map<String,By> elementsMap = new HashMap<>();


    public SignupLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Base.pageLoadTimeoutDuration));
        this.defineAllElements();
    }
    
	private final By loginText_xpath = By.xpath("//h2[contains(text(),'Login to your account')]");
	public String loginText = "loginText";
  
	private final By loginEmailInput_xpath = By.xpath("//input[contains(@data-qa,'login-email')]");
	public String loginEmailInput = "loginEmailInput";
  
	private final By loginPasswordInput_xpath = By.xpath("//input[contains(@data-qa,'login-password')]");
	public String loginPasswordInput = "loginPasswordInput";
  
	private final By loginBtn_xpath = By.xpath("//button[contains(@data-qa,'login-button')]");
	public String loginBtn = "loginBtn";
  
	private final By signupText_xpath = By.xpath("//h2[contains(text(),'New User Signup!')]");
	public String signupText = "signupText";
  
	private final By signupNameInput_xpath = By.xpath("//input[contains(@data-qa,'signup-name')]");
	public String signupNameInput = "signupNameInput";
  
	private final By signupEmailInput_xpath = By.xpath("//input[contains(@data-qa,'signup-email')]");
	public String signupEmailInput = "signupEmailInput";
  
	private final By signupBtn_xpath = By.xpath("//button[contains(@data-qa,'signup-button')]");
	public String signupBtn = "signupBtn";
  
	private final By invalidLoginText_xpath = By.xpath("//p[contains(@style,'red')][contains(.,'Your email or password is incorrect!')]");
	public String invalidLoginText = "invalidLoginText";
  
	private final By invalidSignupText_xpath = By.xpath("//p[contains(@style,'red')][contains(.,'Email Address already exist!')]");
	public String invalidSignupText = "invalidSignupText";
  
	public WebElement getElement(String elementKey) {
		By elementLocator = elementsMap.get(elementKey);
		if (elementLocator != null) {
			return elementKey.toLowerCase().contains("btn") ?
				AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeClickable(elementLocator) :
				AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeVisible(elementLocator);
			}
		return null;
	}
 
	private void defineAllElements() {
		this.elementsMap.put(loginText, loginText_xpath);
		this.elementsMap.put(loginEmailInput, loginEmailInput_xpath);
		this.elementsMap.put(loginPasswordInput, loginPasswordInput_xpath);
		this.elementsMap.put(loginBtn, loginBtn_xpath);
		this.elementsMap.put(signupText, signupText_xpath);
		this.elementsMap.put(signupNameInput, signupNameInput_xpath);
		this.elementsMap.put(signupEmailInput, signupEmailInput_xpath);
		this.elementsMap.put(signupBtn, signupBtn_xpath);
		this.elementsMap.put(invalidLoginText, invalidLoginText_xpath);
		this.elementsMap.put(invalidSignupText, invalidSignupText_xpath);
	}
 

	//Add Other Needed Methods Here

}