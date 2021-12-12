package tests;

import Model.Car;
import Utils.Config;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import tests.steps.TestSteps;

public class CompareTest extends BaseTest {
    private Car original = new Car(1);
    private Car comparable = new Car(2);

    @Test
    public void Run() {
        TestSteps.selectCar(original);
        TestSteps.selectCar(comparable);

        AqualityServices.getBrowser().getDriver().get(Config.getProperty("research_page_url"));
        ResearchPage research_page = new ResearchPage();
        Assert.assertTrue(research_page.state().isDisplayed(), "Research page not displayed\n");
        research_page.goToCompare();

        CompareCarsPage compare_page = new CompareCarsPage();
        Assert.assertTrue(compare_page.state().isDisplayed(), "Compare page not displayed\n");

        compare_page.addToComparison(original);
        compare_page.addToComparison(comparable);
        compare_page.compare();
        Assert.assertTrue(compare_page.carsSelected(), "Models not selected / Overview not displayed\n");

        SoftAssert soft_assert = new SoftAssert();
        soft_assert.assertEquals(compare_page.getTransmissionInfoFor(original), original.getTmInfo(), "Not matching specifications\n");
        soft_assert.assertEquals(compare_page.getEngineInfoFor(original), original.getEngineInfo(), "Not matching specifications\n");
        soft_assert.assertEquals(compare_page.getTransmissionInfoFor(comparable), comparable.getTmInfo(), "Not matching specifications\n");
        soft_assert.assertEquals(compare_page.getEngineInfoFor(comparable), comparable.getEngineInfo(), "Not matching specifications\n");
        soft_assert.assertAll();
    }
}
