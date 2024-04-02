package pages.pages;
 
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AutomatedActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ProductsPage extends Base {
    protected WebDriver webDriver;
    private final Map<String,By> elementsMap = new HashMap<>();


    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Base.pageLoadTimeoutDuration));
        this.defineAllElements();
    }
    
	private final By searchInputField_name = By.name("search");
	public String searchInputField = "searchInputField";
  
	public WebElement getElement(String webElement){
		if (webElement.toLowerCase().contains("btn")){
			return AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeClickable(elementsMap.get(webElement));
		}else{
			return AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeVisible(elementsMap.get(webElement));
		}
	}
 
	private void defineAllElements() {
		this.elementsMap.put(searchInputField, searchInputField_name);
	}
 

	//Add Other Needed Methods Here

}