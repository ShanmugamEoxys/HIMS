package testCases.ADMIN.MASTERS;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_009_AddBedMasters;
import testBase.BaseClass;

public class AddBedMastersTest extends BaseClass {

	@Test(groups = { "Sanity", "ADMIN Module" })
	public void verifyAddBedMasters() {

		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();

		TC_009_AddBedMasters addBedMasters = new TC_009_AddBedMasters(driver);
		addBedMasters.setOpenBM();
		hp.clkMenuClose();
		
//		//Link Bed
		
		addBedMasters.setOpenLinkBed();
		addBedMasters.setBedNo(randomFloorNo());
		addBedMasters.setBedType();
		addBedMasters.setBedStatus();
		addBedMasters.bedStatusReason(randomString().toUpperCase());
		addBedMasters.submitLinkBedForm();

		// AddBedTypes
		addBedMasters.setAddBedType();
		addBedMasters.setBedTypeName(randomString().toUpperCase());
		addBedMasters.setBedCharge(randomBedCharge());
		addBedMasters.setDOB("2025");
		addBedMasters.setMonth("May");
		addBedMasters.setDate("10");
		addBedMasters.SubmitBedType();
		
		// Bed List
		addBedMasters.setBedList();
		addBedMasters.setBedNum(randomFloorNo());
		addBedMasters.setBedTypes();
		addBedMasters.setRoomNo();
		addBedMasters.setStatus();
		addBedMasters.setSubmitBed();

	}

}
