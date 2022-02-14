package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.Driver;

public class DemoQAPage {
	
	public DemoQAPage () {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}

	@FindBy (xpath ="//div[contains(text(),'Do you like the site?')]")
	public WebElement doYoLikeText;
	
	@FindBy (xpath = "//label[@for='yesRadio']")
	public WebElement yesradioLabel;
	
	@FindBy (xpath = "//label[@for='impressiveRadio']")
	public WebElement impressiveRadio;
	

	public WebElement noRadio;
	
	@FindBy (css = ".mt-3")
	public WebElement radioSelectText;
	
    @FindBy (id = "alertButton")
    public WebElement Alert1;
    
 
    public WebElement timerAlertButton;
    
    public WebElement confirmButton;
	
	
	
}
