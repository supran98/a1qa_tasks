package tests;

import Utils.BrowserUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    private void setUp() {
        BrowserUtils.initDriver();
    }
    @AfterSuite
    private void tearDown() {
        BrowserUtils.quitDriver();
    }
}
