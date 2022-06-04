package facebookAppPackage;

import java.io.IOException;
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

public class varifySendMassagesOfApplication2 {
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
			driver = Base.openEdgeBrowser();		}
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
	@Test
	public void varifyCreateNewGroupButton() throws InterruptedException, IOException
	{      
		   homePageFacebook = new HomePageFacebook(driver);
		   Thread.sleep(5000);
		   homePageFacebook.createNewGroup();	
		   Thread.sleep(5000);
		   homePageFacebook.sendMessageTo();
		   Thread.sleep(8000);
		   homePageFacebook.AkashKale();
		   Thread.sleep(5000);
		   homePageFacebook.sendLike();
	}
	@AfterMethod
	public void logout() throws InterruptedException
	{	facebookHeaders.yourProfile();
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
