package assignments.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A25_TooltipFlipkartApp {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");

		WebElement searchTextBox = driver.findElement(By.name("q"));
		if (searchTextBox.getAttribute("title").equals("Search for Products, Brands and More")) {
			System.out.println("Captured Tooltip: " + searchTextBox.getAttribute("title"));
		} else {
			System.out.println("Failed to capture Tooltip");
		}
	}

}
