package libraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	static String filePath = "C:\\Users\\VD57\\Desktop\\ExcelTestData\\Credentials.xlsx";
	static String testData;
	public static String readExcel(int sheetNum, int rowNum, int cellNum)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			testData = row.getCell(cellNum).getStringCellValue();
			wb.close();
		}
		catch(Exception e)
		{
			System.out.println("Something Wring While Reading Excel: "+e.getMessage());
		}
		return testData;
	}
	
	public static void writeExcel(int sheetNum, int rowNum, int cellNum, String resultData)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.createCell(cellNum);
			FileOutputStream fos = new FileOutputStream(filePath);
			cell.setCellValue(resultData);
			wb.write(fos);
			wb.close();
		}
		catch(Exception e)
		{
			System.out.println("Something Wring While Reading Excel: "+e.getMessage());
		}
	}

}
