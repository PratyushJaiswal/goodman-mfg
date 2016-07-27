package pageObjectFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class About {
	WebDriver driver;
	@FindBy(xpath = "//div[@id='menu']/ul/li[1]")
	public WebElement about;
	
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
	
	public About(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAboutImages(int index){
		AboutImgLinks.get(index).click();
	}
	
	public void clickAbout(){
		about.click();
	}
	
	public void clickAboutLinks(int index){
		AboutLinks.get(index).click();
	}
}
