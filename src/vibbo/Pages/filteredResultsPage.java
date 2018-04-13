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

public class filteredResultsPage {
	
	WebDriver driver;
	
	//*********Web Elements*********
	By date=By.xpath("//*[@id=\"113286121\"]/div/div[1]/div[2]/p[5]/a");
	By price=By.xpath("//*[@id=\"113286121\"]/div/div[1]/div[2]/p[2]/a");
	
	
	public filteredResultsPage (WebDriver driver) {
		this.driver=driver;
	}
	public void printDateAndPrice() {
		System.out.println("The date of publication is : " +driver.findElement(date).getText());
		System.out.println("The price is: " +driver.findElement(price).getText());
	}
	
	public void checkingDateAndPrice() {
		
		String expectedDate = "28 mar";
		String dateResult = driver.findElement(date).getText();
		String expectedPrice = "60€";
		String priceResult = driver.findElement(price).getText();
		
		if (expectedDate.equals(dateResult) && expectedPrice.equals(priceResult)) {
			
			System.out.println("****************The date of publication is the expected date.****************");
			System.out.println("****************The price is the expected price.****************");
			driver.findElement(price).click();
		}else {
			System.out.println("****************The date of publication or th price are not the expected data****************");
			System.out.println("****************End of the test -> FAIL****************");
			driver.close();
		}
		
	}
}
