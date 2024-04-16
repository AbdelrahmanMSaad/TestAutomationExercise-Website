package testCases;

import handlingTestData.TestCaseData;
import io.qameta.allure.Step;

public class TestActions extends BaseTest{
    @Step("Fill in Signup Info")
    public void fillInSignupInfo(){
        signupLoginPage.signupLoginPageActions().
                sendTextToSignupNameInput(name).
                sendTextToSignupEmailInput(email);
    }

    @Step("Fill in Account Info")
    public void fillInAccountInfo(TestCaseData testCase) {
        signupEnterAccountInfoPage.signupEnterAccountInfoPageActions().
                clickOnMrRadioBtn().
                sendTextToPasswordInput(testCase.getPassword()).
                selectDayFromDaysDropdownList(testCase.getBirthDay()).
                selectMonthFromMonthsDropdownList(testCase.getBirthMonth()).
                selectYearFromYearsDropdownList(testCase.getBirthYear()).
                clickOnCheckNewsLetterCheckBox().
                clickOnReceiveOffersCheckbox().
                sendTextToFirstNameInput(testCase.getFirstName()).
                sendTextToLastNameInput(testCase.getLastName()).
                sendTextToCompanyInput(testCase.getCompany()).
                sendTextToAddress1Input(testCase.getAddress1()).
                selectCountryFromCountriesDropdownList(testCase.getCountry()).
                sendTextToStateInput(testCase.getState()).
                sendTextToCityInput(testCase.getCity()).
                sendTextToZipcodeInput(testCase.getZipcode()).
                sendTextToMobileInput(testCase.getMobile());
    }

    @Step("Delete Account")
    public void deleteAccount() {
        accountDeletedPage = navigation.navigateToAccountDeletedPageFromHomePage(homePage);
        softAssert.assertTrue(accountDeletedPage.accountDeletedPageActions().isAccountDeletedTextDisplayed());

        homePage = navigation.navigateToHomePageFromAccountDeletedPage(accountDeletedPage);
        softAssert.assertTrue(homePage.homePageActions().isWebsiteLogoDisplayed());
    }

    @Step("Create Account")
    public void createAccount(TestCaseData testCase) {
        softAssert.assertTrue(homePage.homePageActions().isWebsiteLogoDisplayed());

        signupLoginPage = navigation.navigateToSignupLoginPageFromHomePage(homePage);
        softAssert.assertTrue(signupLoginPage.signupLoginPageActions().isSignupTextDisplayed());

        fillInSignupInfo();

        signupEnterAccountInfoPage = navigation.navigateToSignupEnterAccountInfoPageFromSignupLoginPage(signupLoginPage);
        softAssert.assertTrue(signupEnterAccountInfoPage.signupEnterAccountInfoPageActions().isEnterAccountInfoTextDisplayed());

        fillInAccountInfo(testCase);

        accountCreatedPage = navigation.navigateToAccountCreatedPageFromSignupEnterAccountInfoPage(signupEnterAccountInfoPage);
        softAssert.assertTrue(accountCreatedPage.accountCreatedPageActions().isAccountCreatedTextDisplayed());

        homePage = navigation.navigateToHomePageFromAccountCreatedPage(accountCreatedPage);
        softAssert.assertTrue(homePage.homePageActions().isWebsiteLogoDisplayed());
        softAssert.assertTrue(homePage.homePageActions().isLoggedInAsTextDisplayed());
    }

    @Step("Login")
    public void login(TestCaseData testCase) {
        signupLoginPage = navigation.navigateToSignupLoginPageAfterLogoutFromHomePage(homePage);

        signupLoginPage.signupLoginPageActions().
                sendTextToLoginEmailInput(email).
                sendTextToLoginPasswordInput(testCase.getPassword());

        homePage = navigation.navigateToHomePageFromSignupLoginPageAfterLogin(signupLoginPage);
        softAssert.assertTrue(homePage.homePageActions().isWebsiteLogoDisplayed());
        softAssert.assertTrue(homePage.homePageActions().isLoggedInAsTextDisplayed());
    }

    @Step("Invalid Login")
    public void invalidLogin(TestCaseData testCase){
        signupLoginPage = navigation.navigateToSignupLoginPageFromHomePage(homePage);

        signupLoginPage.signupLoginPageActions().
                sendTextToLoginEmailInput(email).
                sendTextToLoginPasswordInput(testCase.getPassword());

        signupLoginPage.signupLoginPageActions().clickOnLoginBtn();
        softAssert.assertTrue(signupLoginPage.signupLoginPageActions().isInvalidLoginTextDisplayed());
    }

    @Step("Logout")
    public  void logout(){
        signupLoginPage = navigation.navigateToSignupLoginPageAfterLogoutFromHomePage(homePage);
        softAssert.assertTrue(signupLoginPage.signupLoginPageActions().isLoginTextDisplayed());
        softAssert.assertTrue(signupLoginPage.signupLoginPageActions().isSignupTextDisplayed());
    }
}
