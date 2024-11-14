package assignments.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A3_ToLearnCloseRedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		//1. open red bus app,
		//2. capture sourcecode
		//3. print it on console 
		//4. then close the app
		driver.get("https://www.redbus.in/");
		System.out.println(driver.getPageSource());
		Thread.sleep(15000);
		driver.close();
		

	}

}
