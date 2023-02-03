package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void init() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//homepage = new HomePage();
		Thread.sleep(3000);
	}
	
	@Test (priority = 3)
	public void validateLogoutTest() {
		homepage.clickOnlogout();
		Assert.assertEquals(driver.getTitle(), prop.getProperty("logoutTestTitle"));
	}
	
	@Test(priority = 1)
	public void validateUserBtn() throws InterruptedException {
		homepage.click_on_user();
		Assert.assertEquals(driver.getTitle(), prop.getProperty("userBtnTestTitle"));
		Thread.sleep(3000);
	}
	
	
	@Test(priority = 2)  //tc_LP = 24
	public void validateCorporateBtn() throws InterruptedException {
		homepage.click_on_corporate_btn();
		boolean value = driver.findElement(By.id("ContentPlaceHolder1_lnkTabCustomer")).isDisplayed();
		Assert.assertEquals(value, true);
		Thread.sleep(2000);
	}
	
	
	@AfterMethod
	public void closeResources() {
	//	homepage.clickOnlogout();
		driver.close();
	}
	

}
