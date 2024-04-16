package handlingTestData;

public class GetTestCase {
    public TestCaseData getTestCase(String testCaseName) {
        TestCaseData[] testCaseList = RetrieveAllTestCases.retrieveAllTestCases();
        assert testCaseList != null;
        for (TestCaseData testCase : testCaseList) {
            if (testCase.getTestCaseName().equals(testCaseName)) {
                return testCase;
            }
        }
        return null;
    }
}
