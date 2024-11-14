package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class D47_BaseClass {
	
	WebDriver driver;
	FileInputStream pFis;
	FileInputStream eFis;
	Workbook workbook;
	Properties prop;
	
	@BeforeTest
	public void ObjectCreation() throws IOException {
		
		//property file
		pFis = new FileInputStream("./testdata/commondata.properties");
		prop = new Properties();
		prop.load(pFis);
		
		//excel file
		eFis = new FileInputStream("./testdata/TestScriptData.xlsx");
		workbook = WorkbookFactory.create(eFis);
	}
	
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			driver =new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver =new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("urlForDemowebshop"));
	}

	@BeforeMethod
	public void login() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
