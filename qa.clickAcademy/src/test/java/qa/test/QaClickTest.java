package qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

import pages.HomePage;
import pages.PracticePage;
import utilityPackage.Common;

public class QaClickTest {
	@Test
	public void testStart() throws InterruptedException {
		
		ExtentAventReporter htmlReport=new ExtentAventReporter(System.getProperty("user.dir")+"\\ExtentReport\\Report.html");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(htmlReport);
		ExtentTest test= extent.createTest("Test1");
		
		
		Common com=new Common();
		WebDriver driver=com.lunchBrowser();
		com.openUrl(driver);
		
		HomePage hp=new HomePage();
		hp.home(driver);
		
		Thread.sleep(4000);
		PracticePage pp= new PracticePage(driver);
		pp.practice();
		extent.flush();
		com.tearDown(driver);
	}

}
