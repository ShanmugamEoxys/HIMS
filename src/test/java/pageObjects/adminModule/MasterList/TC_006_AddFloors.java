package pageObjects.adminModule.MasterList;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.Basepage;

public class TC_006_AddFloors extends Basepage {

	public TC_006_AddFloors(WebDriver driver) {
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

	@FindBy(xpath = "//div[@role='status' and @aria-live='polite']")
	WebElement floorMsg;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void setFlrCate() {
		clkAddFloorbtn.click();
	}

	public void setAddFloor() {
		clkAddFloor.click();
	}

	public void setFloor(String no) {
		enterFlrNo.sendKeys(no);
	}

	public void setSubmitFloor() {
		addFloor.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(floorMsg)); // Wait for message

			String actualMessage = floorMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Floor added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Floor Added Test Failed");

			System.out.println("✅ Floor Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in Floor Test: " + e.getMessage());
			Assert.fail("❌ Floor Added Test Failed due to an unexpected error.");
		}
	}
}
