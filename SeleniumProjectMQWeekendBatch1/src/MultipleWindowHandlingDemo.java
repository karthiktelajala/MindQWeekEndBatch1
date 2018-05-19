import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class MultipleWindowHandlingDemo {

	public static void main(String[] args) {
		
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		String parentWindow = driver.getWindowHandle();
//		System.out.println(parentWindow);
		driver.findElement(By.xpath("//div[@id='bluemenu']/ul/li/a[contains(text(),'Tourism')]")).click();
		driver.findElement(By.xpath("//a[text()='Accommodations']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Hotels & Lounge')]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String currentWindow:allWindows)
		{
			if(currentWindow!=parentWindow)
			{
				driver.switchTo().window(currentWindow);
			}
		}
		
		driver.findElement(By.xpath("//a[text()='Retiring Room']")).click();
	}

}
