package pageObjects.warehouseModule;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Basepage;

public class TC_012_Item_Creation extends Basepage {

	public TC_012_Item_Creation(WebDriver driver) {
		super(driver);
	}

	private static final Logger logger = LogManager.getLogger(TC_013_AssignLocationAndSupplier.class);

	@FindBy(xpath = "//*[@class='MuiListItemText-root css-1nmt8ps']/span[contains(text(),'Item Creation')]")
	WebElement clkItemCreation;

	@FindBy(xpath = "(//a[@id='18_list_child_btn_sn_id'])[2]")
	WebElement itemCreaIcon;

	@FindBy(xpath = "(//*[@id='itemCategory'])[1]")
	WebElement clkItem;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> itemCategoryList;

	@FindBy(xpath = "//*[@id='itemName']")
	WebElement itemName;

	@FindBy(xpath = "//*[@id='dosageUnit']")
	WebElement doseUnit;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> dosageUnits;

	@FindBy(xpath = "//*[@id='genericName']")
	WebElement clkGeneric;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> genericLists;

	@FindBy(xpath = "//*[@id='dosageStrength']")
	WebElement doseStrength;

	@FindBy(xpath = "//*[@id='stockingType']")
	WebElement clkST;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> stockList;

	@FindBy(xpath = "//*[@id='manufacturer']")
	WebElement clkManufac;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> manufacLists;

	@FindBy(xpath = "//*[@id='purchaseType']")
	WebElement clkPurchase;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> typeLists;

	@FindBy(xpath = "//*[@id='Next_button']")
	WebElement next;

	// Page 2
	@FindBy(xpath = "//*[@id='storageLocation']")
	WebElement clkSchLoc;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> locaLists;

	@FindBy(xpath = "//*[@id='preferCarrierMode']")
	WebElement clkMode;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> modeLists;
	// Page 3

	@FindBy(xpath = "//*[@id='hsnCode']")
	WebElement hsnCode;

	@FindBy(xpath = "//*[@id='tax']")
	WebElement clkTax;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> taxSlaps;

	@FindBy(xpath = "//*[@id='buyersname']")
	WebElement clkBuyersName;

	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li")
	List<WebElement> buyersLists;

	@FindBy(xpath = "//*[@id='Save_button']")
	WebElement clkSave;


	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public void setOpenIC() {

		WebElement element = driver.findElement(By.xpath("//a[.//span[text()='Item Creation']]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	public void setItemCategory(String itemName) {
		clkItem.click();

		for (WebElement Itemlist : itemCategoryList) {
			if (Itemlist.getText().equalsIgnoreCase(itemName)) {
				Itemlist.click();
				break;
			}

		}

	}

	public void setItemName(String name) {
		itemName.sendKeys(name);
	}

	public void setdosageUnit(String dose) {
		// System.out.println("Inside dosage units");
		doseUnit.click();

		for (WebElement unit : dosageUnits) {
			// System.out.println("Inside dosage units for");
			if (unit.getText().equalsIgnoreCase(dose)) {
				// System.out.println("Inside dosage units if");
				unit.click();
				break;
			}
		}

	}

	public void setGenericName(String generic) {
		clkGeneric.click();

		for (WebElement genList : genericLists) {
			if (genList.getText().equalsIgnoreCase(generic)) {
				genList.click();
				break;
			}
		}

	}

	public void setDoseStrength(String dose) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dosageStrength']")));
		doseStrength.sendKeys(dose);
	}

	public void setStockType() {
		clkST.click();

		for (WebElement stocks : stockList) {
			if (stocks.getText().equalsIgnoreCase("sale and consumption")) {
				stocks.click();
				break;
			}
		}
	}

	public void setManufacturer() {
		clkManufac.click();

		for (WebElement list : manufacLists) {
			if (list.getText().equalsIgnoreCase("AARYAN ENTERPRISES")) {
				list.click();
				break;
			}
		}
	}

	public void setPurchase() {
		clkPurchase.click();

		for (WebElement purchaseList : typeLists) {
			if (purchaseList.getText().equalsIgnoreCase("Card")) {
				purchaseList.click();
				break;

			}
		}
		next.click();
	}

	public void setScheduleLocation() {
		wait.until(ExpectedConditions.elementToBeClickable(clkSchLoc));

		// Click the storage location dropdown
		try {
			clkSchLoc.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", clkSchLoc);
		}

		// Wait for the dropdown to load
		wait.until(ExpectedConditions.visibilityOfAllElements(locaLists));

		for (WebElement locList : locaLists) {
			if (locList.getText().equalsIgnoreCase("Rack")) {
				try {
					locList.click();
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", locList);
				}
				break;
			}
		}
	}

	public void setCarrierMode() {
		wait.until(ExpectedConditions.elementToBeClickable(clkMode));

		// Click the dropdown safely
		try {
			clkMode.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", clkMode);
		}

		// Wait for options to load
		wait.until(ExpectedConditions.visibilityOfAllElements(modeLists));

		for (WebElement modeList : modeLists) {
			if (modeList.getText().equalsIgnoreCase("By Road")) {
				try {
					modeList.click();
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", modeList);
				}
				break;
			}
		}

		next.click();
	}

	public void setHSNCode(String code) {

		wait.until(ExpectedConditions.visibilityOf(hsnCode));
		hsnCode.sendKeys(code);
	}

	public void setTax() {
		clkTax.click();

		for (WebElement slap : taxSlaps) {
			if (slap.getText().equalsIgnoreCase("GST 28%")) {
				slap.click();
				break;
			}
		}
	}

	public void setBuyerName() {
		clkBuyersName.click();

		for (WebElement buyerList : buyersLists) {
			if (buyerList.getText().equalsIgnoreCase("Harry")) {
				buyerList.click();
				break;
			}
		}
	}

	public void setSave() {
		clkSave.click();
	}
}
