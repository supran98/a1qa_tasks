package Pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import com.github.curiousoddman.rgxgen.RgxGen;
import org.openqa.selenium.By;

import java.time.Duration;

public class FirstForm {
    private static IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final String page_indicator_xpath = "//div[text() = '1 / 4']";
    private final String password_field_xpath = "//input[@placeholder = 'Choose Password']";
    private final String email_field_xpath = "//input[@placeholder = 'Your email']";
    private final String domain_field_xpath = "//input[@placeholder = 'Domain']";
    private final String combo_box_xpath = "//span[@class = 'icon icon-chevron-down']";
    private final String combo_box_item_xpath = "//div[@class = 'dropdown__list-item' and contains(text(), '.org')]";
    private final String check_box_xpath = "//span[@class = 'icon icon-check checkbox__check']";
    private final String next_form_link_xpath = "//a[@class = 'button--secondary']";
    protected final static String send_button_xpath = "//button[@class = 'button button--solid button--blue help-form__send-to-bottom-button']";
    protected final static String agree_cookies_btn_xpath = "//button[text() = 'Not really, no']";
    protected final static String timer_xpath = "//div[@class = 'timer timer--white timer--center']";

    private final String password_pattern = "[A-Z][a-z]{5}\\d{3}[а-я]";
    private final String password = new RgxGen(password_pattern).generate();
    private final String email_pattern = "mail" + password.charAt((int) (Math.random() * 5)); // contains one of first 5 password characters
    private final String email = new RgxGen(email_pattern).generate();
    private final String domain = "any";

    private final int wait_element_timeout = 15;
    private final int wait_element_interval = 1000;

    public boolean isDisplayed() {
        return elementFactory.getLabel(By.xpath(page_indicator_xpath), "indicator").state().isDisplayed();
    }
    public void fill() {
        elementFactory.getTextBox(By.xpath(password_field_xpath), "password_field").clearAndType(password);

        elementFactory.getTextBox(By.xpath(email_field_xpath), "email_field").clearAndType(email);

        elementFactory.getTextBox(By.xpath(domain_field_xpath), "domain_field").clearAndType(domain);

        elementFactory.getComboBox(By.xpath(combo_box_xpath), "combo_box").click();
        elementFactory.getLabel(By.xpath(combo_box_item_xpath), "cb_item").click();

        elementFactory.getCheckBox(By.xpath(check_box_xpath), "no_accept_checkbox").click();
    }
    public boolean hideHelpForm() {
        IButton send_button = elementFactory.getButton(By.xpath(send_button_xpath), "send_button");
        send_button.click();
        return AqualityServices.getConditionalWait().waitFor(() ->
                !send_button.state().isDisplayed(), Duration.ofSeconds(wait_element_timeout), Duration.ofMillis(wait_element_interval));
    }
    public boolean agreeCookies() {
        IButton agree_btn = elementFactory.getButton(By.xpath(agree_cookies_btn_xpath), "agree_btn");
        agree_btn.click();
        return AqualityServices.getConditionalWait().waitFor(() ->
                !agree_btn.state().isDisplayed(), Duration.ofSeconds(wait_element_timeout), Duration.ofMillis(wait_element_interval));
    }
    public String getTimerValue() {
        return elementFactory.getLabel(By.xpath(timer_xpath), "timer").getText();
    }
    public void goToNextForm() {
        elementFactory.getLink(By.xpath(next_form_link_xpath), "next_form_link").click();
    }
}
