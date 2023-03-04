package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	public Home_page(WebDriver driver)
	
	{
		PageFactory.initElements(driver,this);
	}

	  @FindBy(xpath="(//a[text()='Organizations'])[1]")
	  private WebElement organizationlink;
	  
	  @FindBy(xpath="//a[text()='Products']")
	  private WebElement productlink;
	  
	  @FindBy(xpath="//a[text()='More']")
	  private  WebElement morelink;
	  
	  @FindBy(xpath="//a[text()='Campaigns']")
	  private WebElement campaignlink;
	  
	  @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	  private WebElement signoutimg;
	  
	  @FindBy(xpath="//a[text()='Sign Out']")
	  private WebElement signoutbtn;
			  
	  public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}
	  
	public WebElement getSignoutimg() {
		return signoutimg;
	}

	

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	  //bussiness logic for organization
	public void clickorganization()
	{
		organizationlink.click();
	}
	
	public void clickproduct()
	{
		productlink.click();
	}
	  public void clickmorelink()
	  {
		  morelink.click();
	  }

     public void clickcampaign()
     {
    	 campaignlink.click();
     }
     
     public void logout(WebDriver driver) {
    	 Actions act = new Actions(driver);
    	 act.moveToElement(signoutimg).perform();
    	 signoutbtn.click();
     }


}

