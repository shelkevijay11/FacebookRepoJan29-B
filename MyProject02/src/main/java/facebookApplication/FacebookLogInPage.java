package facebookApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLogInPage {
	@FindBy (xpath = "//input[@id='email']")
	private WebElement email ;

	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password ;

	@FindBy (xpath = "//button[contains(text(),'Log')]")
	private WebElement logIn ;

	public FacebookLogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void logInToApplication() {
		email.sendKeys("9284872631");
		password.sendKeys("7507170795");
		logIn.click();
	}


	}

