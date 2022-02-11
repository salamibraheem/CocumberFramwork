package pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.Driver;

public class TradeJournalLoginPage {

	public TradeJournalLoginPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (css =".btn")
     public WebElement button; 	

	@FindBy (id ="username")
    public WebElement userName;
	
	@FindBy (id ="password")
    public WebElement password;
	
	@FindBy (css = ".form-signin-heading")
	public WebElement sigInText;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement logOut;
	
	@FindBy (xpath = "//div[@class='alert alert-danger']")
	public WebElement errorMessageText;
	
	@FindBy(xpath="//h2")
	public WebElement logOutMessage;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement logOutbutton;
	
	@FindBy (xpath="//div[@role='alert' and @class='alert alert-success']")
	public WebElement text;
	
}
