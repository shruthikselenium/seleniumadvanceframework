package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignProduct {
	
	public  CampaignProduct(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	 @FindBy(xpath="//a[text()='Products']")
	 private WebElement producttextbbox;
	 
	 @FindBy(xpath="//img[@alt=\"Create Product...\"]")
	 private WebElement createproducttext;
	 
	 @FindBy(name="productname")
	 private WebElement productnametext;
	 
	 @FindBy(name="button")
	 private WebElement savebtn;
	 
	 @FindBy(xpath="//img[@alt=\"Create Campaign...\"]")
	 private WebElement createcamptext;
	 
	 @FindBy(name="campaignname")
	 private WebElement campaignnametext;
	 
	 @FindBy(xpath="//img[@alt='Select']")
	 private WebElement selectimg;
	 
	 @FindBy(name="search_text")
	 private WebElement searchtextbox;
	 
	 @FindBy(name="search")
	 private WebElement searchclick;
	 
	 @FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	 private WebElement savebutton;

	public WebElement getProducttextbbox() {
		return producttextbbox;
	}

	public WebElement getCreateproducttext() {
		return createproducttext;
	}

	public WebElement getProductnametext() {
		return productnametext;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getCreatecamptext() {
		return createcamptext;
	}

	public WebElement getCampaignnametext() {
		return campaignnametext;
	}

	public WebElement getSelectimg() {
		return selectimg;
	}

	public WebElement getSearchtextbox() {
		return searchtextbox;
	}

	public WebElement getSearchclick() {
		return searchclick;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	 
	public void clickproduct()
	{
		producttextbbox.click();
	}
	public void clickcreateproduct()
	{
		createproducttext.click();
	}
	 public void clickprodcuname(String product)
	 {
		 productnametext.sendKeys(product);
	 }
	 
	 public void clickonsave() {
		 savebtn.click();
	 }
	 public void clickcampainlink()
	 {
		 createcamptext.click();
		 
	}
	
	 public void campaignname(String campaginname)
	 {
		 campaignnametext.sendKeys(campaginname);
	 }
	
	 
	 public void clickonselect()
	 {
		 selectimg.click();
	 }
	 
	 public void serachtext(String product)
	 {
		 searchtextbox.sendKeys(product);
	 }
	 public void clickonsearch()
	 {
		 searchclick.click();
	 }
	 public void clickonlastsavee()
	 {
		 savebutton.click();
		}
	 }

