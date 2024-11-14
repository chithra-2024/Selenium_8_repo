package assignments.synchronization;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class A30_ImplicitWaitDemoAppQspiders {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));		
		
		//1. open demoapps.qspiders.com
		driver.get("https://demoapps.qspiders.com");
		//2. click on UI testing Concepts link
		driver.findElement(By.xpath("//p[contains(text(),'UI Testing Concepts')]")).click();
		//3. verify home page is displayed or not
		
		if(driver.getCurrentUrl().equals("https://demoapps.qspiders.com/ui")) {
			System.out.println("Home Page is displayed when clicked on UI testing Concepts link");
		} else {
			System.out.println("User failed to navigate to Home page");
		}
		//4. click on Web Table
		driver.findElement(By.xpath("//section[contains(text(),'Web Table')]")).click();
		
		//5. click on Dynamic Web Table
		driver.findElement(By.xpath("//a[contains(text(),'Dynamic Web Table')]")).click();
		
		
		
		//6.capture HP Envy's Discount and print
		Thread.sleep(6000);
		WebElement element = driver.findElement(By.xpath("//th[contains(text(),'HP Envy')]/following-sibling::td[3]"));
		
		System.out.println("HP Envy's Discount is "+element.getText());
		
		//7.Take a screenshot of web page
		Thread.sleep(6000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/Qspider"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileHandler.copy(temp, dest);		
	}

}
