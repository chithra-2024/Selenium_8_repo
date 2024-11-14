package assignments.test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartToolTip {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.flipkart.com/");
		WebElement searchElement = driver.findElement(By.cssSelector("//input@placeholder='Search for Products, Brands and More'"));
		
		String title = searchElement.getAttribute("title");
		System.out.println(title);
	}

}
