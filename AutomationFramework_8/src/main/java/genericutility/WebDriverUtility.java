package genericutility;

import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Chithra
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method performs mouse over action on web element
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method performs right click action on web element
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}	
	
	/**
	 * This method is used to switch to a particular window
	 * @param driver
	 * @param windowTitle
	 */
	public void switchToWindow(WebDriver driver,String url) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId: allWindowIds) {
			driver.switchTo().window(windowId);
			if(driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch to a particular iFrame based on iFrame Web Element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method is used to switch to a particular iFrame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch to a particular iFrame based on Name or Id
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method is used to switch to a alert
	 * @param driver
	 */
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	/**
	 * This method is used to switch to a alert and accept
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver) {
		 driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to switch to a alert and dismiss
	 * @param driver
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {
		 driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to switch to a alert and send data
	 * @param driver
	 */
	public void switchToAlertAndSendKeys(WebDriver driver,String data) {
		 driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method is used to perform click operation
	 * @param driver
	 * @param element
	 */
	public void jsClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * This method is used to perform scroll operation	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void jsScroll(WebDriver driver,int x,int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	/**
	 * This method is used to select the dropdown by index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method is used to select the dropdown by option value
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method is used to select the dropdown by visible text
	 * @param element
	 * @param visibleText
	 */
	public void selectDropDownByVisibleText(WebElement element,String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method is used to scroll the window by X and Y coordinates
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollByAmount(WebDriver driver,int x,int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y);
	}
	
	/**
	 * This method is used to scroll to WebElement until the WebElement is visible in view port area
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element);
	}

}
