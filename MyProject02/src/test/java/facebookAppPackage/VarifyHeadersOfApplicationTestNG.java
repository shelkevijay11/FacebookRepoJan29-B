package facebookAppPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.Base;
import facebookApplication.FacebookHeaders;
import facebookApplication.FacebookLogInPage;
import facebookApplication.HomePageFacebook;
import facebookApplication.YourProfileFacebookApplication;

public class VarifyHeadersOfApplicationTestNG {
	
	WebDriver driver;
	FacebookHeaders facebookHeaders;
	YourProfileFacebookApplication yourProfileFacebookApplication;
	FacebookLogInPage facebookLogInPage;
	HomePageFacebook homePageFacebook;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {

		if(browserName.equals("Chrome"))
		{
			driver = Base.openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver = Base.openFirefoxBrowser();
		}
		if(browserName.equals("Edge"))
		{
			driver = Base.openEdgeBrowser();
		}
		 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
@BeforeClass
public void objectOfPomClasses()
{
	facebookLogInPage = new FacebookLogInPage(driver);
	facebookHeaders = new FacebookHeaders(driver);
}
@BeforeMethod
public void logInToApplication() throws InterruptedException
{
	  driver.get("https://www.facebook.com/");
	  facebookLogInPage.logInToApplication();
	  Thread.sleep(5000);  
}
@Test(priority = 1)
public void varifyPagesButton() 
{
	  facebookHeaders.pages();
	  
	  String url = driver.getCurrentUrl();
	  String title = driver.getTitle();
	  
	  if(url.equals("https://www.facebook.com/pages/?category=your_pages&ref=bookmarks")&& title.equals("(20+) Pages|Facebook"))
	  {
		  System.out.println("PASS");
	  }
	  else
	  {
		  System.out.println("FAIL");
	  }
}
@Test(priority = 2)
public void varifyMassengerButton() 
{
	  facebookHeaders.massanger();
	  
	  String url = driver.getCurrentUrl();
	  String title = driver.getTitle();
	  
	  if(url.equals("https://www.facebook.com/pages/?category=your_pages&ref=bookmarks")&& title.equals("(20+) Pages|Facebook"))
	  {
		  System.out.println("PASS");
	  }
	  else
	  {
		  System.out.println("FAIL");
	  }
}
@AfterMethod
public void logout() throws InterruptedException
{	
	facebookHeaders.yourProfile();
    Thread.sleep(5000);
     yourProfileFacebookApplication = new YourProfileFacebookApplication(driver);
	  yourProfileFacebookApplication.logout();
	  Thread.sleep(5000);
}
@AfterClass
public void clearObject(){
	homePageFacebook = null;
	facebookHeaders = null;
	yourProfileFacebookApplication = null;
}
@AfterTest
public void closedBrowser() {
	driver.close();
	driver = null;
	System.gc(); //garbage collector
}
}

