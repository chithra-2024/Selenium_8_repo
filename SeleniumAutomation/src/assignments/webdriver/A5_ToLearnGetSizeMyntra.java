package assignments.webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A5_ToLearnGetSizeMyntra {

	public static void main(String[] args) {
		//1. open Myntra app in maximize mode
		//2. verify welcome page is displayed or not
		//3. capture height and width 
		//4. print it on console
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		if(driver.getCurrentUrl().equals("https://www.myntra.com/")) {
			System.out.println("User navigated to Welcome page");
		} else {
			System.out.println("User failed to navigate");
		}
		
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(height);
		System.out.println(width);

	}

}
