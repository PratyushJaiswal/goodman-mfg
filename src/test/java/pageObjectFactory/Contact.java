package pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Contact {
		
		@FindBy(xpath="//div[@id='content_C014_Col00']/div[2]/p[2]/a[1]/strong")
		public WebElement Warranty;
		public void clickWarranty(){
			Warranty.click();
		}
		
		@FindBy(xpath="//div[@id='content_C014_Col00']/div[2]/p[2]/a[2]/strong")
		public WebElement Registration;
		public void clickRegistration(){
			Registration.click();
		}
		
		@FindBy(xpath="//div[@id='content_C014_Col00']/div[2]/p[2]/a[3]/strong")
		public WebElement Operation;
		public void clickOperation(){
			Operation.click();
		}
		
		@FindBy(xpath="//div[@id='content_C014_Col00']/div[2]/p[2]/a[4]/strong")
		public WebElement Maintenance;
		public void clickMaintenance(){
			Maintenance.click();
		}
		
		@FindBy(xpath="//div[@id='content_C014_Col00']/div[2]/p[2]/a[5]/strong")
		public WebElement HVAC;
		public void clickHVAC(){
			HVAC.click();
		}
		
		@FindBy(xpath="//select[@id='ddliam']")
		public WebElement Dropdown;
		public void selectDropdown(String dropdownValue){
			Select dd = new Select(Dropdown);
			dd.selectByValue(dropdownValue);
		}
		
		@FindBy(id="txtorganization")
		public WebElement Org;
		public void enterOrg(String text){
			Org.sendKeys(text);
		}
		
		@FindBy(id="txtfirstname")
		public WebElement Fname;
		public void enterFname(String text){
			Fname.sendKeys(text);
		}
		
		@FindBy(id="txtlastname")
		public WebElement Lname;
		public void enterLname(String text){
			Lname.sendKeys(text);
		}
		
		@FindBy(id="txttitle")
		public WebElement Title;
		public void enterTitle(String text){
			Title.sendKeys(text);
		}
		
		@FindBy(id="txtaddress1")
		public WebElement Address1;
		public void enterAddress1(String text){
			Address1.sendKeys(text);
		}
		
		@FindBy(id="txtaddress2")
		public WebElement Address2;
		public void enterAddress2(String text){
			Address2.sendKeys(text);
		}
		
		@FindBy(id="txtcity")
		public WebElement City;
		public void enterCity(String text){
			City.sendKeys(text);
		}
		
		@FindBy(id="'txtstate")
		public WebElement State;
		public void enterState(String text){
			State.sendKeys(text);
		}
		
		
}
