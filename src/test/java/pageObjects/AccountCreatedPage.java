package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage{
	
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements;
	@FindBy(xpath="//h2[@data-qa='account-created']/b")
	WebElement account_succes_msg;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement btn_continue;
	
	//iframes
	
	
	@FindBy(xpath="//iframe['google_esf']")
	WebElement iframe1;
	
	@FindBy(xpath="//iframe[id='aswift_3']")
	WebElement iframe2;
	
	
	@FindBy(xpath="//iframe[@id='ad-iframe']")
	WebElement iframe3;
			
	@FindBy(xpath="//div[@id='dismiss-button']")
	WebElement close_btn;


	//Action Methods:
	 public boolean  acc_success_msg() {
		try {
			return(account_succes_msg.isDisplayed());
		}
		catch(Exception e){
		return(false);
		}
	}
	
	public void click_continue(){
		btn_continue.click();
	}
	public void go_adframe1() {
		driver.switchTo().frame("google_esf");
	}
	public void go_adframe2() {
		driver.switchTo().frame("wift_3");
	}
	
	public void go_adframe3() {
		driver.switchTo().frame(iframe1);
	}
	public void adclose() {
		driver.switchTo().alert().dismiss();
	}
}
