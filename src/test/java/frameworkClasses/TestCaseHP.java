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

import pageObjectFactory.HomePage;
import utilities.Constants;

public class TestCaseHP {
	
	static Logger Log = Logger.getLogger(TestCaseHP.class);
	private WebDriver driver;
	HomePage Hp;
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
		
		
		Hp = new HomePage(driver);
		
	  }
	
	@Test
	public void testPageTitle(){
		Assert.assertEquals(driver.getTitle(), "Goodman Air Conditioning And Heating Systems");
	}
	
	@Test
	public void clickOnBanner1(){
		Hp.clickNavban1();
		Hp.clickBanner1();
		Assert.assertEquals(driver.getTitle(), "Reliable Heating & Cooling Systems From Goodman Brand");
		driver.navigate().back();
	}
	
	@Test
	public void clickOnBanner2(){
		Hp.clickNavban2();
		Hp.clickBanner2();
		Assert.assertEquals(driver.getTitle(), "Monthly Payments For Your Home Comfort System | Goodman");
		driver.navigate().back();
	}
	
	@Test
	public void clickOnBanner3(){
		Hp.clickNavban3();
		Hp.clickBanner3();
		Assert.assertEquals(driver.getTitle(), "Read Customer Reviews And Ratings For Goodman Products");
		driver.navigate().back();
	}
	
	@Test
	public void clickOnBanner4(){
		Hp.clickNavban4();
		Hp.clickBanner4();
		Assert.assertEquals(driver.getTitle(), "Goodman Manufacturing Plant Locations");
		driver.navigate().back();
	}
	
	@Test
	public void findDealer(){
		Hp.enterZipcode("77568");
		Hp.enterMiles("20");
		Hp.clickFindDealer();
		driver.navigate().back();
	}
	
	
	
	@AfterClass
	  public void afterClass() {
			driver.close();
	  }

}
