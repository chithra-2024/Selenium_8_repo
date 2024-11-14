package webdriver;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D6_ToLearnGetPosition {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com");
		
		Point position = driver.manage().window().getPosition();
		int x = position.getX();
		int y = position.getY();
		System.out.println("X: "+x);
		System.out.println("Y: "+y);

	}

}
