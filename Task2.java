package TestNGclass1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
	
	WebDriver driver;
	
	@BeforeMethod
   void launchbrowser() throws InterruptedException {
	
	driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	}
	@Test
	void confirmbox() throws InterruptedException, IOException {
	driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	Alert confirmalert = driver.switchTo().alert();
//	confirmalert.accept();
	confirmalert.dismiss(); 
	
	Thread.sleep(5000);
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File sourcefile = ts.getScreenshotAs(OutputType.FILE);
	File targetfile = new File("C:\\Users\\Mahesh\\OneDrive\\Desktop\\selenium\\screenshots\\alerbox-output");     
	FileUtils.copyFile(sourcefile, targetfile);
	
	
	
	}
	
	
	
	
	@AfterMethod
	void teardown() throws InterruptedException {
	Thread.sleep(5000);
	driver.close();
	}
	
	

}
