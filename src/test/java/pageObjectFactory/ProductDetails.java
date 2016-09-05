package pageObjectFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDetails {
	WebDriver driver;
	public ProductDetails(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='unstickyheader']/div[2]/div[2]/div[1]/h1")
	public WebElement header;
	
	@FindBy(xpath="//div[@id='unstickyheader']/div[2]/div[2]/div[2]")
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
	
	@FindBy(xpath="//input[@id='submit']")
	public WebElement Submit;
	
	@FindBy(xpath="html/body/div[5]/div/span")
	public WebElement Ok;
	
	@FindBy(xpath="html/body/div[4]/div/div[1]/span/span")
	public WebElement closeEmail;
	
	public String getHeader(){
		return header.getText();
	}
	
	public String getSummary(){
		return summary.getText();
	}
	
	public void clickBrochure(){
		brochure.click();
	}
	
	public void clickSpecs(){
		specs.click();
	}
	
	public void clickOK(){
		Ok.click();
	}
	
	public void clickStickyHeader(int index){
		StickyHeader.get(index).click();
		if (index==0){
			Assert.assertEquals(getProductFeature(), "Product Features");
			System.out.println("Product Feature is: "+getProductFeature());
		}else if(index==1){
			Assert.assertEquals(getWarrantyHeader(), "Outstanding Limited Warranty Protection");
			System.out.println("Warranty Header is: "+getWarrantyHeader());
		}else if(index==2){
			String rev1=getReview1();
			System.out.println("Review 1 is: "+rev1);
			Assert.assertEquals(getReview1(), rev1);
			String rev2=getReview2();
			System.out.println("Review 2 is: "+rev2);
			Assert.assertEquals(getReview2(), rev2);
		}else if(index==3){
			System.out.println("Sharing icon count is: "+share.size());
		}/*else if(index==4){
			clickStickyHeader(4);
			//clickCloseEmailBox();
		}*/else if(index==5){
			String windowHandle = driver.getWindowHandle();
			ArrayList tabs = new ArrayList (driver.getWindowHandles());
			
			driver.switchTo().window((String) tabs.get(1));
			driver.close();
			
			driver.switchTo().window(windowHandle);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else if(index>=6){
			System.out.println("Index is greater than the number of elements present");
		}
	}
	
	public String getProductFeature(){
		return ProdFeatHeader.getText();
	}
	
	public String getWarrantyHeader(){
		return WarrantyHeader.getText();
	}
	
	public void clickAcordionButtons(int index){
		buttons.get(index).click();
	}
	
	public String getReview1(){
		return Review1.getText();
	}
	
	public String getReview2(){
		return Review2.getText();
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
