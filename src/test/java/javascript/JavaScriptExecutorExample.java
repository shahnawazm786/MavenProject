package javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
	}

}
