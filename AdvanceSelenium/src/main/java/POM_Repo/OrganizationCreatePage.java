package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {
	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusimg;
	
	@FindBy(name="accountname")
	private WebElement Orgname;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	
	
	

	
   public WebElement getPlusimg() {
		return plusimg;
	}

	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	public void clickorganizationplus()
	{
		plusimg.click();
	}
	 public void organizationname(String orgname)
	 {
		 Orgname.sendKeys(orgname);
	 }
	 
	 public void clicksave()
	 {
		 savebtn.click();
	 }
}
