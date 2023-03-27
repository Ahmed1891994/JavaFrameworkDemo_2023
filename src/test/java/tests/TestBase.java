package tests;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Environments.Environment;
import base.Base;
import base.BrowserActions;
import base.ElementActions;
import driver.TargetType;
import utils.MyLogger;

public class TestBase extends Base {
	public Environment cfg;
	public TargetType targettype;
	
	@Parameters("browserName")
	@BeforeMethod
	public void InitializeEnvironment(String browser) {
		// Update Environment parameters
		MyLogger.info("Update Environment parameters using owner library");
		cfg = ConfigFactory.create(Environment.class);

		// save the environment variable into threadlocal
		MyLogger.info("save the environment variable into threadlocal");
		setEnvironment(cfg);
		// make new class from targettype class and get environment and pass the
		// environment to it
		// initialize target class to choose to work locally or remotely
		MyLogger.info("initialize target class to choose to work locally or remotely");
		targettype = new TargetType(getEnvironment().gettarget(), browser);

		// Set the driver
		MyLogger.info("Set the driver");
		setDriver(targettype.createWebDriverInstance());

		// initialize the driver actions and pass the driver webdriver to the class
		MyLogger.info("initialize the ElementActions and BrowserActions and pass the driver webdriver to the class");
		setElementActions(new ElementActions(getDriver()));
		setBrowserActions(new BrowserActions(getDriver()));
		//elementactions = new ElementActions(getDriver());
		//browseractions = new BrowserActions(getDriver());

		// maximize the window
		MyLogger.info("maximize the window");
		getDriver().manage().window().maximize();

		// open the URL
		MyLogger.info("open the URL");
		getBrowserActions().openURL(getEnvironment().geturlBase());
	}
	
	@AfterMethod
	public void TearDown()
	{
		MyLogger.info("Close All windows and teardown");
		getBrowserActions().closeAllWindows();
	}

}
