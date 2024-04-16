package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import handlingTestData.TestCaseData;

public class TestCases1 extends TestActions{
    @Test
    @Description("Test Case 1: Register User")
    @Epic("EP001")
    @Feature("Register")
    public void test_1(){
        TestCaseData testCase = getTestCase.getTestCase("test_1");
        assert testCase != null;
        createAccount(testCase);
        deleteAccount();
        softAssert.assertAll();
    }

    @Test
    @Description("Test Case 2: Login User with correct email and password")
    @Epic("EP001")
    @Feature("Login")
    public void test_2(){
        TestCaseData testCase = getTestCase.getTestCase("test_2");
        assert testCase != null;
        createAccount(testCase);
        login(testCase);
        deleteAccount();
        softAssert.assertAll();
    }

    @Test
    @Description("Test Case 3: Login User with incorrect email and password")
    @Epic("EP002")
    @Feature("Login")
    public void test_3(){
        TestCaseData testCase = getTestCase.getTestCase("test_3");
        assert testCase != null;
        invalidLogin(testCase);
    }
}
