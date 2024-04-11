package allureListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListeners implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getName();
    }


}
