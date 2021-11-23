package tests;

import Utils.BrowserUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setUp() {
        BrowserUtils.maximize();
    }
    @AfterSuite
    public void tearDown() {
        BrowserUtils.quit();
    }
}
