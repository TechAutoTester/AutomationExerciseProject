package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class EnterAccountInfoPage extends BasePage{
	
	public EnterAccountInfoPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements:
	@FindBy(id="id_gender1")
	WebElement radio_gender_male;
	
	@FindBy(id="id_gender2")
	WebElement radio_gender_female;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement dropdown_days;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement dropdown_months;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement dropdown_years;
	
	@FindBy(id="newsletter")
	WebElement checkbox_newsletter;
	
	@FindBy(id="optin")
	WebElement checkbox_specialoffers;
	
	@FindBy(id="first_name")
	WebElement txt_user_firstname;
	
	@FindBy(id="last_name")
	WebElement txt_user_lastname;
	
	@FindBy(id="company")
	WebElement txt_companyname;
	
	@FindBy(name="address1")
	WebElement txt_address1;
	
	@FindBy(name="address2")
	WebElement txt_address2;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement dropdown_country;
	
	@FindBy(xpath="//input[@data-qa='state']")
	WebElement txt_statename;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement txt_cityname;
	
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	
	@FindBy(id="mobile_number")
	WebElement txt_mobile_number;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	WebElement submit_btn_create_account;	


	//ActionMethods;
	public void click_male_radio_btn() {
		radio_gender_male.click();
	}
	public void click_female_radio_btn() {
		radio_gender_female.click();
	}
	public void set_password(String passwd) {
		txt_password.sendKeys(passwd);
	}
	public void select_day(String day) {
		Select slday=new Select(dropdown_days);
		slday.selectByVisibleText(day);
		}
	
	public void select_month(String  month) {
		Select slmonth=new Select(dropdown_months);
		slmonth.selectByVisibleText(month);
		}
		
	public void select_year(String year) {
		Select slyear=new Select(dropdown_years);
		slyear.selectByVisibleText(year);
	}
	
	public WebElement checkboxesElements(){
		return checkbox_newsletter;
	}
	public WebElement checkbox_option() {
		return checkbox_specialoffers;
	}
	
	public void set_first_name(String firstname){
		txt_user_firstname.sendKeys(firstname);
	}

	public void set_last_name(String lastname){
		txt_user_lastname.sendKeys(lastname);
	}

	public void set_companyname(String companyname){
		txt_companyname.sendKeys(companyname);
	}
	public void set_address1(String address1){
		txt_address1.sendKeys(address1);
	}
	public void set_address2(String address2){
		txt_address2.sendKeys(address2);
	}

	public void set_state(String statename){
		txt_statename.sendKeys(statename);
	}

	public void set_cityname(String cityname){
		txt_cityname.sendKeys(cityname);
	}

	public void set_zipcode(String zipcode){
		txt_zipcode.sendKeys(zipcode);
	}

	public void set_mobilenumber(String mobilenumber){
		txt_mobile_number.sendKeys(mobilenumber);
	}
	public WebElement click_submit_btn(){
		return submit_btn_create_account;
	}
	

	
}
