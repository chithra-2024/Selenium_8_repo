package assignments.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A20_XpathAddToCartShoppersStack {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://shoppersstack.com/");
		Thread.sleep(30000);
		System.out.println(driver.findElement(By.xpath("//span[text()=' FAIR AND HANDSOME']/../..//button[@name='addToCart'][1]")).getText());
		driver.findElement(By.xpath("//span[text()=' FAIR AND HANDSOME']/../..//button[@name='addToCart'][1]")).click();

	}

}
