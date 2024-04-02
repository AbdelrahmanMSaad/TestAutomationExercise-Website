package testCases;

import base.Navigation;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.pages.*;
import utils.AutomatedActions;
import utils.TestCaseData;
import utils.Utilities;

public class TestAutomationExercise extends BaseTest{
    SoftAssert softAssert = new SoftAssert();

    protected HomePage homePage;
    protected SignupLoginPage signupLoginPage;
    protected SignupEnterAccountInfoPage signupEnterAccountInfoPage;
    protected AccountCreatedPage accountCreatedPage;
    protected AccountDeletedPage accountDeletedPage;

    @Test
    public void test_1(){
        TestCaseData testCase = Utilities.getTestCase("test_1");
        assert testCase != null;

        homePage = Navigation.openHomePage();
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.webSiteLogo)));
        signupLoginPage = Navigation.navigateToSignupLoginPageFromHomePage(homePage);
        AutomatedActions.TextActions.sendTextToElement(signupLoginPage.getElement(signupLoginPage.signupNameInput),testCase.getName());
        AutomatedActions.TextActions.sendTextToElement(signupLoginPage.getElement(signupLoginPage.signupEmailInput),testCase.getEmail());
        signupEnterAccountInfoPage = Navigation.navigateToSignupEnterAccountInfoPageFromSignupLoginPage(signupLoginPage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.enterAccountInfoText)));
        AutomatedActions.ClickingActions.clickOnElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.mrRadioBtn));
        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.passwordInput),testCase.getPassword());

        AutomatedActions.DropdownListActions.selectAnOptionFromADropdownList(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.daysDropdownList),testCase.getBirthDay());
        AutomatedActions.DropdownListActions.selectAnOptionFromADropdownList(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.monthsDropdownList),testCase.getBirthMonth());
        AutomatedActions.DropdownListActions.selectAnOptionFromADropdownList(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.yearsDropdownList),testCase.getBirthYear());
        AutomatedActions.ClickingActions.clickOnElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.newsletterCheckbox));
        AutomatedActions.ClickingActions.clickOnElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.receiveOffersCheckbox));

        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.firstNameInput),testCase.getFirstName());
        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.lastNameInput),testCase.getLastName());
        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.companyInput),testCase.getCompany());
        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.address1Input),testCase.getAddress1());
        AutomatedActions.DropdownListActions.selectAnOptionFromADropdownList(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.countryDropdownList),testCase.getCountry());
        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.stateInput),testCase.getState());
        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.cityInput),testCase.getCity());
        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.zipcodeInput),testCase.getZipcode());
        AutomatedActions.TextActions.sendTextToElement(signupEnterAccountInfoPage.getElement(signupEnterAccountInfoPage.mobileNumberInput),testCase.getMobile());

        accountCreatedPage = Navigation.navigateToAccountCreatedPageFromSignupEnterAccountInfoPage(signupEnterAccountInfoPage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(accountCreatedPage.getElement(accountCreatedPage.AccountCreatedText)));

        homePage = Navigation.navigateToHomePageFromAccountCreatedPage(accountCreatedPage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.webSiteLogo)));
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.loggedInAsText)));

        accountDeletedPage = Navigation.navigateToAccountDeletedPageFromHomePage(homePage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(accountDeletedPage.getElement(accountDeletedPage.AccountDeletedText)));

        homePage = Navigation.navigateToHomePageFromAccountDeletedPage(accountDeletedPage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.webSiteLogo)));
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.singUpLoginBtn)));
        softAssert.assertAll();
    }


}
