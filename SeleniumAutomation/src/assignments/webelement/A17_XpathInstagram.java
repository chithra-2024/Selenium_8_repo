package assignments.webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A17_XpathInstagram {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com/");
		driver.findElement(By.xpath("//span[contains(text(),'Contact')]")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//h1[contains(@class,'html')]"));
		System.out.println(ele.getText());
		List<WebElement> headers = driver.findElements(By.xpath("//h1[contains(@class,'html')]/../../../../../../../..//h2[contains(@class,'html')]"));
		for(WebElement element:headers) {
			System.out.println(element.getText());
		}
	}

}
