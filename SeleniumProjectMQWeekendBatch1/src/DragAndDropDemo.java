import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import libraries.MouseActions;

public class DragAndDropDemo {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
		WebElement draggable = driver.findElement(By.xpath(".//*[@id='credit1']/a"));
		
		WebElement droppable = driver.findElement(By.xpath(".//*[@id='loan']"));
		
//		Actions act = new Actions(driver);
		
//		act.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
		
		//Or
		
//		act.dragAndDrop(draggable, droppable).build().perform();
		
		//Using Generic Method:
		MouseActions.dragAnddrop(driver, draggable, droppable);
	}

}
