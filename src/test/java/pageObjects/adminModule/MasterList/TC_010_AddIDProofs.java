package pageObjects.adminModule.MasterList;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.Basepage;

public class TC_010_AddIDProofs extends Basepage {

	public TC_010_AddIDProofs(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[contains(text(),'ID Proofs')]")
	WebElement clkID;

	@FindBy(xpath = "//*[contains(text(),' Add ID Proof')]")
	WebElement clkToOpen;

	@FindBy(xpath = "//*[@id='proofName']")
	WebElement idName;

	@FindBy(xpath = "//*[@id='noOfDigits']")
	WebElement noOfDigits;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//div[@role='status' and @aria-live='polite']")
	WebElement idProofMsg;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void setIDProof() {
		clkID.click();

	}

	public void setOpenIDProof() {
		clkToOpen.click();
	}

	public void setIDName(String name) {
		idName.sendKeys(name);
	}

	public void setNoDigits(String no) {
		noOfDigits.sendKeys(no);
	}

	public void setSubmit() {
		submit.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(idProofMsg)); // Wait for message

			String actualMessage = idProofMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "IDProof added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Link Bed Test Failed");

			System.out.println("✅ ID Proof Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in ID Proof Test: " + e.getMessage());
			Assert.fail("❌ ID Proof Test Failed due to an unexpected error.");
		}
	}
}
