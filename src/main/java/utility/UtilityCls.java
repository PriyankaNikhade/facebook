package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlgraphics.ps.dsc.events.DSCCommentEndOfFile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityCls {

	// This method is use to capture screenshot of webpage
	// Need to pass 2 inputs: 1.webDriver object 2. TestCaseID
	// @AuthorName: Priyanka
	public static void captureScreen(WebDriver driver,int testCId) throws IOException {

		// With img date and time print code below 2 line.
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String delimeter = ts.toString().replace(":", "_").replace(" ", "_");

		// For screenshot code below
		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desti=new File("H:\\VelocityWorkSpace\\MavenFaceBook\\screenshot\\capture.jpg" + testCId+  delimeter);
		FileHandler.copy(source, desti);
	}
	
/*	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException 
	{//Mini code utility cls
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("F:\\SELENIUM\\12MarchA_Maven\\Screenshot"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}*/
	
	// This method is use to get TesData from excel sheet
	// Need to pass 2 parameters: 1.rowIndex 2. cellIndex
	// @AuthorName: Priyanka
	
//	public static String getDataFromExcel() throws EncryptedDocumentException, IOException {
//
//		String path = ("H:\\\\VelocityWorkSpace\\\\MavenFaceBook\\\\excelSheet\\\\FBexcel.xlsx");
//		FileInputStream file = new FileInputStream(path);
//		String value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
//
//		String data;
//		try {
//			data=getStringCellValue();
//		}
//		catch(ArithmeticException e) {
//			double value = getNumericCellValue();
//			data = valueToString;
//			//how to convert double /int to string in java
//		}
//		return value;
//	}

	// mini
	public static String getTD(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("H:\\VelocityWorkSpace\\MavenFaceBook\\excelSheet\\FBexcel.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();			
		return value;
	}

	
}
