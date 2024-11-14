package assignments.webdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A7_ToLearnNavigateNaukri {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		//1. open Naukri.com
		//2. verify user navigated to welcome page
		//3. 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();			
		
		driver.navigate().to(new URL("https://www.naukri.com"));
		if(driver.getCurrentUrl().equals("https://www.naukri.com")) {
			System.out.println("User navigated to Welcome page");
		}
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();

	}

}
