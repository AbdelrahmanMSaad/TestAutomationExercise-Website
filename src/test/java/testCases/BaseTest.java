package testCases;

import base.Navigation;
import handlingTestData.GetTestCase;
import handlingTestData.TestCaseData;
import io.qameta.allure.Step;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.pages.*;
import utils.Utilities;

public class BaseTest {
    String name = Utilities.generateRandomString(),
            email = Utilities.generateRandomString() + "@" + Utilities.generateRandomString() + ".com";

    protected Navigation navigation;
    protected GetTestCase getTestCase;

    protected SoftAssert softAssert;

    protected static HomePage homePage;
    protected SignupLoginPage signupLoginPage;
    protected SignupEnterAccountInfoPage signupEnterAccountInfoPage;
    protected AccountCreatedPage accountCreatedPage;
    protected AccountDeletedPage accountDeletedPage;

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        getTestCase = new GetTestCase();
        navigation = new Navigation();
        homePage = navigation.openHomePage();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        softAssert.assertAll();
        navigation.takeScreenShot(iTestResult.getName());
        navigation.attachScreenshot();
        navigation.closeBrowser();
    }
}
