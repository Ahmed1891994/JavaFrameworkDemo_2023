package pages;

import java.net.UnknownHostException;
import java.util.Properties;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import Environments.Environment;
import base.DriverActions;
import driver.TargetType;
import io.qameta.allure.Step;
import models.FakerDataUser;
import utils.Listener;
import utils.PropertiesFIleHandler;


public class TestBase {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public ThreadLocal<Environment> Environment = new ThreadLocal<Environment>();
	public static ThreadLocal<DriverActions> driverActions = new ThreadLocal<DriverActions>();
	public static ThreadLocal<FakerDataUser> fakeruser = new ThreadLocal<FakerDataUser>();
	public PropertiesFIleHandler propUtil;
	public Properties prop;
	public Environment cfg;
	protected TargetType targettype;

	@Step
	@Parameters({"browserName"})
    @BeforeMethod
    public void InitializeEnvironment(String browserName){
		//make instance of fake user to make fake data
		setFakerDataUser(new FakerDataUser());
		
		//Update Environment parameters
		cfg = ConfigFactory.create(Environment.class);
		
		//save the environment variable into threadlocal
		setEnvironment(cfg);
		
    	//make new class from targettype class and get environment and pass the environment to it
		//initialize target class to choose to work locally or remotely
		targettype = new TargetType(getEnvironment(),browserName);
    	
    	//Set the driver
    	setDriver(targettype.createWebDriverInstance());
    	
    	//initialize the driver actions and pass the driver webdriver to the class
        setDriverActions(new DriverActions(getDriver()));
        
        //maximize the window
        getDriver().manage().window().maximize();
        
        //open the URL
        getDriverActions().openURL(getEnvironment().geturlBase());
        
        
    }
	
	@Step
    @AfterMethod
    public void teardown() {
    	getDriverActions().closeAllWindows();
    }
    
    private void setDriver(WebDriver driver)
    {
    	this.driver.set(driver);
    }
    
    protected WebDriver getDriver()
    {
    	return this.driver.get();
    }
    
    private void setEnvironment(Environment env)
    {
    	this.Environment.set(env);
    }
    
    public Environment getEnvironment()
    {
    	return this.Environment.get();
    }
    
    private void setDriverActions(DriverActions driveractions)
    {
    	TestBase.driverActions.set(driveractions);
    }
    
    public DriverActions getDriverActions()
    {
    	return TestBase.driverActions.get();
    }
    
    private void setFakerDataUser(FakerDataUser fakerdatauser)
    {
    	TestBase.fakeruser.set(fakerdatauser);
    }
    
    public FakerDataUser getFakerDataUser()
    {
    	return TestBase.fakeruser.get();
    }
}
