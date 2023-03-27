package driver;

import java.net.URL;
import java.net.UnknownHostException;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.Base;
import utils.ListenToIPAddress;
import utils.MyLogger;

public class RemoteManager extends Base{
	private String ip;
	private String port;
	
	public RemoteManager() {
		try {
			port = getEnvironment().getgridport();
			MyLogger.info("get port from Environment variable with value : " + port);
			ip = new ListenToIPAddress().GetMyIpAddress();
			MyLogger.info("get port from Environment variable or current Host with value : " + ip);
		} catch (UnknownHostException e) {
			MyLogger.error("there is UnknownHostException issue Please Investegate this");
		}
	}
	
	public RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
		RemoteWebDriver remoteWebDriver = null;
	    try {
	    	MyLogger.info("Save URL and port for Grid -> " + ip + ":" + port);
	        String gridURL = String.format("http://%s:%s/wd/hub", ip, port);
	        MyLogger.info("send URL and port and capability to remote driver");
	        remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
	    } catch (java.net.MalformedURLException e) {
	    	MyLogger.error("there is java.net.MalformedURLException issue Please Investegate this");
	    } catch (IllegalArgumentException e) {
	    	MyLogger.error("there is IllegalArgumentException issue Please Investegate this");
	    }
	    return remoteWebDriver;
	}
}