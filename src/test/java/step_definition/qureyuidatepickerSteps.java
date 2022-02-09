package step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.JqureyuidatepickerPage;
import utilites.Driver;
import utilites.PropertiesReader;

public class qureyuidatepickerSteps {
	
	JqureyuidatepickerPage pickerpage = new JqureyuidatepickerPage();

	@Given("I am on the Jqureyui date page")
	public void i_am_on_the_jqureyui_date_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("JqureyuiUrl"));
	   
	}
	@When("I enterd {string} to date picker")
	public void i_enterd_to_date_picker(String dates) {
	    pickerpage.DatePicker.sendKeys(dates);
	}
	@Then("The Date entered should be selected")
	public void the_date_entered_should_be_selected() {
	    
	}

	
}
