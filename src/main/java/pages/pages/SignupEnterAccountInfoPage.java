package pages.pages;
 
import base.Navigation;
import handlingConfigFile.Config;
import initializers.Initializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import AutomatedActions.AutomatedActions;
import pages.pagesActions.SignupEnterAccountInfoPageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SignupEnterAccountInfoPage {
    public WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public SignupEnterAccountInfoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

    public SignupEnterAccountInfoPageActions signupEnterAccountInfoPageActions(){
    	return new SignupEnterAccountInfoPageActions(this.webDriver);
	}
    
	private final By enterAccountInfoText_xpath = By.xpath("//b[contains(.,'Enter Account Information')]");
	protected String enterAccountInfoText = "enterAccountInfoText";
  
	private final By titleText_xpath = By.xpath("//label[contains(.,'Title')]");
	protected String titleText = "titleText";
  
	private final By mrRadioBtn_id = By.id("uniform-id_gender1");
	protected String mrRadioBtn = "mrRadioBtn";
  
	private final By mrsRadioBtn_id = By.id("uniform-id_gender2");
	protected String mrsRadioBtn = "mrsRadioBtn";
  
	private final By nameText_xpath = By.xpath("//label[contains(.,'Name ')]");
	protected String nameText = "nameText";
  
	private final By nameInput_id = By.id("name");
	protected String nameInput = "nameInput";
  
	private final By emailText_xpath = By.xpath("//label[contains(.,'Email ')]");
	protected String emailText = "emailText";
  
	private final By emailInput_id = By.id("email");
	protected String emailInput = "emailInput";
  
	private final By passwordText_xpath = By.xpath("//label[contains(.,'Password ')]");
	protected String passwordText = "passwordText";
  
	private final By passwordInput_id = By.id("password");
	protected String passwordInput = "passwordInput";
  
	private final By dateOfBirthText_xpath = By.xpath("//label[contains(.,'Date of Birth')]");
	protected String dateOfBirthText = "dateOfBirthText";
  
	private final By daysDropdownList_id = By.id("days");
	protected String daysDropdownList = "daysDropdownList";
  
	private final By monthsDropdownList_id = By.id("months");
	protected String monthsDropdownList = "monthsDropdownList";
  
	private final By yearsDropdownList_id = By.id("years");
	protected String yearsDropdownList = "yearsDropdownList";
  
	private final By scrollToTopBtn_xpath = By.xpath("//i[contains(@class,'fa fa-angle-up')]");
	protected String scrollToTopBtn = "scrollToTopBtn";
  
	private final By newsletterCheckbox_id = By.id("newsletter");
	protected String newsletterCheckbox = "newsletterCheckbox";
  
	private final By receiveOffersCheckbox_id = By.id("optin");
	protected String receiveOffersCheckbox = "receiveOffersCheckbox";
  
	private final By addressInfoText_xpath = By.xpath("//label[contains(.,'Address Information')]");
	protected String addressInfoText = "addressInfoText";
  
	private final By firstNameText_xpath = By.xpath("//label[contains(.,'First name ')]");
	protected String firstNameText = "firstNameText";
  
	private final By firstNameInput_id = By.id("first_name");
	protected String firstNameInput = "firstNameInput";
  
	private final By lastNameText_xpath = By.xpath("//label[contains(.,'Last name ')]");
	protected String lastNameText = "lastNameText";
  
	private final By lastNameInput_id = By.id("last_name");
	protected String lastNameInput = "lastNameInput";
  
	private final By companyText_xpath = By.xpath("//label[contains(.,'Company')]");
	protected String companyText = "companyText";
  
	private final By companyInput_id = By.id("company");
	protected String companyInput = "companyInput";
  
	private final By address1Text_xpath = By.xpath("//label[contains(.,'Address ')]");
	protected String address1Text = "address1Text";
  
	private final By address1Input_id = By.id("address1");
	protected String address1Input = "address1Input";
  
	private final By address2Text_xpath = By.xpath("//label[contains(.,'Address 2')]");
	protected String address2Text = "address2Text";
  
	private final By address2Input_id = By.id("address2");
	protected String address2Input = "address2Input";
  
	private final By countryText_xpath = By.xpath("//label[contains(.,'Country ')]");
	protected String countryText = "countryText";
  
	private final By countryDropdownList_id = By.id("country");
	protected String countryDropdownList = "countryDropdownList";
  
	private final By stateText_xpath = By.xpath("//label[contains(.,'State ')]");
	protected String stateText = "stateText";
  
	private final By stateInput_id = By.id("state");
	protected String stateInput = "stateInput";
  
	private final By cityText_xpath = By.xpath("//label[contains(.,'City ')]");
	protected String cityText = "cityText";
  
	private final By cityInput_id = By.id("city");
	protected String cityInput = "cityInput";
  
	private final By zipcodeText_xpath = By.xpath("//label[contains(.,'Zipcode ')]");
	protected String zipcodeText = "zipcodeText";
  
	private final By zipcodeInput_id = By.id("zipcode");
	protected String zipcodeInput = "zipcodeInput";
  
	private final By mobileNumberText_xpath = By.xpath("//label[contains(.,'Mobile Number  ')]");
	protected String mobileNumberText = "mobileNumberText";
  
	private final By mobileNumberInput_id = By.id("mobile_number");
	protected String mobileNumberInput = "mobileNumberInput";
  
	private final By submitBtn_xpath = By.xpath("//button[contains(@data-qa,'create-account')]");
	protected String submitBtn = "submitBtn";
 
	private void defineAllElements() {
		this.elementsMap.put(enterAccountInfoText, enterAccountInfoText_xpath);
		this.elementsMap.put(titleText, titleText_xpath);
		this.elementsMap.put(mrRadioBtn, mrRadioBtn_id);
		this.elementsMap.put(mrsRadioBtn, mrsRadioBtn_id);
		this.elementsMap.put(nameText, nameText_xpath);
		this.elementsMap.put(nameInput, nameInput_id);
		this.elementsMap.put(emailText, emailText_xpath);
		this.elementsMap.put(emailInput, emailInput_id);
		this.elementsMap.put(passwordText, passwordText_xpath);
		this.elementsMap.put(passwordInput, passwordInput_id);
		this.elementsMap.put(dateOfBirthText, dateOfBirthText_xpath);
		this.elementsMap.put(daysDropdownList, daysDropdownList_id);
		this.elementsMap.put(monthsDropdownList, monthsDropdownList_id);
		this.elementsMap.put(yearsDropdownList, yearsDropdownList_id);
		this.elementsMap.put(scrollToTopBtn, scrollToTopBtn_xpath);
		this.elementsMap.put(newsletterCheckbox, newsletterCheckbox_id);
		this.elementsMap.put(receiveOffersCheckbox, receiveOffersCheckbox_id);
		this.elementsMap.put(addressInfoText, addressInfoText_xpath);
		this.elementsMap.put(firstNameText, firstNameText_xpath);
		this.elementsMap.put(firstNameInput, firstNameInput_id);
		this.elementsMap.put(lastNameText, lastNameText_xpath);
		this.elementsMap.put(lastNameInput, lastNameInput_id);
		this.elementsMap.put(companyText, companyText_xpath);
		this.elementsMap.put(companyInput, companyInput_id);
		this.elementsMap.put(address1Text, address1Text_xpath);
		this.elementsMap.put(address1Input, address1Input_id);
		this.elementsMap.put(address2Text, address2Text_xpath);
		this.elementsMap.put(address2Input, address2Input_id);
		this.elementsMap.put(countryText, countryText_xpath);
		this.elementsMap.put(countryDropdownList, countryDropdownList_id);
		this.elementsMap.put(stateText, stateText_xpath);
		this.elementsMap.put(stateInput, stateInput_id);
		this.elementsMap.put(cityText, cityText_xpath);
		this.elementsMap.put(cityInput, cityInput_id);
		this.elementsMap.put(zipcodeText, zipcodeText_xpath);
		this.elementsMap.put(zipcodeInput, zipcodeInput_id);
		this.elementsMap.put(mobileNumberText, mobileNumberText_xpath);
		this.elementsMap.put(mobileNumberInput, mobileNumberInput_id);
		this.elementsMap.put(submitBtn, submitBtn_xpath);
	}
 

	//Add Other Needed Methods Here
}
