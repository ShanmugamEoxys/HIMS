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

public class TC_004_AddLocation extends Basepage {

	public TC_004_AddLocation(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[normalize-space()='Location']")
	WebElement clkAddLocation;

	@FindBy(xpath = "//*[contains(text(),' Add Location')]")
	WebElement clkLocationMenu;

	@FindBy(xpath = "//*[@id='ladName']")
	WebElement enterLocaName;

	@FindBy(xpath = "//*[@name='orgId'] ")
	WebElement clkOrgList;

	@FindBy(xpath = "//*[contains(@class,'MuiAutocomplete-listbox')]/li")
	List<WebElement> slctOrgList;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement clkAddBtn;

	@FindBy(xpath = "//*[contains(@class,'go2072408551')]//div[text()='Lad added successfully']")
	WebElement successLADMsg;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public void setAddLoc() {
		clkAddLocation.click();

	}

	public void setAddLocOpen() {
		clkLocationMenu.click();
	}

	public void setLocName(String name) {
		enterLocaName.sendKeys(name);
	}

	public void setOrgList(String orgName) {
		wait.until(ExpectedConditions.elementToBeClickable(clkOrgList));
		clkOrgList.click();

		wait.until(ExpectedConditions.visibilityOfAllElements(slctOrgList));

		boolean orgFound = false;
		for (WebElement org : slctOrgList) {
			String actualOrgName = org.getText().trim();
			if (actualOrgName.equalsIgnoreCase(orgName)) {
				org.click();
				orgFound = true;
				break;
			}
		}

		if (!orgFound) {
			System.out.println("Organization not found: " + orgName);
		}
	}

	public void setAdd() {
		clkAddBtn.click();

		try {
			wait.until(ExpectedConditions.visibilityOf(successLADMsg)); // Wait for message

			String actualMessage = successLADMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Lad added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Location Added Test Failed");

			System.out.println("✅ Location Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in Location Added Test: " + e.getMessage());
			Assert.fail("❌ Location Added Test Failed due to an unexpected error.");
		}

	}
}
