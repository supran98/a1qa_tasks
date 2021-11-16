package tests;

import Pages.Form1;
import Pages.Form2;
import Pages.Form3;
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
        Assert.assertTrue(start_page.isDisplayed(), "Start page not displayed\n");
        start_page.startSession();

        Form1 form1 = new Form1();
        Assert.assertTrue(form1.isDisplayed(), "First form not displayed\n");
        form1.fill();
        form1.goToNextForm();

        Form2 form2 = new Form2();
        Assert.assertTrue(form2.isDisplayed(), "Second form not displayed\n");
        form2.ChooseInterests();
        form2.upload_avatar();
        form2.goToNextForm();

        Form3 form3 = new Form3();
        Assert.assertTrue(form3.isDisplayed(), "Third form not displayed\n");
    }
}
