package testCases.ADMIN.MASTERS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_004_AddLocation;
import testBase.BaseClass;

public class AddLocationTest extends BaseClass {

	@Test( dataProvider = "Organization", groups = { "Sanity", "ADMIN Module" })
	public void verifyAddLocation(String orgName) {
		System.out.println("Running test with Organization: " + orgName); // Debugging

		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();

		TC_004_AddLocation addLoc = new TC_004_AddLocation(driver);
		addLoc.setAddLoc();
		hp.clkMenuClose();
		addLoc.setAddLocOpen(); // Entering the Add location fields
		addLoc.setLocName(randomString().toUpperCase());
		addLoc.setOrgList(orgName);
		addLoc.setAdd();
	}

//	@DataProvider(name = "orgData")
//    public Object[][] getOrgData() {
//        return new Object[][] { 
//            { "CIANUDI" }, 
//            { "OMBEXPG" }, 
//            { "RFJKFTW" } 
//        };
//    }

	@DataProvider(name = "Organization")
	Object[][] orgData() {
		Object data[][] = {

				{ "CIANUDI" },

		};
		return data;
	}
}
