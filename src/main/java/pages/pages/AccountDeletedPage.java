package pages.pages;
 
import handlingConfigFile.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.pagesActions.AccountDeletedPageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AccountDeletedPage {
    protected WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public AccountDeletedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

   //Method to return the pageActions
   public AccountDeletedPageActions accountDeletedPageActions(){
       	return new AccountDeletedPageActions(this.webDriver);
   	}
    
	private final By AccountDeletedText_xpath = By.xpath("//h2[contains(.,'Account Deleted!')]");
	public String AccountDeletedText = "AccountDeletedText";
  
	private final By continueBtn_xpath = By.xpath("//a[contains(@data-qa,'continue')]");
	public String continueBtn = "continueBtn";
  
 
	private void defineAllElements() {
		this.elementsMap.put(AccountDeletedText, AccountDeletedText_xpath);
		this.elementsMap.put(continueBtn, continueBtn_xpath);
	}
 

	//Add Other Needed Methods Here
}
