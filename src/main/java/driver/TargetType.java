package driver;

import org.openqa.selenium.WebDriver;
import pages.TestBase;
import Environments.Environment;

public class TargetType extends TestBase{
	private Environment env;
	private String target;
	private String browser;
	
	public TargetType(Environment env,String browser) {
		this.env = env;
		this.browser = browser;
		target = env.gettarget();
	}

	public WebDriver createWebDriverInstance() {
        WebDriver webdriver = null;
        BrowserFactoryManager browserfactorymanager = new BrowserFactoryManager();
                     
        switch (target) {
            case "LOCAL":
            	webdriver = browserfactorymanager.get(browser).getDriver();
                break;
            case "REMOTE":
            	RemoteManager remotemanager = new RemoteManager(env);
                webdriver = remotemanager.createRemoteInstance(browserfactorymanager.get(browser).getOptions());
                break;
            default:
            	
        }
        return webdriver;
    }
}
