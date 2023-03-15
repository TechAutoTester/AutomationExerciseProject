package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SinupLoginPage;
import testBase.BaseClass;

public class TC_004_LogoutTestValid extends BaseClass{
	
	@Test(groups= {"Sanity","Regression"})
	public void test_Login() {
		try{
			HomePage hp=new HomePage(driver);	
		hp.click_sinup_login();
		logger.info("**** Clicked on signup link****");
	
	SinupLoginPage sp=new SinupLoginPage(driver);
	boolean logintoAccount=sp.verify_login_acc_is_visible();
	Assert.assertEquals(logintoAccount,true);
	
	logger.info("**** validated the login to your account text is visible ****");
	
	sp.enter_email("vasu143@gmail.com");
	
	logger.info("***** entered email id  ******");
	
	sp.enter_passwd("vasu@143");
	
	logger.info("***** entered password  ******");
	
	sp.click_login_btn();
	
	logger.info("***** Clicked on login button  ******");
	boolean logout_btn=hp.verify_LogHomePage();
	
	Assert.assertEquals(logout_btn,true);
	
	logger.info("***** Validating the logout link in Loggedin homepage ******");
	
	hp.click_Logout_btn();
	
	logger.info("***** Clicked on logout button  ******");
	
	Assert.assertEquals(logintoAccount,true);
	
	logger.info("**** validating the login to your account text is visible ****");
		}
		catch(Exception e) {
			Assert.fail();
		}

}
}
