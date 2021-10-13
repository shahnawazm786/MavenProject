package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Element
	@FindBy(id="search-input-field")
	WebElement searchInputField;
	
	@FindBy(id="location-text-input-field")
	WebElement locationTextInputField;
	
	// Method
	

}
