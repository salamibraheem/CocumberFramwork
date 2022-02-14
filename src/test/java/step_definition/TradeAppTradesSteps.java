package step_definition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppTradesPage;
import utilites.BrowserUtils;
import utilites.Driver;
import utilites.PropertiesReader;

public class TradeAppTradesSteps {
	
	TradeAppTradesPage tradepage = new TradeAppTradesPage();
	BrowserUtils utils = new BrowserUtils();
	
	 String stockSymbol;
     String stockEntryPrice;
	
	@Given("I am on the Trade App Log in page")
	public void i_am_on_the_trade_app_log_in_page() {
	   Driver.getDriver().get(PropertiesReader.getProperty("TradeJournaUrl"));
	   Assert.assertTrue(tradepage.pleaseSignInText.isDisplayed());
	}
	@When("I enter username {string} password {string}")
	public void i_enter_username_password(String userName, String password) {
		tradepage.username.sendKeys(userName);
		tradepage.password.sendKeys(password);
	
	}
	@When("I click on Trade login button")
	public void i_click_on_trade_login_button() {
	  tradepage.signInBtn.click();
	}
	@Then("I shoud be on Trade homepage")
	public void i_shoud_be_on_trade_homepage() {
		Assert.assertTrue(tradepage.tradeIconImage.isDisplayed());
		Assert.assertTrue(tradepage.addBtn.isDisplayed());
	
	}
	@When("I click on add Trade button")
	public void i_click_on_add_trade_button() {
		tradepage.addBtn.click();
	   
	}
	@Then("I shoud be on Save Trade page")
	public void i_shoud_be_on_save_trade_page() {
		Assert.assertTrue(tradepage.saveTradeText.isDisplayed());
	   
	}
	@When("I select {string} and I enter symbol {string} entryDate {string} entryPrice {string} exitDate {string} exitPrice {string}")
	public void i_select_and_i_enter_symbol_entry_date_entry_price_exit_date_exit_price(String buyOrsell, String symbol, String entryDate, String entryPrice, String exitDate, String exitPrice) {
	   stockSymbol = symbol;
	   stockEntryPrice= buyOrsell;
	   utils.selectByVisibleText(tradepage.byOrSellDropDown, buyOrsell);
	   tradepage.stockSymbol.sendKeys(symbol);
	   tradepage.openDate.sendKeys(entryDate);
	   tradepage.stockEntryPrice.sendKeys(entryPrice);
	   tradepage.closeDate.sendKeys(exitDate);
	   tradepage.stockExitPrice.sendKeys(exitPrice);
	}
	@When("I click Save button")
	public void i_click_save_button() {
		tradepage.saveBtn.click();
	  
	}
	@Then("The trade is displayed on the trade table")
	public void the_trade_is_displayed_on_the_trade_table() {
		for (WebElement singleSymbol : tradepage.stockSymbols) {
			if (singleSymbol.getText().equals(stockSymbol)) {
				Assert.assertEquals(singleSymbol.getText(), stockSymbol);;
		}
	}


}
}
