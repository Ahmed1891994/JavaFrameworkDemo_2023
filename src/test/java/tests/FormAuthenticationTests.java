package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.TestBase;

@Listeners(utils.Listener.class)

public class FormAuthenticationTests extends TestBase{
	
	@Attachment
	@Test(description="Valid Login Scenario with valid username and password.")
	public void VerifyLoginSuccessfully()
	{
		HomePage homepage = new HomePage();
		homepage.EnterToForm_Authentication();
		
		LoginPage loginpage = new LoginPage();
		loginpage.pressLogin("tomsmith","SuperSecretPassword!");
		
		SecureAreaPage secureareapage = new SecureAreaPage();

		assertTrue(secureareapage.GetAlertText().contains("You logged into a secure area!"));
		assertEquals(secureareapage.GetPageHeader(), "Secure Area");
	}
	
	@Attachment
	@Test(description="Valid Login Scenario then logout.")
	public void VerifyLogOutSuccessfully()
	{
		HomePage homepage = new HomePage();
		homepage.EnterToForm_Authentication();
		
		LoginPage loginpage = new LoginPage();
		loginpage.pressLogin("tomsmith","SuperSecretPassword!");
		
		SecureAreaPage secureareapage = new SecureAreaPage();

		assertTrue(secureareapage.GetAlertText().contains("You logged into a secure area!"));
		assertEquals(secureareapage.GetPageHeader(), "Secure Area");
		
		secureareapage.Logout();
		assertTrue(loginpage.GetAlertText().contains("You logged out of the secure area!"));
	}
	
	@Attachment
	@Test(description="Failed Login Scenario with invalid username and valid password.")
	public void VerifyLoginFailedWithWrongUserName()
	{
		HomePage homepage = new HomePage();
		homepage.EnterToForm_Authentication();
		
		LoginPage loginpage = new LoginPage();
		loginpage.pressLogin("tomsmithx","SuperSecretPassword!");
		
		assertTrue(loginpage.GetAlertText().contains("Your username is invalid!"));
	}
	
	@Attachment
	@Test(description="Failed Login Scenario with valid username and invalid password.")
	public void VerifyLoginFailedWithWrongPassword()
	{
		HomePage homepage = new HomePage();
		homepage.EnterToForm_Authentication();
		
		LoginPage loginpage = new LoginPage();
		loginpage.pressLogin("tomsmith","SuperSecretPassword!x");
		
		assertTrue(loginpage.GetAlertText().contains("Your password is invalid!"));
	}
	
}
