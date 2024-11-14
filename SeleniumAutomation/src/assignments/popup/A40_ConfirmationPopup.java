package assignments.popup;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A40_ConfirmationPopup {

	public static void main(String[] args) {
		

			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
			driver.switchTo().frame("iframeResult");
			
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			Alert confirmPopup =driver.switchTo().alert();
			System.out.println(confirmPopup.getText());
			confirmPopup.accept();
			
			
		
	}

}
