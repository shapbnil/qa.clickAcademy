package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilityPackage.Common;

public class HomePage extends Common{
	
/*	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}*/
	
	public static By joinOur= By.xpath("//*[text()='NO THANKS']");
	
	public static By practice=By.xpath("//*[text()='Practice']");
	
	
	public void home(WebDriver driver) {
		
		clickObj(driver, HomePage.joinOur );
		clickObj(driver, HomePage.practice);
	}
}
