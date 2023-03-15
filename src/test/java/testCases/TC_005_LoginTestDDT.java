package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SinupLoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_005_LoginTestDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginTestDDT(String email,String password,String status) {
		
		logger.info("***** TC_005_LoginTestDDT test started *****");
		try 
		{
		HomePage hp= new HomePage(driver);
		hp.click_sinup_login();
		 logger.info("****** Clicked on login link******");
		SinupLoginPage sp=new SinupLoginPage(driver);
		sp.enter_email(email);
		logger.info("***** Entered the email from data provider ******");
		sp.enter_passwd(password);
		logger.info("***** Entered the password from data provider ******");
		sp.click_login_btn();
		logger.info("***** clicked on login button******");
		logger.info("***** Started validating the login page with DDT******");
		boolean loggedmsg=hp.verify_LogHomePage();
		
		if(status.equals("valid")) 
		{
			if(loggedmsg==true) 
			{
				hp.click_Logout_btn();
				Assert.assertTrue(true);	
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		else
		{
			if(loggedmsg==true) 
			{
				hp.click_Logout_btn();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("***** test completed******");
		
	}

}
