package testCases.ADMIN.MASTERS;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_005_AddDepartments;
import testBase.BaseClass;

public class AddDepartmentsTest extends BaseClass {

	@Test(groups = { "Sanity", "ADMIN Module" })
	public void verifyAddDepartment() {
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();
		
		TC_005_AddDepartments addDep = new TC_005_AddDepartments(driver);
		addDep.setDep();
		hp.clkMenuClose();
		addDep.setAddDep();
		addDep.setDepName(randomString().toUpperCase());
		addDep.setOrgList();
		addDep.setDepSubmit();
		
	}
}
