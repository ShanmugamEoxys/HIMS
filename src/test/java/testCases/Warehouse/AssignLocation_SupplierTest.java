package testCases.Warehouse;

import pageObjects.warehouseModule.TC_013_AssignLocationAndSupplier;
import testBase.BaseClass;

public class AssignLocation_SupplierTest extends BaseClass{

	
	public void verifySupplierandLocation() {
		
		TC_013_AssignLocationAndSupplier locsup = new TC_013_AssignLocationAndSupplier(driver);
		locsup.setOpenLocSup();
		
		
		
	}

	
}
