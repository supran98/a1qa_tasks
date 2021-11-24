package tests;

import Pages.FirstForm;
import Pages.StartPage;
import Utils.Config;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test4 extends BaseTest {
    private final String url = Config.get("$.url");
    private final String initial_timer_value = "00:00:00";

    @Test
    public void Run() {
        AqualityServices.getBrowser().getDriver().get(url);
        StartPage start_page = new StartPage();
        Assert.assertTrue(start_page.state().isDisplayed(), "Start page not displayed\n");
        start_page.startSession();

        FirstForm first_form = new FirstForm();
        Assert.assertTrue(first_form.state().isDisplayed(), "First form not displayed\n");
        Assert.assertEquals(first_form.getTimerValue(), initial_timer_value, "Unexpected timer value returned\n");
    }
}
