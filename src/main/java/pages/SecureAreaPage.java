package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import utils.MyLogger;

public class SecureAreaPage extends TestBase{
	By logout_btn = By.className("icon-signout");
	By green_alrt = By.id("flash");
	
	By page_hdr = By.xpath("//h2[normalize-space()='Secure Area']");
	
	@Step("Logout Successfully step ...")
	public void Logout()
	{
		MyLogger.info("Click on logout_btn");
		getDriverActions().clickOn(logout_btn);
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
		MyLogger.info("Get page_hdr text -> " + result);
		return result;
	}
}
