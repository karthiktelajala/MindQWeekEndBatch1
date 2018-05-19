import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import libraries.ExcelFile;

public class WorkingWithExcelDemo {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
		File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
		
		String username = ExcelFile.readExcel(0, 1, 0);
		String password = ExcelFile.readExcel(0, 1, 1);
		System.out.println(username + " " + password);
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		
		if(actTitle.equalsIgnoreCase(expTitle))
		{
			ExcelFile.writeExcel(0, 1, 2, "Passed");
		}
		else
		{
			ExcelFile.writeExcel(0, 1, 2, "Failed");
		}
	}
}
