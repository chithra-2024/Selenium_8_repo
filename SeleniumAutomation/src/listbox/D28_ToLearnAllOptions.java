package listbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D28_ToLearnAllOptions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.facebook.com/reg/");
		WebElement monthlistbox = driver.findElement(By.id("month"));
		Select selectedMonth = new Select(monthlistbox);
		
		List<WebElement> allOptions = selectedMonth.getOptions();
		System.out.println(allOptions.size());
		for(WebElement ele: allOptions) {
			System.out.println(ele.getText());
		}
		
		System.out.println(selectedMonth.isMultiple());
	}

}
