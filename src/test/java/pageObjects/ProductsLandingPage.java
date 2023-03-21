package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsLandingPage extends BasePage{
	
	public ProductsLandingPage(WebDriver driver) {
		super(driver);
	}
	
	//web elements
	@FindBy(xpath="//h2[normalize-space()='All Products']")
	WebElement linkProducts;
	
	@FindBy(css="a[href='/product_details/1']")
	WebElement linkViewproduct1;
	
	
	
	
	
	
	//Actions
	public boolean verifyAll_products() {
		try{
			return(linkProducts.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public Object viewproduct1() {
		try{
			return(linkViewproduct1);
	}
		catch(Exception e){
			return false;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
