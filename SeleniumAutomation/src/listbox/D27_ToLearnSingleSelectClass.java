package listbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D27_ToLearnSingleSelectClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://www.facebook.com/reg/");
		WebElement monthDropDown = driver.findElement(By.id("month"));
		Select monthSelect = new Select(monthDropDown);
		monthSelect.selectByIndex(0);
		//monthSelect.selectByValue("1");
		//monthSelect.selectByVisibleText("Jan");
		
		WebElement yearOption = driver.findElement(By.id("year"));
		
		Select yearSelect =new Select(yearOption);
		yearSelect.selectByIndex(1);
		
		System.out.println(yearSelect.isMultiple());
		
	}

}
