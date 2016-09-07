package frameworkClasses;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.steadystate.css.dom.Property;

import pageObjectFactory.HeaderPF;
import pageObjectFactory.ProductDetails;
import pageObjectFactory.Products;
import utilities.Constants;

public class TestCaseProductDetails {
	static Logger log = Logger.getLogger(TestCaseProductDetails.class);
	private WebDriver driver;
	ProductDetails pd;
	Products products;
	HeaderPF header;
	
	
	@Parameters("browserType")
	@BeforeClass
	public void beforeClass(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", Constants.Chrome_driver );
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure(Constants.log_Path);
		//driver.get(Constants.URL);
		pd = new ProductDetails(driver);
		products = new Products(driver);
		header = new HeaderPF(driver);
	}
	
	@BeforeMethod
	public void gotoProducts(){
		header.clickProducts();
	}
	
	@Test(priority=1)
	public void CatProdDetails() throws InterruptedException{
		products.clickResidentialProd(1);
		products.clickLearnMoreProd(3);
		System.out.println("Product title is:"+pd.getHeader());
		System.out.println("Product Summary is: "+pd.getSummary());
		pd.clickBrochure();
		Thread.sleep(5000);
		String windowHandle = driver.getWindowHandle();

		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		
		driver.switchTo().window((String) tabs.get(1));
		//driver.close();
		
		driver.switchTo().window(windowHandle);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pd.clickSpecs();
		Thread.sleep(5000);
		driver.switchTo().window((String) tabs.get(1));
		driver.close();
		driver.switchTo().window(windowHandle);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=2)
	public void stickyHeader() throws InterruptedException{
		products.clickResidentialProd(1);
		products.clickLearnMoreProd(3);
		pd.clickStickyHeader(6);
		/*Assert.assertEquals(pd.getProductFeature(), "Product Features");
		System.out.println("Product Feature is: "+pd.getProductFeature());
		Thread.sleep(3000);
		pd.clickStickyHeader(1);
		Assert.assertEquals(pd.getWarrantyHeader(), "Outstanding Limited Warranty Protection");
		System.out.println("Warranty Header is: "+pd.getWarrantyHeader());
		pd.clickStickyHeader(2);
		String rev1=pd.getReview1();
		System.out.println("Review 1 is: "+rev1);
		Assert.assertEquals(pd.getReview1(), rev1);
		String rev2=pd.getReview2();
		System.out.println("Review 2 is: "+rev2);
		Assert.assertEquals(pd.getReview2(), rev2);
		pd.clickStickyHeader(4);
		pd.clickCloseEmailBox();
		pd.clickStickyHeader(5);
		
		String windowHandle = driver.getWindowHandle();
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		
		driver.switchTo().window((String) tabs.get(1));
		driver.close();
		
		driver.switchTo().window(windowHandle);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		
	}
	
	@Test(priority=3)
	public void ProductShare() throws InterruptedException{
		products.clickResidentialProd(1);
		products.clickLearnMoreProd(3);
		
		pd.clickStickyHeader(3);
		Thread.sleep(5000);
		pd.clickShare(0);
		
		String windowHandle = driver.getWindowHandle();

		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		
		driver.switchTo().window((String) tabs.get(1));
		Thread.sleep(5000);
		driver.close();
		
		driver.switchTo().window(windowHandle);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void navigatetoProductsDetails(){
		products.clickResidentialProd(1);
		products.clickLearnMoreProd(3);
	}
	
	@Test(dataProvider="Authentication", priority=4, dependsOnMethods="navigatetoProductsDetails")
	public void ProductEmail(String From, String To, String Subject, String Message) throws InterruptedException{
		//products.clickResidentialProd(1);
		//products.clickLearnMoreProd(3);
		pd.clickStickyHeader(4);
		Thread.sleep(5000);
		
		pd.enterEmailTo(To);
		pd.enterEmailFrom(From);
		pd.enterSubject(Subject);
		pd.enterMessage(Message);
		pd.clickSubmit();
		pd.clickOK();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	@DataProvider
	  
	   public Object[][] Authentication() throws Exception{
	  
	      // Setting up the Test Data Excel file
		
			Object[][] testObjArray = utilities.ExcelUtils.getTableArray(Constants.File_Path,"ProductEmail");
			
			
			return (testObjArray);
	       
	   }
	
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}
	
	
	
}
