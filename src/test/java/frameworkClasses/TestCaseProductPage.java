package frameworkClasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pageObjectFactory.HeaderPF;
import pageObjectFactory.Products;
import utilities.Constants;

public class TestCaseProductPage {
	static Logger log = Logger.getLogger(TestCaseProductPage.class);
	private WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	Products product;
	HeaderPF header;
	
	@Parameters("browserType")
	
	@BeforeClass
	  public void beforeClass(String browser) {
		
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",Constants.Chrome_driver );
			driver = new ChromeDriver();
		}
		driver.get(Constants.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure(Constants.log_Path);
		driver.get(Constants.URL);
		product = new Products(driver);
		header = new HeaderPF(driver);
		//header.clickProducts();
		
	  }
	@BeforeMethod
	public void gotoProducts(){
		header.clickProducts();
	}
	@Test(priority=1)
	public void CategoryCount(){
		
		int count = product.ResProd.size();
		System.out.println("Total number of categories are: " +count);
		Assert.assertEquals(count,9);
		for(int i=0;i<count;i++){
			System.out.println(product.TitleResProd.get(count).getText());
		}
	}
	
	@Test (priority=2)
	public void CatProductCount(){
		product.clickResidentialProd(1);
		int count=product.ProductCount.size();
		System.out.println("Product count is: "+count);
		String header=product.getHeader();
		Assert.assertEquals(header, "Heat Pumps");
		System.out.println("Header of the category is: " +header);
		System.out.println("Breadcrumbs are: "+ product.getBreadcrumbs());
		product.selectSearch("Air", 1);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		product.selectCategoryList(7);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();
				
	}
	
	@Test(priority=3)
	public void subCatCount(){
		product.clickResidentialProd(3);
		Assert.assertEquals(product.getHeader(), "Packaged Units");
		
		//Assert.assertEquals(product.getBreadcrumbs(), "Home/Products/Packaged Units");
		int count=product.ProductCount.size();
		System.out.println("Sub Category count is: " +count);
		for(int i=0;i<count;i++)
		{
		 String subcat=product.getSubCatTitle(i);
		 System.out.println("Title of the Sub Categories are: "+subcat);
		}
		product.selectSearch("Air", 1);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		product.selectCategoryList(7);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();
		/*product.clickSubCategory(2);
		Assert.assertEquals(product.getHeader(), "Gas Electric");
		
		//Assert.assertEquals(product.getBreadcrumbs(), "Home/Products/Packaged Units/Gas Electric");
		int prodcount=product.ProductCount.size();
		System.out.println("Sub Category count is: " +prodcount);
		for(int i=0;i<prodcount;i++)
		{
		System.out.println("Title of the Products are: "+product.getSubCatTitle(i));
		}
		product.clickLearnMoreProd(1);
		Assert.assertEquals(product.getProdTitle(), "GPG14M");
		System.out.println("Breadcrum is: "+product.getProdBreadcrumb());
		//Assert.assertEquals(product.getProdBreadcrumb(), "Home/Products/Packaged Units/Gas Electric/GPG14M");
*/		
			
	}
	
	@Test(priority=4)
	public void subCatProdCount(){
		product.clickResidentialProd(3);
		product.clickSubCategory(2);
		Assert.assertEquals(product.getHeader(), "Gas Electric");
		
		//Assert.assertEquals(product.getBreadcrumbs(), "Home/Products/Packaged Units/Gas Electric");
		int prodcount=product.ProductCount.size();
		System.out.println("Product count is: " +prodcount);
		for(int i=0;i<prodcount;i++)
		{
		System.out.println("Title of the Product "+i+" is: "+product.getSubCatTitle(i));
		}
		
		product.selectSearch("Air", 1);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		product.selectCategoryList(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();
		
		/*product.clickLearnMoreProd(1);
		Assert.assertEquals(product.getProdTitle(), "GPG14M");
		System.out.println("Breadcrum is: "+product.getProdBreadcrumb());
		//Assert.assertEquals(product.getProdBreadcrumb(), "Home/Products/Packaged Units/Gas Electric/GPG14M");
*/	}
	
	@Test(priority=5)
	public void clickBanner1(){
		product.clickNav1();
		product.clickLearnMore1();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		//driver.navigate().back();
	}
	
	@Test(priority=6)
	public void clickBanner2(){
		product.clickNav2();
		product.clickLearnMore2();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		//driver.navigate().back();
	}
	
	@Test(priority=7)
	public void clickBanner3(){
		product.clickNav3();
		product.clickLearnMore3();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		//driver.navigate().back();
	}
	
	@Test(priority=8)
	public void FeaturedProductCount(){
		int count=product.FP.size();
		System.out.println("Featured Product count is: " +count);
		Assert.assertEquals(count, 4);
		//System.out.println("Product title is: " +product.TitleFP.get(0).getText());
		for(int i=0 ; i<count;i++){
			System.out.println(product.TitleFP.get(i).getText());
		}
	}
	
	
	
	
	
	@Test(priority=9)
	public void gotoProdRev(){
		product.clickProdRev();
		Assert.assertEquals(driver.getTitle(), "Read Customer Reviews And Ratings For Goodman Products");
		//driver.navigate().back();
		
	}
	
	@Test(priority=10)
	public void gotoEnergyCal(){
		product.clickEnergyCalculator();
		Assert.assertEquals(driver.getTitle(), "Save Money With The Energy Calculator From Goodman");
		//driver.navigate().back();
	}
	
	@Test(priority=11)
	public void gotoCategory() throws InterruptedException{
		product.clickResidentialProd(1);
		Assert.assertEquals(driver.getTitle(), "Heat Pumps by Goodman Air Conditioning & Heating");
		Assert.assertEquals(product.getHeader(), "Heat Pumps");
		int count = product.ProductCount.size();
		System.out.println("product count is: "+count);
		for(int i=0; i<count;i++)
		{
			System.out.println("Product title "+i+" is:" +product.getSubCatTitle(i));
		}
		product.selectSearch("Air", 1);
		
		Thread.sleep(6000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.navigate().back();
		product.clickCategoryIcon();
		product.selectCategoryList(3);
		driver.navigate().back();
		product.clickLearnMoreProd(1);
		driver.navigate().back();
		
	}

	
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}
}
