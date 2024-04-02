package base;

import org.openqa.selenium.WebDriver;
import pages.pages.HomePage;
import pages.pages.SignupLoginPage;
import utils.AutomatedActions;
import utils.Utilities;

import java.io.IOException;

public class Base {
    protected static String browser;
    protected static String uRL;
    protected static int elementWaitDuration;
    protected static int pageLoadTimeoutDuration;

    protected static WebDriver webDriver;

    public static void initializeConfigurations() throws IOException {
        browser = Utilities.getPropertyFromConfigFile("browser");
        uRL = Utilities.getPropertyFromConfigFile("url");
        elementWaitDuration = Integer.parseInt(Utilities.getPropertyFromConfigFile("element_wait_duration"));
        pageLoadTimeoutDuration = Integer.parseInt(Utilities.getPropertyFromConfigFile("page_timeout_duration"));
    }


    public static void main(String[] args){
    }
}

