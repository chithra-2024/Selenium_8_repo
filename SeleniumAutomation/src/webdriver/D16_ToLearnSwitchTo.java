package webdriver;


import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D16_ToLearnSwitchTo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shoppersstack.com/products_page/15");
		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[@name='compare']")).click();
		String parentId = driver.getWindowHandle();
		switchToWindow(driver,"flipkart");
		/*
		for(String id: allWindowIds) {			
			driver.switchTo().window(id);
			Thread.sleep(3000);
			String url =driver.getCurrentUrl();
			System.out.println(url);
			Point p = driver.manage().window().getPosition();
			System.out.println(p.getX() + "Y"+p.getY());
			/*
			//if(url.equals("https://www.flipkart.com/"))
			if(url.contains("ebay"))
			{
				Dimension d = driver.manage().window().getSize();
				System.out.println("height: "+d.getHeight() + " width : "+d.getWidth());
				driver.manage().window().setPosition(new Point(10,250));
				//driver.manage().window().maximize();
				
			} else if(url.contains("flipkart")) {
				//driver.manage().window().setPosition(new Point(800,250));
				break;
			}
		}
		*/
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.switchTo().window(parentId);
		driver.findElement(By.id("men")).click();
	}

	
	public static void switchToWindow(WebDriver driver, String partOfUrl) 
	{
		// String parentId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id: allWindowIds) {			
			if(driver.getCurrentUrl().contains(partOfUrl)) {
				driver.switchTo().window(id);
				break;
			}
			/*
			if(!(id == parentId))
			{
				driver.close();
			} */
		}
		
		
	}
}
