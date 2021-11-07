package tests;

import UI.WebPages.AuthPage;
import UI.WebPages.FeedPage;
import Utils.BrowserUtils;
import Utils.Config;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import usermodel.User;

public class AuthTest {
    @Test
    public void authTest() {
        AuthPage auth_page = new AuthPage();

        Assert.assertTrue(auth_page.isDisplayed(), "Auth page not displayed\n");
        auth_page.enterLogin(User.getLogin());
        auth_page.enterPassword(User.getPassword());
        auth_page.clickSignInBtn();

        FeedPage feed = new FeedPage();
        Assert.assertTrue(feed.isDisplayed(), "Authentication failed\n");
    }
    @BeforeClass
    private void openAuthPage() {
        BrowserUtils.get(Config.get("AuthTest.auth_url"));
    }
}
