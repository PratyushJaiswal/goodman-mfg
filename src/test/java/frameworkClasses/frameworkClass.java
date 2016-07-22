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

import pageObjectFactory.homePageFactory;
import utilities.Constants;

public class frameworkClass {
	static Logger log = Logger.getLogger(frameworkClass.class);
	private WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	homePageFactory hp ;
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
		hp = new homePageFactory(driver);
		
	  }
	
	@Test
	public void run(){
		hp.notification();
	}
	
	
	
	@AfterClass
	  public void afterClass() {
			driver.close();
	  }

}
