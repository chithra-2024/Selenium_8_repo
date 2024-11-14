package assignments.actions;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A36_MouseOverMyntraApp {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		driver.get("https://www.myntra.com");
		WebElement kidsLink = driver.findElement(By.linkText("KIDS"));
		
		Actions action = new Actions(driver);
		action.moveToElement(kidsLink).perform();
		
		WebElement ethincWearLink = driver.findElement(By.linkText("Ethnic Wear"));
		ethincWearLink.click();
		if(driver.getTitle().equals("Ki Etnhc - Buy Ki Etnhc online in India")) {
			System.out.println("user navigated to Kids ethinic wear page");
		} else {
			System.out.println("user failed to navigate");
		}
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileHandler.copy(temp, dest);
	}

}
