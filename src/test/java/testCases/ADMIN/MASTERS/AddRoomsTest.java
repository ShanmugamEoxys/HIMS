package testCases.ADMIN.MASTERS;

import java.util.Arrays;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.adminModule.MasterList.TC_008_AddRooms;
import testBase.BaseClass;

public class AddRoomsTest extends BaseClass {

	@Test(groups={"Sanity","ADMIN Module"})
	public void verifyAddRooms()
	{
		Homepage hp = new Homepage(driver);
		hp.clkMenuopen();
		hp.clkAdmincategory();
		
		TC_008_AddRooms addRooms = new TC_008_AddRooms(driver);
		addRooms.setOpenRoom();
		hp.clkMenuClose();
		
		//Room Types
		addRooms.setOpenRoomTypes();
		addRooms.setRoomTypeName(randomString().toUpperCase());
		addRooms.setBedNo(randomFloorNo());
		addRooms.setAmenities();
		addRooms.setActiveStatus();
		addRooms.setSubmit();
		//Room List
		addRooms.setOpenRoomList();
		addRooms.setOpenAddRoom();
		addRooms.setRoomNo(randomFloorNo());
		addRooms.setRoomType();
		addRooms.setRoomLocation();
		addRooms.setRoomWard();
		addRooms.setDepartment();
		addRooms.setRoomSubmit();
	}
	
}
