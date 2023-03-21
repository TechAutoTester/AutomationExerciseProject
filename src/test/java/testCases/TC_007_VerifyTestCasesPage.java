package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.TestCasesPage;
import testBase.BaseClass;

public class TC_007_VerifyTestCasesPage extends BaseClass{
	
	@Test(groups= {"sanity"})
	public void test_VerifyTestCasesPage() {
		try {
		logger.info("*** Started TC_007_VerifyTestCasesPage ******");

		HomePage hp=new HomePage(driver);
		hp.click_testcases();
		logger.info("***** clicked on testcases link ******");
		TestCasesPage tcp=new TestCasesPage(driver);
		Assert.assertEquals(tcp.testcases_msg(), true);
		logger.info("***** validated the testcases page with testcases heading ******");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		
}
}
