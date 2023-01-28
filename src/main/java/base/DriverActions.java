package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Attachment;
import pages.TestBase;

public class DriverActions extends TestBase {
	private WebDriver driver;
	WebDriverWait wait;

	public DriverActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// open url using navigate to track history
		public WebDriver ReturnDriver() {
			return driver;
		}
		
	// ************************************URLNavigation**********************************************
	// open url using navigate to track history
	public void openURL_History(String URL) {
		driver.navigate().to(URL);
		;
	}

	// open url using get() and not care about history
	public void openURL(String URL) {
		driver.get(URL);
	}

	// refresh page
	public void reloadPage() {
		driver.navigate().refresh();
	}

	// Keyboard simulation
	public void keyboardPress(Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(key).perform();
	}

	// Get title from page
	public String TitleGet() {
		return driver.getTitle();
	}

	// ***********************************Buttons & CheckBoxes*****************************************
	// click on button
	public void clickOn(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).click();
	}

	// hover on button
	public void hoverOn(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(element)).perform();
	}

	// select checkbox
	public void SelectCheckbox(By element) {
		if (!driver.findElement(element).isSelected())
			driver.findElement(element).click();
	}

	// deselect checkbox
	public void DeselectCheckbox(By element) {
		if (driver.findElement(element).isSelected())
			driver.findElement(element).click();
	}

	// select checkbox
	public void ActionClick(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(element)).click().perform();
	}

	public void ScrollToElement(By element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	}
	// ****************************************DropBox************************************************
	// Select from dropBox
	public void selectByVisibleText(By element, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Select dropbox = new Select(driver.findElement(element));
		dropbox.selectByVisibleText(text);
	}

	public void selectByValue(By element, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Select dropbox = new Select(driver.findElement(element));
		dropbox.selectByValue(text);
	}

	public void selectByIndex(By element, int index) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Select dropbox = new Select(driver.findElement(element));
		dropbox.selectByIndex(index);
	}

	// ***************************************TextFields**********************************************
	// put text in field after clearing it
	public void textSet(By element, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(text);
	}

	// Get text from element
	public String textGet(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return driver.findElement(element).getText();
	}

	// **************************************WindowClosure***************************************
	public void closeCurrentWindow() {
		driver.close();
	}

	public void closeAllWindows() {
		driver.quit();
	}

	// ******************************************Cookies*****************************************
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	// ***************************************CheckElements**************************************
	public boolean isDisplayed(By element) {
		boolean flag;
		if (driver.findElement(element).isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean isNotExist(By element) {
		boolean flag;
		if (driver.findElements(element).isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean checkElementType(By element, String type) {
		boolean flag = false;
		if (driver.findElement(element).getAttribute("type").equals(type)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// ************************************Element Attributes***************************************
	public String getCSSValue(By element, String parameter) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return driver.findElement(element).getCssValue(parameter);
	}

	// *********************************Wait****************************************
	public void Wait_Implicit(int timer)
	{
		new WebDriverWait(driver, Duration.ofSeconds(timer));
	}
	
	public void Wait_Explicit_Until_Visibility(By element)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void Wait_Explicit_Until_NonVisibility(By element)
	{
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));	
	}
	// ************************************Screenshots***************************************
	@Attachment(value = "Page screenshot" , type = "image/png")
	public byte[] takeScreenShot(String TestMethodName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String time = java.time.LocalTime.now().toString().replace(":", "-").substring(0, 5);
		String date = java.time.LocalDate.now().toString();
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + date + "_" + time + "\\"
				+ TestMethodName + "_" + ThreadLocalRandom.current().nextInt() + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ts.getScreenshotAs(OutputType.BYTES);
	}
}
