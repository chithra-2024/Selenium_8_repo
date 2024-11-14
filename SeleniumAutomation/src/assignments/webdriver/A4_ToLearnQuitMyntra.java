package assignments.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A4_ToLearnQuitMyntra {

	public static void main(String[] args) {
		//1. open Myntra app
		//2. capture URL
		//3. close the window using quite()
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		driver.quit();
	}

}
