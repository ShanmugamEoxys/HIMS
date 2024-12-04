package testCases;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.opModule.TC_001_UHID_Creation;
import testBase.BaseClass;

public class UHID_CreationTest extends BaseClass {

	@Test(groups={"Regression" ,"Master"} )
	public void verify_UHID_Registeration() {

		logger.info("*******Starting TC001_UHID Registeration Test******");
		
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		logger.info("***Cliked on Menuopenbutton*****");
		hp.clkCategoryOpen();
		logger.info("****Clicked on Categorybutton****");
		hp.clkUHIDReg();
        logger.info("****Clicked on UHIDRegbutton*****");
        
		TC_001_UHID_Creation UHID_Page = new TC_001_UHID_Creation(driver);

		logger.info("Providing Patient Details....");
		UHID_Page.setFirstName(randomString().toUpperCase());
		UHID_Page.setLastName(randomString().toUpperCase());
		UHID_Page.setDOB("1999");
		UHID_Page.setMonth("January");
		UHID_Page.setDate("24");
		UHID_Page.setPatientType();
		UHID_Page.setSponsorType();
		UHID_Page.setPhoneNo(randomNumber());
		UHID_Page.setHouseNo();
		UHID_Page.setCountry();
		UHID_Page.setcountryRegion();
		UHID_Page.setCityName();
		UHID_Page.setStreetName(randomAlphaNumeric());
		UHID_Page.setPincode();
		UHID_Page.setGender();
		UHID_Page.createButton();
		logger.info("Validating the UHID.....");
        UHID_Page.verifyUHIDAfterRegistration();
		logger.info("Finished TC_001 UHIDRegisteration Test.....");
	}

}
