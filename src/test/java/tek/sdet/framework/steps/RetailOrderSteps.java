package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class RetailOrderSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.orderPage().ordersButton);
		logger.info("User clicked on Orders section");
	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.orderPage().cancelTheOrderButton);
		logger.info("User clicked on Cancel The Order button");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReasonBoughtWrongItem(String reason) {
		selectByVisibleText(factory.orderPage().cancelReason, reason);
		logger.info("User selected the cancelation Reason" + reason);
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orderPage().cancelOrder);
		logger.info("User clicked on Cancel Order button");
	}

	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
	public void aCancelationMessageShouldBeDisplayedYourOrderHasBeenCancelled() {
		Assert.assertTrue(isElementDisplayed(factory.orderPage().yourOrderHasBeenCancelled));

	}

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.orderPage().returnItemsBtn);
		logger.info("User clicked on Return Items button");
	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReasonItemDamaged(String returnReason) {
		selectByVisibleText(factory.orderPage().returnReasonDropDown, returnReason);
		logger.info("User select the Return Reason " + returnReason);
	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffServiceFedEx(String service) {
		selectByVisibleText(factory.orderPage().returnService, service);
		logger.info("User select the drop off service " + service);
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.orderPage().returnOrderSubmit);
		logger.info("User clicked on Return Order button");
	}

	@Then("a cancelation message should be displayed ‘Return was successful’")
	public void aCancelationMessageShouldBeDisplayedReturnWasSuccessful() {
		waitTillPresence(factory.orderPage().returtWasSuccessfull);
		Assert.assertTrue(isElementDisplayed(factory.orderPage().returtWasSuccessfull));
	}
	
	@When("User click on Review button")
	public void userClickOnReviewButton() {
	    click(factory.orderPage().reviewButton);
	    logger.info("User clicked on Review button");
	}
	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headlineValue, String reviewText) {
	     sendText(factory.orderPage().headlineInputField, headlineValue);
	     sendText(factory.orderPage().desctiptionField, reviewText);
	}
	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
	    click(factory.orderPage().reviewSubmitButton);
	    logger.info("User clicked Add your Review button");
	}
	@Then("a review message should be displayed ‘Your review was added successfully’")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully() {
		waitTillPresence(factory.orderPage().yourReviewWasAddedSuccessfully);
	    Assert.assertTrue(isElementDisplayed(factory.orderPage().yourReviewWasAddedSuccessfully));
	}

}
