package frameworkClasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjectFactory.Contact;
import pageObjectFactory.Footer;
import utilities.Constants;
import utilities.ExcelUtility;


public class TestCaseContactPage {
	//public String am,org,FN,LN,Title,Add1,Add2,city,state,zipcode,phone,Fax,e_mail,Model,Issue,SN,comment;
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
	/*@Test(dataProvider = "Authentication")
	public void test(String fir, String sec){
		System.out.println(fir);
		//System.out.println("test");
		System.out.println(sec);
		
	}*/
	@Test(dataProvider="Authentication")
	public void contactFormFill(String am,String org,String FN,String LN,String Title,String Add1,String Add2,String city,String state,String zipcode,String phone,String Fax,String e_mail,String Model,String Issue,String SN,String comment){
		footer.clickContact();
		contact.selectDropdown(am);
		contact.enterOrg(org);
		contact.enterFname(FN);
		contact.enterLname(LN);
		contact.enterTitle(Title);
		contact.enterAddress1(Add1);
		contact.enterAddress2(Add2);
		contact.enterCity(city);
		contact.enterState(state);
		contact.enterZip(zipcode);
	    contact.enterPhone(phone);
	    contact.enterFax(Fax);
	    contact.enterEmail(e_mail);
	    contact.enterModel(Model);
	    contact.selectCustIssue(Issue);
	    contact.enterSnumber(SN);
	    contact.enterComments(comment);
	    contact.clickSubmit();
	    driver.navigate().to(Constants.URL);
	}
	
	 @DataProvider
	  
	   public Object[][] Authentication() throws Exception{
	  
	      // Setting up the Test Data Excel file
		
			Object[][] testObjArray = utilities.ExcelUtils.getTableArray(Constants.File_Path,"ContactUs");
			
			
			return (testObjArray);
	       
	   }
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
