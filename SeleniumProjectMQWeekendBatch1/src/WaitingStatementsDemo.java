import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingStatementsDemo {

	public static void main(String[] args) throws InterruptedException {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		//Impicit Wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.navigate().to("http://gmail.com");
		
		driver.findElement(By.id("identifierId")).sendKeys("karthiktelajala");
		
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
//		Thread.sleep(5000);
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		
		driver.findElement(By.name("password")).sendKeys("Test123");
		
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	}
}
