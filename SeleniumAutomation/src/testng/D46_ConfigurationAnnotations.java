package testng;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D46_ConfigurationAnnotations {
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("@BeforeSuite executed",true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("@BeforeTest executed",true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("@BeforeClass executed",true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("@BeforeMethod executed",true);
	}
	
	@Test
	public void demo() {
		Reporter.log("@Test(demo) executed",true);
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("@AfterMethod executed",true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("@AfterClass executed",true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("@AfterTest executed",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("@AfterSuite executed", true);
	}

}
