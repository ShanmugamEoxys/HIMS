package testCases.ADMIN.MASTERS;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_010_AddIDProofs;
import testBase.BaseClass;

public class AddIDProofTest extends BaseClass {

	@Test(groups = { "Sanity", "ADMIN Module" })
	public void verifyAddID_Proofs() {

		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();
		
		TC_010_AddIDProofs idProof = new TC_010_AddIDProofs(driver);
		idProof.setIDProof();
		hp.clkMenuClose();
		idProof.setOpenIDProof();
		idProof.setIDName(randomString().toUpperCase());
		idProof.setNoDigits(randomFloorNo());
		idProof.setSubmit();
		
	}

}
