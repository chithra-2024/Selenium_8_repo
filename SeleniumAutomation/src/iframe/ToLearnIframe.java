package iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnIframe {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.dream11.com");
		//switch to iframe by index
		//driver.switchTo().frame(0);
		
		//switch to iframe by id or name
		//driver.switchTo().frame("send-sms-iframe");
		
		//switchTo iframe by webElement
		//get the parent Id before switching to iframe
		
		WebElement iframeExample = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
		driver.switchTo().frame(iframeExample);
		
		
		driver.findElement(By.id("regEmail")).sendKeys("1234567890");
		
		//two ways to switch control from iframe
		//driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		driver.findElement(By.id("hamburger")).click();
	}

}
