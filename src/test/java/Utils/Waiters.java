package Utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.interfaces.IElement;
import java.time.Duration;

public class Waiters {
    public static boolean waitForElementClickable(IElement element, int duration, int interval) {
        return AqualityServices.getConditionalWait().waitFor(() ->
                element.state().isClickable(), Duration.ofSeconds(duration), Duration.ofMillis(interval));
    }
    public static boolean waitForElementDisplayed(IElement element, int duration, int interval) {
        return AqualityServices.getConditionalWait().waitFor(() ->
                element.state().isDisplayed(), Duration.ofSeconds(duration), Duration.ofMillis(interval));
    }
}
