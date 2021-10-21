package tests.beforeafter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	@BeforeClass
	public void beforeBaseClass() {
		System.out.println("Parent Before Class Method");
	}
	@AfterClass
	public void afterBaseClass() {
		System.out.println("Parent After Class Method");
	}
	@BeforeMethod
	public void beforeBaseMethod() {
		System.out.println("Parent Before Method");
	}
	@AfterMethod
	public void afterBaseMethod() {
		System.out.println("Parent After Method");
	}
	

}
