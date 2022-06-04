package facebookApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerFacebook {
@FindBy (xpath = "(//input[@type='search'])[2]")
private WebElement search;

@FindBy (xpath = "(//span[text()='Akash Kale'])[2]")
private WebElement akash;

@FindBy (xpath = "(//p[@class='kvgmc6g5 oygrvhab'])")
private WebElement message;

@FindBy (xpath = "(//div[@aria-label='Press enter to send'])")
private WebElement send;

public MessengerFacebook(WebDriver driver) {
PageFactory.initElements(driver, this);
}
public void search() {
	search.sendKeys("Akash Kale");
}
public void akash() {
	akash.click();
}
public void message() {
	message.sendKeys("Practice Makes Man Perfect");
}
public void send() {
	send.click();
}
}