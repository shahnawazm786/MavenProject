package TestCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample {
	private WebDriver driver=null;
	@BeforeTest
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
	
	@Test(priority = 2)
	public void SearchMultiTest() {
		List<String> data=new ArrayList<String>();
		data.add("Testng Example");
		data.add("Cucumber Example");
		data.add("Unix example");
		data.add("Cyperious example");
		driver.get("https://www.amazon.in/");
		
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		for(String s:data) {
		//search=driver.findElement(By.xpath("//input[@name='q']"));
			//driver.get("https://www.amazon.in/");
			
			search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(s);
		search.sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		search.clear();
		//driver.navigate().to("https://www.google.com");
		}
	}
	
	
	//@AfterClass
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
