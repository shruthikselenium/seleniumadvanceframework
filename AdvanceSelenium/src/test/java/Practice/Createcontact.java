package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Createcontact {
public static void main(String[] args) throws IOException, InterruptedException  {
		
		String key = "webdriver.chrome.driver";
		String value ="C:\\Users\\Tac03\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		 System.setProperty(key, value);
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 FileInputStream fis = new FileInputStream("./src/test/resources/commdata.properties.txt");
		 Properties p = new Properties();
		 p.load(fis);
		 String URL = p.getProperty("url");
		 String USNAME = p.getProperty("username");
		 String PASS = p.getProperty("password");
		 driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASS);
		  driver.findElement(By.id("submitButton")).click();
		  driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		  driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		  
		  Random r = new Random();
		  int ranNum = r.nextInt(1000);
		  FileInputStream fes= new FileInputStream("./src/test/resources/data.xlsx");
		  Workbook wb=WorkbookFactory.create(fes);
		  Sheet shname = wb.getSheet("contact");
		  Row rw = shname.getRow(0);
		  Cell cl = rw.getCell(0);
		  String con = cl.getStringCellValue()+ranNum;
		  Sheet shname1 = wb.getSheet("contact");
		  Row rw1 = shname1.getRow(0);
		  Cell cl1 = rw1.getCell(1);
		  String lastName= cl1.getStringCellValue()+ranNum;
		  Sheet shname2 = wb.getSheet("contact");
		  Row rw2 = shname2.getRow(0);
		  Cell cl2 = rw2.getCell(2);
		  String mobile = cl2.getStringCellValue();
		  
		  driver.findElement(By.name("firstname")).sendKeys(con);
		  driver.findElement(By.name("lastname")).sendKeys(lastName);
		  driver.findElement(By.id("mobile")).sendKeys(mobile);
		  driver.findElement(By.name("button")).click();
		  driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		  
		  

}
}
