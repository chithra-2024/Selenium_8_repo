package assignments.utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchToWindowUtility {

	public static void switchToWindow(WebDriver driver, String partOfUrl) 
	{		
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id: allWindowIds) {	
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(partOfUrl)) {				
				break;
			}			
		}		
		
	}
}
