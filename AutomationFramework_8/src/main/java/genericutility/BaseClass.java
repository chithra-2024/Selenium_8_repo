package genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {
	
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib =new WebDriverUtility();
	
	public static ExtentReports extReport;
	public static ExtentTest test;
	public WebDriver driver;
	public static WebDriver sdriver;
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;

	@BeforeSuite
	public void configReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_report/extent_report_"+jLib.getSystemTime()+".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		wLib.maximizeWindow(driver);	
		
		driver.get(fLib.getDataFromProperty("url"));
		
		sdriver = driver;
	}
	
	@BeforeMethod
	public void login() throws IOException {
		wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fLib.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fLib.getDataFromProperty("password"));
		
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void logOut() {
		hp = new HomePage(driver);
		hp.getLogOut().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}
}
