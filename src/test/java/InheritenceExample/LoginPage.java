package InheritenceExample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import BaseClasses.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
@Test
	public void Test() {
		if(readExcel().equals("Excel")) {
		System.out.print("Excel");
		}
		else {
			System.out.print("Hello");
		}
	}
}
