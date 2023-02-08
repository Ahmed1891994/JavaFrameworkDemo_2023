package driver;

import java.net.URL;
import java.net.UnknownHostException;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Environments.Environment;
import pages.TestBase;
import utils.ListenToIPAddress;

public class RemoteManager extends TestBase{
	private Environment env;
	private String getip;
	public RemoteManager(Environment env) {
		this.env = env;
		try {
			getip = new ListenToIPAddress().GetMyIpAddress();
		} catch (UnknownHostException e) {
			
		}
	}
	
	public RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
		RemoteWebDriver remoteWebDriver = null;
		
	    try {
	        String gridURL = String.format("http://%s:%s/wd/hub", getip, env.getgridport());
	        remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
	    } catch (java.net.MalformedURLException e) {
	    } catch (IllegalArgumentException e) {
	    }
	
	    return remoteWebDriver;
	}
}