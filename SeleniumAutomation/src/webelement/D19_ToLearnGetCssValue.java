package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D19_ToLearnGetCssValue {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com");
		
		WebElement registerElement = driver.findElement(By.linkText("Register"));
		
		System.out.println(registerElement.getCssValue("color"));
		System.out.println(registerElement.getCssValue("font-family"));
	}

}
