package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class SinupLoginPage extends BasePage{
	public SinupLoginPage(WebDriver driver){
	super(driver);
	}
	
	//SinupElements:
	@FindBy(xpath="//h2[normalize-space()='New User Signup!']")
	WebElement txt_new_user_sinup;
	
	@FindBy(xpath="//input[@data-qa=\"signup-name\"]")
	WebElement txtSinupName;
	
	@FindBy(xpath="//input[@data-qa=\"signup-email\"]")
	WebElement txtSinupEmail;
	
	@FindBy(xpath="//button[@data-qa=\"signup-button\"]")
	WebElement buttonSinup;
	
	//Login Elements:
	@FindBy(xpath="//h2[normalize-space()='Login to your account']")
	WebElement login_acc_text;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement txtloginemail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtlogin_passwd;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement btn_login;
	
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")
	WebElement txt_verify_invalid;
	
	//Actions:
	public boolean verify_newUser_sinup() {
		try{
			return(login_acc_text.isDisplayed());
		}
		catch(Exception e) {
			return(false);
		}
	}
	
	public void setName(String name) {
	txtSinupName.sendKeys(name);
	}
	
	public void setemail(String email) {
		txtSinupEmail.sendKeys(email);
	}
	
	public void clicksinupbutton() {
		buttonSinup.click();
	}
	
	public boolean  verify_login_acc_is_visible() {
		try{
			return(login_acc_text.isDisplayed());
		}
		catch(Exception e) {
			return(false);
		}
	}
	
	
	public void enter_email(String emailId) {
		txtloginemail.sendKeys(emailId);
	}
	public void enter_passwd(String passwd) {
		txtlogin_passwd.sendKeys(passwd);
	}
	
	public void click_login_btn() {
		btn_login.click();
	}
	
	public boolean verify_invalid_credentials() {
	try {
		return(txt_verify_invalid.isDisplayed());
	}
	catch(Exception e) {
		return(false);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
