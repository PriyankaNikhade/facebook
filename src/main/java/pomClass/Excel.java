package pomClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel {
	public static void main(String[] args) throws IOException {
	String path = ("F:\\SELENIUM\\Excel\\TestExample.xlsx");
	FileInputStream file = new FileInputStream(path);
	Workbook book = WorkbookFactory.create(file);
	
	//Get string data from excel sheet fetch in program.
	String text =book.getSheet("Test").getRow(8).getCell(1).getStringCellValue();
	System.out.println(text);
	
	//Get Numeric data from excel sheet fetch in program.
	double num =book.getSheet("Test").getRow(15).getCell(1).getNumericCellValue();
	System.out.println(num);
	
	//Get DATE&TIME data from excel sheet fetch in program.
	Date date =book.getSheet("Test").getRow(20).getCell(0).getDateCellValue();
	System.out.println(date);
}
}