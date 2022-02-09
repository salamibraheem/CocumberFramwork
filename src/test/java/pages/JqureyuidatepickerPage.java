package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.Driver;

public class JqureyuidatepickerPage {
	
	public JqureyuidatepickerPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	@FindBy (css = ".hasDatepicker")
	public WebElement DatePicker;
	

}
