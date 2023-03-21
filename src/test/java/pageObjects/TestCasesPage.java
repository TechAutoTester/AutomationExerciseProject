package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage{

	public TestCasesPage(WebDriver driver) {
		super(driver);
	}
	// Webelements
	@FindBy(xpath="//b[normalize-space()='Test Cases']")
	WebElement txtTestCasesMsg;
	
	// Actions
	
	public boolean testcases_msg() {
		try{
			return(txtTestCasesMsg.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	
}
