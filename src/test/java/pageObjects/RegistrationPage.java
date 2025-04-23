package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txttelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConPass;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void settelephone(String telephone) {
		txttelephone.sendKeys(telephone);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setconPassword(String conPassword) {
		txtConPass.sendKeys(conPassword);
	}

	public void setPrivacyPolicy() {
		privacyPolicy.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public String messageDispaly() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}
