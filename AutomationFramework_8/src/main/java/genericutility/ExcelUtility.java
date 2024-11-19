package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	/**
	 * This method is used to read string data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getStringDataFromExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);		
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();		
	}
	
	/**
	 * This method is used to read boolean data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public boolean getBooleanDataFromExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);		
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getBooleanCellValue();		
	}
	
	/**
	 * This method is used to read numeral data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double getNumericDataFromExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);		
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();		
	}
	
	/**
	 * This method is used to read LocalDate data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public LocalDateTime getDateDataFromExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);		
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getLocalDateTimeCellValue();		
	}

}
