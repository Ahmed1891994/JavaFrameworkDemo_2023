package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{
	By username_fld = By.id("username");
	By password_fld = By.id("password");
	By login_btn = By.className("fa-sign-in");
	
	By green_alrt = By.id("flash");
	By page_hdr = By.xpath("//h2[normalize-space()='Login Page']");
	
	@Step("set Username with value {0} step ...")
	public void setUsername(String username)
	{
		getDriverActions().textSet(username_fld,username);
	}
	
	@Step("set Password with value {0} step ...")
	public void setPassword(String password)
	{
		getDriverActions().textSet(password_fld,password);
	}
	
	@Step("Press Login Button step ...")
	public void pressLogin()
	{
		setUsername(getFakerDataUser().getFirstname()+getFakerDataUser().getLastname());
		setPassword(getFakerDataUser().getPassword());
		getDriverActions().clickOn(login_btn);
	}
	
	@Step("Pass username : {0} , Password : {1} ,then Press Login Button step ...")
	public void pressLogin(String user,String password)
	{
		setUsername(user);
		setPassword(password);
		getDriverActions().clickOn(login_btn);
	}
	
	@Step("Get alert text step ...")
	public String GetAlertText()
	{
		return getDriverActions().textGet(green_alrt);
	}
	
	@Step("Get Page header step ...")
	public String GetPageHeader()
	{
		return getDriverActions().textGet(page_hdr);
	}

}
