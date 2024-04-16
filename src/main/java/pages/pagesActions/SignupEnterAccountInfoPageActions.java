package pages.pagesActions;

import AutomatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pages.AccountCreatedPage;

public class SignupEnterAccountInfoPageActions extends pages.pages.SignupEnterAccountInfoPage {
    private final AutomatedActions automatedActions;
    public SignupEnterAccountInfoPageActions(WebDriver webDriver) {
        super(webDriver);
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    public WebElement getElement(String elementKey) {
        By elementLocator = elementsMap.get(elementKey);
        if (elementLocator != null) {
            return elementKey.toLowerCase().contains("btn") ?
                    automatedActions.waitAndVisibilityActions().waitForAnElementToBeClickable(elementLocator) :
                    automatedActions.waitAndVisibilityActions().waitForAnElementToBeVisible(elementLocator);
        }
        return null;
    }

    public boolean isEnterAccountInfoTextDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.enterAccountInfoText));
    }

    public boolean isTitleTextDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.titleText));
    }

    public SignupEnterAccountInfoPageActions clickOnMrRadioBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.mrRadioBtn));
        return this;
    }

    public SignupEnterAccountInfoPageActions clickOnMrsRadioBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.mrsRadioBtn));
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToNameInput(String name){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.nameInput),name);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToEmailInput(String email){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.emailInput),email);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToPasswordInput(String password){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.passwordInput),password);
        return this;
    }

    public SignupEnterAccountInfoPageActions selectDayFromDaysDropdownList(String selection){
        this.automatedActions.dropdownListActions().selectAnOptionFromADropdownList(this.getElement(super.daysDropdownList),selection);
        return this;
    }

    public SignupEnterAccountInfoPageActions selectMonthFromMonthsDropdownList(String selection){
        this.automatedActions.dropdownListActions().selectAnOptionFromADropdownList(this.getElement(super.monthsDropdownList),selection);
        return this;
    }

    public SignupEnterAccountInfoPageActions selectYearFromYearsDropdownList(String selection){
        this.automatedActions.dropdownListActions().selectAnOptionFromADropdownList(this.getElement(super.yearsDropdownList),selection);
        return this;
    }

    public boolean isScrollToTopBtnDisplayed(){
        return this.automatedActions.waitAndVisibilityActions().isWebElementDisplayed(this.getElement(super.scrollToTopBtn));
    }

    public SignupEnterAccountInfoPageActions clickOnScrollToTopBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.scrollToTopBtn));
        return this;
    }

    public SignupEnterAccountInfoPageActions clickOnCheckNewsLetterCheckBox(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.newsletterCheckbox));
        return this;
    }

    public SignupEnterAccountInfoPageActions clickOnReceiveOffersCheckbox(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.receiveOffersCheckbox));
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToFirstNameInput(String firstName){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.firstNameInput),firstName);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToLastNameInput(String lastName){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.lastNameInput),lastName);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToCompanyInput(String company){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.companyInput),company);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToAddress1Input(String address1){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.address1Input),address1);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToAddress2Input(String address2){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.address2Input),address2);
        return this;
    }

    public SignupEnterAccountInfoPageActions selectCountryFromCountriesDropdownList(String selection){
        this.automatedActions.dropdownListActions().selectAnOptionFromADropdownList(this.getElement(super.countryDropdownList),selection);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToStateInput(String state){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.stateInput),state);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToCityInput(String city){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.cityInput),city);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToZipcodeInput(String zipcode){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.zipcodeInput),zipcode);
        return this;
    }

    public SignupEnterAccountInfoPageActions sendTextToMobileInput(String mobile){
        this.automatedActions.textActions().sendTextToElement(this.getElement(super.mobileNumberInput),mobile);
        return this;
    }

    public AccountCreatedPage clickOnSubmitBtn(){
        this.automatedActions.clickingActions().clickOnElement(this.getElement(super.submitBtn));
        return new AccountCreatedPage(this.webDriver);
    }
}
