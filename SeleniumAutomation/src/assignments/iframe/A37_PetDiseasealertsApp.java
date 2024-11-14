package assignments.iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A37_PetDiseasealertsApp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		
		WebElement iframeMap = driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]"));
		driver.switchTo().frame(iframeMap);
		driver.findElement(By.xpath("//*[name()='g' and @id='montana']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("SIGN UP")).click();
		driver.findElement(By.xpath("//input[@id='user']")).sendKeys("chithra4@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1234@Test");
		driver.findElement(By.xpath("//input[@id='cpass']")).sendKeys("1234@Test");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("chithra");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("kala");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
		
		WebElement userTypeDropdown = driver.findElement(By.xpath("//select[@id='user-type']"));
		Select userTypeSelect = new Select(userTypeDropdown);
		
		userTypeSelect.selectByVisibleText("Academic");
		driver.findElement(By.xpath("//input[@id='accept-tou']")).click();
		
		WebElement signUpButton = driver.findElement(By.xpath("//button[@value='Register']"));
		wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
		signUpButton.click();
		
		Actions action = new Actions(driver);
		action.pause(2000);
		
		WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert-sub-header']//p"));
		System.out.println(successMessage.getText());
		
	}

}
