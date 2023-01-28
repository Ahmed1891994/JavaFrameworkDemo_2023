package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeManager extends BrowserFactory{
	@Override
	public WebDriver Driversetup() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver(getOptions());
	}
	
	@Override
	protected EdgeOptions getOptions() {
		EdgeOptions edgeoptions = new EdgeOptions();
		edgeoptions.addArguments("--start-maximized");
		edgeoptions.addArguments("--disable-infobars");
		edgeoptions.addArguments("--disable-notifications");
        return edgeoptions;
	}
}
