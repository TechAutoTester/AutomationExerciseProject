package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SinupLoginPage;

public class TC_005_Register_user_existingEmail extends BaseClass{
	
	@Test(groups= {"sanity","Regression"})
	public void test_existing_Email()
	{	
		try {
			
		logger.info("****** Satrted TC_005_Register_user_existingEmail *****");
		HomePage hp=new HomePage(driver);
		hp.click_sinup_login();
		logger.info("**** Clicked on Sinup link ******");
		
		SinupLoginPage sp=new SinupLoginPage(driver);
		Assert.assertEquals(sp.verify_newUser_sinup(), true);
		logger.info("**** Verify the element new user sinup is visible********");
		
		sp.setName(rb.getString("name"));
		sp.setemail(rb.getString("email"));
		sp.clicksinupbutton();
		
		Assert.assertEquals(sp.verify_Exist_email_msg(),true);
		logger.info("**** Verify the msg Email Address already exist!********");
		}
		catch(Exception e) {
			Assert.fail();;
		}
	}

}
