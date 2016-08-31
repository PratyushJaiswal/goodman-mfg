package pageObjectFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {
	WebDriver driver;
	public ProductDetails(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='unstickyheader']/div[2]/div[2]/div[1]/h1")
	public WebElement header;
	
	@FindBy(xpath="//div[@id='unstickyheader']/div[2]/div[2]/div[2]/p")
	public WebElement summary;
	
	@FindBy(xpath="//div[@id='unstickyheader']/div[2]/div[2]/div[4]/a[1]")
	public WebElement brochure;
	
	@FindBy(xpath="//div[@id='unstickyheader']/div[2]/div[2]/div[4]/a[2]")
	public WebElement specs;
	
	@FindBy(xpath="//div[@class='product-details']/div[2]//div//a")
	public List<WebElement> StickyHeader;
	
	@FindBy(xpath="//div[@id='product-features']/h3/a")
	public WebElement ProdFeatHeader;
	
	@FindBy(xpath="//div[@id='limited-warranty']/div/h3/a")
	public WebElement WarrantyHeader;
	
	@FindBy(xpath="//div[@id='accordion-3']/div[3]/div")
	public List<WebElement> buttons;
	
	@FindBy(xpath="//div[@id='BVRRContainer']/div/div/div/div/ol/li[1]/div/div[1]/div/div[1]")
	public WebElement Review1;
	
	@FindBy(xpath="//div[@id='BVRRContainer']/div/div/div/div/ol/li[2]/div/div[1]/div/div[1]")
	public WebElement Review2;
	
	@FindBy(xpath="//div[@id='ctl00_content_C026_ctl00']/ul/li")
	public List<WebElement> share;
	
	@FindBy(id="To")
	public WebElement EmailTo;
	
	@FindBy(id="From")
	public WebElement EmailFrom;
	
	@FindBy(id="Subject")
	public WebElement Subject;
	
	@FindBy(id="Message")
	public WebElement Message;
	
	@FindBy(id="Submit")
	public WebElement Submit;
	
	@FindBy(xpath="html/body/div[4]/div/div[1]/span/span")
	public WebElement closeEmail;
	
	public void getHeader(){
		header.getText();
	}
	
	public void getSummary(){
		summary.getText();
	}
	
	public void clickBrochur(){
		brochure.click();
	}
	
	public void clickSpecs(){
		specs.click();
	}
	
	public void clickStickyHeader(int index){
		StickyHeader.get(index).click();
	}
	
	public void getProductFeature(){
		ProdFeatHeader.getText();
	}
	
	public void getWarrantyHeader(){
		WarrantyHeader.getText();
	}
	
	public void clickAcordionButtons(int index){
		buttons.get(index).click();
	}
	
	public void getReview1(){
		Review1.getText();
	}
	
	public void getReview2(){
		Review2.getText();
	}
	
	public void clickShare(int index){
		share.get(index).click();
	}
	
	public void enterEmailTo(String text){
		EmailTo.sendKeys(text);
	}
	
	public void enterEmailFrom(String text){
		EmailFrom.sendKeys(text);
	}
	
	public void enterSubject(String text){
		Subject.sendKeys(text);
	}
	
	public void enterMessage(String text){
		Message.sendKeys(text);
	}
	
	public void clickSubmit(){
		Submit.click();
	}
	
	public void clickCloseEmailBox(){
		closeEmail.click();
	}

}
