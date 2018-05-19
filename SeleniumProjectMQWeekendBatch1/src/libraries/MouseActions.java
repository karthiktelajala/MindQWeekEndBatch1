package libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	public static void dragAnddrop(WebDriver driver, WebElement draggable, WebElement droppable)
	{
		Actions act = new Actions(driver);
		
		act.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
		
		//Or
		
//		act.dragAndDrop(draggable, droppable).build().perform();
	}
}
