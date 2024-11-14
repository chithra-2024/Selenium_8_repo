package crossbrowsertesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ToLearnCrossBrowserTesting {
	
	public WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void launch(@Optional("chrome") String browserName) {
		if(browserName.equals("chrome")){
			driver = new ChromeDriver();		
		} else if(browserName.equals("edge")){
			driver= new EdgeDriver();
		}
		else if(browserName.equals("firefox")){
			driver= new FirefoxDriver();
		}
		
		driver.get("https://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

}
