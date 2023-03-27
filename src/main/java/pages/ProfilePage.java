package pages;

import org.openqa.selenium.By;
import base.Base;

public class ProfilePage extends Base{
	
	private final By ProfileText = By.xpath("/html/body/h1");
	
    public String GetProfileText()
    {
        return getElementActions().textGet(ProfileText);
    }
}
