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

public class TC_002_AddOrganization extends Basepage {

	public TC_002_AddOrganization(WebDriver driver) {
		super(driver); // Calls the constructor of Basepage
	}

	@FindBy(xpath = "//*[@data-testid='AddIcon']")
	WebElement clkAddOrgbtn;

	@FindBy(xpath = "//*[@id='orgName']")
	WebElement enterOrgName;

	@FindBy(xpath = "//*[@id='orgEmail']")
	WebElement enterOrgEmail;

	@FindBy(xpath = "//*[@id='orgContact']")
	WebElement enterOrgNo;

	@FindBy(xpath = "//*[@id='orgAddress']")
	WebElement enterOrgAddress;

	@FindBy(xpath = "//*[@name='orgCountry']")
	WebElement selectCountry;

	@FindBy(xpath = "//*[contains(@class,'MuiAutocomplete-listbox')]/li")
	WebElement chooseCountryName;

	@FindBy(xpath = "//*[@id='orgState']")
	WebElement selectcountryState;
	// *[@id='mui-component-select-patientAddressCurrentCity']
	@FindBy(xpath = "//*[@id='orgCity']")
	WebElement selectCityName;

	@FindBy(xpath = "//*[@id='orgPOcode']")
	WebElement enterPostalCode;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement clkSubmitButton;

	@FindBy(xpath = "//*[contains(@class,'go2072408551')]//div[text()='Organization added successfully']")
	WebElement toasterMsg;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void setAddOrgbtn() {
		wait.until(ExpectedConditions.elementToBeClickable(clkAddOrgbtn));
		clkAddOrgbtn.click();

	}

	public void setOrgName(String orgname) {
		enterOrgName.sendKeys(orgname);
	}

	public void setOrgEmail(String orgEmail) {
		enterOrgEmail.sendKeys(orgEmail + "@gmail.com");
	}

	public void setOrgContact(String orgCont) {
		enterOrgNo.sendKeys(orgCont);
	}

	public void setOrgAddress(String orgaddress) {
		enterOrgAddress.sendKeys(orgaddress);
	}

	public void setCountry() {
		selectCountry.click();

		// We wait the list of country available
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@class,'MuiAutocomplete-listbox')]/li")));

		// Find all country list items
		List<WebElement> countriesList = driver
				.findElements(By.xpath("//*[contains(@class,'MuiAutocomplete-listbox')]/li"));

		// Iterate through the list items in the dropdown and select the desired country

		for (WebElement country : countriesList) {
			if (country.getText().equals("India")) {
				country.click();
				break;
			}
		}

	}

	public void setcountryRegion() {
		selectcountryState.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'MuiList-root MuiList-padding')]/li")));
		// find all list items

		List<WebElement> regionsList = driver
				.findElements(By.xpath("//*[contains(@class,'MuiList-root MuiList-padding')]/li"));

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
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@aria-labelledby,'orgCity-label')]/li")));

		// find all city list items
		List<WebElement> cityList = driver.findElements(By.xpath("//*[contains(@aria-labelledby,'orgCity-label')]/li"));

		for (WebElement cities : cityList) {
			if (cities.getText().equals("Bengaluru")) {
				cities.click();
				break;
			}
		}

	}

	public void setPostalCode() {
		enterPostalCode.sendKeys("560035");
	}

	public void setSubmit() {
		clkSubmitButton.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(toasterMsg)); // Wait for message

			String actualMessage = toasterMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Organization added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Add Organization Test Failed");

			System.out.println("✅ Add Organization Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in Add Organization Test: " + e.getMessage());
			Assert.fail("❌ Add Organization Test Failed due to an unexpected error.");
		}
	}
}