package pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//div[@class='gm-home-banner-left']//a[@href='/about']")
	public WebElement Banner1;
		public void clickBanner1(){
		Banner1.click();
		}
	
	@FindBy(xpath = "//div[@class='gm-home-banner-left']//a[@href='/resources/consumer-finance']")
	public WebElement Banner2;
		public void clickBanner2(){
		Banner2.click();
		}
	
	@FindBy(xpath = "//div[@class='gm-home-banner-left']//a[@href='/resources/customer-reviews']")
	public WebElement Banner3;
		public void clickBanner3(){
		Banner3.click();
		}
	
	@FindBy(xpath = "//div[@class='gm-home-banner-left']//a[@href='/about/plant-locations']")
	public WebElement Banner4;
		public void clickBanner4(){
		Banner4.click();
		}
	
	@FindBy(xpath = "//div[@id='banner-fade']/ol/li[1]/a")
	public WebElement NavBanner1;
		public void clickNavban1(){
		NavBanner1.click();
		}
	
	@FindBy(xpath = "//div[@id='banner-fade']/ol/li[2]/a")
	public WebElement NavBanner2;
		public void clickNavban2(){
		NavBanner2.click();
		}
	
	@FindBy(xpath = "//div[@id='banner-fade']/ol/li[3]/a")
	public WebElement NavBanner3;
		public void clickNavban3(){
		NavBanner3.click();
		}
	
	@FindBy(xpath = "//div[@id='banner-fade']/ol/li[4]/a")
	public WebElement NavBanner4;
		public void clickNavban4(){
		NavBanner4.click();
		}
	
	@FindBy(xpath = "//input[@id='txtfdsearch'][@type='text']")
	public WebElement Zip;
		public void enterZipcode(String zip){
		Zip.sendKeys(zip);
		}
	
	@FindBy(xpath = "//input[@id='txtfdmiles'][@type='number']")
	public WebElement Miles;
		public void enterMiles(String miles){
		Miles.sendKeys(miles);
		}
	
	@FindBy(xpath = "//input[@id='btngmfdsearch'][@type='button']")
	public WebElement FindDealerBtn;
		public void clickFindDealer(){
		FindDealerBtn.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C003_Col01']//a[@href='/resources/repair-or-replace']")
	public WebElement FindMoreBtn;
		public void clickFindMore(){
		FindMoreBtn.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C011_Col00']//a[@href='/about/energy-responsibility']")
	public WebElement BlueLearMoreBtn;
		public void clickBlueLearMore(){
		BlueLearMoreBtn.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C013_Col00']//a[@href='#']")
	public WebElement BlueArrow;
		public void clickBlueArrow(){
		BlueArrow.click();
		}
	
	@FindBy(xpath = "//input[@id='content_C020_ctl00_ctl00_searchTextBox']")
	public WebElement SearchProd;
		public void SearchProd(String text){
		SearchProd.sendKeys(text);
		}
	
	@FindBy(xpath = "//div[@id='content_C023_Col00']//a[@href='/resources/customer-reviews']")
	public WebElement ProdRev;
		public void gotoProdRev(){
		ProdRev.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C023_Col01']//a[@href='/resources/energy-calculator']")
	public WebElement EnergyCalc;
		public void gotoEnergyCalc(){
		EnergyCalc.click();
		}
	
	@FindBy(xpath = "//div[@id='owl-demo']//div[@class='owl-prev']")
	public WebElement Prev;
		public void clickPrev(){
		Prev.click();
		}
	
	@FindBy(xpath = "//div[@id='owl-demo']//div[@class='owl-next']")
	public WebElement Next;
		public void clickNext(){
		Next.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C046_Col00']//a[@href='/products']")
	public WebElement ViewAll;
		public void clickViewAll(){
		ViewAll.click();
		}
	
	@FindBy(xpath = "//div[@id='owl-demo']//a[@href='/products/air-conditioners']")
	public WebElement AC;
		public void clickAC(){
		AC.click();
		}
	
	@FindBy(xpath = "//div[@class='owl-item']//a[@href='/products/gas-furnaces/80-afue-gas-furnaces']")
	public WebElement GF;
		public void clickGF(){
		GF.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C025_Col00']//a[@href='/resources/customer-reviews']")
	public WebElement ProdRev2;
		public void gotoProdRev2(){
		ProdRev2.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C036_Col00']//a[@href='/about/energy-responsibility']")
	public WebElement GreenLearMoreBtn;
		public void clickGreenLearnMore(){
		GreenLearMoreBtn.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C043_Col01']//a[@href='http://www.dsireusa.org/']")
	public WebElement RI;
		public void clickRebateInc(){
		RI.click();
		}
	
	@FindBy(xpath = "//div[@id='content_C043_Col01']//a[@href='/product-registration']")
	public WebElement ProdReg;
		public void clickProdReg(){
		ProdReg.click();
		}

}
