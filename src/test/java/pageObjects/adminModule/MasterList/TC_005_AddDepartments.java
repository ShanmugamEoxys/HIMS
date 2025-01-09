package pageObjects.adminModule.MasterList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.Basepage;

public class TC_005_AddDepartments extends Basepage {

	public TC_005_AddDepartments(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[contains(text(),'Departments')]")
	WebElement addLocbtn;

	@FindBy(xpath = "//*[contains(text(),' Add Department')]")
	WebElement clkaddDep;

	@FindBy(xpath = "//*[@id='deptName']")
	WebElement enterDepName;

	@FindBy(xpath = "//*[@name='orgId']")
	WebElement clkOrglist;

	@FindBy(xpath = "//*[contains(@class,'MuiAutocomplete-listbox')]")
	WebElement slctOrgList;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement clkAdd;
	
	public void setDep() {
		addLocbtn.click();
	}

	public void setAddDep() {
		clkaddDep.click();
	}

	public void setDepName(String depName) {
		enterDepName.sendKeys(depName);
	}

	public void setOrgList() {
		clkOrglist.click();

		List<WebElement> orgDepList = slctOrgList.findElements(By.tagName("li"));
		for (WebElement orgDepLists : orgDepList) {
			if (orgDepLists.getText().equalsIgnoreCase("CIANUDI")) {
				orgDepLists.click();
				break;
			}
		}
	}

	public void setDepSubmit() {
		clkAdd.click();
	}
}
