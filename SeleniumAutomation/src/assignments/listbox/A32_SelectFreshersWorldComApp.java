package assignments.listbox;

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
import org.openqa.selenium.support.ui.Select;

public class A32_SelectFreshersWorldComApp {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//1. open freshersworld.com
		driver.get("https://www.freshersworld.com/");
		
		//2. click on Register Now link
		driver.findElement(By.id("reg_new_btn")).click();
		
		//3. select Bangalore in current city dropdown
		WebElement currentCityDropDown = driver.findElement(By.id("currentCity"));
		Select currentCity =  new Select(currentCityDropDown);
		currentCity.selectByVisibleText("Bangalore");
		
		//4.select BE/Btech in highest qualification dropdown
		WebElement highestQualDropDown = driver.findElement(By.id("course"));
		Select highestQual =new Select(highestQualDropDown);
		highestQual.selectByVisibleText("BE/B.Tech");
		
		//5. take screenshot of web page
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenshots/"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileHandler.copy(temp, dest);

	}

}
