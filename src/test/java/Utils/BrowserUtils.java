package Utils;

import aquality.selenium.browser.AqualityServices;

public class BrowserUtils {
    public static void maximize() {
        AqualityServices.getBrowser().maximize();
    }
    public static void quit() {
        AqualityServices.getBrowser().quit();
    }
}
