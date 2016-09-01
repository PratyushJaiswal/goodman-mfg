package frameworkClasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
	  }
	@Test
	public void productsCategoryCount(){
		header.clickProducts();
		int count = product.ResProd.size();
		System.out.println(count);
		Assert.assertEquals(count, 10);
	}
}
