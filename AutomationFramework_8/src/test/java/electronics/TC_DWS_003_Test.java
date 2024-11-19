package electronics;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListernerUtility;
import objectrepository.HomePage;

@Listeners(ListernerUtility.class)
public class TC_DWS_003_Test extends BaseClass{
	
	@Test
	public void clickOnElectronics() throws EncryptedDocumentException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));		
		hp = new HomePage(driver);
		hp.getElectronicsLink().click();
		Assert.assertEquals(driver.getTitle(), eLib.getStringDataFromExcel("Electronics", 1, 0),"Electronics page is not displayed");
		test.log(Status.PASS, "Electronics page is displayed");
	}

}
