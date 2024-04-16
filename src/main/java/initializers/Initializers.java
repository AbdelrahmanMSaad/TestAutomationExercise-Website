package initializers;

import AutomatedActions.AutomatedActions;
import base.Navigation;
import handlingConfigFile.Config;
import org.openqa.selenium.WebDriver;

public class Initializers extends Navigation {
    public static WebDriver webDriver;
    public Initializers(){
        super();
        webDriver = super.webDriver;
    }
    public static void initializeConfigFile(){
        new Config();
    }
}
