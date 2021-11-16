package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setUp() {
        AqualityServices.getBrowser().maximize();
    }
    @AfterSuite
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
