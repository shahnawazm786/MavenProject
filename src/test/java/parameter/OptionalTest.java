package parameter;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class OptionalTest {
	
	@Parameters({"Optional-value"})
	@Test
	public void optionalTest(@Optional("Optional value")String value) {
		System.out.println("Optional Test Value ==> " + value);
		
	}

}
