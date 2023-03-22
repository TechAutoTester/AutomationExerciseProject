package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.Assert;

public class ProductsLandingPage extends BasePage{
	
	public ProductsLandingPage(WebDriver driver) {
		super(driver);
	}
	
	//web elements
	@FindBy(xpath="//h2[normalize-space()='All Products']")
	WebElement linkProducts;
	
	@FindBy(css="a[href='/product_details/1']")
	WebElement linkViewproduct1;
	
	@FindBy(id="search_product")
	WebElement txtbox_search;
	
	@FindBy(id="submit_search")
	WebElement searchtn;
	
	@FindBy(xpath="//h2[contains(text(),'Searched Products')]")
	WebElement txtSearchedProducts;
	

	
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
	
	public void searchProduct(String productName) {
		txtbox_search.sendKeys(productName);
	}
	
	public void click_search_btn() {
		searchtn.click();
	}
	
	public boolean verifySearchedProducts() {
		return(txtSearchedProducts.isDisplayed());
	}
	
	public  String productname(int i) {
		
			String productname=driver.findElement(By.xpath("//div["+i+"][@class='col-sm-4']/div/div/div/p")).getText();
			return productname;
			
	
}
}