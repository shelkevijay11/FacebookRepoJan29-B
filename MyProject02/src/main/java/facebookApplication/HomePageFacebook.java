package facebookApplication;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFacebook {
@FindBy (xpath = "//span[text()='Create new group']")
private WebElement createNewGroup;

@FindBy (xpath = "//input[@aria-label='Send message to']")
private WebElement sendMessageTo;

@FindBy (xpath = "(//span[text()='Akash Kale'])[2]")
private WebElement AkashKale;

@FindBy (xpath = "//div[@aria-label='Send a Like']")
private WebElement sendLike;

WebDriver driver;
public HomePageFacebook(WebDriver driver) throws IOException {
	PageFactory.initElements(driver, this);
	this.driver = driver;
	
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", createNewGroup);
	
	TakesScreenshot shot = (TakesScreenshot)driver;
	File sourc = shot.getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Users\\Dell\\OneDrive\\Desktop\\seleshot\\Test123.jpeg");
	FileHandler.copy(sourc, dest);
}
public void createNewGroup() {
	createNewGroup.click();
}
public void sendMessageTo() {
	sendMessageTo.sendKeys("Akash Kale");
}
public void AkashKale() {
	AkashKale.click();
	
}
public void sendLike() {
	sendLike.click();
}
}
