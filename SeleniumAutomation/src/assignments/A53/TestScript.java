package assignments.A53;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestScript extends BaseClass{
	
	@Test
	public void clickOnSalesLink()
	{
		driver.findElement(By.xpath("//span[text()='Sales']")).click();
		assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Sales')]")).isDisplayed(),"Sales Report history text is not displayed");
		Reporter.log("Sales Report history text is displayed",true);
	}

}
