package pages.pages;
 
import base.Navigation;
import handlingConfigFile.Config;
import initializers.Initializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import AutomatedActions.AutomatedActions;
import pages.pagesActions.AccountCreatedPageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AccountCreatedPage{
    protected WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public AccountCreatedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

    public AccountCreatedPageActions accountCreatedPageActions(){
    	return new AccountCreatedPageActions(this.webDriver);
	}
    
	private final By AccountCreatedText_xpath = By.xpath("//h2[contains(.,'Account Created!')]");
	protected String AccountCreatedText = "AccountCreatedText";
  
	private final By continueBtn_xpath = By.xpath("//a[contains(@data-qa,'continue')]");
	protected String continueBtn = "continueBtn";
 
	private void defineAllElements() {
		this.elementsMap.put(AccountCreatedText, AccountCreatedText_xpath);
		this.elementsMap.put(continueBtn, continueBtn_xpath);
	}
 

	//Add Other Needed Methods Here
}
