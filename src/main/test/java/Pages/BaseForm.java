package Pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import org.openqa.selenium.By;
import java.time.Duration;

public class BaseForm {
    protected static IElementFactory elementFactory = AqualityServices.getElementFactory();
    protected final static String send_button_xpath = "//button[@class = 'button button--solid button--blue help-form__send-to-bottom-button']";
    protected final static String agree_cookies_btn_xpath = "//button[text() = 'Not really, no']";
    protected final static String timer_xpath = "//div[@class = 'timer timer--white timer--center']";

    public boolean hideHelpForm() {
        IButton send_button = elementFactory.getButton(By.xpath(send_button_xpath), "send_button");
        send_button.click();
        return AqualityServices.getConditionalWait().waitFor(() ->
                !send_button.state().isDisplayed(), Duration.ofSeconds(15), Duration.ofMillis(1000));
    }
    public boolean agreeCookies() {
        IButton agree_btn = elementFactory.getButton(By.xpath(agree_cookies_btn_xpath), "agree_btn");
        agree_btn.click();
        return AqualityServices.getConditionalWait().waitFor(() ->
                !agree_btn.state().isDisplayed(), Duration.ofSeconds(10), Duration.ofMillis(1000));
    }
    public String getTimerValue() {
        return elementFactory.getLabel(By.xpath(timer_xpath), "timer").getText();
    }
}
