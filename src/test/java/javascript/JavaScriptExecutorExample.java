package javascript;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {
	private WebDriver driver;
	private JavascriptExecutor js;
	@Test
	public void methodTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com");
		js=(JavascriptExecutor)driver;
		js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.close();
	}
	public void methodCSSSelector() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blog.testproject.io/");
		//js=(JavascriptExecutor)driver;
		//js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement ele=driver.findElement(By.cssSelector("#menu-top-menu-1"));
		if(ele!=null)
			assertTrue(true,"Element found");
		else
			assertFalse(true);
		

	}
}
