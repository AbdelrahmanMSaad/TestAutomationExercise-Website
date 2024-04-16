package pages.pagesActions;

import AutomatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pages.ProductsPage;

public class ProductsPageActions extends ProductsPage {
    private final AutomatedActions automatedActions;

    public ProductsPageActions(WebDriver webDriver) {
        super(webDriver);
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    public WebElement getElement(String elementKey) {
        By elementLocator = super.elementsMap.get(elementKey);
        if (elementLocator != null) {
            return elementKey.toLowerCase().contains("btn") ?
                    automatedActions.waitAndVisibilityActions().waitForAnElementToBeClickable(elementLocator) :
                    automatedActions.waitAndVisibilityActions().waitForAnElementToBeVisible(elementLocator);
        }
        return null;
    }

    public void sendTextToSearchInputField(String searchText){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.searchInputField),searchText);
    }
}
