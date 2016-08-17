package frameworkClasses;

import java.util.ArrayList;
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

public class TestCaseHeader {
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Reliable Heating & Cooling Systems From Goodman Brand");
		header.clickAboutImages(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Buy Environment-friendly HVAC Systems From Goodman");
		driver.navigate().to(Constants.URL);
	}
	
	@Test(priority=2)
	public void clickRLinks(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		header.clickAbout();
		Assert.assertEquals(driver.getTitle(), "Reliable Heating & Cooling Systems From Goodman Brand");
		header.clickAboutLinks(4);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String windowHandle = driver.getWindowHandle();
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));
		Assert.assertEquals(driver.getTitle(), "Daikin Global | A leading air conditioning and refrigeration innovator and provider for residential, commercial and industrial applications");
		driver.close();
		
		driver.switchTo().window(windowHandle);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Reliable Heating & Cooling Systems From Goodman Brand");
	}
	
	@Test(priority=3)
	public void ProdImages(){
		header.clickProducts();
		header.clickProductImages(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Heat Pumps by Goodman Air Conditioning & Heating");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=4)
	public void ProdLinks(){
		header.clickProducts();
		header.clickProductLinks(1);
		System.out.println(header.ProductLinks.get(1).getText());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Find the Perfect Goodman Brand Controls and Thermostats");
		
	}
	
	@Test(priority=5)
	public void ResourceImages(){
		header.clickResource();
		header.clickResourceImages(0);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Learn More About Heating And Cooling Systems | Goodman");
		
	}
	
	@Test(priority=6)
	public void ResourceLinks(){
		header.clickResource();
		header.clickResourceLinks(3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Find A Dealer For Goodman Manufacturing Products");
		
	}
	
	@Test(priority=7)
	public void SupportImages(){
		header.clickSupport();
		header.clickSupportImages(0);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Get The Best Limited Warranty On HVAC Systems | Goodman");
		/*driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	}
	
	@Test(priority=8)
	public void SupportLinks(){
		header.clickSupport();
		header.clickSupportLinks(2);
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
