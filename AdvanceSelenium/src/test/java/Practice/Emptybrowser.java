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


public class Emptybrowser {

	public static void main(String[] args) throws IOException, InterruptedException  {
		
		String key = "webdriver.chrome.driver";
		String value ="C:\\Users\\Tac03\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		 System.setProperty(key, value);
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		//driver.get("http://localhost:8888/");
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commdata.properties.txt");
		  Properties p = new Properties();
		  p.load(fis);
		  String URL = p.getProperty("url");
		  String USERNAME = p.getProperty("username");
		  String PASS = p.getProperty("password");
		  
		  driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASS);
		  driver.findElement(By.id("submitButton")).click();
		  driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		  driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		    
		  Random ran = new Random();
		  int ranNum = ran.nextInt(1000);
		  //fetching data from excel
		  FileInputStream fi= new FileInputStream("./src/test/resources/data.xlsx");
		  Workbook wb= WorkbookFactory.create(fi);
		  Sheet sh1 = wb.getSheet("organization");
		  Row row = sh1.getRow(0);
		  Cell cel = row.getCell(0);
		  String orgname = cel.getStringCellValue()+ranNum;
		  
		  
		  driver.findElement(By.name("accountname")).sendKeys(orgname);
		  driver.findElement(By.name("button")).click();
		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		  
		  
		 }
		 

}