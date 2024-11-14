package assignments.listbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A33_SelectMonth_FaceBook_Reg {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.facebook.com/reg/");
		WebElement monthlistbox = driver.findElement(By.id("month"));
		Select selectedMonth =new Select(monthlistbox);
		
		//select the options one by one in month dropdown
		List<WebElement> allMonthsOptions = selectedMonth.getOptions();
		
		for(WebElement ele:allMonthsOptions) {
			selectedMonth.selectByVisibleText(ele.getText());
		}
		
		//using for loop
		//for(int i=0;i<allMonthsOptions.size();i++) {
		//	selectedMonth.selectByIndex(i);
		//}
		
		//select last option in year dropdown
		WebElement yearlistbox = driver.findElement(By.id("year"));
		Select selectedYear = new Select(yearlistbox);
		List<WebElement> allYearOptions = selectedYear.getOptions();		
		selectedYear.selectByIndex(allYearOptions.size()-1);
		
		//check element is selected or not
		System.out.println(selectedMonth.getFirstSelectedOption().isSelected());
		System.out.println(selectedYear.getFirstSelectedOption().isSelected());
	}

}
