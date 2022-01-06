package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {

	@Test
	public void test_Login()
	{
		 logger.info("Starting TC_002_Login");
	
	try {
	
		driver.get(rb.getString("appURL")); //Get URL from config file.
		logger.info("opening application..");
		
		
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver); 
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setemail(rb.getString("email"));
		logger.info("Email Provided");
		
		lp.setpassword(rb.getString("password"));
		logger.info("Password Provided");
		
		lp.clickLogin();
		logger.info("Clicked on Login");
		
		boolean targetpage=lp.isMyAccountExists();
		
		if(targetpage)
		{
			logger.info("Login Success");
			Assert.assertTrue(true);
		}
		
		else {
			logger.info("Login Failed");
			captureScreen(driver, "test_Login");
			Assert.assertTrue(false);
		}
		
	
	} 
	
	catch(Exception e)
	{
		logger.fatal("Login Failed");
		Assert.fail();
	}
	
	}	
}
