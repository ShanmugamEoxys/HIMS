package pageObjects.adminModule.MasterList;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.Basepage;

public class TC_008_AddRooms extends Basepage {

	public TC_008_AddRooms(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	@FindBy(xpath = "//*[contains(text(),'Rooms')]")
	WebElement openRooms;

	// Room Type
	@FindBy(xpath = "//*[contains(text(),'Room Types')]")
	WebElement openRoomType;

	@FindBy(xpath = "//*[contains(text(),' Add Room Type')]")
	WebElement clkAddRoomType;

	@FindBy(xpath = "//*[@id='roomType']")
	WebElement enterRoomType;

	@FindBy(xpath = "//*[@id='numOfBeds']")
	WebElement enterNoOfBeds;

	@FindBy(xpath = "//*[@id='amenities']")
	WebElement clkAmenities;

	@FindBy(xpath = "//*[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters')]//input[@type='checkbox']")
	List<WebElement> checkboxes;

	@FindBy(xpath = "//*[@id='acSts_form_control_label']")
	WebElement enableStatus;

	@FindBy(xpath = "//*[contains(@class, 'MuiTypography-root')]")
	WebElement outsideElement;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//*[contains(@class,'go2072408551')]//div[text()='RoomType added successfully']")
	WebElement roomTypeMsg;
	// RoomList
	@FindBy(xpath = "//*[contains(text(),'Room List')]")
	WebElement openRoomList;

	@FindBy(xpath = "//*[contains(text(),' Add Room')]")
	WebElement openRoom;

	@FindBy(xpath = "//*[@id='roomNo']")
	WebElement roomNo;

	@FindBy(xpath = "//*[@name='roomTypeId']")
	WebElement roomType;

	@FindBy(xpath = "//*[contains(@class,'MuiBox-root css-nx7py2')]/li")
	List<WebElement> roomTypeList;

	@FindBy(xpath = "//*[@name='ladId']")
	WebElement clkLocation;

	@FindBy(xpath = "//*[contains(@class,'MuiBox-root css-nx7py2')]/li")
	List<WebElement> slctLocation;

	@FindBy(xpath = "//*[@name='wardId']")
	WebElement clkWard;

	@FindBy(xpath = "//*[contains(@class,'MuiAutocomplete-listbox')]/li")
	List<WebElement> slctWardList;

	@FindBy(xpath = "//*[@name='deptId']")
	WebElement clkDepartment;

	@FindBy(xpath = "//*[contains(@class,'MuiBox-root css-nx7py2')]/li")
	List<WebElement> departmentLists;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement add;

	@FindBy(xpath = "//*[contains(@class,'go2072408551')]//div[text()='Room added successfully']")
	WebElement roomListMsg;

	public void setOpenRoom() {
		openRooms.click();
	}

	public void setOpenRoomTypes() {

		wait.until(ExpectedConditions.visibilityOf(openRoomType));
		openRoomType.click();
		clkAddRoomType.click();
	}

	public void setRoomTypeName(String name) {
		enterRoomType.sendKeys(name);
	}

	public void setBedNo(String bedsnos) {
		enterNoOfBeds.sendKeys(bedsnos);
	}

	public void setAmenities() {
		clkAmenities.click();

//		for(int i=0;i<checkboxes.size();i++) {
//			checkboxes.get(i).click();
//		}

//		for (WebElement checkbox : checkboxes) {
//			checkbox.click();
//		}

		// total no checkboxes -how many checkboxes want to select=starting index
		// 7-3=4(Starting index) //select last 3 checkboxes
//		for(int i=4;i<checkboxes.size();i++)
//		{
//			checkboxes.get(i).click();
//		}

		// select first 3 checkboxes
		for (int i = 0; i < 3; i++) {
			checkboxes.get(i).click();
		}

		Actions actions = new Actions(driver);
		actions.click(outsideElement).click().perform(); // move cursor and click outside
	}

	public void setActiveStatus() {
		enableStatus.click();
	}

	public void setSubmit() {
		submit.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(roomTypeMsg)); // Wait for message

			String actualMessage = roomTypeMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "RoomType added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ RoomType Added Test Failed");

			System.out.println("✅ RoomType Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in RoomType Test: " + e.getMessage());
			Assert.fail("❌ RoomType Added Test Failed due to an unexpected error.");
		}
	}

	// Room List
	public void setOpenRoomList() {
		openRoomList.click();
	}

	public void setOpenAddRoom() {
		openRoom.click();
	}

	public void setRoomNo(String no) {
		roomNo.sendKeys(no);
	}

	public void setRoomType() {
		roomType.click();

		for (WebElement roomlist : roomTypeList) {

			if (roomlist.getText().equalsIgnoreCase("Normal")) {
				roomlist.click();
				break;
			}
		}
	}

	public void setRoomLocation() {
		clkLocation.click();

		for (WebElement location : slctLocation) {
			if (location.getText().equalsIgnoreCase("Bengaluru")) {
				location.click();
				break;
			}
		}

	}

	public void setRoomWard() {
		clkWard.click();

		for (WebElement ward : slctWardList) {
			if (ward.getText().equalsIgnoreCase("VYKMWCB - 6 Floor")) {
				ward.click();
				break;
			}
		}
	}

	public void setDepartment() {
		clkDepartment.click();

		for (WebElement departments : departmentLists) {
			if (departments.getText().equalsIgnoreCase("TQDTLCQ")) {
				departments.click();
				break;
			}
		}

	}

	public void setRoomSubmit() {
		add.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(roomListMsg)); // Wait for message

			String actualMessage = roomListMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Room added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Counter Added Test Failed");

			System.out.println("✅ RoomList Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in RoomList Test: " + e.getMessage());
			Assert.fail("❌ RoomList Added Test Failed due to an unexpected error.");
		}
	}

}
