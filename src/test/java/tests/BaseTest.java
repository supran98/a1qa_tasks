package tests;

import UI.WebElements.Post;
import UI.WebPages.HomePage;
import Utils.BrowserUtils;
import org.testng.annotations.*;
import usermodel.User;

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
    @BeforeClass
    protected void openUserPage() {
        BrowserUtils.get(User.getHomepageUrl());
    }

}
