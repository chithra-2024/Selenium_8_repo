package assignments.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A18_XpathByAxesDemoQspiderApp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table/dynamicTable");
		Thread.sleep(4000);
		WebElement eles = driver.findElement(By.xpath("//th[text()=\"Levi's Shirt\"]/following-sibling::td[5]/..//a"));
		//WebElement element =driver.findElement(By.xpath("//th[contains(text(),'HP Envy')]/following-sibling::td[3][contains(text(),'')]"));
		
		//System.out.println("HP Envy's Discount is "+element.getText());
		driver.findElement(By.xpath("//th[text()=\"Levi's Shirt\"]/following-sibling::td[5]/..//a")).click();
		}

}
