package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverActions;
import io.qameta.allure.Step;
import utils.MyLogger;

public class HomePage extends DriverActions{
	private By page_hdr = By.className("heading");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@Step("From Home Page Enter to Link step ...")
	public void EnterToLinkByText(String linkpath)
	{
		MyLogger.info("User wants to click on " + linkpath);
		clickOn(By.xpath("//a[text()='"+linkpath+"']"));
	}
	
	@Step("Get Page header step ...")
	public String GetPageHeader()
	{
		MyLogger.info("Get text of PageHeader");
		return textGet(page_hdr);
	}
}

