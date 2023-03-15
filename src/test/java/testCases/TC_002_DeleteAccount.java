package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountDeletedPage;
import pageObjects.HomePage;
import pageObjects.SinupLoginPage;
import testBase.BaseClass;


public class TC_002_DeleteAccount extends BaseClass{
	
	
	@Test(groups= {"Master"})
	public void test_Login() {
		logger.info("***** Started TC_002_LoginTest   ******");
		try {
		HomePage hp=new HomePage(driver);	
		hp.click_sinup_login();
		logger.info("****** Clicked on Login link ******");
		SinupLoginPage sp=new SinupLoginPage(driver);
		boolean loginMsgtxt=sp.verify_login_acc_is_visible();
		Assert.assertEquals(loginMsgtxt,true);
		logger.info("***** validated the login to account is visible ");
		sp.enter_email("vasu143@gmail.com");
		logger.info("***** entered email id  ******");
		sp.enter_passwd("vasu@143");
		logger.info("***** entered password  ******");
		sp.click_login_btn();
		logger.info("***** Clicked on login button  ******");
		boolean loggesInasmsg=hp.verify_LogHomePage();	
		Assert.assertEquals(loggesInasmsg,true);
		logger.info("***** validated the loggedIn as user is visible ");
		hp.click_delete_account();
		logger.info("***** Clicked on delete account  link ");
		AccountDeletedPage acdp=new AccountDeletedPage(driver);
		boolean accDeleteMsg=acdp.acc_delete_msg();	
		Assert.assertEquals(accDeleteMsg,true);
		logger.info("***** Validated the account deleted message ");
	}	
		catch (Exception e) {
			Assert.fail();
		}
	
	
	
		
		
		
		
		
		
	
		
	}

}
