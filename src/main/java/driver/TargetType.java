package driver;

import org.openqa.selenium.WebDriver;
import base.Base;
import utils.MyLogger;

public class TargetType extends Base{
	private String target;
	private String browser;
	
	public TargetType(String target,String browser) {
		this.browser = browser;
		this.target = target;
	}

	public WebDriver createWebDriverInstance() {
        WebDriver webdriver = null;
        BrowserFactoryManager browserfactorymanager = new BrowserFactoryManager();
        MyLogger.info("Choose Target depending on properties file -> " + target);
        switch (target) {
            case "LOCAL":
            	MyLogger.info("Create local driver");
            	webdriver = browserfactorymanager.get(browser).getDriver();
                break;
            case "REMOTE":
            	MyLogger.info("Create remote driver");
            	RemoteManager remotemanager = new RemoteManager();
                webdriver = remotemanager.createRemoteInstance(browserfactorymanager.get(browser).getOptions());
                break;
            default:     	
        }
        return webdriver;
    }
}
