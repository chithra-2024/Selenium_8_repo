package assignments.pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A48_DemoApp_Register {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		FileInputStream fis = new FileInputStream("./testdata/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("demoshopurl"));
		
		FileInputStream fisForExcel = new FileInputStream("./testdata/TestScriptData.xlsx");		
		Workbook workbook = WorkbookFactory.create(fisForExcel);
		
		WelcomePage wp = new WelcomePage(driver);
		
		wp.getRegisterLink().click();
		RegisterPage rp = new RegisterPage(driver);
		
		rp.getFemaleRadioButton().click();

		
		String firstname = workbook.getSheet("register").getRow(1).getCell(0).getStringCellValue();
		String lastname =  workbook.getSheet("register").getRow(1).getCell(1).getStringCellValue();
		String email = workbook.getSheet("register").getRow(1).getCell(2).getStringCellValue();
		String password = workbook.getSheet("register").getRow(1).getCell(3).getStringCellValue();
		String confirmPassword = workbook.getSheet("register").getRow(1).getCell(4).getStringCellValue();
		
		rp.getFirstnameTextField().sendKeys(firstname);
		rp.getLastnameTextField().sendKeys(lastname);
		rp.getEmailTextField().sendKeys(email);
		rp.getPasswordTextField().sendKeys(password);
		rp.getCnfPasswordTextField().sendKeys(confirmPassword);
		
		rp.getRegisterButton().click();
		
		String expectedTitle = workbook.getSheet("registersuccess").getRow(1).getCell(0).getStringCellValue();
		
		if(driver.getTitle().equals(expectedTitle))	{
			System.out.println("User registration completed");
		} else {
			System.out.println("user registration failed");
		}
		
	}

}
