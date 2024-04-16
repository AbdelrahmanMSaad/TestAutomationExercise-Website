package base;

import org.openqa.selenium.WebDriver;

public class WebDriverHelper {
    private static WebDriver webDriver;

    public static void setWebDriver(WebDriver driver) {
        webDriver = driver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
