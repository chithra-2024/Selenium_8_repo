package giftcards;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListernerUtility;
import objectrepository.HomePage;

@Listeners(ListernerUtility.class)
public class TC_DWS_004_Test extends BaseClass{

	@Test
	public void clickOnGiftCards() throws EncryptedDocumentException, IOException {		
		hp = new HomePage(driver);
		hp.getGiftCardsLink().click();
		Assert.assertEquals(driver.getTitle(), eLib.getStringDataFromExcel("Giftcards", 1, 0),"Gift Cards page is not displayed");
		test.log(Status.PASS, "Gift Cards page is displayed");
	}
}
