package pageObjects.adminModule.MasterList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.Basepage;

public class TC_007_AddWards extends Basepage {

	public TC_007_AddWards(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//*[contains(text(),'Wards')]")
	WebElement openWard;

	@FindBy(xpath = "//*[contains(text(),' Add Ward')]")
	WebElement clkAddWard;

	@FindBy(xpath = "//*[@id='wardName']")
	WebElement wardName;

	@FindBy(xpath = "//*[@name='ladId']")
	WebElement wardLoc;

	@FindBy(xpath = "//*[contains(@class,'MuiAutocomplete-listbox')]")
	WebElement wardList;

	@FindBy(xpath = "//*[@id='floorId']")
	WebElement clkFloor;
	
	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]")
	WebElement slctFloorList;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement clkAddtbn;
	
	public void setWardOpen() {
		openWard.click();
	}

	public void setAddWard() {
		clkAddWard.click();
	}

	public void setWardName(String name) {
		wardName.sendKeys(name);
	}

	public void setWardLocation() {
		wardLoc.click();

		List<WebElement> wardLocation = wardList.findElements(By.tagName("li"));
		for (WebElement wardLocationsList : wardLocation) {
			if (wardLocationsList.getText().equalsIgnoreCase("Bengaluru")) {
				wardLocationsList.click();
				break;
			}
		}

	}

	public void setWardFloor() {
		clkFloor.click();
		
	List<WebElement>floorsList=slctFloorList.findElements(By.tagName("li"));
	
	for(WebElement floorList:floorsList)
	{
		if(floorList.getText().equalsIgnoreCase("3"));
		{
			floorList.click();
			break;
		}
		
	}
		
	}
	
	public void setAddNewWard() {
		clkAddtbn.click();
	}
	
}
