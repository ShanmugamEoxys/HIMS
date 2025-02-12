package pageObjects.warehouseModule;

import java.time.Duration;
import java.util.List;

import javax.swing.JScrollBar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Basepage;

public class TC_013_AssignLocationAndSupplier extends Basepage {

	public TC_013_AssignLocationAndSupplier(WebDriver driver) {
		super(driver);

	}

	private static final Logger logger = LogManager.getLogger(TC_013_AssignLocationAndSupplier.class);

	@FindBy(xpath = "//*[contains(text(),'Assign Location And Supplier')]")
	WebElement clkLocSup;

	// Add Supplier
	@FindBy(xpath = "//*[@id='Add Supplier_button']")
	WebElement clkAddSupp;

	@FindBy(xpath = "//*[@id='supplierCode']")
	WebElement clkSeleSupp;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> supplierLists;

	@FindBy(xpath = "//*[@id='purchaseRate']")
	WebElement purRate;

	@FindBy(xpath = "//*[@id='mrp']")
	WebElement mrpField;

	@FindBy(xpath = "//*[@id='tax']")
	WebElement clkTax;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> taxSlaps;

	@FindBy(xpath = "//label[text()='Effective From']/following-sibling::div//button")
	WebElement fromDateInput;

	@FindBy(xpath = "//label[text()='Effective To']/following-sibling::div//button")
	WebElement toDateInput;

	@FindBy(xpath = "//*[@id='UpdateSuplierId_button']")
	WebElement supplierAdd;

	@FindBy(xpath = "//button[@aria-label='Choose date']")
	WebElement clkDOBicon;

	@FindBy(xpath = "//button[@aria-label='calendar view is open, switch to year view']")
	WebElement yearsMenu;

	@FindBy(xpath = "//*[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall MuiPickersCalendarHeader-switchViewButton')]")
	WebElement yearOpen;

	@FindBy(xpath = "//*[contains(@class,'MuiYearCalendar-root')]//div")
	List<WebElement> years;

	@FindBy(xpath = "//div[contains(@class,'MuiPickersCalendarHeader-label')]")
	WebElement monthsDisplay;

	@FindBy(xpath = "//button[@title='Previous month']")
	WebElement prevMonthButton;

	@FindBy(xpath = "//button[@title='Next month']")
	WebElement afterNextMonth;

	@FindBy(xpath = "//button[@role='gridcell']")
	List<WebElement> dates;

	// 2.Add WareHouseDetails
	@FindBy(css = "button[id='Add Warehouse Details_button']")
	WebElement clkWarehouseDetails;

	@FindBy(id = "warehouse")
	WebElement clkSlctWarehouse;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	List <WebElement> warehouselist;
	
	@FindBy(xpath = "//input[@id='min']")
	WebElement minValue;
	
	@FindBy(xpath = "//input[@id='reorder']")
	WebElement reorderValue;
	
	@FindBy(xpath = "//input[@id='maxLevel']")
	WebElement maxValue;
	
	@FindBy(xpath = "//button[@id='UpdateSuplierId_button']")
	WebElement addWarehouse;
	
	//3. Add CounterDetails
	@FindBy(id="Add Counter  Details_button")
	WebElement addCounterDetailsButton;
	
	@FindBy(id="warehouse")
	WebElement clickWarehouse;
	
	@FindBy(xpath = "//ul[@role='listbox']/li")
	List <WebElement> counterLists;
	
	@FindBy(xpath = "//input[@name='minLevel']")
	WebElement counterMinValue;
	
	@FindBy(xpath = "//input[@id='reorder']")
	WebElement counterReorderValue;
	
	@FindBy(xpath = "//input[@id='max']")
	WebElement counterMaxValue;
	
	@FindBy(css = "button[type='submit']")
	WebElement savecounterDetails;
	
	@FindBy(id="Create-Item-Warehouse_button")
	WebElement assignItem;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

	Actions action = new Actions(driver);

	public void setOpenLocSup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clkLocSup);

		// clkLocSup.click();
	}

	public void setAddSupp() {
		clkAddSupp.click();

	}

	public void setSelectSupplier() {
		clkSeleSupp.click();

		for (WebElement suppList : supplierLists) {
			if (suppList.getText().equalsIgnoreCase("Supplier1")) {
				suppList.click();
				break;
			}
		}
	}

	public void setPurchaseRate(String rate) {
		purRate.sendKeys(Keys.CONTROL + "a"); // select all text
		purRate.sendKeys(Keys.BACK_SPACE);
		purRate.sendKeys(rate);

	}

	public void setMRP(String mrpvalue, String rate) {
		double purchaseRate = Double.parseDouble(rate);
		double mrp;

		// If mrp value is empty or invalid, set it to at least 5 more than purchase
		// rate
		if (mrpvalue == null || mrpvalue.isEmpty()) {
			mrp = purchaseRate + 5; // Ensure MRP is 5 more than purchase rate
		} else {
			mrp = Double.parseDouble(mrpvalue);
			if (mrp <= purchaseRate) {
				mrp = purchaseRate + 5; // Adjust if it's less than or equal to purchase rate
			}
		}

		mrpField.sendKeys(Keys.CONTROL + "a");
		mrpField.sendKeys(Keys.BACK_SPACE);
		mrpField.sendKeys(mrpvalue);

	}

	public void setTax() {
		clkTax.click();

		for (WebElement slap : taxSlaps) {
			if (slap.getText().equalsIgnoreCase("IGST 18%")) {
				action.doubleClick(slap).perform();
				break;
			}
		}
	}

	public void setFromDOB(String requiredYear) {
		// ✅ Step 1: Ensure the date picker is visible before clicking
		WebElement dateField = driverWait.until(ExpectedConditions.elementToBeClickable(fromDateInput));

		// ✅ Step 2: Click the date field using JavaScript to avoid overlay issues
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateField);

		// ✅ Step 3: Wait for the year menu to be visible and clickable
		WebElement yearMenu = driverWait.until(ExpectedConditions.elementToBeClickable(yearsMenu));
		js.executeScript("arguments[0].click();", yearMenu);

		// ✅ Step 4: Re-fetch the list of years to avoid StaleElementReferenceException
		List<WebElement> yearElements = driver
				.findElements(By.xpath("//*[contains(@class,'MuiYearCalendar-root')]//div"));

//        // Iterate through the list of years and select the required year
		for (WebElement year : yearElements) {
			// if text of the year matches with the required year
			if (year.getText().equals(requiredYear)) {
				action.doubleClick(year).build().perform();
				// year.click();
				break;
			}

		}
	}

	public void setFromMonth(String requiredMonth) {
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait for the month display element to be visible
			monthsDisplay = wait.until(ExpectedConditions.visibilityOf(monthsDisplay));

			// Loop until the displayed month matches the required month
			while (!monthsDisplay.getText().contains(requiredMonth)) {
				// Click the "Previous month" button to navigate
				prevMonthButton = wait.until(ExpectedConditions.elementToBeClickable(prevMonthButton));
				// afterNextMonth.click();
				prevMonthButton.click();
				// Wait for the month display to update
				monthsDisplay = wait.until(ExpectedConditions.visibilityOf(monthsDisplay));

			}
		}
	}

	public void setFromDate(String requiredDate) {
		for (WebElement date : dates) {
			if (date.getText().equals(requiredDate)) {
				action.doubleClick(date).build().perform();
				// date.click();
				break;
			}
		}
	}

	public void setToDOB(String requiredYear) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// ✅ Step 1: Ensure the date picker is visible before clicking
		WebElement toDateField = driverWait.until(ExpectedConditions.elementToBeClickable(toDateInput));

		// ✅ Step 3: Click the field using JavaScript to avoid overlays
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", toDateField);

		// ✅ Step 4: Wait for the year dropdown to be clickable
		WebElement yearMenu = wait.until(ExpectedConditions.elementToBeClickable(yearsMenu));
		js.executeScript("arguments[0].click();", yearMenu);

		// ✅ Step 4: Re-fetch the list of years to avoid StaleElementReferenceException
		List<WebElement> yearElements = driver
				.findElements(By.xpath("//*[contains(@class,'MuiYearCalendar-root')]//div"));

//        // Iterate through the list of years and select the required year
		for (WebElement year : yearElements) {
			// if text of the year matches with the required year
			if (year.getText().equals(requiredYear)) {
				action.doubleClick(year).build().perform();
				// year.click();
				break;
			}

		}

	}

	public void setToMonth(String requiredMonth) {
		{

			// Wait for the month display element to be visible
			monthsDisplay = driverWait.until(ExpectedConditions.visibilityOf(monthsDisplay));

			// Loop until the displayed month matches the required month
			while (!monthsDisplay.getText().contains(requiredMonth)) {
				// Click the "Previous month" button to navigate
				afterNextMonth = driverWait.until(ExpectedConditions.elementToBeClickable(afterNextMonth));
				afterNextMonth.click();
				// prevMonthButton.click();
				// Wait for the month display to update
				monthsDisplay = driverWait.until(ExpectedConditions.visibilityOf(monthsDisplay));

			}
		}
	}

	public void setToDate(String requiredDate) {
		for (WebElement date : dates) {
			if (date.getText().equals(requiredDate)) {
				action.doubleClick(date).build().perform();
				// date.click();
				break;
			}
		}
	}

	public void setAddSupplier() {
		supplierAdd.click();
		js.executeScript("arguments[0].scrollIntoView(true);", clkWarehouseDetails);
	}

	
	
	// 2. Add Warehouse Details

	public void setclkToOpenWarehouseDetails() {
		//clkWarehouseDetails.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clkWarehouseDetails);
	}

	public void SelectWarehouse(String warehouseName) {
		clkSlctWarehouse.click();
		
		for(WebElement warehouselist:warehouselist) {
			if(warehouselist.getText().equalsIgnoreCase(warehouseName)) {
				warehouselist.click();
				break;
			}
		}
		
		
	}
	
	public void setMinValue(String min) {
		//minValue.sendKeys(Keys.CONTROL+ "a");
		minValue.sendKeys(Keys.BACK_SPACE);
		minValue.sendKeys(min);
	}
	
	public void setReorderValue(String min) {
		int minVal = Integer.parseInt(min);
		int reorderVal = minVal+5;
		
		reorderValue.sendKeys(Keys.BACK_SPACE);
		reorderValue.sendKeys(String.valueOf(reorderVal));
		
	}
	
	public void setMaxValue(String reorder) {
		int reorderVal = Integer.parseInt(reorder);
		int maxVal = reorderVal+5;
		
		maxValue.sendKeys(Keys.BACK_SPACE);
		maxValue.sendKeys(String.valueOf(maxVal));
	}
	
	public void setAddWarehouseDetails() {
		addWarehouse.click();
	}
	
	public void clickAddCounterDetails() {
		addCounterDetailsButton.click();
		js.executeScript("arguments[0].scrollIntoView(true);", addCounterDetailsButton);
		
	}
	
	public void setCounter(String counter) {
		clickWarehouse.click();
		
		for(WebElement counterList:counterLists) {
			if(counterList.getText().equalsIgnoreCase(counter)) {
				counterList.click();
				break;
			}
		}
		
	}
	
	public void setCounterMinValue(String min) {
		counterMinValue.sendKeys(Keys.BACK_SPACE);
		counterMinValue.sendKeys(min);
	}
	
	public void setCounterReorder(String min) {
		int minVal = Integer.parseInt(min);
		int reorderValue = minVal+10;
		
		counterReorderValue.sendKeys(Keys.BACK_SPACE);
		counterReorderValue.sendKeys(String.valueOf(reorderValue));
	}
	
	public void setCounterMax(String reorder) {
	
		int reorderValue = Integer.parseInt(reorder);
		int maxCounterVal = reorderValue+20;
		
		counterMaxValue.sendKeys(Keys.BACK_SPACE);
		counterMaxValue.sendKeys(String.valueOf(maxCounterVal));
		
	}
	
	public void  submitCounterDetails() {
		savecounterDetails.click();

	}
	
	public void setAssignItem() {
		driverWait.until(ExpectedConditions.visibilityOf(assignItem));
		assignItem.click();

	}
}
