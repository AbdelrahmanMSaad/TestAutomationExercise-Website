package pages.pagesActions;

import AutomatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pages.AccountDeletedPage;
import pages.pages.HomePage;
import pages.pages.ProductsPage;
import pages.pages.SignupLoginPage;

public class HomePageActions extends HomePage {
    private final AutomatedActions automatedActions;

    public HomePageActions(WebDriver webDriver) {
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

    //Add Your Methods Here

    public boolean isWebsiteLogoDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.webSiteLogo));
    }

    public HomePageActions clickOnHomeBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.homeBtn));
        return new HomePageActions(this.webDriver);
    }

    public ProductsPage clickOnProductsBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.productsBtn));
        return new ProductsPage(this.webDriver);
    }

    public void clickOnCartBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.cartBtn));
    }

    public SignupLoginPage clickOnSignUpLoginBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.singUpLoginBtn));
        return new SignupLoginPage(this.webDriver);
    }

    public SignupLoginPage clickOnLogoutBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.logoutBtn));
        return new SignupLoginPage(this.webDriver);
    }

    public AccountDeletedPage clickOnDeleteAccountPage(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.deleteAccountBtn));
        return new AccountDeletedPage(this.webDriver);
    }

    public boolean isLoggedInAsTextDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.loggedInAsText));
    }



}
