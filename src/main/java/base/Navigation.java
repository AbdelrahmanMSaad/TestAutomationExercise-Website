package base;

import org.openqa.selenium.WebDriver;
import pages.pages.*;
import utils.AutomatedActions;
import utils.Browsers;
import utils.Utilities;

import java.io.IOException;

public class Navigation extends Base{
    private static WebDriver webDriver;

    public Navigation(){
        Navigation.webDriver = Base.webDriver;
    }

    private static void initializeAutomatedActions(){
        new AutomatedActions(Base.webDriver);
    }

    private static void initializeNavigation(){
        new Navigation();
    }

    public static HomePage openHomePage() {
        try {
            Base.initializeConfigurations();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(Base.browser.equalsIgnoreCase(Browsers.chrome)){
            Base.webDriver = Utilities.openChrome();
        }else if(Base.browser.equalsIgnoreCase(Browsers.firefox)){
            Base.webDriver = Utilities.openFirefox();
        }

        Navigation.initializeNavigation();
        Navigation.initializeAutomatedActions();

        webDriver.get(Base.uRL);

        Utilities.maximizePage(webDriver);
        AutomatedActions.WaitAndVisibilityActions.setImplicitWait(webDriver,10);
        return new HomePage(Navigation.webDriver);
    }

    public static ProductsPage navigateToProductsPageFromHomePage(HomePage homePage){
        AutomatedActions.ClickingActions.clickOnElement(homePage.getElement(homePage.productsBtn));
        return new ProductsPage(Navigation.webDriver);
    }

    public static SignupLoginPage navigateToSignupLoginPageFromHomePage(HomePage homePage){
        AutomatedActions.ClickingActions.clickOnElement(homePage.getElement(homePage.singUpLoginBtn));
        return new SignupLoginPage(Navigation.webDriver);
    }

    public static SignupEnterAccountInfoPage navigateToSignupEnterAccountInfoPageFromSignupLoginPage(SignupLoginPage signupLoginPage){
        AutomatedActions.ClickingActions.clickOnElement(signupLoginPage.getElement(signupLoginPage.signupBtn));
        return new SignupEnterAccountInfoPage(Navigation.webDriver);
    }
    public static AccountCreatedPage navigateToAccountCreatedPageFromSignupEnterAccountInfoPage(SignupEnterAccountInfoPage signupEnterAccountInfoPage){
        AutomatedActions.ClickingActions.clickOnElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.submitBtn));
        return new AccountCreatedPage(Navigation.webDriver);
    }
    public static HomePage navigateToHomePageFromAccountCreatedPage(AccountCreatedPage accountCreatedPage){
        AutomatedActions.ClickingActions.clickOnElement(accountCreatedPage.getElement(accountCreatedPage.continueBtn));
        return new HomePage(Navigation.webDriver);
    }

    public static AccountDeletedPage navigateToAccountDeletedPageFromHomePage(HomePage homePage){
        AutomatedActions.ClickingActions.clickOnElement(homePage.getElement(homePage.deleteAccountBtn));
        return new AccountDeletedPage(Navigation.webDriver);
    }

    public static HomePage navigateToHomePageFromAccountDeletedPage(AccountDeletedPage accountDeletedPage){
        AutomatedActions.ClickingActions.clickOnElement(accountDeletedPage.getElement(accountDeletedPage.continueBtn));
        return new HomePage(Navigation.webDriver);
    }

    public static HomePage navigateToHomePageFromSignupLoginPage(SignupLoginPage signupLoginPage){
        AutomatedActions.ClickingActions.clickOnElement(signupLoginPage.getElement(signupLoginPage.loginBtn));
        return new HomePage(Navigation.webDriver);
    }

    public static void closeBrowser(){
        Navigation.webDriver.quit();
    }
}
