package Organization;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import Generics.BaseClass;
import Generics.Excel_Utility;
import Generics.Java_Utility;
import Generics.Property_Utility;
import Generics.Validation;
import Generics.WebDriver_Utility;
import POM_Repo.Home_page;
import POM_Repo.Login_page;
import POM_Repo.OrganizationCreatePage;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Test(groups="RegressionTest")


public class CreateOrganizationTc2 extends BaseClass{
	@Test(retryAnalyzer=Generics.RetryAnalyser.class)
	
	public void createorganization() throws IOException, InterruptedException {
	
		//Property_Utility plib= new Property_Utility();
		 
		//String key="webdriver.chrome.driver";
    	//String value="C:\\Users\\Tac03\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		//System.setProperty(key, value);
		//WebDriver driver= new ChromeDriver();
		// fetching data from Property_file
		
		
		 // String URL = plib.getKeyvalue("url");
		  //String USERNAME = plib.getKeyvalue("username");
		  //String PASS = plib.getKeyvalue("password");
		
		/*FileInputStream fis= new FileInputStream("./src/test/resources/commdata.properties.txt");
		Properties pro= new Properties();
	    pro.load(fis);
	    String URL = pro.getProperty("url");
	    String USERNAME = pro.getProperty("username");
	    String PASS = pro.getProperty("password");*/
	    //driver.get(URL);
	    //Login_page lp=new Login_page(driver);
	    //lp.loginToapp(USERNAME, PASS);
	    
	    //driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	     //driver.findElement(By.name("user_password")).sendKeys(PASS);
	     //driver.findElement(By.id("submitButton")).click();
	     
	    
		
	     Home_page home= new Home_page(driver);
	      home.clickorganization();
	     
	    // driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click(); 
	     //click on +img
	      OrganizationCreatePage orgname= new OrganizationCreatePage(driver);
		    orgname.clickorganizationplus();
	     //driver.findElement(By.xpath("//img[@src="themes/softed/images/btnL3Add.gif"]")).click();
	     
	     Java_Utility jlib= new Java_Utility();
	     int ranNum = jlib.getRandomnum();
	     //Random rn= new Random();
	     //int ranNum = rn.nextInt(1000);
	     
	     Thread.sleep(1000);
	     Excel_Utility elib=new Excel_Utility();
	    String orgName = elib.getExceldata("organization",0,0)+ranNum;
	    // String orgName = elib.getExceldata("organization",0,0)+ranNum;
	     //fetching data from excel sheet
	     /*
	     FileInputStream fes= new FileInputStream("./src/test/resources/data.xlsx");
	     Workbook wb=WorkbookFactory.create(fes);
	     Sheet org = wb.getSheet("organization");
	     Row rw = org.getRow(0);
	     Cell cl = rw.getCell(0);
	     String orgName = cl.getStringCellValue()+ranNum;*/
	     
	     orgname.organizationname(orgName);
	     Assert.assertEquals(false, true);
	     //driver.findElement(By.name("accountname")).sendKeys(orgName);
	     orgname.clicksave();
	     //driver.findElement(By.name("button")).click();
	     
	     
	     
	    
	     Thread.sleep(2000);
	    //String actdata = driver.findElement(By.xpath("//span[text()='[ ACC18 ] Testyanta51 -  Organization Information']")).getText();
	     Validation val= new Validation(driver);
	    String actdata = val.orgvalidation(driver,orgName);
	     //Hardassert
	    Assert.assertEquals(orgName,actdata);
	     /*if(actdata.contains(orgName))
	     {
	    	 System.out.println("pass");
	     }
	     else 
	     {
	    	 System.out.println("fail");
	     }*/
	   
	     //home.logout(driver);
		//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	
	
	}
	
	
	
	
}
