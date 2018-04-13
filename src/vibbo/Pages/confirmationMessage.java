package vibbo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author arranzi
 * 
 * This class will store all the locator and methods of main page
 *
 */

public class confirmationMessage {
	
	WebDriver driver;
	
	//*********Web Elements*********
	By alert=By.xpath("//*[@id=\"ResponseEnviado\"]");
	
	public confirmationMessage (WebDriver driver) {
		this.driver=driver;
	}
	
	public void checkingConfirmationMessage() {
		
		if (driver.findElement(alert).isEnabled()) {
			System.out.println("****************Your message was sent correctly****************.");
			System.out.println("##################****************End of the test -> PASS****************##################");
			driver.close();
		}else {
			System.out.println("***************Your message was not sent correctly.***************");
			System.out.println("***************End of the test -> FAIL***************");
			driver.quit();
		}
	}
	
}
