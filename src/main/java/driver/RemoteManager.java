package driver;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Environments.Environment;
import pages.TestBase;

public class RemoteManager extends TestBase{
	private Environment env;
	
	public RemoteManager(Environment env) {
		this.env = env;
	}
	
	public RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
		RemoteWebDriver remoteWebDriver = null;
	    try {
	        String gridURL = String.format("http://%s:%s/wd/hub", env.getgridurl(), env.getgridport());
	        remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
	    } catch (java.net.MalformedURLException e) {
	    } catch (IllegalArgumentException e) {
	    }
	
	    return remoteWebDriver;
	}
}