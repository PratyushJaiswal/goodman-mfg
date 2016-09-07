package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {
	WebDriver driver;
	public Footer(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@id='footer_TA575B027026_Col00']/div/ul/li[1]/a")
	public WebElement FooterContact;
		public void clickContact(){
		FooterContact.click();
		}
	
	@FindBy(xpath = "//div[@id='footer_TA575B027026_Col00']/div/ul/li[2]/a")
	public WebElement PrivPolicy;
		public void clickPrivPolicy(){
		PrivPolicy.click();
		}
	
	@FindBy(xpath = "//div[@id='footer_TA575B027026_Col00']/div/ul/li[3]/a")
	public WebElement FooterCorpGov;
		public void clickFooterCorpGov(){
		FooterCorpGov.click();
		}
	
	@FindBy(xpath = "//div[@id='footer_TA575B027026_Col00']/div/ul/li[4]/a")
	public WebElement FooterResource;
		public void clickFooterResource(){
		FooterResource.click();
		}
	
	@FindBy(xpath = "//div[@id='footer_TA575B027026_Col00']/div/ul/li[5]/a")
	public WebElement Partner;
		public void clickPartner(){
		Partner.click();
	}
	
	@FindBy(xpath = "//div[@id='footer_TA575B027026_Col00']/div/ul/li[6]/a")
	public WebElement BecomeDealer;
		public void clickBecomeDealer(){
		BecomeDealer.click();
	}
	
	@FindBy(xpath = "//div[@id='footer_TA575B027026_Col00']/div/ul/li[7]/a")
	public WebElement ComProd;
		public void clickComProd(){
		ComProd.click();
	}
	
	@FindBy(xpath = "//div[@id='footer_TA575B027026_Col00']/div/ul/li[8]/a")
	public WebElement Employment;
		public void clickEmployment(){
		Employment.click();
	}
	
	@FindBy(xpath = "//div[@id='footer_TA575B027011_Col02'][@class='sf_colsIn sf_3cols_3in_25']")
	public WebElement ProdRecall;
		public void clickProdRecall(){
		ProdRecall.click();
	}
}
