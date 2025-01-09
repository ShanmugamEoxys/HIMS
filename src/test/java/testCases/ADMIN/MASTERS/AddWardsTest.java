package testCases.ADMIN.MASTERS;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_007_AddWards;
import testBase.BaseClass;

public class AddWardsTest extends BaseClass {

	@Test(groups= {"Sanity","ADMIN Module"})
	public void verifyAddWards() {
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();
		
		TC_007_AddWards addWard = new TC_007_AddWards(driver);
		addWard.setWardOpen();
		hp.clkMenuClose();
		addWard.setAddWard();
		addWard.setWardName(randomString().toUpperCase());
		addWard.setWardLocation();
		addWard.setWardFloor();
		addWard.setAddNewWard();
	}

}
