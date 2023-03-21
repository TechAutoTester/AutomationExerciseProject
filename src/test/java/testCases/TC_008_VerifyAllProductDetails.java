package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDetailPage1;
import pageObjects.ProductsLandingPage;
import testBase.BaseClass;

public class TC_008_VerifyAllProductDetails extends BaseClass{

	
	@Test(groups={"sanity"})
	public void test_verifyProductDetails() {
		try {
		logger.info("***** Started TC_008_VerifyAllProductDetails *****");
		HomePage hp=new HomePage(driver);
		hp.click_products();
		logger.info("***** Clicked on products link *****");
		ProductsLandingPage plp=new ProductsLandingPage(driver);
		Assert.assertEquals(plp.verifyAll_products(),true);
		logger.info("***** validated all products *******");
		
		JavascriptExecutor ex= (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();",plp.viewproduct1());
		logger.info("***** clicked on first view product *****");
		
		ProductDetailPage1 pdp=new ProductDetailPage1(driver);
		Assert.assertEquals(pdp.verify_product_name(), true);
		logger.info("***** validated product name *******");
		Assert.assertEquals(pdp.verify_product_Category(), true);
		logger.info("***** validated product category *******");
		Assert.assertEquals(pdp.verify_product_price(), true);
		logger.info("***** validated product price *******");
		Assert.assertEquals(pdp.verify_ailability(), true);
		logger.info("***** validated product availability *******");
		Assert.assertEquals(pdp.verify_condition(), true);
		logger.info("***** validated product condition *******");
		Assert.assertEquals(pdp.verify_brand(), true);	
		logger.info("***** validated product brand *******");
		logger.info("***** testCase passed");
	}
		catch(Exception e) {
			Assert.fail();
		}
	
}
	
	
	
}
