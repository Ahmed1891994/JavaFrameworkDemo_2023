package pages;

import java.util.Properties;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Environments.Environment;
import base.DriverActions;
import driver.TargetType;
import io.qameta.allure.Step;
import utils.MyLogger;
import utils.PropertiesFileHandler;

public class TestBase {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public ThreadLocal<Environment> Environment = new ThreadLocal<Environment>();
	public static ThreadLocal<DriverActions> driverActions = new ThreadLocal<DriverActions>();
	public PropertiesFileHandler propUtil;
	public Properties prop;
	public Environment cfg;
	protected TargetType targettype;

	@Step
	@Parameters({ "browserName" })
	@BeforeMethod
	public void InitializeEnvironment(String browserName) {

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
		targettype = new TargetType(getEnvironment(), browserName);

		// Set the driver
		MyLogger.info("Set the driver");
		setDriver(targettype.createWebDriverInstance());

		// initialize the driver actions and pass the driver webdriver to the class
		MyLogger.info("initialize the driver actions and pass the driver webdriver to the class");
		setDriverActions(new DriverActions(getDriver()));

		// maximize the window
		MyLogger.info("maximize the window");
		getDriver().manage().window().maximize();

		// open the URL
		MyLogger.info("open the URL");
		getDriverActions().openURL(getEnvironment().geturlBase());
	}

	/*@Step
	//@AfterMethod
	public void GoHome() {
		MyLogger.info("open the URL");
		getDriverActions().openURL(getEnvironment().geturlBase());
	}*/

	@Step
	@AfterMethod
	public void teardown() {
		MyLogger.info("Close All windows and teardown");
		getDriverActions().closeAllWindows();
	}

	private void setDriver(WebDriver driver) {
		MyLogger.debug("save the driver to ThreadLocal variable");
		this.driver.set(driver);
	}

	protected WebDriver getDriver() {
		MyLogger.debug("get the driver from ThreadLocal variable");
		return this.driver.get();
	}

	private void setEnvironment(Environment env) {
		MyLogger.debug("save the Environment to ThreadLocal variable");
		this.Environment.set(env);
	}

	public Environment getEnvironment() {
		MyLogger.debug("get the Environment from ThreadLocal variable");
		return this.Environment.get();
	}

	private void setDriverActions(DriverActions driveractions) {
		MyLogger.debug("save the DriverActions to ThreadLocal variable");
		TestBase.driverActions.set(driveractions);
	}

	public DriverActions getDriverActions() {
		MyLogger.debug("get the DriverActions from ThreadLocal variable");
		return TestBase.driverActions.get();
	}
}
