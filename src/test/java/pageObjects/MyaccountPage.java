package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {

	public MyaccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Account']")
	WebElement myAccountHeading;
	
	
	public boolean verify_myaccount() {
		try {
		return (myAccountHeading.isDisplayed());
		}catch(Exception e) {
			return false;
		}
		}
	}


