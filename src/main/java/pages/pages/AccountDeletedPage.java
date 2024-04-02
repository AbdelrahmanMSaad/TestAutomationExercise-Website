package pages.pages;
 
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AutomatedActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AccountDeletedPage extends Base {
    protected WebDriver webDriver;
    private final Map<String,By> elementsMap = new HashMap<>();


    public AccountDeletedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Base.pageLoadTimeoutDuration));
        this.defineAllElements();
    }
    
	private final By AccountDeletedText_xpath = By.xpath("//h2[contains(.,'Account Deleted!')]");
	public String AccountDeletedText = "AccountDeletedText";
  
	private final By continueBtn_xpath = By.xpath("//a[contains(@data-qa,'continue')]");
	public String continueBtn = "continueBtn";
  
	public WebElement getElement(String webElement){
		if (webElement.toLowerCase().contains("btn")){
			return AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeClickable(elementsMap.get(webElement));
		}else{
			return AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeVisible(elementsMap.get(webElement));
		}
	}
 
	private void defineAllElements() {
		this.elementsMap.put(AccountDeletedText, AccountDeletedText_xpath);
		this.elementsMap.put(continueBtn, continueBtn_xpath);
	}
 

	//Add Other Needed Methods Here

}