package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductsLandingPage;
import testBase.BaseClass;

public class TC_009_VerifySearchProduct extends BaseClass{
	
	@Test(groups= {"sanity"})
	public void test_search_product() {
		
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
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].scrollIntoView();",plp.productname("saree"));
		plp.productname("saree");
		logger.debug("errormessasge");
		logger.info("*** validated all the products ****");
		//pending remaining
		
		
		
		
		
	}

}
