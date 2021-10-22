package tests.beforeafter;

import java.io.IOException;

import org.testng.annotations.Test;

public class ExceptionMessageTest {
	@Test(expectedExceptions = {IOException.class},
			expectedExceptionsMessageRegExp = "Pass Message Test")
	public void exceptionMsgTestOne() throws Exception{
		throw new IOException("Pass Message Test");
	}
	@Test(expectedExceptions = {IOException.class},
			expectedExceptionsMessageRegExp = ".* Message .*")
	public void exceptionMsgTestTwo()throws Exception{
		throw new IOException("Pass Message Test");
	}
	@Test(expectedExceptions = {IOException.class}, expectedExceptionsMessageRegExp = "Pass Message Test")
	public void execptionMsgTestThree() throws Exception{
		throw new IOException("Fail Message Test");
	}
	

}
