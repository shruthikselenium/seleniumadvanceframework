package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderEx2 {
	@Test(dataProvider="dataProvider_test")
	
	public  void companyDetails(String name , String contact , String email) throws InterruptedException {
		String key ="webdriver.chrome.driver";
		String value="C:\\Users\\Tac03\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).sendKeys(contact);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.name("button")).click();
		driver.quit();
		Thread.sleep(2000);
		
	}
		
@DataProvider()
	public  Object dataProvider_test() throws InterruptedException {
		Object[][] objArr = new Object[3][3];
		objArr[0][0]="Aditya";
		objArr[0][1]="9887744552";
		objArr[0][2]="aditya@gmail.com";
		Thread.sleep(2000);
		objArr[1][0]="Ashwin";
		objArr[1][1]="79722856485";
		objArr[1][2]="aswin@gmail.com";
		Thread.sleep(2000);
		objArr[2][0]="Aradhya";
		objArr[2][1]="997788556644";
		objArr[2][2]="aradhy@gamil.com";
		return objArr;
		
	}

		
}
