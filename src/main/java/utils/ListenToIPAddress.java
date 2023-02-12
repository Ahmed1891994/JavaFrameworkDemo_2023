package utils;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ListenToIPAddress {
	public String GetMyIpAddress() throws UnknownHostException
	{
		String result = System.getProperty("HUB_HUB");
		System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+result);
		if(result == null)
			result = InetAddress.getLocalHost().getHostAddress();
		System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+result);
		return result;
	}
}
