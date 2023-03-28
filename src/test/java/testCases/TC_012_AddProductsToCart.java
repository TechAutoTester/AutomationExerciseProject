package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductsLandingPage;
import testBase.BaseClass;

public class TC_012_AddProductsToCart extends BaseClass{
	
	@Test(groups= {"sanity"})
	public void test_AddProductsToCart() {
		try {
		logger.info("*** Started TC_012_AddProductsToCart ***");
		HomePage hp =new HomePage(driver);
		hp.click_products();
		logger.info("**** clicked on products *****");
		
		ProductsLandingPage plp=new ProductsLandingPage(driver);
		Actions ac=new Actions(driver);
		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].scrollIntoView()", plp.productwrapper(1));
		logger.info("***** scroll to product 1 ****");
		ac.moveToElement(plp.productwrapper(1)).moveToElement(plp.productAddCart(1)).click().perform();
		logger.info("**** hover on product1 and clicked on add to cart button ****");
		
		plp.clickContinueShopping();
		logger.info("***** clicked on continue shopping ****");
		
		ac.moveToElement(plp.productwrapper(2)).moveToElement(plp.productAddCart(2)).click().perform();
		logger.info("**** hover on product2 and clicked on add to cart ***");
		
		plp.clickViewCart();
		logger.info("**** clicked on view cart *****");
		
		CartPage cp=new CartPage(driver);
//		Assert.assertEquals(cp.verifyProductslist(),2 );
//		logger.info("**** validated number of products added to cart *****");
		
		Assert.assertEquals(cp.verifyCartprice(), true);
		logger.info("**** validated cart prices *****");
		
		Assert.assertEquals(cp.verifyQuantity(),true);
		logger.info("**** validated quantity *****");
		
		Assert.assertEquals(cp.verifyTotalprice(), true);
		logger.info("**** validated total price *****");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
	
	}

}
