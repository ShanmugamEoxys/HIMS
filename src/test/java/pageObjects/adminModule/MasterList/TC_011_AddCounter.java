package pageObjects.adminModule.MasterList;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.Basepage;

public class TC_011_AddCounter extends Basepage {

	public TC_011_AddCounter(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[contains(text(),'Counters')]")
	WebElement clkCounters;

	@FindBy(xpath = "//*[contains(text(),' Add Counter')]")
	WebElement clkAddCoun;

	@FindBy(xpath = "//*[@id='counterName']")
	WebElement CountName;

	@FindBy(xpath = "//*[@id='floorId']")
	WebElement clkFloor;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> floorList;

	@FindBy(xpath = "//*[@id='patientTypeId']")
	WebElement clkPatType;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> slctPatType;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//div[@role='status' and @aria-live='polite']")
	WebElement counterAddedMsg;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void setCounter() {
		clkCounters.click();

	}

	public void openAddCounter() {
		clkAddCoun.click();
	}

	public void setCounterName(String name) {
		CountName.sendKeys(name);
	}

	public void setFloor() {
		clkFloor.click();

		for (WebElement floor : floorList) {
			if (floor.getText().equalsIgnoreCase("13")) {
				floor.click();
				break;
			}

		}
	}

	public void setPatientType() {
		clkPatType.click();

		for (WebElement patientType : slctPatType) {
			if (patientType.getText().equalsIgnoreCase("Normal")) {
				patientType.click();
				break;
			}
		}

	}

	public void setSubmit() {
		submit.click();
		
		try {
			wait.until(ExpectedConditions.visibilityOf(counterAddedMsg)); // Wait for message

			String actualMessage = counterAddedMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Counter added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Counter Added Test Failed");

			System.out.println("✅ Counter Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in ID Proof Test: " + e.getMessage());
			Assert.fail("❌ Counter Added Test Failed due to an unexpected error.");
		}
	}

}
