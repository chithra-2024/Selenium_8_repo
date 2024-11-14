package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D30_ToLearnClickAndHold {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://yonobusiness.sbi/login/yonobusinesslogin");
		
		WebElement eyeIcon = driver.findElement(By.xpath("//div[@class='disableddiv showPassword shownhide']"));
				
		Actions act = new Actions(driver);
		act.moveToElement(eyeIcon).clickAndHold().pause(2000).release().perform();
		}

}