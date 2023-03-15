package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	
public static WebDriver driver;
public  Logger logger;
public ResourceBundle rb;

//-------------------------------	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br) {
		
		logger=LogManager.getLogger(this.getClass()); //this.getClass will give class to get log of each class;

		rb=ResourceBundle.getBundle("Config");
		try {
			if(br.equals("chrome")) {
				driver=new ChromeDriver();
				logger.info("***** Chrome driver launched *******");
			}
			else if(br.equals("edge")) {
				driver=new EdgeDriver();
				logger.info("***** Edge driver launched *******");
			}
			else {
				driver=new FirefoxDriver();
				logger.info("***** Firefox driver launched *******");
			}
			driver.manage().deleteAllCookies();
						
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(rb.getString("appUrl"));
			logger.info("****** url opened *******");
			driver.manage().window().maximize();
			String homePage_title=driver.getTitle();
			Assert.assertEquals(homePage_title,rb.getString("HomePageTitle"));
			logger.info("****** validated the homepage title ******");
		}
			catch(Exception e) {
				Assert.fail();
	}
}
	
	@AfterClass(groups= {"Sanity","Master","Regression"})
	public void teardown() {
		driver.quit();
		logger.info("******* quiting the appliaction ******");
	}
	
	 public String randomString(int stringnnum) {
		String ra=RandomStringUtils.randomAlphabetic(stringnnum);
		return(ra);
	 }
	 
	 public String randomNumbers(int randomnum) {
		 String rn=RandomStringUtils.randomNumeric( randomnum);
		 return(rn);
	 }
	 
	 public String randomAlphanumeric() {
		 String ra=RandomStringUtils.randomAlphabetic(3);
		String rn=RandomStringUtils.randomNumeric(4);
		String rans =ra+"@"+rn;
		return(rans);
	 }
	 
	 public String captureScreen(String tname) {
		
//		 SimpleDateFormat df=new SimpleDateFormat("yyyymmddhhmmss");
//		 Date dt=new Date();
//		 String timeStamp = df.format(dt);  //the three statements in below code in one line.
	 
		String timeStamp=new SimpleDateFormat("yyyy.mm.dd.hh:mm:ss").format(new Date());  //the Above 3 statements in 
	 
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;         //interface
		
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);  //takes screenshot as file.
		
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";  //set file name,timestamp and destination;
		
		try {
			FileUtils.copyFile(source,new File(destination));
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return destination;
	 }
	

}
