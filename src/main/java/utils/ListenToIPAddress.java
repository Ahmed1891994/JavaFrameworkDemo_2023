package utils;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ListenToIPAddress {
	public String GetMyIpAddress() throws UnknownHostException
	{
		String result = System.getProperty("HUBHOST");
		if(result == null)
			result = InetAddress.getLocalHost().getHostAddress();
		return result;
	}
}
