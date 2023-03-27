package base;

import org.openqa.selenium.WebDriver;
import Environments.Environment;
import utils.MyLogger;

public class Base{
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected static ThreadLocal<Environment> Environment = new ThreadLocal<Environment>();
	public static ThreadLocal<ElementActions> elementactions = new ThreadLocal<ElementActions>();
	public static ThreadLocal<BrowserActions> browseractions = new ThreadLocal<BrowserActions>();
	
	
	protected void setDriver(WebDriver driver) {
		MyLogger.debug("save the driver to ThreadLocal variable");
		this.driver.set(driver);
	}

	protected WebDriver getDriver() {
		MyLogger.debug("get the driver from ThreadLocal variable");
		return driver.get();
	}
	
	protected void setEnvironment(Environment env) {
		MyLogger.debug("save the Environment to ThreadLocal variable");
		Base.Environment.set(env);
	}

	public Environment getEnvironment() {
		MyLogger.debug("get the Environment from ThreadLocal variable");
		return Base.Environment.get();
	}
	
	public void setElementActions(ElementActions elementactions) {
		MyLogger.debug("save the ElementActions to ThreadLocal variable");
		Base.elementactions.set(elementactions);
	}

	public ElementActions getElementActions() {
		MyLogger.debug("get the ElementActions from ThreadLocal variable");
		return Base.elementactions.get();
	}
	
	public void setBrowserActions(BrowserActions browseractions) {
		MyLogger.debug("save the BrowserActions to ThreadLocal variable");
		Base.browseractions.set(browseractions);
	}

	public BrowserActions getBrowserActions() {
		MyLogger.debug("get the BrowserActions from ThreadLocal variable");
		return Base.browseractions.get();
	}
}
