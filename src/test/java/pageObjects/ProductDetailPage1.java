package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage1 extends BasePage{

	public ProductDetailPage1(WebDriver driver) {
		super(driver);
	}
	//Web elements pending ...need to change
	@FindBy(xpath="//h2[normalize-space()='Blue Top']")
	WebElement txt_productName;
	
	@FindBy(xpath="//p[contains(text(),'Category')]")
	WebElement productCategory;
	
	@FindBy(xpath="//span[contains(text(),'Rs.')]")
	WebElement productPrice;
	
	@FindBy(xpath="//b[contains(text(),'Availability:')]")
	WebElement productAvailability;
	
	@FindBy(xpath="//b[contains(text(),'Condition:')]")
	WebElement productCondition;
	
	@FindBy(xpath="//b[contains(text(),'Brand:')]")
	WebElement productBrand;
	
	//Actions
	
	public boolean verify_product_name() {
		try{return(txt_productName.isDisplayed());
	}
		catch(Exception e) {
			return false;
			}
	}
	
	public boolean verify_product_Category() {
		return(productCategory.isDisplayed());
	}
	
	public boolean verify_product_price() {
		return(productPrice.isDisplayed());
	}
	
	public boolean verify_ailability() {
		return(productAvailability.isDisplayed());
	}
	
	public boolean verify_condition() {
		return(productCondition.isDisplayed());
	}
	
	public boolean verify_brand() {
		return(productBrand.isDisplayed());
	}
	
	
	
	
	
	
	
}
