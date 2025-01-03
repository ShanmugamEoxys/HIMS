package testCases;


import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.opModule.TC_003_PatientRegisteration;
import testBase.BaseClass;

public class Patient_RegisterationTest extends BaseClass {

	@Test(groups = { "Sanity", "OP Module" })
	
	public void verify_PaitentRegisteration()
	{
		        
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkCategoryOpen();
		logger.info("clicked category menu successfully");
		hp.clkPatRegPage();

		TC_003_PatientRegisteration PatRegPage = new TC_003_PatientRegisteration(driver);

		// Page1
		PatRegPage.setPatientType();
		PatRegPage.setVisitForType();
		PatRegPage.setPatientName(randomString().toUpperCase(), randomString().toUpperCase());
		PatRegPage.setDOB("1998");
		PatRegPage.setMonth("March");
		PatRegPage.setDate("20");
		PatRegPage.setDrName(); // setDr name here i called.
		PatRegPage.setGender();
		PatRegPage.setPatientEmail(randomEmailFormat().toLowerCase());
		PatRegPage.setPhNo(randomNumber());
		PatRegPage.setCheckbox();
		PatRegPage.setPatientCategory();
		PatRegPage.setPatID(randomNumber());
		PatRegPage.setNextPage();
        //Page2
		PatRegPage.setHouseNo(randomHouseNo());
		PatRegPage.setHouseName(randomHouseName().toUpperCase());
		PatRegPage.setCountryAddress();
		PatRegPage.setCountryState();
		PatRegPage.setAddressCity();
		PatRegPage.setSameAddressBox();
		PatRegPage.setNextPage();
		//Page3
		PatRegPage.setOccupation();
		PatRegPage.setWorkOrganization();
		PatRegPage.setknownUs();
		PatRegPage.setConsultation();
		PatRegPage.setclkPhyCondition();
		PatRegPage.setPatRace();
		PatRegPage.setFatherSpouseName(randomString().toUpperCase());
		PatRegPage.setEmePhNo(randomNumber());
		PatRegPage.setSaveForm(); // final form submit
	}

}

