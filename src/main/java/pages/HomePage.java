package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import utils.MyLogger;

public class HomePage extends TestBase{
	By page_hdr = By.className("heading");
	
	@Step("From Home Page Enter to Link step ...")
	public void EnterToLinkByText(String linkpath)
	{
		MyLogger.info("click on " + linkpath);
		getDriverActions().clickOn(By.xpath("//a[text()='"+linkpath+"']"));
	}
	
	@Step("Get Page header step ...")
	public String GetPageHeader()
	{
		MyLogger.info("Get text of PageHeader");
		return getDriverActions().textGet(page_hdr);
	}
}

