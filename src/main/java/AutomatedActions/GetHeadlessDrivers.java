package AutomatedActions;

import Browsers.Browsers;
import handlingConfigFile.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GetHeadlessDrivers {
    private static WebDriver getHeadlessChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver getHeadlessFirefoxDriver(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        return new FirefoxDriver(firefoxOptions);
    }

    public static WebDriver getDriver(){
        if(Config.browser.equalsIgnoreCase(Browsers.chrome)){
            return GetHeadlessDrivers.getHeadlessChromeDriver();
        }else if(Config.browser.equalsIgnoreCase(Browsers.firefox)){
            return GetHeadlessDrivers.getHeadlessFirefoxDriver();
        }
        return null;
    }
}
