package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverActions;
import io.qameta.allure.Step;
import utils.MyLogger;
import utils.TestDataGenerator;

public class LoginPage extends DriverActions{
	private By username_fld = By.id("username");
	private By password_fld = By.id("password");
	private By login_btn = By.className("fa-sign-in");
	private By green_alrt = By.id("flash");
	private By page_hdr = By.xpath("//h2[normalize-space()='Login Page']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("set Username with value {0} step ...")
	public void EnterUsername(String username)
	{
		MyLogger.info("set username -> "+ username +" in field");
		textSet(username_fld,username);
	}
	
	@Step("set Password with value {0} step ...")
	public void EnterPassword(String password)
	{
		MyLogger.info("set password -> "+ password +" in field");
		textSet(password_fld,password);
	}
	
	@Step("Press Login Button step ...")
	public void pressLogin()
	{
		String firstname = TestDataGenerator.fakerDataUser.getFirstname();
		String lastname = TestDataGenerator.fakerDataUser.getLastname();
		String password = TestDataGenerator.fakerDataUser.getPassword();
		MyLogger.info("firstname generated from Faker library -> "+firstname+" ,and lastname generated from faker library -> "+lastname);
		EnterUsername(firstname+lastname);
		MyLogger.info("username Entered is -> "+firstname+lastname);
		MyLogger.info("password generated from Faker library -> "+password);
		MyLogger.info("Enter Password into Field");
		EnterPassword(password);
		MyLogger.info("Click on login button");
		clickOn(login_btn);
	}
	
	@Step("Pass username : {0} , Password : {1} ,then Press Login Button step ...")
	public void pressLogin(String user,String password)
	{
		EnterUsername(user);
		MyLogger.info("username Entered is -> "+user);
		EnterPassword(password);
		MyLogger.info("password Entered is -> "+password);
		MyLogger.info("Click on login button");
		clickOn(login_btn);
	}
	
	@Step("Get alert text step ...")
	public String GetAlertText()
	{
		String result = textGet(green_alrt);
		MyLogger.info("Get green_alrt text -> " + result);
		return result;
	}
	
	@Step("Get Page header step ...")
	public String GetPageHeader()
	{
		String result = textGet(page_hdr);
		MyLogger.info("Get Page header text -> " + result);
		return result;
	}
}
