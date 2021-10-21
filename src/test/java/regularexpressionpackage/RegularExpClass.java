package regularexpressionpackage;

import org.testng.annotations.Test;
public class RegularExpClass {

	@Test
	public void includeFirstTest() {
		System.out.println("First include test method");
	}
	@Test
	public void includeSecondTest() {
		System.out.println("Second include test method");
	}
	@Test
	public void excludeFirstTest() {
		System.out.println("First exclude test method");
	}
	
	@Test
	public void excludeSecondTest() {
		System.out.println("Second exclude test method");
	}
	@Test
	public void includeMethod() {
		System.out.println("Include method");
	}
	@Test
	public void excludeMethod() {
		System.out.println("Exclude method");
	}
	
	
}
