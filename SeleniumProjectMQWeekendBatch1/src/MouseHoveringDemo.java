import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class MouseHoveringDemo {

	public static void main(String[] args) {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(electronics).build().perform();
		driver.findElement(By.xpath("//a[@href='/samsung-mobile-store?otracker=nmenu_sub_Electronics_0_Samsung']")).click();
		
	}
}
