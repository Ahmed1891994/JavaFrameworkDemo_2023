package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import utils.MyLogger;

public class LoginPage extends TestBase{
	By username_fld = By.id("username");
	By password_fld = By.id("password");
	By login_btn = By.className("fa-sign-in");
	
	By green_alrt = By.id("flash");
	By page_hdr = By.xpath("//h2[normalize-space()='Login Page']");
	
	@Step("set Username with value {0} step ...")
	public void setUsername(String username)
	{
		MyLogger.info("set username -> "+ username +" in field");
		getDriverActions().textSet(username_fld,username);
	}
	
	@Step("set Password with value {0} step ...")
	public void setPassword(String password)
	{
		MyLogger.info("set password -> "+ password +" in field");
		getDriverActions().textSet(password_fld,password);
	}
	
	@Step("Press Login Button step ...")
	public void pressLogin()
	{
		String firstname = getFakerDataUser().getFirstname();
		String lastname = getFakerDataUser().getLastname();
		String password = getFakerDataUser().getPassword();
		MyLogger.info("firstname generated from Faker library -> "+firstname+" ,and lastname generated from faker library -> "+lastname);
		setUsername(firstname+lastname);
		MyLogger.info("username Entered is -> "+firstname+lastname);
		MyLogger.info("password generated from Faker library -> "+password);
		MyLogger.info("Enter Password into Field");
		setPassword(password);
		MyLogger.info("Click on login button");
		getDriverActions().clickOn(login_btn);
	}
	
	@Step("Pass username : {0} , Password : {1} ,then Press Login Button step ...")
	public void pressLogin(String user,String password)
	{
		setUsername(user);
		MyLogger.info("username Entered is -> "+user);
		setPassword(password);
		MyLogger.info("password Entered is -> "+password);
		MyLogger.info("Click on login button");
		getDriverActions().clickOn(login_btn);
	}
	
	@Step("Get alert text step ...")
	public String GetAlertText()
	{
		String result = getDriverActions().textGet(green_alrt);
		MyLogger.info("Get green_alrt text -> " + result);
		return result;
	}
	
	@Step("Get Page header step ...")
	public String GetPageHeader()
	{
		String result = getDriverActions().textGet(page_hdr);
		MyLogger.info("Get Page header text -> " + result);
		return result;
	}

}
