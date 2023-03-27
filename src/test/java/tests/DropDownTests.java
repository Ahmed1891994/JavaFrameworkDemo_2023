package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Attachment;
import pages.DropDownPage;
import pages.HomePage;

public class DropDownTests extends TestBase{
	HomePage homepage;
	DropDownPage dropdownpage;

	@Attachment
	@Test(description="Valid Choosing elements from dropdown by index" ,dataProvider = "elementsDropDownIndexes")
	public void SelectElementbyindex(int itemnumber) {
		homepage = new HomePage();
		homepage.EnterToLinkByText("Dropdown");
		
		dropdownpage = new DropDownPage();
		dropdownpage.ChooseItem(itemnumber);

		Assert.assertEquals(dropdownpage.GetSelectedItem(), dropdownpage.GetComparableText(itemnumber));
	}

	@Test(description="Valid Choosing elements from dropdown by text" ,dataProvider = "elementsDropDownText")
	public void SelectElementbytext(String itemtxt) {
		homepage = new HomePage();
		homepage.EnterToLinkByText("Dropdown");
		
		dropdownpage = new DropDownPage();
		dropdownpage.ChooseItem(itemtxt);
		
		Assert.assertEquals(dropdownpage.GetSelectedItem(), dropdownpage.GetComparableText(itemtxt));
	}

	@Test(description="Valid checking default after selecting by index then refresh" ,dataProvider = "elementsDropDownIndexes")
	public void CheckDefautAfterRefresh_Index(int itemnumber) {
		homepage = new HomePage();
		homepage.EnterToLinkByText("Dropdown");
		
		dropdownpage = new DropDownPage();
		dropdownpage.ChooseItem(itemnumber);
		dropdownpage.ReloadDropDownPage();
		Assert.assertEquals(dropdownpage.GetSelectedItem(), "Please select an option");
	}

	@Test(description="Valid checking default after selecting by txt then refresh" ,dataProvider = "elementsDropDownText")
	public void CheckDefautAfterRefresh_Text(String itemtxt) {
		homepage = new HomePage();
		homepage.EnterToLinkByText("Dropdown");
		
		dropdownpage = new DropDownPage();
		dropdownpage.ChooseItem(itemtxt);
		dropdownpage.ReloadDropDownPage();
		Assert.assertEquals(dropdownpage.GetSelectedItem(), "Please select an option");
	}

	// array with indexes of elements in Dropdown
	@DataProvider(name = "elementsDropDownIndexes")
	public static Object[][] elementsDropDownIndexes() {
		return new Object[][] { { 1 }, { 2 } };
	}
	
	// array with text of elements in Dropdown
		@DataProvider(name = "elementsDropDownText")
		public static Object[][] elementsDropDownText() {
			return new Object[][] { { "Please select an option" }, { "Option 1" }, { "Option 2" } };
		}
}
