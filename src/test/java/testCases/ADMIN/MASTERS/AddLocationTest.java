package testCases.ADMIN.MASTERS;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_004_AddLocation;
import testBase.BaseClass;

public class AddLocationTest extends BaseClass {

	@Test(groups= {"Sanity","ADMIN Module"})
	public void verifyAddLocation()
	{
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();
		
		TC_004_AddLocation addLoc = new TC_004_AddLocation(driver);
		addLoc.setAddLoc();
		hp.clkMenuClose();
		addLoc.setAddLocOpen(); //Entering the Add location fields
		addLoc.setLocName(randomString().toUpperCase());
		addLoc.setOrgList();
		addLoc.setAdd();
	}
}
