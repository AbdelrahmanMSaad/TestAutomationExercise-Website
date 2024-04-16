package pages.pages;
 
import base.Navigation;
import handlingConfigFile.Config;
import initializers.Initializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import AutomatedActions.AutomatedActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ProductsPage {
    public WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }
    
	private final By searchInputField_name = By.name("search");
	protected String searchInputField = "searchInputField";
 
	private void defineAllElements() {
		this.elementsMap.put(searchInputField, searchInputField_name);
	}
 

	//Add Other Needed Methods Here
}
