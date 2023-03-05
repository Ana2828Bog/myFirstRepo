package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//img[@id='profileImage']")
	public WebElement profileImage;

	@FindBy(id = "nameInput")
	public WebElement profileNameInputField;

	@FindBy(id = "personalPhoneInput")
	public WebElement profilePhoneNumberField;

	@FindBy(xpath = "//button[text()='Update']")
	public WebElement profileUpdateButton;

	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMessage;

	@FindBy(xpath = "//input[@id='emailInput']")
	public WebElement profileEmailField;

	@FindBy(xpath = "//input[@name='previousPassword']")
	public WebElement profilePriviousPasswordField;

	@FindBy(css = "#newPasswordInput")
	public WebElement profileNewPasswordField;

	@FindBy(css = "#confirmPasswordInput")
	public WebElement profileConfirmPassword;

	@FindBy(id = "credentialsSubmitBtn")
	public WebElement profileChangePasswordButton;

	@FindBy(xpath = "//input[@id='cardNumberInput']")
	public WebElement profileCardNumberField;

	@FindBy(css = "#nameOnCardInput")
	public WebElement profileNameOfCardField;

	@FindBy(id = "expirationMonthInput")
	public WebElement profileExpirationMonthDropDown;

	@FindBy(id = "expirationYearInput")
	public WebElement profileExpirationYearDropDown;

	@FindBy(id = "securityCodeInput")
	public WebElement profileSecutityCodeField;

	@FindBy(id = "paymentSubmitBtn")
	public WebElement addYourCardButton;

	@FindBy(xpath = "//div[contains(text(),'Password Updated Successfully')]")
	public WebElement passwordUpdatedSuccessfully;

	@FindBy(xpath = "//div[contains(text(),'Payment Method added sucessfully')]")
	public WebElement paymentMethodAddedSuccessfully;

	@FindBy(xpath = "//p[contains(text(),'Add a payment method')]")
	public WebElement addPaymentMethodButton;

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/p[1]")
	public WebElement cardInTheWallet;

	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	public WebElement editButton;

	@FindBy(xpath = "//div[contains(text(),'Payment Method updated Successfully')]")
	public WebElement paymentMethodApdatedSuccessfully;

	@FindBy(xpath = "//button[contains(text(),'remove')]")
	public WebElement removeCardButon;

	@FindBy(xpath = "//div[@class='account__address-new']")
	public WebElement addAddressOption;
	
	@FindBy(xpath = "//select[@id='countryDropdown']")
	public WebElement newAddressSelectCountryDropdown;
	
	@FindBy(css = "#fullNameInput")
	public WebElement newAddressFullNameField;
	
	@FindBy(css = "#phoneNumberInput")
	public WebElement newAddressPhoneNumberField;
	
	@FindBy(css = "#streetInput")
	public WebElement newAddressStreetField;
	
	@FindBy(css = "#apartmentInput")
	public WebElement newAddressAptField;
	
	@FindBy(css = "#cityInput")
	public WebElement newAddressCityField;
	
	@FindBy(xpath = "//select[@class='account__address-new-dropdown' and @name='state']")
	public WebElement newAddressStateDropdown;
	
	@FindBy(xpath = "//input[@id='zipCodeInput']")
	public WebElement newAddressZipCodeField;
	
	@FindBy(xpath = "//button[@id='addressBtn']")
	public WebElement newAddressAddYourAddressButton;
	
	@FindBy(css = "#addressBtn")
	public WebElement updateYourAddressButton;
	
	@FindBy(xpath = "//div[@class='account__address-single']")
	public WebElement addressBox;
	
	@FindBy(xpath = "//div[@class='account__address-new-modal']")
	public WebElement newAddressPopup;
	
	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	public WebElement editAddressButton;
	
	@FindBy(xpath = "//div[contains(text(),'Address Added Successfully')]")
	public WebElement addressAddedSuccessfully;
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	public WebElement removeAddressButton;
	
	@FindBy(xpath = "//div[contains(text(),'Address Updated Successfully')]")
	public WebElement addressUpdatedSuccessfully;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]")
	public List<WebElement> addressesList;
	

	
}
