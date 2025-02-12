package pageObjects.opModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Basepage;

public class TC_003_PatientRegisteration extends Basepage {

	public TC_003_PatientRegisteration(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act = new Actions(driver);

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@FindBy(xpath = "//*[@id='patientType']")
	WebElement patientType;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[1]")
	WebElement selectPatType;

	@FindBy(xpath = "//*[@id='patientVisitFor']")
	WebElement clkPatVisitForType;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[5]")
	WebElement selectVisitForType;

	@FindBy(xpath = "//*[@id='patientFirstName']")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='patientLastName']")
	WebElement lastName;

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

	@FindBy(xpath = "//*[contains(@class,'MuiDayCalendar-monthContainer')]//button")
	List<WebElement> dates;

	@FindBy(xpath = "//*[@id='patientGender']")
	WebElement selectGender;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[1]")
	WebElement genderList;

	@FindBy(xpath = "//*[@id='patientEmail']")
	WebElement patientEmail;

	@FindBy(xpath = "//*[@id='doctorName']")
	WebElement clkDr;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[1]")
	WebElement selectDrName;

	@FindBy(xpath = "//*[@class=' react-tel-input ']//input[@type='tel']")
	WebElement phno;

	@FindBy(xpath = "//span[text()='Same as Phone Number']/preceding-sibling::span/input[@type='checkbox']")
	WebElement chkBox;

	@FindBy(xpath = "//*[@id='patientCategory']")
	WebElement clkPatCat;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[2]")
	WebElement slctPatientList;

	@FindBy(xpath = "//*[@id='patientIdType']")
	WebElement clkPatIDType;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> slctIDType;

	@FindBy(xpath = "//*[@id='patientIdNo']")
	WebElement sendIDNo;

	@FindBy(xpath = "//*[@id='Next_button']")
	WebElement clkNextPage;

	// page 2

	@FindBy(xpath = "//*[@id='patientCurrentHouseNo']")
	WebElement enterHouseNo;

	@FindBy(xpath = "//*[@id='patientCurrentStreetName']")
	WebElement enterHouseName;

	@FindBy(xpath = "//*[@id='mui-component-select-patientAddressCurrentCountry']")
	WebElement clkAddressCountry;

	@FindBy(xpath = "//*[@id='mui-component-select-patientAddressCurrentStateRegion']")
	WebElement clkAddressState;

	@FindBy(xpath = "//*[@id='mui-component-select-patientAddressCurrentCity']")
	WebElement clkAddressCity;

	@FindBy(xpath = "//*[@name='sameAsCurrentAddress']")
	WebElement clkSameAddrBox;

	// Page3
	@FindBy(xpath = "//*[@id='patientOccupation']")
	WebElement clkOccupation;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]")
	WebElement slctOccupationList;

	@FindBy(xpath = "//*[@id='patientWorkingOrganization']")
	WebElement clkPatWorkOrg;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]")
	WebElement slctWorkOrgList;

	@FindBy(xpath = "//*[@id='knownUs']")
	WebElement clkKnownUs;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]")
	WebElement slctKnownUsList;

	@FindBy(xpath = "//*[@id='consultation']")
	WebElement clkConsultation;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]")
	WebElement slctConsultationList;

	@FindBy(xpath = "//*[@id='patientPhysicalCondition']")
	WebElement clkPhyCondition;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]")
	WebElement slctPhyConditionList;

	@FindBy(xpath = "//*[@id='patientRace']")
	WebElement clkRace;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]")
	WebElement slctPatientRace;

	@FindBy(xpath = "//*[@id='patientFatherSpouseName']")
	WebElement clkFatherSpouseName;

	@FindBy(xpath = "//*[@class=' react-tel-input ']//input[@type='tel']")
	WebElement emergencyNo;

	@FindBy(xpath = "//*[@id='Save_button']")
	WebElement clkSave;

	@FindBy(xpath = "//*[contains(text(),'Skip')]")
	WebElement skip;

	public void setPatientType() {

		patientType.click();

		// perform double click

		act.doubleClick(selectPatType).perform();
		// selectPatType.click();
	}

	public void setVisitForType() {

		clkPatVisitForType.click();
		selectVisitForType.click();
	}

	public void setPatientName(String fname, String lname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);

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
				year.click();
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
				prevMonthButton = wait.until(ExpectedConditions.elementToBeClickable(prevMonthButton));
				prevMonthButton.click();

				// Wait for the month display to update
				monthsDisplay = wait.until(ExpectedConditions.visibilityOf(monthsDisplay));

			}
		}
	}

	public void setDate(String requiredDate) {
		for (WebElement date : dates) {
			if (date.getText().equals(requiredDate)) {
				date.click();
				break;
			}
		}
	}

	public void setGender() {
		selectGender.click();
		genderList.click();
	}

	public void setPatientEmail(String email) {
		patientEmail.sendKeys(email);
	}

	public void setDrName() {

		clkDr.click();
		selectDrName.click();
	}

	public void setPhNo(String mobNo) {

		jse.executeScript("window.scrollBy(0,600)");

		phno.sendKeys(mobNo);
	}

	public void setCheckbox() {
		chkBox.click();
	}

	public void setPatientCategory() {
		clkPatCat.click();
		slctPatientList.click();
	}

	public void setPatID(String id) {
		clkPatIDType.click();
		for (WebElement Ids : slctIDType) {
			if (Ids.getText().equalsIgnoreCase("License")) {
				Ids.click();
				break;
			}
		}

		// slctIDType.click();
		sendIDNo.sendKeys(id);
	}

	public void setNextPage() {
		clkNextPage.click();
	}

	// page2
	public void setHouseNo(String houseNo) {
		enterHouseNo.sendKeys(houseNo);
	}

	public void setHouseName(String houseName) {
		enterHouseName.sendKeys(houseName);
	}

	public void setCountryAddress() {
		clkAddressCountry.click();

		// We wait the list of country available

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")));

		// Find all country list items
		List<WebElement> countriesList = driver
				.findElements(By.xpath("//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li"));

		// Iterate through the list items in the dropdown and select the desired country

		for (WebElement country : countriesList) {
			if (country.getText().equals("India")) {
				country.click();
				break;
			}
		}

	}

	public void setCountryState() {
		clkAddressState.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")));
		// find all list items

		List<WebElement> regionsList = driver
				.findElements(By.xpath("//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li"));

		for (WebElement regions : regionsList) {
			if (regions.getText().equals("Tamil Nadu")) {
				regions.click();
				break;
			}
		}
	}

	public void setAddressCity() {
		clkAddressCity.click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")));

		// find all city list items
		List<WebElement> cityList = driver
				.findElements(By.xpath("//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li"));

		for (WebElement cities : cityList) {
			if (cities.getText().equals("Tiruchirappalli")) {
				cities.click();
				break;
			}
		}

	}

	public void setSameAddressBox() {
		clkSameAddrBox.click();
	}

	// Page3
	public void setOccupation() {
		clkOccupation.click();

		// Locate all list items (options) within the dropdown
		List<WebElement> options = slctOccupationList.findElements(By.tagName("li"));

		// Select the desired option by index
		if (options.size() > 4) {
			options.get(3).click(); // Index starts from 0
		} else {
			System.out.println("Option index out of bounds");
		}
	}

	public void setWorkOrganization() {
		clkPatWorkOrg.click();
		List<WebElement> options = slctWorkOrgList.findElements(By.tagName("li"));
		for (WebElement listOptions : options) {
			if (listOptions.getText().equalsIgnoreCase("Bussiness")) {
				listOptions.click();
				break;
			}
		}

	}

	public void setknownUs() {
		clkKnownUs.click();
		List<WebElement> options = slctKnownUsList.findElements(By.tagName("li"));
		for (WebElement KnownUsOptions : options) {
			if (KnownUsOptions.getText().equalsIgnoreCase("Campains")) {
				KnownUsOptions.click();
				break;
			}
		}
	}

	public void setConsultation() {
		clkConsultation.click();
		List<WebElement> options = slctConsultationList.findElements(By.tagName("li"));
		for (WebElement KnownUsOptions : options) {
			if (KnownUsOptions.getText().equalsIgnoreCase("General medicine")) {
				KnownUsOptions.click();
				break;
			}
		}
	}

	public void setclkPhyCondition() {
		clkPhyCondition.click();
		List<WebElement> options = slctPhyConditionList.findElements(By.tagName("li"));
		for (WebElement KnownUsOptions : options) {
			if (KnownUsOptions.getText().equalsIgnoreCase("Healthy")) {
				KnownUsOptions.click();
				break;
			}
		}
	}

	public void setPatRace() {
		clkRace.click();
		List<WebElement> options = slctPatientRace.findElements(By.tagName("li"));
		for (WebElement KnownUsOptions : options) {
			if (KnownUsOptions.getText().equalsIgnoreCase("Asian")) {
				KnownUsOptions.click();
				break;
			}
		}
	}

	public void setFatherSpouseName(String name) {
		clkFatherSpouseName.sendKeys(name);
	}

	public void setEmePhNo(String emeNo) {
		emergencyNo.sendKeys(emeNo);
	}

	public void setSaveForm() {
		clkSave.click();

	}

	public void verifyAfterPatientRegistration() {
		try {
			// Wait for a success dialog
			WebElement successMsg = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='dialog']")));

			// Extaract UHID
			WebElement uhidTextElement = successMsg.findElement(By.xpath("//div[contains(text(),'UHID:')]"));
			String uhid = uhidTextElement.getText().split(":")[1].trim();
			System.out.println("✅ Generated Patient UHID: " + uhid);

			wait.until(ExpectedConditions.elementToBeClickable(skip));
			skip.click();

			// Wait for the UHID list to be visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(@class,'MuiDataGrid-columnHeaderTitle') and text()='Patient UHID']")));

			// Verify UHID in the List
			WebElement uhidInList = driver.findElement(
					By.xpath("//p[contains(@class, 'MuiTypography-body2') and contains(text(),'" + uhid + "')]"));

			if (uhidInList.isDisplayed()) {
				System.out.println("✅ The registered Patient UHID " + uhid + " is present in the UHID List.");
			} else {
				System.out.println("❌ The registered UHID " + uhid + " is NOT found in the UHID List.");
			}

		} catch (Exception e) {
			System.out.println("❌ Error: " + e.getMessage());
			e.printStackTrace(); // Ensure error details are printed in the console }
		}
	}
}
