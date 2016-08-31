package pageObjectFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
	WebDriver driver;
	public Products(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='pbanner-fade']/ol/li[1]/a")
	public WebElement nav1;
	
	@FindBy(xpath="//div[@id='pbanner-fade']/ol/li[2]/a")
	public WebElement nav2;
	
	@FindBy(xpath="//div[@id='pbanner-fade']/ol/li[3]/a")
	public WebElement nav3;
	
	@FindBy(xpath="//div[@id='pbanner-fade']/div/ul/li[2]/div/div[2]/a")
	public WebElement LearnMore1;
	
	@FindBy(xpath="//div[@id='pbanner-fade']/div/ul/li[3]/div/div[2]/a")
	public WebElement LearnMore2;
	
	@FindBy(xpath="//div[@id='pbanner-fade']/div/ul/li[4]/div/div[2]/a")
	public WebElement LearnMore3;
	
	@FindBy(xpath="//div[@id='content_C013_Col00']/div/a")
	public WebElement ProdRev;
	
	@FindBy(xpath="//div[@id='content_C013_Col01']/div/a")
	public WebElement EnergyCal;
	
	@FindBy(xpath="//div[@id='content_C005_Col00']/div[2]/div/div/div/div")
	public List<WebElement> ResProd;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[1]/a/div/div/span")
	public WebElement AC;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[2]/a/div/div/span")
	public WebElement HP;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[3]/div/a/div/span")
	public WebElement GF;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[4]/div/a/div/span")
	public WebElement PU;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[5]/div/a/div/span")
	public WebElement AHC;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[6]/a/div/div")
	public WebElement IAQ;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[7]/div/a/div/span")
	public WebElement Controls;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[8]/a/div/div/span")
	public WebElement IntProd;
	
	@FindBy(xpath="//div[@id='content_C008_Col00']/div/div[9]/a/div/div")
	public WebElement DS;
	
	@FindBy(xpath="//div[@class='owl-wrapper-outer']//div")
	public List<WebElement> FP;
	
	@FindBy(xpath="//div[@id='content_C006_Col00']/div/div[1]/div[1]/h1")
	public WebElement Header;
	
	@FindBy(xpath="//div[@id='content_C006_Col00']/div/div[3]/div/div[1]/a")
	public WebElement CatProdRev;
	
	@FindBy(xpath="//div[@id='content_C006_Col00']/div/div[3]/div/div[2]/a")
	public WebElement CatEnergyCal;
	
	@FindBy(xpath="//div[@id='content_C006_Col00']/div/div[2]")
	public WebElement Breadcrumb;
	
	@FindBy(id="txtproductsearch")
	public WebElement search;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//li")
	public List<WebElement> searchSelect;
	
	@FindBy(xpath="//div[@id='categorymenu']/a")
	public WebElement CatIcon;
	
	@FindBy(xpath="//div[@id='categorymenu']//div//ul//li")
	public List<WebElement> CatList;
	
	@FindBy(xpath="//div[@class='gm-product-wrap']/div")
	public List<WebElement> ProductsAC;
	
	@FindBy(xpath="//div[@id='content_C006_Col00']/div/div[4]/div/a")
	public List<WebElement> LearnMore;
	
	@FindBy(xpath="//div[@class='gm-product-wrap']/div")
	public List<WebElement> SubCatPU;
	
	@FindBy(xpath="//div[@class='gm-product-wrap']/div")
	public List<WebElement> ProdDF;
	
	public void clickNav1(){
		nav1.click();
	}
	
	public void clickNav2(){
		nav2.click();
	}
	
	public void clickNav3(){
		nav3.click();
	}
	
	public void clickLearnMore1(){
		LearnMore1.click();
	}
	
	public void clickLearnMore2(){
		LearnMore2.click();
	}
	
	public void clickLearnMore3(){
		LearnMore3.click();
	}
	
	public void clickProdRev(){
		ProdRev.click();
	}
	
	public void clickEnergyCalculator(){
		EnergyCal.click();
	}
	
	public void clickResidentialProd(int index){
		ResProd.get(index).click();
	}
	
	public void clickFeaturedProd(int index){
		FP.get(index).click();
	}
	
	public void clickSubCategory(int index){
		SubCatPU.get(index).click();
	}
	
	public void clickLearnMoreProd(int index){
		LearnMore.get(index).click();
	}
	
	public void getHeader(){
		Header.getText();
	}
	
	public void getBreadcrumbs(){
		Breadcrumb.getText();
	}
	
	public void clickCategoryProdRev(){
		CatProdRev.click();
	}
	
	public void clickCategoryEnergyCal(){
		CatEnergyCal.click();
	}
	
	public void selectSearch(String text, int index){
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+search.getLocation().x+")");
		
		search.sendKeys(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(searchSelect.size()>= index){
			searchSelect.get(index).click();
		} else if (searchSelect.size()==0){
			search.sendKeys(Keys.ENTER);
		}else {
			System.out.println("index is greater than the found element");
	}
	}
	
	public void clickCategoryIcon(){
		CatIcon.click();
	}
	
	public void selectCategoryList(int index){
		CatIcon.click();
		if(CatList.size()>=index){
			CatList.get(index).click();
		}else {
			System.out.println("index value is greater than the category list");
		}
	}

}
