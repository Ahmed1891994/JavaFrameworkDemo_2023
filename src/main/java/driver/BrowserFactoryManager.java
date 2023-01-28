package driver;

import java.util.HashMap;
import java.util.Map;


public class BrowserFactoryManager {
	private BrowserFactory Chrome = new ChromeManager();
	private BrowserFactory Edge =  new EdgeManager();
	private BrowserFactory Firefox =  new FireFoxManager();
	private Map<String, BrowserFactory> map = new HashMap<>();
	
	
	{
		map.put("Chrome",Chrome);
		map.put("Edge",Edge);
		map.put("Firefox",Firefox);	
	}
	
	public BrowserFactory get(String language)
	{
		return map.get(language);

	}
}
