package Pages;

import org.openqa.selenium.By;

public class Form3 extends BaseForm {
    private final String page_indicator_xpath = "//div[text() = '3 / 4']";

    public boolean isDisplayed() {
        return elementFactory.getLabel(By.xpath(page_indicator_xpath), "indicator").state().isDisplayed();
    }
}
