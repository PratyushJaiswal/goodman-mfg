package pageObjectFactory;

import java.awt.Window;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class FindDealer {
	WebDriver driver;
	public FindDealer(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='filter-sec']/div/div[1]/span")//input[@id='dnn_ctr10007_GMDefault_ctl00_txtzipcode']
	public WebElement zip;
	@FindBy(xpath="//select[@id='dnn_ctr10007_GMDefault_ctl00_ddlMiles']")
	public WebElement miles;
	@FindBy(xpath="//select[@id='dnn_ctr10007_GMDefault_ctl00_ddlfilter']")
	public WebElement filterby;
	@FindBy(xpath="//input[@id='dnn_ctr10007_GMDefault_ctl00_imgfinddealer']")
	public WebElement search;
	@FindBy(xpath="//span[@id='dnn_ctr10007_GMDefault_ctl00_lblcount']")
	public WebElement resultCount;
	@FindBy(tagName="iframe")
	public List<WebElement> frameList;
	@FindBy(xpath="//div[@id='filter-sec']")
	public WebElement iframe;
	
	public void EnterZip(String zipcode){
	
		zip.sendKeys(zipcode);
	}
	
	public void selectMiles(String dropdown){
		Select mile=new Select(miles);
		mile.selectByValue(dropdown);
	}
	
	public void selectFilter(String dropdown){
		Select filter=new Select(filterby);
		filter.selectByValue(dropdown);
	}
	
	public void clickSearch(){
		search.click();
	}
	
	public void verifyResult(){
		Assert.assertEquals(resultCount.getText(), "20 Results Found");
	}
	
	public int getFrames(){
		return frameList.size();
		
	}
	
}
