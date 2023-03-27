package pages;

import org.openqa.selenium.By;
import base.Base;
import io.qameta.allure.Step;
import utils.MyLogger;

public class HomePage extends Base {
	private By page_hdr = By.className("heading");

	@Step("From Home Page Enter to Link step ...")
	public void EnterToLinkByText(String linkpath) {
		MyLogger.info("User wants to click on " + linkpath);
		getElementActions().clickOn(By.xpath("//a[text()='" + linkpath + "']"));
	}

	@Step("Get Page header step ...")
	public String GetPageHeader() {
		MyLogger.info("Get text of PageHeader");
		return getElementActions().textGet(page_hdr);
	}
}
