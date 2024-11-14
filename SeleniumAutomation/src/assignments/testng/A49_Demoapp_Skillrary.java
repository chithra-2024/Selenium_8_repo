package assignments.testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import assignments.testng.pom.WelcomePage;
import pom.D43_LoginPage;

public class A49_Demoapp_Skillrary {

	@Test
	public void testLogin() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//read from skillrarycommondata.properties
		FileInputStream fis = new FileInputStream("./testdata/skillrarycommondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		driver.get(prop.getProperty("url"));
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		FileInputStream fisForExcel = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fisForExcel);
		
		D43_LoginPage lp = new D43_LoginPage(driver);
		lp.getEmailTextField().sendKeys(workbook.getSheet("skillrarylogin").getRow(1).getCell(0).getStringCellValue());
		lp.getPasswordTextField().sendKeys(workbook.getSheet("skillrarylogin").getRow(1).getCell(1).getStringCellValue());
		lp.getLoginButton().click();
		if(driver.getTitle().equals("SkillRary Ecommerce")){
			Reporter.log("User logged in successfully",true);
		} else {
			Reporter.log("User failed to login",true);
		}
	}
}
