package pageObjectFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class homePageFactory {
	static Logger log = Logger.getLogger(homePageFactory.class);
	WebDriver driver;
	@FindBy(id = "gs_htif0")
	WebElement elementname;
	
	public homePageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void notification(){
		elementname.sendKeys("this is the search");
	}

}
