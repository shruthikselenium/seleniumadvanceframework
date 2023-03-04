package Generics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repo.Home_page;
import POM_Repo.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 public   WebDriver driver;
	 public static WebDriver sdriver;
	 public Property_Utility plib= new Property_Utility();
	
	@BeforeSuite
	public void BS() {
		System.out.println("Data connection");
	}
@BeforeTest
public void BT() {
	System.out.println("parallel execution");
}
//@Parameters("BROWSER")
@BeforeClass

public void BC() throws IOException

{
	
	 String BROWSER = plib.getKeyvalue("browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
	}
	else {
		driver= new ChromeDriver();
	}
	System.out.println("Launching browser");
	sdriver=driver;
}
@BeforeMethod
public void BM() throws IOException {
	Property_Utility plib= new Property_Utility();
	String URL = plib.getKeyvalue("url");
	String USERNAME = plib.getKeyvalue("username");
	 String PASS = plib.getKeyvalue("password");
	 driver.get(URL);
	 Login_page lp=new Login_page(driver);
	 lp.loginToapp(USERNAME, PASS);
	    
	System.out.println("Login application");
}
@AfterMethod
public void  AM()
{
	 Home_page home= new Home_page(driver);
	home.logout(driver);
	System.out.println("logout application");
}
@AfterClass
public void AC()
{
	System.out.println("Close the  browser");
}
@AfterTest
public void AT()
{
	System.out.println("parallel execution done");
	}
@AfterSuite
public void AS()
{
	 System.out.println("database closed");
	}
}
