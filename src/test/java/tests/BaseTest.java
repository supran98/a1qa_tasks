package tests;

import UI.WebElements.Post;
import UI.WebPages.HomePage;
import Utils.BrowserUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static Post post;
    protected static HomePage home;
    @BeforeSuite
    protected void setUp() {
        BrowserUtils.initDriver();
    }
    @AfterSuite
    protected void tearDown() {
        BrowserUtils.quitDriver();
    }
}
