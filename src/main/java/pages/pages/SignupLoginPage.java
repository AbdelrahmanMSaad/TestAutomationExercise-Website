package pages.pages;
 
import base.Navigation;
import handlingConfigFile.Config;
import initializers.Initializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import AutomatedActions.AutomatedActions;
import pages.pagesActions.SignupLoginPageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SignupLoginPage {
    protected WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public SignupLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

    public SignupLoginPageActions signupLoginPageActions(){
    	return new SignupLoginPageActions(this.webDriver);
	}
    
	private final By loginText_xpath = By.xpath("//h2[contains(text(),'Login to your account')]");
	protected String loginText = "loginText";
  
	private final By loginEmailInput_xpath = By.xpath("//input[contains(@data-qa,'login-email')]");
	protected String loginEmailInput = "loginEmailInput";
  
	private final By loginPasswordInput_xpath = By.xpath("//input[contains(@data-qa,'login-password')]");
	protected String loginPasswordInput = "loginPasswordInput";
  
	private final By loginBtn_xpath = By.xpath("//button[contains(@data-qa,'login-button')]");
	protected String loginBtn = "loginBtn";
  
	private final By signupText_xpath = By.xpath("//h2[contains(text(),'New User Signup!')]");
	protected String signupText = "signupText";
  
	private final By signupNameInput_xpath = By.xpath("//input[contains(@data-qa,'signup-name')]");
	protected String signupNameInput = "signupNameInput";
  
	private final By signupEmailInput_xpath = By.xpath("//input[contains(@data-qa,'signup-email')]");
	protected String signupEmailInput = "signupEmailInput";
  
	private final By signupBtn_xpath = By.xpath("//button[contains(@data-qa,'signup-button')]");
	protected String signupBtn = "signupBtn";
  
	private final By invalidLoginText_xpath = By.xpath("//p[contains(@style,'red')][contains(.,'Your email or password is incorrect!')]");
	protected String invalidLoginText = "invalidLoginText";
  
	private final By invalidSignupText_xpath = By.xpath("//p[contains(@style,'red')][contains(.,'Email Address already exist!')]");
	protected String invalidSignupText = "invalidSignupText";
 
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
