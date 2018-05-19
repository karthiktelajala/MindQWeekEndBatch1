import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class WorkingWithWebTablesDemo2 {

	public static void main(String[] args) throws Exception {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		
		Actions act = new Actions(driver);
		
		WebElement admin = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b"));
		act.moveToElement(admin).build().perform();
		WebElement userManagement = driver.findElement(By.id("menu_admin_UserManagement"));
		act.moveToElement(userManagement).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		String username= "john18@gmail.com";
		driver.findElement(By.xpath("//a[text()='"+username+"']/parent::td/preceding-sibling::td/input")).click();
		driver.findElement(By.id("btnDelete")).click();

		driver.findElement(By.xpath("//input[@value='Cancel']")).click();
	}
}
