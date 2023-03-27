package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_012_AddProductsToCart extends BaseClass{
	
	@Test
	public void test_AddProductsToCart() {
		
		HomePage hp =new HomePage(driver);
		hp.click_products();
		
		
		
		
	}

}
