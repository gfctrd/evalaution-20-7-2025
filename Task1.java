package evlauayion2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
	WebDriver driver;
	@BeforeMethod
	void launchbrowser() throws InterruptedException {
		driver=new  ChromeDriver();
		driver.get("https://www.globalsqa.com/samplepagetest/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
	}
	@Test
	void formTest() throws IOException, InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='g2599-name']")).sendKeys("mahesh");
		driver.findElement(By.xpath("//input[@id='g2599-email']")).sendKeys("mahireddy8013@gmail.com");
		driver.findElement(By.xpath("//input[@id='g2599-website']")).sendKeys("https://the-internet.herokuapp.com/login");
		
		WebElement drpdown = driver.findElement(By.xpath("//select[@id='g2599-experienceinyears']"));
		Select experienceselect = new Select(drpdown);
		experienceselect.selectByContainsVisibleText("0-1");
		
		WebElement chckbox = driver.findElement(By.xpath("//input[@class='checkbox-multiple'][1]"));
		chckbox.click();
		
		WebElement radiobtn = driver.findElement(By.xpath("//input[@class='radio'][1]"));
		radiobtn.click();
		
		
//		driver.findElement(By.xpath("//button[text()='Alert Box : Click Here']")).click();
//		
//		Alert alert1 = driver.switchTo().alert();
//		alert1.accept();
//	
		
		driver.findElement(By.xpath("//textarea[@class='textarea']")).sendKeys("hi, everyone");
		
		
		
		driver.findElement(By.xpath("//button[@class='pushbutton-wide']")).click();
		
		Thread.sleep(4000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File("C:\\Users\\Mahesh\\OneDrive\\Desktop\\selenium\\screenshots\\form-output");     
		FileUtils.copyFile(sourcefile, targetfile);
		
		
	}
		@AfterMethod
		void teardown() throws InterruptedException {
			Thread.sleep(5000);
			driver.close();
		}
	


}
