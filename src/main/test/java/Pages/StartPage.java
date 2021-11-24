package Pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class StartPage extends Form {
    private final String start_link_xpath = "//a[@class = 'start__link']";
    private IElementFactory elementFactory = AqualityServices.getElementFactory();

    public StartPage() {
        super(By.xpath("//p[contains(text(), 'Hi and welcome')]"), "page_indicator");
    }

    public void startSession() {
        elementFactory.getLink(By.xpath(start_link_xpath), "start_link").click();
    }
}
