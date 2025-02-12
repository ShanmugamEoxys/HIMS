
package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
	public WebDriver driver;
	
    protected static final Logger logger = LogManager.getLogger(Basepage.class); // Correctly initializing Logger
	public Basepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //initialize the webelements (@Findby)
	}

	// provide a getter for driver
	public WebDriver getDriver() {
		return driver;
	}
	
	

}
