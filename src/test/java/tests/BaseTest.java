package tests;

import Utils.BrowserUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    protected void setUp() {
        BrowserUtils.maximize();
    }
    @AfterSuite
    protected void tearDown() {
        BrowserUtils.quit();
    }
}
