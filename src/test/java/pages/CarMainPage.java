package pages;

import Utils.StaticMap;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CarMainPage extends Form {
    private IElementFactory factory = AqualityServices.getElementFactory();

    private static final String page_indicator_xpath = "//h1[contains(text(), '%s %s %s')]";
    private final String base_trim_link_xpath = "(//ul[@class = 'trim-compare-list']//a)[1]";
    private final String no_cars_found_lbl_xpath = "//div[@class = 'sds-notification__title']";
    private final String one_trim_lbl_xpath = "//h2[text() = ' 1 trim ']";

    ILink trim_link = factory.getLink(By.xpath(base_trim_link_xpath), "base_trim_link");
    ILabel no_cars_found_lbl = factory.getLabel(By.xpath(no_cars_found_lbl_xpath), "no_cars_found_lbl");
    ILabel one_trim = factory.getLabel(By.xpath(one_trim_lbl_xpath), "one_trim_available");

    public CarMainPage() {
        super(By.xpath(String.format(page_indicator_xpath,
                StaticMap.get("year"), StaticMap.get("make"), StaticMap.get("model"))), "car_main_page");
    }
    public boolean hasAvailableTrims() {
        if (!trim_link.state().isClickable() || no_cars_found_lbl.state().isDisplayed() || one_trim.state().isDisplayed()) // one trim -> no trim comparison
            return false;
        else
            return true;
    }
    public void goToTrim() {
        factory.getLink(By.xpath(base_trim_link_xpath), "base_trim_link").click();
    }
}
