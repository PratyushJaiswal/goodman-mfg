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

import pageObjectFactory.Contact;
import pageObjectFactory.Footer;
import utilities.Constants;

public class TestCaseContactPage {
	static Logger log = Logger.getLogger(frameworkClass.class);
	private WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	Contact contact;
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
		contact = new Contact(driver);
		footer = new Footer(driver);
		
	  }
	
	@Test
	public void contactFormFill(){
		footer.clickContact();
		contact.selectDropdown("Contractor");
		contact.enterOrg("softway");
		contact.enterFname("Syed");
		contact.enterLname("Zakaulla");
		contact.enterTitle("Software Engineer");
		contact.enterAddress1("132, HBR layout");
		contact.enterAddress2("Kalyan Nagar");
		contact.enterCity("Bangalore");
		contact.enterState("Karnataka");
		contact.enterZip("560043");
	    contact.enterPhone("9980818544");
	    contact.enterFax("9980818544");
	    contact.enterEmail("syed.zakaulla@softway.com");
	    contact.enterModel("ZP110");
	    contact.selectCustIssue("Misc");
	    contact.enterSnumber("112195");
	    contact.enterComments("This is a test message from softway");
	    contact.clickSubmit();
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
