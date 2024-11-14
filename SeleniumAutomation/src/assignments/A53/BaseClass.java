package assignments.A53;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	WebDriver driver;
	FileInputStream pFis;
	FileInputStream eFis;
	Workbook workbook;
	Properties prop;
	
	@BeforeTest
	public void ObjectCreation() throws IOException {
		
		//property file
		pFis = new FileInputStream("./testdata/skillrarycommondata.properties");
		prop = new Properties();
		prop.load(pFis);
		
		//excel file
		eFis = new FileInputStream("./testdata/TestScriptData.xlsx");
		workbook = WorkbookFactory.create(eFis);
	}
	
	@BeforeClass
	public void launchBrowser() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("url"));
	}
	
	@BeforeMethod
	public void login() {
		driver.findElement(By.linkText("LOGIN")).click();
		driver.findElement(By.id("email")).sendKeys(workbook.getSheet("skillrarylogin").getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.id("password")).sendKeys(workbook.getSheet("skillrarylogin").getRow(1).getCell(1).getStringCellValue());
		driver.findElement(By.id("last")).click();
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//span[text()='SkillRary Admin']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	}
	
	@AfterClass
	public void closeBrowser() {		
		driver.quit();
	}

}
