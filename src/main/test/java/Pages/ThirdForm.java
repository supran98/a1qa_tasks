package Pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import org.openqa.selenium.By;

public class ThirdForm {
    private static IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final String page_indicator_xpath = "//div[text() = '3 / 4']";

    public boolean isDisplayed() {
        return elementFactory.getLabel(By.xpath(page_indicator_xpath), "indicator").state().isDisplayed();
    }
}
