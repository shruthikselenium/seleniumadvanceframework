package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import Generics.WebDriver_Utility;
import POM_Repo.CampaignProduct;
import POM_Repo.Home_page;
import POM_Repo.Login_page;


@Test


public class CreateCampaignProductTest extends BaseClass{

  
  public void createCampaignProductTest() throws IOException, InterruptedException {
	  
  
	
//		String key = "webdriver.chrome.driver";
//		String value ="C:\\Users\\Tac03\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
//		 System.setProperty(key, value);
//		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 //fetching the data from property_file
		 Property_Utility plib= new Property_Utility();
//		  String URL = plib.getKeyvalue("url");
//		  String USERNAME = plib.getKeyvalue("username");
//		  String PASS = plib.getKeyvalue("password");
		 /*FileInputStream fis = new FileInputStream("./src/test/resources/commdata.properties.txt");
		  Properties p = new Properties();
		  p.load(fis);
		  String URL = p.getProperty("url");
		  String USERNAME = p.getProperty("username");
		  String PASS = p.getProperty("password");*/
		  
//	  driver.get(URL);
//		  Login_page log= new Login_page(driver);
//		  log.loginToapp(USERNAME, PASS);
//		  /*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		  driver.findElement(By.name("user_password")).sendKeys(PASS);
//		  driver.findElement(By.id("submitButton")).click();*/
//			
		  CampaignProduct cmpo= new CampaignProduct(driver);
		  cmpo.clickproduct();
		  cmpo.clickcreateproduct();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		//driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
			
		//random class
		Java_Utility jlib=new Java_Utility();
		  int rnNum = jlib.getRandomnum();
		   //Random ran = new Random();
			//int raNum = ran.nextInt(100);
		  
		  Excel_Utility elib= new Excel_Utility();
		  String product = elib.getExceldata("product", 0, 0)+rnNum;
		  
		  
		  //fetching the data from excel
		  /*
			FileInputStream fi = new FileInputStream("./src/test/resources/data.xlsx");
			Workbook wb= WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("product");
			Row rw = sh.getRow(0);
			Cell cel = rw.getCell(0);
			String pname = cel.getStringCellValue()+rnNum;*/
		      cmpo.clickprodcuname(product);
		    //driver.findElement(By.name("productname")).sendKeys(product);
			//save
		      cmpo.clickonsave();
		   // driver.findElement(By.name("button")).click();
		    
		    
		    Home_page home= new Home_page(driver);
		    home.clickmorelink();
		    home.clickcampaign();
		    //driver.findElement(By.xpath("//a[text()='More']")).click();
			//driver.findElement(By.name("Campaigns")).click();
			cmpo.clickcampainlink();
			//driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
			
			
		    //fetching the data from excel 
			
			 FileInputStream fs= new FileInputStream("./src/test/resources/data.xlsx");
			 Workbook w=WorkbookFactory.create(fs);
			 Sheet sheet1 = w.getSheet("organization");
			 Row rw2 = sheet1.getRow(0);
			 Cell cellNum = rw2.getCell(0);
			 String campaginname = cellNum.getStringCellValue()+rnNum;
			 
			 cmpo.campaignname(campaginname);
			 cmpo.clickonselect();
			// driver.findElement(By.name("campaignname")).sendKeys(campaginname);
			 //driver.findElement(By.xpath("//img[@alt='Select']")).click();
			 
			//switching the window
			 
			 WebDriver_Utility wlib= new WebDriver_Utility();
			 wlib.switchWindow(driver,"Products&action");
			/*Set<String> allId = driver.getWindowHandles();
			Iterator<String> it = allId.iterator();
			while(it.hasNext()) //org,prd,ctn,lead
			{
				String wid = it.next();
				driver.switchTo().window(wid);
				String title = driver.getTitle();
				if(title.contains("Products&action")) {
					break;
				}
			}*/
			 cmpo.serachtext(product);
			 cmpo.clickonsearch();
			//driver.findElement(By.name("search_text")).sendKeys(product);
			//driver.findElement(By.name("search")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
			//driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
			
			    
			
			 //switching the window
			wlib.switchWindow(driver,"Campaigns&action");
			  
		    	/*Set<String> allId1 = driver.getWindowHandles();
		    	Iterator<String> it1 = allId1.iterator();
		    	while(it1.hasNext())
		    	{
		    		String wid1 = it1.next();
		    		driver.switchTo().window(wid1);
		    		String title1 = driver.getTitle();
		    		if(title1.contains("Campaigns&action")) {
		    			
		    			break;
		    	}
		    }*/
			cmpo.clickonlastsavee();
			//driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	

	}
}

