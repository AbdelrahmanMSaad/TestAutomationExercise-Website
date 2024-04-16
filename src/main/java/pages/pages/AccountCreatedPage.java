package pages.pages;
 
import handlingConfigFile.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.pagesActions.AccountCreatedPageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AccountCreatedPage {
    protected WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public AccountCreatedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

   //Method to return the pageActions
   public AccountCreatedPageActions accountCreatedPageActions(){
       	return new AccountCreatedPageActions(this.webDriver);
   	}
    
	private final By AccountCreatedText_xpath = By.xpath("//h2[contains(.,'Account Created!')]");
	public String AccountCreatedText = "AccountCreatedText";
  
	private final By continueBtn_xpath = By.xpath("//a[contains(@data-qa,'continue')]");
	public String continueBtn = "continueBtn";
  
 
	private void defineAllElements() {
		this.elementsMap.put(AccountCreatedText, AccountCreatedText_xpath);
		this.elementsMap.put(continueBtn, continueBtn_xpath);
	}
 

	//Add Other Needed Methods Here
}
