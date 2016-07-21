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
		
		@FindBy(id="txtzipcode")
		public WebElement Zip;
		public void enterZip(String text){
			Zip.sendKeys(text);
		}
		
		@FindBy(id="txtphonenumber")
		public WebElement Phone;
		public void enterPhone(String text){
			Phone.sendKeys(text);
		}
		
		@FindBy(id="txtfaxnumber")
		public WebElement Fax;
		public void enterFax(String text){
			Fax.sendKeys(text);
		}
		
		@FindBy(id="txtemail")
		public WebElement Email;
		public void enterEmail(String text){
			Email.sendKeys(text);
		}
		
		@FindBy(id="txtmodel")
		public WebElement Model;
		public void enterModel(String text){
			Model.sendKeys(text);
		}
		
		@FindBy(id="ddlcustomerissue")
		public WebElement Issue;
		public void enterCustIssue(String dropdownvalue){
			Select dd= new Select(Issue);
			dd.selectByValue(dropdownvalue);
		}
		
		@FindBy(id="txtserialNumber")
		public WebElement Snumber;
		public void enterSnumber(String text){
			Snumber.sendKeys(text);
		}
		
		@FindBy(id="txtadditionalcomment")
		public WebElement Comments;
		public void enterComments(String text){
			Comments.sendKeys(text);
		}
		
		@FindBy(id="content_C006_ctl00_ctl00_C033")
		public WebElement Cancel;
		public void clickCancel(){
			Cancel.click();
		}
		
		@FindBy(id="content_C006_ctl00_ctl00_C014")
		public WebElement Submit;
		public void clickSubmit(){
			Submit.click();
		}
		
		@FindBy(xpath="//div[@id='content_C003_Col01']/div[2]/a")
		public WebElement ViewLoc;
		public void clickViewLocation(){
			ViewLoc.click();
		}
		
}
