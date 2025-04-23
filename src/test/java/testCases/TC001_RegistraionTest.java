package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_RegistraionTest extends BaseClass {


	@Test(groups="Regression")
	public void Verify_registration() {
		
		try {
		logger.info("******TC001 RegistrationTest****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****Click on MyAccount");
		hp.clickRegister();
		logger.info("****Click on Registration");

		RegistrationPage rp = new RegistrationPage(driver);
		
		logger.info("***Providing details****");
		rp.setFirstName(randomeString().toUpperCase());
		rp.setLastName(randomeString().toUpperCase());
		rp.setEmail(randomeString() + "@gmail.com");
		rp.settelephone(randomNumber());
		String password = randomAlphaNumeric();
		rp.setPassword(password);
		rp.setconPassword(password);
		rp.setPrivacyPolicy();
		rp.clickContinue();
		
		logger.info("****Validating expected message****");
		String message = rp.messageDispaly();
		Assert.assertEquals(message, "Your Account Has Been Created!");
		}catch(Exception e) {
			logger.error("test failed");
			logger.debug("debugs logs");
			Assert.fail();
		}

	}

	

}
