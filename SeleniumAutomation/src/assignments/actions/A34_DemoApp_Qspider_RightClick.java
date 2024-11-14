package assignments.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A34_DemoApp_Qspider_RightClick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[contains(text(),'UI Testing Concepts')]")).click();
		driver.findElement(By.xpath("//section[contains(text(),'Button')][1]")).click();
		driver.findElement(By.linkText("Right Click")).click();
		
		WebElement rightClickButton = driver.findElement(By.xpath("//button[contains(text(),'Right Click')]"));
		Actions act = new Actions(driver);
		act.contextClick(rightClickButton).perform();
		
		driver.findElement(By.xpath("//div[contains(text(),'Yes')]")).click();
		
		WebElement yesMsg = driver.findElement(By.xpath("//span[contains(@class,'text-green')]"));
		
		System.out.println(yesMsg.getText());
		System.out.println(yesMsg.getCssValue("color"));
	}

}
