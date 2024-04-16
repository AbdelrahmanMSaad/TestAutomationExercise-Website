package pages.pages;
 
import handlingConfigFile.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.pagesActions.SignupEnterAccountInfoPageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SignupEnterAccountInfoPage {
    protected WebDriver webDriver;
    protected final Map<String,By> elementsMap = new HashMap<>();

    public SignupEnterAccountInfoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
        this.defineAllElements();
    }

   //Method to return the pageActions
   public SignupEnterAccountInfoPageActions signupEnterAccountInfoPageActions(){
       	return new SignupEnterAccountInfoPageActions(this.webDriver);
   	}
    
	private final By enterAccountInfoText_xpath = By.xpath("//b[contains(.,'Enter Account Information')]");
	public String enterAccountInfoText = "enterAccountInfoText";
  
	private final By titleText_xpath = By.xpath("//label[contains(.,'Title')]");
	public String titleText = "titleText";
  
	private final By mrRadioBtn_id = By.id("uniform-id_gender1");
	public String mrRadioBtn = "mrRadioBtn";
  
	private final By mrsRadioBtn_id = By.id("uniform-id_gender2");
	public String mrsRadioBtn = "mrsRadioBtn";
  
	private final By nameText_xpath = By.xpath("//label[contains(.,'Name ')]");
	public String nameText = "nameText";
  
	private final By nameInput_id = By.id("name");
	public String nameInput = "nameInput";
  
	private final By emailText_xpath = By.xpath("//label[contains(.,'Email ')]");
	public String emailText = "emailText";
  
	private final By emailInput_id = By.id("email");
	public String emailInput = "emailInput";
  
	private final By passwordText_xpath = By.xpath("//label[contains(.,'Password ')]");
	public String passwordText = "passwordText";
  
	private final By passwordInput_id = By.id("password");
	public String passwordInput = "passwordInput";
  
	private final By dateOfBirthText_xpath = By.xpath("//label[contains(.,'Date of Birth')]");
	public String dateOfBirthText = "dateOfBirthText";
  
	private final By daysDropdownList_id = By.id("days");
	public String daysDropdownList = "daysDropdownList";
  
	private final By monthsDropdownList_id = By.id("months");
	public String monthsDropdownList = "monthsDropdownList";
  
	private final By yearsDropdownList_id = By.id("years");
	public String yearsDropdownList = "yearsDropdownList";
  
	private final By scrollToTopBtn_xpath = By.xpath("//i[contains(@class,'fa fa-angle-up')]");
	public String scrollToTopBtn = "scrollToTopBtn";
  
	private final By newsletterCheckbox_id = By.id("newsletter");
	public String newsletterCheckbox = "newsletterCheckbox";
  
	private final By receiveOffersCheckbox_id = By.id("optin");
	public String receiveOffersCheckbox = "receiveOffersCheckbox";
  
	private final By addressInfoText_xpath = By.xpath("//label[contains(.,'Address Information')]");
	public String addressInfoText = "addressInfoText";
  
	private final By firstNameText_xpath = By.xpath("//label[contains(.,'First name ')]");
	public String firstNameText = "firstNameText";
  
	private final By firstNameInput_id = By.id("first_name");
	public String firstNameInput = "firstNameInput";
  
	private final By lastNameText_xpath = By.xpath("//label[contains(.,'Last name ')]");
	public String lastNameText = "lastNameText";
  
	private final By lastNameInput_id = By.id("last_name");
	public String lastNameInput = "lastNameInput";
  
	private final By companyText_xpath = By.xpath("//label[contains(.,'Company')]");
	public String companyText = "companyText";
  
	private final By companyInput_id = By.id("company");
	public String companyInput = "companyInput";
  
	private final By address1Text_xpath = By.xpath("//label[contains(.,'Address ')]");
	public String address1Text = "address1Text";
  
	private final By address1Input_id = By.id("address1");
	public String address1Input = "address1Input";
  
	private final By address2Text_xpath = By.xpath("//label[contains(.,'Address 2')]");
	public String address2Text = "address2Text";
  
	private final By address2Input_id = By.id("address2");
	public String address2Input = "address2Input";
  
	private final By countryText_xpath = By.xpath("//label[contains(.,'Country ')]");
	public String countryText = "countryText";
  
	private final By countryDropdownList_id = By.id("country");
	public String countryDropdownList = "countryDropdownList";
  
	private final By stateText_xpath = By.xpath("//label[contains(.,'State ')]");
	public String stateText = "stateText";
  
	private final By stateInput_id = By.id("state");
	public String stateInput = "stateInput";
  
	private final By cityText_xpath = By.xpath("//label[contains(.,'City ')]");
	public String cityText = "cityText";
  
	private final By cityInput_id = By.id("city");
	public String cityInput = "cityInput";
  
	private final By zipcodeText_xpath = By.xpath("//label[contains(.,'Zipcode ')]");
	public String zipcodeText = "zipcodeText";
  
	private final By zipcodeInput_id = By.id("zipcode");
	public String zipcodeInput = "zipcodeInput";
  
	private final By mobileNumberText_xpath = By.xpath("//label[contains(.,'Mobile Number  ')]");
	public String mobileNumberText = "mobileNumberText";
  
	private final By mobileNumberInput_id = By.id("mobile_number");
	public String mobileNumberInput = "mobileNumberInput";
  
	private final By submitBtn_xpath = By.xpath("//button[contains(@data-qa,'create-account')]");
	public String submitBtn = "submitBtn";
  
 
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
