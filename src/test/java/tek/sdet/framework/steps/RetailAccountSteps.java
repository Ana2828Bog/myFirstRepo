package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;


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
		List<Map<String,String>> passwordField = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().profilePriviousPasswordField,passwordField.get(0).get("previousPassword"));
		sendText(factory.accountPage().profileNewPasswordField,passwordField.get(0).get("newPassword"));
		sendText(factory.accountPage().profileConfirmPassword,passwordField.get(0).get("confirmPassword"));
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
	    List<Map<String,String>> cardFields = dataTable.asMaps(String.class, String.class);
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
		List<Map<String,String>> cardFields = dataTable.asMaps(String.class, String.class);
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
		if(isElementDisplayed(factory.accountPage().profileCardNumberField)) {
			logger.info("payment details are removed");
		}else {
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
}
