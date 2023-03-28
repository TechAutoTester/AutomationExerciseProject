package pageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);	
	}
	
	//WebElements
	
	@FindBy(xpath="//h2[contains(text(),'Subscription')]")
	WebElement txtSubscription;
	
	@FindBy(id="susbscribe_email")
	WebElement txtBoxEmail;
	
	@FindBy(xpath="//button[@id='subscribe']")
	WebElement btnSubscribe;
	
	@FindBy(xpath="//div[@class='alert-success alert']")
	WebElement alertSuccessMsg;
	
	@FindBy(xpath="//tbody/tr")
	WebElement listProducts;
	
	@FindBy(xpath="//tr/td[@class='cart_price']/p")
	WebElement txtPrice;
	
	@FindBy(xpath="//tr/td[@class='cart_quantity']/button")
	WebElement txtQuantity;
	
	@FindBy(xpath="//tr/td[@class='cart_total']/p")
	WebElement txtTotalPrice;
	
	
	
	//Actions
	
	public WebElement subscription() {
		return(txtSubscription);
	}
	
	public boolean verifySubscription() {
		return(txtSubscription.isDisplayed());
	}
	
	public void enterEmail(String email){
		txtBoxEmail.sendKeys(email);
	}
	
	public void clickSubscribeBtn() {
		btnSubscribe.click();
	}
	
	public boolean verifySuccessMsg() {
		try {
		return(alertSuccessMsg.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public Dimension verifyProductslist() {
		try{
			return(listProducts.getSize());
		}
	catch(Exception e) {
		return null;
	}
	}
	
	public boolean verifyCartprice() {
		try{
			return(txtPrice.isDisplayed());
	}
		catch(Exception e) {
			return false;
		}
	}
	
	
	public boolean verifyQuantity() {
		try{
			return(txtQuantity.isDisplayed());
	}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean verifyTotalprice() {
		try{
			return(txtTotalPrice.isDisplayed());
	}
		catch(Exception e) {
			return false;
		}
	}





}

