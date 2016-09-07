package frameworkClasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pageObjectFactory.FindDealer;
import pageObjectFactory.HeaderPF;
import pageObjectFactory.HomePage;
import utilities.Constants;

public class TestCaseFindaDealer {
	static Logger log = Logger.getLogger(TestCaseProductDetails.class);
	private WebDriver driver;
	FindDealer FD;
	HeaderPF header;
	HomePage HP;
	
	@Parameters("browserType")
	@BeforeClass
	public void beforeClass(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", Constants.Chrome_driver);
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure(Constants.log_Path);
		FD=new FindDealer(driver);
		header=new HeaderPF(driver);
		HP=new HomePage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException{
		header.clickFindDealer();
		Thread.sleep(5000);
	}
	
	@Test
	public void findDealer() throws InterruptedException{
		
		System.out.println(FD.getFrames());
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		FD.EnterZip("77479");
		
		/*header.clickFindDealer();
		FD.EnterZip("77479");
		FD.selectMiles("10");
		FD.selectFilter("All");
		FD.clickSearch();
		HP.enterZipcode("77479");
		HP.enterMiles("10");
		HP.clickFindDealer();*/
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}

}
