package step_definition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoQAPage;
import utilites.BrowserUtils;
import utilites.Driver;

public class DemoAQSteps {
	DemoQAPage demoPage = new DemoQAPage();
	BrowserUtils utils = new BrowserUtils();
	
	// demo Radio page element# Starts
	@Given("I am on the radio button webpage {string}")
	public void i_am_on_the_radio_button_webpage(String url) {
	 Driver.getDriver().get(url);
	 utils.waitUntilElementVisible(demoPage.doYoLikeText);
	 Assert.assertTrue(demoPage.doYoLikeText.isDisplayed());
	}
	@When("I select {string}")
	public void i_select(String radioOption) {
		Assert.assertFalse(demoPage.noRadio.isEnabled());
		
		if (radioOption.equals("Yes")&& demoPage.yesradioLabel.isEnabled()) {
			demoPage.yesradioLabel.click();
		}
	     if (radioOption.equals("Impressive")&&demoPage.impressiveRadio.isEnabled()) {
	    	 demoPage.impressiveRadio.click();
	     }
	}
	@Then("A text {string} displays")
	public void a_text_displays(String textResults) {
		utils.waitUntilElementVisible(demoPage.radioSelectText);
		Assert.assertEquals(demoPage.radioSelectText.getText(), textResults);
		Assert.assertEquals(demoPage.radioSelectText.getText(), textResults); 
		
		// demo Radio page element #Ends
	}

	// Alert 1 steps #Starts
	
	@Given("I an on the Alert page {string}")
	public void i_an_on_the_alert_page(String url) {
	   Driver.getDriver().get(url);
	  Assert.assertTrue(demoPage.Alert1.isDisplayed());
	}
	@When("I click on AlertButton element")
	public void i_click_on_alert_button_element() {
		demoPage.Alert1.click();
	}
	@Then("I am able to accept the Alert")
	public void i_am_able_to_accept_the_alert() {
		utils.waitUntilAlertIsPresent();
		utils.alertAccept();
		
	   
	}
	// Alert 1 steps #Ends
}
