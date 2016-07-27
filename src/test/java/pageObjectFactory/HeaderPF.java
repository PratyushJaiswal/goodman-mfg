package pageObjectFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HeaderPF {
	WebDriver driver;
	@FindBy(xpath = "//div[@id='menu']/ul/li[1]")
	public WebElement About;
	@FindBy(xpath ="//div[@id='menu']/ul/li[2]")
	public WebElement Product;
	@FindBy(xpath ="//div[@id='menu']/ul/li[3]")
	public WebElement Resource;
	@FindBy(xpath ="//div[@id='menu']/ul/li[4]")
	public WebElement Support;
	@FindBy(xpath ="//div[@id='menu']/ul/li[5]")
	public WebElement Warranty;
	@FindBy(xpath ="//div[@id='menu']/ul/li[6]")
	public WebElement Registration;
	@FindBy(xpath ="//div[@id='header_TA575B027005_Col01']/div/div/a")
	public WebElement FindDealer;
	
	
	@FindBys( {
			@FindBy(xpath ="//div[@id='menu']/ul/li[1]"),
			@FindBy(className = "sub-menu-left"),
			@FindBy(tagName = "li")
			} )
	public List<WebElement> AboutImgLinks;
	
	@FindBys( {
			@FindBy(xpath ="//div[@id='menu']/ul/li[1]"),
			@FindBy(className = "sub-menu-right"),
			@FindBy(tagName = "li")
			} )
	public List<WebElement> AboutLinks;
	
	@FindBys( {
			@FindBy(xpath ="//div[@id='menu']/ul/li[2]"),
			@FindBy(className = "sub-menu-left"),
			@FindBy(tagName = "li")
			} )
	public List<WebElement> ProductImgLinks;

	@FindBys( {
			@FindBy(xpath ="//div[@id='menu']/ul/li[2]"),
			@FindBy(className = "sub-menu-right"),
			@FindBy(tagName = "li")
		} )
	public List<WebElement> ProductLinks;
	
	@FindBys( {
			@FindBy(xpath ="//div[@id='menu']/ul/li[3]"),
			@FindBy(className = "sub-menu-left"),
			@FindBy(tagName = "li")
			} )
	public List<WebElement> ResourceImgLinks;

	@FindBys( {
			@FindBy(xpath ="//div[@id='menu']/ul/li[3]"),
			@FindBy(className = "sub-menu-right"),
			@FindBy(tagName = "li")
		} )
	public List<WebElement> ResourceLinks;
	
	@FindBys( {
			@FindBy(xpath ="//div[@id='menu']/ul/li[4]"),
			@FindBy(className = "sub-menu-left"),
			@FindBy(tagName = "li")
			} )
	public List<WebElement> SupportImgLinks;

	@FindBys( {
			@FindBy(xpath ="//div[@id='menu']/ul/li[4]"),
			@FindBy(className = "sub-menu-right"),
			@FindBy(tagName = "li")
		} )
	public List<WebElement> SupportLinks;
	
	public HeaderPF(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAboutImages(int index){
		AboutImgLinks.get(index).click();
	}
	
	public void clickAbout(){
		About.click();
	}
	
	public void clickAboutLinks(int index){
		System.out.println("content"+ AboutLinks.size());
		System.out.println(AboutLinks.get(0).getText());
		AboutLinks.get(index).click();
		System.out.println(AboutLinks.get(1).getTagName());
	}
	
	public void clickProducts(){
		Product.click();
	}
	
	public void clickProductImages(int index){
		ProductImgLinks.get(index).click();
	}
			
	public void clickProductLinks(int index){
		AboutLinks.get(index).click();
	}
	
	public void clickResource(){
		Resource.click();
	}
	
	public void clickResourceImages(int index){
		ResourceImgLinks.get(index).click();
	}
			
	public void clickResourceLinks(int index){
		ResourceLinks.get(index).click();
	}
	
	public void clickSupport(){
		Support.click();
	}
	
	public void clickSupportImages(int index){
		SupportImgLinks.get(index).click();
	}
			
	public void clickSupportLinks(int index){
		SupportLinks.get(index).click();
	}
	
	public void clickWarranty(){
		Warranty.click();
	}
	
	public void clickRegistration(){
		Registration.click();
	}
	
	public void clickFindDealer(){
		FindDealer.click();
	}
	
	
}
