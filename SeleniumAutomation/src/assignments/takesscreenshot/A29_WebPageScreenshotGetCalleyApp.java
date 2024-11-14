package assignments.takesscreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class A29_WebPageScreenshotGetCalleyApp {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		Thread.sleep(3000);
		
		String[] urls = {"https://www.getcalley.com/","https://www.getcalley.com/calley-lifetime-offer/","https://www.getcalley.com/see-a-demo/"};
				
		for(int i=0;i<urls.length;i++)	{	
			driver.findElement(By.linkText(urls[i])).click();
			captureScreenshot(driver);
		}
		
		driver.close();
	}

public static void captureScreenshot(WebDriver driver) throws InterruptedException, IOException {
	
	Thread.sleep(3000);
	driver.manage().window().setSize(new Dimension(1366, 768));

	TakesScreenshot ts = (TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);

	File dest = new File("./screenshots/" + LocalDateTime.now().toString().replace(":", "-") + ".png");
	FileHandler.copy(temp, dest);		

	driver.navigate().back();			
	Thread.sleep(3000);
	}
}
