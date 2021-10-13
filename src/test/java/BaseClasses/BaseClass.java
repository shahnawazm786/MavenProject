package BaseClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {
protected WebDriver driver=null;
public BaseClass(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public String readExcel() {
	return "Hello";
}

}
