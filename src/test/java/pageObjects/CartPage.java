package pageObjects;

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
	
	@FindBy(css="p[class='text-center'] a")
	WebElement txtPrice;
	
	@FindBy(css="tr[id='product-1'] button[class='disabled']")
	WebElement txtQuantity;
	
	@FindBy(css="tr[id='product-1'] p[class='cart_total_price']")
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
		return(alertSuccessMsg.isDisplayed());
	}
	
	}

