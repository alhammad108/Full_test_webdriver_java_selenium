import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paramiter {
	
	public WebDriver driver;
	
	String My_Url="https://www.demoblaze.com/index.html# ";
		SoftAssert mysoftassert=new SoftAssert();
String expected_title="STORE";

@BeforeTest()
public void My_pretest() {				
	WebDriverManager.chromedriver().setup();
	
	driver=new ChromeDriver();
	driver.get(My_Url);
	driver.manage().window().maximize();
}


}
