package pages.pages;
 
import handlingConfigFile.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.pagesActions.ProductsPageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ProductsPage {
    protected WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

   //Method to return the pageActions
   public ProductsPageActions productsPageActions(){
       	return new ProductsPageActions(this.webDriver);
   	}
    
	private final By searchInputField_name = By.name("search");
	public String searchInputField = "searchInputField";
  
 
	private void defineAllElements() {
		this.elementsMap.put(searchInputField, searchInputField_name);
	}
 

	//Add Other Needed Methods Here
}
