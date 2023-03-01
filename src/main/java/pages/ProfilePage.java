package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverActions;

public class ProfilePage extends DriverActions{
	
	private final By ProfileText = By.xpath("/html/body/h1");
	
	public ProfilePage(WebDriver driver)
    {
		super(driver);
    }
	
    public String GetProfileText()
    {
        return textGet(ProfileText);
    }
}
