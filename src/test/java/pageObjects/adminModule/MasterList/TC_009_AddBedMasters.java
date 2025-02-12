package pageObjects.adminModule.MasterList;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.Basepage;

public class TC_009_AddBedMasters extends Basepage {

	public TC_009_AddBedMasters(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Actions actions = new Actions(driver);

	@FindBy(xpath = "//*[contains(text(),'Bed Master')]")
	WebElement clkBM;

	// Link Bed
	@FindBy(xpath = "//*[normalize-space()='Link Bed']")
	WebElement clkLinkBed;

	@FindBy(xpath = "(//button[normalize-space()='Link Bed'])[1]")
	WebElement openLinkBedMenu;

	@FindBy(xpath = "//*[@id='bedNo']")
	WebElement clkBedNo;

	@FindBy(xpath = "//*[@id='bedTypeId']")
	WebElement bedType;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> bedTypeList;

	@FindBy(xpath = "//*[@id='bedStatus']")
	WebElement bedStatus;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> statusList;

	@FindBy(xpath = "//*[@id='bedStsReason']")
	WebElement statusReason;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//*[@role='status' and @aria-live='polite']")
	WebElement linkBedMsg;

	// Add Bed Types

	@FindBy(xpath = "//*[contains(text(),'Add Bed Types')]")
	WebElement clkaddBedTypes;

	@FindBy(xpath = "//*[contains(text(),' Add New Bed Type')]")
	WebElement openNewBedType;

	@FindBy(xpath = "//*[@id='bedTypeName']")
	WebElement bedTypeName;

	@FindBy(xpath = "//*[@id='bedCharge']")
	WebElement bedCharge;

	@FindBy(xpath = "//button[@aria-label='Choose date']")
	WebElement clkDOBicon;

	@FindBy(xpath = "//button[@aria-label='calendar view is open, switch to year view']")
	WebElement yearsMenu;

	@FindBy(xpath = "//*[contains(@class,'MuiYearCalendar-root')]//div")
	List<WebElement> years;

	@FindBy(xpath = "//*[contains(@class,'MuiPickersCalendarHeader-label')]/div")
	WebElement monthsDisplay;

	@FindBy(xpath = "//button[@title='Previous month']")
	WebElement prevMonthButton;

	@FindBy(xpath = "//button[@title='Next month']")
	WebElement afterNextMonth;

	@FindBy(xpath = "//button[@role='gridcell']")
	List<WebElement> dates;

	@FindBy(xpath = "//*[@role='status' and @aria-live='polite']")
	WebElement addBedTypeMsg;

	// Bed List

	@FindBy(xpath = "//*[contains(text(),'Bed List')]")
	WebElement clkBedList;

	@FindBy(xpath = "//*[contains(text(),' Add New Bed')]")
	WebElement clkNewBed;

	@FindBy(xpath = "//*[@id='bedNo']")
	WebElement clkBedNum;

	@FindBy(xpath = "//*[@id='bedTypeId']")
	WebElement slctbedType;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> selectBedTypes;

	@FindBy(xpath = "//*[@id='roomId']")
	WebElement clkRoomNo;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> slctRoomNo;

	@FindBy(xpath = "//*[@id='bedStatus']")
	WebElement clkBedStatus;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> slctBedStatus;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement Submit;

	@FindBy(xpath = "//*[@role='status' and @aria-live='polite']")
	WebElement bedListMsg;

	// Link Bed
	public void setOpenBM() {
		clkBM.click();
	}

	public void setOpenLinkBed() {
		clkLinkBed.click();
		openLinkBedMenu.click();
	}

	public void setBedNo(String no) {
		clkBedNo.sendKeys(no);
	}

	public void setBedType() {
		bedType.click();

		for (WebElement bedType : bedTypeList) {
			if (bedType.getText().equalsIgnoreCase("Child Bed")) {
				bedType.click();
				break;
			}
		}

	}

	public void setBedStatus() {
		bedStatus.click();
		for (WebElement status : statusList) {

			if (status.getText().equalsIgnoreCase("AVAILABLE")) {
				status.click();
			}
		}
	}

	public void bedStatusReason(String name) {
		statusReason.sendKeys(name);
	}

	public void submitLinkBedForm() {
		submit.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(linkBedMsg)); // Wait for message

			String actualMessage = linkBedMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Bed info added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Link Bed Test Failed");

			System.out.println("✅ Link Bed Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in ID Proof Test: " + e.getMessage());
			Assert.fail("❌ Link Bed Test Failed due to an unexpected error.");
		}
	}

	// Add BedTypes
	public void setAddBedType() {
		clkaddBedTypes.click();
		openNewBedType.click();
	}

	public void setBedTypeName(String name) {
		bedTypeName.sendKeys(name);
		;
	}

	public void setBedCharge(String amount) {
		bedCharge.sendKeys(amount);
	}

	public void setDOB(String requiredYear) {
		// open date picker
		clkDOBicon.click();
		// Wait for the yearsMenu to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(yearsMenu));
		yearsMenu.click();

//        // Iterate through the list of years and select the required year
		for (WebElement year : years) {
			// if text of the year matches with the required year
			if (year.getText().equals(requiredYear)) {
				actions.doubleClick(year).build().perform();
				// year.click();
				break;
			}

		}
	}

	public void setMonth(String requiredMonth) {
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait for the month display element to be visible
			monthsDisplay = wait.until(ExpectedConditions.visibilityOf(monthsDisplay));

			// Loop until the displayed month matches the required month
			while (!monthsDisplay.getText().contains(requiredMonth)) {
				// Click the "Previous month" button to navigate
				afterNextMonth = wait.until(ExpectedConditions.elementToBeClickable(afterNextMonth));
				afterNextMonth.click();

				// Wait for the month display to update
				monthsDisplay = wait.until(ExpectedConditions.visibilityOf(monthsDisplay));

			}
		}
	}

	public void setDate(String requiredDate) {
		for (WebElement date : dates) {
			if (date.getText().equals(requiredDate)) {
				actions.doubleClick(date).build().perform();
				// date.click();
				break;
			}
		}
	}

	public void SubmitBedType() {
		submit.click();

		try {
			wait.until(ExpectedConditions.visibilityOf(addBedTypeMsg)); // Wait for message

			String actualMessage = addBedTypeMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Bed type added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Bed Type Test Failed");

			System.out.println("✅ Bed Type Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in Bed Type Test: " + e.getMessage());
			Assert.fail("❌ Bed Type Added Test Failed due to an unexpected error.");
		}
	}

	public void setBedList() {
		clkBedList.click();
		clkNewBed.click();
	}

	public void setBedNum(String no) {
		clkBedNum.sendKeys(no);
	}

	public void setBedTypes() {
		slctbedType.click();
		for (WebElement BedType : selectBedTypes) {
			if (BedType.getText().equalsIgnoreCase("LCFQRYV")) {
				BedType.click();
				break;
			}

		}

	}

	public void setRoomNo() {
		clkRoomNo.click();
		for (WebElement RoomNo : slctRoomNo) {
			if (RoomNo.getText().equalsIgnoreCase("78")) {
				RoomNo.click();
				break;
			}
		}
	}

	public void setStatus() {
		clkBedStatus.click();
		for (WebElement Status : slctBedStatus) {
			if (Status.getText().equalsIgnoreCase("AVAILABLE")) {
				Status.click();
				break;
			}
		}

	}

	public void setSubmitBed() {
		Submit.click();

		try {
			wait.until(ExpectedConditions.visibilityOf(bedListMsg)); // Wait for message

			String actualMessage = bedListMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Bed info added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Bed List Added Test Failed");

			System.out.println("✅ Bed List Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in Bed List Test: " + e.getMessage());
			Assert.fail("❌ Bed List Added Test Failed due to an unexpected error.");
		}
}
}