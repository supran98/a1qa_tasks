package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    private static WebDriver driver;

    public static void initDriver() {
        if (Config.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;

    }
    public static void get(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
    public static WebElement waitForElement(String locator) {
        WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), 7);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
    }
    public static void quitDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
