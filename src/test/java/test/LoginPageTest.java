package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import distributor.loginpage.LoginPage;
import testbase.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, prop.getProperty("entity_page_title"));
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closewindows() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
