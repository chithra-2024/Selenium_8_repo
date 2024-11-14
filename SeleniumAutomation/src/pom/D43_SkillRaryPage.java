package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D43_SkillRaryPage {
	
	@FindBy(id="navbar-search-input")
	private WebElement searchTextField;
	
	public D43_SkillRaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
	
}
