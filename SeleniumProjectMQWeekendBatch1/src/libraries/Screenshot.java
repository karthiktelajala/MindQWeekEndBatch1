package libraries;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("C:\\Users\\VD57\\Desktop\\Screenshots\\"+screenshotName+".jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Ooops...! Got exception while taking screenshot. "+e.getMessage());
		}
	}

}
