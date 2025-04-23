package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	
	@Test(groups="Sanity")
	public void verify_Login() {
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****Click on MyAccount");
		hp.clickLogin();
		logger.info("****Click on Login");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(pro.getProperty("valid_email"));
		lp.enterPassword("valid_password");
		lp.clickLogin();
		
		MyaccountPage mp=new MyaccountPage(driver);
		boolean status=mp.verify_myaccount();
		Assert.assertTrue(status);
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
}

