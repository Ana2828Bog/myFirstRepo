package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@id='orderLink']")
	public WebElement ordersButton;

	@FindBy(id = "cancelBtn")
	public WebElement cancelTheOrderButton;

	@FindBy(xpath = "//select[@id='reasonInput']")
	public WebElement cancelReason;

	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelOrder;

	@FindBy(xpath = "//p[contains(text(),'Your Order Has Been Cancelled')]")
	public WebElement yourOrderHasBeenCancelled;

	@FindBy(id = "returnBtn")
	public WebElement returnItemsBtn;

	@FindBy(xpath = "//select[@id='reasonInput']")
	public WebElement returnReasonDropDown;

	@FindBy(xpath = "//select[@id='dropOffInput']")
	public WebElement returnService;

	@FindBy(xpath = "//p[contains(text(),'Return was successfull')]")
	public WebElement returtWasSuccessfull;

	@FindBy(id = "orderSubmitBtn")
	public WebElement returnOrderSubmit;

	@FindBy(xpath = "//input[@id='headlineInput']")
	public WebElement headlineInputField;

	@FindBy(xpath = "//textarea[@id='descriptionInput']")
	public WebElement desctiptionField;

	@FindBy(id = "reviewBtn")
	public WebElement reviewButton;

	@FindBy(id = "reviewSubmitBtn")
	public WebElement reviewSubmitButton;

	@FindBy(xpath = "//div[contains(text(),'Your review was added successfully')]")
	public WebElement yourReviewWasAddedSuccessfully;
}
