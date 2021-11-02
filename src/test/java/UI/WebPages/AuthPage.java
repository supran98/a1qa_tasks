package UI.WebPages;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AuthPage {
    private final String login_field_xpath = "//input[@id = 'index_email']";
    private final String password_field_xpath = "//input[@id = 'index_pass']";
    private final String sign_in_btn_xpath = "//button[@id = 'index_login_button']";
    private WebElement login_field = BrowserUtils.getDriver().findElement(By.xpath(login_field_xpath));
    private WebElement password_field = BrowserUtils.getDriver().findElement(By.xpath(password_field_xpath));
    private WebElement sign_in_btn = BrowserUtils.getDriver().findElement(By.xpath(sign_in_btn_xpath));

    public boolean isDisplayed() {
        return sign_in_btn.isDisplayed();
    }
    public void enterLogin(String login) {
        login_field.sendKeys(login);
    }
    public void enterPassword(String password) {
        password_field.sendKeys(password);
    }
    public void clickSignInBtn() {
        sign_in_btn.click();
    }
}
