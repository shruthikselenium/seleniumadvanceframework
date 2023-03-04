package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpom {
	
	
	
	public Productpom(WebDriver driver) {
		
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusimg;
	
	@FindBy(name="productname")
	private WebElement productnametextbox;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(name="Delete")
	private WebElement deletebtn;
	
	

	public WebElement getPlusimg() {
		return plusimg;
	}

	public WebElement getProductnametextbox() {
		return productnametextbox;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	
	
	public void clickplusbutton() {
		plusimg.click();
	}
	
	public void productname(String pname) {
		productnametextbox.sendKeys(pname);
		
	}
	public void  clicksavebtn()
	{
		savebtn.click();
	}
	public void clickdelete()
	{
		deletebtn.click();
	}
	
	

}
