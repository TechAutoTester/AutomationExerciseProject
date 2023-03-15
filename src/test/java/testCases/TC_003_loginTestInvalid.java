package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SinupLoginPage;
import testBase.BaseClass;

public class TC_003_loginTestInvalid extends BaseClass{
	
	@Test(groups= {"Sanity","Master"}) // groups added
	public void test_Login() {
		logger.info("****** Starting Login test with invalid data ******");
		try{
			HomePage hp=new HomePage(driver);	
		hp.click_sinup_login();
		logger.info("****** Clicked on Login link ******");
		SinupLoginPage sp=new SinupLoginPage(driver);
		boolean loginpage=sp.verify_newUser_sinup();
		Assert.assertEquals(loginpage,true);
		logger.info("***** validated the login to account is visible ");
		sp.enter_email("vasu@gmail.com");
		logger.info("***** entered email id  ******");
		sp.enter_passwd("vau@143");
		logger.info("***** entered password  ******");
		sp.click_login_btn();
		logger.info("***** Clicked on login button  ******");
		boolean invalid_credntials_msg=sp.verify_invalid_credentials();
		Assert.assertEquals(invalid_credntials_msg,true);
		logger.info("***** validated txt with expecting error ******");
		}
			catch(Exception e) {
				Assert.fail();
		}
}
}
