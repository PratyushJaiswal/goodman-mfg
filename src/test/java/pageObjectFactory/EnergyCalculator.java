package pageObjectFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class EnergyCalculator {
	WebDriver driver;
	public EnergyCalculator(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="address")
	public WebElement address;
	@FindBy(id="city")
	public WebElement city;
	@FindBy(id="state")
	public WebElement state;
	@FindBy(id="zip")
	public WebElement zip;
	@FindBy(xpath="//div[@id='form']/div[4]/input")
	public WebElement findHome;
	@FindBy(id="next1")
	public WebElement next;
	@FindBy(xpath="//div[@id='content']/div[1]/div[2]//div")
	public List<WebElement> HomeAge;
	@FindBy(xpath="//div[@id='content']/div[2]/div[2]//div")
	public List<WebElement> HomeSize;
	@FindBy(xpath="//div[@id='content']/div[4]/div[2]//div")
	public List<WebElement> TotalWindows;
	@FindBy(xpath="//div[@id='content']/div[3]/div[2]//div")
	public List<WebElement> FinishedLevels;
	
	@FindBys( {
		@FindBy(xpath="//div[@id='content']/div[5]/div[2]//div"),
		@FindBy(xpath="//div[@id='content']/div[5]/div[3]//div")
		} )
	public List<WebElement> CurrentSystem;
	
	@FindBy(id="next0")
	public WebElement back;
	
	@FindBy(xpath="//div[@id='content']/div[1]/div[2]//div")
	public List<WebElement> HeatingRate;
	
	@FindBy(xpath="//div[@id='content']/div[2]/div[2]//div")
	public List<WebElement> CoolingRate;
	
	@FindBys({
		@FindBy(xpath="//div[@id='content']/div/div[1]//label"),
		@FindBy(xpath="//div[@id='content']/div/div[2]//label")
	})
	public List<WebElement> interests;
	
	@FindBy(xpath="//div[@id='content']/h2")
	public WebElement stepFive;
	
	@FindBy(xpath="//div[@id='content']/div[4]/div[1]")
	public WebElement lastBack;
	
	@FindBy(xpath="//div[@id='content']/div[4]/div[2]")
	public WebElement restart;
	
	@FindBy(xpath="//div[@id='table2']/a[1]")
	public WebElement localDealer;
	
	@FindBy(xpath="//div[@id='table2']/a[2]")
	public WebElement print;
	
	@FindBy(xpath="//div[@id='table2']/a[3]")
	public WebElement Email;
	
	public void enterAddress(String text){
		address.sendKeys(text);
	}
	
	public void enterCity(String text){
		city.sendKeys(text);
	}
	
	public void enterState(String text){
		state.sendKeys(text);
	}
	
	public void enterZip(String text){
		zip.sendKeys(text);
	}
	
	public void clickfindHome(){
		findHome.click();
	}
	
	public void clickNext(){
		next.click();
	}
	
	public void selectHomeAge(int index){
		HomeAge.get(index).click();
	}
	
	public void selectHomeSize(int index){
		HomeSize.get(index).click();
	}
	
	public void selectWindows(int index){
		TotalWindows.get(index).click();
	}
	
	public void selectLevels(int index){
		FinishedLevels.get(index).click();
	}
	
	public void selectSystem(int index){
		CurrentSystem.get(index).click();
	}
	
	public void clickBack(){
		back.click();
	}
	
	public void selectHeatingRate(int index){
		HeatingRate.get(index).click();
	}
	
	public void selectCoolingRate(int index){
		CoolingRate.get(index).click();
	}
	
	public void selectInterests(int index){
		interests.get(index).click();
	}
	
	public void clickLastBack(){
		lastBack.click();
	}
	
	public void clickRestart(){
		restart.click();
	}
	
	public void clickDealer(){
		localDealer.click();
	}
	
	public void clickPrint(){
		print.click();
	}
	
	public void clickEmail(){
		Email.click();
	}
	
	public void getHeader(){
		stepFive.getText();
	}
}
