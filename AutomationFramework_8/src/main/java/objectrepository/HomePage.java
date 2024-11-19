package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Log out")
	private WebElement logOut;
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement booksLink;
	
	@FindBy(partialLinkText = "COMPUTERS")
	private WebElement computersLink;
	
	@FindBy(partialLinkText = "ELECTRONICS")
	private WebElement electronicsLink;
	
	@FindBy(partialLinkText = "GIFT CARDS")
	private WebElement giftCardsLink;	
	

	public WebElement getBooksLink() {
		return booksLink;
	}	
	
	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}
	public WebElement getGiftCardsLink() {
		return giftCardsLink;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogOut() {
		return logOut;
	}
	
}
