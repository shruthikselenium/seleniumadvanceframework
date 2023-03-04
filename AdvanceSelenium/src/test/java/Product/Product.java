package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generics.BaseClass;
import Generics.Excel_Utility;
import Generics.Java_Utility;
import Generics.Property_Utility;
import POM_Repo.Home_page;
import POM_Repo.Productpom;

public class Product extends BaseClass{
 
	@Test
	public void product() throws EncryptedDocumentException, IOException  {
		
		Property_Utility plib= new Property_Utility();
//		String key= "webdriver.chrome.driver";
//		String value="C:\\Users\\Tac03\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
//		System.setProperty(key, value);
//		WebDriver driver= new ChromeDriver();
//	    driver.manage().window().maximize();
//		
		//fetching the data from Property_file
	    
		
		

		Home_page home = new Home_page(driver);
	    home.clickproduct();
	//driver.findElement(By.xpath("//a[text()='Products']")).click();
	
	Productpom pl= new Productpom(driver);
	pl.clickplusbutton();
	
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	Java_Utility jlib= new Java_Utility();
	int raNum = jlib.getRandomnum();
	//Random ran = new Random();
	//int raNum = ran.nextInt(100);
	
	
	Excel_Utility elib= new Excel_Utility();
	String pname = elib.getExceldata("product", 0, 0)+raNum;
	//fetching data from excel sheet
	/*
	FileInputStream fi = new FileInputStream("./src/test/resources/data.xlsx");
	Workbook wb= WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("product");
	Row rw = sh.getRow(0);
	Cell cel = rw.getCell(0);
	String pname = cel.getStringCellValue()+raNum;*/
	
	pl.productname(pname);
	pl.clicksavebtn();
	pl.clickdelete();
	//driver.findElement(By.name("productname")).sendKeys(pname);
	//driver.findElement(By.name("button")).click();
	//driver.findElement(By.name("Delete")).click();
	Alert alt = driver.switchTo().alert();
	alt.accept();
	
	
	  
	  String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	     if(actdata.contains(pname))
	     {
	    	 System.out.println("pass");
	     }
	     else 
	     {
	    	 System.out.println("fail");
	     }
	   
	  // home.logout(driver);
	//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	

	}

}
