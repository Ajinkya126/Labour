package test;

import javax.swing.text.Utilities;

import org.openqa.selenium.Alert;
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

import testbase.TestBase;
import util.Utility;

public class LoginPageTest extends TestBase {
	
  LoginPage loginpage;
  
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test (priority=1)
	public void validateLoginWithValidCre() throws InterruptedException {
	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	String title = driver.getTitle();
	Assert.assertEquals(title, "MY DASHBOARD");
	}
	
	@Test (priority=2)
	public void validateLoginWithInvPass() throws InterruptedException {
	loginpage.login(prop.getProperty("username"), "xyz123");
	boolean value = driver.findElement(By.xpath("//li[text()='Please enter valid username or password.']")).isDisplayed();
	Assert.assertEquals(value, true);
    }
	
	@Test (priority=3)
	public void validateLoginWithInvUn() throws InterruptedException {
	loginpage.login("invalidun", prop.getProperty("password"));
	boolean value = driver.findElement(By.xpath("//li[text()='Please enter valid username or password.']")).isDisplayed();
	Assert.assertEquals(value, true);
    }
	
	@Test (priority=4)
	public void validateLoginWithInvUNandPWD() throws InterruptedException {
	loginpage.login("invalidun", "invalidpwd");
	boolean value = driver.findElement(By.xpath("//li[text()='Please enter valid username or password.']")).isDisplayed();
	Assert.assertEquals(value, true);
    }
	
	@Test (priority=5)
	public void validateForgotPwd()throws InterruptedException {
		loginpage.forgotPwd(prop.getProperty("performer_mail"));
		boolean value = driver.findElement(By.xpath("//li[contains(text(),'Temporary password sent on your registered email. ')]")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
	@Test (priority=6)
	public void validateAccountLockedBtn() throws InterruptedException {
		loginpage.accountLocked(prop.getProperty("performer_mail"));
		Thread.sleep(2000);
		String alt = driver.switchTo().alert().getText();
		System.out.println(alt);
		Assert.assertEquals(alt,"Your Account is Active !!!! Please Login with your login credentials.");
		driver.switchTo().alert().accept();
		}
	
	@Test(priority=7) // Validation not possible
	public void validateLoginByGmail() {
		loginpage.gmailLogin();
	}
	
	@Test (priority=9)
	public void validateLoginHelp() {
		loginpage.loginHelp();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login Help");
	}
	
	
	
	
	@AfterMethod
	public void closeResources() {
	//	driver.close();
	}

}
