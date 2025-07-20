package TestNGclass1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task3 {
	WebDriver driver;
	@BeforeMethod
	void launnchbrowser() {
	driver= new ChromeDriver();
	driver.get("https://v1.training-support.net/selenium/iframes");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	@Test
	void frames() throws IOException {
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='/selenium/frame1']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.id("actionButton")).click();
		
		System.out.println("successfully executed iframe1");
		
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='/selenium/frame2']"));
		driver.switchTo().frame(frame2);
		
		driver.findElement(By.id("actionButton")).click();
		System.out.println("successfully executed iframe1");
		
		driver.switchTo().defaultContent();
		
		
		driver.findElement(By.xpath("//button[@onclick='goBack()']")).click();
		System.out.println("successfully clicked back button");
		
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


