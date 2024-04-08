package pages.pages;
 
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AutomatedActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HomePage extends Base {
    protected WebDriver webDriver;
    private final Map<String,By> elementsMap = new HashMap<>();


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Base.pageLoadTimeoutDuration));
        this.defineAllElements();
    }
    
	private final By webSiteLogo_className = By.className("logo");
	public String webSiteLogo = "webSiteLogo";
  
	private final By homeBtn_xpath = By.xpath("//a[@href='/'][contains(.,'Home')]");
	public String homeBtn = "homeBtn";
  
	private final By productsBtn_xpath = By.xpath("//a[contains(@href,'/products')]");
	public String productsBtn = "productsBtn";
  
	private final By cartBtn_xpath = By.xpath("//a[contains(@href,'/view_cart')]");
	public String cartBtn = "cartBtn";
  
	private final By singUpLoginBtn_xpath = By.xpath("//a[contains(@href,'/login')]");
	public String singUpLoginBtn = "singUpLoginBtn";
  
	private final By logoutBtn_xpath = By.xpath("//a[contains(@href,'/logout')]");
	public String logoutBtn = "logoutBtn";
  
	private final By deleteAccountBtn_xpath = By.xpath("//a[contains(@href,'/delete_account')]");
	public String deleteAccountBtn = "deleteAccountBtn";
  
	private final By loggedInAsText_xpath = By.xpath("//i[contains(@class,'fa fa-user')]");
	public String loggedInAsText = "loggedInAsText";
  
	private final By testCasesBtn_xpath = By.xpath("//a[contains(@href,'/test_cases')]");
	public String testCasesBtn = "testCasesBtn";
  
	private final By carouselSection_id = By.id("slider-carousel");
	public String carouselSection = "carouselSection";
  
	private final By carouselSectionLeftBtn_xpath = By.xpath("//a[contains(@class,'left control-carousel hidden-xs')]");
	public String carouselSectionLeftBtn = "carouselSectionLeftBtn";
  
	private final By carouselSectionRightBtn_xpath = By.xpath("//a[contains(@class,'right control-carousel hidden-xs')]");
	public String carouselSectionRightBtn = "carouselSectionRightBtn";
  
	public WebElement getElement(String elementKey) {
		By elementLocator = elementsMap.get(elementKey);
		if (elementLocator != null) {
			return elementKey.toLowerCase().contains("btn") ?
				AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeClickable(elementLocator) :
				AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeVisible(elementLocator);
			}
		return null;
	}
 
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