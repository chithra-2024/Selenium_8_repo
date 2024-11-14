package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D41_TestScript {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		D43_WelcomePage wp = new D43_WelcomePage(driver);
		wp.getLoginLink().click();
		
		D43_LoginPage lp = new D43_LoginPage(driver);
		lp.getEmailTextField().sendKeys("chithra12321@gmail.com");
		lp.getPasswordTextField().sendKeys("ch423");
		lp.getLoginButton().click();
	}

}
