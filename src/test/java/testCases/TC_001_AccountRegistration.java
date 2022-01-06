package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;



public class TC_001_AccountRegistration extends BaseClass{
	
	
	@Test
	public void test_account_registration() throws IOException, InterruptedException
	{
		driver.get(rb.getString("appURL")); //Get URL from config file.
		logger.info("opening application..");
		
		
		driver.manage().window().maximize();
		
		
		HomePage hp=new HomePage(driver); 
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage ac_reg_pg=new AccountRegistrationPage(driver);
		logger.info("opened Registration page..");
		
		ac_reg_pg.setFirstName("John");
		logger.info("First name provided..");
		
		ac_reg_pg.setLastName("Jhon");
		logger.info("Last name provided..");
		
		ac_reg_pg.setEmail(randomstring()+"@gmail.com");
		//ac_reg_pg.setEmail("abc123abc@gmail.com");
		logger.info("Email provided..");
		
		
		ac_reg_pg.setTelephone("123456789");
		logger.info("Number provided..");
		
		ac_reg_pg.setPassword("123456");
		logger.info("Password provided..");
		
		ac_reg_pg.setConfirmPassword("123456");
		logger.info("Confirm password provided..");
		
		ac_reg_pg.setPrivacyPolicy();
		logger.info("policy checked..");
		
		ac_reg_pg.clickContinue();
		logger.info("Clicked continue..");
		
		String con_msg=ac_reg_pg.getConfirmationMsg();
		if(con_msg.equals("Your Account Has Been Created!"))
		{
			logger.info("Registration successful");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "test_account_registration");
			logger.info("Registration Failed");
			Assert.assertTrue(false);
		}	
		
		
		
	}
	
	
	
	
	
}
