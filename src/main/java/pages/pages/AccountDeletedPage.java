package pages.pages;
 
import base.Navigation;
import handlingConfigFile.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import AutomatedActions.AutomatedActions;
import pages.pagesActions.AccountDeletedPageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AccountDeletedPage {
    protected WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();
    private final AutomatedActions automatedActions;

    public AccountDeletedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
		this.automatedActions = new AutomatedActions(this.webDriver);
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

    public AccountDeletedPageActions accountDeletedPageActions(){
    	return new AccountDeletedPageActions(this.webDriver);
	}
    
	private final By AccountDeletedText_xpath = By.xpath("//h2[contains(.,'Account Deleted!')]");
	protected String AccountDeletedText = "AccountDeletedText";
  
	private final By continueBtn_xpath = By.xpath("//a[contains(@data-qa,'continue')]");
	protected String continueBtn = "continueBtn";
  
	public WebElement getElement(String elementKey) {
		By elementLocator = elementsMap.get(elementKey);
		if (elementLocator != null) {
			return elementKey.toLowerCase().contains("btn") ?
				automatedActions.waitAndVisibilityActions().waitForAnElementToBeClickable(elementLocator) :
				automatedActions.waitAndVisibilityActions().waitForAnElementToBeVisible(elementLocator);
			}
		return null;
	}
 
	private void defineAllElements() {
		this.elementsMap.put(AccountDeletedText, AccountDeletedText_xpath);
		this.elementsMap.put(continueBtn, continueBtn_xpath);
	}
 

	//Add Other Needed Methods Here
}
