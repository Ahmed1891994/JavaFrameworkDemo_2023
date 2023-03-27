package pages;

import org.openqa.selenium.By;
import base.Base;
import io.qameta.allure.Step;
import utils.MyLogger;

public class DropDownPage extends Base{
	//set locators in the page
    private final By dropdownlist = By.id("dropdown");
    private String[] items ={"Please select an option","Option 1","Option 2"};

	@Step("Choose Item by Index '{0}'step ...")
    public void ChooseItem(int itemindex)
    {
        try
        {
        	MyLogger.info("Choose Item by Index : " + itemindex);
        	getElementActions().selectByIndex(dropdownlist, itemindex);
        }
        catch(Exception e)
        {
        	MyLogger.error("No Item is found by index : " + itemindex);
        }
    }
	
	@Step("Reload DropDown Page step ...")
	public void ReloadDropDownPage()
	{
		getBrowserActions().reloadPage();
	}
	
	@Step("Choose Item by txt '{0}' step ...")
    public void ChooseItem(String itemtxt)
    {
    	try 
        {
    		MyLogger.info("Choose Item by txt : " + itemtxt);
    		getElementActions().selectByVisibleText(dropdownlist, itemtxt);
        }
        catch(Exception e)
        {
        	MyLogger.error("No Item is found by txt : " + itemtxt);
        }
    }
	
    public String GetSelectedItem()
    {
        //GetSelectedItem
    	MyLogger.info("get selected Item in drop box");
    	String result = getElementActions().getFirstSelectiontxt(dropdownlist);
    	MyLogger.info("First selected Item in drop box is : " + result);
    	return result;
    }

    public String GetComparableText(int index)
    {
        String[] items ={"Please select an option","Option 1","Option 2"};
        String result = null;
        try {
            result = items[index];
        	MyLogger.info("get text from fixed array to compare with the chosen element");
        	MyLogger.info("element in fixed array is : " + result);
        }
        catch(java.lang.IndexOutOfBoundsException e)
        {
        	MyLogger.error("index : "+ index +"is out of range");
        }
        return result;
    }
    
    public String GetComparableText(String text)
    {
        
        String result = null;
        try {
        	for(String item : items)
        	{
        		if(item.equals(text))
        		{
        			result = text;
        			break;
        		}
        	}
        	MyLogger.info("get text from fixed array to compare with the chosen element");
        	MyLogger.info("element in fixed array is : " + result);
        }
        catch(java.lang.IndexOutOfBoundsException e)
        {
        	MyLogger.error("text : "+ text +"is not found");
        }
        return result;
    }
}
