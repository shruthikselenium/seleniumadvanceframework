package Campaign;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generics.BaseClass;
import Generics.Excel_Utility;
import Generics.Java_Utility;
import Generics.Property_Utility;
import Generics.WebDriver_Utility;
import POM_Repo.Campaginpom;
import POM_Repo.Home_page;
import POM_Repo.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;
 @Test(groups="SmokeTest")
public class CreateCampaginTest  extends BaseClass {

	public void createecampagin() throws IOException{
		
		Property_Utility plib= new Property_Utility();
//		 String BROWSER = plib.getKeyvalue("browser");
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//			
//		}
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//			
//		}
//		else {
//			driver= new ChromeDriver();
//		}
//		
//		String key = "webdriver.chrome.driver";
//		String value ="C:\\Users\\Tac03\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
//		 System.setProperty(key, value);
//		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 //fetching the data from property_file
		  
//		  String URL = plib.getKeyvalue("url");
//		  String USERNAME = plib.getKeyvalue("username");
//		  String PASS = plib.getKeyvalue("password");
//		/* FileInputStream fis = new FileInputStream("./src/test/resources/commdata.properties.txt");
//		  Properties p = new Properties();
//		  p.load(fis);
//		  String URL = p.getProperty("url");
//		  String USERNAME = p.getProperty("username");
//		  String PASS = p.getProperty("password"); */
//		  
//		  driver.get(URL);
//		  Login_page log= new Login_page(driver);
//		  log.loginToapp(USERNAME, PASS);
		  /*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASS);
		  driver.findElement(By.id("submitButton")).click();*/
		  
		  
		  WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		  Actions a = new Actions(driver);
		  a.moveToElement(more).perform();
		  
		  Home_page home= new Home_page(driver);
		  home.clickcampaign();
		  //driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		  
		  Campaginpom cmpname = new Campaginpom(driver);
		  cmpname.createcampclick();
		  //driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		  
		  Java_Utility jlib=new Java_Utility();
		  int rnNum = jlib.getRandomnum();
		  //Random rn= new Random();
		  //int rnNum = rn.nextInt(1000);
		  
		  Excel_Utility elib= new Excel_Utility();
		  //String campname = elib.getExceldata("campaign", 0, 0)+rnNum;
		  
		  String campname = elib.getExcelusingdataformat("campaign",0,0)+rnNum;
		  //fetching the data from excel
		  /*
		  FileInputStream fi= new FileInputStream("./src/test/resources/data.xlsx");
		  Workbook wb= WorkbookFactory.create(fi);
		   Sheet sh = wb.getSheet("campaign");
		   Row ro = sh.getRow(0);
		   Cell cel = ro.getCell(0);
		   String cam = cel.getStringCellValue()+rnNum;*/
		  
		  cmpname.campaigncreateclick(campname);
		  cmpname.savebtnclick();
		   //driver.findElement(By.name("campaignname")).sendKeys(campname);
		  // driver.findElement(By.name("button")).click();
		   
		   
		   
		    
		  String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		   if(actdata.contains(campname))
		     {
		    	 System.out.println("pass");
		     }
		     else 
		     {
		    	 System.out.println("fail");
		     }
		   
		  // home.logout(driver);
		  
		  driver.close();
	}

}
