import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class LaunchingBrowserDemo {

	public static void main(String[] args) throws Exception {
	
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		       
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\geckodriver.exe");
//		WebDriver driver2 = new FirefoxDriver();
		
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
//		driver.get("https://facebook.com");
		
		driver.navigate().to("http://gmail.com");
		
		driver.findElement(By.xpath("//span[contains(text(),'Forgot email?')]")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		WebElement userName = driver.findElement(By.id("identifierId"));
		userName.sendKeys("karthiktelajala");
		
		driver.navigate().refresh();
		
		
	}

}
