package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_011_VerifySubscriptionInCartPage extends BaseClass{
	
	@Test(groups= {"sanity"})
	
	public void test_subscriptionInCart() {
		try {
		logger.info("**** Started TC_011_VerifySubscriptionInCartPage testCase ****");
		HomePage hp=new HomePage(driver);
		hp.clickCart();
		logger.info("***** clicked on cart link *****");
		CartPage cp=new CartPage(driver);
		cp.verifySubscription();
		logger.info("**** validated the subscription txt ****");
		cp.enterEmail(rb.getString("email"));
		cp.clickSubscribeBtn();
		logger.info("**** clicked on subscribe button");
		Assert.assertEquals(cp.verifySuccessMsg(), true);
		logger.info("**** validated the success message *****");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}

}
