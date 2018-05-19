import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WorkingWithFramesDemo {

	public static void main(String[] args) {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("http://toolsqa.com/iframe-practice-page/");
		
//		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
//		System.out.println(allFrames.size());
		
		driver.switchTo().frame("IF2");
		String expText = "Unique & Clean";
		String actText = driver.findElement(By.xpath("//h5[contains(text(),'Unique & Clean')]")).getText();
		System.out.println(actText);
		if(actText.equalsIgnoreCase(expText))
		{
			System.out.println("Passed");
		}
		

	}

}
