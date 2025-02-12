package pageObjects.opModule;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Basepage;

public class TC_001_UHID_Creation extends Basepage {

	public TC_001_UHID_Creation(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='pat_first_name']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='pat_last_name']")
	WebElement txtLastname;

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

	@FindBy(xpath = "//div[@id='patientType']")
	WebElement patientType;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[1]")
	WebElement selectPatientType;

	@FindBy(xpath = "//div[@id='sponsers']")
	WebElement selectSponsorType;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[1]")
	WebElement chooseSponsorList;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement enterTelephone;

	@FindBy(xpath = "//input[@name='patientCurrentHouseNo']")
	WebElement enterHouseNo;

	@FindBy(xpath = "//*[@id='mui-component-select-patientAddressCurrentCountry']")
	WebElement selectCountry;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	WebElement chooseCountryName;

	@FindBy(xpath = "//*[@id='mui-component-select-patientAddressCurrentStateRegion']")
	WebElement selectcountryRegion;
	// *[@id='mui-component-select-patientAddressCurrentCity']
	@FindBy(xpath = "//*[@id='mui-component-select-patientAddressCurrentCity']")
	WebElement selectCityName;

	@FindBy(xpath = "//*[@id='UHIDstreetname']")
	WebElement enterStreetName;

	@FindBy(xpath = "//*[@id='UHIDgender']")
	WebElement selectGender;

	@FindBy(xpath = "//*[@id='UHIDpincode']")
	WebElement enterPincode;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[1]")
	WebElement genderList;

	@FindBy(xpath = "//*[@id='createUHID']")
	WebElement clickCreateButton;

	@FindBy(xpath = "//button[text()='View UHID List']")
	WebElement viewUHIDList;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setDOB(String requiredYear) {
		// open date picker
		clkDOBicon.click();
		// Wait for the yearsMenu to be clickable
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

	public void setPatientType() {
		patientType.click();

		selectPatientType.click();
	}

	public void setSponsorType() {
		selectSponsorType.click();
		chooseSponsorList.click();
	}

	public void setPhoneNo(String phNo) {
		enterTelephone.sendKeys(phNo);
	}

	public void setHouseNo() {
		enterHouseNo.sendKeys("12A");
	}

	public void setCountry() {
		selectCountry.click();

		// We wait the list of country available
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")));

		// Find all country list items
		List<WebElement> countriesList = driver.findElements(By.xpath(
				"//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li"));

		// Iterate through the list items in the dropdown and select the desired country

		for (WebElement country : countriesList) {
			if (country.getText().equals("India")) {
				country.click();
				break;
			}
		}

	}

	public void setcountryRegion() {
		selectcountryRegion.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")));
		// find all list items

		List<WebElement> regionsList = driver.findElements(By.xpath(
				"//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li"));

		for (WebElement regions : regionsList) {
			if (regions.getText().equals("Karnataka")) {
				regions.click();
				break;
			}
		}

	}

	public void setCityName() {
		selectCityName.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")));

		// find all city list items
		List<WebElement> cityList = driver.findElements(By.xpath(
				"//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li"));

		for (WebElement cities : cityList) {
			if (cities.getText().equals("Bengaluru")) {
				cities.click();
				break;
			}
		}

	}

	public void setStreetName(String streetName) {
		enterStreetName.sendKeys(streetName);
	}

	public void setPincode() {

		enterPincode.sendKeys(Keys.BACK_SPACE);
		enterPincode.sendKeys("560035");

	}

	public void setGender() {
		selectGender.click();
		genderList.click();
	}

	public void createButton() {
		clickCreateButton.click();
	}

	public void verifyUHIDAfterRegistration() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    try {
	        // Wait for success dialog
	        WebElement successDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']")));

	        // Extract UHID
	        WebElement uhidTextElement = successDialog.findElement(By.xpath("//p[contains(text(),'UHID:')]"));
	        String uhid = uhidTextElement.getText().split(":")[1].trim();
	        System.out.println("✅ Generated UHID: " + uhid);

	        // Click "View UHID List" button
	        driver.findElement(By.xpath("//button[contains(text(),'View UHID List')]")).click();

	        // Wait for UHID list to be visible
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'MuiDataGrid-columnHeaderTitle') and text()='Patient UHID']")));

	        // Verify UHID in the list
	        WebElement uhidInList = driver.findElement(By.xpath("//p[contains(@class, 'MuiTypography-body2') and contains(text(),'" + uhid + "')]"));

	        if (uhidInList.isDisplayed()) {
	            System.out.println("✅ The Registered UHID " + uhid + " is present in the UHID List.");
	        } else {
	            System.out.println("❌ The Registered UHID " + uhid + " is NOT found in the UHID List.");
	        }
	    } catch (Exception e) {
	        System.out.println("❌ Error: " + e.getMessage());
	        e.printStackTrace(); // Ensure error details are printed in the console
	    }
	}

}
