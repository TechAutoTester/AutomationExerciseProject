package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends BasePage{
	
	public AccountDeletedPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements:
	@FindBy(xpath="//b[normalize-space()='Account Deleted!']")
	WebElement txt_account_deleted_msg;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement btn_continue;
	
	
	//Action Methods:
	 public boolean acc_delete_msg() {
		try {
			return(txt_account_deleted_msg.isDisplayed());
		}
		catch(Exception e) {
			return(false);		}
	}
	public void click_continue(){
		btn_continue.click();
	}
	
}
