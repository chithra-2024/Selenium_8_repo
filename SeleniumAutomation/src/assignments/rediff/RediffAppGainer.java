package assignments.rediff;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class RediffAppGainer {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));		
		driver.get("https://money.rediff.com/gainers");		
		List<WebElement> allRows = driver.findElements(By.xpath("(//table[@class='dataTable']/..//tr)"));		
		List<WebElement> headers = driver.findElements(By.xpath("//table[@class='dataTable']/..//tr//th"));			
		if(headers.size() == 6)
			System.out.printf("%-30s %-15s %-8s %-8s %-8s %-8s\n",headers.get(0).getText(),headers.get(1).getText(),headers.get(2).getText(),headers.get(3).getText(),headers.get(4).getText(),headers.get(5).getText());			
		
		for(WebElement row:allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if(cells.size() == 6)
				System.out.printf("%-30s %-15s %-8s %-8s %-8s %-8s\n",cells.get(0).getText(),cells.get(1).getText(),cells.get(2).getText(),cells.get(3).getText(),cells.get(4).getText(),cells.get(5).getText());						
		}
	}
}