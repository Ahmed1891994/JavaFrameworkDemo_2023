package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.MyLogger;

public class BrowserActions {
	private WebDriver driver;
	WebDriverWait wait;

	public BrowserActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// ************************************URLNavigation**********************************************
	// open url using navigate to track history
	public void openURL_History(String URL) {
		MyLogger.info("navigate to : " + URL);
		driver.navigate().to(URL);
	}

	// open url using get() and not care about history
	public void openURL(String URL) {
		MyLogger.info("Open URL : " + URL);
		driver.get(URL);
	}

	// refresh page
	public void reloadPage() {
		MyLogger.info("Refresh Page");
		driver.navigate().refresh();
	}

	// **************************************WindowClosure***************************************
	public void closeCurrentWindow() {
		MyLogger.info("close Current Window");
		driver.close();
	}

	public void closeAllWindows() {
		MyLogger.info("close All Windows");
		driver.quit();
	}
}
