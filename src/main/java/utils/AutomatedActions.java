package utils;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AutomatedActions extends Base {
    private static WebDriver webDriver;
    private static Actions actions;
    private static WebDriverWait webDriverWait;

    public AutomatedActions(WebDriver webDriver) {
        AutomatedActions.webDriver = webDriver;
        actions = new Actions(AutomatedActions.webDriver);
        webDriverWait = new WebDriverWait(AutomatedActions.webDriver,Duration.ofSeconds(Base.elementWaitDuration));
    }

    public static class WaitAndVisibilityActions {
        /**
         * This method is to set the global implicit wait for the session
         *
         * @param webDriver         web driver
         * @param durationInSeconds int duration in seconds
         */
        public static void setImplicitWait(WebDriver webDriver, int durationInSeconds) {
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationInSeconds));
        }

        public static WebElement waitForAnElementToBeClickable(By by){
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        }

        public static WebElement waitForAnElementToBeVisible(By by){
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        

        /**
         * Method to check if the web element is displayed
         * @param webElement to check
         * @return is displayed
         */
        public static boolean isWebElementDisplayed(WebElement webElement){
            return webElement.isDisplayed();
        }

        /**
         * Method to check if the web element is selected
         * @param webElement to check
         * @return is selected
         */
        public static boolean isWebElementSelected(WebElement webElement){
            return webElement.isSelected();
        }

        /**
         * Method to check if the web element is enabled
         * @param webElement to check
         * @return is enabled
         */
        public static boolean isWebElementEnabled(WebElement webElement){
            return webElement.isEnabled();
        }
    }

    public static class ClickingActions {

        /**
         * This method is used to click on a web element
         *
         * @param webElement to be clicked
         */
        public static void clickOnElement(WebElement webElement) {
            webElement.click();
        }

        /**
         * This method is to double click on a web element
         *
         * @param webElement to be double clicked
         */
        public static void doubleClickOnElement(WebElement webElement) {
            AutomatedActions.actions.doubleClick(webElement).perform();
        }
    }

    public static class TextActions{
        /**
         * This method is to get the text of a web element
         * @param webElement that contains the text
         * @return  string, the web element text
         */
        public static String getElementText(WebElement webElement){
            return webElement.getText();
        }

        /**
         * This method is to send a text to a web element
         * @param webElement to send the text to
         * @param text to be sent
         */
        public static void sendTextToElement(WebElement webElement,String text){
            webElement.sendKeys(text);
        }
    }

    public static class DropdownListActions{
        public static void selectAnOptionFromADropdownList(WebElement dropdownListWebElement,String optionToBeSelected){
            String script = "arguments[0].style.display='block';";
            ((JavascriptExecutor) AutomatedActions.webDriver).executeScript(script, dropdownListWebElement);
            Select select = new Select(dropdownListWebElement);
            select.selectByVisibleText(optionToBeSelected);
        }
    }

    public static class ScrollingActions{
        public static void scrollToAnElement(WebElement webElement){
            actions.moveToElement(webElement).perform();
        }
    }

    public static void main(String[] args) {
//        AutomatedActions.
    }
}
