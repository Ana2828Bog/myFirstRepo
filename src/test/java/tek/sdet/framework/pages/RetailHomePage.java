package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup{

	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "Sign in") 
	public WebElement signInButton;
	
	@FindBy(xpath = "//a[text()='TEKSCHOOL']")
	public WebElement tekSchoolLogo;
	
	@FindBy(id="search")
	public WebElement AllDepartmentDropDown;
	
	@FindBy(xpath = "//option[@class='search__select-option ']")
	public List<WebElement> optionsAllDepartment;
	
	@FindBy(css = "#searchInput")
	public WebElement searchBar;
	
	@FindBy(xpath = "//button[@id='searchBtn']")
	public WebElement searchButton;
	
	@FindBy(id = "cartBtn")
	public WebElement cartButton;
	
	@FindBy(xpath = "//img[contains(@alt, 'Pokemon']")
	public WebElement pokemonProductImage;
	
	@FindBy(xpath = "//a[text()='Account']")
	public WebElement accountOption;
	
	@FindBy(id = "hamburgerBtn")
	public WebElement allIcon;
	
	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarElements;
	
	@FindBy(xpath = "//span[text()='Electronics']")
	public WebElement electronicsSideBar;
	
	@FindBy(xpath = "//span[text()='Computers']")
	public WebElement computersSideBar;
	
	@FindBy(xpath = "span[text()='Smart Home']")
	public WebElement smartHomeSideBar;
	
	@FindBy(xpath = "//span[text()='Sports']")
	public WebElement sportsSideBar;
	
	@FindBy(xpath = "//span[text()='Automative']")
	public WebElement automativeSideBar;
	
	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarOptionElements;
	
	@FindBy(xpath = "//button[@id='logoutBtn']")
	public WebElement logoutButton;
	
	@FindBy(xpath = "//p[contains(text(),'Kasa Outdoor Smart Plug')]")
	public WebElement kasaOutdoorSmartPlug;
	
	@FindBy(xpath = "//select[@class='product__select']")
	public WebElement quantityDropDown;
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	public WebElement addToCartButton;
	
	@FindBy(id = "cartQuantity")
	public WebElement cartQuantity;
	
	@FindBy(xpath ="//button[@id='proceedBtn']")
	public WebElement proceedToCheckout;
	
	@FindBy(id = "addAddressBtn")
	public WebElement addAddressButton;
	
	@FindBy(id = "countryDropdown")
	public WebElement countryDropDown;
	
	@FindBy(xpath = "//input[@id='fullNameInput']")
	public WebElement addressFullNameField;
	
	@FindBy(xpath = "//input[@id='phoneNumberInput']")
	public WebElement addressPhoneNumberField;
	
	@FindBy(xpath = "//input[@id='streetInput']")
	public WebElement addressStreetField;
	
	@FindBy(id = "apartmentInput")
	public WebElement aptSuitUnitField;
	
	@FindBy(id = "cityInput")
	public WebElement cityField;
	
	@FindBy(xpath = "//body/div[@id='root']/div[3]/div[2]/div[1]/div[1]/form[1]/div[5]/div[2]/div[1]/div[1]/select[1]")
	public WebElement stateDropDown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeInput;
	
	@FindBy(id = "addressBtn")
	public WebElement addYourAddressButton;
	
	@FindBy(id = "addPaymentBtn")
	public WebElement addCreditOrDebitCard;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement placeYourOrderButton;
	
	@FindBy(xpath = "//p[contains(text(),'Order Placed, Thanks')]")
	public WebElement orderPlacedThanks;
	
}
