package testNGPackage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Login {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();       
			driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS );
	}
	
	@Test
	public void loginWithValidCredentials()
	{	
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle, actTitle);
		
	}
	
	@Test
	public void loginWithInvalidCredentials()
	{	
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		String expMsg = "Invalid credentials";
		String actMsg = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
		Assert.assertEquals(expMsg, actMsg);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
