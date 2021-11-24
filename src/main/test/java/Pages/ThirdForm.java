package Pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ThirdForm extends Form {
    private static IElementFactory elementFactory = AqualityServices.getElementFactory();

    public ThirdForm() {
        super(By.xpath("//div[text() = '3 / 4']"), "page_indicator");
    }
}
