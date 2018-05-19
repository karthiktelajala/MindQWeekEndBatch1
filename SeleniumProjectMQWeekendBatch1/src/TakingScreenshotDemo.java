import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import libraries.Screenshot;

public class TakingScreenshotDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("http://gmail.com");
		
		Screenshot.captureScreenshot(driver,"LoginScreen");
		
		driver.findElement(By.id("identifierId")).sendKeys("karthiktelajala");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("hello");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		Thread.sleep(3000);
		
		Screenshot.captureScreenshot(driver, "ErrorLogin");
	}

}
