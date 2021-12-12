package tests.steps;

import Model.Car;
import Utils.Config;
import Utils.StaticMap;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import pages.*;

public class TestSteps {
    public static void selectCar(Car car) {
        while (true) {
            if (carFound()) {
                fillCarInfo(car);
                break;
            }
        }
    }
    private static boolean carFound() {
        AqualityServices.getBrowser().getDriver().get(Config.getProperty("homepage_url"));
        Homepage homepage = new Homepage();
        Assert.assertTrue(homepage.state().isDisplayed(), "Homepage not displayed\n");
        homepage.goToResearch();
        research();

        CarMainPage car_page = new CarMainPage();
        Assert.assertTrue(car_page.state().isDisplayed(), "Car page not displayed\n");
        while (!car_page.hasAvailableTrims()) {
            research();
        }

        car_page.goToTrim();
        return trimFound();
    }
    private static boolean trimFound() {
        TrimPage trimPage = new TrimPage();
        Assert.assertTrue(trimPage.state().isDisplayed(), "Trims page not displayed\n");
        trimPage.goToCompareTrims();

        CompareTrimsPage compare_trims_page = new CompareTrimsPage();
        if (compare_trims_page.specsPresented()) {
            compare_trims_page.setSpecs();
            return true;
        }
        else
            return false;
    }
    private static void research() {
        AqualityServices.getBrowser().getDriver().get(Config.getProperty("research_page_url"));

        ResearchPage research_page = new ResearchPage();
        Assert.assertTrue(research_page.state().isDisplayed(), "Research page not displayed\n");
        research_page.randomSearch();
        research_page.clickResearch();
    }
    private static void fillCarInfo(Car car) {
        car.setMake(StaticMap.get("make"));
        car.setModel(StaticMap.get("model"));
        car.setYear(StaticMap.get("year"));
        car.setTrim(StaticMap.get("trim"));
        car.setEngineInfo(StaticMap.get("engine"));
        car.setTmInfo(StaticMap.get("transmission"));
    }
}
