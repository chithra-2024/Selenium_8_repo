package assignments.popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A42_Naukri_FileUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.naukri.com/");
		driver.findElement(By.linkText("Register")).click();
		
		Actions action = new Actions(driver);
		action.pause(2000);
		WebElement iAmExpHeader = driver.findElement(By.xpath("(//h2[@class='main-3'])[1]"));
		action.scrollToElement(iAmExpHeader).perform();
		iAmExpHeader.click();
		WebElement fileUpload = driver.findElement(By.xpath("//input[@type='file']"));
		fileUpload.sendKeys("C:/Personal/Resume/Satish_Resume_16yrs_Exp_Manager.pdf");
		action.scrollToElement(fileUpload).perform();
		
	}
}
