package pages.pagesActions;

import AutomatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pages.AccountDeletedPage;
import pages.pages.HomePage;

public class AccountDeletedPageActions extends AccountDeletedPage {
    private final AutomatedActions automatedActions;

    public AccountDeletedPageActions(WebDriver webDriver) {
        super(webDriver);
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    public WebElement getElement(String elementKey) {
        By elementLocator = super.elementsMap.get(elementKey);
        if (elementLocator != null) {
            return elementKey.toLowerCase().contains("btn") ?
                    automatedActions.waitAndVisibilityActions().waitForAnElementToBeClickable(elementLocator) :
                    automatedActions.waitAndVisibilityActions().waitForAnElementToBeVisible(elementLocator);
        }
        return null;
    }

    //Add your Methods Here

    public boolean isAccountDeletedTextDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.AccountDeletedText));
    }

    public HomePage clickOnContinueBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.continueBtn));
        return new HomePage(this.webDriver);
    }
}
