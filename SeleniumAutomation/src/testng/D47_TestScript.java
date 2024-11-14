package testng;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class D47_TestScript extends D47_BaseClass{

	@Test
	public void clickOnBooks() {
		driver.findElement(By.partialLinkText("BOOKS")).click();
		
		if(driver.getTitle().equals(workbook.getSheet("demowebshop").getRow(1).getCell(0).getStringCellValue())) {
			Reporter.log("Books page is displayed",true);
		} else {
			Reporter.log("Books page is not displayed",true);
		}
	}
}
