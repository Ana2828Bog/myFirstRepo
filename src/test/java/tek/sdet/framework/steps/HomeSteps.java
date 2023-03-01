package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility {
	private POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekSchoolLogo));
		logger.info("user is on retail website");
		logger.info("Actual Title " + actualTitle + " Equals " + " Expected Title " + expectedTitle);
	}

	@When("User search for {string} product")
	public void userSearchForProduct(String productValue) {
		sendText(factory.homePage().searchBar, productValue);
		click(factory.homePage().searchButton);
		logger.info("user searched for product " + productValue);
	}

	@Then("The product should be displayed")
	public void theProductShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemonProductImage));
		logger.info("the Product is displayed on home page");

	}

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allIcon);
		logger.info("user clicked on All section");
	}

	@Then("below option are present in shop by department sidebar")
	public void bellowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> expectedSideBar = dataTable.asLists(String.class);
		List<WebElement> actualSideBar = factory.homePage().sideBarElements;

		for (int i = 0; i < expectedSideBar.get(0).size(); i++) {
			Assert.assertEquals(actualSideBar.get(i).getText(), expectedSideBar.get(0).get(i));
			logger.info(actualSideBar.get(i).getText() + " is equal to " + expectedSideBar.get(0).get(i));

		}
	}

	@When("User on {string}")
	public void userOnElectronics(String department) {
		List<WebElement> sideBarOptions = factory.homePage().sideBarElements;
		for (WebElement option : sideBarOptions) {
			if (option.getText().equals(department)) {
				click(option);
				try {
					logger.info(option.getText() + "is present ");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> expectedDepartmentOptions = dataTable.asLists(String.class);
		List<WebElement> actualDepartmentOptions = factory.homePage().sideBarElements;

		for (int i = 0; i < expectedDepartmentOptions.get(0).size(); i++) {
			for (WebElement dept : actualDepartmentOptions) {
				if (dept.getText().equals(expectedDepartmentOptions.get(0).get(i))) {

					Assert.assertTrue(isElementDisplayed(dept));
					logger.info(dept.getText() + " is present ");
				}
			}
		}
	}

//	@When("User should be logged in into Account")
//	public void userShouldBeLoggedInIntoAccount() {
//		Assert.assertTrue(isElementDisplayed(factory.homePage().logoutButton));
//		logger.info("User is logged in into Account");
//	}

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String departmentValue) {
		click(factory.homePage().AllDepartmentDropDown);
		List<WebElement> options = factory.homePage().optionsAllDepartment;
		for (WebElement op : options) {
			if (op.getText().equals(departmentValue)) {
				click(op);
				break;
			}
		}
	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String item) {
		sendText(factory.homePage().searchBar, item);
		logger.info("User search for an item {string}");
	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.homePage().searchButton);
	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.homePage().kasaOutdoorSmartPlug);
	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
		click(factory.homePage().quantityDropDown);
		selectByValue(factory.homePage().quantityDropDown, quantity);

	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.homePage().addToCartButton);
		logger.info("User clicked add to Cart button");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String quantity) {
		logger.info("Expected quantity " + quantity + " Actual quantity " + factory.homePage().cartQuantity.getText());
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.homePage().cartButton);
		logger.info("User clicked on Cart option");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.homePage().proceedToCheckout);
		logger.info("User click on Proceed to Checkout button");
	}

	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.homePage().addAddressButton);
		logger.info("User clicked Add a new address link for shipping address");
	}

	@Then("User fill new address form with below information")
	public void userFilNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.homePage().countryDropDown, addressInfo.get(0).get("country"));
		sendText(factory.homePage().addressFullNameField, addressInfo.get(0).get("fullName"));
		sendText(factory.homePage().addressPhoneNumberField, addressInfo.get(0).get("phoneNumber"));
		sendText(factory.homePage().addressStreetField, addressInfo.get(0).get("streetAddress"));
		sendText(factory.homePage().aptSuitUnitField, addressInfo.get(0).get("apt"));
		sendText(factory.homePage().cityField, addressInfo.get(0).get("city"));
		sendText(factory.homePage().stateDropDown, addressInfo.get(0).get("state"));
		sendText(factory.homePage().zipCodeInput, addressInfo.get(0).get("zipCode"));
		logger.info("User filled new address form with below information");
	}

	@Then("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.homePage().addYourAddressButton);
		logger.info("User clicked Add Your Address button");
	}

	@Then("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		click(factory.homePage().addCreditOrDebitCard);
		logger.info("User clicked Add a credit card or Debit Card for Payment method");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.homePage().placeYourOrderButton);
		logger.info("User click on Place Your Order");
	}

	@Then("a message should be displayed Order Placed, Thanks’")
	public void aMessageShouldBeDisplayedOrderPlacedThanks() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().orderPlacedThanks));
		logger.info("a message is displayed ‘Order Placed, Thanks’");
	}

}
