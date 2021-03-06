package javascript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {
	private WebDriver driver;
	private JavascriptExecutor js;
	@Test
	public void methodTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		js=(JavascriptExecutor)driver;
		
		driver.get("https://www.browserstack.com");
		driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
		long start_time=System.currentTimeMillis();
		js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");
		//Thread.sleep(5000);
		//js.executeAsyncScript("window.close()");
		driver.close();
		long end_time=System.currentTimeMillis();
		System.out.println("Total time taken -> "+ (end_time-start_time));
	}
	@Test
	public void methodCSSSelector() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blog.testproject.io/");
		long log_time=System.currentTimeMillis();
		//js=(JavascriptExecutor)driver;
		//js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement ele=driver.findElement(By.cssSelector("#menu-top-menu-1"));
		if(ele!=null)
			assertTrue(true,"Element found");
		else
			assertFalse(true);
		
		
		driver.close();
		System.out.println("Total time taken to execute -> " +((System.currentTimeMillis()-log_time)/1000) + "seconds");
	}
	
	@Test
	public void testCssSelectorFirst() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/dropdowns");
		WebElement dropdown=driver.findElement(By.cssSelector("select#first"));
		Select original=new Select(dropdown);
		List<WebElement> listElement=original.getOptions();
		List<String> orgStringList=new ArrayList<String>();
		for(WebElement ele:listElement) {
			orgStringList.add(ele.getText());
		}
		WebElement targetDropdown=driver.findElement(By.id("order-same"));
		Select target=new Select(targetDropdown);
		List<WebElement> targetElement=target.getOptions();
		List<String> targetString=new ArrayList<String>();
		for(WebElement ele:targetElement) {
			targetString.add(ele.getText());
		}
		assertEquals(orgStringList,targetString);
		driver.close();
	}
}
