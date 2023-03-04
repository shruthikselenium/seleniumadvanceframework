package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	public Login_page(WebDriver driver) {
		
		PageFactory.initElements( driver,this);
	}
   //declaration
	@FindBy(name="user_name")
	private WebElement usernametextfield;
	
	@FindBy(name="user_password")
	private WebElement passtextfield;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	public WebElement getusertext()
	{
		
		return usernametextfield;
		
	}
	public WebElement getpasswordtext()
	{
		return passtextfield;
		
	}
	
	public WebElement getloginbtn()
	{
		return loginbutton;
	}
	
	public void loginToapp(String username,String password) {
		usernametextfield.sendKeys(username);
		passtextfield.sendKeys(password);
		loginbutton.click();
	}
	
}
