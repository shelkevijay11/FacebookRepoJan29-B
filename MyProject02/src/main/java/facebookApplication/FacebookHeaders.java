package facebookApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHeaders {
@FindBy(xpath = "(//span[@class='l9j0dhe7'])[1]")
private WebElement home;

@FindBy(xpath = "//a[@aria-label='Pages']")
private WebElement pages;

@FindBy(xpath = "//a[@aria-label='Watch']")
private WebElement watch;

@FindBy(xpath = "//a[@aria-label='Marketplace']")
private WebElement marketPlace;

@FindBy(xpath = "//a[@aria-label='More']")
private WebElement more;

@FindBy(xpath = "//div[@aria-label='Create']")
private WebElement create;

@FindBy(xpath = "(//div[@aria-label='Messenger'])[1]")
private WebElement massanger;

@FindBy(xpath = "(//div[@class='rq0escxv l9j0dhe7 du4w35lb'])[2]")
private WebElement notifications;

@FindBy(xpath = "//div[@class='j83agx80 l9j0dhe7']")
private WebElement yourProfile;

@FindBy(xpath = "(//span[@class='ijkhr0an pvl4gcvk sgqwj88q bp9cbjyn j83agx80 g0qnabr5 hzruof5a tw6a2znq'])[1]")
private WebElement search;

@FindBy(xpath = "//a[@aria-label='Facebook']")
private WebElement facebookLogo;

public  FacebookHeaders(WebDriver driver) {
	PageFactory.initElements(driver, this);
 }
public void home() {
	home.click();
}
public void pages() {
	pages.click();
}
public void watch() {
	watch.click();
}
public void marketPlace() {
	marketPlace.click();
}
public void more() {
	more.click();
}
public void create() {
	create.click();
}
public void massanger() {
	massanger.click();
}
public void notifications() {
	notifications.click();
}
public void yourProfile() {
	yourProfile.click();
}
public void search() {
	search.click();
}
public void facebookLogo() {
	facebookLogo.click();
}





















}
