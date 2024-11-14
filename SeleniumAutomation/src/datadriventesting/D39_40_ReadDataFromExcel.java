package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class D39_40_ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String url = workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String username = workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String password = workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		System.out.println(url);	
		System.out.println(username);
		System.out.println(password);
		
		System.out.println((int)workbook.getSheet("Sheet1").getRow(1).getCell(3).getNumericCellValue());
		System.out.println(workbook.getSheet("Sheet1").getRow(1).getCell(4).getBooleanCellValue());
		LocalDateTime date = workbook.getSheet("Sheet1").getRow(1).getCell(5).getLocalDateTimeCellValue();
		System.out.println(date);
		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getYear());
		/*
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.linkText("LOGIN")).click();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		*/
	
	}

}
