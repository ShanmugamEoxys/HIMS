package testCases;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_002_AddOrganization;
import testBase.BaseClass;

public class AddOrganizationTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verifyAddOrganization() {
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();

		TC_002_AddOrganization addOrg = new TC_002_AddOrganization(driver);
		addOrg.setAddOrgbtn();
		addOrg.setOrgName(randomString().toUpperCase());
		addOrg.setOrgEmail(randomAlphaNumeric());
		addOrg.setOrgContact(randomNumber());
		addOrg.setOrgAddress(randomAlphaNumeric1());
		addOrg.setCountry();
		addOrg.setcountryRegion();
		addOrg.setCityName();
		addOrg.setPostalCode();
		addOrg.setSubmit();
	}

}
