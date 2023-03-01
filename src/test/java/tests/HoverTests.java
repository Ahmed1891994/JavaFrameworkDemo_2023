package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import pages.HomePage;
import pages.HoverPage;
import pages.ProfilePage;
import pages.TestBase;

@Listeners(utils.Listener.class)

public class HoverTests extends TestBase{
	HomePage homepage;
	HoverPage hoverpage;
    ProfilePage profilepage;
    
    @Attachment
	@Test(description="Valid Hovering On Images and entering the profile related to image" , dataProvider = "numberofimages")
    public void HoverImg(int index)
    {
    	homepage = new HomePage(getDriver());
		homepage.EnterToLinkByText("Hovers");
        
		hoverpage = new HoverPage(getDriver());
		hoverpage.HoverImgIndex(index);
		hoverpage.EnterOnProfile(index);
		
		profilepage = new ProfilePage(getDriver());
        Assert.assertEquals(profilepage.GetProfileText(), "Not Found");
    }
    @DataProvider(name="numberofimages")
    public static Object[][] Numberofimages()
    {
        return new Object[][] {
                {1},{2},{3}
        };
    }
	
}
