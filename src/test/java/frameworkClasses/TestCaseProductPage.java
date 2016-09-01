package frameworkClasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
		
		header.clickProducts();
	  }
	@Test(priority=1)
	public void productsCategoryCount(){
		
		int count = product.ResProd.size();
		System.out.println("Total number of categories are: " +count);
		Assert.assertEquals(count,9);
	}
	
	@Test(priority=2)
	public void clickBanner1(){
		product.clickNav1();
		product.clickLearnMore1();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.navigate().back();
	}
	
	@Test(priority=2)
	public void clickBanner2(){
		product.clickNav2();
		product.clickLearnMore2();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.navigate().back();
	}
	
	@Test(priority=2)
	public void clickBanner3(){
		product.clickNav3();
		product.clickLearnMore3();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.navigate().back();
	}
	
	@Test
	public void FeaturedProductCount(){
		int count=product.FP.size();
		System.out.println("Featured Product count is: " +count);
		Assert.assertEquals(count, 4);
		System.out.println(product.FP.get(0).getText());
	}

	
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}
}
