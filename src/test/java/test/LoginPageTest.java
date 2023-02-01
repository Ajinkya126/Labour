package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.LoginPage;
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
		loginpage = new LoginPage();
	}
	
	@Ignore
	@Test (priority=1)
	public void validateLoginWithValidCre() throws InterruptedException {
	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	String title = driver.getTitle();
	Assert.assertEquals(title, "MY DASHBOARD");
	Thread.sleep(4000);
	}
	
	@Ignore
	@Test (priority=2)
	public void validateLoginWithInvPass() throws InterruptedException {
	loginpage.login(prop.getProperty("username"), "xyz123");
	boolean value = driver.findElement(By.xpath("//li[text()='Please enter valid username or password.']")).isDisplayed();
	Assert.assertEquals(value, true);
	Thread.sleep(2000);
    }
	
	@Ignore
	@Test (priority=3)
	public void validateLoginWithInvUn() throws InterruptedException {
	loginpage.login("invalidun", prop.getProperty("password"));
	boolean value = driver.findElement(By.xpath("//li[text()='Please enter valid username or password.']")).isDisplayed();
	Assert.assertEquals(value, true);
	Thread.sleep(2000);
    }
	
	@Ignore
	@Test (priority=4)
	public void validateLoginWithInvUNandPWD() throws InterruptedException {
	loginpage.login("invalidun", "invalidpwd");
	boolean value = driver.findElement(By.xpath("//li[text()='Please enter valid username or password.']")).isDisplayed();
	Assert.assertEquals(value, true);
	Thread.sleep(2000);
    }
	

	@Test (priority=9)
	public void validateLoginHelp() {
		loginpage.loginHelp();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login Help");
	}
	
	
	@AfterMethod
	public void closeResources() {
		driver.close();
	}


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
