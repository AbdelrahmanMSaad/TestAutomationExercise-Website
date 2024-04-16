package handlingConfigFile;

public class Config {
    public static String browser;
    public static String uRL;
    public static int pageLoadTimeoutDuration;
    public static int elementWaitDuration;
    public static int implicitWaitDuration;

    public Config(){
        browser = GetPropertiesFromConfigFile.getPropertyFromConfigFile("browser");
        uRL = GetPropertiesFromConfigFile.getPropertyFromConfigFile("url");
        pageLoadTimeoutDuration = Integer.parseInt(GetPropertiesFromConfigFile.getPropertyFromConfigFile("page_timeout_duration"));
        elementWaitDuration = Integer.parseInt(GetPropertiesFromConfigFile.getPropertyFromConfigFile("element_wait_duration"));
        implicitWaitDuration = Integer.parseInt(GetPropertiesFromConfigFile.getPropertyFromConfigFile("implicit_wait_duration"));
    }
}
