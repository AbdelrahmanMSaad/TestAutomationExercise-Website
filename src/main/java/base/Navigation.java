package base;

import getDirectories.GetDirectories;
import handlingConfigFile.Config;
import initializers.Initializers;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.pages.*;
import AutomatedActions.AutomatedActions;
import Browsers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Navigation {
    protected WebDriver webDriver;
    public Navigation(){
    }

    public HomePage openHomePage() {
        Initializers.initializeConfigFile();
        if(Config.browser.equalsIgnoreCase(Browsers.chrome)){
            this.webDriver = OpenBrowsers.openChrome();
        }else if(Config.browser.equalsIgnoreCase(Browsers.firefox)){
            this.webDriver = OpenBrowsers.openFirefox();
        }
        new Initializers();
        AutomatedActions automatedActions = new AutomatedActions(this.webDriver);
        automatedActions.waitAndVisibilityActions().setImplicitWait();
        automatedActions.browsersActions().maximizeBrowserPage();
        automatedActions.browsersActions().openURL(Config.uRL);
        return new HomePage(this.webDriver);
    }

    public ProductsPage navigateToProductsPageFromHomePage(HomePage homePage){
        return homePage.homePageActions().clickOnProductsBtn();
    }

    public SignupLoginPage navigateToSignupLoginPageFromHomePage(HomePage homePage){
        return homePage.homePageActions().clickOnSignUpLoginBtn();
    }

    public AccountDeletedPage navigateToAccountDeletedPageFromHomePage(HomePage homePage){
        return homePage.homePageActions().clickOnDeleteAccountPage();
    }

    public SignupLoginPage navigateToSignupLoginPageAfterLogoutFromHomePage(HomePage homePage) {
        return homePage.homePageActions().clickOnLogoutBtn();
    }

    public SignupEnterAccountInfoPage navigateToSignupEnterAccountInfoPageFromSignupLoginPage(SignupLoginPage signupLoginPage){
        return signupLoginPage.signupLoginPageActions().clickOnSignupBtn();
    }
    public AccountCreatedPage navigateToAccountCreatedPageFromSignupEnterAccountInfoPage(SignupEnterAccountInfoPage signupEnterAccountInfoPage){
        return signupEnterAccountInfoPage.signupEnterAccountInfoPageActions().clickOnSubmitBtn();
    }
    public HomePage navigateToHomePageFromAccountCreatedPage(AccountCreatedPage accountCreatedPage){
        return accountCreatedPage.accountCreatedPageActions().clickOnContinueBtn();
    }

    public HomePage navigateToHomePageFromAccountDeletedPage(AccountDeletedPage accountDeletedPage){
        return accountDeletedPage.accountDeletedPageActions().clickOnContinueBtn();
    }

    public HomePage navigateToHomePageFromSignupLoginPageAfterLogin(SignupLoginPage signupLoginPage){
        return signupLoginPage.signupLoginPageActions().clickOnLoginBtn();
    }

    public void closeBrowser(){
        try {
            if (this.webDriver != null) {
                this.webDriver.quit(); // Close the browser window and terminate the WebDriver session
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during shutdown
            System.err.println("Error occurred during browser shutdown: " + e.getMessage());
        }
    }

    public void takeScreenShot(String testName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String screenshotDestPath = GetDirectories.getScreenshotsDirectory() + File.separator + screenshotName;
        File screenshotFile = ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(screenshotFile.toPath(), Paths.get(screenshotDestPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.BYTES);
    }

}
