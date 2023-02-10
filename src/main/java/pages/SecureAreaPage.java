package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

public class SecureAreaPage extends TestBase{
	By logout_btn = By.className("icon-signout");
	By green_alrt = By.id("flash");
	
	By page_hdr = By.xpath("//h2[normalize-space()='Secure Area']");
	
	@Step("Logout Successfully step ...")
	public void Logout()
	{
		getDriverActions().clickOn(logout_btn);
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
