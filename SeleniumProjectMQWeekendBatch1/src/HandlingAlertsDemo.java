import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class HandlingAlertsDemo {

	public static void main(String[] args) {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/selenium/delete_customer.php");
		
		driver.findElement(By.name("cusid")).sendKeys("123");
		driver.findElement(By.name("submit")).click();
		
		String expMessage = "Customer Successfully Delete!";
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String actMessage = alert.getText();
		
		System.out.println(actMessage);
		if(actMessage.equalsIgnoreCase(expMessage))
		{
			alert.accept();
		}
		else
		{
			alert.dismiss();
		}
		
		driver.switchTo().defaultContent();
		driver.findElement(By.name("res")).click();
		System.out.println(driver.getTitle());
	}

}
