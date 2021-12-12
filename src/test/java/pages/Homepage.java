package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class Homepage extends Form {
    private static final String page_indicator_xpath = "//*[text() = 'Trending content near you']";
    private String research_link_xpath = "//a[text() = 'Research & Reviews']";

    public Homepage() {
        super(By.xpath(page_indicator_xpath), "homepage");
    }
    public void goToResearch() {
        AqualityServices.getElementFactory().getLink(By.xpath(research_link_xpath), "research_link").click();
    }
}
