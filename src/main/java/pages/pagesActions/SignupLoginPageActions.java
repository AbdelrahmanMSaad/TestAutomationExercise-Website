package pages.pagesActions;

import AutomatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pages.HomePage;
import pages.pages.SignupEnterAccountInfoPage;
import pages.pages.SignupLoginPage;

public class SignupLoginPageActions extends SignupLoginPage {
    private final AutomatedActions automatedActions;
    public SignupLoginPageActions(WebDriver webDriver) {
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

    public boolean isLoginTextDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.loginText));
    }

    public SignupLoginPageActions sendTextToLoginEmailInput(String email){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.loginEmailInput),email);
        return this;
    }

    public SignupLoginPageActions sendTextToLoginPasswordInput(String password){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.loginPasswordInput),password);
        return this;
    }

    public boolean isInvalidLoginTextDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.invalidLoginText));
    }

    public HomePage clickOnLoginBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.loginBtn));
        return new HomePage(this.webDriver);
    }

    public boolean isSignupTextDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.signupText));
    }

    public SignupLoginPageActions sendTextToSignupNameInput(String name){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.signupNameInput),name);
        return this;
    }

    public SignupLoginPageActions sendTextToSignupEmailInput(String email){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.signupEmailInput),email);
        return this;
    }

    public boolean isInvalidSignupTextDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.invalidSignupText));
    }

    public SignupEnterAccountInfoPage clickOnSignupBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.signupBtn));
        return new SignupEnterAccountInfoPage(this.webDriver);
    }
}
