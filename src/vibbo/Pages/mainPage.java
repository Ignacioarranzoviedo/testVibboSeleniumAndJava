package vibbo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author arranzi
 * 
 * This class will store all the locator and methods of main page
 *
 */
public class mainPage {
	
WebDriver driver;
	
	//*********Web Elements*********
	By searchtext=By.id("sb_searchtext");
	By location=By.id("sb_location");
	By location2=By.xpath("//*[@id=\"ui-id-1\"]");
	By searchMainButton=By.id("sb_searchbutton");
	
	
	public mainPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public void typeThingAndLocation(String thingToSearch, String placeToSearch) {
		driver.findElement(searchtext).sendKeys(thingToSearch);
		System.out.println("****************Look for 'proyector'****************");
		driver.findElement(location).sendKeys(placeToSearch);
		System.out.println("****************Only in Esparreguera****************");
		
	}
	
	public void summitSearch() {
		driver.findElement(location).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(location).sendKeys(Keys.ARROW_UP);
		driver.findElement(location).sendKeys(Keys.ENTER);
		driver.findElement(searchMainButton).click();
		
	}
	
	

}
