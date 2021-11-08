package tests;

import Utils.BrowserUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Repeater implements IRetryAnalyzer {
    private static boolean refreshed = false;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (refreshed)
            return false;
        else {
            BrowserUtils.getDriver().navigate().refresh();
            refreshed = true;
            return true;
        }
    }
}
