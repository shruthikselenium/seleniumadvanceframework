package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) throws InterruptedException   {
		//launching the browser
		String key="webdriver.chrome.driver";
		String value="C:\\Users\\Tac03\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		
		driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[1]")).click();
		
		Thread.sleep(1000);
		
		String month = "March 2023";
		String date = "25";
	
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
	
	}
	

}
