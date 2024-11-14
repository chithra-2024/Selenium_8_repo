package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class D1_LaunchEmptyBrowser {

	public static void main(String[] args) {
		//ChromeDriver driver = new ChromeDriver();
		//EdgeDriver driver = new EdgeDriver();
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

}
