package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D43_WelcomePage {

	//declaration
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	//initialization
	public D43_WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//getters
	public WebElement getLoginLink() {
		return loginLink;
	}
	
	
}
