package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utilityPackage.Common;

public class PracticePage extends Common {

	WebDriver driver;

	public PracticePage(WebDriver driver) {
		this.driver = driver;
	}

//Radio Button Example
	public static By radiobtn = By.name("radioButton");
	// Suggession Class Example
	public static By typeCountry = By.id("autocomplete");
	// Dropdown Example
	public static By option = By.id("dropdown-class-example");

	// Checkbox Example
	public static By checkBoxOption1 = By.id("checkBoxOption1");

	public static By checkBoxOption3 = By.id("checkBoxOption3");

	//Window handle
	public static By openwindow = By.id("openwindow");

	// Home page child window
	//public static By joinOur = By.xpath("//*[text()='NO THANKS']");

	public static By practice = By.xpath("//*[text()='Practice']");
	
	//Switch Tab Example
	public static By opentab = By.id("opentab");

	public static By name = By.id("name");
	
	public static By alertbtn = By.id("alertbtn");
	
	// Element Displayed Example hide-textbox
	public static By hide_textbox = By.id("hide-textbox");
	
	public void practice() throws InterruptedException {
		// Radio Button Example
		clickObj(driver, PracticePage.radiobtn);

		// Suggession Class Example
		enterText(driver, PracticePage.typeCountry, "Bangladesh");
		clickObj(driver, PracticePage.typeCountry);

		// Dropdown Example
		selectObj(driver, PracticePage.option, "Option2");

		// Checkbox Example
		clickObj(driver, PracticePage.checkBoxOption1);
		clickObj(driver, PracticePage.checkBoxOption3);

		
		// Switch Window Example
		Thread.sleep(5000);
		String parent = driver.getWindowHandle();
		String child = null;
		clickObj(driver, PracticePage.openwindow);
		// driver.findElement(By.id("openwindow")).click();

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (!window.equals(parent)) {
				child = window;
			}
		}
		Thread.sleep(5000);
		driver.switchTo().window(child);
		//Thread.sleep(5000);
	//clickObj(driver, HomePage.joinOur );
		//Thread.sleep(5000);
		clickObj(driver, HomePage.practice);
		
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		System.out.println(title);
		String expected_title = "Practice Page";
		Assert.assertEquals(expected_title, title);
		// System.out.println("Test Completed");
		// logs
		// String text=driver.findElement(By.xpath("//*[text()='My Cart
		// (1)']")).getText();
		
		tearDown(driver);
		Thread.sleep(5000);

		driver.switchTo().window(parent);
		//Switch Tab Example
		//clickObj(driver, PracticePage.opentab);
		//Thread.sleep(3000);
		//driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//driver.switchTo().window(parent);
		
		//Switch To Alert Example
		enterText(driver, PracticePage.name, "Biplab");
		
		clickObj(driver, PracticePage.alertbtn);
		driver.switchTo().alert().accept();
		
		//Web Table
		WebElement table=driver.findElement(By.xpath("//table[@id='product']"));
		int rows=table.findElements(By.tagName("tr")).size();
		
		int columns=table.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).size();
		
				
		List<WebElement> lst_Rows= table.findElements(By.tagName("tr"));
		
		for(int i=0;i<lst_Rows.size();i++) {
			List<WebElement> lst_Columns=lst_Rows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<lst_Columns.size();j++) {
					System.out.print(lst_Columns.get(j).getText()+" ");
			
				  
			 
				}
				System.out.println();
		}
		
		// Element Displayed Example hide-textbox
		clickObj(driver, PracticePage.hide_textbox);
		
		
		Thread.sleep(4000);
		//Mouse Hover Example
		WebElement ele=driver.findElement(By.id("mousehover"));
		Actions action=new Actions(driver);
		action.moveToElement(ele);
		action.build().perform();
		
		//iFrame Example
		WebElement frame=driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame(frame);
		// Clicking inside the frame
		driver.findElement(By.xpath("//*[text()=' contact@rahulshettyacademy.com']")).getText();
		driver.switchTo().defaultContent();
		
		
		
				
	}

}