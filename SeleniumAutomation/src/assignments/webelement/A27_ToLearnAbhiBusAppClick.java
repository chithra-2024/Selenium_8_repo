package assignments.webelement;

import java.util.List;
import java.util.TreeSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A27_ToLearnAbhiBusAppClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.abhibus.com/");
		Thread.sleep(2000);

		// select Hyd to blr bus link
		driver.findElement(By.xpath("//a[text()='Hyderabad to Bangalore Bus']")).click();
		Thread.sleep(10000);

		// click on Bus partner dropdown
		driver.findElement(By.xpath("//div[text()='Bus Partner']")).click();

		Thread.sleep(4000);

		// check Big Bus checkbox		
		driver.findElement(By.xpath("//label[text()='BMCC Travels']/..//input[@type='checkbox']")).click();
		
		
		List<WebElement> bigBuseWebElements = driver.findElements(
				By.xpath("//div[@id='travel-distance-container']/../../../../..//strong[contains(@class,'fare')]"));

		System.out.println("count of Big buses is " + bigBuseWebElements.size());
		
		TreeSet<Integer> priceSet = new TreeSet<Integer>();
		
		
		for (WebElement bigBusRecord : bigBuseWebElements) {			
			priceSet.add(Integer.parseInt(bigBusRecord.getText().replace(",","")));			
		}
		
		System.out.println(priceSet);
		System.out.println("Lowest price is "+priceSet.first());
		System.out.println("highest price is "+priceSet.last());

	}

}
