package assignments.webdriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A6_ToLearnNavigateAmazonApp {

		public static void main(String[] args) throws InterruptedException, MalformedURLException {
			//1. open amazon app in maximized mode without using get()
			//2. verify welcome page is displayed
			//3. perform back and forth operation
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();			
			
			driver.navigate().to(new URL("https://www.amazon.in"));
			if(driver.getCurrentUrl().equals("https://www.amazon.in")) {
				System.out.println("user navigated to Welcome page");
			} else {
				System.out.println("User failed to navigate to Welcome page");
			}
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().forward();
			Thread.sleep(2000);
			driver.navigate().refresh();

		}

	}