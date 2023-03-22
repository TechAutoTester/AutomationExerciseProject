package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_010_VerifySubscriptionInHomePage extends BaseClass{
	
	@Test(groups={"sanity"})
	public void test_subscription() {
		
		try{
		HomePage hp=new HomePage(driver);
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].scrollIntoView", hp.subscription());
		logger.info("***** scroll to footer subscription element *******");
		Assert.assertEquals(hp.verifySubscription(), true);
		logger.info("***** validated subscription txt is visible ****");
		
		hp.enterEmail(rb.getString("email"));
		logger.info("**** entered email in txtbox ****");
		hp.clickSubscribeBtn();
		logger.info("**** clicked on subscribe button ****");
		Assert.assertEquals(hp.verifySuccessMsg(),true);
		logger.info("***** validated subscription success message is visible ****");
		}
		catch(Exception e) {
			Assert.fail();
		}
			
	}

}
