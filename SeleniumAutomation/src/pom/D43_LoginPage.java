package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D43_LoginPage {

	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginButton;
	
	public D43_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
}
