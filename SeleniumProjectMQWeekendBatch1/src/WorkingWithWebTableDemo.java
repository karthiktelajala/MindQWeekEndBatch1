import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WorkingWithWebTableDemo {

	public static void main(String[] args) throws Exception {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://www.redbus.in/");

		
		driver.findElement(By.id("src")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='src']/following-sibling::ul/li[text()='Bangalore']")).click();

		driver.findElement(By.id("dest")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@id='dest']/following-sibling::ul/li[text()='Pune']")).click();

		driver.findElement(By.id("onward_cal")).click();

		Date today = new Date();
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(today);
		
		int day = (cal.get(Calendar.DAY_OF_MONTH))+1;
		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/td[text()='"+day+"']")).click();

		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scroll(200,0)");
		
		driver.findElement(By.id("search_btn")).click();
		
	}

}
