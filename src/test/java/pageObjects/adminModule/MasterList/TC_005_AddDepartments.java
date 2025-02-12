package pageObjects.adminModule.MasterList;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

	@FindBy(xpath = "//*[contains(@class,'go2072408551')]//div[text()='Department added successfully']")
	WebElement departmentMsg;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
		try {
			wait.until(ExpectedConditions.visibilityOf(departmentMsg)); // Wait for message

			String actualMessage = departmentMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Department added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Department Added Test Failed");

			System.out.println("✅ Department Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in Department Added Test: " + e.getMessage());
			Assert.fail("❌ Department Added Test Failed due to an unexpected error.");
		}
	}
}
