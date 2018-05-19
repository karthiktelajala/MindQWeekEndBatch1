package testNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DataProvider {

	@Test(dataProvider="credentials")
	public void loginWithValidCredentials(String username, String password)
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS );
		
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle, actTitle);
		
	}
	
	@org.testng.annotations.DataProvider(name="credentials")
	public Object[][] credentials()
	{
		return new Object[][] {{"Admin","admin"},{"Admin","admin"}};
	}
}
