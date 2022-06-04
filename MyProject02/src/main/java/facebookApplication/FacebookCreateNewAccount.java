package facebookApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookCreateNewAccount {
	@FindBy (xpath = "//a[contains(text(),'New')]")
	private WebElement createNewAcc ;
	
	@FindBy (xpath = "(//input[@class='inputtext _58mg _5dba _2ph-'])[1]")
	private WebElement firestName ;
	
	@FindBy (xpath = "(//input[@type='text'])[3]")
	private WebElement surName ;
	
	@FindBy (xpath = "(//input[@type='text'])[4]")
	private WebElement mobNoOrEmailAdd ;
	
	@FindBy (xpath = "(//input[@type='password'])[2]")
	private WebElement newPassword ;
	
	@FindBy (xpath = "(//select[@id='day'])")
	private WebElement day ;
	
	@FindBy (xpath = "(//select[@id='month'])")
	private WebElement month ;
	
	@FindBy (xpath = "(//select[@id='year'])")
	private WebElement year ;
	
	@FindBy (xpath = "(//label[text()='Custom'])")
	private WebElement custom ;
	
	public  FacebookCreateNewAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void creatNewAccount() {
		createNewAcc.click();
	}
	public void firestName() {
		firestName.sendKeys("Arti");
	}
	public void surName() {
		surName.sendKeys("Guhade");
	}
	public void mobNoOrEmailAddress() {
		mobNoOrEmailAdd.sendKeys("8823301829");
	}
	public void newPassword() {
		newPassword.sendKeys("Arti@12345");
	}
	public void day() {
		day.click();
	}
	public void month() {
		month.click();
	}
	public void year() {
		year.click();
	}
	public void custom() {
		custom.click();
	}
}

