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

import pageObjectFactory.Footer;
import utilities.Constants;

public class TestCaseFooter {
	static Logger log = Logger.getLogger(frameworkClass.class);
	private WebDriver driver;
	Footer footer;
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
		footer = new Footer(driver);
	}
	
	@Test(priority=1)
	public void Contact(){
		footer.clickContact();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Contact Us Online At Goodman By Filling This Form");
	}
	
	@Test(priority=2)
	public void Policy(){
		footer.clickPrivPolicy();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Privacy Policy Regarding Use Of Goodman Website");
	}
	
	@Test(priority=3)
	public void Governacnce(){
		footer.clickFooterCorpGov();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Read About Corporate Governance | Goodman Manufacturing");
	}
	
	@Test(priority=4)
	public void Resources(){
		footer.clickFooterResource();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Resources | Goodman Manufacturing");
	}
	
	@Test(priority=5)
	public void Partner(){
		footer.clickPartner();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Get the current window handle
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		
		//Use the list of window handles to switch between windows
		driver.switchTo().window((String) tabs.get(1));
		Assert.assertEquals(driver.getTitle(), "Welcome to Goodman Manufacturing");
		driver.close();
		//Switch back to original window
		driver.switchTo().window(windowHandle);
		//driver.navigate().to(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=6)
	public void BecomeDealer(){
		footer.clickBecomeDealer();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Get the current window handle
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		
		//Use the list of window handles to switch between windows
		driver.switchTo().window((String) tabs.get(1));
		Assert.assertEquals(driver.getTitle(), "Welcome to Goodman Manufacturing");
		driver.close();
		//Switch back to original window
		driver.switchTo().window(windowHandle);
		//driver.navigate().to(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=7)
	public void CommercialProdcuts(){
		footer.clickComProd();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Get the current window handle
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		
		//Use the list of window handles to switch between windows
		driver.switchTo().window((String) tabs.get(1));
		Assert.assertEquals(driver.getTitle(), "Commercial HVAC Systems | Daikin Comfort");
		driver.close();
		//Switch back to original window
		driver.switchTo().window(windowHandle);
		//driver.navigate().to(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=8)
	public void Employment(){
		footer.clickEmployment();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Get the current window handle
				String windowHandle = driver.getWindowHandle();

				//Get the list of window handles
				ArrayList tabs = new ArrayList (driver.getWindowHandles());
				
				//Use the list of window handles to switch between windows
				driver.switchTo().window((String) tabs.get(1));
				Assert.assertEquals(driver.getTitle(), "Careers at Goodman Manufacturing | Join a leader in air conditioning and heating equipment! | Home");
				driver.close();
				//Switch back to original window
				driver.switchTo().window(windowHandle);
				//driver.navigate().to(Constants.URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@Test(priority=9)
	public void ProductRecall() throws InterruptedException{
		footer.clickProdRecall();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Get the current window handle
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		
		//Use the list of window handles to switch between windows
		driver.switchTo().window((String) tabs.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.regcen.com/cordrecalls/", "Raees is happy macha ");
		Thread.sleep(2000);
		driver.close();
		//Switch back to original window
		driver.switchTo().window(windowHandle);
		//driver.navigate().to(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void close(){
		driver.close();
	}
	

}
