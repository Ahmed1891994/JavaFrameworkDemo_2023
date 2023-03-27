package pages;

import org.openqa.selenium.By;
import base.Base;
import io.qameta.allure.Step;
import utils.MyLogger;

public class SecureAreaPage extends Base{
	private By logout_btn = By.className("icon-signout");
	private By green_alrt = By.id("flash");
	
	private By page_hdr = By.xpath("//h2[normalize-space()='Secure Area']");
	
	@Step("Logout Successfully step ...")
	public void Logout()
	{
		MyLogger.info("Click on logout_btn");
		getElementActions().clickOn(logout_btn);
	}
	
	@Step("Get alert text step ...")
	public String GetAlertText()
	{
		String result = getElementActions().textGet(green_alrt);
		MyLogger.info("Get green_alrt text -> " + result);
		return result;
	}
	
	@Step("Get Page header step ...")
	public String GetPageHeader()
	{
		String result = getElementActions().textGet(page_hdr);
		MyLogger.info("Get page_hdr text -> " + result);
		return result;
	}
}
