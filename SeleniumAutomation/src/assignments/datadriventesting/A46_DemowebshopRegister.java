package assignments.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A46_DemowebshopRegister {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		
		FileInputStream fis = new FileInputStream("./testdata/registerdata.properties");		
		Properties prop = new Properties();		
		prop.load(fis);
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.id("LastName")).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("ConfirmPassword")).sendKeys(prop.getProperty("confirmpassword"));
		
		driver.findElement(By.name("register-button")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='result']")).getText());
	
	}

}
