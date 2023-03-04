package Generics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {

	  public void switchWindow(WebDriver driver,String PartialWindowTitle)
	  {
		  Set<String> allId = driver.getWindowHandles();
			Iterator<String> it = allId.iterator();
			while(it.hasNext()) //org,prd,ctn,lead
			{
				String wid = it.next();
				driver.switchTo().window(wid);
				String title = driver.getTitle();
				if(title.contains("Products&action")) {
					break;
				}
			}
	  }
	  
	  public void movetoelement(WebDriver driver, WebElement element) {
		  
		  Actions a= new Actions(driver);
		  a.moveToElement(element).perform();
	  }

	

}
