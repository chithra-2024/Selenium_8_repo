package assignments.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A47_DemoWebShopRegisterFromExcelReadData {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		
		FileInputStream fis = new FileInputStream("./testdata/registerdata.properties");		
		Properties prop = new Properties();		
		prop.load(fis);		

		FileInputStream fisForExcel = new FileInputStream("./testdata/TestScriptData.xlsx");		
		Workbook workbook = WorkbookFactory.create(fisForExcel);
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.linkText("Register")).click();
		
		String firstname = workbook.getSheet("register").getRow(1).getCell(0).getStringCellValue();
		String lastname =  workbook.getSheet("register").getRow(1).getCell(1).getStringCellValue();
		String email = workbook.getSheet("register").getRow(1).getCell(2).getStringCellValue();
		String password = workbook.getSheet("register").getRow(1).getCell(3).getStringCellValue();
		String confirmPassword = workbook.getSheet("register").getRow(1).getCell(4).getStringCellValue();
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
		
		driver.findElement(By.name("register-button")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='result']")).getText());
	
	}

}
