package popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D34_ToHandleFileUploadPopup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.freshersworld.com/user/register?src=homeheader");
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\QSpider\\Chithra\\Resume\\CV_Satisha_DS.pdf");
	}

}
