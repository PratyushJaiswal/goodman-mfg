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
import utilities.Constants;

public class TestCaseAbout {
	static Logger log = Logger.getLogger(frameworkClass.class);
	private WebDriver driver;
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
		header = new HeaderPF(driver);
	}
	
	@Test (priority=1)
	public void clickImageLinks(){
		header.clickAbout();
		header.clickAboutImages(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Buy Environment-friendly HVAC Systems From Goodman");
		driver.navigate().to(Constants.URL);
	}
	
	@Test(priority=2)
	public void clickRLinks(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		header.clickAbout();
		header.clickAboutLinks(3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Assert.assertEquals(driver.getTitle(), "Goodman Manufacturing Plant Locations");
		driver.navigate().to(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=3)
	public void ProdImages(){
		header.clickProducts();
		header.clickProductImages(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Heat Pumps by Goodman Air Conditioning & Heating");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=4)
	public void ProdLinks(){
		header.clickProducts();
		header.clickProductLinks(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Find the Perfect Goodman Brand Controls and Thermostats");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=5)
	public void ResourceImages(){
		header.clickResource();
		header.clickResourceImages(0);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Learn More About Heating And Cooling Systems | Goodman");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=6)
	public void ResourceLinks(){
		header.clickResource();
		header.clickResourceLinks(0);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "HVAC FAQs");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=7)
	public void SupportImages(){
		header.clickSupport();
		header.clickSupportImages(3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Read About the Goodman Policy On Internet Purchases");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=8)
	public void SupportLinks(){
		header.clickSupport();
		header.clickSupportLinks(3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Contact Us Online At Goodman By Filling This Form");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=9)
	public void Warranty(){
		header.clickWarranty();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Lookup The Warranty For Your Goodman HVAC System");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=10)
	public void Registration(){
		header.clickRegistration();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Register Your Goodman Product On The Website Today");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=11)
	public void DealerBtn(){
		header.clickFindDealer();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Find A Dealer For Goodman Manufacturing Products");
		//driver.navigate().back();
	}
	
	@AfterClass
	  public void afterClass() {
			driver.close();
	  }
}
