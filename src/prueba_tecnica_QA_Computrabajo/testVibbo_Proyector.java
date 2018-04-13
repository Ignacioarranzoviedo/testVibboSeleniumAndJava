
package prueba_tecnica_QA_Computrabajo;
/**
 * 
 * @author arranzi
 *
 */
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import vibbo.Pages.confirmationMessage;
import vibbo.Pages.filteredResultsPage;
import vibbo.Pages.mainPage;
import vibbo.Pages.ourProyectorPage;
import vibbo.Pages.resultsPage;


public class testVibbo_Proyector {
	
	
	public static void main(String[] args) throws Throwable{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\arranzi\\Desktop\\Ejercito_de_dumblendore\\WEB-DRIVER-BOOK\\geckodriver.exe");
		
		//we instantiate the Firefox implementation of the WebDriver interface (subclass of the RemoteWebDriver class)
		WebDriver driver = new FirefoxDriver();
		
		EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(driver);
		IAmTheEventListener eventListener = new IAmTheEventListener();
		eventFiringDriver.register(eventListener);
			
		eventFiringDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		eventFiringDriver.get("https://www.vibbo.com/");
		System.out.println("Vibbo main page");
		
		Thread.sleep(1000);
		
		mainPage search=new mainPage(eventFiringDriver);
		search.typeThingAndLocation("proyector", "Esparreguera");
		Thread.sleep(4000);
		search.summitSearch();
		
		Thread.sleep(5000);
		
		resultsPage setFilter=new resultsPage(eventFiringDriver);
		setFilter.typeMaxPrice("60");
		setFilter.summitFilter();
		
		filteredResultsPage checkingDateAndPrice=new filteredResultsPage(eventFiringDriver);
		checkingDateAndPrice.printDateAndPrice();
		checkingDateAndPrice.checkingDateAndPrice();
		
		Thread.sleep(2000);
	
		ourProyectorPage sendingAMessage=new ourProyectorPage(eventFiringDriver);
		sendingAMessage.printTheSellerName();
		sendingAMessage.checkingTheSellerName();
		Thread.sleep(3000);
		sendingAMessage.typeTheMessage();
		
		Thread.sleep(4000);
		
		WebElement acceptCondition = eventFiringDriver.findElement(By.id("acepto_condiciones"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", acceptCondition);
		
		sendingAMessage.sendTheMessage();
		
		Thread.sleep(2000);
		
		confirmationMessage alertMessage=new confirmationMessage(eventFiringDriver);
		alertMessage.checkingConfirmationMessage();
		
		
	}

}
