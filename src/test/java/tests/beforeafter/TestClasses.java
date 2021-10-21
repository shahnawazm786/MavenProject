package tests.beforeafter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestClasses extends BaseClass{
	@BeforeClass
	public void beforeChildClass() {
		System.out.println("Child Before Class Method");
	}
	@AfterClass
	public void afterChildClass() {
		System.out.println("Child After Class Method");
	}
	

}
