package pageObjectFactory;

import java.util.List;

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
	
	@FindBy(xpath="//div[@id='content_C005_Col00']/div[2]")
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
	public WebElement ProdRevAC;
	
	@FindBy(xpath="//div[@id='content_C006_Col00']/div/div[3]/div/div[2]/a")
	public WebElement EnergyCalAC;
	
	@FindBy(xpath="//div[@id='content_C006_Col00']/div/div[2]")
	public WebElement BreadcrumbAC;
	
	@FindBy(id="id=txtproductsearch")
	public WebElement searchAC;
	
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
	
	

}
