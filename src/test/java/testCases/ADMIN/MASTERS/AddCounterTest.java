package testCases.ADMIN.MASTERS;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_011_AddCounter;
import testBase.BaseClass;

public class AddCounterTest extends BaseClass {

	@Test( groups = { "Sanity", "ADMIN Module" })
	public void verifyAddCounters() {
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();

		TC_011_AddCounter addCounter = new TC_011_AddCounter(driver);
		addCounter.setCounter();
		hp.clkMenuClose();
		addCounter.openAddCounter();
		addCounter.setCounterName(randomString().toUpperCase());
		addCounter.setFloor();
		addCounter.setPatientType();
		addCounter.setSubmit();

	}

	
}
