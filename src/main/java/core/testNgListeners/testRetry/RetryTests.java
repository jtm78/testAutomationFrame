package core.testNgListeners.testRetry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTests implements IRetryAnalyzer {
    private final int countOfRetry = 3;
    private int count = 0;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (iTestResult.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(UnstableTest.class)) {
            if (count < countOfRetry) {
                count++;
                return true;
            }
        }
        return false;
    }
}
