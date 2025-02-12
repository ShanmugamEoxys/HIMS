package testCases.Warehouse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.warehouseModule.TC_012_Item_Creation;
import pageObjects.warehouseModule.TC_013_AssignLocationAndSupplier;
import testBase.BaseClass;

public class Item_Creation_Test extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@DataProvider(name = "dosageUnits")
	public Object[][] getDosageData() {
		return new Object[][] { { "100mg" }

		};
	}

	@Test(dataProvider = "dosageUnits", groups = { "Sanity", "Warehouse Module" })
	public void verifyItemCreation(String dosage) throws InterruptedException {
		driver.navigate().refresh();
		Homepage hp = new Homepage(driver);
		hp.openWH();

		TC_012_Item_Creation itemcre = new TC_012_Item_Creation(driver);
		itemcre.setOpenIC();
		itemcre.setItemCategory("Category 1");
		itemcre.setItemName(randomString().toUpperCase());
		itemcre.setdosageUnit(dosage);
		itemcre.setGenericName("Generic1");
		itemcre.setDoseStrength(randomFloorNo());
		itemcre.setStockType();
		itemcre.setManufacturer();
		itemcre.setPurchase();
		// Page 2
		itemcre.setScheduleLocation();
		itemcre.setCarrierMode();
		// Page 3
		itemcre.setHSNCode("HSN" + randomBedCharge()); // 4 digit no randomly pass
		itemcre.setTax();
		itemcre.setBuyerName();
		itemcre.setSave();

		// cont... of location and supplier
		TC_013_AssignLocationAndSupplier locationup = new TC_013_AssignLocationAndSupplier(driver);
		locationup.setOpenLocSup();
		locationup.setAddSupp();
		locationup.setSelectSupplier();
		String purchaseRate = randomBedCharge(); // Example: "4000"
		String mrpValue = String.valueOf(Integer.parseInt(purchaseRate) + 5);
		locationup.setPurchaseRate(purchaseRate);
		locationup.setMRP(mrpValue, purchaseRate); // This will ensure MRP is at least 5 more than purchase rate
		locationup.setTax();

		// from date
		locationup.setFromDOB("2025");
		locationup.setFromMonth("January");
		locationup.setFromDate("7");
//		// to date
		Thread.sleep(1000);

		locationup.setToDOB("2025");
		locationup.setToMonth("February");
		locationup.setToDate("15");
//		
		locationup.setAddSupplier();

		// 2.AddWarehouseDetails
		locationup.setclkToOpenWarehouseDetails();
		locationup.SelectWarehouse("Warehouse1");
		// Generate Random Min Value
		String minValue = randomOrderValue();
		locationup.setMinValue(minValue);
		// Generate Random Reorder Value
		int reorderValue = Integer.parseInt(minValue);
		locationup.setReorderValue(String.valueOf(reorderValue));
		// Generate Random Max Value
		int maxValue = reorderValue + 5;
		locationup.setMaxValue(String.valueOf(maxValue));
		locationup.setTax();
		locationup.setAddWarehouseDetails(); // Submit Warehouse Details.

		// Add Counter Details
		locationup.clickAddCounterDetails();
		locationup.setCounter("IBZCCBU");

		//Generate Random Min Count Value
		String minCountVal = randomOrderValue();
        locationup.setCounterMinValue(minCountVal);

        //Generate Counter Reorder value
        int reorderCountValue = Integer.parseInt(minCountVal);
        locationup.setCounterReorder(String.valueOf(reorderCountValue));
        
        //Generate Counter Max Value
		
        int maxCountValue = reorderCountValue + 20;
        locationup.setCounterMax(String.valueOf(maxCountValue));
		
		//Submit Counter Details
        locationup.submitCounterDetails();
        //Assign Item
        locationup.setAssignItem();
		
	}

	
}
