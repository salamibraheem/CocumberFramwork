package step_definition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.TradeJournalLoginPage;
import utilites.Driver;
import utilites.PropertiesReader;

public class TradeJournalLoginSteps {
	
	
	TradeJournalLoginPage tradePage = new TradeJournalLoginPage();
	
	
	// valid test #Starts
	@Given("I am on tradeJournal sign in page")
	public void i_am_on_trade_journal_sign_in_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("TradeJournaUrl"));
	   
	}
	@Given("The sing in button displays")
	public void the_sing_in_button_displays() {
		Assert.assertTrue(tradePage.button.isDisplayed());	    
	}
	@When("I enter valid username {string} and valid password {string}")
	public void i_enter_valid_username_and_valid_password(String name, String password) {
	    tradePage.userName.sendKeys(name);
	    tradePage.password.sendKeys(password);
		
	}
	@When("I click the sign in button")
	public void i_click_the_sign_in_button() {
		tradePage.button.click();
	    
	}
	@Then("I should be directed to home page")
	public void i_should_be_directed_to_home_page() {
		Assert.assertTrue(tradePage.logOut.isDisplayed());
	    
	}
	
	// valid test #Ends
	
	// Invalid test #Starts
	
	@Given("The Sign in button displays")
	public void the_sign_in_button_displays() {
		Assert.assertTrue(tradePage.button.isDisplayed());
	}

	
	@When("I enter invalid username {string} and Invalid password {string}")
	public void i_enter_invalid_username_and_invalid_password(String username, String password) {
	    tradePage.userName.sendKeys(username);
	    tradePage.password.sendKeys(password);
		
	}
	
	
	@Then("I should not be sign in")
	public void i_should_not_be_sign_in() {
		tradePage.button.click();
		Assert.assertTrue(tradePage.userName.isDisplayed());
	   
		
	}
	@Then("Error message will display {string}")
	public void error_message_will_display(String text) {
	 Assert.assertEquals(tradePage.errorMessageText.getText(), text);
		
	}

	// Invalid test #Ends
	
   // Logout test#Starts 
	
	@Given("I am on tradeJournal hame page")
	public void i_am_on_trade_journal_hame_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("TradeHomeUrl"));
	    
	}
	@When("I am click on the Logout buttom")
	public void i_am_click_on_the_logout_buttom() {
		tradePage.logOut.click();
	    
	}
	@Then("I should directed to logout page following a message {string}")
	public void i_should_directed_to_logout_page_following_a_message(String LogOutMessageDispalys) {
	   Assert.assertEquals(tradePage.logOutMessage.getText(), LogOutMessageDispalys);
	}
	@Then("I clicked on click on log out button")
	public void i_clicked_on_click_on_log_out_button() {
		tradePage.logOutbutton.click();
	   
	}
	@Then("I should directed to sign in page following a message placed {string}")
	public void i_should_directed_to_sign_in_page_following_a_message_placed(String headMessage) {
	   Assert.assertEquals(tradePage.text.getText(),headMessage );
		
	}
	


}
