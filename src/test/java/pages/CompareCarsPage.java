package pages;

import Model.Car;
import Utils.Config;
import Utils.Waiters;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CompareCarsPage extends Form {
    private IElementFactory factory = AqualityServices.getElementFactory();

    private static final String page_indicator_xpath = "//*[text() = 'Choose cars to compare, or check out our popular comparisons.']";
    private final String add_car_link_xpath = "(//a[@class = 'add-car'])[%s]";;
    private final String make_cb_xpath = "//select[@id = 'vehicle_selection_make']";
    private final String model_cb_xpath = "//select[@id = 'vehicle_selection_model']";
    private final String year_cb_xpath = "//select[@id = 'vehicle_selection_year']";
    private final String trim_cb_xpath = "//select[@id = 'vehicle_selection_trim']";
    private final String add_to_compare_btn_xpath = "//button[text() = 'Add car to comparison']";
    private final String compare_btn_xpath = "//button[text() = 'See the comparison']";
    private final String overview_lbl_xpath = "//h2[text() = 'Overview']";
    private final String engine_info_xpath =
            "(//td[contains(p, '-liter') or contains(p, '-hp') or contains(p, 'Engine')])[%s]";
    private final String transmission_info_xpath =
            "(//td[contains(p, '/T') or contains(p, '-Speed') or contains(p, 'CVT')])[%s]//p";

    private IButton add_to_compare_btn = factory.getButton(By.xpath(add_to_compare_btn_xpath), "add_to_compare_btn");
    private IButton compare_btn = factory.getButton(By.xpath(compare_btn_xpath), "compare_btn");
    private IComboBox make_cb = factory.getComboBox(By.xpath(make_cb_xpath), "make_cb");
    private IComboBox model_cb = factory.getComboBox(By.xpath(model_cb_xpath), "model_cb");
    private IComboBox year_cb = factory.getComboBox(By.xpath(year_cb_xpath), "year_cb");
    private IComboBox trim_cb = factory.getComboBox(By.xpath(trim_cb_xpath), "trim_cb");
    private ILabel overview_lbl = factory.getLabel(By.xpath(overview_lbl_xpath), "overview_lbl");

    private int wait_duration = Integer.parseInt(Config.getProperty("wait_element_timeout"));
    private int wait_interval = Integer.parseInt(Config.getProperty("wait_element_interval"));

    public CompareCarsPage() {
        super(By.xpath(page_indicator_xpath), "compare_cars_page");
    }
    public void addToComparison(Car car) {
        String locator = String.format(add_car_link_xpath, car.getId());
        factory.getLink(By.xpath(locator), "add_car_link").click();

        Waiters.waitForElementClickable(make_cb, wait_duration, wait_interval);
        make_cb.sendKeys(car.getMake());

        Waiters.waitForElementClickable(model_cb, wait_duration, wait_interval);
        model_cb.sendKeys(car.getModel());

        Waiters.waitForElementClickable(year_cb, wait_duration, wait_interval);
        year_cb.sendKeys(car.getYear());

        Waiters.waitForElementClickable(trim_cb, wait_duration, wait_interval);
        trim_cb.sendKeys(car.getTrim());

        Waiters.waitForElementClickable(add_to_compare_btn, wait_duration, wait_interval);
        add_to_compare_btn.click();
    }
    public void compare() {
        Waiters.waitForElementClickable(compare_btn, wait_duration, wait_interval);
        compare_btn.click();
    }
    public boolean carsSelected() {
        return Waiters.waitForElementDisplayed(overview_lbl, wait_duration, wait_interval);
    }
    public String getEngineInfoFor(Car car) {
        String locator = String.format(engine_info_xpath, car.getId());
        return factory.getLabel(By.xpath(locator), "engine_info_lbl").getText();
    }
    public String getTransmissionInfoFor(Car car) {
        String locator = String.format(transmission_info_xpath, car.getId());
        return factory.getLabel(By.xpath(locator), "transmission_info_lbl").getText();
    }
}
