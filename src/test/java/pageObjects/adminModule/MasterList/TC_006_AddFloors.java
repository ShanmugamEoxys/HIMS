package pageObjects.adminModule.MasterList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.Basepage;

public class TC_006_AddFloors extends Basepage {

	public TC_006_AddFloors(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//*[contains(text(),'Floors')]")
	WebElement clkAddFloorbtn;
	
	@FindBy(xpath = "//*[contains(text(),' Add Floor')]")
	WebElement clkAddFloor;
	
	@FindBy(xpath = "//*[@id='floorNum']")
	WebElement enterFlrNo;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement addFloor;
	
	
	public void setFlrCate() {
		clkAddFloorbtn.click();
	}
	
	public void setAddFloor() {
		clkAddFloor.click();
	}
	
	public void setFloor(String no) {
		enterFlrNo.sendKeys(no);
	}
	
	public void setSubmitFloor()
	{
		addFloor.click();
	}
}
