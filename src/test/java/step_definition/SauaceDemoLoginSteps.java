package step_definition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauaceDemoLoginPage;
import utilites.BrowserUtils;
import utilites.Driver;
import utilites.PropertiesReader;

public class SauaceDemoLoginSteps {
	
	SauaceDemoLoginPage page = new SauaceDemoLoginPage();
	BrowserUtils utils = new BrowserUtils();
	
	
	// valid test #Starts
	@Given("I am on the SauceDemo login page")
	public void i_am_on_the_suace_demo_login_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("sauceUrl"));
		
	}
	@When("I enter valid username {string} password {string}")
	public void i_enter_valid_username_password(String uesename, String password) {
	   page.username.sendKeys(uesename);
	   page.password.sendKeys(password);
	  
		
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		 page.loginButton.click();
	}
	 
	@Then("I should be directed to inventory page")
	public void i_should_be_directed_to_inventory_page() {
		Assert.assertTrue(page.inventoryPageProductText.isDisplayed());
		
	    
	}
	@Then("There should be {int} items in the page")
	public void there_should_be_items_in_the_page(Integer number) {
		Assert.assertTrue(number==page.inventoryItims.size());
		Assert.assertSame(number, page.inventoryItims.size());
	   
		// valid test #Ends
}  

	// Invalid tests #Starts
	@When("I enter invalid username {string} password {string}")
	public void i_enter_invalid_username_password(String username, String invalidPassword) {
		page.username.sendKeys(username);
		page.password.sendKeys(invalidPassword);
	}
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
	    Assert.assertTrue(page.username.isDisplayed());
	    Assert.assertFalse(utils.isElementPresent(page.inventoryPageProductText));
	}
	@Then("Error message should display {string}")
	public void error_message_should_display(String errorMessage) {
	    Assert.assertEquals(page.errorMessage.getText(), errorMessage);
	 
	}

	// Invalid test #Ends
	
} 