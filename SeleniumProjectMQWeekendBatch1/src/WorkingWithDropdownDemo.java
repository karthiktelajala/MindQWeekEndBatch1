import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class WorkingWithDropdownDemo {

	public static void main(String[] args) {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.get("https://facebook.com");
		
		WebElement month = driver.findElement(By.id("month"));
		
		Select sel = new Select(month);
		
//		sel.selectByIndex(8);
		sel.selectByVisibleText("Aug");
		
//		List<WebElement> monthList = sel.getOptions();
//		
//		for(int i=0;i<monthList.size();i++)
//		{
//			String str = monthList.get(i).getText();
//			String expectedMonth = "Aug";
//			if(str.equalsIgnoreCase(expectedMonth))
//			{
//				sel.selectByVisibleText(str);
//			}
//		}
		
//		WebElement radio = driver.findElement(By.id("u_0_c"));
//		if(!(radio.isSelected()))
//		{
//			radio.click();
//		}
	}

}
