package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverActions;
import io.qameta.allure.Step;
import utils.MyLogger;

public class HoverPage extends DriverActions{
		public HoverPage(WebDriver driver)
	    {
			super(driver);
	    }

		@Step("Hover on image with index {0} step ...")
	    public void HoverImgIndex(int index)
	    {
	    	By imgindex = By.xpath("//*[@id='content']/div/div["+index+"]");
	    	MyLogger.info("Hover on image with index : " + index);
	        hoverOn(imgindex);
	    }

		@Step("Enter to Profile with index {0} step ...")
	    public void EnterOnProfile(int index)
	    {
	    	By btnindex = By.xpath("//*[@id='content']/div/div["+index+"]/div/a");
	    	MyLogger.info("Enter to Profile with index : " + index);
	    	clickOn(btnindex);
	    }
}
