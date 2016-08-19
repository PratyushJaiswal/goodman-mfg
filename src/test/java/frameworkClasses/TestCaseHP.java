package frameworkClasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public WebDriverWait wait;
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
		//driver.get(Constants.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure(Constants.log_Path);
		driver.get(Constants.URL);
		
		
		Hp = new HomePage(driver);
		
	  }
	
	@Test(priority = 1)
	public void testPageTitle(){
		Assert.assertEquals(driver.getTitle(), "Goodman Air Conditioning And Heating Systems");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test (priority = 2)
	public void clickOnBanner1(){
		Hp.clickNavban1();
		Hp.clickBanner1();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Reliable Heating & Cooling Systems From Goodman Brand");
		driver.navigate().back();
	}
	
	@Test (priority = 3)
	public void clickOnBanner2(){
		Hp.clickNavban2();
		Hp.clickBanner2();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Monthly Payments For Your Home Comfort System | Goodman");
		driver.navigate().back();
	}
	
	@Test (priority = 4)
	public void clickOnBanner3(){
		Hp.clickNavban3();
		Hp.clickBanner3();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Read Customer Reviews And Ratings For Goodman Products");
		driver.navigate().back();
	}
	
	@Test (priority = 5)
	public void clickOnBanner4(){
		Hp.clickNavban4();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp.clickBanner4();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Goodman Manufacturing Plant Locations");
		driver.navigate().back();
	}
	
	@Test (priority=6)
	public void findDealer(){
		Hp.enterZipcode("77479");
		Hp.enterMiles("20");
		Hp.clickFindDealer();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Find A Dealer For Goodman Manufacturing Products");
		driver.navigate().back();
	}
	
	@Test (priority=7)
	public void FindMore(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp.clickFindMore();
		
		Assert.assertEquals(driver.getTitle(), "When To Repair or Replace Your HVAC System | Goodman");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@Test(priority=8)
	public void BlueLearnMore() {
		
		Hp.clickBlueLearnMore();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Buy Environment-friendly HVAC Systems From Goodman");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@Test(priority=9)
	public void BlueArrow(){
		Hp.clickBlueArrow();
		Assert.assertEquals(driver.getTitle(), "Goodman Air Conditioning And Heating Systems");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@Test(priority=10)
	public void clickSearch() throws InterruptedException{
		Hp.selectAutoSearch("air", 1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Search Result");
		Thread.sleep(3000);
		driver.navigate().back();
		}
	
	@Test(priority=11)
	public void gotoProdRev(){
		Hp.gotoProdRev();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Read Customer Reviews And Ratings For Goodman Products");
		driver.navigate().back();
		}
	
	@Test(priority=12)
	public void gotoEnergyCalc(){
		Hp.gotoEnergyCalc();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Save Money With The Energy Calculator From Goodman");
		driver.navigate().back();
		}
	
	@Test(priority=13)
	public void Previous(){
		Hp.clickPrev();
		//Assert.assertEquals(Hp.getElement(), "Ductless Systems");
	}
	
	@Test(priority=14)
	public void Next(){
		Hp.clickNext();
		//Assert.assertEquals(Hp.getName(), "Air Handlers");
		
	}
	
	@Test(priority=15)
	public void clickAC(){
		Hp.clickAC();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Air Conditioners by Goodman Air Conditioning & Heating");
		driver.navigate().back();
	}
	
	@Test(priority=16)
	public void viewAll(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp.clickViewAll();
		
		Assert.assertEquals(driver.getTitle(), "Check Out Goodman Manufacturing's Product Range");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=17)
	public void gotoGF(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp.clickGF();
		Assert.assertEquals(driver.getTitle(), "Shop for 80% AFUEs from Goodman AC & Heating");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=18)
	public void clickProdRev2() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp.gotoProdRev2();
		
		Assert.assertEquals(driver.getTitle(), "Read Customer Reviews And Ratings For Goodman Products");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=19)
	public void gotoGreenLearnMore(){
		Hp.clickGreenLearnMore();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Buy Environment-friendly HVAC Systems From Goodman");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=21)
	public void gotoRI(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp.clickRebateInc();
		
		Assert.assertEquals(driver.getTitle(), "Database of State Incentives for Renewables & Efficiency - DSIRE");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=20)
	public void gotoProdReg(){
		Hp.clickProdReg();
		Assert.assertEquals(driver.getTitle(), "Register Your Goodman Product On The Website Today");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	
	@AfterClass
	  public void afterClass() {
			driver.close();
	  }

}
