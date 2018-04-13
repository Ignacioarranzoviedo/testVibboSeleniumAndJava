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

public class resultsPage {
	
	WebDriver driver;
	
	//*********Web Elements*********
	By pricelistTo=By.xpath("//*[@id=\"sb_pricelistTo\"]");
	By searchbutton_filter=By.xpath("//*[@id=\"sb_searchbutton_filter\"]");
	
	public resultsPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public void typeMaxPrice(String maxPrice) {
		driver.findElement(pricelistTo).sendKeys(maxPrice);
		System.out.println("****************Set the max price to: "+maxPrice+"****************");
	}
	public void summitFilter() {
		driver.findElement(searchbutton_filter).click();
	}
}
