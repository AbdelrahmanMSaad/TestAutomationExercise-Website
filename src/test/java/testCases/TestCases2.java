package testCases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import handlingTestData.TestCaseData;

public class TestCases2 extends TestActions {
    @Test
    @Description("Test Case 4: Logout User")
    @Epic("EP002")
    @Feature("Logout")
    public void test_4(){
        TestCaseData testCase = getTestCase.getTestCase("test_4");
        assert testCase != null;
        createAccount(testCase);
        logout();
    }
}
