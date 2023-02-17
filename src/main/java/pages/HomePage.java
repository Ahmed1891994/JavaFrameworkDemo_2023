package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import utils.MyLogger;

public class HomePage extends TestBase{
	By add_remove_element_lnk = By.linkText("Add/Remove Elements");
	By checkboxes_lnk = By.linkText("Checkboxes");
	By drag_and_drop_lnk = By.linkText("Drag and Drop");
	By hovers_lnk = By.linkText("Hovers"); 
	By form_authentication_lnk = By.linkText("Form Authentication");
	
	By page_hdr = By.className("heading");
	
	@Step("Enter to Add_Remove_Elements Link step ...")
	public void EnterToAdd_Remove_Elements()
	{
		MyLogger.info("click on add_remove_element_lnk");
		getDriverActions().clickOn(add_remove_element_lnk);
	}
	
	@Step("Enter to Checkboxes Link step ...")
	public void EnterToCheckboxes()
	{
		MyLogger.info("click on checkboxes_lnk");
		getDriverActions().clickOn(checkboxes_lnk);
	}
	
	@Step("Enter to Form_Authentication Link step ...")
	public void EnterToForm_Authentication()
	{
		MyLogger.info("click on form_authentication_lnk");
		getDriverActions().clickOn(form_authentication_lnk);
	}
	
	@Step("Get Page header step ...")
	public String GetPageHeader()
	{
		MyLogger.info("Get text of PageHeader");
		return getDriverActions().textGet(page_hdr);
	}
}

