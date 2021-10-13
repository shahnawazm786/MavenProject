package PageObject;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	@SuppressWarnings("unused")
	private WebDriver driver;
	private WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Wait Element
	public boolean ifElementDisplayed(WebElement element) {
		return exciplitWaitElement(element,10).isDisplayed();
	}
	
	public WebElement exciplitWaitElement(WebElement element,long timeout) {
		
		try {
			wait=new WebDriverWait(driver,timeout);
			return  wait.ignoring(NoSuchElementException.class)
			.pollingEvery(5,TimeUnit.SECONDS)
			.until(ExpectedConditions.elementToBeClickable(element));
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
	}
	public WebElement waitElementBy(By by,long timeout) {
		wait=new WebDriverWait(driver,timeout);
		return wait.ignoring(NoSuchElementException.class)
		.pollingEvery(5,TimeUnit.SECONDS)
		.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
}
