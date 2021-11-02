package tests;

import UI.WebPages.AuthPage;
import UI.WebPages.FeedPage;
import Utils.BrowserUtils;
import Utils.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {
    @Test
    public void authTest() {
        BrowserUtils.get(Config.get("AuthTest.auth_url"));
        AuthPage auth_page = new AuthPage();

        Assert.assertTrue(auth_page.isDisplayed(), "Auth page not displayed");
        auth_page.enterLogin(Config.get("test_user2.login", Config.getProperty("credentials")));
        auth_page.enterPassword(Config.get("test_user2.password", Config.getProperty("credentials")));
        auth_page.clickSignInBtn();

        FeedPage feed = new FeedPage();
        Assert.assertTrue(feed.isDisplayed(), "Authentication failed\n");
    }
}
