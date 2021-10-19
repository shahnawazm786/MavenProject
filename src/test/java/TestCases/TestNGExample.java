package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGExample {
	WebDriver driver;
	@BeforeClass
	public void Method1() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver=new ChromeDriver();
	}
	@Test
	public void Method2() {
		
		driver.get("https://www.google.com");
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
