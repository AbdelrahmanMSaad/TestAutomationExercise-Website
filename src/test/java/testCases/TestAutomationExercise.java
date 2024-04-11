package testCases;

import base.Navigation;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.pages.AccountCreatedPage;
import pages.pages.AccountDeletedPage;
import pages.pages.SignupEnterAccountInfoPage;
import pages.pages.SignupLoginPage;
import utils.AutomatedActions;
import utils.TestCaseData;
import utils.Utilities;

public class TestAutomationExercise extends BaseTest{
    SoftAssert softAssert = new SoftAssert();

    protected SignupLoginPage signupLoginPage;
    protected SignupEnterAccountInfoPage signupEnterAccountInfoPage;
    protected AccountCreatedPage accountCreatedPage;
    protected AccountDeletedPage accountDeletedPage;

    @Step("Create Account")
    public void createAccount(TestCaseData testCase){
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
    }

    @Step("Login")
    public void login(TestCaseData testCase){
        signupLoginPage = Navigation.navigateToSignupLoginPageFromHomePage(homePage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(signupLoginPage.getElement(signupLoginPage.loginText)));
        AutomatedActions.TextActions.sendTextToElement(signupLoginPage.getElement(signupLoginPage.loginEmailInput),testCase.getEmail());
        AutomatedActions.TextActions.sendTextToElement(signupLoginPage.getElement(signupLoginPage.loginPasswordInput),testCase.getPassword());

        homePage = Navigation.navigateToHomePageFromSignupLoginPage(signupLoginPage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.loggedInAsText)));
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.deleteAccountBtn)));
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.logoutBtn)));
    }

    @BeforeMethod
    public void setUp() {
        homePage = Navigation.openHomePage();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        Utilities.takeScreenShot(iTestResult.getName());
        Utilities.captureAndAttachScreenshot();
        Navigation.closeBrowser();
    }

    @Test
    @Description("Test Case 1: Register User")
    @Epic("EP001")
    public void test_1(){
        TestCaseData testCase = Utilities.getTestCase("test_1");
        assert testCase != null;

        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.webSiteLogo)));

        createAccount(testCase);

        accountDeletedPage = Navigation.navigateToAccountDeletedPageFromHomePage(homePage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(accountDeletedPage.getElement(accountDeletedPage.AccountDeletedText)));

        homePage = Navigation.navigateToHomePageFromAccountDeletedPage(accountDeletedPage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.webSiteLogo)));
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.singUpLoginBtn)));
        softAssert.assertAll();
    }

    @Test
    @Description("Test Case 2: Login User with correct email and password")
    @Epic("EP001")
    public void test_2(){
        TestCaseData testCase = Utilities.getTestCase("test_2");
        assert testCase != null;
        createAccount(testCase);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.webSiteLogo)));
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.loggedInAsText)));

        AutomatedActions.ClickingActions.clickOnElement(homePage.getElement(homePage.logoutBtn));

        login(testCase);

        accountDeletedPage = Navigation.navigateToAccountDeletedPageFromHomePage(homePage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(accountDeletedPage.getElement(accountDeletedPage.AccountDeletedText)));

        homePage = Navigation.navigateToHomePageFromAccountDeletedPage(accountDeletedPage);
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.webSiteLogo)));
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(homePage.getElement(homePage.singUpLoginBtn)));

        softAssert.assertAll();
    }

    @Test
    @Description("Test Case 3: Login User with incorrect email and password")
    @Epic("EP002")
    public void test_3(){
        TestCaseData testCaseData = Utilities.getTestCase("test_3");
        assert testCaseData != null;

        signupLoginPage = Navigation.navigateToSignupLoginPageFromHomePage(homePage);
        AutomatedActions.TextActions.sendTextToElement(signupLoginPage.getElement(signupLoginPage.loginEmailInput),testCaseData.getEmail());
        AutomatedActions.TextActions.sendTextToElement(signupLoginPage.getElement(signupLoginPage.loginPasswordInput),testCaseData.getPassword());
        AutomatedActions.ClickingActions.clickOnElement(signupLoginPage.getElement(signupLoginPage.loginBtn));
        softAssert.assertTrue(AutomatedActions.WaitAndVisibilityActions.isWebElementDisplayed(signupLoginPage.getElement(signupLoginPage.invalidLoginText)));

    }




}
