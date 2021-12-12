package pages;

import Utils.StaticMap;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TrimPage extends Form {
    private static final String page_indicator_xpath = "//h1[contains(text(), '%s %s %s')]";
    private final String trim_cmp_link_xpath = "//a[contains(text(),  'trim comparison')]";
    public TrimPage() {
        super(By.xpath(String.format(page_indicator_xpath,
                StaticMap.get("year"), StaticMap.get("make"), StaticMap.get("model"))), "trim_page");
    }
    public void goToCompareTrims() {
        AqualityServices.getElementFactory().getLink(By.xpath(trim_cmp_link_xpath), "trim_options_link").click();
    }
}
