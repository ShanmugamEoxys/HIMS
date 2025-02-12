package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends Basepage { // inherit common func WebDriver Setup and element initialization
//inherit the driver and getdriver method

	public Homepage(WebDriver driver) {
		super(driver); // call the basepage constructor
	}

	// OP
	@FindBy(xpath = "//*[@data-testid='MenuOpenIcon']")
	WebElement menuOpen;

	@FindBy(xpath = "//a[@id='2_list_btn_sn_id']")
	WebElement patCateOpen;

	@FindBy(xpath = "//*[@id='2_list_child_text_sn_id']/span[text()='UHID Registration']")
	WebElement clkUHIDpage;

	@FindBy(xpath = "//*[starts-with(text(),'Registration')]")
	WebElement clkPatRegpage;

	@FindBy(xpath = "//*[@data-testid='MenuIcon']")
	WebElement menuClose;
	// Admin

	@FindBy(xpath = "//a[@id='1_list_btn_sn_id']")
	WebElement adminCateOpen;

	@FindBy(xpath = "//*[@id='1_list_child_sn_id']/div[1]")
	WebElement clkMasterListmenu;

	// Warehouse

	@FindBy(xpath = "//*[@id='18_list_btn_sn_id']")
	WebElement warehouseMenu;

	// select with icon wise
	@FindBy(xpath = "(//a[@id='18_list_btn_sn_id'])[1]")
	WebElement warehouseIcon;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public void clkMenuopen() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(menuOpen));
		menuOpen.click();
	}

	public void clkMenuClose() {
		menuClose.click();
	}

	public void clkCategoryOpen() {
		patCateOpen.click();
	}

	public void clkUHIDReg() {
		clkUHIDpage.click();
	}

	public void clkPatRegPage() {
		clkPatRegpage.click();
	}

	public void clkAdmincategory() {
		wait.until(ExpectedConditions.elementToBeClickable(adminCateOpen));
		adminCateOpen.click();

		wait.until(ExpectedConditions.elementToBeClickable(clkMasterListmenu));
		clkMasterListmenu.click();
	}

	// Warehouse
	public void openWH() {
		// warehouseMenu.click();
		warehouseIcon.click();
	}

}
