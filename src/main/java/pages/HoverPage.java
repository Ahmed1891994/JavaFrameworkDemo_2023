package pages;

import org.openqa.selenium.By;
import base.Base;
import io.qameta.allure.Step;
import utils.MyLogger;

public class HoverPage extends Base {

	@Step("Hover on image with index {0} step ...")
	public void HoverImgIndex(int index) {
		By imgindex = By.xpath("//*[@id='content']/div/div[" + index + "]");
		MyLogger.info("Hover on image with index : " + index);
		getElementActions().hoverOn(imgindex);
	}

	@Step("Enter to Profile with index {0} step ...")
	public void EnterOnProfile(int index) {
		By btnindex = By.xpath("//*[@id='content']/div/div[" + index + "]/div/a");
		MyLogger.info("Enter to Profile with index : " + index);
		getElementActions().clickOn(btnindex);
	}
}
