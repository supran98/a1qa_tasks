package pages;

import Utils.Config;
import Utils.StaticMap;
import Utils.Waiters;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CompareTrimsPage extends Form {
    private static final String page_indicator_xpath = "//div[@class = 'trims-description']";
    private final String show_specifications_btn_xpath =
            "(//button[@class = 'sds-accordion__trigger js-accordion-trigger'])[1]"; // upper button with pull-out section
    private final String engine_info_xpath =
            "(//td[contains(text(), '-hp') or contains(text(), '-liter') or contains(text(), 'Engine')])[1]";
    private final String transmission_info_xpath =
            "(//td[contains(text(), '/T')  or contains(text(), 'CVT') or contains(text(), '-Speed')])[1]";
    private final String trim_name_xpath = "(//div[@class = 'table-container']//td)[1]";

    private IElementFactory factory = AqualityServices.getElementFactory();
    private IButton show_specs_btn = factory.getButton(By.xpath(show_specifications_btn_xpath), "show_specs_btn");
    private String trim_name;
    private String engine_info;
    private String tm_info;

    private final int wait_duration = Integer.parseInt(Config.getProperty("wait_element_timeout"));
    private final int wait_interval = Integer.parseInt(Config.getProperty("wait_element_interval"));

    public CompareTrimsPage() {
        super(By.xpath(page_indicator_xpath), "compare_trims_page");
    }
    public void setSpecs() {
        show_specs_btn.click();
        trim_name = factory.getLabel(By.xpath(trim_name_xpath), "trim_name").getText();
        engine_info = factory.getLabel(By.xpath(engine_info_xpath), "engine_info").getText();
        tm_info = factory.getLabel(By.xpath(transmission_info_xpath), "tm_info").getText();
        saveSpecs();
    }

    private void saveSpecs() {
        StaticMap.put("trim", trim_name);
        StaticMap.put("engine", engine_info);
        StaticMap.put("transmission", tm_info);
    }
    public boolean specsPresented() {
        return Waiters.waitForElementClickable(show_specs_btn, wait_duration, wait_interval);
    }
}
