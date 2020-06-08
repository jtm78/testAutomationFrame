package core.testNgListeners;

import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.*;

//ToDO for multithreating
@Log4j
public class ConsoleLogReporter implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testName = "Test " + "\"" + iTestResult.getInstanceName()
                + "." + iTestResult.getName() + "\"" + " Started";
        log.info(StringUtils.repeat("=", 40) + "START" + StringUtils.repeat("=", 40));
        log.info(testName);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        printResultOfTheTest(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        printResultOfTheTest(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
       printResultOfTheTest(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void printResultOfTheTest(ITestResult result){
        log.info(StringUtils.repeat("-", 85));
        if(result.getStatus() == ITestResult.SUCCESS) {
            log.info("PASSED");
        }
        else if (result.getStatus() == ITestResult.FAILURE) {
            log.info("FAILED");
            log.info(StringUtils.repeat("-", 85));
            log.error(result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            log.info("SKIPPED");
        }
        log.info(StringUtils.repeat("=", 40) + "FINISH" + StringUtils.repeat("=", 40));
    }
}
