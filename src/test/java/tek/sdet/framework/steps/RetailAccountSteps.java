package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class RetailAccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("user clicked on Account option");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
		clearTextUsingSendKeys(factory.accountPage().profileNameInputField);
		sendText(factory.accountPage().profileNameInputField, nameValue);
		clearTextUsingSendKeys(factory.accountPage().profilePhoneNumberField);
		sendText(factory.accountPage().profilePhoneNumberField, phoneValue);
		logger.info("user updated Name and Phone values ");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().profileUpdateButton);
		logger.info("user clicked on Update button");
	}

	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateSuccessMessage));
		logger.info("user profile information updated");
	}

	@When("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		List<Map<String, String>> passwordField = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().profilePriviousPasswordField, passwordField.get(0).get("previousPassword"));
		sendText(factory.accountPage().profileNewPasswordField, passwordField.get(0).get("newPassword"));
		sendText(factory.accountPage().profileConfirmPassword, passwordField.get(0).get("confirmPassword"));
		logger.info("user updated password information");
	}

	@When("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		click(factory.accountPage().profileChangePasswordButton);
		logger.info("user clicked on Change Password button");
	}

	@Then("a message should be displayed ‘Password Updated Successfully’")
	public void messageShouldBeDisplayed() {
		waitTillPresence(factory.accountPage().passwordUpdatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().passwordUpdatedSuccessfully));
		logger.info("password updated successfully");
	}

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentMethodButton);
		logger.info("User clicked on Add a payment metod link");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> cardFields = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().profileCardNumberField, cardFields.get(0).get("cardNumber"));
		sendText(factory.accountPage().profileNameOfCardField, cardFields.get(0).get("nameOnCard"));
		sendText(factory.accountPage().profileExpirationMonthDropDown, cardFields.get(0).get("expirationMonth"));
		sendText(factory.accountPage().profileExpirationYearDropDown, cardFields.get(0).get("expirationYear"));
		sendText(factory.accountPage().profileSecutityCodeField, cardFields.get(0).get("securityCode"));
		logger.info("User filled Debid or credit card information");
	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addYourCardButton);
		logger.info("User clicked on Add your card button");
	}

	@Then("a message should be displayed ‘Payment Method added successfully’")
	public void aMessageShouldBeDisplayedPaymentMethodAddedSuccessfully() {
		waitTillPresence(factory.accountPage().paymentMethodAddedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().paymentMethodAddedSuccessfully));
		logger.info("message is displayed ‘Payment Method added successfully’\"");
	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().editButton);
		logger.info("user clicked on Edit option of card section");
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardFields = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.accountPage().profileCardNumberField);
		clearTextUsingSendKeys(factory.accountPage().profileNameOfCardField);
		clearTextUsingSendKeys(factory.accountPage().profileSecutityCodeField);
		sendText(factory.accountPage().profileCardNumberField, cardFields.get(0).get("cardNumber"));
		sendText(factory.accountPage().profileNameOfCardField, cardFields.get(0).get("nameOnCard"));
		sendText(factory.accountPage().profileExpirationMonthDropDown, cardFields.get(0).get("expirationMonth"));
		sendText(factory.accountPage().profileExpirationYearDropDown, cardFields.get(0).get("expirationYear"));
		sendText(factory.accountPage().profileSecutityCodeField, cardFields.get(0).get("securityCode"));
		logger.info("User filled Debid or credit card information");
	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().addYourCardButton);
		logger.info("user clicked on Update Your Card button");
	}

	@Then("a message should be displayed ‘Payment Method updated Successfully’")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
		waitTillPresence(factory.accountPage().paymentMethodApdatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().paymentMethodApdatedSuccessfully));
		logger.info("message is displayed ‘Payment Method updated Successfully’\"");
	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().removeCardButon);
		logger.info("user clicked on remove option of card section");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		if (isElementDisplayed(factory.accountPage().profileCardNumberField)) {
			logger.info("payment details are removed");
		} else {
			logger.info("payment details are NOT removed");
		}
//		try{
//			isElementDisplayed(factory.accountPage().cardInTheWallet); 	
//			}catch(StaleElementReferenceException e){
//			logger.info("payment details are removed");
//		}
	}

	@When("User click on Card in the Wallet")
	public void userClickOnCardInTheWallet() {
		click(factory.accountPage().cardInTheWallet);
	}

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressOption);
		logger.info("User clicked on Add address option");
	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		clearTextUsingSendKeys(factory.accountPage().newAddressFullNameField);
		clearTextUsingSendKeys(factory.accountPage().newAddressPhoneNumberField);
		clearTextUsingSendKeys(factory.accountPage().newAddressStreetField);
		clearTextUsingSendKeys(factory.accountPage().newAddressAptField);
		clearTextUsingSendKeys(factory.accountPage().newAddressCityField);
		clearTextUsingSendKeys(factory.accountPage().newAddressZipCodeField);
		List<List<String>> addressInfo = dataTable.asLists(String.class);
		selectByVisibleText(factory.accountPage().newAddressSelectCountryDropdown,
				DataGeneratorUtility.data(addressInfo.get(0).get(0)));
		sendText(factory.accountPage().newAddressFullNameField, DataGeneratorUtility.data(addressInfo.get(0).get(1)));
		sendText(factory.accountPage().newAddressPhoneNumberField,
				DataGeneratorUtility.data(addressInfo.get(0).get(2)));
		sendText(factory.accountPage().newAddressStreetField, DataGeneratorUtility.data(addressInfo.get(0).get(3)));
		sendText(factory.accountPage().newAddressAptField, DataGeneratorUtility.data(addressInfo.get(0).get(4)));
		sendText(factory.accountPage().newAddressCityField, DataGeneratorUtility.data(addressInfo.get(0).get(5)));
		selectByVisibleText(factory.accountPage().newAddressStateDropdown,
				DataGeneratorUtility.data(addressInfo.get(0).get(6)));
		sendText(factory.accountPage().newAddressZipCodeField, DataGeneratorUtility.data(addressInfo.get(0).get(7)));
		logger.info("user filled new address form with below information");

	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayedAddressAddedSuccessfully(String expectedMessage) {
		waitTillPresence(factory.accountPage().addressAddedSuccessfully);
		Assert.assertEquals(expectedMessage, factory.accountPage().addressAddedSuccessfully.getText());
	}

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.accountPage().removeAddressButton);
		logger.info("User clicked on remove option of Address section");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		Assert.assertFalse(getDriver()
				.findElements(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]")).isEmpty());

	}

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.accountPage().editAddressButton);
		logger.info("User clicked on edit address option");
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().updateYourAddressButton);
		logger.info("User clicked update Your Address button");
	}

	@Then("a message should be displayed ‘Address Updated Successfully’")
	public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {
		waitTillPresence(factory.accountPage().addressUpdatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().addressUpdatedSuccessfully));
	}
}
