package listbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D28_ToLearnFirstSelectedOption {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://demoapp.skillrary.com/");
		
		WebElement priceListbox = driver.findElement(By.id("cars"));
		Select priceSelect = new Select(priceListbox);
		priceSelect.selectByIndex(2);
		priceSelect.selectByIndex(1);
		priceSelect.selectByIndex(0);
		
		WebElement firstSelectedOption = priceSelect.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
		
		List<WebElement> allSelectedOptions = priceSelect.getAllSelectedOptions();
		
		for(WebElement ele: allSelectedOptions) {
			System.out.println(ele.getText());
		}
	}

}
