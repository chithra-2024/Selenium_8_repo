package seleniumtest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SeleniumTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://flipkart.com");

		List<WebElement> images = driver.findElements(By.xpath("//div[@class='_3sdu8W emupdz']/..//img"));

		for (WebElement img : images) {
			System.out.println(img.getAttribute("alt"));

			File temp = img.getScreenshotAs(OutputType.FILE);
			File dest = new File("./flipkart_screenshots/"+img.getAttribute("alt") +"-" + LocalDateTime.now().toString().replace(":", "-") + ".png");
			FileHandler.copy(temp, dest);
			
		}
	}

}
