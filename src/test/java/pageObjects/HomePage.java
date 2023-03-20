package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Elements:
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]/li[4]/a")
	WebElement link_sinup;
	
	@FindBy(xpath="//li[10]//a[1]")
	WebElement loggedMsg;
	
	@FindBy(xpath="//a[@href='/logout']")
	WebElement btn_logout;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	WebElement linkDeleteAccount;
	
	@FindBy(xpath="//a[normalize-space()='Contact us']")
	WebElement linkContactUs;
	
	//ActionMethods:
	public void click_sinup_login() {
		link_sinup.click();
	}
	
	 public boolean verify_LogHomePage() {
		try {
			return(loggedMsg.isDisplayed());
		}
		catch(Exception e) {
			return (false);
		}
	}
	public void click_delete_account(){
		linkDeleteAccount.click();
	}
	
	public void click_Logout_btn() {
		btn_logout.click();
	}
	
	
	public void click_contact_us() {
		linkContactUs.click();
	}
	
	public String HomePageTitle() {
		return(driver.getTitle());
	}
	
	
	
	
	
	
	

}
