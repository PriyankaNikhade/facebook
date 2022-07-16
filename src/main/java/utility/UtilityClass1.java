package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass1 {
	
	public static void captureScreen(WebDriver driver,int testCId) throws IOException {

		// With img date and time print code below 2 line.
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String delimeter = ts.toString().replace(":", "_").replace(" ", "_");

		// For screenshot code below
		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desti=new File("H:\\VelocityWorkSpace\\MavenFaceBook\\screenshot\\capture.jpeg" + testCId+ delimeter);
		FileHandler.copy(source, desti);
	}

	public static String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {

		String path = ("H:\\VelocityWorkSpace\\MavenFaceBook\\TestData\\FBexcel.xlsx");
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);

		String data;
		try {
			data=book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		catch(ArithmeticException e) {
			double value = book.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			data = String.valueOf(value);
			//how to convert double /int to string in java
		}
		return data;
	}
}
