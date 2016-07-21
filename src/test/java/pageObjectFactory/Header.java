package pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
	
	@FindBy(xpath = "//div[@class='header']//a[@href='/home']")
	public WebElement Home_Logo;
		public void gotoHome(){
		Home_Logo.click();
		}
	
	@FindBy(xpath="//div[@id='menu']/ul/li[1])")
	public WebElement About;
		public void clickAbout(){
		About.click();
		}
	
	@FindBy(xpath="//div[@id='menu']/ul/li[2]")
	public WebElement Product;
		public void clickProduct(){
		Product.click();
		}
	
	@FindBy(xpath = "//div[@id='menu']/ul/li[3]")
	public WebElement Resources;
		public void clickResources(){
		Resources.click();
		}
		
	@FindBy(xpath = "//div[@id='menu']/ul/li[4]")
	public WebElement Support;
		public void clickSupport(){
		Support.click();
		}
	
	@FindBy(xpath = "//div[@id='menu']/ul/li[5]")
	public WebElement Warranty;
		public void clickWarranty(){
		Warranty.click();
		}
		
	@FindBy(xpath = "//div[@id='menu']/ul/li[6]")
	public WebElement ProductReg;
		public void clickProdReg(){
		ProductReg.click();
		}
		
	@FindBy(xpath = "//div[@class='search-icon']//a[contains(text(), 'Search Goodman')]")
	public WebElement Search;
		public void Search(){
		Search.sendKeys("text");
		}
	
	@FindBy(xpath = "//div[@class='dealer-icon']//a[@href='/resources/find-a-dealer']")
	public WebElement FindDealer;
		public void clickDealer(){
		FindDealer.click();
		}
		
}
