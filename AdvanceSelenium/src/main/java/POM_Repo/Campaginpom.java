package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaginpom {
	 public Campaginpom(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy(xpath="//img[@alt='Create Campaign...']")
			 private WebElement createcamplink;
	  
	 @FindBy(name="campaignname")
	   private WebElement campaginnamelink;
	   
	 @FindBy(name="button")
	  private WebElement savebtn;

	public WebElement getCreatecamplink() {
		return createcamplink;
	}

	public WebElement getCampaginnamelink() {
		return campaginnamelink;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	 
	 public void createcampclick()
	 {
		 createcamplink.click();
	 }
	 
	 public void campaigncreateclick(String campname)
	 {
		 campaginnamelink.sendKeys(campname);
	 }
	 
	 public void savebtnclick()
	 {
		 savebtn.click();
	 }
}





