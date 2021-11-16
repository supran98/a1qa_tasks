package Pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.waitings.ConditionalWait;
import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;

import java.time.Duration;

public class StartPage {
    private final String start_link_xpath = "//a[@class = 'start__link']";
    private final String welcome_lbl_xpath = "//p[contains(text(), 'Hi and welcome')]";
    private IElementFactory elementFactory = AqualityServices.getElementFactory();

    public void startSession() {
        elementFactory.getLink(By.xpath(start_link_xpath), "start_link").click();
    }
    public boolean isDisplayed() {
        return elementFactory.getLabel(By.xpath(welcome_lbl_xpath), "indicator").state().isDisplayed();
    }
}
