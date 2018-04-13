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

public class ourProyectorPage {
	WebDriver driver;
	
	//*********Web Elements*********
	By sellerName=By.xpath("//*[@id=\"main\"]/div[1]/div/div[4]/div/div[2]/div[2]/div[2]/div[1]");
	By sendAMessage=By.xpath("//*[@id=\"sellerBox-show-chatForm\"]");
	By messageText=By.id("cmt_contact_box");
	By messageName=By.id("name_contact_box");
	By messageEmail=By.id("email_contact_box");
	By acceptCondition=By.id("acepto_condiciones");
	By messageButton=By.id("BContactar");
	
	
		
	public ourProyectorPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public void printTheSellerName() {
		System.out.println(("****************The seller is: " +driver.findElement(sellerName).getText()+"****************"));
	}
	
	public void checkingTheSellerName() {
		
		String expectedSellerName ="Xavi";
		String sellerNameResult = driver.findElement(sellerName).getText();
		
		if (expectedSellerName.equals(sellerNameResult)) {
			System.out.println("****************The seller is the expected seller.****************");
			driver.findElement(sendAMessage).click();
		
		}else {
			System.out.println("****************The seller is not the expected seller.****************");
			System.out.println("****************End of the test -> FAIL****************");
			driver.close();
		}
	}
		
	public void typeTheMessage() {
			
		String mytext = "Test QA";
		String myName = "Ignacio Arranz";
		String myMail = "ignacio.a.oviedo@gmail.com";
		driver.findElement(messageText).sendKeys(mytext);
		driver.findElement(messageName).sendKeys(myName);
		driver.findElement(messageEmail).sendKeys(myMail);
		System.out.println("****************Sending message****************");
			
	}
	
	public void sendTheMessage() {		
		
		driver.findElement(messageButton).click();
		
	}
		
	
	
}
