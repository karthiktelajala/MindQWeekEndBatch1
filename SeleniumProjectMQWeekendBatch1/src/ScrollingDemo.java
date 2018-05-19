//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//
//public class ScrollingDemo {
//
//	public static void main(String[] args) throws AWTException, InterruptedException {
//	
//		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//		FirefoxProfile firefoxProfile = new FirefoxProfile();       
//		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		
//		driver.get("https://www.flipkart.com/");
//		driver.findElement(By.xpath("//button[text()='✕']")).click();
//		
//		//using javascript
////		JavascriptExecutor jsp = (JavascriptExecutor)driver;
////		jsp.executeScript("window.scroll(200,300)");
//		
//		//using Robot Class
//		Robot robot = new Robot();
////		robot.keyPress(KeyEvent.VK_DOWN);
////		robot.keyRelease(KeyEvent.VK_DOWN);
////		Thread.sleep(2000);
////		robot.keyPress(KeyEvent.VK_UP);
////		robot.keyRelease(KeyEvent.VK_UP);
//		
//		robot.keyPress(KeyEvent.VK_WINDOWS);
//		robot.keyPress(KeyEvent.VK_D);
//		robot.keyRelease(KeyEvent.VK_WINDOWS);
//		robot.keyRelease(KeyEvent.VK_D);
//	}
//}
