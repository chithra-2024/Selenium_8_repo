package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D30_ToLearnMoveToElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://www.myntra.com");
		/*WebElement menLink = driver.findElement(By.xpath("//a[contains(text(),'Men')][1]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(menLink).perform(); */
		
		WebElement womenLink = driver.findElement(By.xpath("//a[contains(text(),'Women')][1]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(womenLink).perform();
		
		
	}

}
