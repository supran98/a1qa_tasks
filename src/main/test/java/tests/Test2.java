package tests;

import Pages.Form1;
import Pages.StartPage;
import Utils.Config;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 extends BaseTest {
    private final String url = Config.get("$.url");

    @Test
    public void Run() {
        AqualityServices.getBrowser().getDriver().get(url);
        StartPage start_page = new StartPage();
        Assert.assertTrue(start_page.isDisplayed(), "Start page not displayed\n");
        start_page.startSession();

        Form1 form1 = new Form1();
        Assert.assertTrue(form1.isDisplayed(), "First form not displayed\n");
        Assert.assertTrue(form1.hideHelpForm(), "Help form not hidden\n");
    }
}
