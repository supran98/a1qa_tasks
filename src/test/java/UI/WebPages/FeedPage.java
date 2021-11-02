package UI.WebPages;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FeedPage {
    private final String locator = "//nav[@class = 'side_bar_nav']";
    private WebElement sidebar = BrowserUtils.getDriver().findElement(By.xpath(locator));
    public boolean isDisplayed() {
        return sidebar.isDisplayed();
    }
}
