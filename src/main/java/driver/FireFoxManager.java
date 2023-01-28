package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxManager extends BrowserFactory{
	
	@Override
	protected WebDriver Driversetup() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver(getOptions());
	}

	@Override
	protected FirefoxOptions getOptions() {
		FirefoxOptions firefoxoptions = new FirefoxOptions();
		firefoxoptions.addArguments("--start-maximized");
		firefoxoptions.addArguments("--disable-infobars");
		firefoxoptions.addArguments("--disable-notifications");
		firefoxoptions.addPreference("dom.disable_open_during_load", true);
        return firefoxoptions;
	}
}
