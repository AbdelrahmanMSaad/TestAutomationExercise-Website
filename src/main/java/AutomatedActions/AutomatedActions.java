package AutomatedActions;

import Browsers.Browsers;
import base.WebDriverHelper;
import handlingConfigFile.Config;
import handlingConfigFile.GetPropertiesFromConfigFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomatedActions {
    protected final WebDriver webDriver;
    private final Actions actions;
    private final WebDriverWait webDriverWait;

    public AutomatedActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        actions = new Actions(this.webDriver);
        webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(Integer.parseInt(GetPropertiesFromConfigFile.getPropertyFromConfigFile("element_wait_duration"))));
    }

    public WaitAndVisibilityActions waitAndVisibilityActions(){
        return new WaitAndVisibilityActions();
    }

    public ClickingActions clickingActions(){
        return new ClickingActions(actions);
    }

    public TextActions textActions(){
        return new TextActions();
    }

    public DropdownListActions dropdownListActions(){
        return new DropdownListActions();
    }

    public ScrollingActions scrollingActions(){
        return new ScrollingActions();
    }

    public BrowsersActions browsersActions(){
        return new BrowsersActions();
    }

    public class WaitAndVisibilityActions {
        /**
         * This method is to set the global implicit wait for the session according to the time specified in the config file
         */
        public void setImplicitWait() {
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.implicitWaitDuration));
        }

        public WebElement waitForAnElementToBeClickable(By by){
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        }

        public WebElement waitForAnElementToBeVisible(By by){
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }


        /**
         * Method to check if the web element is displayed
         * @param webElement to check
         * @return is displayed
         */
        public boolean isWebElementDisplayed(WebElement webElement){
            return webElement.isDisplayed();
        }

        /**
         * Method to check if the web element is selected
         * @param webElement to check
         * @return is selected
         */
        public boolean isWebElementSelected(WebElement webElement){
            return webElement.isSelected();
        }

        /**
         * Method to check if the web element is enabled
         * @param webElement to check
         * @return is enabled
         */
        public boolean isWebElementEnabled(WebElement webElement){
            return webElement.isEnabled();
        }
    }

    public class ClickingActions {
        private final Actions actions;
        public ClickingActions(Actions actions){
            this.actions = actions;
        }

        /**
         * This method is used to click on a web element
         *
         * @param webElement to be clicked
         */
        public void clickOnElement(WebElement webElement) {
            webElement.click();
        }

        /**
         * This method is to double click on a web element
         *
         * @param webElement to be double clicked
         */
        public void doubleClickOnElement(WebElement webElement) {
            this.actions.doubleClick(webElement).perform();
        }
    }

    public class TextActions{
        /**
         * This method is to get the text of a web element
         * @param webElement that contains the text
         * @return  string, the web element text
         */
        public String getElementText(WebElement webElement){
            return webElement.getText();
        }

        /**
         * This method is to send a text to a web element
         * @param webElement to send the text to
         * @param text to be sent
         */
        public void sendTextToElement(WebElement webElement,String text){
            webElement.sendKeys(text);
        }
    }

    public class DropdownListActions{
        public void selectAnOptionFromADropdownList(WebElement dropdownListWebElement,String optionToBeSelected){
            String script = "arguments[0].style.display='block';";
            ((JavascriptExecutor) webDriver).executeScript(script, dropdownListWebElement);
            Select select = new Select(dropdownListWebElement);
            select.selectByVisibleText(optionToBeSelected);
        }
    }

    public class ScrollingActions{
        public void scrollToAnElement(WebElement webElement){
            actions.moveToElement(webElement).perform();
        }
    }

    public class BrowsersActions{
        public void maximizeBrowserPage(){
            webDriver.manage().window().maximize();
        }

        public void openURL(String url){
            webDriver.get(url);
        }
    }
}
