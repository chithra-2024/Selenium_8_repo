package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D32_ToLearnDragAndDropDemowebshopapp {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(By.xpath("//input[@id='small-searchterms']")), "computing and internet").perform();
		
		action.click(driver.findElement(By.xpath("//input[@value='Search']"))).perform();
		
	}

}
