package pageObjects.adminModule.MasterList;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.Basepage;

public class TC_007_AddWards extends Basepage {

	public TC_007_AddWards(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//*[contains(text(),'Wards')]")
	WebElement openWard;

	@FindBy(xpath = "//*[contains(text(),' Add Ward')]")
	WebElement clkAddWard;

	@FindBy(xpath = "//*[@id='wardName']")
	WebElement wardName;

	@FindBy(xpath = "//*[@name='ladId']")
	WebElement wardLoc;

	@FindBy(xpath = "//*[contains(@class,'MuiAutocomplete-listbox')]")
	WebElement wardList;

	@FindBy(xpath = "//*[@id='floorId']")
	WebElement clkFloor;
	
	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]")
	WebElement slctFloorList;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement clkAddtbn;
	
	@FindBy(xpath = "//*[contains(@class,'go2072408551')]//div[text()='Ward added successfully']")
	WebElement wardsMsg;
	
	WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public void setWardOpen() {
		openWard.click();
	}

	public void setAddWard() {
		clkAddWard.click();
	}

	public void setWardName(String name) {
		wardName.sendKeys(name);
	}

	public void setWardLocation() {
		wardLoc.click();

		List<WebElement> wardLocation = wardList.findElements(By.tagName("li"));
		for (WebElement wardLocationsList : wardLocation) {
			if (wardLocationsList.getText().equalsIgnoreCase("Bengaluru")) {
				wardLocationsList.click();
				break;
			}
		}

	}

	public void setWardFloor() {
		clkFloor.click();
		
	List<WebElement>floorsList=slctFloorList.findElements(By.tagName("li"));
	
	for(WebElement floorList:floorsList)
	{
		if(floorList.getText().equalsIgnoreCase("3"));
		{
			floorList.click();
			break;
		}
		
	}
		
	}
	
	public void setAddNewWard() {
		clkAddtbn.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(wardsMsg)); // Wait for message

			String actualMessage = wardsMsg.getText().trim(); // Capture the actual message
			String expectedMessage = "Ward added successfully";

			// Print the actual message in the console
			System.out.println("🔍 Actual User Message: '" + actualMessage + "'");

			// Verify if the actual message matches the expected message
			Assert.assertEquals(actualMessage, expectedMessage, "❌ Ward Added Test Failed");

			System.out.println("✅ Ward Added Test Passed at: " + java.time.LocalTime.now());

		} catch (Exception e) {
			System.out.println("❌ Exception in Ward Test: " + e.getMessage());
			Assert.fail("❌ Ward Added Test Failed due to an unexpected error.");
		}
	}
	
}
