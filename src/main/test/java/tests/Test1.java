package tests;

import Pages.FirstForm;
import Pages.SecondForm;
import Pages.ThirdForm;
import Pages.StartPage;
import Utils.Config;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {
    private final String url = Config.get("$.url");

    @Test
    public void Run() {
        StartPage start_page = new StartPage();
        AqualityServices.getBrowser().getDriver().get(url);
        Assert.assertTrue(start_page.state().isDisplayed(), "Start page not displayed\n");
        start_page.startSession();

        FirstForm first_form = new FirstForm();
        Assert.assertTrue(first_form.state().isDisplayed(), "First form not displayed\n");
        first_form.fill();
        first_form.goToNextForm();

        SecondForm second_form = new SecondForm();
        Assert.assertTrue(second_form.state().isDisplayed(), "Second form not displayed\n");
        second_form.ChooseInterests();
        second_form.upload_avatar();
        second_form.goToNextForm();

        ThirdForm third_form = new ThirdForm();
        Assert.assertTrue(third_form.state().isDisplayed(), "Third form not displayed\n");
    }
}
