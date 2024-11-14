package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D21_ToLearnIsSelected {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		String rating="Poor";
		System.out.println("==before clicking");
		System.out.println(driver.findElement(By.xpath("//label[text()='"+rating+"']/..//input[@type='radio']")).isSelected());
		
		driver.findElement(By.xpath("//label[text()='Poor']/..//input[@type='radio']")).click();
		System.out.println("==after clicking==");
		System.out.println(driver.findElement(By.xpath("//label[text()='Poor']/..//input[@type='radio']")).isSelected());
		
		
		
	}

}
