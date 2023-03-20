package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_006_ContactUsForm extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void test_contactus_Form() {
		try {
			
		logger.info("***** Started TC_006_ContactUsForm *******");
		HomePage hp=new HomePage(driver);
		hp.click_contact_us();
		logger.info("***** Clicked on contactus link ******");
		ContactUsPage cp=new ContactUsPage(driver);
		Assert.assertEquals(cp.verify_getInTouchMsg(),true );
		logger.info("***** validated get in touch element is visble");
		cp.enter_name(rb.getString("name"));
		cp.enter_email(rb.getString("email"));
		cp.enter_subject("ad display");
		logger.info("**** name email and subjcet entered *****");
		cp.type_msg("ad is displayed under the bottom of the page");
		logger.info("***** entered my message *******");
		cp.upload_file(rb.getString("img_path"));
		logger.info("**** file is uploaded*****");
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", cp.click_submit_btn());
	
		logger.info("**** clicked on submit button ***** ");
		driver.switchTo().alert().accept();
		logger.info("***** Switched to alert and clicked on ok button *****");
		Assert.assertEquals(cp.verify_success_msg(),"Success! Your details have been submitted successfully.");
		logger.info("***** verified submitted details successfully message");
		cp.click_Home();
		logger.info("**** clicked on Home button ****");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),rb.getString("HomePageTitle"));
		logger.info("**** validated the home page title *****");
	}
		catch(Exception e) {
			Assert.fail();
		}
	}

}
