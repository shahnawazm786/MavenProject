package TestCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGExample {
	private WebDriver driver=null;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		
	}
	@Test
	public void SearchTest() throws Exception {
		
		driver.get("https://www.google.com");
		WebElement search=driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("Selenium");
		search.sendKeys(Keys.RETURN);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		List<WebElement> listElement=driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
		System.out.println(listElement.size());
		if(listElement.size()>0) {
			assertTrue(true,"List found of "+listElement.size());
		}
		else {
			assertFalse(true);
		}
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
