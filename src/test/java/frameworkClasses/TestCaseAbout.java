package frameworkClasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	
	@Test
	public void clickImageLinks(){
		header.clickAbout();
		header.clickAboutImages(1);
		driver.navigate().back();
	}
	
	@Test
	public void clickRLinks(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		header.clickAbout();
		header.clickAboutLinks(0);;
		driver.navigate().to(Constants.URL);
	}
	
	@AfterClass
	  public void afterClass() {
			driver.close();
	  }
}
