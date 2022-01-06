package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement lgn_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement lgn_password;
	@FindBy(xpath="//input[@value='Login']") WebElement lgn_btn;
	@FindBy(xpath="//h2[text()='My Account']") WebElement msgHeading;
	
	
	
	public void setemail(String email)
	{
		lgn_email.sendKeys(email);
	}
	
	public void setpassword(String password)
	{
		lgn_password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		lgn_btn.click();
	}
	
	public boolean isMyAccountExists()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	
}
