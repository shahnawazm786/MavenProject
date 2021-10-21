package tests.beforeafter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClasses extends BaseClass{
	@BeforeClass
	public void beforeChildClass() {
		System.out.println("Child Before Class Method");
	}
	@AfterClass
	public void afterChildClass() {
		System.out.println("Child After Class Method");
	}
	@BeforeMethod
	public void beforeChildMethod() {
		System.out.println("Child Before Method");
	}
	@AfterMethod
	public void afterChildMethod() {
		System.out.println("Child After Method");
	}
	@Test
	public void testMethod() {
		System.out.println("Test Method under TestClasses");
	}
	

}
