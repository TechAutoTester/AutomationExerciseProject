package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductsLandingPage;
import testBase.BaseClass;

public class TC_009_VerifySearchProduct extends BaseClass{
	
	@Test(groups= {"sanity"})
	public void test_search_product() {
		try {
		logger.info("***** Started TC_009_VerifySearchProduct *****");
		HomePage hp=new HomePage(driver);
		hp.click_products();
		logger.info("***** Clicked on products link *****");
		ProductsLandingPage plp=new ProductsLandingPage(driver);
		Assert.assertEquals(plp.verifyAll_products(),true);
		logger.info("***** validated all products *******");
		
		plp.searchProduct("Saree");
		plp.click_search_btn();
		logger.info("**** clicked search button ****");
		Assert.assertEquals(plp.verifySearchedProducts(),true);
		logger.info("***** validated searched products txt *****");
		
		for(int i=2;i<5;i++) {
			if(plp.productname(i).contains("Saree")) {
				logger.info("***** validated the searched product name *********");
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		
		
		
	}

}
