package pom;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D42_StaleElementException {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapp.skillrary.com");
		/*
		WebElement searchTF = driver.findElement(By.id("navbar-search-input"));
		searchTF.sendKeys("Selenium",Keys.ENTER);
		
		searchTF.sendKeys("testng"); */
		
		D43_SkillRaryPage sp = new D43_SkillRaryPage(driver);
		sp.getSearchTextField().sendKeys("Selenium",Keys.ENTER);
		sp.getSearchTextField().sendKeys("Testng",Keys.ENTER);
		sp.getSearchTextField().sendKeys("mobiles");
		
	}

}
