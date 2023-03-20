package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends BasePage{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	//web elements
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']")
	WebElement txtGetintouch;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement txtName;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	WebElement txtSubject;
	
	@FindBy(xpath="//textarea[@placeholder='Your Message Here']")
	WebElement txtYourMessageHere;
	
	@FindBy(xpath="//input[@name='upload_file']")
	WebElement fileUpload;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[@class='status alert alert-success']")
	WebElement txtSuccessMsg;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	WebElement btnHome;
	
	
	@FindBy(id="google_esf")
	WebElement frame1;
	
	@FindBy(id="aswift_1")
	WebElement frame2;

	@FindBy(id="ad_frame")
	WebElement frame3;
	
	@FindBy(xpath="//*[@id='dismiss-button']")
	WebElement btnDismisss;
	
	
	
	//actions
	public boolean verify_getInTouchMsg() {
		try {
		return(txtGetintouch.isDisplayed());
	}
		catch(Exception e) {
			return false;
		}	
	}
	
	public void enter_name(String name) {
		txtName.sendKeys(name);
	}
	
	public void enter_email(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enter_subject(String subject) {
		txtSubject.sendKeys(subject);
	}
	
	public void type_msg(String message) {
		txtYourMessageHere.sendKeys(message);
	}
	
	public void click_chooseFile() {
		fileUpload.click();
	}
	
	public  void upload_file(String path) {
		fileUpload.sendKeys(path);	
	}
	
	public Object click_submit_btn() {
		return btnSubmit;
	}
	
	public String verify_success_msg() {
		return(txtSuccessMsg.getText());	
	}
	
	public void click_Home() {
		btnHome.click();
	}
	
	
	
	
	

}
