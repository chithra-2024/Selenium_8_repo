package assignments.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A26_ToLearnGetRectDemoWebShopApp {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		boolean registerButtonStatus = driver.findElement(By.xpath("//a[text()='Register']")).isDisplayed();
		
		if(registerButtonStatus) {
			System.out.println("Reegister link is displayed");
		} else {
			System.out.println("Register link is not displayed");
		}
		
		Rectangle rect = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']")).getRect();
		
		System.out.println("Height of Subscribe button is "+rect.getHeight());
		System.out.println("Width of Subscribe button is "+rect.getWidth());
		System.out.println("X coordinate of Subscribe button is "+rect.getX());
		System.out.println("Y coordinate of Subscribe button is "+rect.getY());
		
	}

}
