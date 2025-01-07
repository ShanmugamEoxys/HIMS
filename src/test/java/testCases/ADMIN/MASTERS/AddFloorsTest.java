package testCases.ADMIN.MASTERS;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_006_AddFloors;
import testBase.BaseClass;

public class AddFloorsTest extends BaseClass {

	@Test(groups = { "Sanity", "ADMIN Module" })
	public void verifyAddFloors()
	{
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();
		
		TC_006_AddFloors addFlr = new TC_006_AddFloors(driver);
		addFlr.setFlrCate();
		hp.clkMenuClose();
		addFlr.setAddFloor();
		addFlr.setFloor(randomFloorNo());
		addFlr.setSubmitFloor();
		
	}
}
