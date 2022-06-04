package facebookAppPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import facebookApplication.FacebookHeaders;
import facebookApplication.FacebookLogInPage;
import facebookApplication.HomePageFacebook;
import facebookApplication.MessengerFacebook;
import facebookApplication.YourProfileFacebookApplication;

public class VarifyHeadersOfApplication {


	 public static void main(String[] args) throws InterruptedException, IOException {
		  System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION TESTING\\CHROMEDRIVER2022\\ChromeDriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		  
		  /* 1st Test Case -> Open the Browser, Inter the valid url, insert the valid credentials in LogIn Page,
		  open the PagesPage, Validate the current url and Page title. */
		  
		  driver.get("https://www.facebook.com/");
		  FacebookLogInPage facebookLogInPage = new FacebookLogInPage(driver);
		  facebookLogInPage.logInToApplication();
		  Thread.sleep(5000);
		  FacebookHeaders facebookHeaders = new FacebookHeaders(driver);
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
		  facebookHeaders.yourProfile();
		  Thread.sleep(5000);
		  YourProfileFacebookApplication yourProfileFacebookApplication = new YourProfileFacebookApplication(driver);
		  yourProfileFacebookApplication.logout();
		  
		  /* 2nd Test Case --> Open the Browser,Inter valid url,insert valid credentials in logInPage, 
		  Open the Header Messenger, validate the current url and Page Title*/
		  
		  driver.get("https://www.facebook.com/");
		  Thread.sleep(2000);
		  facebookLogInPage.logInToApplication();
		  Thread.sleep(5000);
		  facebookHeaders.massanger();
		  
		   url = driver.getCurrentUrl();
		   title = driver.getTitle();
		   
		   if(url.equals("https://www.facebook.com/pages/?category=your_pages&ref=bookmarks") && title.equals("(20+) Pages|Facebook"))
			  {
				  System.out.println("PASS");
			  }
			  else
			  {
				  System.out.println("FAIL");
			  }
		   Thread.sleep(5000);
		   MessengerFacebook messengerFacebook = new MessengerFacebook(driver);
		   
		   messengerFacebook.search();
		   messengerFacebook.akash();
		   messengerFacebook.message();
		   messengerFacebook.send();
		 
		   Thread.sleep(2000);
		   facebookHeaders.yourProfile();
			  Thread.sleep(5000);
			  yourProfileFacebookApplication.logout();
			  
			/*3 rd test Case--> Open the Browser,Inter the valid url,Insert the valid credentials in fields,
			  Hit the LogIn Button,Open the HomePage,ScrollDown, Open the Create new Group. Take a Screenshot*/  
			  Thread.sleep(2000);
			  driver.get("https://www.facebook.com/");
			  facebookLogInPage.logInToApplication();
			  HomePageFacebook homePageFacebook = new HomePageFacebook(driver);
			  Thread.sleep(5000);
			  
			   homePageFacebook.createNewGroup();	
			   Thread.sleep(5000);
			   homePageFacebook.sendMessageTo();
			   Thread.sleep(8000);
			   homePageFacebook.AkashKale();
			   Thread.sleep(5000);
				 
			   homePageFacebook.sendLike();
			  
			   facebookHeaders.yourProfile();
			
			Thread.sleep(5000);
			 yourProfileFacebookApplication.logout();
			  
				  driver.close();	     
		  
}
}
