package parameter;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class ParameterTest {
@Parameters({"Param -1"})
@Test
public void parameterTestOne(String param) {
	System.out.println("Value in Test One Method ===>  "+param);
}
@Parameters({"Param -2"})
@Test
public void parameterTestTwo(String param1) {
	System.out.println("Value in Test Two Method"+param1);
}
@Parameters({"First Parameter","Second Parameter"})
@Test
public void paramterTestThree(String para1,String para2) {
	System.out.println("Value of First Parameter"+para1);
	System.out.println("Value of Second Parameter" + para2);
}

}

