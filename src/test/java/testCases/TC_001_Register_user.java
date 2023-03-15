package testCases;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountCreatedPage;
import pageObjects.HomePage;
import pageObjects.SinupLoginPage;
import testBase.BaseClass;
import pageObjects.EnterAccountInfoPage;
import pageObjects.AccountDeletedPage;
public class TC_001_Register_user extends BaseClass{
	
		
	@Test(priority=1,groups={"Sanity","Regression"})
	public void test_signupPage(){
		logger.info("****logstarting TC_001_Register_user Test*****");
		
		try {
		
		HomePage hp=new HomePage(driver);
		hp.click_sinup_login();
		logger.info("***** Clicked on sinup Link *****");
		SinupLoginPage sp=new SinupLoginPage(driver);
		boolean signUpPage=sp.verify_newUser_sinup();
		Assert.assertEquals(signUpPage,true);
		logger.info("***** Validated the New User Signup! title *****");
		}
		catch(Exception e) {
			Assert.fail();
			logger.error("******* test_signupPage test failed *******");
		}
		try {
			
			String name=randomString(6).toUpperCase();
			SinupLoginPage sp=new SinupLoginPage(driver);
			sp.setName(name);
			logger.info("***** Started Entering the account details *******");
			String emailId=randomString(5)+"143@gmail.com";
			sp.setemail(emailId);
			sp.clicksinupbutton();
			logger.info("******** CLicked on sinup button *********");
			EnterAccountInfoPage ec=new EnterAccountInfoPage(driver);
			ec.click_male_radio_btn();
			logger.info("**** clicked on rd_btn ******");
			ec.set_password(randomAlphanumeric());
			logger.info("**** set password ******");
			ec.select_day("11");
			logger.info("**** set day from drpdown ******");

			ec.select_month("January");
			logger.info("**** set month drpdown ******");

			ec.select_year("1998");
			logger.info("**** set year drpdown ******");

			JavascriptExecutor ex= (JavascriptExecutor)driver;
			ex.executeScript("arguments[0].click();",ec.checkboxesElements());
			logger.info("**** clicked on newsletter checbox ******");
			
			ex.executeScript("arguments[0].click();", ec.checkbox_option());
			ec.checkbox_option();
			logger.info("**** clicked on option checbox ******");

			ec.set_first_name(randomString(6));
			logger.info("**** set firstname ******");

			ec.set_last_name(randomString(4));
			logger.info("**** set lastname ******");

			ec.set_companyname("Andhra solutions");
			logger.info("**** set companyname ******");

			ec.set_address1("vskp,"+"201"+"akireddypalem");
			logger.info("**** set address1 ******");

			ec.set_address2("andhra,"+"jnkjhkk");		
			logger.info("**** set address2 ******");
			ec.set_state("Ap");
			logger.info("**** set state ******");
			ec.set_cityname("vskp");
			logger.info("**** set cutyname ******");

			ec.set_zipcode(randomNumbers(6));
			logger.info("**** set zipcode ******");

			ec.set_mobilenumber(randomNumbers(10));
			logger.info("**** set mobile number ******");

			ex.executeScript("arguments[0].click();",ec.click_submit_btn());
			logger.info("***** Clicked on Submit button ********");
			
			AccountCreatedPage acs=new AccountCreatedPage(driver);
			boolean acc_createdmsg=acs.acc_success_msg();
			Assert.assertEquals(acc_createdmsg,true);	
			logger.info("**** Validated that account is created ******");
			}
		catch(Exception e) {
				Assert.fail();
				logger.info("****** test_acc_created test failed *****");
			}
		try {
			
		AccountCreatedPage ac=new AccountCreatedPage(driver);
		HomePage hp=new HomePage(driver);
		ac.click_continue();
		logger.info("****** Clicked on contione button after acconnt creation *******");
//		ac.go_adframe1();    ///for ad block, we have to go into 2 frame and close the ad button.
//		ac.go_adframe2();
//		ac.go_adframe3();
//		ac.adclose();
		boolean loggesInasmsg=hp.verify_LogHomePage();	
		Assert.assertEquals(loggesInasmsg,true);
		logger.info("**** validated the account is logged in as username and see the logout link ******");
			}
			catch(Exception e) {
				Assert.fail();
				logger.info("******* Logged in as username homepage test failed  **********");
		}
			
		try {
			HomePage hp=new HomePage(driver);
			hp.click_delete_account();
			logger.info("****** Clicked on Delete account button ***********");
			
			AccountDeletedPage acdp=new AccountDeletedPage(driver);
			boolean accDeleteMsg=acdp.acc_delete_msg();	
			Assert.assertEquals(accDeleteMsg,true);
			logger.info("******* validated the account deleted msg******");
			acdp.click_continue();
		}
			catch(Exception e) {
				Assert.fail();
				logger.info("**** test_verify_delete_acc test failed ******");
			}
			}
}
	
