import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class my_testCase extends paramiter {
@Test()
public void Log_in() {
	String Actual_tittle=driver.getTitle();
	assertEquals(Actual_tittle, expected_title);
	
mysoftassert.assertAll();
}
@Test(priority= 1,groups="customer")
public void LoginAscustomer() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
}
	@Test(priority = 1, groups = "maneger")
	public void LoginAsmaneger() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).click();
	}

	@Test(priority = 2, groups = "maneger")
	public void Addcustomer() throws InterruptedException {
		int userID = (int) (Math.random() * 100);
		StringBuilder userName = new StringBuilder();
		userName.append(userID);
		String UserIdAsstring = userName.toString();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("Mr");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"))
				.sendKeys("User" + UserIdAsstring);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"))
				.sendKeys(UserIdAsstring);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		Thread.sleep(2000);
		String Mytextalert = driver.switchTo().alert().getText();

		boolean chickalert = Mytextalert.contains("Customer added successfully");
		assertEquals(chickalert, true);

		driver.switchTo().alert().accept();

		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"))
				.sendKeys("User" + UserIdAsstring);

		mysoftassert.assertAll();
	}
@Test()
public void Open_customer() throws InterruptedException {
	String bigamount="1000";
	String smallamouont="600";
int num1=	Integer.parseInt(smallamouont);
	int num2 = Integer.parseInt(bigamount);
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
	Thread.sleep(2000);
	
	Select Myselect = new Select(driver.findElement(By.id("userSelect")));

Myselect.selectByVisibleText("Harry Potter");
Thread.sleep(2000);
driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
Thread.sleep(2000);

driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(bigamount);

driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
Thread.sleep(2000); 
driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(smallamouont);
Thread.sleep(2000);
driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();

String balance= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
Thread.sleep(2000);

assertEquals(balance,num2-num1);
mysoftassert.assertAll();

}


	
}

