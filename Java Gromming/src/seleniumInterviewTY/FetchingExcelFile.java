package seleniumInterviewTY;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Vibhor\\Desktop\\Selenium Data\\DemoDataFile.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String value = book.getSheet("DemoSheet").getRow(2).getCell(1).getStringCellValue();
		System.out.println("Cell Value : "+value);
	}
}