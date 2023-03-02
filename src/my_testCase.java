import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class my_testCase extends paramiter{
@Test()
public void chick_the_Title() {
	String Actual_title=driver.getTitle();
	assertEquals(Actual_title, expected_title);
	mysoftassert.assertAll();
}
@Test()
public void chick_the_imeges_drower() {
	List<WebElement> my_imeges=driver.findElements(By.className("img-fluid"));
	boolean image_check1 = my_imeges.get(0).getAttribute("src")==my_imeges.get(1).getAttribute("src");
	boolean image_check2 = my_imeges.get(1).getAttribute("src")==my_imeges.get(2).getAttribute("src");
	boolean image_check3 = my_imeges.get(2).getAttribute("src")==my_imeges.get(1).getAttribute("src");
	mysoftassert.assertEquals(image_check1, false,"image one with image two");
	mysoftassert.assertEquals(image_check2, false,"image two with image three ");
	mysoftassert.assertEquals(image_check3, false,"image three with image one");
	mysoftassert.assertAll();
}
	
	@Test
	public void validate_Contact() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String the_name_Of_emils []= {"a1@gmail.com","a2@gmail.com","a3@gmail.com","a4@gmail.com"};
Random check_Email=new Random();
int num_Rand =  check_Email.nextInt(4);
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys(the_name_Of_emils[num_Rand]);
		Thread.sleep(3000);
String attribute_Of_email = driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).getAttribute("value");
String regex = "^(.+)@(.+)$";


Pattern pattern = Pattern.compile(regex);


Matcher matcher = pattern.matcher(the_name_Of_emils[num_Rand]);
System.out.println(the_name_Of_emils[num_Rand]+"is valid "+matcher.matches());


boolean my_check_Of_themaches = matcher.matches();
mysoftassert.assertEquals(my_check_Of_themaches,true);

mysoftassert.assertAll();
	}
	
}


