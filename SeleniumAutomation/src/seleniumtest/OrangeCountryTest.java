package seleniumtest;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeCountryTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.orangehrm.com/en/book-a-free-demo");
		WebElement countryDropDown = driver.findElement(By.name("Country"));
		Select countrySelect = new Select(countryDropDown);
		
		List<WebElement> countryList = countrySelect.getOptions();
		TreeSet<String> orderedSet = new TreeSet<String>();
		
		for(WebElement country:countryList) {
			orderedSet.add(country.getText());
		}
		
		System.out.println(orderedSet);
		Map<String,Integer> countryCountMap = new TreeMap<String, Integer>();
		char key ='A';
		int count=0;
		
		//Afghanistan, Albania, Algeria, American Samoa, Andorra, Angola, Anguilla, Antigua and Barbuda, Argentina, Armenia, Aruba, Australia, Austria, Azerbaijan
		//East Timor, Ecuador, Egypt, El Salvador, Equatorial Guinea, Eritrea, Estonia, Ethiopia
		
		for(String countryName: orderedSet) {
			if(countryName.startsWith(""+key)) {
				count ++;				
			} else {
				countryCountMap.put(""+key, count);
				count = 1;
				key++;
			}
		}
		countryCountMap.put(""+key, count+1);
		System.out.println(countryCountMap);
	}

}
