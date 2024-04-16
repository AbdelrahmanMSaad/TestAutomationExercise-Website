package pages.pages;
 
import base.Navigation;
import handlingConfigFile.Config;
import initializers.Initializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import AutomatedActions.AutomatedActions;
import pages.pagesActions.HomePageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HomePage {
    protected WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

    public HomePageActions homePageActions(){
    	return new HomePageActions(this.webDriver);
	}
    
	private final By webSiteLogo_className = By.className("logo");
	protected String webSiteLogo = "webSiteLogo";
  
	private final By homeBtn_xpath = By.xpath("//a[@href='/'][contains(.,'Home')]");
	protected String homeBtn = "homeBtn";
  
	private final By productsBtn_xpath = By.xpath("//a[contains(@href,'/products')]");
	protected String productsBtn = "productsBtn";
  
	private final By cartBtn_xpath = By.xpath("//a[contains(@href,'/view_cart')]");
	protected String cartBtn = "cartBtn";
  
	private final By singUpLoginBtn_xpath = By.xpath("//a[contains(@href,'/login')]");
	protected String singUpLoginBtn = "singUpLoginBtn";
  
	private final By logoutBtn_xpath = By.xpath("//a[contains(@href,'/logout')]");
	protected String logoutBtn = "logoutBtn";
  
	private final By deleteAccountBtn_xpath = By.xpath("//a[contains(@href,'/delete_account')]");
	protected String deleteAccountBtn = "deleteAccountBtn";
  
	private final By loggedInAsText_xpath = By.xpath("//i[contains(@class,'fa fa-user')]");
	protected String loggedInAsText = "loggedInAsText";
  
	private final By testCasesBtn_xpath = By.xpath("//a[contains(@href,'/test_cases')]");
	protected String testCasesBtn = "testCasesBtn";
  
	private final By carouselSection_id = By.id("slider-carousel");
	protected String carouselSection = "carouselSection";
  
	private final By carouselSectionLeftBtn_xpath = By.xpath("//a[contains(@class,'left control-carousel hidden-xs')]");
	protected String carouselSectionLeftBtn = "carouselSectionLeftBtn";
  
	private final By carouselSectionRightBtn_xpath = By.xpath("//a[contains(@class,'right control-carousel hidden-xs')]");
	protected String carouselSectionRightBtn = "carouselSectionRightBtn";
  

 
	private void defineAllElements() {
		this.elementsMap.put(webSiteLogo, webSiteLogo_className);
		this.elementsMap.put(homeBtn, homeBtn_xpath);
		this.elementsMap.put(productsBtn, productsBtn_xpath);
		this.elementsMap.put(cartBtn, cartBtn_xpath);
		this.elementsMap.put(singUpLoginBtn, singUpLoginBtn_xpath);
		this.elementsMap.put(logoutBtn, logoutBtn_xpath);
		this.elementsMap.put(deleteAccountBtn, deleteAccountBtn_xpath);
		this.elementsMap.put(loggedInAsText, loggedInAsText_xpath);
		this.elementsMap.put(testCasesBtn, testCasesBtn_xpath);
		this.elementsMap.put(carouselSection, carouselSection_id);
		this.elementsMap.put(carouselSectionLeftBtn, carouselSectionLeftBtn_xpath);
		this.elementsMap.put(carouselSectionRightBtn, carouselSectionRightBtn_xpath);
	}
 

	//Add Other Needed Methods Here
}
