package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D14_XpathByAxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("C:/Users/Mohan/OneDrive/Desktop/Siblings.html");
		WebElement ele = driver.findElement(By.xpath("//td[text()='KGF']/following-sibling::td[2]"));
		System.out.println(ele.getText());
		
		////th[text()="Levi's Shirt"]/following-sibling::td[5]/..//a
		

	}

}
