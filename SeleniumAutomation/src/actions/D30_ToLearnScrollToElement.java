package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D30_ToLearnScrollToElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		driver.get("https://demowebshop.tricentis.com");
		WebElement twitterLink = driver.findElement(By.linkText("Twitter"));
		
		Actions action = new Actions(driver);
		action.scrollToElement(twitterLink).perform();
	}

}
